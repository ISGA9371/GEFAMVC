//Funcion inicial
//Variables globales

function init(){

    //Lleva a la ventana principal
    crearCombos();
    asignarCombos();

}

function crearCombos(){

    mdc.select.MDCSelect.attachTo(document.getElementById('direccion-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('subdireccion-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('area-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('tecnologia-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('tipoProyecto-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('aplicacion-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('canal-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('empresa-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('servicio-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('pi-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('proy-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('estado-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('facturado-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('responsable-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('gestor-js-select'));

}

function asignarCombos(){

    $(".mdc-select").each(function(index, element){
        var $parentTd = $(element).parent();
        var $hiddenInput = $parentTd.find("input");
        var rootSelect = document.getElementById($(element).attr("id"));
        var selectObj = new mdc.select.MDCSelect(rootSelect);

        rootSelect.addEventListener('MDCSelect:change', function () {
            $hiddenInput.val(selectObj.value);
        });
    });

     var rootSD = document.getElementById('subdireccion-js-select');
     var hiddenSD = document.getElementById('hidden-subdireccion');
     var viewSD = document.getElementById('subDir');
     var selectSD = new mdc.select.MDCSelect(rootSD);

     rootSD.addEventListener('MDCSelect:change', function() {
         hiddenSD.value = selectSD.value.split("|")[0];
         viewSD.value = selectSD.value.split("|")[1];
     });

}

function funcionCancelar(){

    window.location="/";

}
