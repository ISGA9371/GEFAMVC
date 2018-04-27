

function init() {

    initGlobal();
    addCalendars();
    addButtonEvents();
    camp();


}

function addCalendars() {

    $('#fechaNeg').datepicker({dateFormat: "dd/mm/yy"});
    $('#fechaReal').datepicker({dateFormat: "dd/mm/yy"});
    $('#fechaEnvio').datepicker({dateFormat: "dd/mm/yy"});
    var fechaNeg = new mdc.textField.MDCTextField(document.querySelector('#mdc-fechaNeg'));

    $("#fechaNeg").change(function () {
        if ("" != fechaNeg.value) {
            $("#mdc-fechaNeg > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#mdc-fechaNeg > label").removeClass("mdc-text-field__label--float-above");
        }
    });
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
