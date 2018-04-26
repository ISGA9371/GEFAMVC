function init() {
    camp();
    addButtonEvents();

    $("#hidden-envcomponente").val($("#hidden-componente").val());

    var fecha=$("#datetimepicker").val();
    var dia = fecha.substring(8,10);
    var mes = fecha.substring(5,7);
    var anio = fecha.substring(0,4);
    $("#datetimepickerformat").val(dia+"/"+mes+"/"+anio);



}

function rojelia(){
    var descrip = $('#descripcion2').val();
    var descri = $('#descripcion').val();
    var des = $('#desfijo').val();

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

    $('#desfijo').val(descri + " - inicial - " + descrip + " - "+ dd+"/"+mm+"/"+yyyy);
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

/*function loadSelects() {
    mdc.select.MDCSelect.attachTo(document.getElementById('Prioridad-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('Origen-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('Estado-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('responsable-js-select'));
}*/

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

/*demoReady(function() {
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
});*/

function camp() {
    new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Subdireccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Version-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Requerimiento")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Tecnologia")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Prioridad")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Peticionario")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Origen")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Incidencia")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
}
