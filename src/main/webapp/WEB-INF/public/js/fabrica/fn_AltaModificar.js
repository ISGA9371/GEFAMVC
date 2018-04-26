

function init() {

    initGlobal();
    crearCombos();
    asignarCombos();
    addCalendars();
    addMissing();
    addButtonEvents();


}

function crearCombos() {

    mdc.select.MDCSelect.attachTo(document.getElementById('DifMod-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('prioridad-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('origen-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('modvuelo-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('moddyd-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('responsable-js-select'));
}

function asignarCombos (){

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

function addCalendars() {

    type="text/javascript">

        /**
         * datepicker
         * dateFormat: "dd-mm-yy"
         */


    $('#componentPreviewDeliverDate').datepicker({
        dateFormat: "dd/mm/yy"
    });

    $('#componentPossibleDeliverDate').datepicker({
        dateFormat: "dd/mm/yy"
    });

    $('#componentRealDeliverDate').datepicker({
        dateFormat: "dd/mm/yy"
    });

    var numberMonths = ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'];


}

function addMissing() {

    $("#hidden-status").val("5");

    $("#hidden-modificationStatus").val("5");

    $("#hidden-comp").val( $("#hidden-envcomponente").val());

    $("#hidden-startTyp").val($("#hidden-startTypology").val());

    $("#hidden-finalTyp").val($("#hidden-finalTypology").val());

    $("#hidden-status").val($("#hidden-modificationStatus").val());

    $("#hidden-userre").val("XMY3080");


}

function addButtonEvents() {
    var btnCancel = document.getElementById('cancelar-btn');
    btnCancel.addEventListener("click", function () {
        holder("Cargando...");
        window.location.href = "/components/filters";
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
