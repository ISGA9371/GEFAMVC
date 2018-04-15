

function init() {

    initGlobal();
    crearCombos();
    asignarCombos();
    addCalendars();
    addMissing();


}

function crearCombos() {

    mdc.select.MDCSelect.attachTo(document.getElementById('DifMod-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('prioridad-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('origen-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('modvuelo-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('moddyd-js-select'));
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

        $('#datetimepicker4').datetimepicker({
            format: 'DD/MM/YYYY'
        });

        $('#datetimepicker5').datetimepicker({
            format: 'DD/MM/YYYY'
        });

        $('#datetimepicker6').datetimepicker({
            format: 'DD/MM/YYYY'
        });


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
