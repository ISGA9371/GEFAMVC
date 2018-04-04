$(function () {

    const principal = new mdc.select.MDCSelect(document.querySelector('#principal'));
    var principalEL = $('#principal');
    var principalId = $("#level\\.levelSuperior\\.levelSerial").val();
    console.log("SUPLEVELSERIAL ID "+principalId);
    principal.selectedIndex = principalId - 1;
    principal.value = principalEL.find("li[id="+principalId+"]").html();

    //LOAD SUB LEVELS FROM PRINCIPAL

    $.ajax({
        url: "/levels/"+principalId+"/sublevel"
    }).done(function(data) {
        let subdirs = data;
        //$("#subdir-sel-text").html("");
        if (typeof subdirs !== 'undefined' && subdirs.length > 0) {
            $("#subdir-select").html("");
            $.each(subdirs, function( index, value ) {
                $("#subdir-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "value='"+value.levelSerial+"'>"+value.levelName+"</li>");

            });

            const subPrincipal = new mdc.select.MDCSelect(document.querySelector('#subprincipal'));
            var subPrincipalEL = $('#subprincipal');
            var subPrincipalId = $("#level\\.levelSerial").val();
            console.log("LEVELSERIAL ID "+subPrincipalId);
            subPrincipal.selectedIndex = subPrincipalEL.find("ul li[value="+ subPrincipalId +"]").index();
            subPrincipal.value = subPrincipalEL.find("ul li[id="+subPrincipalId+"]").html();

        }else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");

    });

    /* LOADING SUBDIRECCIONES CUANDO DIRECCION CMABIA
    let coso = parseInt("0");
    principal.listen('MDCSelect:change', () => {
        if(++coso > 1){coso = 0; return;}
        let id = select.selectedOptions[0].value;

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
                        "value='"+value.levelSerial+"'>"+value.levelName+"</li>");

                });
            }else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");

        });
    });
    */

    const responsible = new mdc.select.MDCSelect(document.querySelector('#responsible'));
    var responsibleEL = $('#responsible');
    var responsibleId = $("#user\\.userId").val();
    console.log("RESPONSIBLE ID "+responsibleId);
    responsible.selectedIndex = responsibleEL.find("ul li[value="+ responsibleId +"]").index();
    responsible.value = responsibleEL.find("ul li[id="+responsibleId+"]").html();

    const area = new mdc.select.MDCSelect(document.querySelector('#area'));
    var areaEL = $('#area');
    var areaId = $("#area\\.areaId").val();
    console.log("Area ID "+areaId);
    area.selectedIndex = areaEL.find("ul li[value="+ areaId +"]").index();
    area.value = areaEL.find("ul li[id="+areaId+"]").html();

    const manager = new mdc.select.MDCSelect(document.querySelector('#manager'));
    var managerEL = $('#manager');
    var managerId = $("#userManager\\.userId").val();
    console.log("Gestor ID "+managerId);
    manager.selectedIndex = managerEL.find("ul li[value="+ managerId +"]").index();
    manager.value = managerEL.find("ul li[id="+managerId+"]").html();

    const tech = new mdc.select.MDCSelect(document.querySelector('#tech'));
    var techEL = $('#tech');
    var techId = $("#technology\\.technologyId").val();
    console.log("TECH ID "+techId);
    tech.selectedIndex = techEL.find("ul li[value="+ techId +"]").index();
    tech.value = techEL.find("ul li[id="+techId+"]").html();

    const meth = new mdc.select.MDCSelect(document.querySelector('#meth'));
    var methEL = $('#meth');
    var methId = $("#project\\.methodology\\.methodologyId").val();
    console.log("METH ID "+methId);
    meth.selectedIndex = methEL.find("ul li[value="+ methId +"]").index();
    meth.value = methEL.find("ul li[id="+methId+"]").html();

    const app = new mdc.select.MDCSelect(document.querySelector('#app'));
    var appEL = $('#app');
    var appId = $("#application\\.applicationSerial").val();
    console.log("app ID "+appId);
    app.selectedIndex = appEL.find("ul li[value="+ appId +"]").index();
    app.value = appEL.find("ul li[id="+appId+"]").html();

    const channel = new mdc.select.MDCSelect(document.querySelector('#channel'));
    var channelEL = $('#channel');
    var channelId = $("#channel\\.channelSerial").val();
    console.log("channel ID "+channelId);
    channel.selectedIndex = channelEL.find("ul li[value="+ channelId +"]").index();
    channel.value = channelEL.find("ul li[id="+channelId+"]").html();

    const company = new mdc.select.MDCSelect(document.querySelector('#company'));
    var companyEL = $('#company');
    var companyId = $("#company\\.companyId").val();
    console.log("company ID "+companyId);
    company.selectedIndex = companyEL.find("ul li[value="+ companyId +"]").index();
    company.value = companyEL.find("ul li[id="+companyId+"]").html();

    const serviceType = new mdc.select.MDCSelect(document.querySelector('#service-type'));
    var serviceTypeEL = $('#service-type');
    var serviceTypeId = $("#serviceType\\.serviceTypeId").val();
    console.log("serviceType ID "+serviceTypeId);
    serviceType.selectedIndex = serviceTypeEL.find("ul li[value="+ serviceTypeId +"]").index();
    serviceType.value = serviceTypeEL.find("ul li[id="+serviceTypeId+"]").html();

    const pi = new mdc.select.MDCSelect(document.querySelector('#pi'));
    var piEL = $('#pi');
    var piId = $("#programIncrement\\.programIncrementId").val();
    console.log("pi ID "+piId);
    pi.selectedIndex = piEL.find("ul li[value="+ piId +"]").index();
    pi.value = piEL.find("ul li[id="+piId+"]").html();

    //TODO PROJECTs

    const status = new mdc.select.MDCSelect(document.querySelector('#status'));
    var statusEL = $('#status');
    var statusId = $("#status\\.statusId").val();
    console.log("status ID "+statusId);
    status.selectedIndex = statusEL.find("ul li[value="+ statusId +"]").index();
    status.value = statusEL.find("ul li[id="+statusId+"]").html();

    //TODO Al enviar objeto, poner a null el level.levelSuperior,levelSerial

});