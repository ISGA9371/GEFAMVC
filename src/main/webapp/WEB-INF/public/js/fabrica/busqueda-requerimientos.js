$(function () {

    var datepicker1 = $('#datepicker1');
    datepicker1.datepicker({
        dateFormat: 'dd/mm/yy'
    });

    var datepicker2 = $('#datepicker2');
    datepicker2.datepicker({
        dateFormat: 'dd/mm/yy'
    });

    datepicker1.change(function () {
        console.log("CAMBIO FECHA 1");
        if (datepicker1.val() !== "") {
            datepicker1.parent().find("label").addClass("mdc-text-field__label--float-above");
            $("input[id=requirementStartDate]").val(datepicker1.val());
        } else {
            datepicker1.parent().find("label").removeClass("mdc-text-field__label--float-above");
        }
    });

    datepicker2.change(function () {
        console.log("CAMBIO FECHA 2");
        if (datepicker2.val() !== "") {
            datepicker2.parent().find("label").addClass("mdc-text-field__label--float-above");
            $("input[id=requirementEndDate]").val(datepicker2.val());
        } else {
            datepicker2.parent().find("label").removeClass("mdc-text-field__label--float-above");
        }
    });

    const direc = new mdc.select.MDCSelect(document.querySelector('#dirs'));
    const subdirs = new mdc.select.MDCSelect(document.querySelector('#subdirs'));
    if($("#dirs li[aria-selected]").length > 0) {
        $("#dirs div.mdc-select__label").addClass("mdc-select__label--float-above");

        var principalId = $("#principalId").val();
        var subPrincipalId = $("#subPrincipalId").val();
        console.log("SUBPID "+subPrincipalId);
        $.ajax({
            url: "/api/levels/"+principalId+"/sub-levels"
        }).done(function(data) {
            let subs = data.data;
            $("#subdir-sel-text").html("");
            subdirs.selectedIndex = -1;
            subdirs.value = "";
            if (typeof subs !== 'undefined' && subs.length > 0) {
                $("#subdir-select").html("");
                var subPrincipalEL = $("#subdirs");
                $.each(subs, function( index, value ) {
                    let aria = value.levelId == subPrincipalId ? ' aria-selected' : '';
                    $("#subdir-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +  aria +
                        " value='"+value.levelId+"'>"+value.levelName+"</li>");
                });
                subPrincipalEL.removeClass("mdc-select--disabled");
                mdc.select.MDCSelect.attachTo(document.getElementById('subdirs'));

                if(subPrincipalId !== ''){
                    $("#subdirs div.mdc-select__label").addClass("mdc-select__label--float-above");
                    subdirs.selectedIndex = subPrincipalEL.find("ul li[value="+ subPrincipalId +"]").index();
                    subdirs.value = subPrincipalEL.find("ul li[value="+subPrincipalId+"]").html();
                }
            }else {
                mdc.select.MDCSelect.attachTo(document.getElementById('subdirs'));
                $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
            }
        });
    }else{
        mdc.select.MDCSelect.attachTo(document.getElementById('subdirs'));
    }

    //let coso = parseInt("0");
    direc.listen('MDCSelect:change', () => {
        console.log("DIREC");
      //  if (coso++ === 0) return; else coso = 0;
        let id = direc.selectedOptions[0].value;
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
        var responsibleEL = $("#responsables");
        var responsibleId = $("#userInternalId").val();
        if (typeof resps !== 'undefined' && resps.length > 0) {
            $("#responsables-ul").html("");
            $.each(resps, function( index, value ) {
                if(value.profileType.profileTypeId === 7){
                    let aria = value.userInternalId === responsibleId ? 'aria-selected ' : '';
                    $("#responsables-ul").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " + aria+
                        " id='"+value.userInternalId+"'>"+value.userInternalId+"</li>");
                }
            });
            mdc.select.MDCSelect.attachTo(document.getElementById('responsables'));
            if(responsibleId !== ''){
                $("#responsables div.mdc-select__label").addClass("mdc-select__label--float-above");
                responsables.selectedIndex = responsibleEL.find("ul li[id="+ responsibleId +"]").index();
                responsables.value = responsibleEL.find("ul li[id="+responsibleId+"]").html();
            }
        }else {
            mdc.select.MDCSelect.attachTo(document.getElementById('responsables'));
            $("#responsables-ul").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
        }
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
        var gestorEL = $("#gestores");
        var gestorId = $("#userManagerId").val();
        if (typeof gests !== 'undefined' && gests.length > 0) {
            $("#gestores-ul").html("");
            $.each(gests, function( index, value ) {
                if(value.profileType.profileTypeId === 1 || value.profileType.profileTypeId === 2){
                    let aria = value.userInternalId === gestorId ? 'aria-selected ' : '';
                    $("#gestores-ul").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " + aria+
                        " id='"+value.userInternalId+"'>"+value.userInternalId+"</li>");
                }
            });
            mdc.select.MDCSelect.attachTo(document.getElementById('gestores'));
            if(gestorId !== ''){
                $("#gestores div.mdc-select__label").addClass("mdc-select__label--float-above");
                gestores.selectedIndex = gestorEL.find("ul li[id="+ gestorId +"]").index();
                gestores.value = gestorEL.find("ul li[id="+gestorId+"]").html();
            }
        }else{
            mdc.select.MDCSelect.attachTo(document.getElementById('gestores'));
            $("#gestores-ul").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
        }
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

    if($("#areas li[aria-selected]").length > 0)
        $("#areas div.mdc-select__label").addClass("mdc-select__label--float-above");

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
    if($("#tipos-proy li[aria-selected]").length > 0)
        $("#tipos-proy div.mdc-select__label").addClass("mdc-select__label--float-above");
    let index6 = parseInt("0");
    tiposProy.listen('MDCSelect:change', () => {
        if (index6++ === 0) return; else index6 = 0;
        let id = tiposProy.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("PROYECTTYPEID " +id);
        $("#methodologyId").val(id);
    });

    const techs = new mdc.select.MDCSelect(document.querySelector('#techs'));
    if($("#techs li[aria-selected]").length > 0)
        $("#techs div.mdc-select__label").addClass("mdc-select__label--float-above");
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
    if($("#empresas li[aria-selected]").length > 0)
        $("#empresas div.mdc-select__label").addClass("mdc-select__label--float-above");
    let index8 = parseInt("0");
    empresas.listen('MDCSelect:change', () => {
        if (index8++ === 0) return; else index8 = 0;
        let id = empresas.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("COMPANYID " +id);
        $("#companyId").val(id);
    });

    let index9 = parseInt("0");
    if($("#tipos-serv li[aria-selected]").length > 0)
        $("#tipos-serv div.mdc-select__label").addClass("mdc-select__label--float-above");
    tiposServ.listen('MDCSelect:change', () => {
        if (index9++ === 0) return; else index9 = 0;
        let id = tiposServ.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("TIPOSERVID " +id);
        $("#serviceTypeId").val(id);
    });

    const app = new mdc.select.MDCSelect(document.querySelector('#aplicacion'));
    if($("#aplicacion li[aria-selected]").length > 0)
        $("#aplicacion div.mdc-select__label").addClass("mdc-select__label--float-above");
    let index10 = parseInt("0");
    app.listen('MDCSelect:change', () => {
        if (index10++ === 0) return; else index10 = 0;
        let id = app.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("APPID " +id);
        $("#applicationId").val(id);
    });

    const canal = new mdc.select.MDCSelect(document.querySelector('#canal'));
    if($("#canal li[aria-selected]").length > 0)
        $("#canal div.mdc-select__label").addClass("mdc-select__label--float-above");
    let index11 = parseInt("0");
    canal.listen('MDCSelect:change', () => {
        if (index11++ === 0) return; else index11 = 0;
        let id = canal.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("CANALID " +id);
        $("#channelId").val(id);
    });

    const pi = new mdc.select.MDCSelect(document.querySelector('#pi'));
    if($("#pi li[aria-selected]").length > 0)
        $("#pi div.mdc-select__label").addClass("mdc-select__label--float-above");
    let index12 = parseInt("0");
    pi.listen('MDCSelect:change', () => {
        if (index12++ === 0) return; else index12 = 0;
        let id = pi.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("PIID " +id);
        $("#programIncrementId").val(id);
    });

    //SETDATES
    if($("#requirementStartDate").val()){
        var compD1 = $("#requirementStartDate").val().split('/');
        var startD = new Date(compD1[2],compD1[1]-1,compD1[0]);
        datepicker1.parent().find("label").addClass("mdc-text-field__label--float-above");
        var date1 = startD.getDate() < 10 ? '0'+ startD.getDate() : startD.getDate();
        var menth1 = startD.getDate() < 9 ? '0'+ (startD.getMonth()+1) : (startD.getMonth()+1);
        datepicker1.val(date1+"/"+menth1+"/"+startD.getFullYear());
    }
    if($("#requirementEndDate").val()){
        var compD2 = $("#requirementEndDate").val().split('/');
        var endD = new Date(compD2[2],compD2[1]-1,compD2[0]);
        datepicker2.parent().find("label").addClass("mdc-text-field__label--float-above");
        var date2 = startD.getDate() < 10 ? '0'+ startD.getDate() : startD.getDate();
        var menth2 = startD.getDate() < 9 ? '0'+ (startD.getMonth()+1) : (startD.getMonth()+1);
        datepicker2.val(date2+"/"+menth2+"/"+endD.getFullYear());
    }

    $('#clear-form').click(function() {
        $("#find")[0].reset();
        $("input[type=text]").val("");

        direc.selectedIndex = -1;
        direc.value = "";

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
        $("#subdirs").addClass("mdc-select--disabled");

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

    console.log("REQURIEZISE "+requirementsSize);
    var reSize = parseInt(requirementsSize);
    if(reSize === 0){
        customHolder("info","No se encontraron resultados para tu búsqueda.");
    }
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