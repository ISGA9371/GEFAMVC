

function init() {
    loadSelects();
    var rootVersion = document.getElementById('version-mdc-text');
    var textVersion = new mdc.textField.MDCTextField(rootVersion);
    textVersion.value = getVersion();
    defaultTypologies();
    addSelectEvents();
    addComponentValidation();
    addRequirementValidation();
    addDifficultyValidation();
    addHoursValidation();
    addButtonEvents();
}

function getVersion() {
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
    return today;
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

function addRequirementValidation() {
    var goodDescription120 = /^^([A-Za-z0-9áéíóúñÁÉÍÓÚÑ]( )?)*$/
    $('#requieriment-mdc-text :input')
        .data("oldValue", '')
        .bind('input propertychange', function () {
            var $this = $(this);
            var newValue = $this.val();

            if (!goodDescription120.test(newValue))
                return $this.val($this.data('oldValue'));
            return $this.data('oldValue', newValue)
        });
}

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
 function addSelectEvents(){

     var rootType = document.getElementById('nuemod-js-select');
     //var hiddenType = document.getElementById('selected-technology');
     var selectType = new mdc.select.MDCSelect(rootType);

     rootType.addEventListener('MDCSelect:change', function() {
         alert(selectType.value);
         if(selectType.value == 0){
             $('#tipologia-empty-js-select').hide();
             new mdc.select.MDCSelect(document.getElementById('tipologia-news-js-select')).selectedIndex = -1
             $('#tipologia-news-js-select').show();
             $('#tipologia-mods-js-select').hide();
         }
         if(selectType.value == 1){
             $('#tipologia-empty-js-select').hide();
             new mdc.select.MDCSelect(document.getElementById('tipologia-mods-js-select')).selectedIndex = -1
             $('#tipologia-news-js-select').hide();
             $('#tipologia-mods-js-select').show();
         }
         selectType.clearSelection
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

function loadSelects(){
    mdc.select.MDCSelect.attachTo(document.getElementById('nuemod-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-empty-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-news-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-mods-js-select'));
}

function defaultTypologies(){
    $('#tipologia-empty-js-select').show();
    new mdc.select.MDCSelect(document.getElementById('tipologia-empty-js-select')).disabled = true;
    $('#tipologia-news-js-select').hide();
    $('#tipologia-mods-js-select').hide();
}