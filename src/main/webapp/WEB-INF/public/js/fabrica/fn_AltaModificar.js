function init() {

    initGlobal();
    camposBloqueadosF();
    crearCombos();
    asignarCombos();
    addCalendars();
    addMissing();
    addButtonEvents();
    camp();
    loadSelects2();
    //cargarTipologias();
    userLog();

    var fecha=$("#datetimepicker").val();
    //var dia = fecha.substring(8,10);
    //var mes = fecha.substring(5,7);
    //var anio = fecha.substring(0,4);
    //$("#datetimepickerformat").val(dia+"/"+mes+"/"+anio);

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
    var today =dd + '/' + mm + '/' + yyyy;
    $("#datetimepicker").val(today);

}

function userLog() {
console.log("llego");
    var user=0;
    $.ajax({
        url: "/users/info"
    }).done(function(data) {
        user=data.userInternalId;

    });
}

function crearCombos() {

    //mdc.select.MDCSelect.attachTo(document.getElementById('DifMod-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('prioridad-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('origen-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('moddyd-js-select'));
    //mdc.select.MDCSelect.attachTo(document.getElementById('responsable-js-select'));
}

function asignarCombos (){

    $(".mdc-select").each(function(index, element){
        var $parentTd = $(element).parent();
        var $hiddenInput = $parentTd.find("input");
        var rootSelect = document.getElementById($(element).attr("id"));
        var selectObj = new mdc.select.MDCSelect(rootSelect);

        rootSelect.addEventListener('MDCSelect:change', function () {
            $hiddenInput.val(selectObj.value);
        });
    });
}

function addCalendars() {

    $('#fechaNeg').datepicker({dateFormat: "dd/mm/yy"});
    $('#fechaReal').datepicker({dateFormat: "dd/mm/yy"});
    var fechaNeg = new mdc.textField.MDCTextField(document.querySelector('#mdc-fechaNeg'));
    var fechaReal = new mdc.textField.MDCTextField(document.querySelector('#mdc-fechaReal'));

    $("#fechaNeg").change(function () {
        if ("" != fechaNeg.value) {
            $("#mdc-fechaNeg > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#mdc-fechaNeg > label").removeClass("mdc-text-field__label--float-above");
        }
    });
    $("#fechaReal").change(function () {
        if ("" != fechaReal.value) {
            $("#mdc-fechaReal > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#mdc-fechaReal > label").removeClass("mdc-text-field__label--float-above");
        }
    });


}

function addMissing() {

    $("#hidden-status").val("5");

    $("#hidden-modificationStatus").val("5");

    $("#hidden-comp").val( $("#hidden-envcomponente").val());

    $("#hidden-startTyp").val($("#hidden-startTypology").val());

    $("#hidden-finalTyp").val($("#hidden-finalTypology").val());

    $("#hidden-status").val($("#hidden-modificationStatus").val());

    $("#hidden-userre").val("XMY3080");
    //$("#hidden-userre").val ($("#hidden-userr").val());

    //$("#responsabletxt").val("XMY3080");
    //$("#hidden-responsable").val("XMY3080");



}

function camp() {
    new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("subdireccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("version-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("requerimiento-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tecnologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tipologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("dificultad-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("estado-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tipmodificacion-js-text")).disabled = true;
    //new mdc.textField.MDCTextField(document.getElementById("usuario-js-text")).disabled = true;
    //new mdc.textField.MDCTextField(document.getElementById("difmodificacion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaEnvio-js-text")).disabled = true;
}

function loadSelects2() {
    const prioridad = new mdc.select.MDCSelect(document.querySelector('#prioridad-js-select'));
    $.ajax({
        url: "/api/prioritys"
    }).done(function (data) {
        let subs = data.data;
        $("#prioridad-sel-text").html("");
        prioridad.selectedIndex = -1;
        prioridad.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#prioridad-select").html("");
            $.each(subs, function (index, value) {
                $("#prioridad-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='" + value.priorityId + "' value='" + value.priorityId + "'>" + value.priorityName + "</li>");
            });
        } else $("#prioridad-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
    });

    const origen = new mdc.select.MDCSelect(document.querySelector('#origen-js-select'));
    $.ajax({
        url: "/api/origins"
    }).done(function(data) {
        let subs = data.data;
        $("#origen-sel-text").html("");
        origen.selectedIndex = -1;
        origen.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#origen-select").html("");
            $.each(subs, function( index, value ) {
                $("#origen-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.originId+"' value='"+value.originId+"'>"+value.originName+"</li>");
            });
        }else $("#origen-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
    });

}
function addButtonEvents() {
    //Actions for save requirements
    $('form').on('submit', function (e) {
        e.preventDefault();
        HoldOn.open({
            theme: "sk-cube",
            content: '',
            message: 'Registrando Modificación',
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



function ajaxGuardar() {
    var $form = $("form");
    var url = $form.attr("action");
    var formData = $($form).serializeArray();

    $.ajax({
        cache: false,
        //contentType: false,
        //processData: false,
        url: url,
        type: 'post',
        data: formData
        /*data: data,
        success: function(data){
            alert(data);
        }*/
    }).done(function (data) {
        customHolder("info", "Modificacion Registrada Exitosamente.","window.location.href = '/components/filters'; holder('Cargando...')");
        //customHolder("info", "Componente Dado de Alta Exitosamente.","$('html').html(okData);");
    }).fail(function (xhr, status, error) {
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


function camposBloqueadosF() {
    var aux = $("#dificultad-modificacion").val();
    if (aux === "F"){
    } else {
        new mdc.textField.MDCTextField(document.getElementById("hours-div")).disabled = true;
        new mdc.textField.MDCTextField(document.getElementById("costo-div")).disabled = true;
    }

}

