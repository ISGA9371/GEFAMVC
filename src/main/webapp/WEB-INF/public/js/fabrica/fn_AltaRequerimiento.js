//Funcion inicial
//Variables globales

function init(){

    initGlobal();
    asignarCombos();
    desHabilitarDep();
    calendar();
    addButtonEvents();
    assigMiss();

}

function assigMiss(){

    //Estado Activo
    $("#hidden-estado").val("28");
    //Facturado NO
    $("#hidden-facturado").val("0");


}

function calendar(){

    mdc_text_fecPropInic = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_fecPropInic'));
    mdc_text_fecha_hasta = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_fecha_hasta'));
    // $('#fecPropInic').datepicker({dateFormat: "dd/mm/yy"});
    // $('#fecPropFin').datepicker({dateFormat: "dd/mm/yy"});
    //
    // $("#fecPropInic").change(function () {
    //     if ("" != fecPropInic.value) {
    //         $("#mdc-group-fecPropInic > label").addClass("mdc-text-field__label--float-above");
    //     } else {
    //         $("#mdc-group-fecPropInic > label").removeClass("mdc-text-field__label--float-above");
    //     }
    // });
    //
    // $("#fecPropFin").change(function () {
    //     if ("" != fecPropFin.value) {
    //         $("#mdc-group-fecPropFin > label").addClass("mdc-text-field__label--float-above");
    //     } else {
    //         $("#mdc-group-fecPropFin > label").removeClass("mdc-text-field__label--float-above");
    //     }
    // });

    $("#fecPropInic").datepicker({
        dateFormat: "dd/mm/yy"
    }).on("change", function () {
        $("#fecPropFin").datepicker("option", "minDate", getDate(this));

        if ("" != mdc_text_fecPropInic.value) {
            $("#mdc_text_fecPropInic > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#mdc_text_fecPropInic > label").removeClass("mdc-text-field__label--float-above");
        }
    });


    $("#fecPropFin").datepicker({
        dateFormat: "dd/mm/yy"
    }).on("change", function () {
        $("#fecPropInic").datepicker("option", "maxDate", getDate(this));

        if ("" != mdc_text_fecha_hasta.value) {
            $("#mdc_text_fecha_hasta > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#mdc_text_fecha_hasta > label").removeClass("mdc-text-field__label--float-above");
        }
    });

}

function getDate(element) {
    var date;
    try {
        date = $.datepicker.parseDate("dd/mm/yy", element.value);
    } catch (error) {
        date = null;
    }
    return date;
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

    //cmb direction
    const directions = new mdc.select.MDCSelect(document.querySelector('#dirs'));
    $.ajax({
        url: "/api/levels"
    }).done(function(data) {

        let subs = data.data;

        $("#dir-dir-text").html("");
        directions.selectedIndex = -1;
        directions.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#dir-select").html("");
            $.each(subs, function( index, value ) {

                if(value.levelType.levelTypeId==1){
                    $("#dir-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +
                        "id='"+value.levelId+"' value='"+value.levelId+"'>"+value.levelName+"</li>");
                }

            });
        }else $("#dir-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");

    });

    //cmb area
    const areas = new mdc.select.MDCSelect(document.querySelector('#area-js-select'));

    $.ajax({
        url: "/api/areas"
    }).done(function(data) {

        let subs = data.data;

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

    //cmb technology
    const tecno = new mdc.select.MDCSelect(document.querySelector('#tecnologia-js-select'));

    $.ajax({
        url: "/api/technologies"
    }).done(function(data) {

        let subs = data.data;

        $("#tecno-tecno-text").html("");
        tecno.selectedIndex = -1;
        tecno.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#tecno-select").html("");
            $.each(subs, function( index, value ) {

                $("#tecno-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.technologyId+"' value='"+value.technologyId+"'>"+value.technologyName+"</li>");


            });
        }else $("#tecno-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");

    });

    //cmb channel
    const canal = new mdc.select.MDCSelect(document.querySelector('#canal-js-select'));

    $.ajax({
        url: "/api/channels"
    }).done(function(data) {

        let subs = data.data;

        $("#channel-channel-text").html("");
        canal.selectedIndex = -1;
        canal.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#channel-select").html("");
            $.each(subs, function( index, value ) {

                $("#channel-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.channelId+"' value='"+value.channelId+"'>"+value.channelName+"</li>");

            });
        }else $("#channel-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");

    });


    //function direction and subdirection
    const select = new mdc.select.MDCSelect(document.querySelector('#dirs'));
    const subdirs = new mdc.select.MDCSelect(document.querySelector('#subdirs'));
    let coso = 0;
    select.listen('MDCSelect:change', () => {
    if (coso!= 0) return; else coso = 1;
    let id = select.selectedOptions[0].value;
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
        let subs = data.data;
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

    var rootSelect = document.getElementById("subdirs");
    var selectObj = new mdc.select.MDCSelect(rootSelect);

    rootSelect.addEventListener('MDCSelect:change', function () {

        $("#subDir").val(selectObj.value.split("|")[1]);
        $("#hidden-subdireccion").val(selectObj.value.split("|")[0]);
        $("#subDir").focus();
        new mdc.textField.MDCTextField(document.getElementById('subDirDiv')).disabled = true;
    });

    //select userinternal
    const users = new mdc.select.MDCSelect(document.querySelector('#responsable-js-select'));
    $.ajax({
        url: "/api/users/"
    }).done(function(data) {
        //let subdirs = JSON.parse(data);
        let subs = data.data;
        //console.log(subs.length);
        $("#subdir-users-text").html("");
        users.selectedIndex = -1;
        users.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#users-select").html("");
            $.each(subs, function( index, value ) {

                //console.log("impresion"+ value.profileType.profileTypeId );
               if(value.profileType.profileTypeId==7){
                   $("#users-select").append(
                       "<li class='mdc-list-item' role='option' tabindex='0' " +
                       "id='"+value.userInternalId+"' value='"+value.userInternalId+"'>"+value.userInternalId+"</li>");
               }


            });
        }else $("#users-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");

    });


    //select userinternalarea
    const areaG = new mdc.select.MDCSelect(document.querySelector('#area-js-select'));
    const userG = new mdc.select.MDCSelect(document.querySelector('#gestor-js-select'));
    const servT = new mdc.select.MDCSelect(document.querySelector('#servicio-js-select'));

    let cosoS = 0;
    areaG.listen('MDCSelect:change', () => {
        if (cosoS!= 0) return; else cosoS = 1;
    let id = areaG.selectedOptions[0].value;
    //SET HIDDEN FIELD VALUE
    $("#hidden-area").val(id);
    //clean subdir
    $("#hidden-gestor").val("");
    //console.log("seleccion "+ id);
    //console.log("hidden"+ $("#hidden-direccion").val());

    new mdc.select.MDCSelect(document.getElementById('gestor-js-select')).disabled = false;

        $.ajax({
            url: "/api/users/"
        }).done(function(data) {
            //let subdirs = JSON.parse(data);
            let subs = data.data;
            //console.log(subs.length);
            $("#subdir-usersG-text").html("");
            userG.selectedIndex = -1;
            userG.value = "";
            if (typeof subs !== 'undefined' && subs.length > 0) {
                $("#usersG-select").html("");
                $.each(subs, function( index, value ) {

                    if(value.profileType.profileTypeId==id){
                        $("#usersG-select").append(
                            "<li class='mdc-list-item' role='option' tabindex='0' " +
                            "id='"+value.userInternalId+"' value='"+value.userInternalId+"'>"+value.userInternalId+"</li>");
                    }

                });
            }else $("#usersG-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
            //Only one
            //cosoS=0;
        });

    new mdc.select.MDCSelect(document.getElementById('servicio-js-select')).disabled = false;

        //Second cmb
        $.ajax({
            url: "/api/service-types"
        }).done(function(data) {
            //let subdirs = JSON.parse(data);
            let subs = data.data;
            //console.log(subs.length);
            $("#ts-ts-text").html("");
            servT.selectedIndex = -1;
            servT.value = "";
            if (typeof subs !== 'undefined' && subs.length > 0) {
                $("#ts-select").html("");
                $.each(subs, function( index, value ) {

                    if(value.area.areaId==id){
                        $("#ts-select").append(
                            "<li class='mdc-list-item' role='option' tabindex='0' " +
                            "id='"+value.serviceTypeId+"' value='"+value.serviceTypeId+"'>"+value.serviceTypeName+"</li>");
                    }

                });
            }else $("#ts-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
            cosoS=0;
        });

    });

    //cmb Company
    const companyCmb = new mdc.select.MDCSelect(document.querySelector('#empresa-js-select'));

    $.ajax({
        url: "/api/companies"
    }).done(function(data) {

        let subs = data.data;

        $("#em-em-text").html("");
        companyCmb.selectedIndex = -1;
        companyCmb.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#em-select").html("");
            $.each(subs, function( index, value ) {

                $("#em-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.companyId+"' value='"+value.companyId+"'>"+value.companyName+"</li>");

            });
        }else $("#em-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");

    });


    //cmb PI
    const piCmb = new mdc.select.MDCSelect(document.querySelector('#pi-js-select'));

    $.ajax({
        url: "/api/programIncrements"
    }).done(function(data) {

        let subs = data.data;

        $("#pi-pi-text").html("");
        piCmb.selectedIndex = -1;
        piCmb.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#pi-select").html("");
            $.each(subs, function( index, value ) {

                $("#pi-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.programIncrementId+"' value='"+value.programIncrementId+"'>"+value.programIncrementName+"</li>");

            });
        }else $("#pi-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");

    });

    //select PI-Project
    const piSel = new mdc.select.MDCSelect(document.querySelector('#pi-js-select'));
    const proyG = new mdc.select.MDCSelect(document.querySelector('#proy-js-select'));
    let cosoP = 0;
    piSel.listen('MDCSelect:change', () => {
        if (cosoP!= 0) return; else cosoP = 1;
    let id = piSel.selectedOptions[0].value;
    //SET HIDDEN FIELD VALUE
    $("#hidden-pi").val(id);
    //clean proy
    $("#hidden-proy").val("");

    new mdc.select.MDCSelect(document.getElementById('proy-js-select')).disabled = false;

    $.ajax({
        url: "/api/projects"
    }).done(function(data) {

        let subs = data.data;

        $("#nP-nP-text").html("");
        proyG.selectedIndex = -1;
        proyG.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#nP-select").html("");
            $.each(subs, function( index, value ) {

                if(value.programIncrement.programIncrementId==id){

                    $("#nP-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +
                        "id='"+value.projectId+"|"+value.methodology.methodologyName+"' value='"+value.projectId+"'>"+value.projectId+"</li>");
                }

            });
        }else $("#nP-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
        cosoP=0;
    });
});


    var rootSL = document.getElementById("proy-js-select");
    var selectOb = new mdc.select.MDCSelect(rootSL);

    rootSL.addEventListener('MDCSelect:change', function () {

        $("#tipProyText").val(selectOb.value.split("|")[1]);
        $("#hidden-proy").val(selectOb.value.split("|")[0]);
        $("#tipProyText").focus();
        new mdc.textField.MDCTextField(document.getElementById('tipProyDiv')).disabled = true;
    });




}

function desHabilitarDep(){

    new mdc.select.MDCSelect(document.getElementById('subdirs')).disabled = true;
    new mdc.select.MDCSelect(document.getElementById('gestor-js-select')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('subDirDiv')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('tipProyDiv')).disabled = true;
    new mdc.select.MDCSelect(document.getElementById('proy-js-select')).disabled = true;
    new mdc.select.MDCSelect(document.getElementById('servicio-js-select')).disabled = true;

}

function asignHours(){

    $("#hoursRequerimentFinal").val($("#hoursRequirement").val());

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

function addButtonEvents() {
    //Actions for save requirements
    $('form').on('submit', function (e) {
        e.preventDefault();
        HoldOn.open({
            theme: "sk-cube",
            content: '',
            message: 'Registrando Requerimiento',
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
        window.location.href = "/requirements/filters";
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
        customHolder("info", "Requerimiento Dado de Alta Exitosamente.","window.location.href = '/requirements/" + $(data).find("#requirementId").val() + "'; holder('Cargando...')");
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
