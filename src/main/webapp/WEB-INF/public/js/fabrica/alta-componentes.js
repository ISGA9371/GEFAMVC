function init() {
    //showH();
    addCalendars();
    loadSelects();
    getVersion();
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
    var btnSave = document.getElementById('guardar-btn');
    btnCancel.addEventListener("click", function () {
        window.history.back();
    })
    btnSave.addEventListener("click", function () {
        validateWindowData();
    })
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
        new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value="";
        new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value="";
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
}

function defaultTypologies() {
    $('#tipologia-empty-js-select').show();
    new mdc.select.MDCSelect(document.getElementById('tipologia-empty-js-select')).disabled = true;
    $('#tipologia-news-js-select').hide();
    $('#tipologia-mods-js-select').hide();
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