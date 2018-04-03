$(function () {

    const principal = new mdc.select.MDCSelect(document.querySelector('#principal'));
    principal.selectedIndex = 4;
/*
    const select = new mdc.select.MDCSelect(document.querySelector('#dirs'));
    let coso = parseInt("0");
    select.listen('MDCSelect:change', () => {
        if(++coso > 1){coso = 0; return;}

        let id = select.selectedOptions[0].value;

        //SET HIDDEN FIELD VALUE
        $("#directionId").val(id);

        $.ajax({
            url: "/levels/"+id+"/sublevel"
        }).done(function(data) {
            //let subdirs = JSON.parse(data);
            let subdirs = data;
            console.log(subdirs.length);
            $("#subdir-sel-text").html("");
            if (typeof subdirs !== 'undefined' && subdirs.length > 0) {
                $("#subdir-select").html("");
                $.each(subdirs, function( index, value ) {
                    console.log( index + ": " + value.levelSerial );
                    $("#subdir-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +
                        "value='"+value.levelSerial+"'>"+value.levelName+"</li>");

                });
            }else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");

        });
    });

    const subdirs = new mdc.select.MDCSelect(document.querySelector('#subdirs'));
    let index2 = parseInt("0");
    subdirs.listen('MDCSelect:change', () => {
        if (++index2 > 1) {index2 = 0;return;}
        let id = subdirs.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        $("#subDirectionId").val(id);
    });

    const areas = new mdc.select.MDCSelect(document.querySelector('#areas'));
    let index3 = parseInt("0");
    areas.listen('MDCSelect:change', () => {
        if(++index3 > 1){index3 = 0; return;}

        let id = areas.selectedOptions[0].value;
        let val = areas.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        $("#attAreaId").val(id);

        $.ajax({
            url: "/service-types/area/"+id
        }).done(function(data) {
            //let subdirs = JSON.parse(data);
            let services = data;
            console.log(services.length);
            $("#service-type-sel-text").html("");
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
    });

    const tiposProy = new mdc.select.MDCSelect(document.querySelector('#tipos-proy'));
    let index4 = parseInt("0");
    tiposProy.listen('MDCSelect:change', () => {
        if (++index4 > 1) {index4 = 0;return;}
        let id = tiposProy.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        $("#proyTypeId").val(id);
    });

    const techs = new mdc.select.MDCSelect(document.querySelector('#techs'));
    let index5 = parseInt("0");
    techs.listen('MDCSelect:change', () => {
        if (++index5 > 1) {index5 = 0;return;}
        let id = techs.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        $("#techId").val(id);

        $.ajax({
            url: "/technologies/"+id+"/app"
        }).done(function(data) {
            let apps = data;
            console.log(apps.length);
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
        if (++index6 > 1) {index6 = 0;return;}
        let id = empresas.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        $("#companyId").val(id);
    });

    const tiposServ = new mdc.select.MDCSelect(document.querySelector('#tipos-serv'));
    let index7 = parseInt("0");
    empresas.listen('MDCSelect:change', () => {
        if (++index7 > 1) {index7 = 0;return;}
        let id = tiposServ.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        $("#serviceTypeId").val(id);
    });

*/
});