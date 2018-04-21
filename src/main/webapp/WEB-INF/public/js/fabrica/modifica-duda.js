function init() {

    addCalendars();
   // loadSelects();
    addButtonEvents();

    $("#hidden-status").val("11");
    $("#hidden-doubtType").val("13");
    $("#hidden-envcomponente").val($("#hidden-componente").val());
    //$("#descripcion").val($("#hidden-descri").val());


    var fecha=$("#datetimepicker").val();
    var dia = fecha.substring(8,10);
    var mes = fecha.substring(5,7);
    var anio = fecha.substring(0,4);
    $("#datetimepickerformat").val(dia+"/"+mes+"/"+anio);

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;

    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }
    var today = 'v' + yyyy + mm + dd;

    $('#doubtVersion').val(today);

}
/*
function loadSelects() {
    mdc.select.MDCSelect.attachTo(document.getElementById('Prioridad-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('Duda-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('responsable-js-select'));
}*/

function addCalendars() {
    $('#FecRealCFG').datetimepicker({
        format: 'DD/MM/YYYY',
        widgetPositioning: {
            horizontal: 'auto',
            vertical: 'top'
        }
    });
}

function addButtonEvents() {
    var btnCancel = document.getElementById('cancelar-btn');
    btnCancel.addEventListener("click", function () {
        window.history.back();
    })
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
    var rootEst = document.getElementById('responsable-js-select');
    var hiddenEst = document.getElementById('hidden-responsable');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});

demoReady(function() {
    var rootEst = document.getElementById('Duda-js-select');
    var hiddenEst = document.getElementById('hidden-dudaSelect');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});
