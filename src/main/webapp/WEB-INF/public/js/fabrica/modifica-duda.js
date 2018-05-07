function init() {

    addCalendars();
    //camp();
    addButtonEvents();
    loadSelects2();

    $("#hidden-status").val("11");
    $("#hidden-doubtType").val("13");
    $("#hidden-envcomponente").val($("#hidden-componente").val());
    //$("#descripcion").val($("#hidden-descri").val());

    var fecha=$("#datetimepicker").val();
    var dia = fecha.substring(8,10);
    var mes = fecha.substring(5,7);
    var anio = fecha.substring(0,4);
    $("#datetimepickerformat").val(dia+"/"+mes+"/"+anio);

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;

    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }
    var today = 'v' + yyyy + mm + dd;
    var desfes  = dd + mm + yyyy;
    $('#doubtVersion').val(today);


}


demoReady(function() {
    var rootEst = document.getElementById('prioridad');
    var hiddenEst = document.getElementById('hidden-prioridad');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});

demoReady(function() {
    var rootEst = document.getElementById('Duda-js-select');
    var hiddenEst = document.getElementById('hidden-dudaSelect');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});

function addCalendars() {
    $('#FecRealCFG').datetimepicker({
        format: 'DD/MM/YYYY',
        widgetPositioning: {
            horizontal: 'auto',
            vertical: 'top'
        }
    });
}

function holder(msg){
    HoldOn.open({
        theme: "sk-cube",
        content: '',
        message: msg,
        // backgroundColor: "#004582",
        backgroundColor: "#0c71ca",
        textColor: "white",
    });
}

function rojelia(){
    var descrip = $('#descripcion2').val();
    var descri = $('#descripcion').val();
    var des = $('#desfijo').val();

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;

    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }
    var today = 'v' + yyyy + mm + dd;

    $('#desfijo').val(descri + " | " + descrip + " - "+ dd+"/"+mm+"/"+yyyy);
}

/*function camp() {
    new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("subdireccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("version-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("requerimiento-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tecnologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tipologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("prioridad-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("peticionario-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tioDuda-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = true;
}*/


function addButtonEvents() {
    //Actions for save requirements
    $('form').on('submit', function (e) {
        e.preventDefault();
        HoldOn.open({
            theme: "sk-cube",
            content: '',
            message: 'Registrando Duda',
            // backgroundColor: "#004582",
            backgroundColor: "#0c71ca",
            textColor: "white"
        });
        setTimeout("ajaxGuardar();", 500)
    });

    //Actions for cancel requirements
    var btnCancel = document.getElementById('cancelar-btn');
    btnCancel.addEventListener("click", function () {
        holder("Cargando...");
        window.location.href = "/components/filters";
    })
}

function ajaxGuardar() {
    var $form = $("form");
    var url = $form.attr("action");
    var formData = $($form).serializeArray();

    $.ajax({
        async: false,
        url: url,
        type: 'post',
        data: formData
    }).done(function (data) {
        customHolder("info", "Duda Registrada Exitosamente.","window.location.href =  '/doubts/" + $(data).find("#doubtId").val() + "'; holder('Cargando...')");
        //customHolder("info", "Componente Dado de Alta Exitosamente.","$('html').html(okData);");
    }).fail(function (xhr, status, error) {
        console.log("fail");
        customHolder("error", xhr.responseJSON.message)
    });
}

function customHolder(type, msg, fctn) {
    var options = null;
    fctn = fctn == undefined ? "" : fctn;
    switch(type){
        case "Error":
        case "ERROR":
        case "error":
            options = msgAssets.error;
            break;
        case "Aviso":
        case "AVISO":
        case "aviso":
            options = msgAssets.warn;
            break;
        default:
            options = msgAssets.info;
    }
    msg = msg == undefined ? options.defaultMsg : msg;
    HoldOn.open({
        theme: "custom",
        // If theme == "custom" , the content option will be available to customize the logo
        content: '<img style="height: 57px; margin-left: -5px;" src="data:image/png;base64,' + options.icon + '" >',
        message: "<br>" + msg +'<br><br><input type="button" value="Aceptar" class="btn btn-default" onclick="HoldOn.close();'+fctn+'">',
        backgroundColor: "#0c71ca",
        textColor: "white"
    });
}


function loadSelects2() {
    const prioridad = new mdc.select.MDCSelect(document.querySelector('#prioridad'));
    $.ajax({
        url: "/api/prioritys"
    }).done(function(data) {
        let subs = data.data;
        $("#prioridad-sel-text").html("");
        prioridad.selectedIndex = -1;
        prioridad.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#prioridad-select").html("");
            $.each(subs, function( index, value ) {
                $("#prioridad-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.priorityId+"' value='"+value.priorityId+"'>"+value.priorityName+"</li>");
            });
        }else $("#prioridad-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
    });

    const DudaType = new mdc.select.MDCSelect(document.querySelector('#Duda-js-select'));
    $.ajax({
        url: "/api/doubt-types"
    }).done(function(data) {
        let subs = data.data;
        $("#Duda-sel-text").html("");
        DudaType.selectedIndex = -1;
        DudaType.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#Duda-select").html("");
            $.each(subs, function( index, value ) {
                $("#Duda-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.doubtTypeId+"' value='"+value.doubtTypeId+"'>"+value.doubtTypeName+"</li>");
            });
        }else $("#Duda-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
    });
}

function dyd() {

    alert("entro en dyd");
    new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("subdireccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("version-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("requerimiento-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tecnologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tipologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("prioridad-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tioDuda-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("peticionario-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("descripcionedit-js-text")).disabled = false;
    new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = false;
    new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = false;
    //document.getElementById("")
    $('#boton-cerrar').show();

    //tioDuda-js-text

    $('#Duda-js-select').hide(); //combo origen
    $('#tioDuda-js-text').show(); //input origen
    //$('#Origen-input').val($('#Origen-js-select2').val());

    //prioridad
    $('#prioridad').hide(); //combo prioridad
    $('#prioridad-js-text').show(); //input prioridad
    //$('#Prioridad-input').val($('#prioridad-sel-text').val());
}

function fabrica() {

    alert("fabrica");
    new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("subdireccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("version-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("requerimiento-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tecnologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tipologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("prioridad-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tioDuda-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("peticionario-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("descripcionedit-js-text")).disabled = false;
    new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = false;
    new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = false;
    //new mdc.textField.MDCTextField(document.getElementById("boton-cerrar")).disabled = true;
    $('#boton-cerrar').hide();
    //tioDuda-js-text

    $('#Duda-js-select').hide(); //combo origen
    $('#tioDuda-js-text').show(); //input origen
    //$('#Origen-input').val($('#Origen-js-select2').val());

    //prioridad
    $('#prioridad').hide(); //combo prioridad
    $('#prioridad-js-text').show(); //input prioridad
    //$('#Prioridad-input').val($('#hidden-prioridad').val());
}

function gestor() {

    alert("gestor");
    new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("subdireccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("version-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("requerimiento-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tecnologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tipologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("prioridad-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tioDuda-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("peticionario-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("descripcionedit-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = false;
    new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = false;
    //new mdc.textField.MDCTextField(document.getElementById("boton-cerrar")).disabled = true;
    $('#boton-cerrar').hide();
    //tioDuda-js-text

    $('#Duda-js-select').hide(); //combo origen
    $('#tioDuda-js-text').show(); //input origen
    //$('#Origen-input').val($('#Origen-js-select2').val());

    //prioridad
    $('#prioridad').hide(); //combo prioridad
    $('#prioridad-js-text').show(); //input prioridad
    //$('#Prioridad-input').val($('#prioridad').val());
}

function adminin() {

    alert("administrador");
    new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("subdireccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("version-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("requerimiento-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tecnologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tipologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("prioridad-js-text")).disabled = false;
    new mdc.textField.MDCTextField(document.getElementById("tioDuda-js-text")).disabled = false;
    new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("peticionario-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("descripcionedit-js-text")).disabled = false;
    new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = false;
    new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = false;
    //new mdc.textField.MDCTextField(document.getElementById("boton-cerrar")).disabled = true;
    $('#boton-cerrar').show();
    //tioDuda-js-text

    $('#Duda-js-select').show(); //combo origen
    $('#tioDuda-js-text').show(); //input origen

    //prioridad
    $('#prioridad').show(); //combo prioridad
    $('#prioridad-js-text').show(); //input prioridad
}