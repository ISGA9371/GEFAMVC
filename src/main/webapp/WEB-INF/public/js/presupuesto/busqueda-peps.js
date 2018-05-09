function init() {
    //showH();
    initGlobal();
    holder("Cargando");
    loadSelects();
    addHiddenEvents();
    addButtonEvents();
    if (!showingError) {
        HoldOn.close();
    }
}

function addTextValidation() {
    var goodDescription120 = /^([A-Za-z0-9áéíóúñÁÉÍÓÚÑ]( )?)*$/
    $('#pep-mdc-text')
        .data("oldValue", '')
        .bind('input propertychange', function () {
            var $this = $(this);
            var newValue = $this.val();

            if (!goodDescription120.test(newValue))
                return $this.val($this.data('oldValue'));
            return $this.data('oldValue', newValue)
        });
    $('#pep-name-mdc-text')
        .data("oldValue", '')
        .bind('input propertychange', function () {
            var $this = $(this);
            var newValue = $this.val();

            if (!goodDescription120.test(newValue))
                return $this.val($this.data('oldValue'));
            return $this.data('oldValue', newValue)
        });
}

function addButtonEvents() {
    var btnBuscar = document.getElementById('btn-buscar');
    btnBuscar.addEventListener("click", function () {
        $("#results").css("display", "none");
        var params = {
            budgetId: $("#budgetId").val(),
            budgetYear: $("#budgetYear").val(),
            budgetName: $("#budgetName").val(),
            areaId: $("#areaId").val(),
            bankingId: $("#bankingId").val(),
            userReceiverId: $("#userReceiverId").val(),
            userSenderId: $("#userSenderId").val(),
            corporationId: $("#corporationId").val(),
            natureId: $("#natureId").val(),
            budgetCostCenter: $("#budgetCostCenter").val(),
            //transferDateFrom: $("#transferDateFrom").val().split("/").reverse().join("-"),
            //transferDateTo: $("#transferDateTo").val().split("/").reverse().join("-")
        };
        $.ajax({
            url: "/budgets/search",
            method: "GET",
            data: $.param( params ),
            dataType: "json",
            beforeSend: function (xhr) {
                HoldOn.open({
                    theme: "sk-cube",
                    content: '',
                    message: 'Consultado Información',
                    backgroundColor: "#0c71ca",
                    textColor: "white",
                });
            }
        }).done(function (data) {
            currentTransfers = data;
            currentPeps = currentTransfers;
            pagePeps(1);
            $('#pagination-div').bootpag({
                total: Math.ceil(currentPeps.length/10),
                page: 1,
                maxVisible: 10,
                leaps: true,
                firstLastUse: true,
                prev: '‹',
                next: '›',
                first: '«',
                last: '»',
                wrapClass: 'pagination',
                activeClass: 'active',
                disabledClass: 'disabled',
                nextClass: 'next',
                prevClass: 'prev',
                lastClass: 'last',
                firstClass: 'first'
            }).on("page", function(event, num){
                pagePeps(num);
            });
            $("#results").css("display", "block");
            HoldOn.close();
        }).fail(function (xhr, status, error) {
            HoldOn.close();
            customHolder("error", xhr.responseJSON.message)
        });
    })
    var btnLimpiar = document.getElementById('btn-limpiar');
    btnLimpiar.addEventListener("click", function () {
        //limpiar
    });
    var btnModificar = document.getElementById('btn-modificar');
    btnModificar.addEventListener("click", function () {
        if ($('input[name=pepsIds]:checked').attr("id") !== undefined) {
            holder("Cargando...");
            window.location.href = "/budgets/transfers/" + $('input[name=pepsIds]:checked').attr("id");
        } else {
            customHolder("warn", "Debe seleccionar un Traspaso.")
        }
    });
    var btnEliminar = document.getElementById('btn-eliminar');
    btnEliminar.addEventListener("click", function () {
        /*holder("Cargando...");
        window.location.href = "/components/filters";*/
        alert("No se han acordados las condiciones para eliminar, se espera aclaracion para asignar funcionalidad.");
    });
    var btnTaspaso = document.getElementById('btn-traspaso');
    btnTaspaso.addEventListener("click", function () {
        if ($('input[name=pepsIds]:checked').attr("id") !== undefined) {
            holder("Cargando...");
            window.location.href = "/budgets/" + $('input[name=pepsIds]:checked').closest("td").next().html()+"/transfers/add";
        } else {
            customHolder("warn", "Debe seleccionar un Traspaso.")
        }
    });
    var btnDispersion = document.getElementById('btn-dispersion');
    btnDispersion.addEventListener("click", function () {
        if ($('input[name=pepsIds]:checked').attr("id") !== undefined) {
            holder("Cargando...");
            window.location.href = "/budgets/"+$('input[name=pepsIds]:checked').closest("td").next().html()+"/dispersions/add?transferId="+$('input[name=pepsIds]:checked').attr("id");
        } else {
            customHolder("warn", "Debe seleccionar un Traspaso.")
        }
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
            $("#componentStartCost").val(Number(splittedNews[2]) * Number($("#auxFare").val()));
            $("#componentFinalCost").val($("#componentStartCost").val());
            new mdc.textField.MDCTextField(document.getElementById("cost-mdc-text")).value = Number($("#componentStartCost").val()).formatMoney(2);
        } else {
            hiddenTypology.value = "";
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("cost-mdc-text")).value = "";
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
            $("#componentStartCost").val(Number(splittedMods[2]) * Number($("#auxFare").val()));
            $("#componentFinalCost").val($("#componentStartCost").val());
            new mdc.textField.MDCTextField(document.getElementById("cost-mdc-text")).value = Number($("#componentStartCost").val()).formatMoney(2);
        } else {
            hiddenTypology.value = "";
            $("#typologyEmp").val(hiddenTypology.value);
            new mdc.textField.MDCTextField(document.getElementById("difficulty-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("hours-mdc-text")).value = "";
            new mdc.textField.MDCTextField(document.getElementById("cost-mdc-text")).value = "";
        }
    });
}

function loadSelects() {
    mdc.select.MDCSelect.attachTo(document.getElementById('year-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('area-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('banking-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('receiver-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('sender-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('corporation-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('nature-js-select'));
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
        customHolder('error', '¡Error al consultar combos!');
        $('#typology').val("");
        showingError = true;
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
            $("#banking-js-select").find("ul:first").append($liElement);
        });
        mdc.select.MDCSelect.attachTo(document.getElementById('banking-js-select'));
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        customHolder('error', '¡Error al consultar combos!');
        $('#typology').val("");
        showingError = true;
    });
    var usersProfileType1;
    var usersProfileType2;
    $.ajax({
        async: false,
        url: "/api/profile-types/1/users"
    }).done(function (json) {
        usersProfileType1 = json.data;
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        customHolder('error', '¡Error al consultar combos!');
        $('#typology').val("");
        showingError = true;
    });
    if (usersProfileType1 === undefined) {
        return;
    }
    $.ajax({
        async: false,
        url: "/api/profile-types/2/users"
    }).done(function (json) {
        usersProfileType2 = json.data;
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar combos!');
        customHolder('error', '¡Error al consultar combos!');
        $('#typology').val("");
        showingError = true;
    });
    if (usersProfileType2 === undefined) {
        return;
    }
    $.each(usersProfileType1, function (i, data) {
        $liElement = $("<li>");
        $liElement.attr("class", "mdc-list-item");
        $liElement.attr("role", "option");
        $liElement.attr("id", data.userInternalId);
        $liElement.append(data.userInternalId);
        $("#sender-js-select").find("ul:first").append($liElement);
        $("#receiver-js-select").find("ul:first").append($liElement.clone());
    });
    $.each(usersProfileType2, function (i, data) {
        $liElement = $("<li>");
        $liElement.attr("class", "mdc-list-item");
        $liElement.attr("role", "option");
        $liElement.attr("id", data.userInternalId);
        $liElement.append(data.userInternalId);
        $("#sender-js-select").find("ul:first").append($liElement);
        $("#receiver-js-select").find("ul:first").append($liElement.clone());
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
}

function addHiddenEvents() {
    addTextSyncMdcToHtml("budgetId", "pep-mdc-text");
    addTextSyncMdcToHtml("budgetName", "pep-name-mdc-text");
    addTextSyncMdcToHtml("budgetCostCenter", "cr-mdc-text");
    addSelectSyncMdcToHtml("budgetYear", "year-js-select");
    addSelectSyncMdcToHtml("areaId", "area-js-select");
    addSelectSyncMdcToHtml("bankingId", "banking-js-select");
    addSelectSyncMdcToHtml("userReceiverId", "receiver-js-select");
    addSelectSyncMdcToHtml("userSenderId", "sender-js-select");
    addSelectSyncMdcToHtml("corporationId", "corporation-js-select");
    addSelectSyncMdcToHtml("natureId", "nature-js-select");
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


function addSelectSyncMdcToHtml(htmlField, mdcSelect) {
    var $hiddenInput = $("#" + htmlField);
    var rootSelect = document.getElementById(mdcSelect);
    var selectObj = new mdc.select.MDCSelect(rootSelect);

    rootSelect.addEventListener('MDCSelect:change', function () {
        $hiddenInput.val(selectObj.value);
    });
}

function pagePeps(numPage) {
    $("#table-peps > tbody").empty();
    var limiter = (10 * (numPage - 1));
    $.each(currentPeps.slice(0 + limiter, 10 + limiter), function (i, data) {
        $("#table-peps > tbody").append(
            "<tr href='#row-detail-wrapper-1' data-tggle='collapse' class='clickable' aria-controls='row-detail-wrapper-1'>" +
            "<td>" +
            "<div class='mdc-radio color-custom'>" +
            "<input class='mdc-radio__native-control' type='radio' id='" + data.transferId + "' name='pepsIds'>" +
            "<div class='mdc-radio__background'>" +
            "<div class='mdc-radio__outer-circle'></div>" +
            "<div class='mdc-radio__inner-circle'></div>" +
            "</div>" +
            "</div>" +
            "</td>" +
            "<td>" + data.budget.budgetId + "</td>" +
            "<td>" + data.budget.userReceiver.userInternalId + "</td>" +
            "<td>" + seniority(new Date(data.transferDate), new Date()) + "</td>" +
            "<td>$" + Number(data.budget.budgetAmount).formatMoney(2) + "</td>" +
            "<td>$" + (Number(data.budget.budgetAmount) - Number(data.transferWithdrawalValue)).formatMoney(2) + "</td>" +
            "<td>$" + Number(data.budget.budgetIncurredTestFactory).formatMoney(2) + "</td>" +
            "<td>$" + Number(data.budget.budgetIncurredSoftwareFactory).formatMoney(2) + "</td>" +
            "<td>$" + (Number(data.budget.budgetIncurredTestFactory) + Number(data.budget.budgetIncurredSoftwareFactory)).formatMoney(2) + "</td>" +
            "</tr>"
        );
    });
    for (var j = 10; $('#table-peps tbody tr').length < j;) {
        $("#table-peps > tbody").append(
            "<tr href='#row-detail-wrapper-1' data-tggle='collapse' class='clickable' aria-controls='row-detail-wrapper-1'>" +
            "<td colspan='9'><div class='mdc-radio color-custom'></div></td>" +
            "</tr>"
        );
    }
}

function addCalendars() {
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

function seniority(d1, d2) {
    d1 = new Date(d1.setHours(0,0,0,0));
    d2 = new Date(d2.setHours(0,0,0,0));
    var diff = 0;
    if (d1 && d2) {

        diff = Math.round(Math.abs((d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000)));
    }
    return diff;
}

var showingError = false;
var currentPeps = null;
var currentTransfers = null;