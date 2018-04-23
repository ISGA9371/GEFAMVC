function init() {
    loadSelects();
    addButtonEvents();

    $("#hidden-envcomponente").val($("#hidden-componente").val());

    var fecha=$("#datetimepicker").val();
    var dia = fecha.substring(8,10);
    var mes = fecha.substring(5,7);
    var anio = fecha.substring(0,4);
    $("#datetimepickerformat").val(dia+"/"+mes+"/"+anio);

}

$(function () {
    $('#datetimepicker4').datetimepicker({
        format: 'DD/MM/YYYY'
    });
});

function addButtonEvents() {
    var btnCancel = document.getElementById('cancelar-btn');
    btnCancel.addEventListener("click", function () {
        holder("Cargando...");
        window.location.href = "/components/filters";
    })
}

function loadSelects() {
    mdc.select.MDCSelect.attachTo(document.getElementById('Prioridad-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('Origen-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('Estado-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('responsable-js-select'));
}

function holder(msg){
    HoldOn.open({
        theme: "sk-cube",
        content: '',
        message: msg,
        // backgroundColor: "#004582",
        backgroundColor: "#0c71ca",
        textColor: "white",
    });
}

demoReady(function() {
    var rootEst = document.getElementById('Prioridad-js-select');
    var hiddenEst = document.getElementById('hidden-prioridad');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});
demoReady(function() {
    var rootEst = document.getElementById('Estado-js-select');
    var hiddenEst = document.getElementById('hidden-estado');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});
demoReady(function() {
    var rootEst = document.getElementById('Origen-js-select');
    var hiddenEst = document.getElementById('Origen-js-select2');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});
demoReady(function() {
    var rootEst = document.getElementById('responsable-js-select');
    var hiddenEst = document.getElementById('hidden-responsable');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});