let savedFromAnchor = false;
let anchorUrl = null;
$(function () {

    var $form = $('#form'), origForm = $form.serialize();

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
            datepicker2.datepicker("option", "minDate", getDate(datepicker1.val()));
            $("input[id=requirementStartDate]").val(datepicker1.val());
        } else {
            datepicker1.parent().find("label").removeClass("mdc-text-field__label--float-above");
        }
    });

    datepicker2.change(function () {
        console.log("CAMBIO FECHA 2");
        if (datepicker2.val() !== "") {
            datepicker2.parent().find("label").addClass("mdc-text-field__label--float-above");
            datepicker1.datepicker("option", "maxDate", getDate(datepicker2.val()));
            $("input[id=requirementEndDate]").val(datepicker2.val());
        } else {
            datepicker2.parent().find("label").removeClass("mdc-text-field__label--float-above");
        }
    });

    const principal = new mdc.select.MDCSelect(document.querySelector('#principal'));
    var principalId = $("#level\\.levelSuperior\\.levelId").val();
    console.log("SUPLEVEL ID "+principalId);

    const subPrincipal = new mdc.select.MDCSelect(document.querySelector('#subprincipal'));
    //LOAD SUB LEVELS FROM PRINCIPAL
    $.ajax({
        url: "/api/levels/"+principalId+"/sub-levels"
    }).done(function(data) {
        let subdirs = data.data;
        $("#subdir-sel-text").html("");
        if (typeof subdirs !== 'undefined' && subdirs.length > 0) {
            $("#subdir-select").html("");
            var subPrincipalEL = $("#subprincipal");
            var subPrincipalId = $("#level\\.levelId").val();
            var subdir;
            $.each(subdirs, function( index, value ) {
                subdir = value.user.userInternalId;
                let aria = value.levelId == subPrincipalId ? ' aria-selected' : '';
                $("#subdir-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0'" + aria +" data-subdir='" +
                    value.user.userInternalId+"' value='"+value.levelId+"'>"+value.levelName+"</li>");
            });

            $("#subdir").val(subdir);

            mdc.select.MDCSelect.attachTo(document.getElementById('subprincipal'));
            subPrincipal.selectedIndex = subPrincipalEL.find("ul li[value="+ subPrincipalId +"]").index();
            subPrincipal.value = subPrincipalEL.find("ul li[value="+subPrincipalId+"]").html();

        }else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");

    });

    var idx = parseInt("0");
    subPrincipal.listen('MDCSelect:change', () => {
        if (idx++ === 0) return; else idx = 0;
        let selectedOpt = subPrincipal.selectedOptions[0];
        let id = selectedOpt.value;
        console.log("SELECTEDSUBDIR "+id);
        $("#subdir").val(selectedOpt.dataset.subdir);

        $("#level\\.levelId").val(id);
    });

    //LOADING SUBDIRECCIONES CUANDO DIRECCION CMABIA
    let coso = parseInt("0");
    principal.listen('MDCSelect:change', () => {
        if (coso++ === 0) return; else coso = 0;
        let id = principal.selectedOptions[0].value;
        //LIMPIAR LA SUBDIRECCIÓN!
        $("#level\\.levelId").val("");

        var subPrincipal = new mdc.select.MDCSelect(document.querySelector('#subprincipal'));
        subPrincipal.disabled = true;

        $.ajax({
            url: "/api/levels/"+id+"/sub-levels"
        }).done(function(data) {
            let subdirs = data.data;
            $("#subdir-sel-text").html("");
            subPrincipal.selectedIndex = -1;
            subPrincipal.value = "";

            if (typeof subdirs !== 'undefined' && subdirs.length > 0) {
                $("#subdir-select").html("");
                var subdir;
                $.each(subdirs, function( index, value ) {
                    subdir = value.user.userInternalId;
                    $("#subdir-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' data-subdir='" +
                        value.user.userInternalId+"' value='"+value.levelId+"'>"+value.levelName+"</li>");
                });
            }else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
            subPrincipal.disabled = false;

            $("#subdir").val(subdir);

        });
    });

    const responsible = new mdc.select.MDCSelect(document.querySelector('#responsible'));

    $.ajax({
        url: "/api/users/"
    }).done(function(data) {
        let resps = data.data;
        var responsibleEL = $("#responsible");
        var responsibleId = $("#user\\.userInternalId").val();
        if (typeof resps !== 'undefined' && resps.length > 0) {
            $("#responsables-ul").html("");
            $.each(resps, function( index, value ) {
                if(value.profileType.profileTypeId === 7){
                    let aria = value.userInternalId === responsibleId ? 'aria-selected ' : '';
                    $("#responsibles-ul").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " + aria +
                        "id='"+value.userInternalId+"'>"+value.userInternalId+"</li>");
                }
            });
            console.log("RESPONSIBLE ID "+responsibleId);
            mdc.select.MDCSelect.attachTo(document.getElementById('responsible'));
            responsible.selectedIndex = responsibleEL.find("ul li[id="+ responsibleId +"]").index();
            responsible.value = responsibleEL.find("ul li[id="+responsibleId+"]").html();

        }else $("#responsables-ul").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
    });

    let index = parseInt("0");
    responsible.listen('MDCSelect:change', () => {
        if (index++ === 0) return; else index = 0;
        var id1 = responsible.selectedOptions[0].id;
        console.log("RESPINSIBLEIDSEL "+responsible.selectedOptions.length+" " + id1);
        $("#user\\.userInternalId").val(id1);
    });

    const area = new mdc.select.MDCSelect(document.querySelector('#area'));
    const serviceType = new mdc.select.MDCSelect(document.querySelector('#service-type'));
    var areaId = $("#area\\.areaId").val();
    console.log("Area ID "+areaId);

    //LOAD SERVICES TYPE AT BEGINNING, BY AREA ID
    $.ajax({
        url: "/api/service-types"
    }).done(function(data) {
        let services = data.data;
        $("#service-type-sel-text").html("");

        if (typeof services !== 'undefined' && services.length > 0) {
            $("#service-type-select").html("");
            var serviceTypeEL = $("#service-type");
            var serviceTypeId = $("#serviceType\\.serviceTypeId").val();

            $.each(services, function( index, value ) {
                if(value.area.areaId == areaId) {
                    let aria = value.serviceTypeId == serviceTypeId ? ' aria-selected ' : '';
                    $("#service-type-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " + aria +
                        "value='" + value.serviceTypeId + "'>" + value.serviceTypeName + "</li>");
                }
            });

            mdc.select.MDCSelect.attachTo(document.getElementById('service-type'));
            serviceType.selectedIndex = serviceTypeEL.find("ul li[value="+ serviceTypeId +"]").index();
            serviceType.value = serviceTypeEL.find("ul li[value="+serviceTypeId+"]").html();

        }else $("#service-type-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
    });

    let index9 = 0;
    var serviceTypeId = $("#serviceType\\.serviceTypeId").val();
    console.log("serviceType ID "+serviceTypeId);
    serviceType.listen('MDCSelect:change', () => {
        if (index9++ === 0) return; else index9 = 0;
        let id = serviceType.selectedOptions[0].value;
        $("#serviceType\\.serviceTypeId").val(id);
        console.log("SELECTEserviceType ID "+id);
    });

    let index2 = parseInt("0");
    area.listen('MDCSelect:change', () => {
        if (index2++ === 0) return; else index2 = 0;

        //LIMPIAR EL TIPO DE SERVICIO!
        $("#level\\.levelId").val("");

        let id = area.selectedOptions[0].value;
        $("#area\\.areaId").val(id);
        console.log("NUEVAAREAID " +id);

        var serviceType = new mdc.select.MDCSelect(document.querySelector('#service-type'));
        serviceType.disabled = true;

        $("#service-type").find("div").first().click();
        $("#service-type").find("li").first().click();

        setTimeout(function () {
            $.ajax({
                url: "/api/service-types"
            }).done(function(data) {
                let services = data.data;
                $("#service-type-sel-text").html("");
                serviceType.selectedIndex = -1;
                serviceType.value = "";

                if (typeof services !== 'undefined' && services.length > 0) {
                    $("#service-type-select").html("");
                    $.each(services, function( index, value ) {
                        if(value.area.areaId == id) {
                            $("#service-type-select").append(
                                "<li class='mdc-list-item' role='option' tabindex='0' " +
                                "value='" + value.serviceTypeId + "'>" + value.serviceTypeName + "</li>");
                        }
                    });
                }else $("#service-type-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
                serviceType.disabled = false;
                HoldOn.close();
            });
        }, 50);
    });

    const managers = new mdc.select.MDCSelect(document.querySelector('#manager'));
    $.ajax({
        url: "/api/users/"
    }).done(function(data) {
        let gests = data.data;
        if (typeof gests !== 'undefined' && gests.length > 0) {
            $("#gestores-ul").html("");
            var managerEL = $('#manager');
            var managerId = $("#userManager\\.userInternalId").val();
            console.log("Gestor ID "+managerId);
            var aria;
            $.each(gests, function( index, value ) {
                if(value.profileType.profileTypeId === 1 || value.profileType.profileTypeId === 2){
                    aria = value.userInternalId == managerId ? 'aria-selected ' : '';
                    $("#managers-ul").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " + aria +
                        "id='"+value.userInternalId+"'>"+value.userInternalId+"</li>");
                }
            });

            mdc.select.MDCSelect.attachTo(document.getElementById('manager'));
            managers.selectedIndex = managerEL.find("ul li[id="+ managerId +"]").index();
            managers.value = managerEL.find("ul li[id="+managerId+"]").html();
        }else $("#gestores-ul").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
    });

    let index3 = parseInt("0");
    managers.listen('MDCSelect:change', () => {
        if (index3++ === 0) return; else index3 = 0;
        let id = managers.selectedOptions[0].id;
        console.log("MANAGERID "+managers.selectedOptions.length+" " + id);
        $("#userManager\\.userInternalId").val(id);
    });

    const tech = new mdc.select.MDCSelect(document.querySelector('#tech'));
    var techId = $("#technology\\.technologyId").val();
    console.log("TECH ID "+techId);
    let index4 = parseInt("0");
    tech.listen('MDCSelect:change', () => {
        if (index4++ === 0) return; else index4 = 0;
        let id = tech.selectedOptions[0].value;
        console.log("TECHIDSEl "+tech.selectedOptions.length+" " + id);
        $("#technology\\.technologyId").val(id);
    });
/*
    const meth = new mdc.select.MDCSelect(document.querySelector('#meth'));
    var methId = $("#project\\.methodology\\.methodologyId").val();
    console.log("METH ID "+methId);
    let index5 = parseInt("0");
    meth.listen('MDCSelect:change', () => {
        if (index5++ === 0) return; else index5 = 0;
        let id = meth.selectedOptions[0].value;
        $("#project\\.methodology\\.methodologyId").val(id);
        console.log("METH ID CH"+id);
    });
*/
    const app = new mdc.select.MDCSelect(document.querySelector('#app'));
    var appId = $("#application\\.applicationId").val();
    console.log("app ID "+appId);
    let index6 = parseInt("0");
    app.listen('MDCSelect:change', () => {
        if (index6++ === 0) return; else index6 = 0;
        let id = app.selectedOptions[0].value;
        $("#application\\.applicationId").val(id);
    });

    const channel = new mdc.select.MDCSelect(document.querySelector('#channel'));
    var channelId = $("#channel\\.channelId").val();
    console.log("channel ID "+channelId);
    let index7 = parseInt("0");
    channel.listen('MDCSelect:change', () => {
        if (index7++ === 0) return; else index7 = 0;
        let id = channel.selectedOptions[0].value;
        $("#channel\\.channelId").val(id);
    });

    const company = new mdc.select.MDCSelect(document.querySelector('#company'));
    var companyId = $("#company\\.companyId").val();
    console.log("company ID "+companyId);
    let index8 = parseInt("0");
    company.listen('MDCSelect:change', () => {
        if (index8++ === 0) return; else index8 = 0;
        let id = company.selectedOptions[0].value;
        $("#company\\.companyId").val(id);
    });

    const pi = new mdc.select.MDCSelect(document.querySelector('#pi'));
    var piId = $("#programIncrement\\.programIncrementId").val();
    console.log("pi ID "+piId);
    let index10 = parseInt("0");
    pi.listen('MDCSelect:change', () => {
        if (index10++ === 0) return; else index10 = 0;
        let id = pi.selectedOptions[0].value;
        $("#programIncrement\\.programIncrementId").val(id);
        let carga = 0;

        //LIMPIAR PROYECTO SDATOOL!
        $("#project\\.projectId").val("");

        $("#project").find("div").first().click();
        $("#project").find("li").first().click();

        setTimeout(function () {
            $.ajax({
                url: "/api/projects"
            }).done(function(data) {
                let proys = data.data;

                if (typeof proys !== 'undefined' && proys.length > 0) {
                    project.selectedIndex = -1;
                    project.value = "";
                    $("#ul-proyects").html("");
                    $.each(proys, function( index, value ) {
                        if(value.programIncrement.programIncrementId === id){
                            var coso = "<li class='mdc-list-item' role='option' id='"+value.projectId+"' "+
                                "data-meth='"+value.methodology.methodologyName+"' aria-selected='true'>"+value.projectName+"</li>";
                            $("#ul-proyects").append(coso);
                            carga = 1;
                        }
                    });
                    if(carga === 0) $("#ul-proyects").html("<li class='mdc-list-item' role='option'></li>");
                }else $("#ul-proyects").html("<li class='mdc-list-item' role='option'></li>");
            });
        },50);


    });

    //LOAD SDATOOLs AT BEGINNING, BY PI ID
    const project = new mdc.select.MDCSelect(document.querySelector('#project'));
    var projectId = $("#project\\.projectId").val();
    console.log("project ID "+projectId);

    $.ajax({
        url: "/api/projects"
    }).done(function(data) {
        let projects = data.data;
        $("#proy-selected").html("");

        if (typeof projects !== 'undefined' && projects.length > 0) {
            $("#ul-proyects").html("");
            var projectEL = $("#project");
            var projectId = $("#project\\.projectId").val();

            $.each(projects, function( index, value ) {
                if(value.programIncrement.programIncrementId == piId) {
                    let aria = value.projectId == projectId ? ' aria-selected ' : ' ';
                    $("#ul-proyects").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " + aria +
                        " data-meth='" + value.methodology.methodologyName +"' " +
                        "id='" + value.projectId + "'>" + value.projectId + "</li>");
                }
            });

            mdc.select.MDCSelect.attachTo(document.getElementById('project'));
            project.selectedIndex = projectEL.find("ul li[id="+ projectId +"]").index();
            project.value = projectEL.find("ul li[value="+projectId+"]").html();

        }else $("#service-type-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");

    });

    let index11 = parseInt("0");
    project.listen('MDCSelect:change', () => {
        if (index11++ === 0) return; else index11 = 0;
        let id = project.selectedOptions[0].id;
        $("#project\\.projectId").val(id);
        let meth =project.selectedOptions[0].dataset.meth;
        console.log("PROYECTSEL METH "+meth);
        $("#meth").val(meth);
    });

    const status = new mdc.select.MDCSelect(document.querySelector('#status'));
    var statusId = $("#status\\.statusId").val();
    console.log("status ID "+statusId);
    let index12 = parseInt("0");
    status.listen('MDCSelect:change', () => {
        if (index12++ === 0) return; else index12 = 0;
        let id = status.selectedOptions[0].value;
        $("#status\\.statusId").val(id);
    });

    const billed = new mdc.select.MDCSelect(document.querySelector('#billed'));
    let index13 = parseInt("0");
    billed.listen('MDCSelect:change', () => {
        if (index13++ === 0) return; else index13 = 0;
        let id = billed.selectedOptions[0].value;
        $("#requirementBilled").val(id);
    });

    //SET DATES
    if($("#requirementStartDate").val()){
        var compD1 = $("#requirementStartDate").val().split('/');
        var startD = new Date(compD1[2],compD1[1]-1,compD1[0]);
        var date1 = startD.getDate() < 10 ? '0'+ startD.getDate() : startD.getDate();
        var menth1 = startD.getMonth() < 9 ? '0'+ (startD.getMonth()+1) : (startD.getMonth()+1);
        datepicker1.val(date1+"/"+menth1+"/"+startD.getFullYear());
    }
    if($("#requirementEndDate").val()){
        var compD2 = $("#requirementEndDate").val().split('/');
        var endD = new Date(compD2[2],compD2[1]-1,compD2[0]);
        var date2 = endD.getDate() < 10 ? '0'+ endD.getDate() : endD.getDate();
        var menth2 = endD.getMonth() < 9 ? '0'+ (endD.getMonth()+1) : (endD.getMonth()+1);
        datepicker2.val(date2+"/"+menth2+"/"+endD.getFullYear());
    }

    $("#form").submit(function (e) {
        e.preventDefault();
        showHoldOn('Actualizando requerimiento...');

        var datas= $( this ).serialize();

        $.ajax({
            type: "POST",
            url:   "/requirements",
            data:  datas
        }).done(function(data){
            HoldOn.close();
            console.log("EXITE "+data);
            var func = savedFromAnchor ? continueAnchor() : undefined;
            customHolder("info","El Requerimiento se actualizó correctamente.",func);

        }).fail(function () {
            HoldOn.close();
            console.log("FALLE");
            customHolder("error","Ocurrio un error al actualizar el Requerimiento.");
        });
    });

    //HACK HOURS
    $(document).on("input","#requirementHour",function () {
        //this.value = parseFloat(this.value).toFixed(2);
    });

    datepicker1.keydown(function(e) {
        if(e.keyCode === 8){
            datepicker1.val("");
            $("#requirementStartDate").val("");
            datepicker1.datepicker("hide");
        }
    });
    datepicker2.keydown(function(e) {
        if(e.keyCode === 8){
            datepicker2.val("");
            $("#requirementEndDate").val("");
            datepicker2.datepicker("hide");
        }
    });

    /*FORM*/
    $("form :input").change(function() {
        $(this).closest('form').data('changed', true);
    });


    $("#asociar-pep-btn").click(function (e) {
        e.preventDefault();
        anchorUrl="/budgets/assign/filters?requirementId=" + $("#requirementId").val();

        if($form.serialize() !== origForm){
            console.log("CAMNIOES");
            showConfirmSave();
        }else {
            showHoldOn("Cargando...");
            window.location.href = anchorUrl;
        }

    });

    $("#alta-comp-btn").click(function (e) {
        e.preventDefault();
        anchorUrl="/components/add?requirementId=" + $("#requirementId").val();
        if($form.serialize() !== origForm){
            console.log("CAMNIOES");
            showConfirmSave();
        }else {
            showHoldOn("Cargando...");

            window.location.href = anchorUrl;
        }
    });

});

function getDate(element) {
    var date;
    try {
        date = $.datepicker.parseDate("dd/mm/yy", element);
    } catch (error) {
        date = null;
    }
    return date;
}

function showHoldOn(message) {
    HoldOn.open({
        theme: "sk-cube",
        content: '',
        message: message,
        backgroundColor: "#0c71ca",
        textColor: "white",
    });
}
function showConfirmSave(){
    HoldOn.open({
        theme: "custom",
        // If theme == "custom" , the content option will be available to customize the logo
        content: '<img style="height: 57px; margin-left: -5px;" src="data:image/png;base64,' + icone + '" >',
        message: "<br>" + "Hay cambios sin guardar, ¿deseas guardarlos?" +'<br><br>' +
        '<input type="button" value="No" class="btn btn-default" ' +
        'style="margin-right:24px;" '+ 'onclick="HoldOn.close(); continueAnchor();"> ' +
        '<input type="button" value="Guardar" class="btn btn-default" onclick="HoldOn.close(); saveAnchor();">',
        backgroundColor: "#0c71ca",
        textColor: "white"
    });
}
function continueAnchor() {
    window.location.href = anchorUrl;
}
function saveAnchor() {
    savedFromAnchor = true;
    $("#form").submit();
}

let icone = "iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAQAAAD/5HvMAAADgElEQVR4Ae3a30tUaRzH8SescevMaMjMGt2Kf8DSLyqxaLcGvAnWi/6KklOE4p8QtIIKCsuaw27k1k0yEkHBVJLIEvsPLGNepTWMQ3fNmaH3evfl4Xh+zDnPA17M6/MPvMHzeMZ5VF1dXYcVDkWmKbHJNnU8POpss0mJaW5wApVsis43yF3W8QjT5B0uP9oPusoabeJqUWbUXtA13pPEOlfMB53mb9J4zCmTQbf4SloNxs0E9bLIwXZ5wgRFhhggs78BhigywQqfOdgcmbRBfVTwqzPHOVTIzjPPHn6vyKYJKvAvoPuEi4OKMYd77AC6DxSSBvX5cjwexIqRZXlIy5eUSxLUSwXdf/yESrAzVNG9JtN50AK6VXKohOtnDd1sp0G30P1ODyrFjrKE7tdOgk7zFT1HGZie1GAwftAKIFbpMRLUQxkQf8YNuqY/ypHPDiLyWaoCYjRe0HuEJycrRZDsLG3E2zhBVwHxAGUkSDYDiJHooDXEJxzjQTl2EatRQYO0ES7KWJDsPqJFITzoLqKOYyUoyx7iTnjQOmIOZWkLiDdhQQ4e4py1oIuIbxwPDioidlHWdoQa4npw0DTiCcriniKmgoNKiAmrQS7iUXDQJqJoNWgMsREctI0YQskMHXvZMGIrOKiOGLAalEfUgoM8RMZqUC+ieXiDDv+P7FA91MmPPcL0sdd/MdoMchFL8V4dK1aDniEmg4NuID5bDNJfrr8EB53AQ5y3FRT98UP2DjFvLWgRUUGFBbmIPRwrQTkaiNtRH/JbiHtWgiYRHvnwIEUZsUPWeFAfXxDPUVFBo4B4aDxoFgGXgoNk64gWZ4wGXaCtP9Bxgq4goEq/saCTfER853J4kOwxAsqGvo45ygsELKPiBp2igYA/jPzps4yAOoXoINk46Empv9IrobvZ6Zee8+jK9CfOOckLdDOoToMyvEJX5WyinAt8RPeSY/GDZDk+oGsxQ66jmD5maaP7Byfx1YIvCXa5TzbmO2uKL+DLyae5fMnxGr89FrjIkZATdYlFGvi9xEl7PZVhjoPVeIrLGMPk6d1fnmHGcHlGjYP9xjEzF3jjNEirzk2TV5yD/EVy31mmYP4SeJS3JFFhxN41+QirtIjL4zmX7f8jQYE7vKFJmG9UuC0H3F6Q7DjXmeIRG2xRo7m/GltssMQkP/MDKtkUdtcN6gZ1g/4Hcx7nSGjajrgAAAAASUVORK5CYII=";