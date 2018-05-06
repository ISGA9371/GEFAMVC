function init() {
    //showH();
    initGlobal();
    $("#statusTypology").val(8);
    $("#status").val(31);
    holder("Cargando");
    addCalendars();
    loadSelects();
    getVersion();
    addHiddenEvents();
    setDefaults();
    addSelectEvents();
    addComponentValidation();
    //addRequirementValidation();
    addDifficultyValidation();
    addHoursValidation();
    addButtonEvents();

    if (!showingError) {
        HoldOn.close();
    }
}

function getVersion() {
    var rootVersion = document.getElementById('version-mdc-text');
    var textVersion = new mdc.textField.MDCTextField(rootVersion);

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

    textVersion.value = today;
    $('#componentVersion').val(textVersion.value);
    textVersion.disabled = true;
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

function addDifficultyValidation() {
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
}

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
            message: 'Registrando Componente',
            // backgroundColor: "#004582",
            backgroundColor: "#0c71ca",
            textColor: "white"
        });
        setTimeout("ajaxGuardar();", 500)
    });
    var btnCancel = document.getElementById('cancelar-btn');
    btnCancel.addEventListener("click", function () {
        holder("Cargando...");
        window.location.href = "/requirements/" + $("#requirement").val();
    })
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
        customHolder("info", "Componente Dado de Alta Exitosamente.", "window.location.href = '/components/" + $(data).find("#componentId").val() + "'; holder('Cargando...')");
        //customHolder("info", "Componente Dado de Alta Exitosamente.","$('html').html(okData);");
    }).fail(function (xhr, status, error) {
        customHolder("error", xhr.respo.message)
    });
}

function addSelectEvents() {
    var hiddenTypology = document.getElementById('typology');
    var rootType = document.getElementById('nuemod-js-select');
    var selectType = new mdc.select.MDCSelect(rootType);

    rootType.addEventListener('MDCSelect:change', function () {
        $("#componentNewMod").val(selectType.value);
        if (selectType.value == 0) {
            $('#tipologia-empty-js-select').hide();
            new mdc.select.MDCSelect(document.getElementById('tipologia-news-js-select')).selectedIndex = -1;
            $('#tipologia-news-js-select').show();
            $('#tipologia-mods-js-select').hide();
        }
        if (selectType.value == 1) {
            $('#tipologia-empty-js-select').hide();
            new mdc.select.MDCSelect(document.getElementById('tipologia-mods-js-select')).selectedIndex = -1;
            $('#tipologia-news-js-select').hide();
            $('#tipologia-mods-js-select').show();
        }
        hiddenTypology.value = new mdc.select.MDCSelect(document.getElementById('tipologia-news-js-select')).value;
        $("#typologyEmp").val(hiddenTypology.value);
        new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value = "";
        new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value = "";
    });

    var rootNews = document.getElementById('tipologia-news-js-select');
    var selectNews = new mdc.select.MDCSelect(rootNews);

    rootNews.addEventListener('MDCSelect:change', function () {
        if (selectNews.value != "") {
            var splittedNews = selectNews.value.split('|');
            hiddenTypology.value = splittedNews[0];
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value = splittedNews[1];
            new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value = splittedNews[2];
            if (splittedNews[1] == "F") {
                new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).disabled = false;
            } else {
                new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).disabled = true;
            }
            $("#componentStartHours").val(splittedNews[2]);
            $("#componentFinalHours").val(splittedNews[2]);
            $("#componentStartCost").val(Number(splittedNews[2]) * Number($("#auxFare").val()));
            $("#componentFinalCost").val($("#componentStartCost").val());
            new mdc.textField.MDCTextField(document.getElementById("cost-mdc-text")).value = Number($("#componentStartCost").val()).formatMoney(2);
        } else {
            hiddenTypology.value = "";
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value = "";
            $("#componentStartHours").val("");
            $("#componentFinalHours").val("");
            new mdc.textField.MDCTextField(document.getElementById("cost-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).disabled = true;
        }
    });

    var rootMods = document.getElementById('tipologia-mods-js-select');
    var selectMods = new mdc.select.MDCSelect(rootMods);

    rootMods.addEventListener('MDCSelect:change', function () {
        if (selectMods.value != "") {
            var splittedMods = selectMods.value.split('|');
            hiddenTypology.value = splittedMods[0];
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value = splittedMods[1];
            new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value = splittedMods[2];
            if (splittedMods[1] == "F") {
                new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).disabled = false;
            } else {
                new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).disabled = true;
            }
            $("#componentStartHours").val(splittedMods[2]);
            $("#componentFinalHours").val(splittedMods[2]);
            $("#componentStartCost").val(Number(splittedMods[2]) * Number($("#auxFare").val()));
            $("#componentFinalCost").val($("#componentStartCost").val());
            new mdc.textField.MDCTextField(document.getElementById("cost-mdc-text")).value = Number($("#componentStartCost").val()).formatMoney(2);
        } else {
            hiddenTypology.value = "";
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value = "";
            $("#componentStartHours").val("");
            $("#componentFinalHours").val("");
            new mdc.textField.MDCTextField(document.getElementById("cost-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).disabled = true;
        }
    });
}

function loadSelects() {
    mdc.select.MDCSelect.attachTo(document.getElementById('nuemod-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-empty-js-select'));
    $.ajax({
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
    });
}

function setDefaults() {
    $('#tipologia-empty-js-select').show();
    new mdc.select.MDCSelect(document.getElementById('tipologia-empty-js-select')).disabled = true;
    $('#tipologia-news-js-select').hide();
    $('#tipologia-mods-js-select').hide();
    new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value = "";
    new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value = "";
    new mdc.textField.MDCTextField(document.getElementById("cost-mdc-text")).value = "";
    new mdc.textField.MDCTextField(document.getElementById("requieriment-mdc-text")).value = new mdc.textField.MDCTextField(document.getElementById("requieriment-mdc-text")).value;
    new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("cost-mdc-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("requieriment-mdc-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("FecRealCFG")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("FecPreFac")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("FecNegFac")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("FecRealFac")).disabled = true;
}

function addHiddenEvents() {
    addTextSyncMdcToHtml("componentName", "component-mdc-text");
    addTextSyncMdcToHtml("componentVersion", "version-mdc-text");
    addHoursSyncMdcToHtml("componentStartHours", "hours-mdc-text");
    addHoursSyncMdcToHtml("componentFinalHours", "hours-mdc-text");
    addDateSyncMdcToHtml("componentDesignRealDeliverDate", "FecRealCFG-mdc-text");
    addDateSyncMdcToHtml("componentPreviewDeliverDate", "FecPreFac-mdc-text");
    addDateSyncMdcToHtml("componentPossibleDeliverDate", "FecNegFac-mdc-text");
    addDateSyncMdcToHtml("componentRealDeliverDate", "FecRealFac-mdc-text")
    $("#requirement").val($("#requirementHidden").val());
}

function addTextSyncMdcToHtml(htmlField, mdcField) {
    var rootName = document.getElementById(mdcField);
    var inputName = rootName.querySelector('input');
    var hiddenName = document.getElementById(htmlField);
    var textName = new mdc.textField.MDCTextField(rootName);
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

function addHoursSyncMdcToHtml(htmlField, mdcField) {
    var rootName = document.getElementById(mdcField);
    var inputName = rootName.querySelector('input');
    var hiddenName = document.getElementById(htmlField);
    var textName = new mdc.textField.MDCTextField(rootName);
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

function addDateSyncMdcToHtml(htmlField, mdcField) {
    var rootName = document.querySelector('#' + mdcField);
    var inputName = rootName.querySelector('input');
    var hiddenName = document.getElementById(htmlField);
    var textName = new mdc.textField.MDCTextField(rootName);
    $(inputName).change(function () {
        hiddenName.value = textName.value;
        if ("" != textName.value) {
            $("#" + mdcField + " > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#" + mdcField + " > label").removeClass("mdc-text-field__label--float-above");
        }
    });
}

function showH() {
    document.getElementById('EstadoLinea').style.display = 'inline';
}

function addCalendars(min, max) {
    new mdc.textField.MDCTextField(document.getElementById("FecRealCFG")).disabled = false;
    new mdc.textField.MDCTextField(document.getElementById("FecPreFac")).disabled = false;
    new mdc.textField.MDCTextField(document.getElementById("FecNegFac")).disabled = false;
    new mdc.textField.MDCTextField(document.getElementById("FecRealFac")).disabled = false;
    $('#FecRealCFG').datepicker("destroy");
    $('#FecRealCFG').datepicker({
        dateFormat: "dd/mm/yy",
        minDate: min,
        maxDate: max
    });

    $('#FecPreFac').datepicker("destroy");
    $('#FecPreFac').datepicker({
        dateFormat: "dd/mm/yy",
        minDate: min,
        maxDate: max
    });

    $('#FecNegFac').datepicker("destroy");
    $('#FecNegFac').datepicker({
        dateFormat: "dd/mm/yy",
        minDate: min,
        maxDate: max
    });

    $('#FecRealFac').datepicker("destroy");
    $('#FecRealFac').datepicker({
        dateFormat: "dd/mm/yy",
        minDate: min,
        maxDate: max
    });
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

var changeHours = function () {
    $("#componentStartCost").val(Number($("#componentStartHours").val()) * Number($("#auxFare").val()));
    $("#componentFinalCost").val($("#componentStartCost").val());
    new mdc.textField.MDCTextField(document.getElementById("cost-mdc-text")).value = Number($("#componentStartCost").val()).formatMoney(2);
}