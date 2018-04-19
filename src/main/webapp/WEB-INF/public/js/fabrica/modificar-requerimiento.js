$(function () {

    var picker1 = $("#datetimepicker1");
    var picker2 = $("#datetimepicker2");

    picker1.datetimepicker({
        format: 'DD/MM/YYYY',
        locale: 'es-mx',
        useCurrent: false
    });

    picker2.datetimepicker({
        format: 'DD/MM/YYYY',
        locale: 'es-mx',
        useCurrent: false
    });

    picker1.on("dp.change", function (e) {
        var date = e.date;
        var dateStr = date.date() + "/" + (date.month() + 1) + '/' + date.year();
        $("input[id=requirementStartDate]").val(dateStr);
    });

    picker2.on("dp.change", function (e) {
        var date = e.date;
        var dateStr = date.date() + "/" + (date.month() + 1) + '/' + date.year();
        $("input[id=requirementEndDate]").val(dateStr);
    });


    const principal = new mdc.select.MDCSelect(document.querySelector('#principal'));
    var principalEL = $('#principal');
    var principalId = $("#level\\.levelSuperior\\.levelId").val();
    console.log("SUPLEVEL ID "+principalId);
    principalEL.find("li[value="+principalId+"]").click();
    principalEL.find("div").first().click();

    principal.selectedIndex = principalId - 1;
    principal.value = principalEL.find("li[value="+principalId+"]").html();

    var subPrincipal = new mdc.select.MDCSelect(document.querySelector('#subprincipal'));
    //LOAD SUB LEVELS FROM PRINCIPAL
    $.ajax({
        url: "/api/levels/"+principalId+"/sub-levels"
    }).done(function(data) {
        let subdirs = data.data;
        $("#subdir-sel-text").html("");
        if (typeof subdirs !== 'undefined' && subdirs.length > 0) {
            $("#subdir-select").html("");
            $.each(subdirs, function( index, value ) {
                $("#subdir-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' data-subdir='" +
                    value.user.userInternalId+"' value='"+value.levelId+"'>"+value.levelName+"</li>");
            });

            var subPrincipalEL = $('#subprincipal');
            var subPrincipalId = $("#level\\.levelId").val();
            console.log("SUBLEVEL ID "+subPrincipalId + " "+"li[value="+subPrincipalId+"]");

            subPrincipalEL.find("div").first().click();
            subPrincipalEL.find("li[value='"+subPrincipalId+"']").click();
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
        /*
        var base_combo = "<div id=\"subprincipal\" class=\"mdc-select\" role=\"listbox\" data-mdc-auto-init=\"MDCSelect\">\n" +
            "                    <div class=\"mdc-select__surface mdc-ripple-upgraded\" tabindex=\"0\" >\n" +
        "                        <div class=\"mdc-select__label mdc-select__label--float-above\">Subdireccion *</div>\n" +
        "                        <div class=\"mdc-select__selected-text\" id=\"subdir-sel-text\"></div>\n" +
        "                        <div class=\"mdc-select__bottom-line\"></div>\n" +
        "                    </div>\n" +
        "                    <div class=\"mdc-menu mdc-select__menu col-md-3\">\n" +
        "                        <ul class=\"mdc-list mdc-menu__items\" id=\"subdir-select\">\n" +
        "                            <li class=\"mdc-list-item\" role=\"option\" tabindex=\"0\"></li>\n" +
        "                        </ul>\n" +
        "                    </div>\n" +
        "                </div>";
    papa = $("#subprincipal").parent();
    papa.empty();
    papa.append(base_combo);*/
    var subPrincipal = new mdc.select.MDCSelect(document.querySelector('#subprincipal'));
        if (coso++ === 0) return; else coso = 0;
        subPrincipal.disabled = true;
        let id = principal.selectedOptions[0].value;

        $.ajax({
            url: "/api/levels/"+id+"/sub-levels"
        }).done(function(data) {
            let subdirs = data.data;
            $("#subdir-sel-text").html("");
            subPrincipal.selectedIndex = -1;
            subPrincipal.value = "";
            if (typeof subdirs !== 'undefined' && subdirs.length > 0) {
                $("#subdir-select").html("");
                $.each(subdirs, function( index, value ) {
                    $("#subdir-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' data-subdir='" +
                        value.user.userInternalId+"' value='"+value.levelId+"'>"+value.levelName+"</li>");
                });
            }else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
            subPrincipal.disabled = false;
        });
    });

    const responsible = new mdc.select.MDCSelect(document.querySelector('#responsible'));
    var responsibleEL = $('#responsible');
    var responsibleId = $("#user\\.userInternalId").val();
    console.log("RESPONSIBLE ID "+responsibleId);
    responsibleEL.find("div").first().click();
    responsibleEL.find("li[value="+responsibleId+"]").click();
    responsible.selectedIndex = responsibleEL.find("ul li[id="+ responsibleId +"]").index();
    responsible.value = responsibleEL.find("ul li[id="+responsibleId+"]").html();
    let index = parseInt("0");
    responsible.listen('MDCSelect:change', () => {
        if (index++ === 0) return; else index = 0;
        var id1 = responsible.selectedOptions[0].id;
        console.log("RESPINSIBLEIDSEL "+responsible.selectedOptions.length+" " + id1);
        $("#user\\.userInternalId").val(id1);
    });

    const area = new mdc.select.MDCSelect(document.querySelector('#area'));
    var areaEL = $('#area');
    var areaId = $("#area\\.areaId").val();
    console.log("Area ID "+areaId);
    areaEL.find("div").first().click();
    areaEL.find("li[value="+areaId+"]").click();
    area.selectedIndex = areaEL.find("ul li[value="+ areaId +"]").index();
    area.value = areaEL.find("ul li[value="+areaId+"]").html();
    let index2 = parseInt("0");
    area.listen('MDCSelect:change', () => {
        if (index2++ === 2) return; else index2 = 0;
        let id = area.selectedOptions[0].value;
        $("#area\\.areaId").val(id);
    });

    const manager = new mdc.select.MDCSelect(document.querySelector('#manager'));
    var managerEL = $('#manager');
    var managerId = $("#userManager\\.userInternalId").val();
    console.log("Gestor ID "+managerId);
    //managerEL.find("div").first().click();
    //managerEL.find("li[value="+managerId+"]").click();
    manager.selectedIndex = managerEL.find("ul li[id="+ managerId +"]").index();
    manager.value = managerEL.find("ul li[id="+managerId+"]").html();
    let index3 = parseInt("0");
    manager.listen('MDCSelect:change', () => {
        if (index3++ === 0) return; else index3 = 0;
        let id = manager.selectedOptions[0].id;
        console.log("MANAGERID "+manager.selectedOptions.length+" " + id);
        $("#userManager\\.userInternalId").val(id);
    });

    const tech = new mdc.select.MDCSelect(document.querySelector('#tech'));
    var techEL = $('#tech');
    var techId = $("#technology\\.technologyId").val();
    console.log("TECH ID "+techId);
    techEL.find("div").first().click();
    techEL.find("li[value="+techId+"]").click();
    tech.selectedIndex = techEL.find("ul li[value="+ techId +"]").index();
    tech.value = techEL.find("ul li[value="+techId+"]").html();
    let index4 = parseInt("0");
    tech.listen('MDCSelect:change', () => {
        if (index4++ === 0) return; else index4 = 0;
        let id = tech.selectedOptions[0].value;
        console.log("TECHIDSEl "+tech.selectedOptions.length+" " + id);
        $("#technology\\.technologyId").val(id);
    });

    const meth = new mdc.select.MDCSelect(document.querySelector('#meth'));
    var methEL = $('#meth');
    var methId = $("#project\\.methodology\\.methodologyId").val();
    console.log("METH ID "+methId);
    methEL.find("div").first().click();
    methEL.find("li[value="+methId+"]").click();
    meth.selectedIndex = methEL.find("ul li[value="+ methId +"]").index();
    meth.value = methEL.find("ul li[value="+methId+"]").html();
    let index5 = parseInt("0");
    meth.listen('MDCSelect:change', () => {
        if (index5++ === 0) return; else index5 = 0;
        let id = meth.selectedOptions[0].value;
        $("#project\\.methodology\\.methodologyId").val(id);
    });

    const app = new mdc.select.MDCSelect(document.querySelector('#app'));
    var appEL = $('#app');
    var appId = $("#application\\.applicationId").val();
    console.log("app ID "+appId);
    appEL.find("div").first().click();
    appEL.find("li[value="+appId+"]").click();
    app.selectedIndex = appEL.find("ul li[value="+ appId +"]").index();
    app.value = appEL.find("ul li[value="+appId+"]").html();
    let index6 = parseInt("0");
    app.listen('MDCSelect:change', () => {
        if (index6++ === 0) return; else index6 = 0;
        let id = app.selectedOptions[0].value;
        $("#application\\.applicationId").val(id);
    });

    const channel = new mdc.select.MDCSelect(document.querySelector('#channel'));
    var channelEL = $('#channel');
    var channelId = $("#channel\\.channelId").val();
    console.log("channel ID "+channelId);
    channelEL.find("div").first().click();
    channelEL.find("li[value="+channelId+"]").click();
    channel.selectedIndex = channelEL.find("ul li[value="+ channelId +"]").index();
    channel.value = channelEL.find("ul li[value="+channelId+"]").html();
    let index7 = parseInt("0");
    channel.listen('MDCSelect:change', () => {
        if (index7++ === 0) return; else index7 = 0;
        let id = channel.selectedOptions[0].value;
        $("#channel\\.channelId").val(id);
    });

    const company = new mdc.select.MDCSelect(document.querySelector('#company'));
    var companyEL = $('#company');
    var companyId = $("#company\\.companyId").val();
    console.log("company ID "+companyId);
    companyEL.find("div").first().click();
    companyEL.find("li[value="+companyId+"]").click();
    company.selectedIndex = companyEL.find("ul li[value="+ companyId +"]").index();
    company.value = companyEL.find("ul li[value="+companyId+"]").html();
    let index8 = parseInt("0");
    company.listen('MDCSelect:change', () => {
        if (index8++ === 0) return; else index8 = 0;
        let id = company.selectedOptions[0].value;
        $("#company\\.companyId").val(id);
    });

    const serviceType = new mdc.select.MDCSelect(document.querySelector('#service-type'));
    var serviceTypeEL = $('#service-type');
    var serviceTypeId = $("#serviceType\\.serviceTypeId").val();
    console.log("serviceType ID "+serviceTypeId);
    serviceTypeEL.find("div").first().click();
    serviceTypeEL.find("li[value="+serviceTypeId+"]").click();
    serviceType.selectedIndex = serviceTypeEL.find("ul li[value="+ serviceTypeId +"]").index();
    serviceType.value = serviceTypeEL.find("ul li[value="+serviceTypeId+"]").html();
    let index9 = parseInt("0");
    serviceType.listen('MDCSelect:change', () => {
        if (index9++ === 0) return; else index9 = 0;
        let id = serviceType.selectedOptions[0].value;
        $("#serviceType\\.serviceTypeId").val(id);
    });

    const pi = new mdc.select.MDCSelect(document.querySelector('#pi'));
    var piEL = $('#pi');
    var piId = $("#programIncrement\\.programIncrementId").val();
    console.log("pi ID "+piId);
    piEL.find("div").first().click();
    piEL.find("li[value="+piId+"]").click();
    pi.selectedIndex = piEL.find("ul li[value="+ piId +"]").index();
    pi.value = piEL.find("ul li[value="+piId+"]").html();
    let index10 = parseInt("0");
    pi.listen('MDCSelect:change', () => {
        if (index10++ === 0) return; else index10 = 0;
        let id = pi.selectedOptions[0].value;
        $("#programIncrement\\.programIncrementId").val(id);
    });

    const project = new mdc.select.MDCSelect(document.querySelector('#project'));
    var projectEL = $('#project');
    var projectId = $("#project\\.projectId").val();
    console.log("project ID "+projectId);
    projectEL.find("div").first().click();
    projectEL.find("li[value="+projectId+"]").click();
    project.selectedIndex = projectEL.find("ul li[id="+ projectId +"]").index();
    project.value = projectEL.find("ul li[id="+projectId+"]").html();
    let index11 = parseInt("0");
    project.listen('MDCSelect:change', () => {
        if (index11++ === 0) return; else index11 = 0;
        let id = project.selectedOptions[0].id;
        $("#project\\.projectId").val(id);
    });

    //TODO DOING PROJECTS
    /*
    $.ajax({
        url: "/projects/"+principalId+"/sublevel"
    }).done(function(data) {
        let subdirs = data;
        //$("#subdir-sel-text").html("");
        if (typeof subdirs !== 'undefined' && subdirs.length > 0) {
            $("#subdir-select").html("");
            $.each(subdirs, function( index, value ) {
                $("#subdir-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "value='"+value.levelId+"'>"+value.levelName+"</li>");

            });

            const subPrincipal = new mdc.select.MDCSelect(document.querySelector('#subprincipal'));
            var subPrincipalEL = $('#subprincipal');
            var subPrincipalId = $("#level\\.levelId").val();
            console.log("SUBLEVEL ID "+subPrincipalId);
            subPrincipal.selectedIndex = subPrincipalEL.find("ul li[value="+ subPrincipalId +"]").index();
            subPrincipal.value = subPrincipalEL.find("ul li[value="+subPrincipalId+"]").html();

        }else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
    });
    */

    const status = new mdc.select.MDCSelect(document.querySelector('#status'));
    var statusEL = $('#status');
    var statusId = $("#status\\.statusId").val();
    console.log("status ID "+statusId);
    //statusEL.find("div").first().click();
    //statusEL.find("li[value="+statusId+"]").click();
    status.selectedIndex = statusEL.find("ul li[value="+ statusId +"]").index();
    status.value = statusEL.find("ul li[value="+statusId+"]").html();
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

    //TODO Al enviar objeto, poner a null el level.levelSuperior.levelId ?
    /*$('#form').submit(function() {
        $("#level\\.levelSuperior\\.levelId").val(null);
        return true;
    });*/

    //SET DATES

    if($("#requirementStartDate").val()){
        var compD1 = $("#requirementStartDate").val().split('/');
        var startD = new Date(compD1[2],compD1[1]-1,compD1[0]);
        picker1.val(startD.getDate()+"/"+(startD.getMonth()+1)+"/"+startD.getFullYear());
    }
    if($("#requirementEndDate").val()){
        var compD2 = $("#requirementEndDate").val().split('/');
        var endD = new Date(compD2[2],compD2[1]-1,compD2[0]);
        picker2.val(endD.getDate()+"/"+(endD.getMonth()+1)+"/"+endD.getFullYear())
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