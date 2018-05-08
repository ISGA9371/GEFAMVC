let dataId;
var selectedBudgetsIds = [];
let companyFare;
$(function () {

    $.ajax({
        url: "/requirements/"+requirementId+"/fare"
    }).done(function(data) {
        companyFare = data.data;
        console.log("REQUREMENTFARE "+data.data);
    });

    $("#cancel-search").click(function () {
        window.history.back();
    });

    const areas = new mdc.select.MDCSelect(document.querySelector('#areas'));
    let index = parseInt("0");
    areas.listen('MDCSelect:change', () => {
        if (index++ === 0) return; else index = 0;
        let id = areas.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("AREAID " +id);
        $("#areaId").val(id);
    });

    const banking = new mdc.select.MDCSelect(document.querySelector('#bankings'));
    let index2 = parseInt("0");
    banking.listen('MDCSelect:change', () => {
        if (index2++ === 0) return; else index2 = 0;
        let id = banking.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("BANKINGID " +id);
        $("#bankingId").val(id);
    });

    const corporation = new mdc.select.MDCSelect(document.querySelector('#corporations'));
    let index3 = parseInt("0");
    corporation.listen('MDCSelect:change', () => {
        if (index3++ === 0) return; else index3 = 0;
        let id = corporation.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("CORPOID " +id);
        $("#corporationId").val(id);
    });

    const natures = new mdc.select.MDCSelect(document.querySelector('#natures'));
    let index4 = parseInt("0");
    natures.listen('MDCSelect:change', () => {
        if (index4++ === 0) return; else index4 = 0;
        let id = natures.selectedOptions[0].value;
        //SET HIDDEN FIELD VALUE
        console.log("NATUREID " +id);
        $("#natureId").val(id);
    });

    let addBudget = $("#add-budget");
    let clearSearch = $("#clear-search");

    $(document).on("click",'#results-table tbody tr.clickable', function () {
        var radioButton = $(this).find('input[type=radio]');
        radioButton.prop('checked', 'checked');
        dataId = $(this).closest('tr').data("id");

        addBudget.removeAttr("disabled");
    });

    clearSearch.click(function() {
        $("#search-form")[0].reset();
        $("#search-form input[type=text]").val("");

        areas.selectedIndex = -1;
        areas.value = "";
        banking.selectedIndex = -1;
        banking.value = "";
        corporation.selectedIndex = -1;
        corporation.value = "";
        natures.selectedIndex = -1;
        natures.value = "";

        $(".mdc-select__label").removeClass("mdc-select__label--float-above");
        $(".mdc-text-field__label").removeClass("mdc-text-field__label--float-above");

        $("#search-form input[type=hidden]").val("");

        $("#results-table tbody").html("");

        clearSearch.attr("disabled","disabled");
        addBudget.attr("disabled","disabled");
    });

    /*SELECCIONAR PEPE*/
    let saveBudgets = $("#save");
    let cancelSave = $("#cancel-save");
    addBudget.click(function (e) {
        var row = $("tr[data-id="+dataId+"]");
        selectedBudgetsIds.push(dataId);
        row.hide('slow', function () {
            row.find("td").not("td[data-select='']").css("display","none");
            var botecito = $("#botecito").clone();
            botecito.attr("data-budget-id",dataId);


            row.prepend(botecito);
            row.append($("#incurrido").clone());
            row.append($("#incurrido-hrs").clone());
            row.removeClass("clickable");

            row.css("display","table-row");
            $("#selected-budgets tbody").prepend(row[0].outerHTML);

            row.remove();

            addBudget.attr("disabled","disabled");
            saveBudgets.removeAttr("disabled");
            cancelSave.removeAttr("disabled");
        });
    });

    cancelSave.click(function () {
        $("#selected-budgets tbody tr td#botecito").each(function (index, element) {
            element.click();
        });
    });

    $(document).on("click","tr td#botecito",function () {
        console.log("BOTECITO");
        var row = $(this).closest("tr");
        row.hide('slow', function () {
            row.find("td").not("td[data-select='']").css("display","table-cell");

            var budgetId = row.data("budgetId");
            console.log("BUDGETOID "+budgetId);
            var index = selectedBudgetsIds.indexOf(budgetId);
            if (index > -1) selectedBudgetsIds.splice(index, 1);

            row.find($("#botecito")).remove();
            row.find($("#incurrido")).remove();
            row.find($("#incurrido-hrs")).remove();

            row.css("display","table-row");
            row.addClass("clickable");
            $("#results-table tbody").prepend(row[0].outerHTML);
            row.remove();

            let selectedBudgetsCount = $("#selected-budgets tbody tr").length;
            console.log("BOTECITOCUANTOS "+selectedBudgetsCount);
            if(selectedBudgetsCount === 0){
                saveBudgets.attr("disabled","disabled");
                cancelSave.attr("disabled","disabled");
            }
        });
    });

    $(document).on("input","input.incurrido-horas",function () {
        let amountSpan = $(this).closest("tr").find("td#incurrido span");
        let mult = parseFloat($(this).val()) * parseFloat(companyFare);
        let multStr = parseFloat(mult, 10).toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
        amountSpan.attr("data-raw",mult);
        amountSpan.html(multStr);

        let sum = parseFloat("0");
        $("#selected-budgets tr td#incurrido-hrs input.incurrido-horas").each(function (index, value) {
            sum += parseFloat($(value).val());
        });
        $("#acum-hours").html(sum);

    });

    $("#search-form").submit(function (e) {
        e.preventDefault();
        showHoldOn();

        var datas= $( this ).serialize();

        $.ajax({
            type: "GET",
            url:   "/budgets/assign/search",
            data:  datas
        }).done(function(data){
            HoldOn.close();
            var tbodyResults = $("#results-table tbody");
            tbodyResults.html("");
            tbodyResults.append(data);

            $("#results-table tr").each(function (index, value) {
                console.log("HOLA " + $(this).find("#saldo-mxn").html());
                var saldoHoras = parseFloat($(this).find("#saldo-mxn").html()) / parseFloat(companyFare);
                $(this).find("#saldo-hrs").html(saldoHoras);
            });

            clearSearch.removeAttr("disabled");
        }).fail(function () {
            HoldOn.close();
            customHolder("error","Ocurrio un error en la búsqueda.");
        });
    });


    $(document).on('submit','#form',function(e) {
        e.preventDefault();

        delete requirementObj["requirementDateUpload"];
        delete requirementObj["requirementStartDate"];
        delete requirementObj["requirementEndDate"];

        let budgetRequirementsList = [];
        $("#selected-budgets tbody tr").each(function (index, value) {
            let row = value;
            let budgetId = $(row).find("td#botecito").attr("data-budget-id");
            let budget = {};
            budget["budgetId"] = budgetId;

            let requirement = {};
            requirement["requirementId"] = requirementId;

            let budgetRequirement = {};
            budgetRequirement["requirement"] = requirement;
            let reqValue = $(row).find("td#incurrido span").attr("data-raw");
            let reqHours= $(row).find("td#incurrido-hrs input.incurrido-horas").val();
            budgetRequirement["budgetRequirementValue"] = reqValue; //INCURRIDO MXN
            budgetRequirement["budgetRequirementHours"] = reqHours; //INCURRIDO HORAS
            budgetRequirement["budgetRequirementBilled"] = "false";
            budgetRequirement["budget"] = budget;

            budgetRequirementsList.push(budgetRequirement);

        });

        let budgets = {};
        budgets["budgets"] = budgetRequirementsList;

        //console.log(JSON.stringify(budgets));
        console.log(JSON.stringify(budgetRequirementsList));


        $.ajax({
            type: "PUT",
            url:   "/budgets/assign",
            data:  JSON.stringify(budgetRequirementsList),
            //data:  requirementObj,
            contentType:'application/json'
        }).done(function(data){
            console.log("hola");
        }).fail(function () {
            console.log("fail");
        });
    });

});

function showHoldOn() {
    HoldOn.open({
        theme: "sk-cube",
        content: '',
        message: 'Cargando...',
        backgroundColor: "#0c71ca",
        textColor: "white",
    });
}