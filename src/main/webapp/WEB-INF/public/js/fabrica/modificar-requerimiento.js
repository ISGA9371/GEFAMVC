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
                console.log("SUBLEVEL ID "+subPrincipalId);
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
    var areaId = $("#area\\.areaId").val();
    console.log("Area ID "+areaId);
    let index2 = parseInt("0");
    area.listen('MDCSelect:change', () => {
        if (index2++ === 2) return; else index2 = 0;
        let id = area.selectedOptions[0].value;
        $("#area\\.areaId").val(id);
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
        let id = manager.selectedOptions[0].id;
        console.log("MANAGERID "+manager.selectedOptions.length+" " + id);
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

    const meth = new mdc.select.MDCSelect(document.querySelector('#meth'));
    var methId = $("#project\\.methodology\\.methodologyId").val();
    console.log("METH ID "+methId);
    let index5 = parseInt("0");
    meth.listen('MDCSelect:change', () => {
        if (index5++ === 0) return; else index5 = 0;
        let id = meth.selectedOptions[0].value;
        $("#project\\.methodology\\.methodologyId").val(id);
    });

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

    const serviceType = new mdc.select.MDCSelect(document.querySelector('#service-type'));
    var serviceTypeId = $("#serviceType\\.serviceTypeId").val();
    console.log("serviceType ID "+serviceTypeId);
    let index9 = parseInt("0");
    serviceType.listen('MDCSelect:change', () => {
        if (index9++ === 0) return; else index9 = 0;
        let id = serviceType.selectedOptions[0].value;
        $("#serviceType\\.serviceTypeId").val(id);
    });

    const pi = new mdc.select.MDCSelect(document.querySelector('#pi'));
    var piId = $("#programIncrement\\.programIncrementId").val();
    console.log("pi ID "+piId);
    let index10 = parseInt("0");
    pi.listen('MDCSelect:change', () => {
        if (index10++ === 0) return; else index10 = 0;
        let id = pi.selectedOptions[0].value;
        $("#programIncrement\\.programIncrementId").val(id);
    });

    var projectId = $("#project\\.projectId").val();
    console.log("project ID "+projectId);
    const project = new mdc.select.MDCSelect(document.querySelector('#project'));

    let index11 = parseInt("0");
    project.listen('MDCSelect:change', () => {
        if (index11++ === 0) return; else index11 = 0;
        let id = project.selectedOptions[0].id;
        $("#project\\.projectId").val(id);
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
    $("#form").submit(function () {
        showHoldOn();
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