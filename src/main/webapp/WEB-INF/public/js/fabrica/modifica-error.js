function init() {
    //camp();
    addButtonEvents();
    loadSelects();
    loadSelects2();

    $("#hidden-envcomponente").val($("#hidden-componente").val());

    var fecha=$("#datetimepicker").val();
    var dia = fecha.substring(8,10);
    var mes = fecha.substring(5,7);
    var anio = fecha.substring(0,4);
    $("#datetimepickerformat").val(dia+"/"+mes+"/"+anio);

   /* //Asignacion de campos de texto a los hidden
    demoReady(function() {
        var rootName = document.getElementById('incidencia-js-select');
        var inputName = rootName.querySelector('input');
        var hiddenName = document.getElementById('hidden-estado');
        var textName = new mdc.textField.MDCTextField(rootName);

        inputName.addEventListener('keyup', function() {
            hiddenName.value = textName.value;
        });
        inputName.addEventListener('change', function() {
            hiddenName.value = textName.value;
        });
        inputName.addEventListener('blur', function() {
            hiddenName.value = textName.value;
        });
    });
*/


    //$('#incidencia-js-select').val($('#hidden-estado').val());
}

function loadSelects() {
    //mdc.select.MDCSelect.attachTo(document.getElementById('usuario-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('incidencia-js-select'));
}

demoReady(function() {
    var rootEst = document.getElementById('incidencia-js-select');
    var hiddenEst = document.getElementById('hidden-estado');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});

demoReady(function() {
    var rootEst = document.getElementById('Origen-js-select');
    var hiddenEst = document.getElementById('Origen-js-select2');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});

demoReady(function() {
    var rootEst = document.getElementById('prioridad');
    var hiddenEst = document.getElementById('hidden-prioridad');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});

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

function rojeliatama() {
    var textoArea = document.getElementById("desfijo").value;
    var tama = textoArea.length;
    if(tama > 600){
        alert("exedes el tamaño maximo de caracteres ");
    }

}

$(function () {
    $('#datetimepicker4').datetimepicker({
        format: 'DD/MM/YYYY'
    });
});

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

/*function camp() {
    if($("#usuario-h").val() === 1){ //dyd
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Requerimiento")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Tecnologia")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Prioridad")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Origen")).disabled = true;
        //new mdc.textField.MDCTextField(document.getElementById("incidencia-js-select")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Peticionario")).disabled = true;
    }else if($("#usuario-h").val() === 2){ //fabrica
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Requerimiento")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Tecnologia")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Prioridad")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Origen")).disabled = true;
        //new mdc.textField.MDCTextField(document.getElementById("incidencia-js-select")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Peticionario")).disabled = true;
    }else if($("#usuario-h").val() === 3){ //gestor
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Requerimiento")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Tecnologia")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Prioridad")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Origen")).disabled = true;
        //new mdc.textField.MDCTextField(document.getElementById("incidencia-js-select")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Peticionario")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
    }else if($("#usuario-h").val() === 4){ // Administrador
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Requerimiento")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Tecnologia")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Prioridad")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Origen")).disabled = false;
        //new mdc.textField.MDCTextField(document.getElementById("incidencia-js-select")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Peticionario")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = false;
    }else {
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Requerimiento")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Tecnologia")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Prioridad")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Origen")).disabled = true;
        //new mdc.textField.MDCTextField(document.getElementById("incidencia-js-select")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Peticionario")).disabled = true;
    }
}*/

function dyd() {

        alert("entro en dyd");
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Requerimiento")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Tecnologia")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Prioridad-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Origen")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("incidencia-estado-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Peticionario")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-textuser")).disabled = false;
        //document.getElementById("")
        $('#boton-cerrar').show();

        //incidencia
        $('#incidencia-js-select').hide(); //combo incidecnia
        $('#incidencia-estado-js-text').show(); //input incidencia
        $('#incidencia-estado-js-text2').val($('#hidden-estado').val());

        //origen

    $('#Origen-js-select').hide(); //combo origen
    $('#Origen').show(); //input origen
    //$('#Origen-input').val($('#Origen-js-select2').val());

        //prioridad
    $('#prioridad').hide(); //combo prioridad
    $('#Prioridad-text').show(); //input prioridad
    //$('#Prioridad-input').val($('#prioridad-sel-text').val());
}

function fabrica() {

        alert("fabrica");
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Requerimiento")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Tecnologia")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Prioridad-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Origen")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("incidencia-estado-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Peticionario")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-textuser")).disabled = false;
        //new mdc.textField.MDCTextField(document.getElementById("boton-cerrar")).disabled = true;
        $('#boton-cerrar').hide();
    $('#incidencia-js-select').hide(); //combo incidecnia
    $('#incidencia-estado-js-text').show(); //input incidencia
    $('#incidencia-estado-js-text').val($('#hidden-estado').val());

    //origen

    $('#Origen-js-select').hide(); //combo origen
    $('#Origen').show(); //input origen
    //$('#Origen-input').val($('#Origen-js-select2').val());

    //prioridad
    $('#prioridad').hide(); //combo prioridad
    $('#Prioridad-text').show(); //input prioridad
    //$('#Prioridad-input').val($('#hidden-prioridad').val());
}

function gestor() {

        alert("gestor");
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Requerimiento")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Tecnologia")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Prioridad-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Origen")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("incidencia-estado-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Peticionario")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-textuser")).disabled = true;
        //new mdc.textField.MDCTextField(document.getElementById("boton-cerrar")).disabled = true;
        $('#boton-cerrar').hide();
    $('#incidencia-js-select').hide(); //combo incidecnia
    $('#incidencia-estado-js-text').show(); //input incidencia
    //$('#incidencia-estado-js-text').val($('#hidden-estado').val());

    //origen

    $('#Origen-js-select').hide(); //combo origen
    $('#Origen').show(); //input origen
    //$('#Origen-input').val($('#Origen-js-select2').val());

    //prioridad
    $('#prioridad').hide(); //combo prioridad
    $('#Prioridad-text').show(); //input prioridad
    //$('#Prioridad-input').val($('#prioridad').val());
}

function adminin() {

        alert("administrador");
        new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Subdireccion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Version-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Requerimiento")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Tecnologia")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Prioridad-text")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("Origen")).disabled = false;
        new mdc.select.MDCSelect(document.getElementById("incidencia-js-select")).disabled = false;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("Peticionario")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("descripcion-js-textuser")).disabled = false;
        //new mdc.textField.MDCTextField(document.getElementById("boton-cerrar")).disabled = true;
        $('#boton-cerrar').show();
    $('#incidencia-js-select').show(); //combo incidecnia
    $('#incidencia-estado-js-text').show(); //input incidencia

    //origen

    $('#Origen-js-select').show(); //combo origen
    $('#Origen').show(); //input origen

    //prioridad
    $('#prioridad').show(); //combo prioridad
    $('#Prioridad-text').show(); //input prioridad
}

function addButtonEvents() {
    //Actions for save requirements
    $('form').on('submit', function (e) {
        e.preventDefault();
        HoldOn.open({
            theme: "sk-cube",
            content: '',
            message: 'Registrando Incidencia',
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
        customHolder("info", "Duda Registrada Exitosamente.","window.location.href =  '/issues/" + $(data).find("#issueId").val() + "'; holder('Cargando...')");
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

    const origen = new mdc.select.MDCSelect(document.querySelector('#Origen-js-select'));
    $.ajax({
        url: "/api/origins"
    }).done(function(data) {
        let subs = data.data;
        $("#Origen-sel-text").html("");
        origen.selectedIndex = -1;
        origen.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#Origen-select").html("");
            $.each(subs, function( index, value ) {
                $("#Origen-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.originId+"' value='"+value.originId+"'>"+value.originName+"</li>");
            });
        }else $("#Origen-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
    });

}