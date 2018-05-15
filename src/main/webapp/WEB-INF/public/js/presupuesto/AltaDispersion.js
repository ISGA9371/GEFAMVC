

function init() {

    initGlobal();
    camp();
    asignarCombos();
    addCalendars();
    //add default values
    //addMissing();
    //addDefaultValues();
    //disableFields();
    formatMoney();
    //addButtonEvents();


}

function agregar() {

    var dataForms = [];
    var counter = 0;
    var transferobjet = new Object();
    data = $( "#trasfer" ).serialize();
    //dataForms[counter++] = data;

    transferobjet.componentDesignRealDeliverDate=data[1];

    dataForms[counter++] = transferobjet;

}

function addCalendars() {

    $('#fechaNeg').datepicker({dateFormat: "dd/mm/yy"});
    $('#fechaReal').datepicker({dateFormat: "dd/mm/yy"});
    $('#fechaEnvio').datepicker({dateFormat: "dd/mm/yy"});
    var fechaNeg = new mdc.textField.MDCTextField(document.querySelector('#mdc-fechaNeg'));

    $("#fechaNeg").change(function () {
        if ("" != fechaNeg.value) {
            $("#mdc-fechaNeg > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#mdc-fechaNeg > label").removeClass("mdc-text-field__label--float-above");
        }
    });
}

function camp() {
    new mdc.textField.MDCTextField(document.getElementById("pepId")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("nombrePep")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("anio")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("area-div")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("banca")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("resDonation")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("solicitante")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Entidad")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("ig")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("cr")).disabled = true;
}

function asignarCombos(){


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