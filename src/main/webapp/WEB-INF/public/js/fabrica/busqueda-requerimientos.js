$(function () {

    $('#datetimepicker4').datetimepicker({
        format: 'DD/MM/YYYY',
        locale: 'es-mx',
        useCurrent: false
    });

    $('#datetimepicker5').datetimepicker({
        format: 'DD/MM/YYYY',
        locale: 'es-mx',
        useCurrent: false
    });

    $("#datetimepicker4").on("dp.change", function (e) {
        var date = e.date;
        var dateStr = date.date() + "/" + (date.month() + 1) + '/' + date.year();
        $("input[id=requirementStartDate]").val(dateStr);
    });

    $("#datetimepicker5").on("dp.change", function (e) {
        var date = e.date;
        var dateStr = date.date() + "/" + (date.month() + 1) + '/' + date.year();
        $("input[id=requirementEndDate]").val(dateStr);
    });

    const select = new mdc.select.MDCSelect(document.querySelector('#dirs'));
    const subdirs = new mdc.select.MDCSelect(document.querySelector('#subdirs'));
    let coso = parseInt("0");
    select.listen('MDCSelect:change', () => {
        if (coso++ === 0) return; else coso = 0;
        let id = select.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        $("#principalId").val(id);
        console.log("PRINCIPALID" +id);

        $("#subdirs").addClass("mdc-select--disabled");

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
                    //console.log( index + ": " + value.levelId );
                    $("#subdir-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +
                        "value='"+value.levelId+"'>"+value.levelName+"</li>");
                });
                $("#subdirs").removeClass("mdc-select--disabled");
                $("#subdirs div.mdc-select__label").removeClass("mdc-select__label--float-above");
            }else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");

        });
    });
    let index2 = parseInt("0");
    subdirs.listen('MDCSelect:change', () => {
        if (index2++ === 0) return; else index2 = 0;
        let id = subdirs.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("SUBPRINCIPALID " +id);
        $("#subPrincipalId").val(id);
    });

    let index3 = parseInt("0");
    const responsables = new mdc.select.MDCSelect(document.querySelector('#responsables'));
    $.ajax({
        url: "/api/users/"
    }).done(function(data) {
        let resps = data.data;
        responsables.selectedIndex = -1;
        responsables.value = "";
        if (typeof resps !== 'undefined' && resps.length > 0) {
            $("#responsables-ul").html("");
            $.each(resps, function( index, value ) {
                if(value.profileType.profileTypeId === 7){
                    $("#responsables-ul").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +
                        "id='"+value.userInternalId+"'>"+value.userInternalId+"</li>");
                }
            });
        }else $("#responsables-ul").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
    });

    responsables.listen('MDCSelect:change', () => {
        if (index3++ === 0) return; else index3 = 0;
        let id = responsables.selectedOptions[0].id;
        //SET HIDDEN FIELD VALUE
        console.log("RESPONSABLE " +id);
        $("#userInternalId").val(id);
    });

    let index4 = parseInt("0");
    const gestores= new mdc.select.MDCSelect(document.querySelector('#gestores'));
    $.ajax({
        url: "/api/users/"
    }).done(function(data) {
        let gests = data.data;
        gestores.selectedIndex = -1;
        gestores.value = "";
        if (typeof gests !== 'undefined' && gests.length > 0) {
            $("#gestores-ul").html("");
            $.each(gests, function( index, value ) {
                if(value.profileType.profileTypeId === 1 || value.profileType.profileTypeId === 2){
                    $("#gestores-ul").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +
                        "value='"+value.userInternalId+"'>"+value.userInternalId+"</li>");
                }
            });
        }else $("#gestores-ul").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
    });
    gestores.listen('MDCSelect:change', () => {
        if (index4++ === 0) return; else index4 = 0;
        let id = gestores.selectedOptions[0].id;
        //SET HIDDEN FIELD VALUE
        console.log("GESTORID " +id);
        $("#userManagerId").val(id);
    });

    const areas = new mdc.select.MDCSelect(document.querySelector('#areas'));
    const tiposServ = new mdc.select.MDCSelect(document.querySelector('#tipos-serv'));
    let index5 = parseInt("0");
    areas.listen('MDCSelect:change', () => {
        if (index5++ === 0) return; else index5 = 0;
        let id = areas.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("AREAID " +id);
        $("#areaId").val(id);

        /*$("#tipos-serv div.mdc-select__label").removeClass("mdc-select__label--float-above");
        if(id === 1){
            $("#service-type-select").html( $("#service-types-ul").html() );
            $("#tipos-serv").removeClass("mdc-select--disabled");
        }else {
            tiposServ.selectedIndex = -1;
            tiposServ.value = "";
            $("#tipos-serv").addClass("mdc-select--disabled");
            $("#service-type-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
        }*/
        /*
        $.ajax({
            url: "/service-types/area/"+id
        }).done(function(data) {
            //let subdirs = JSON.parse(data);
            let services = data;
            console.log(services.length);
            $("#service-type-sel-text").html("");
            tiposServ.selectedIndex = -1;
            tiposServ.value = "";

            if (typeof services !== 'undefined' && services.length > 0) {
                $("#service-type-select").html("");
                $.each(services, function( index, value ) {
                    console.log( index + ": " + value.serviceTypeName );
                    $("#service-type-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +
                        "value='"+value.serviceTypeId+"'>"+value.serviceTypeName+"</li>");

                });
            }else $("#service-type-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");

        });
        */
    });

    const tiposProy = new mdc.select.MDCSelect(document.querySelector('#tipos-proy'));
    let index6 = parseInt("0");
    tiposProy.listen('MDCSelect:change', () => {
        if (index6++ === 0) return; else index6 = 0;
        let id = tiposProy.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("PROYECTTYPEID " +id);
        $("#projectTypeId").val(id);
    });

    const techs = new mdc.select.MDCSelect(document.querySelector('#techs'));
    let index7 = parseInt("0");
    techs.listen('MDCSelect:change', () => {
        if (index7++ === 0) return; else index7 = 0;
        let id = techs.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        $("#technologyId").val(id);
        console.log("TECHID " +id);
        /*
        $.ajax({
            url: "/technologies/"+id+"/app"
        }).done(function(data) {
            let apps = data;
            console.log(apps.length);
            //tiposServ.selectedIndex = -1; APPS SELECT
            //tiposServ.value = ""; APPS SELECT
            $("#aplicacion-sel-text").html("");
            if (typeof apps !== 'undefined' && apps.length > 0) {
                $("#aplicacion-select").html("");
                $.each(apps, function( index, value ) {
                    console.log( index + ": " + value.applicationName);
                    $("#aplicacion-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +
                        "value='"+value.applicationSerial+"'>"+value.applicationName+"</li>");
                });
            }else $("#service-type-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");

        });
        */
    });

    const empresas = new mdc.select.MDCSelect(document.querySelector('#empresas'));
    let index8 = parseInt("0");
    empresas.listen('MDCSelect:change', () => {
        if (index8++ === 0) return; else index8 = 0;
        let id = empresas.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("COMPANYID " +id);
        $("#companyId").val(id);
    });

    let index9 = parseInt("0");
    tiposServ.listen('MDCSelect:change', () => {
        if (index9++ === 0) return; else index9 = 0;
        let id = tiposServ.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("TIPOSERVID " +id);
        $("#tipos-serv").val(id);
    });

    const app = new mdc.select.MDCSelect(document.querySelector('#aplicacion'));
    let index10 = parseInt("0");
    app.listen('MDCSelect:change', () => {
        if (index10++ === 0) return; else index10 = 0;
        let id = empresas.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("APPID " +id);
        $("#applicationId").val(id);
    });

    const canal = new mdc.select.MDCSelect(document.querySelector('#canal'));
    let index11 = parseInt("0");
    canal.listen('MDCSelect:change', () => {
        if (index11++ === 0) return; else index11 = 0;
        let id = empresas.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("CANALID " +id);
        $("#channelId").val(id);
    });

    const pi = new mdc.select.MDCSelect(document.querySelector('#pi'));
    let index12 = parseInt("0");
    pi.listen('MDCSelect:change', () => {
        if (index12++ === 0) return; else index12 = 0;
        let id = pi.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("PIID " +id);
        $("#programIncrementId").val(id);
    });

    $('#clear-form').click(function() {
        $("#find")[0].reset();
        $("input[type=text]").val("");

        select.selectedIndex = -1;
        select.value = "";
        subdirs.selectedIndex = -1;
        subdirs.value = "";
        responsables.selectedIndex = -1;
        responsables.value = "";
        gestores.selectedIndex = -1;
        gestores.value = "";
        areas.selectedIndex = -1;
        areas.value = "";
        tiposProy.selectedIndex = -1;
        tiposProy.value = "";
        techs.selectedIndex = -1;
        techs.value = "";
        empresas.selectedIndex = -1;
        empresas.value = "";
        tiposServ.selectedIndex = -1;
        tiposServ.value = "";
        app.selectedIndex = -1;
        app.value = "";
        canal.selectedIndex = -1;
        canal.value = "";
        pi.selectedIndex = -1;
        pi.value = "";

        $(".mdc-select__label").removeClass("mdc-select__label--float-above");
        $(".mdc-text-field__label").removeClass("mdc-text-field__label--float-above");

        $("input[type=hidden]").val("");

        editReq.attr("disabled","disabled");

        $("#results-table tbody").html("");
    });


    $('tr.clickable').find('input[type=radio]').click(function (event) {
        //
    });

    var editReq = $("#edit-requirement");
    //var addComp = $("#add-component");

    $('tr.clickable').click(function() {
        var radioButton = $(this).find('input[type=radio]');
        console.log("hola"+ radioButton.length);
        radioButton.prop('checked', true);

        editReq.attr("href","/requirements/"+radioButton.val());
        editReq.removeAttr("disabled");
        let target = $(this).attr("aria-controls");

        $("#"+target).collapse('toggle');
        //addComp.attr("href","/components/add?requirementId="+radioButton.val());
        //addComp.removeAttr("disabled");
    });

    editReq.click(function () {
        if($(this).attr("href")) {
            showHoldOn();
            $("#results-table tbody").html("");
            editReq.attr("disabled","disabled");
        }
    });
    /*
    addComp.click(function () {
        if($(this).attr("href")){
            showHoldOn();
            $("#results-table tbody").html("");
        }
    });*/


    //TODO APLICAICONES

    $("#row-content-results div.collapse").on('show.bs.collapse', function(){
        $(".collapse").collapse('hide');
    });
});

function showHoldOn() {
    HoldOn.open({
        theme: "sk-cube",
        content: '',
        message: 'Procesando...',
        backgroundColor: "#0c71ca",
        textColor: "white",
    });
}