function init() {
    loadSelects();
    loadSelects2();
    addButtonEvents();
    camp();

    $("#hidden-envcomponente").val($("#hidden-componente").val());

    //$("#hidden-responsable").val($("#responsabletxt").val());
    $("#responsabletxt").val("XMY3080");
    $("#hidden-responsable").val("XMY3080");

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
    mdc.select.MDCSelect.attachTo(document.getElementById('Estado-js-select'));
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

function camp() {
    new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("subdireccon")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Versi")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Requerimiento")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Tecnologia")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Peticionario-js-text")).disabled = true;
}


function loadSelects2() {
    const prioridad = new mdc.select.MDCSelect(document.querySelector('#prioridad'));
    $.ajax({
        url: "/api/prioritys"
    }).done(function(data) {
        let subs = data.data;
        $("#prioridad-sel-text").html("");
        prioridad.selectedIndex = -1;
        prioridad.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#prioridad-select").html("");
            $.each(subs, function( index, value ) {
                $("#prioridad-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.priorityId+"' value='"+value.priorityId+"'>"+value.priorityName+"</li>");
            });
        }else $("#prioridad-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
    });

    const origen = new mdc.select.MDCSelect(document.querySelector('#Origen-js-select'));
    $.ajax({
        url: "/api/origins"
    }).done(function(data) {
        let subs = data.data;
        $("#Origen-sel-text").html("");
        origen.selectedIndex = -1;
        origen.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#Origen-select").html("");
            $.each(subs, function( index, value ) {
                $("#Origen-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.originId+"' value='"+value.originId+"'>"+value.originName+"</li>");
            });
        }else $("#Origen-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
    });

}
