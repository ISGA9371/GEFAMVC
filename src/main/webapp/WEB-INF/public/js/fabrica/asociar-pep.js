let dataId;
$(function () {
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
    let cancelBudget = $("#cancel");

    $('tr.clickable').click(function() {
        var radioButton = $(this).find('input[type=radio]');
        console.log("hola"+ radioButton.length);
        radioButton.prop('checked', 'checked');
        dataId = $(this).closest('tr').data("id");

        addBudget.removeAttr("disabled");
        cancelBudget.removeAttr("disabled");

        //addComp.attr("href","/components/add?requirementId="+radioButton.val());
        //addComp.removeAttr("disabled");
    });

    $('input[name=budgets]').change(function () {
    });

    /*SELECCIONAR PEPE*/
    addBudget.click(function (e) {
        //e.stopPropagation();

        var row = $("tr[data-id="+dataId+"]");

        row.hide('slow', function () {
            row.find("td").not("td[data-select='']").css("display","none");

            row.prepend($("#botecito").clone());
            row.append($("#incurrido").clone());
            row.append($("#incurrido-hrs").clone());
            row.css("display","table-row");

            console.log("");
            $("#selected-budgets tbody").prepend(row[0].outerHTML);

            row.remove();
        });
    });

});

function showHoldOn() {
    HoldOn.open({
        theme: "sk-cube",
        content: '',
        message: 'Procesando...',
        backgroundColor: "#0c71ca",
        textColor: "white",
    });
}