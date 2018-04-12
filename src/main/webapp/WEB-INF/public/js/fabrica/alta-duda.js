function init() {
    //showH();
    //initGlobal();
    addCalendars();
    loadSelects();
    //getVersion();
    //addHiddenEvents();
    //setDefaults();
    //addSelectEvents();
    //addComponentValidation();
    //addRequirementValidation();
    //addDifficultyValidation();
    //addHoursValidation();
    addButtonEvents();

    $("#hidden-status").val("11");
    $("#hidden-doubtType").val("13");
    $("#hidden-envcomponente").val($("#hidden-componente").val());


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

function loadSelects() {
    mdc.select.MDCSelect.attachTo(document.getElementById('Prioridad-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('Duda-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('responsable-js-select'));
}

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