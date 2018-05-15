function init() {
    //showH();
    initGlobal();
    holder("Cargando");
    addCalendars();
    loadSelects();
    //getVersion();
    addHiddenEvents();
    setDefaults();
    addSelectEvents();
    fillFields();
    addComponentValidation();
    //addRequirementValidation();
    //addDifficultyValidation();
    addHoursValidation();
    addButtonEvents();

    if (!showingError) {
        HoldOn.close();
    }
}

function addComponentValidation() {
    var goodDescription120 = /^^([A-Za-z0-9áéíóúñÁÉÍÓÚÑ]( )?)*$/
    $('#component-mdc-text :input')
        .data("oldValue", '')
        .bind('input propertychange', function () {
            var $this = $(this);
            var newValue = $this.val();

            if (!goodDescription120.test(newValue))
                return $this.val($this.data('oldValue'));
            return $this.data('oldValue', newValue)
        });
}

/*function addRequirementValidation() {
    var goodDescription120 = /^([A-Za-z0-9áéíóúñÁÉÍÓÚÑ]( )?)*$/
    $('#requieriment-mdc-text :input')
        .data("oldValue", '')
        .bind('input propertychange', function () {
            var $this = $(this);
            var newValue = $this.val();

            if (!goodDescription120.test(newValue))
                return $this.val($this.data('oldValue'));
            return $this.data('oldValue', newValue)
        });
}*/

/*function addDifficultyValidation() {
    var goodDifficulty = /^($|[0-4]{1}$)/
    $('#difficulty-mdc-text :input')
        .data("oldValue", '')
        .bind('input propertychange', function () {
            var $this = $(this);
            var newValue = $this.val();
            if (!goodDifficulty.test(newValue))
                return $this.val($this.data('oldValue'));
            return $this.data('oldValue', newValue)
        });
}*/

function addHoursValidation() {
    //var goodHours = /^((0?)|([1-9]{1}\d{0,3}))$/
    var goodHours = /^((0?)|([1-9]{1}\d{0,5}))(\.?|(\.[0-9]{1,2})?)$/
    $('#hours-mdc-text :input')
        .data("oldValue", '')
        .bind('input propertychange', function () {
            var $this = $(this);
            var newValue = $this.val();

            if (!goodHours.test(newValue))
                return $this.val($this.data('oldValue'));
            return $this.data('oldValue', newValue)
        });
}

function addButtonEvents() {
    $('form').on('submit', function (e) {
        e.preventDefault();
        HoldOn.open({
            theme: "sk-cube",
            content: '',
            message: 'Actualizando Componente',
            // backgroundColor: "#004582",
            backgroundColor: "#0c71ca",
            textColor: "white"
        });
        setTimeout("ajaxGuardar();", 500)
    });
    var btnDelete = document.getElementById('eliminar-btn');
    btnDelete.addEventListener("click", function () {
        HoldOn.open({
            theme: "sk-cube",
            content: '',
            message: 'Eliminando Componente',
            // backgroundColor: "#004582",
            backgroundColor: "#0c71ca",
            textColor: "white"
        });
        setTimeout("ajaxEliminar();", 500)
    });
    var btnCancel = document.getElementById('cancelar-btn');
    btnCancel.addEventListener("click", function () {
        holder("Cargando...");
        window.location.href = "/components/filters";
    });
}

function ajaxEliminar() {
    $.ajax({
        async: false,
        url: "/components/" + $("#componentId").val(),
        type: 'DELETE'
    }).done(function (json) {
        customHolder("info", "Componente Eliminado.", "document.getElementById('cancelar-btn').click()");
    }).fail(function (xhr, status, error) {
        customHolder("error", xhr.responseJSON.message)
    });
}

function ajaxGuardar() {
    var $form = $("form");
    var url = $form.attr("action");
    var formData = $($form).serializeArray();

    $.ajax({
        async: false,
        url: url,
        type: 'post',
        data: formData
    }).done(function (data) {
        customHolder("info", "Componente Modificado Exitosamente.");
    }).fail(function (xhr, status, error) {
        customHolder("error", xhr.responseJSON.message)
    });
}

function addSelectEvents(){
    var hiddenTypology = document.getElementById('finalTypology');
    rootType = document.getElementById('producto-js-select');
    rootType.addEventListener('MDCSelect:change', function () {
        //holder("Cargando...");
        cargarTipologias();
    });

    rootType = document.getElementById('tipologia-js-select');
    rootType.addEventListener('MDCSelect:change', function () {
        var typologyData = mdcSelectTipology.value.split('|');
        hiddenTypology.value = typologyData[0];
        $("#typologyEmp").val(hiddenTypology.value);
        mdcTextHours.value = typologyData[2];
        if (typologyData[1] == "F") {
            mdcTextHours.disabled = false;
        } else {
            mdcTextHours.disabled = true;
        }
        addCalendars(typologyData[3],typologyData[4]);
        $("#componentStartHours").val(typologyData[2]);
        $("#componentFinalHours").val(typologyData[2]);
        $("#componentStartCost").val(Number(typologyData[2]) * Number($("#auxFare").val()));
        $("#componentFinalCost").val($("#componentStartCost").val());
        mdcTextCost.value = Number($("#componentStartCost").val()).formatMoney(2);
    });


    rootType = document.getElementById('estatus-componente-js-select');
    rootType.addEventListener('MDCSelect:change', function () {
        $("#status").val(mdcSelectStsComponent.value);
    });


    rootType = document.getElementById('facturado-js-select');
    rootType.addEventListener('MDCSelect:change', function () {
        $("#componentForBill").val(mdcSelectBilled.value);
    });


    rootType = document.getElementById('estatus-tipificacion-js-select');
    rootType.addEventListener('MDCSelect:change', function () {
        $("#statusTypology").val(mdcSelectStsTipology.value);
    });
}

function cargarTipologias() {
    mdcSelectTipology.selectedIndex = -1;
    $("#tipologia-js-select").find("ul:first").empty();
    $.each(typologyList, function (i, data) {
        if (data.product.productId == mdcSelectProduct.value) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.typologyId + "|" + data.typologySeverity + "|" + data.typologySeverityHours + "|" + data.typologyStartDate + "|" + data.typologyFinalDate);
            $liElement.append(data.typologySeverity);
            $("#tipologia-js-select").find("ul:first").append($liElement);
        }
    });
    $("#componentFinalHours").val("");
    $("#componentFinalCost").val("");
    $("#finalTypology").val("");
    mdcTextHours.value = "";
    mdcTextCost.value = "";
    mdcTextHours.disabled = true;
    mdcTextCost.disabled = true;
    mdcSelectTipology.disabled = false;
    resetCalendars();
}

function loadSelects() {
    /*$.ajax({
        async: false,
        url: "/api/typologies/types?componentModified=false"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.typologyId + "|" + data.typologySeverity + "|" + data.typologySeverityHours + "|" + data.typologyStartDate + "|" + data.typologyFinalDate);
            $liElement.append(data.product.productName);
            $("#tipologia-news-js-select").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-news-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        new mdc.select.MDCSelect(document.getElementById('nuemod-js-select')).disabled = true;
        showingError = true;
        customHolder('error', '¡Error al consultar combos!');
    });
    $.ajax({
        async: false,
        url: "/api/typologies/types?componentModified=true"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.typologyId + "|" + data.typologySeverity + "|" + data.typologySeverityHours + "|" + data.typologyStartDate + "|" + data.typologyFinalDate);
            $liElement.append(data.product.productName);
            $("#tipologia-mods-js-select").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-mods-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        new mdc.select.MDCSelect(document.getElementById('nuemod-js-select')).disabled = true;
        showingError = true;
        customHolder('error', '¡Error al consultar combos!');
    });*/
    $.ajax({
        async: false,
        url: "/api/products"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            if(data.technology.technologyId == $("#auxTechnology").val()) {
                $liElement = $("<li>");
                $liElement.attr("class", "mdc-list-item");
                $liElement.attr("role", "option");
                $liElement.attr("id", data.productId);
                $liElement.append(data.productName);
                $("#producto-js-select").find("ul:first").append($liElement);
            }
        });
        //mdc.select.MDCSelect.attachTo(document.getElementById('producto-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        mdcSelectProduct.disabled = true;
        showingError = true;
        customHolder('error', '¡Error al consultar combos!');
    });
    var modificados="";
    if($("#nuemod").val() == "Nuevo")
        modificados="false";
    if($("#nuemod").val() == "Modificado")
        modificados="true";
    $.ajax({
        async: false,
        url: "/api/typologies/types?componentModified=" +modificados
    }).done(function (json) {
        typologyList = json.data;
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        mdcSelectTipology.disabled = true;
        showingError = true;
        customHolder('error', '¡Error al consultar combos!');
        controllerTypologies = false;
    });
    $.ajax({
        async: false,
        url: "/api/status-types/3/status"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.statusId);
            $liElement.append(data.statusName);
            $("#estatus-tipificacion-js-select").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('estatus-tipificacion-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        new mdc.select.MDCSelect(document.getElementById('estatus-tipificacion-js-select')).disabled = true;
        customHolder('error', '¡Error al consultar combos!');
        showingError = true;
        $('#statusTypology').val("");
    });
    $.ajax({
        async: false,
        url: "/api/status-types/8/status"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.statusId);
            $liElement.append(data.statusName);
            $("#estatus-componente-js-select").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('estatus-componente-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        new mdc.select.MDCSelect(document.getElementById('estatus-componente-js-select')).disabled = true;
        customHolder('error', '¡Error al consultar combos!');
        showingError = true;
        $('#status').val("");
    });
}

function fillFields(){
    currentTypology = typologyList.find(x => x.typologyId == savedFinalTypology);
    selectByValue(mdcSelectProduct,"producto-js-select",currentTypology.product.productId);
    setTimeout('selectLikeValue(mdcSelectTipology,"tipologia-js-select",savedFinalTypology);',100);
    setTimeout('fieldsDown();',300);
}

function fieldsDown() {
    $("#componentFinalHours").val(savedComponentFinalHours);
    mdcTextHours.value = savedComponentFinalHours;
    $("#componentFinalCost").val(savedComponentFinalCost);
    mdcTextCost.value = savedComponentFinalCost;
    $("#componentDesignRealDeliverDate").val(savedComponentDesignRealDeliverDate);
    mdcTextFecRealCFG.value = savedComponentDesignRealDeliverDate;
    $("#componentPreviewDeliverDate").val(savedComponentPreviewDeliverDate);
    mdcTextFecPreFac.value = savedComponentPreviewDeliverDate;
    $("#componentPossibleDeliverDate").val(savedComponentPossibleDeliverDate);
    mdcTextFecNegFac.value = savedComponentPossibleDeliverDate;
    $("#componentRealDeliverDate").val(savedComponentRealDeliverDate);
    mdcTextFecRealFac.value = savedComponentRealDeliverDate;
    mdcTextDesc.value = $("#componentTypoComment").val();
    selectByValue(mdcSelectStsComponent,"estatus-componente-js-select",$("#status").val());
    selectByValue(mdcSelectStsTipology,"estatus-tipificacion-js-select",$("#statusTypology").val());
    selectByValue(mdcSelectBilled,"facturado-js-select",Number(($("#componentForBill").val() == 'true')));
}

function selectByValue(mdcSelect, mdcSelectId,  value){
    $option = $("#"+mdcSelectId).parent().find("li[id='" + value + "']");
    mdcSelect.item($option.parent().find("li").index($option)).click();
    $(mdcSelect.label_).addClass("mdc-select__label--float-above");
}

function selectLikeValue(mdcSelect, mdcSelectId,  value){
    $option = $("#"+mdcSelectId).parent().find("li[id^='" + value + "']");
    mdcSelect.item($option.parent().find("li").index($option)).click();
    $(mdcSelect.label_).addClass("mdc-select__label--float-above");
}

function setDefaults() {
    mdcTextHours.value = "";
    mdcTextCost.value = "";
    mdcTextRequirement.value = mdcTextRequirement.value;
    mdcTextHours.disabled = true;
    mdcTextCost.disabled = true;
    mdcTextRequirement.disabled = true;
    mdcTextFecRealCFG.disabled = true;
    mdcTextFecPreFac.disabled = true;
    mdcTextFecNegFac.disabled = true;
    mdcTextFecRealFac.disabled = true;
    mdcTextVersion.disabled = true;
    //mdcSelectTipology.disabled = true;
    //mdcSelectProduct.disabled = true;
}

function addHiddenEvents() {
    addTextSyncMdcToHtml("componentName", "component-mdc-text", mdcTextComponent);
    addTextSyncMdcToHtml("componentVersion", "version-mdc-text", mdcTextVersion);
    addTextSyncMdcToHtml("componentTypoComment", "descripcion-mdc-text", mdcTextDesc);
    addHoursSyncMdcToHtml("componentStartHours", "hours-mdc-text", mdcTextHours);
    addHoursSyncMdcToHtml("componentFinalHours", "hours-mdc-text", mdcTextHours);
    addDateSyncMdcToHtml("componentDesignRealDeliverDate", "FecRealCFG-mdc-text", mdcTextFecRealCFG);
    addDateSyncMdcToHtml("componentPreviewDeliverDate", "FecPreFac-mdc-text", mdcTextFecPreFac);
    addDateSyncMdcToHtml("componentPossibleDeliverDate", "FecNegFac-mdc-text", mdcTextFecNegFac);
    addDateSyncMdcToHtml("componentRealDeliverDate", "FecRealFac-mdc-text", mdcTextFecRealFac);
    $("#requirement").val($("#requirementHidden").val());
}

function addTextSyncMdcToHtml(htmlField, mdcFieldName, mdcField) {
    var rootName = document.getElementById(mdcFieldName);
    var inputName = rootName.querySelector('input');
    var hiddenName = document.getElementById(htmlField);
    var textName = mdcField;
    textName.value = textName.value;

    inputName.addEventListener('keyup', function () {
        hiddenName.value = textName.value;
    });
    inputName.addEventListener('change', function () {
        hiddenName.value = textName.value;
    });
    inputName.addEventListener('blur', function () {
        hiddenName.value = textName.value;
    });
}

function addHoursSyncMdcToHtml(htmlField, mdcFieldName, mdcField) {
    var rootName = document.getElementById(mdcFieldName);
    var inputName = rootName.querySelector('input');
    var hiddenName = document.getElementById(htmlField);
    var textName = mdcField;
    textName.value = textName.value;

    inputName.addEventListener('keyup', function () {
        hiddenName.value = textName.value;
        changeHours();
    });
    inputName.addEventListener('change', function () {
        hiddenName.value = textName.value;
        changeHours();
    });
    inputName.addEventListener('blur', function () {
        hiddenName.value = textName.value;
        changeHours();
    });
}

function addDateSyncMdcToHtml(htmlField, mdcFieldName, mdcField) {
    var rootName = document.getElementById(mdcFieldName);
    var inputName = rootName.querySelector('input');
    var hiddenName = document.getElementById(htmlField);
    var textName = mdcField;
    $(inputName).change(function () {
        hiddenName.value = textName.value;
        if ("" != textName.value) {
            $("#" + mdcFieldName + " > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#" + mdcFieldName + " > label").removeClass("mdc-text-field__label--float-above");
        }
    });
}

function showH() {
    document.getElementById('EstadoLinea').style.display = 'inline';
}

function addCalendars(min, max) {
    if(min === null || min === "null"){
        min = null;
    } else {
        min = new Date(Number(min));
    }
    if(max === null || max === "null"){
        max = null;
    } else {
        max = new Date(Number(max));
    }
    resetCalendars();
    mdcTextFecRealCFG.disabled = false;
    mdcTextFecPreFac.disabled = false;
    mdcTextFecNegFac.disabled = false;
    mdcTextFecRealFac.disabled = false;

    $('#FecRealCFG').datepicker({
        dateFormat: "dd/mm/yy",
        minDate: min,
        maxDate: max
    });

    $('#FecPreFac').datepicker({
        dateFormat: "dd/mm/yy",
        minDate: min,
        maxDate: max
    });

    $('#FecNegFac').datepicker({
        dateFormat: "dd/mm/yy",
        minDate: min,
        maxDate: max
    });

    $('#FecRealFac').datepicker({
        dateFormat: "dd/mm/yy",
        minDate: min,
        maxDate: max
    });
}

function resetCalendars() {
    mdcTextFecRealCFG.value = "";
    $("#componentDesignRealDeliverDate").val("");
    mdcTextFecRealCFG.disabled = true;
    mdcTextFecPreFac.value = "";
    $("#componentPreviewDeliverDate").val("");
    mdcTextFecPreFac.disabled = true;
    mdcTextFecNegFac.value = "";
    $("#componentPossibleDeliverDate").val("");
    mdcTextFecNegFac.disabled = true;
    mdcTextFecRealFac.value = "";
    $("#componentRealDeliverDate").val("");
    mdcTextFecRealFac.disabled = true;

    $('#FecRealCFG').datepicker("destroy");
    $('#FecPreFac').datepicker("destroy");
    $('#FecNegFac').datepicker("destroy");
    $('#FecRealFac').datepicker("destroy");
}

function holder(msg) {
    HoldOn.open({
        theme: "sk-cube",
        content: '',
        message: msg,
        // backgroundColor: "#004582",
        backgroundColor: "#0c71ca",
        textColor: "white",
    });
}

Number.prototype.formatMoney = function (c, d, t) {
    var n = this,
        c = isNaN(c = Math.abs(c)) ? 2 : c,
        d = d == undefined ? "." : d,
        t = t == undefined ? "," : t,
        s = n < 0 ? "-" : "",
        i = String(parseInt(n = Math.abs(Number(n) || 0).toFixed(c))),
        j = (j = i.length) > 3 ? j % 3 : 0;
    return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
};

var showingError = false;
var okData = null;

var typologyList = null;

var changeHours = function () {
    $("#componentFinalCost").val(Number($("#componentStartHours").val()) * Number($("#auxFare").val()));
    mdcTextCost.value = Number($("#componentFinalCost").val()).formatMoney(2);
}

savedComponentFinalCost = $("#componentFinalCost").val();
savedComponentFinalHours = $("#componentFinalHours").val();
savedComponentDesignRealDeliverDate = $("#componentDesignRealDeliverDate").val();
savedComponentPreviewDeliverDate = $("#componentPreviewDeliverDate").val();
savedComponentPossibleDeliverDate = $("#componentPossibleDeliverDate").val();
savedComponentRealDeliverDate = $("#componentRealDeliverDate").val();
savedFinalTypology = $("#finalTypology").val();

mdcTextComponent = new mdc.textField.MDCTextField($('#component-mdc-text')[0]);
mdcTextVersion = new mdc.textField.MDCTextField($('#version-mdc-text')[0]);
mdcTextRequirement = new mdc.textField.MDCTextField($('#requieriment-mdc-text')[0]);
mdcTextHours = new mdc.textField.MDCTextField($('#hours-mdc-text')[0]);
mdcTextCost = new mdc.textField.MDCTextField($('#cost-mdc-text')[0]);
mdcTextFecRealCFG = new mdc.textField.MDCTextField($('#FecRealCFG-mdc-text')[0]);
mdcTextFecPreFac = new mdc.textField.MDCTextField($('#FecPreFac-mdc-text')[0]);
mdcTextFecNegFac = new mdc.textField.MDCTextField($('#FecNegFac-mdc-text')[0]);
mdcTextFecRealFac = new mdc.textField.MDCTextField($('#FecRealFac-mdc-text')[0]);
mdcTextDesc = new mdc.textField.MDCTextField($('#descripcion-mdc-text')[0]);
mdcSelectProduct = new mdc.select.MDCSelect($('#producto-js-select')[0]);
mdcSelectTipology = new mdc.select.MDCSelect($('#tipologia-js-select')[0]);
mdcSelectStsTipology = new mdc.select.MDCSelect($('#estatus-tipificacion-js-select')[0]);
mdcSelectStsComponent = new mdc.select.MDCSelect($('#estatus-componente-js-select')[0]);
mdcSelectBilled = new mdc.select.MDCSelect($('#facturado-js-select')[0]);

new mdc.textField.MDCTextField($('#level-superior-mdc-text')[0]).disabled = true;
new mdc.textField.MDCTextField($('#level-mdc-text')[0]).disabled = true;
new mdc.textField.MDCTextField($('#company-mdc-text')[0]).disabled = true;
new mdc.textField.MDCTextField($('#technology-mdc-text')[0]).disabled = true;
new mdc.textField.MDCTextField($('#nuemod-mdc-text')[0]).disabled = true;
new mdc.textField.MDCTextField($('#typology-inicio-mdc-text')[0]).disabled = true;
new mdc.textField.MDCTextField($('#difficulty-inicio-mdc-text')[0]).disabled = true;
new mdc.textField.MDCTextField($('#hours-inicio-mdc-text')[0]).disabled = true;
new mdc.textField.MDCTextField($('#cost-inicio-mdc-text')[0]).disabled = true;

