//Funcion inicial
//Variables globales

function init(){

    initGlobal();
    asignarCombos();
    addCalendars();
    //add default values
    addMissing();
    addDefaultValues();
    disableFields();
    formatMoney();
    addButtonEvents();

}

function disableFields(){

    new mdc.textField.MDCTextField(document.getElementById('divAnioPep')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('dirDiv')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('respAreaDiv')).disabled = true;
    new mdc.select.MDCSelect(document.getElementById('subdirs')).disabled = true;

}

function addDefaultValues(){

    //Asign year
    var fecha = new Date();
    var ano = fecha.getFullYear();
    $("#anioPep").val(ano);
    $("#hdYear").val(ano);
    $("#anioPep").focus();


}


function asignarCombos(){

    //Asigna los valores seleccionados a todos los combos
    $(".mdc-select").each(function(index, element){
        var $parentTd = $(element).parent();
        var $hiddenInput = $parentTd.find("input");
        var rootSelect = document.getElementById($(element).attr("id"));
        var selectObj = new mdc.select.MDCSelect(rootSelect);

        rootSelect.addEventListener('MDCSelect:change', function () {
            $hiddenInput.val(selectObj.value);
        });
    });

    //cmb area
    areas = new mdc.select.MDCSelect(document.querySelector('#area-js-select'));

    $.ajax({
        url: "/api/areas"
    }).done(function(data) {

        subs = data.data;

        $("#area-area-text").html("");
        areas.selectedIndex = -1;
        areas.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#area-select").html("");
            $.each(subs, function( index, value ) {

                $("#area-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.areaId+"' value='"+value.areaId+"'>"+value.areaName+"</li>");

            });
        }else $("#area-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");

    });


    //cmb banking
    bnk = new mdc.select.MDCSelect(document.querySelector('#banca-js-select'));

    $.ajax({
        url: "/api/bankings"
    }).done(function(data) {

        subs = data.data;

        $("#bc-bc-text").html("");
        bnk.selectedIndex = -1;
        bnk.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#bc-select").html("");
            $.each(subs, function( index, value ) {

                $("#bc-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.bankingId+"' value='"+value.bankingId+"'>"+value.bankingName+"</li>");

            });
        }else $("#bc-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");

    });

    //cmb corporation
    coorp = new mdc.select.MDCSelect(document.querySelector('#estado-js-select'));

    $.ajax({
        url: "/api/corporations"
    }).done(function(data) {

        subs = data.data;

        $("#en-en-text").html("");
        coorp.selectedIndex = -1;
        coorp.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#en-select").html("");
            $.each(subs, function( index, value ) {

                $("#en-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.corporationId+"' value='"+value.corporationId+"'>"+value.corporationName+"</li>");

            });
        }else $("#en-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");

    });

    //cmb nature
    natu = new mdc.select.MDCSelect(document.querySelector('#ig-js-select'));

    $.ajax({
        url: "/api/natures"
    }).done(function(data) {

        subs = data.data;

        $("#nt-nt-text").html("");
        natu.selectedIndex = -1;
        natu.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#nt-select").html("");
            $.each(subs, function( index, value ) {

                $("#nt-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.natureId+"' value='"+value.natureId+"'>"+value.natureName+"</li>");

            });
        }else $("#nt-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");

    });

    //Asign CR
    select = new mdc.select.MDCSelect(document.querySelector('#ig-js-select'));
    inter = 0;
    select.listen('MDCSelect:change', () => {

        id = select.selectedOptions[0].value;

        if(id==1){

            $("#cr").val("MX11");
            $("#cr").focus();

        }else{

            $("#cr").val("MX23");
            $("#cr").focus();
        }

    });

    //cmb direction
    directions = new mdc.select.MDCSelect(document.querySelector('#dirs'));
    $.ajax({
        url: "/api/levels"
    }).done(function(data) {

        subs = data.data;

        $("#dir-dir-text").html("");
        directions.selectedIndex = -1;
        directions.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#dir-select").html("");
            $.each(subs, function( index, value ) {

                if(value.levelType.levelTypeId==1){
                    $("#dir-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +
                        "id='"+value.levelId+"|"+value.user.userInternalId+"' value='"+value.levelId+"'>"+value.levelName+"</li>");

                }

            });
        }else $("#dir-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");

    });

    //Asign director
    var rootSelect = document.getElementById("dirs");
    var selectObj = new mdc.select.MDCSelect(rootSelect);

    rootSelect.addEventListener('MDCSelect:change', function () {

        $("#dirPep").val(selectObj.value.split("|")[1]);
        $("#hidden-direccion").val(selectObj.value.split("|")[0]);
        $("#dirPep").focus();
        new mdc.textField.MDCTextField(document.getElementById('dirDiv')).disabled = true;
    });


    //function direction and groups
    subdirs = new mdc.select.MDCSelect(document.querySelector('#subdirs'));
    coso = 0;
    directions.listen('MDCSelect:change', () => {
        if (coso!= 0) return; else coso = 1;
    id = directions.selectedOptions[0].value;
    //SET HIDDEN FIELD VALUE
    $("#hidden-direccion").val(id);
    //clean subdir
    $("#hidden-subdireccion").val("");
    //console.log("seleccion "+ id);
    //console.log("hidden"+ $("#hidden-direccion").val());

    new mdc.select.MDCSelect(document.getElementById('subdirs')).disabled = false;

    $.ajax({
        url: "/api/levels/"+id+"/sub-levels"
    }).done(function(data) {
        //let subdirs = JSON.parse(data);
        subs = data.data;
        //console.log(subs.length);
        $("#subdir-sel-text").html("");
        subdirs.selectedIndex = -1;
        subdirs.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#subdir-select").html("");
            $.each(subs, function( index, value ) {
                //console.log( index + ": " + value.user.userInternalId );
                //console.log( index + ": " + value.userInternalId );
                $("#subdir-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.levelId+"|"+value.user.userInternalId+"'>"+value.levelName+"</li>");
            });
        }else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
        coso=0;
    });

    });

    //Asign userInternalArea
    var rootSelect1 = document.getElementById("subdirs");
    var selectObj1 = new mdc.select.MDCSelect(rootSelect1);

    rootSelect1.addEventListener('MDCSelect:change', function () {

        $("#respArea").val(selectObj1.value.split("|")[1]);
        $("#hidden-subdireccion").val(selectObj1.value.split("|")[0]);
        $("#respArea").focus();
        new mdc.textField.MDCTextField(document.getElementById('respAreaDiv')).disabled = true;
    });

    userG = new mdc.select.MDCSelect(document.querySelector('#respDyD-js-select'));
    $.ajax({
        url: "/api/users/"
    }).done(function(data) {
        //let subdirs = JSON.parse(data);
        subs = data.data;
        //console.log(subs.length);
        $("#respDyd-respDyd-text").html("");
        userG.selectedIndex = -1;
        userG.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#respDyd-select").html("");
            $.each(subs, function( index, value ) {

                if(value.profileType.profileTypeId=="7"){
                    $("#respDyd-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +
                        "id='"+value.userInternalId+"' value='"+value.userInternalId+"'>"+value.userInternalId+"</li>");
                }

            });
        }else $("#respDyd-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
        //Only one
        //cosoS=0;
    });

}

function funcionCancelar(){

    //Lleva a la ventana principal
    window.location="../../../..";

}

function addCalendars(){

    //mdc_text_fechaTranspaso = new mdc.textField.MDCTextField(document.querySelector('#fechaTranspaso'));

    $('#componentDesignRealDeliverDate').datepicker({
        dateFormat: "dd/mm/yy"
    });

    $("#componentDesignRealDeliverDate").change(function () {
        if ("" != componentDesignRealDeliverDate.value) {
            $("#mdc-group-componentDesignRealDeliverDate > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#mdc-group-componentDesignRealDeliverDate > label").removeClass("mdc-text-field__label--float-above");
        }
    });
    // $('#fechaTranspaso').datetimepicker({
    //     format: 'DD/MM/YYYY',
    //     widgetPositioning: {
    //         horizontal: 'auto',
    //         vertical: 'top'
    //     }
    // });

}

function addMissing(){

    $('#hdStatus').val(41);
    $('#hdStatusDyd').val(42);

}

function formatMoney(){

    $("#valorPEP").on({
        "focus": function(event) {
            $(event.target).select();
        },
        "keyup": function(event) {
            $(event.target).val(function(index, value) {
                $("#valorEnviar").val(value.replace(/\D/g, "").replace(/([0-9])([0-9]{2})$/, '$1.$2'));
                $("#hdAmount").val(value.replace(/\D/g, "").replace(/([0-9])([0-9]{2})$/, '$1.$2'));
                return value.replace(/\D/g, "").replace(/([0-9])([0-9]{2})$/, '$1.$2').replace(/\B(?=(\d{3})+(?!\d)\.?)/g, ",");
            });
        }
    });

}

function addButtonEvents() {
    //Actions for save requirements
    $('form').on('submit', function (e) {
        e.preventDefault();
        HoldOn.open({
            theme: "sk-cube",
            content: '',
            message: 'Registrando PEP',
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
        window.location.href = "/budgets/filters";
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
        customHolder("info", "PEP Dado de Alta Exitosamente.","window.location.href = '/budgets/" + $(data).find("#transferId").val() + "'; holder('Cargando...')");
        //customHolder("info", "Componente Dado de Alta Exitosamente.","$('html').html(okData);");
    }).fail(function (xhr, status, error) {
        //console.log("fail");
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

function asociarTransfer(valor){

    $("#transferId").val(valor);

}