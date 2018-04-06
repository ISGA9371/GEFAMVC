
$(function () {
    const principal = new mdc.select.MDCSelect(document.querySelector('#principal'));
    var principalEL = $('#principal');
    var principalId = $("#level\\.levelSuperior\\.levelId").val();
    console.log("SUPLEVEL ID "+principalId);
    //principalEL.find("div").first().click();
    //principalEL.find("li[value="+principalId+"]").click();
    principal.selectedIndex = principalId - 1;
    principal.value = principalEL.find("li[value="+principalId+"]").html();

    //LOAD SUB LEVELS FROM PRINCIPAL
    $.ajax({
        url: "/levels/"+principalId+"/sublevel"
    }).done(function(data) {
        let subdirs = data;
        $("#subdir-sel-text").html("");
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
            console.log("SUBLEVEL ID "+subPrincipalId + " "+"li[value="+subPrincipalId+"]");

            //subPrincipalEL.find("div").first().click();
            //subPrincipalEL.find("li[value='"+subPrincipalId+"']").click();
            subPrincipal.selectedIndex = subPrincipalEL.find("ul li[value="+ subPrincipalId +"]").index();
            subPrincipal.value = subPrincipalEL.find("ul li[id="+subPrincipalId+"]").html();

            var idx = parseInt("0");
            subPrincipal.listen('MDCSelect:change', () => {
                if (++idx > 1) {idx = 0;return;}
                let id = subdirs.selectedOptions[0].value;
                $("#level\\.levelId").val(id);
            });

        }else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");

    });
    //LOADING SUBDIRECCIONES CUANDO DIRECCION CMABIA
    let coso = parseInt("0");
    principal.listen('MDCSelect:change', () => {
        if(++coso > 1){coso = 0; return;}
        let id = principal.selectedOptions[0].value;

        $.ajax({
            url: "/levels/"+id+"/sublevel"
        }).done(function(data) {
            let subdirs = data;
            $("#subdir-sel-text").html("");
            if (typeof subdirs !== 'undefined' && subdirs.length > 0) {
                $("#subdir-select").html("");
                $.each(subdirs, function( index, value ) {
                    $("#subdir-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +
                        "value='"+value.levelId+"'>"+value.levelName+"</li>");
                });
            }else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");

        });
    });

    const responsible = new mdc.select.MDCSelect(document.querySelector('#responsible'));
    var responsibleEL = $('#responsible');
    var responsibleId = $("#user\\.userInternalId").val();
    console.log("RESPONSIBLE ID "+responsibleId);
    //responsibleEL.find("div").first().click();
    //responsibleEL.find("li[value="+responsibleId+"]").click();
    responsible.selectedIndex = responsibleEL.find("ul li[value="+ responsibleId +"]").index();
    responsible.value = responsibleEL.find("ul li[id="+responsibleId+"]").html();
    let index = parseInt("0");
    responsible.listen('MDCSelect:change', () => {
        if (++index > 1) {index = 0;return;}
        let id = responsible.selectedOptions[0].value;
        $("#user\\.userInternalId").val(id);
    });

    const area = new mdc.select.MDCSelect(document.querySelector('#area'));
    var areaEL = $('#area');
    var areaId = $("#area\\.areaId").val();
    console.log("Area ID "+areaId);
    //areaEL.find("div").first().click();
    //areaEL.find("li[value="+areaId+"]").click();
    area.selectedIndex = areaEL.find("ul li[value="+ areaId +"]").index();
    area.value = areaEL.find("ul li[id="+areaId+"]").html();
    let index2 = parseInt("0");
    area.listen('MDCSelect:change', () => {
        if (++index2 > 1) {index2 = 0;return;}
        let id = area.selectedOptions[0].value;
        $("#area\\.areaId").val(id);
    });

    const manager = new mdc.select.MDCSelect(document.querySelector('#manager'));
    var managerEL = $('#manager');
    var managerId = $("#userManager\\.userInternalId").val();
    console.log("Gestor ID "+managerId);
    //managerEL.find("div").first().click();
    //managerEL.find("li[value="+managerId+"]").click();
    manager.selectedIndex = managerEL.find("ul li[value="+ managerId +"]").index();
    manager.value = managerEL.find("ul li[id="+managerId+"]").html();
    let index3 = parseInt("0");
    manager.listen('MDCSelect:change', () => {
        if (++index3 > 1) {index3 = 0;return;}
        let id = manager.selectedOptions[0].value;
        $("#userManager\\.userInternalId").val(id);
    });

    const tech = new mdc.select.MDCSelect(document.querySelector('#tech'));
    var techEL = $('#tech');
    var techId = $("#technology\\.technologyId").val();
    console.log("TECH ID "+techId);
    //techEL.find("div").first().click();
    //techEL.find("li[value="+techId+"]").click();
    tech.selectedIndex = techEL.find("ul li[value="+ techId +"]").index();
    tech.value = techEL.find("ul li[id="+techId+"]").html();
    let index4 = parseInt("0");
    tech.listen('MDCSelect:change', () => {
        if (++index4 > 1) {index4 = 0;return;}
        let id = tech.selectedOptions[0].value;
        $("#technology\\.technologyId").val(id);
    });

    const meth = new mdc.select.MDCSelect(document.querySelector('#meth'));
    var methEL = $('#meth');
    var methId = $("#methodology\\.methodologyId").val();
    console.log("METH ID "+methId);
    //methEL.find("div").first().click();
    //methEL.find("li[value="+methId+"]").click();
    meth.selectedIndex = methEL.find("ul li[value="+ methId +"]").index();
    meth.value = methEL.find("ul li[id="+methId+"]").html();
    let index5 = parseInt("0");
    meth.listen('MDCSelect:change', () => {
        if (++index5 > 1) {index5 = 0;return;}
        let id = meth.selectedOptions[0].value;
        $("#methodology\\.methodologyId").val(id);
    });

    const app = new mdc.select.MDCSelect(document.querySelector('#app'));
    var appEL = $('#app');
    var appId = $("#application\\.applicationId").val();
    console.log("app ID "+appId);
    //appEL.find("div").first().click();
    //appEL.find("li[value="+appId+"]").click();
    app.selectedIndex = appEL.find("ul li[value="+ appId +"]").index();
    app.value = appEL.find("ul li[id="+appId+"]").html();
    let index6 = parseInt("0");
    app.listen('MDCSelect:change', () => {
        if (++index6 > 1) {index6 = 0;return;}
        let id = app.selectedOptions[0].value;
        $("#application\\.applicationId").val(id);
    });

    const channel = new mdc.select.MDCSelect(document.querySelector('#channel'));
    var channelEL = $('#channel');
    var channelId = $("#channel\\.channelId").val();
    console.log("channel ID "+channelId);
    //channelEL.find("div").first().click();
    //channelEL.find("li[value="+channelId+"]").click();
    channel.selectedIndex = channelEL.find("ul li[value="+ channelId +"]").index();
    channel.value = channelEL.find("ul li[id="+channelId+"]").html();
    let index7 = parseInt("0");
    channel.listen('MDCSelect:change', () => {
        if (++index7 > 1) {index7 = 0;return;}
        let id = channel.selectedOptions[0].value;
        $("#channel\\.channelId").val(id);
    });

    const company = new mdc.select.MDCSelect(document.querySelector('#company'));
    var companyEL = $('#company');
    var companyId = $("#company\\.companyId").val();
    console.log("company ID "+companyId);
    //companyEL.find("div").first().click();
    //companyEL.find("li[value="+companyId+"]").click();
    company.selectedIndex = companyEL.find("ul li[value="+ companyId +"]").index();
    company.value = companyEL.find("ul li[id="+companyId+"]").html();
    let index8 = parseInt("0");
    company.listen('MDCSelect:change', () => {
        if (++index8 > 1) {index8 = 0;return;}
        let id = company.selectedOptions[0].value;
        $("#company\\.companyId").val(id);
    });

    const serviceType = new mdc.select.MDCSelect(document.querySelector('#service-type'));
    var serviceTypeEL = $('#service-type');
    var serviceTypeId = $("#serviceType\\.serviceTypeId").val();
    console.log("serviceType ID "+serviceTypeId);
    //serviceTypeEL.find("div").first().click();
    //serviceTypeEL.find("li[value="+serviceTypeId+"]").click();
    serviceType.selectedIndex = serviceTypeEL.find("ul li[value="+ serviceTypeId +"]").index();
    serviceType.value = serviceTypeEL.find("ul li[id="+serviceTypeId+"]").html();
    let index9 = parseInt("0");
    serviceType.listen('MDCSelect:change', () => {
        if (++index9 > 1) {index9 = 0;return;}
        let id = serviceType.selectedOptions[0].value;
        $("#serviceType\\.serviceTypeId").val(id);
    });

    const pi = new mdc.select.MDCSelect(document.querySelector('#pi'));
    var piEL = $('#pi');
    var piId = $("#programIncrement\\.programIncrementId").val();
    console.log("pi ID "+piId);
    //piEL.find("div").first().click();
    //piEL.find("li[value="+piId+"]").click();
    pi.selectedIndex = piEL.find("ul li[value="+ piId +"]").index();
    pi.value = piEL.find("ul li[id="+piId+"]").html();
    let index10 = parseInt("0");
    pi.listen('MDCSelect:change', () => {
        if (++index10 > 1) {index10 = 0;return;}
        let id = pi.selectedOptions[0].value;
        $("#programIncrement\\.programIncrementId").val(id);
    });

    const project = new mdc.select.MDCSelect(document.querySelector('#project'));
    var projectEL = $('#project');
    var projectId = $("#project\\.projectId").val();
    console.log("project ID "+projectId);
    //projectEL.find("div").first().click();
    //projectEL.find("li[value="+projectId+"]").click();
    project.selectedIndex = projectEL.find("ul li[value="+ projectId +"]").index();
    project.value = projectEL.find("ul li[id="+projectId+"]").html();
    let index11 = parseInt("0");
    project.listen('MDCSelect:change', () => {
        if (++index11 > 1) {index11 = 0;return;}
        let id = project.selectedOptions[0].value;
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
            subPrincipal.value = subPrincipalEL.find("ul li[id="+subPrincipalId+"]").html();

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
    status.value = statusEL.find("ul li[id="+statusId+"]").html();
    let index12 = parseInt("0");
    status.listen('MDCSelect:change', () => {
        if (++index12 > 1) {index12 = 0;return;}
        let id = status.selectedOptions[0].value;
        $("#status\\.statusId").val(id);
    });

    const billed = new mdc.select.MDCSelect(document.querySelector('#billed'));
    let index13 = parseInt("0");
    billed.listen('MDCSelect:change', () => {
        if (++index13 > 1) {index13 = 0;return;}
        let id = billed.selectedOptions[0].value;
        $("#requirementBilled").val(id);
    });

    //TODO Al enviar objeto, poner a null el level.levelSuperior.levelId ?
    /*$('#form').submit(function() {
        $("#level\\.levelSuperior\\.levelId").val(null);
        return true;
    });*/

});