//Funcion inicial
//Variables globales

function init(){

    crearCombos();
    asignarCombos();

}

function crearCombos(){

    mdc.select.MDCSelect.attachTo(document.getElementById('anio-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('area-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('banca-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('responsableDot-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('solicitante-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('estado-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('ig-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('direccion-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('director-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('grupo-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('respArea-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('respDyD-js-select'));
}

function asignarCombos(){

    //Asigna los valores seleccionados a todos los combos
    $(".mdc-select").each(function(index, element){
        var $parentTd = $(element).parent();
        var $hiddenInput = $parentTd.find("input");
        var rootSelect = document.getElementById($(element).attr("id"));
        var selectObj = new mdc.select.MDCSelect(rootSelect);

        rootSelect.addEventListener('MDCSelect:change', function () {
            $hiddenInput.val(selectObj.value);
        });
    });


}

function funcionCancelar(){

    //Lleva a la ventana principal
    window.location="/";

}
