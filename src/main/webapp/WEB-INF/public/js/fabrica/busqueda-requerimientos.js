$(function () {

    const select = new mdc.select.MDCSelect(document.querySelector('.mdc-select'));
    let coso = parseInt("0");
    select.listen('MDCSelect:change', () => {
        if(++coso > 1){coso = 0; return;}

        let id = select.selectedOptions[0].value;

        $.ajax({
            url: "/nivel/"+id+"/subdir"
        }).done(function(data) {
            console.log("SUBIDR "+data);
            //$( this ).addClass( "done" );
        });

        /*alert(`Selected "${select.selectedOptions[0].value}" at index ${select.selectedIndex} ` +
            `with value "${select.value}"`);*/
    });

});