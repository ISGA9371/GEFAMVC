function init() {
    //showH();
    initGlobal();
    holder("Cargando");
    addCalendars();
    loadSelects();
    fillFields();
    addHiddenEvents();
    defaultTypologies();
    addCustomSelectEvents();
    addComponentValidation();
    //addRequirementValidation();
    addDifficultyValidation();
    addHoursValidation();
    addButtonEvents();

    setTimeout("window.scrollTo(0, 0)", 50);
    setTimeout("$(\".container\").click();", 50);
    if (!showingError) {
        HoldOn.close();
    }
}

function fillFields() {
    new mdc.textField.MDCTextField(document.getElementById('component-mdc-text')).value = $('#componentName').val();
    new mdc.textField.MDCTextField(document.getElementById('version-mdc-text')).value = $('#componentVersion').val();
    new mdc.textField.MDCTextField(document.getElementById('descripcion-mdc-text')).value = $('#componentTypoComment').val()

    var initHour = $('#componentStartHours').val();
    var auxHour = $('#componentFinalHours').val();
    var $elementTypologiaInicio = $("#typology").parent().find("li[id^='" + $('#typology').val() + "|']");
    if ($elementTypologiaInicio.length > 0) {
        var idTypologiaInicio = $elementTypologiaInicio.attr('id');
        var splittedTypologiaInicio = idTypologiaInicio.split('|');
        if (splittedTypologiaInicio[3] == "false") {
            splittedTypologiaInicio[3] = 0;
        }
        if (splittedTypologiaInicio[3] == "true") {
            splittedTypologiaInicio[3] = 1;
        }
        if (splittedTypologiaInicio[3] === 0 || splittedTypologiaInicio[3] === 1) {
            var comboId = "";
            if (splittedTypologiaInicio[3] == 0) {
                new mdc.textField.MDCTextField(document.getElementById("nuemod-mdc-text")).value = "Nuevo";
                $('#tipologia-empty-js-select').hide();
                $('#tipologia-news-js-select').show();
                $('#tipologia-mods-js-select').hide();
                comboId = "tipologia-news-js-select";
            }
            if (splittedTypologiaInicio[3] == 1) {
                new mdc.textField.MDCTextField(document.getElementById("nuemod-mdc-text")).value = "Modificado";
                $('#tipologia-empty-js-select').hide();
                $('#tipologia-news-js-select').hide();
                $('#tipologia-mods-js-select').show();
                comboId = "tipologia-mods-js-select";
            }
            selectByValue(comboId,$elementTypologiaInicio.attr("id"));
            new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value = splittedTypologiaInicio[1];
            if(splittedTypologiaInicio[1] == "F"){
                new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value = initHour;
            } else {
                new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value = splittedTypologiaInicio[2];
            }
        } else {
            $('#tipologia-empty-js-select').show();
            new mdc.select.MDCSelect(document.getElementById('tipologia-news-js-select')).selectedIndex = -1;
            $('#tipologia-news-js-select').hide();
            $('#tipologia-mods-js-select').hide();
            new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value = "";
        }
    } else {
        $('#tipologia-empty-js-select').show();
        $('#tipologia-news-js-select').hide();
        $('#tipologia-mods-js-select').hide();
    }
    if ($('#componentStartCost').val() == "") {
        $('#componentStartCost').val(Number(new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value) * Number($("#auxFare").val()));
    }
    if ($("#typology-final").val() == "") {
        $("#typology-final").val($("#typology").val())
    }
    new mdc.textField.MDCTextField(document.getElementById('initial-cost-mdc-text')).value = Number($('#componentStartCost').val()).formatMoney(2);
    var $elementTypologiaFinal = $("#typology-final").parent().find("li[id^='" + $('#typology-final').val() + "|']");
    if ($elementTypologiaFinal.length > 0) {
        var idTypologiaFinal = $elementTypologiaFinal.attr('id');
        var splittedTypologiaFinal = idTypologiaFinal.split('|');
        if (splittedTypologiaFinal[3] == "false") {
            splittedTypologiaFinal[3] = 0;
        }
        if (splittedTypologiaFinal[3] == "true") {
            splittedTypologiaFinal[3] = 1;
        }
        if (splittedTypologiaFinal[3] === 0 || splittedTypologiaFinal[3] === 1) {
            if (splittedTypologiaFinal[3] == 0) {
                new mdc.textField.MDCTextField(document.getElementById("nuemod-mdc-text")).value = "Nuevo";
                $('#tipologia-final-empty-js-select').hide();
                $('#tipologia-final-news-js-select').show();
                $('#tipologia-final-mods-js-select').hide();
                comboId = "tipologia-final-news-js-select";
            }
            if (splittedTypologiaFinal[3] == 1) {
                new mdc.textField.MDCTextField(document.getElementById("nuemod-mdc-text")).value = "Modifcado";
                $('#tipologia-final-empty-js-select').hide();
                $('#tipologia-final-news-js-select').hide();
                $('#tipologia-final-mods-js-select').show();
                comboId = "tipologia-final-mods-js-select";
            }
            selectByValue(comboId,$elementTypologiaFinal.attr("id"));
            setTimeout(function () {if(splittedTypologiaFinal[1] == "F"){
                $('#componentFinalHours').val(auxHour);
                new mdc.textField.MDCTextField(document.getElementById("hours-final-mdc-text")).value = auxHour;
                $('#componentFinalHours').val(auxHour);
                changeHours();
            }}, 100);
        } else {
            $('#tipologia-final-empty-js-select').show();
            new mdc.select.MDCSelect(document.getElementById('tipologia-final-news-js-select')).selectedIndex = -1;
            $('#tipologia-final-news-js-select').hide();
            $('#tipologia-final-mods-js-select').hide();
            new mdc.textField.MDCTextField(document.getElementById("difficulty-final-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("hours-final-mdc-text")).value = "";
        }
    } else {
        $('#tipologia-final-empty-js-select').show();
        $('#tipologia-final-news-js-select').hide();
        $('#tipologia-final-mods-js-select').hide();
    }
    if ($('#componentFinalCost').val() == "") {
        $('#componentFinalCost').val(Number(new mdc.textField.MDCTextField(document.getElementById("hours-final-mdc-text")).value) * Number($("#auxFare").val()));
    }
    new mdc.textField.MDCTextField(document.getElementById('final-cost-mdc-text')).value = Number($('#componentFinalCost').val()).formatMoney(2);
    var $statusTypology = $("#statusTypology").parent().find("li[id^='" + $('#statusTypology').val() + "']");
    if ($statusTypology.length > 0) {
        selectByValue("estatus-tipificacion-js-select",$statusTypology.attr("id"));
    }
    var $status = $("#status").parent().find("li[id^='" + $('#status').val() + "']");
    if ($status.length > 0) {
        selectByValue("estatus-componente-js-select",$status.attr("id"));
    }
    var $componentForBill = "";
    $componentForBill = $('#componentForBill').val();
    if ($componentForBill == "false") {
        $componentForBill = 0;
    }
    if ($componentForBill == "true") {
        $componentForBill = 1;
    }
    if ($componentForBill === 0 || $componentForBill === 1) {
        selectByValue("facturado-js-select",$componentForBill);
    }
    $('#componentForBill').val($componentForBill);
    /*var d = new Date($('#componentDesignRealDeliverDate').val());
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
    new mdc.textField.MDCTextField(document.getElementById('FecRealFac-mdc-text')).value = $('#componentRealDeliverDate').val();*/
    new mdc.textField.MDCTextField(document.getElementById('FecRealCFG-mdc-text')).value = $('#componentDesignRealDeliverDate').val();
    new mdc.textField.MDCTextField(document.getElementById('FecPreFac-mdc-text')).value = $('#componentPreviewDeliverDate').val();
    new mdc.textField.MDCTextField(document.getElementById('FecNegFac-mdc-text')).value = $('#componentPossibleDeliverDate').val();
    new mdc.textField.MDCTextField(document.getElementById('FecRealFac-mdc-text')).value = $('#componentRealDeliverDate').val();

    new mdc.textField.MDCTextField(document.getElementById('version-mdc-text')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('level-superior-mdc-text')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('level-mdc-text')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('company-mdc-text')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('technology-mdc-text')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('nuemod-mdc-text')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('requieriment-mdc-text')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('difficulty-mdc-text')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('hours-mdc-text')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('initial-cost-mdc-text')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('difficulty-final-mdc-text')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('hours-final-mdc-text')).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById('final-cost-mdc-text')).disabled = true;
}

function clickSelectOption(idHolder) {
    $holder = $("#" + idHolder);
    $holder.parent().find("li[id^='" + $holder.val() + "']").click();

}

function selectByValue(mdcSelectId, value){
    $select = new mdc.select.MDCSelect(document.getElementById(mdcSelectId));
    $option = $("#"+mdcSelectId).parent().find("li[id='" + value + "']");
    $select.item($option.parent().find("li").index($option)).click();
    $($select.label_).addClass("mdc-select__label--float-above");
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
    $('#hours-final-mdc-text :input')
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

function addCustomSelectEvents() {
    var hiddenTypology = document.getElementById('typology-final');

    var rootNews = document.getElementById('tipologia-final-news-js-select');
    var selectNews = new mdc.select.MDCSelect(rootNews);

    rootNews.addEventListener('MDCSelect:change', function () {
        if (selectNews.value != "") {
            var splittedNews = selectNews.value.split('|');
            hiddenTypology.value = splittedNews[0];
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-final-mdc-text")).value = splittedNews[1];
            new mdc.textField.MDCTextField(document.getElementById("hours-final-mdc-text")).value=splittedNews[2];
            if(splittedNews[1] == "F"){
                new mdc.textField.MDCTextField(document.getElementById("hours-final-mdc-text")).disabled = false;
            } else {
                new mdc.textField.MDCTextField(document.getElementById("hours-final-mdc-text")).disabled = true;
            }
            $("#componentFinalHours").val(splittedNews[2]);
            $("#componentFinalCost").val(Number(splittedNews[2]) * Number($("#auxFare").val()));
            new mdc.textField.MDCTextField(document.getElementById("final-cost-mdc-text")).value = Number($("#componentFinalCost").val()).formatMoney(2);
        } else {
            hiddenTypology.value = "";
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-final-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("hours-final-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("final-cost-mdc-text")).value = "";
        }
    });

    var rootMods = document.getElementById('tipologia-final-mods-js-select');
    var selectMods = new mdc.select.MDCSelect(rootMods);

    rootMods.addEventListener('MDCSelect:change', function () {
        if (selectMods.value != "") {
            var splittedMods = selectMods.value.split('|');
            hiddenTypology.value = splittedMods[0];
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-final-mdc-text")).value = splittedMods[1];
            new mdc.textField.MDCTextField(document.getElementById("hours-final-mdc-text")).value=splittedMods[2];
            if(splittedMods[1] == "F"){
                new mdc.textField.MDCTextField(document.getElementById("hours-final-mdc-text")).disabled = false;
            } else {
                new mdc.textField.MDCTextField(document.getElementById("hours-final-mdc-text")).disabled = true;
            }
            $("#componentFinalHours").val(splittedMods[2]);
            $("#componentFinalCost").val(Number(splittedMods[2]) * Number($("#auxFare").val()));
            new mdc.textField.MDCTextField(document.getElementById("final-cost-mdc-text")).value = Number($("#componentFinalCost").val()).formatMoney(2);
        } else {
            hiddenTypology.value = "";
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-final-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("hours-final-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("final-cost-mdc-text")).value = "";
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
    mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-empty-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-final-empty-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('facturado-js-select'));
    $.ajax({
        async: false,
        url: "/api/typologies/types?componentModified=false"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.typologyId + "|" + data.typologySeverity + "|" + data.typologySeverityHours + "|" + data.typologyComponentModified);
            $liElement.append(data.product.productName);
            $("#tipologia-news-js-select").find("ul:first").append($liElement);
            $("#tipologia-final-news-js-select").find("ul:first").append($liElement.clone());
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-news-js-select'));
        mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-final-news-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        customHolder('error', '¡Error al consultar combos!');
        $('#typology').val("");
        showingError = true;
    });
    $.ajax({
        async: false,
        url: "/api/typologies/types?componentModified=true"
    }).done(function (json) {
        $.each(json.data, function (i, data) {
            $liElement = $("<li>");
            $liElement.attr("class", "mdc-list-item");
            $liElement.attr("role", "option");
            $liElement.attr("id", data.typologyId + "|" + data.typologySeverity + "|" + data.typologySeverityHours + "|" + data.typologyComponentModified);
            $liElement.append(data.product.productName);
            $("#tipologia-mods-js-select").find("ul:first").append($liElement);
            $("#tipologia-final-mods-js-select").find("ul:first").append($liElement.clone());
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-mods-js-select'));
        mdc.select.MDCSelect.attachTo(document.getElementById('tipologia-final-mods-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        customHolder('error', '¡Error al consultar combos!');
        showingError = true;
        $("#typology-final").val("");
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

function defaultTypologies() {
    new mdc.select.MDCSelect(document.getElementById('tipologia-empty-js-select')).disabled = true;
    new mdc.select.MDCSelect(document.getElementById('tipologia-news-js-select')).disabled = true;
    new mdc.select.MDCSelect(document.getElementById('tipologia-mods-js-select')).disabled = true;
    new mdc.select.MDCSelect(document.getElementById('tipologia-final-empty-js-select')).disabled = true;
}

function addHiddenEvents() {
    addTextSyncMdcToHtml("componentName", "component-mdc-text");
    addTextSyncMdcToHtml("componentVersion", "version-mdc-text");
    addTextSyncMdcToHtml("componentTypoComment", "descripcion-mdc-text");
    addHoursSyncMdcToHtml("componentFinalHours", "hours-final-mdc-text");
    addDateSyncMdcToHtml("componentDesignRealDeliverDate", "FecRealCFG-mdc-text");
    addDateSyncMdcToHtml("componentPreviewDeliverDate", "FecPreFac-mdc-text");
    addDateSyncMdcToHtml("componentPossibleDeliverDate", "FecNegFac-mdc-text");
    addDateSyncMdcToHtml("componentRealDeliverDate", "FecRealFac-mdc-text")
    //$("#requirement").val($("#requirementHidden").val());
    //addSelectSyncMdcToHtml("subdireccion","subdireccion-js-select");
    addSelectSyncMdcToHtml("statusTypology", "estatus-tipificacion-js-select");
    addSelectSyncMdcToHtml("componentForBill", "facturado-js-select");
    addSelectSyncMdcToHtml("status", "estatus-componente-js-select");
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
    var rootName = document.querySelector('#'+mdcField);
    var inputName = rootName.querySelector('input');
    var hiddenName = document.getElementById(htmlField);
    var textName = new mdc.textField.MDCTextField(rootName);
    $(inputName).change(function () {
        hiddenName.value = textName.value;
        if ("" != textName.value) {
            $("#"+mdcField+" > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#"+mdcField+" > label").removeClass("mdc-text-field__label--float-above");
        }
    });
}

function addSelectSyncMdcToHtml(htmlField, mdcSelect) {
    var $hiddenInput = $("#" + htmlField);
    var rootSelect = document.getElementById(mdcSelect);
    var selectObj = new mdc.select.MDCSelect(rootSelect);

    rootSelect.addEventListener('MDCSelect:change', function () {
        $hiddenInput.val(selectObj.value);
    });
}

function showH() {
    document.getElementById('EstadoLinea').style.display = 'inline';
}

function addCalendars() {
    $('#FecRealCFG').datepicker({
        dateFormat: "dd/mm/yy"
    });

    $('#FecPreFac').datepicker({
        dateFormat: "dd/mm/yy"
    });

    $('#FecNegFac').datepicker({
        dateFormat: "dd/mm/yy"
    });

    $('#FecRealFac').datepicker({
        dateFormat: "dd/mm/yy"
    });
}

function holder(msg) {
    HoldOn.open({
        theme: "sk-cube",
        content: '',
        message: msg,
        // backgroundColor: "#004582",
        backgroundColor: "#0c71ca",
        textColor: "white"
    });
}

function pad(n, width, z) {
    z = z || '0';
    n = n + '';
    return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
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

var changeHours = function(){
    $("#componentFinalCost").val(Number($("#componentFinalHours").val())*Number($("#auxFare").val()));
    new mdc.textField.MDCTextField(document.getElementById("final-cost-mdc-text")).value=Number($("#componentFinalCost").val()).formatMoney(2);
}

var showingError = false;