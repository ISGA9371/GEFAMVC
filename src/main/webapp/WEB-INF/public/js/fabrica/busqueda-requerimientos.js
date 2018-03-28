$(function () {

    const select = new mdc.select.MDCSelect(document.querySelector('#dirs'));
    let coso = parseInt("0");
    select.listen('MDCSelect:change', () => {
        if(++coso > 1){coso = 0; return;}

        let id = select.selectedOptions[0].value;

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

    const areas = new mdc.select.MDCSelect(document.querySelector('#areas'));
    let index2 = parseInt("0");
    areas.listen('MDCSelect:change', () => {
        if(++index2 > 1){index2 = 0; return;}

        let id = areas.selectedOptions[0].value;

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

});