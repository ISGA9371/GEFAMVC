function init() {
    //showH();
    addCalendars();
    loadSelects();
    fillFields();
    addHiddenEvents();
    defaultTypologies();
    addSelectEvents();
    addComponentValidation();
    //addRequirementValidation();
    addDifficultyValidation();
    addHoursValidation();
    addButtonEvents();

    $("#statusTypology").val(3);
    $("#status").val(3);
}

function fillFields() {
    new mdc.textField.MDCTextField(document.getElementById('component-mdc-text')).value = $('#componentName').val();
    new mdc.textField.MDCTextField(document.getElementById('version-mdc-text')).value = $('#componentVersion').val();
    var d = new Date($('#componentDesignRealDeliverDate').val());
    $('#componentDesignRealDeliverDate').val(pad(d.getDate(),2) + "/" + pad(d.getMonth()+1,2) + "/" + d.getFullYear());
    new mdc.textField.MDCTextField(document.getElementById('FecRealCFG-mdc-text')).value = $('#componentDesignRealDeliverDate').val();
    var d = new Date($('#componentPreviewDeliverDate').val());
    $('#componentPreviewDeliverDate').val(pad(d.getDate(),2) + "/" + pad(d.getMonth()+1,2) + "/" + d.getFullYear());
    new mdc.textField.MDCTextField(document.getElementById('FecPreFac-mdc-text')).value = $('#componentPreviewDeliverDate').val();
    var d = new Date($('#componentPossibleDeliverDate').val());
    $('#componentPossibleDeliverDate').val(pad(d.getDate(),2) + "/" + pad(d.getMonth()+1,2) + "/" + d.getFullYear());
    new mdc.textField.MDCTextField(document.getElementById('FecNegFac-mdc-txt')).value = $('#componentPossibleDeliverDate').val();
    var d = new Date($('#componentRealDeliverDate').val());
    $('#componentRealDeliverDate').val(pad(d.getDate(),2) + "/" + pad(d.getMonth()+1,2) + "/" + d.getFullYear());
    new mdc.textField.MDCTextField(document.getElementById('FecRealFac-mdc-text')).value = $('#componentRealDeliverDate').val();
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
    var goodHours = /^((0?)|([1-9]{1}\d{0,2}))(\.?|(\.[1-9]{1,2})?)$/
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
    var btnCancel = document.getElementById('cancelar-btn');
    btnCancel.addEventListener("click", function () {
        window.history.back();
    });
}

function addSelectEvents() {

    var hiddenTypology = document.getElementById('typology-final');
    var rootType = document.getElementById('nuemod-js-select');
    var selectType = new mdc.select.MDCSelect(rootType);

    rootType.addEventListener('MDCSelect:change', function () {
        $("#componentNewMod").val(selectType.value);
        if (selectType.value == 0) {
            $('#tipologia-final-empty-js-select').hide();
            new mdc.select.MDCSelect(document.getElementById('tipologia-final-news-js-select')).selectedIndex = -1;
            $('#tipologia-final-news-js-select').show();
            $('#tipologia-final-mods-js-select').hide();
        }
        if (selectType.value == 1) {
            $('#tipologia-final-empty-js-select').hide();
            new mdc.select.MDCSelect(document.getElementById('tipologia-final-mods-js-select')).selectedIndex = -1;
            $('#tipologia-final-news-js-select').hide();
            $('#tipologia-final-mods-js-select').show();
        }
        hiddenTypology.value = new mdc.select.MDCSelect(document.getElementById('tipologia-final-news-js-select')).value;
        $("#typologyEmp").val(hiddenTypology.value);
        new mdc.textField.MDCTextField(document.getElementById("difficulty-final-mdc-text")).value="";
        new mdc.textField.MDCTextField(document.getElementById("hours-final-mdc-text")).value="";
    });

    var rootNews = document.getElementById('tipologia-news-js-select');
    var selectNews = new mdc.select.MDCSelect(rootNews);

    rootNews.addEventListener('MDCSelect:change', function () {
        if (selectNews.value.match(/\|/g).length == 2) {
            var splittedNews = selectNews.value.split('|');
            hiddenTypology.value = splittedNews[0];
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value=splittedNews[1];
            new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value=splittedNews[2];
        } else {
            hiddenTypology.value = "";
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value="";
            new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value="";
        }
    });

    var rootMods = document.getElementById('tipologia-mods-js-select');
    var selectMods = new mdc.select.MDCSelect(rootMods);

    rootMods.addEventListener('MDCSelect:change', function () {
        if (selectMods.value.match(/\|/g).length == 2) {
            var splittedMods = selectMods.value.split('|');
            hiddenTypology.value = splittedMods[0];
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value=splittedMods[1];
            new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value=splittedMods[2];
        } else {
            hiddenTypology.value = "";
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value="";
            new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value="";
        }
    });
}

function validateWindowData() {
    hideData();
}

function hideData() {

    /*var rootNewMod = document.getElementById('tecnologia-js-select');
    var hiddenNewMod = document.getElementById('selected-technology');
    var selectNewMod = new mdc.select.MDCSelect(rootTechnology);

    rootTechnology.addEventListener('MDCSelect:change', function() {
        hiddenTechnology.value = selectTechnology.value;
    });*/

}

function loadSelects() {
    mdc.select.MDCSelect.attachTo(document.getElementById('nuemod-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-empty-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-news-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-mods-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-final-empty-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-final-news-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-final-mods-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('estatus-tipificacion-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('estatus-componente-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('facturado-js-select'));
}

function defaultTypologies() {
    $('#tipologia-empty-js-select').show();
    new mdc.select.MDCSelect(document.getElementById('tipologia-empty-js-select')).disabled = true;
    new mdc.select.MDCSelect(document.getElementById('tipologia-news-js-select')).disabled = true;
    new mdc.select.MDCSelect(document.getElementById('tipologia-mods-js-select')).disabled = true;
    $('#tipologia-news-js-select').hide();
    $('#tipologia-mods-js-select').hide();
    $('#tipologia-final-empty-js-select').show();
    new mdc.select.MDCSelect(document.getElementById('tipologia-final-empty-js-select')).disabled = true;
    $('#tipologia-final-news-js-select').hide();
    $('#tipologia-final-mods-js-select').hide();
}

function addHiddenEvents() {
    addTextSyncMdcToHtml("componentName", "component-mdc-text");
    addTextSyncMdcToHtml("componentVersion", "version-mdc-text");
    addTextSyncMdcToHtml("componentDesignRealDeliverDate", "FecRealCFG-mdc-text");
    addTextSyncMdcToHtml("componentPreviewDeliverDate", "FecPreFac-mdc-text");
    addTextSyncMdcToHtml("componentPossibleDeliverDate", "FecNegFac-mdc-txt");
    addTextSyncMdcToHtml("componentRealDeliverDate", "FecRealFac-mdc-text");
    $("#requirement").val($("#requirementHidden").val());
}

function addTextSyncMdcToHtml(htmlField, mdcField) {
    var rootName = document.getElementById(mdcField);
    var inputName = rootName.querySelector('input');
    var hiddenName = document.getElementById(htmlField);
    var textName = new mdc.textField.MDCTextField(rootName);

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

function showH() {
    document.getElementById('EstadoLinea').style.display = 'inline';
}

function addCalendars(){
    $('#FecRealCFG').datetimepicker({
        format: 'DD/MM/YYYY',
        widgetPositioning: {
            horizontal: 'auto',
            vertical: 'top'
        }
    });

    $('#FecPreFac').datetimepicker({
        format: 'DD/MM/YYYY',
        widgetPositioning: {
            horizontal: 'auto',
            vertical: 'top'
        }
    });

    $('#FecNegFac').datetimepicker({
        format: 'DD/MM/YYYY',
        widgetPositioning: {
            horizontal: 'auto',
            vertical: 'top'
        }
    });

    $('#FecRealFac').datetimepicker({
        format: 'DD/MM/YYYY',
        widgetPositioning: {
            horizontal: 'auto',
            vertical: 'top'
        }
    });
}

function pad(n, width, z) {
    z = z || '0';
    n = n + '';
    return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
}