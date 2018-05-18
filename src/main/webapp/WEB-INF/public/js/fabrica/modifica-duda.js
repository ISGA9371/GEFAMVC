function init() {

    addCalendars();
    addButtonEvents();
    loadSelects2();
    userLog();

    $("#hidden-status").val("11");
    $("#hidden-doubtType").val("13");
    $("#hidden-envcomponente").val($("#hidden-componente").val());

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



/*demoReady(function() {
    var rootEst = document.getElementById('incidencia-js-select');
    var hiddenEst = document.getElementById('hidden-estado');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});*/

function userLog() {
    var user=4;
   /* $.ajax({
        url: "/users/info"
    }).done(function(data) {
        var subs = data.data;
        user=subs.profileType.profileTypeId;
*/
    if(user === 7){
        //alert("entro en dyd");
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("requerimiento-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("tecnologia-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("tipologia-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("peticionario-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcionedit-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-textfabrica")).disabled = true;

        $('#boton-cerrar').show();
        $('#Duda-js-select').hide(); //combo origen
        $('#descripcion-js-textfabrica').hide(); //combo descripcion edita fabrica
        $('#prioridad').hide(); //combo prioridad

    }else if(user === 8){
        //alert("fabrica");
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("requerimiento-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("tecnologia-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("tipologia-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("peticionario-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcionedit-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = true;
        $('#boton-cerrar').hide();

        $('#Duda-js-select').hide(); //combo origen

        //prioridad
        $('#prioridad').hide(); //combo prioridad
        //$('#Prioridad-input').val($('#hidden-prioridad').val());
    }else if(user === 1){
        //alert("gestor");
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("requerimiento-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("tecnologia-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("tipologia-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("peticionario-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcionedit-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-textfabrica")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("descripcionedit-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = true;
        $('#boton-cerrar').hide();

        $('#Duda-js-select').hide(); //combo origen

        //prioridad
        $('#prioridad').hide(); //combo prioridad
        $('#descripcion-js-textfabrica').hide(); //describe fabrica
        $('#descripcionedit-js-text').hide(); //describe fabrica
    }else if(user === 5){
        //alert("infikltrado");
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("requerimiento-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("tecnologia-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("tipologia-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("peticionario-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcionedit-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = true;
        $('#boton-cerrar').hide();

        $('#Duda-js-select').hide(); //combo origen
        //$('#Origen-input').val($('#Origen-js-select2').val());

        //prioridad
        $('#prioridad').hide(); //combo prioridad
        //$('#Prioridad-input').val($('#prioridad').val());
    }else if(user === 4){
        //alert("administrador");
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("requerimiento-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("tecnologia-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("tipologia-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("peticionario-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcionedit-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Fecha-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Resoluciones-js-text")).disabled = true;
        $('#boton-cerrar').show();

        $('#Duda-js-select').show(); //combo origen

        //prioridad
        $('#prioridad').show(); //combo prioridad
    }else {
        holder("Cargando...usuario sin acceso");
        window.location.href = "/";
    }
    //});
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
  
    $.ajax({
        async: false,
        url: "/api/prioritys"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.priorityId);
            $liElement.append(data.priorityName);
            $("#prioridad").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('prioridad'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        new mdc.select.MDCSelect(document.getElementById('prioridad')).disabled = true;
        customHolder('error', '¡Error al consultar combos!');
        showingError = true;
        $('#hidden-prioridad').val("");
    });

    $.ajax({
        async: false,
        url: "/api/doubt-types"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.doubtTypeId);
            $liElement.append(data.doubtTypeName);
            $("#Duda-js-select").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('Duda-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        new mdc.select.MDCSelect(document.getElementById('Duda-js-select')).disabled = true;
        customHolder('error', '¡Error al consultar combos!');
        showingError = true;
        $('#hidden-dudaSelect').val("");
    });

    $.ajax({
        async: false,
        url: "/api/status-types/4/status"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.statusId);
            $liElement.append(data.statusName);
            $("#estatus-componente-js-select").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('estatus-componente-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        new mdc.select.MDCSelect(document.getElementById('estatus-componente-js-select')).disabled = true;
        customHolder('error', '¡Error al consultar combos!');
        showingError = true;
        $('#hidden-estado').val("");
    });

    selectByValue(mdcSelectStsComponent,"estatus-componente-js-select",$("#hidden-estado").val());
    selectByValue(mdcSelectDudaTipo,"Duda-js-select",$("#hidden-dudaSelect").val());
    selectByValue(mdcSelectPrioridad,"prioridad",$("#hidden-prioridad").val());
}

function selectByValue(mdcSelect, mdcSelectId,  value){
    $option = $("#"+mdcSelectId).parent().find("li[id='" + value + "']");
    mdcSelect.item($option.parent().find("li").index($option)).click();
    $(mdcSelect.label_).addClass("mdc-select__label--float-above");
}

mdcSelectStsComponent = new mdc.select.MDCSelect($('#estatus-componente-js-select')[0]);
mdcSelectDudaTipo = new mdc.select.MDCSelect($('#Duda-js-select')[0]);
mdcSelectPrioridad = new mdc.select.MDCSelect($('#prioridad')[0]);
