

function init() {

    initGlobal();
    crearCombos();
    asignarCombos();
    addCalendars();
    addMissing();
    addButtonEvents();
    camp();


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

    $('#fechaNeg').datepicker({dateFormat: "dd/mm/yy"});
    $('#fechaReal').datepicker({dateFormat: "dd/mm/yy"});
    $('#fechaEnvio').datepicker({dateFormat: "dd/mm/yy"});
    var fechaNeg = new mdc.textField.MDCTextField(document.querySelector('#mdc-fechaNeg'));
    var fechaReal = new mdc.textField.MDCTextField(document.querySelector('#mdc-fechaReal'));
    var fechaEnvio = new mdc.textField.MDCTextField(document.querySelector('#mdc-fechaEnvio'));

    $("#fechaNeg").change(function () {
        if ("" != fechaNeg.value) {
            $("#mdc-fechaNeg > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#mdc-fechaNeg > label").removeClass("mdc-text-field__label--float-above");
        }
    });
    $("#fechaReal").change(function () {
        if ("" != fechaReal.value) {
            $("#mdc-fechaReal > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#mdc-fechaReal > label").removeClass("mdc-text-field__label--float-above");
        }
    });

    $("#fechaEnvio").change(function () {
        if ("" != fechaEnvio.value) {
            $("#mdc-fechaEnvio > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#mdc-fechaEnvio > label").removeClass("mdc-text-field__label--float-above");
        }
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

function camp() {
    new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("subdireccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("version-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("requerimiento-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tecnologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tipologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("dificultad-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("estado-js-text")).disabled = true;
}
