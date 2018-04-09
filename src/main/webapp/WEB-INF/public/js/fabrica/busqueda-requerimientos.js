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
        var dateStr = date.year() + "-" + (date.month() + 1) + '-' + date.date();
        $("input[id=requirementStartDate]").val(dateStr);
    });

    $("#datetimepicker5").on("dp.change", function (e) {
        var date = e.date;
        var dateStr = date.year() + "-" + (date.month() + 1) + '-' + date.date();
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

        $.ajax({
            url: "/levels/"+id+"/sublevel"
        }).done(function(data) {
            //let subdirs = JSON.parse(data);
            let subs = data;
            console.log(subs.length);
            $("#subdir-sel-text").html("");
            subdirs.selectedIndex = -1;
            subdirs.value = "";
            if (typeof subs !== 'undefined' && subs.length > 0) {
                $("#subdir-select").html("");
                $.each(subs, function( index, value ) {
                    console.log( index + ": " + value.levelId );
                    $("#subdir-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +
                        "value='"+value.levelId+"'>"+value.levelName+"</li>");
                });
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

    const areas = new mdc.select.MDCSelect(document.querySelector('#areas'));
    const tiposServ = new mdc.select.MDCSelect(document.querySelector('#tipos-serv'));
    let index3 = parseInt("0");
    areas.listen('MDCSelect:change', () => {
        if (index3++ === 0) return; else index3 = 0;
        let id = areas.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("AREAID " +id);
        $("#areaId").val(id);

        if(id === 1)
            $("#service-type-select").html( $("#service-types-ul").html() );
        else
            $("#service-type-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
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
    let index4 = parseInt("0");
    tiposProy.listen('MDCSelect:change', () => {
        if (index4++ === 0) return; else index4 = 0;
        let id = tiposProy.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("PROYECTTYPEID " +id);
        $("#projectTypeId").val(id);
    });

    const techs = new mdc.select.MDCSelect(document.querySelector('#techs'));
    let index5 = parseInt("0");
    techs.listen('MDCSelect:change', () => {
        if (index5++ === 0) return; else index5 = 0;
        let id = techs.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        $("#technologyId").val(id);
        console.log("TECHID " +id);
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
    });

    const empresas = new mdc.select.MDCSelect(document.querySelector('#empresas'));
    let index6 = parseInt("0");
    empresas.listen('MDCSelect:change', () => {
        if (index6++ === 0) return; else index6 = 0;
        let id = empresas.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("COMPANYID " +id);
        $("#companyId").val(id);
    });

    let index7 = parseInt("0");
    tiposServ.listen('MDCSelect:change', () => {
        if (index7++ === 0) return; else index7 = 0;
        let id = tiposServ.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("TIPOSERVID " +id);
        $("#tipos-serv").val(id);
    });

    const app = new mdc.select.MDCSelect(document.querySelector('#aplicacion'));
    let index8 = parseInt("0");
    app.listen('MDCSelect:change', () => {
        if (index8++ === 0) return; else index8 = 0;
        let id = empresas.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("APPID " +id);
        $("#companyId").val(id);
    });


    $('tr.clickable').click(function() {
        var radioButton = $(this).find('input[type=radio]');
        radioButton.prop('checked', true);
        $("#edit-requirement").attr("href","/requirements/"+radioButton.val());
    });

    //TODO APLICAICONES

});