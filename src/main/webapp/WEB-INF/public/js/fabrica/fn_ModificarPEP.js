//Funcion inicial
//Variables globales

function init(){

    initGlobal();
    crearCombos();
    asignarCombos();
    addCalendars();
    //add default values
    addMissing();
    camp();
    loadCombos()
}

function crearCombos(){

    mdc.select.MDCSelect.attachTo(document.getElementById('anio-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('area-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('banca-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('responsableDot-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('solicitante-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('estado-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('ig-js-select'));

}

function asignarCombos(){

    //Asigna los valores seleccionados a todos los combos
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

function asignMount(value){

    $('#hdAmount').val(value);

}

function funcionCancelar(){

    //Lleva a la ventana principal
    window.location="/";

}

function addCalendars(){

    $('#fechaTranspaso').datepicker({dateFormat: "dd/mm/yy"});

}

function addMissing(){

    $('#hdStatus').val(40);
    $('#hdStatusDyd').val(42);

}

function camp() {

    new mdc.textField.MDCTextField(document.getElementById('pepIdDiv-js-text')).disabled = true;
}

function loadCombos(){

    $.ajax({
        async: false,
        url: "/api/areas"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.areaId);
            $liElement.append(data.areaName);
            $("#area-js-select").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('area-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        new mdc.select.MDCSelect(document.getElementById('area-js-select')).disabled = true;
        customHolder('error', '¡Error al consultar combos!');
        showingError = true;
        $('#hidden-area').val("");
    });

    $.ajax({
        async: false,
        url: "/api/bankings"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.bankingId);
            $liElement.append(data.bankingName);
            $("#banca-js-select").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('banca-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        new mdc.select.MDCSelect(document.getElementById('banca-js-select')).disabled = true;
        customHolder('error', '¡Error al consultar combos!');
        showingError = true;
        $('#hidden-banca').val("");
    });

    $.ajax({
        async: false,
        url: "/api/corporations"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.corporationId);
            $liElement.append(data.corporationName);
            $("#estado-js-select").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('estado-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        new mdc.select.MDCSelect(document.getElementById('estado-js-select')).disabled = true;
        customHolder('error', '¡Error al consultar combos!');
        showingError = true;
        $('#hidden-estado').val("");
    });

    $.ajax({
        async: false,
        url: "/api/natures"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.natureId);
            $liElement.append(data.natureName);
            $("#ig-js-select").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('ig-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        new mdc.select.MDCSelect(document.getElementById('ig-js-select')).disabled = true;
        customHolder('error', '¡Error al consultar combos!');
        showingError = true;
        $('#hidden-ig').val("");
    });

    $.ajax({
        async: false,
        url: "/api/budgets-responsible"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.budgetsResponsibleId);
            $liElement.append(data.budgetsResponsibleName);
            $("#responsableDot-js-select").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('responsableDot-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        new mdc.select.MDCSelect(document.getElementById('responsableDot-js-select')).disabled = true;
        customHolder('error', '¡Error al consultar combos!');
        showingError = true;
        $('#hidden-responsableDot').val("");
    });

    $.ajax({
        async: false,
        url: "/api/budgets-applicants"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.budgetsApplicantId);
            $liElement.append(data.budgetsApplicantName);
            $("#solicitante-js-select").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('solicitante-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        new mdc.select.MDCSelect(document.getElementById('solicitante-js-select')).disabled = true;
        customHolder('error', '¡Error al consultar combos!');
        showingError = true;
        $('#hidden-solicitante').val("");
    });

    selectByValue(mdcSelectArea,"area-js-select",$("#hidden-area").val());
    selectByValue(mdcSelectBanking,"banca-js-select",$("#hidden-banca").val());
    selectByValue(mdcSelectEstado,"estado-js-select",$("#hidden-estado").val());
    selectByValue(mdcSelectNature,"ig-js-select",$("#hidden-ig").val());
    selectByValue(mdcSelectresponsableDot,"responsableDot-js-select",$("#hidden-responsableDot").val());
    selectByValue(mdcSelectsolicitante,"solicitante-js-select",$("#hidden-solicitante").val());

}

function selectByValue(mdcSelect, mdcSelectId,  value){
    $option = $("#"+mdcSelectId).parent().find("li[id='" + value + "']");
    mdcSelect.item($option.parent().find("li").index($option)).click();
    $(mdcSelect.label_).addClass("mdc-select__label--float-above");
}


mdcSelectArea = new mdc.select.MDCSelect($('#area-js-select')[0]);
mdcSelectBanking = new mdc.select.MDCSelect($('#banca-js-select')[0]);
mdcSelectEstado = new mdc.select.MDCSelect($('#estado-js-select')[0]);
mdcSelectNature = new mdc.select.MDCSelect($('#ig-js-select')[0]);
mdcSelectresponsableDot = new mdc.select.MDCSelect($('#responsableDot-js-select')[0]);
mdcSelectsolicitante = new mdc.select.MDCSelect($('#solicitante-js-select')[0]);
