$(function () {

  /** 
   * datepicker
   * dateFormat: "dd-mm-yy"
  */
  $('#componentDesignRealDeliverDate').datetimepicker({
    format: 'DD/MM/YYYY'
  });

  $('#componentPreviewDeliverDate').datetimepicker({
    format: 'DD/MM/YYYY'
  });

  $('#componentPossibleDeliverDate').datetimepicker({
    format: 'DD/MM/YYYY'
  });

  $('#componentRealDeliverDate').datetimepicker({
    format: 'DD/MM/YYYY'
  });


  $("#tabs").tabs();


  const direccion = new mdc.select.MDCSelect(document.querySelector('#slct_direccion'));
  const subidreccion = new mdc.select.MDCSelect(document.querySelector('#slct_subidreccion'));
  const empresa = new mdc.select.MDCSelect(document.querySelector('#slct_empresa'));
  const tecnologia = new mdc.select.MDCSelect(document.querySelector('#slct_tecnologia'));
  const nuevo_modificado = new mdc.select.MDCSelect(document.querySelector('#slct_nuevo_modificado'));
  const estado = new mdc.select.MDCSelect(document.querySelector('#slct_estado'));
  const tipologia_inicial = new mdc.select.MDCSelect(document.querySelector('#slct_tipologia_inicial'));
  const tipologia_final = new mdc.select.MDCSelect(document.querySelector('#slct_tipologia_final'));
  const estado_tipificado = new mdc.select.MDCSelect(document.querySelector('#slct_estado_tipificado'));

  direccion.listen('MDCSelect:change', () => {
    idSuperior = direccion.value;
    subs = $('#select_subdireccion').children('option');
    $("#slct_subidreccion > .mdc-menu > ul").html("");
    $.each(subs, function (index, value) {
      if (idSuperior == $(value).data("superior")) {
        $("#slct_subidreccion > .mdc-menu > ul").append(
          "<li class='mdc-list-item' role='option' tabindex='0' id='" + value.value + "'>" + value.text + "</li>"
        );
      }
    });
    $("#slct_subidreccion").removeClass("mdc-select--disabled");
  });


  tipologia_inicial.listen('MDCSelect:change', () => {
    $("#typologyStartSeverity").val( $(tipologia_inicial.selectedOptions[0]).data("severity") );
    $("#mdc-group-typologyStartSeverity").addClass("mdc-text-field--upgraded");
    $("#mdc-group-typologyStartSeverity > label").addClass("mdc-text-field__label--float-above");

    $("#typologyStartSeverityHours").val( $(tipologia_inicial.selectedOptions[0]).data("hours") );
    $("#mdc-group-typologyStartSeverityHours").addClass("mdc-text-field--upgraded");
    $("#mdc-group-typologyStartSeverityHours > label").addClass("mdc-text-field__label--float-above");
  });

  tipologia_final.listen('MDCSelect:change', () => {
    $("#typologyFinalSeverity").val($(tipologia_final.selectedOptions[0]).data("severity"));
    $("#mdc-group-typologyFinalSeverity").addClass("mdc-text-field--upgraded");
    $("#mdc-group-typologyFinalSeverity > label").addClass("mdc-text-field__label--float-above");

    $("#typologyFinalSeverityHours").val($(tipologia_final.selectedOptions[0]).data("hours"));
    $("#mdc-group-typologyFinalSeverityHours").addClass("mdc-text-field--upgraded");
    $("#mdc-group-typologyFinalSeverityHours > label").addClass("mdc-text-field__label--float-above");
  });


  $("#btn-submit").click(function () {

    $("#principalId").val(direccion.value);
    $("#subPrincipalId").val(subidreccion.value);
    $("#companyId").val(empresa.value);
    $("#technologyId").val(tecnologia.value);
    $("#typologyNewComponent").val(nuevo_modificado.value);
    $("#statusId").val(estado.value);
    $("#startProductId").val(tipologia_inicial.value);
    $("#finalProductId").val(tipologia_final.value);
    $("#statusTypologyId").val(estado_tipificado.value);

    $.ajax({
      url: "/components/search",
      method: "GET",
      // data: JSON.stringify( $("#searchForm").serialize() ),
      data: $.param( $("#searchForm").serialize() ),
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

      if (1 <= data.length) {

        $("#row-title-results").show();
        $("#row-content-results").show();
        $("#row-buttons-results").show();

        $("#tab-componentes > table > tbody").html("");
        $("#tab-fecha > table > tbody").html("");
        $("#tab-cierre > table > tbody").html("");

        $.each(data, function (index, value) {
          $("#tab-componentes > table > tbody").append(
            "<tr><th></th>" +
            "<th>" + value.componentName + "</th>" +
            "<th>" + "" + "</th>" +
            "<th>" + value.componentVersion + "</th>" +
            "<th>" + "" + "</th>" +
            "<th>" + "" + "</th>" +
            "<th>" + "" + "</th>" +
            "<th>" + "" + "</th>" +
            "<th>" + "" + "</th>" +
            "<th><a class='btn btn-primary btn-xs' href='/modifications/add?componentId=" + value.componentId + 
              "'><span class='glyphicons glyphicons-edit' aria-hidden='true'></span> +</a></th>" + 
            "<th><a class='btn btn-primary btn-xs' href='/doubts/add?componentId=" + value.componentId + 
              "'><span class='glyphicons glyphicons-edit' aria-hidden='true'></span> +</a></th>" + 
            "<th><a class='btn btn-primary btn-xs' href='/issues/add?componentId=" + value.componentId + 
              "'><span class='glyphicons glyphicons-edit' aria-hidden='true'></span> +</a></th>" + 
            "<th><a class='btn btn-success btn-xs' href='/components/" + value.componentId + 
              "'><span class='glyphicons glyphicons-edit' aria-hidden='true'></span> Editar</a></th></tr>"
          );

          designRealDeliverDate = new Date(value.componentDesignRealDeliverDate);
          date1 = designRealDeliverDate.getDate() + "/" + designRealDeliverDate.getMonth() + "/" + designRealDeliverDate.getFullYear();
          possibleDeliverDate = new Date(value.componentPossibleDeliverDate);
          date2 = possibleDeliverDate.getDate() + "/" + possibleDeliverDate.getMonth() + "/" + possibleDeliverDate.getFullYear();
          previewDeliverDate = new Date(value.componentPreviewDeliverDate);
          date3 = previewDeliverDate.getDate() + "/" + previewDeliverDate.getMonth() + "/" + previewDeliverDate.getFullYear();
          realDeliverDate = new Date(value.componentRealDeliverDate);
          date4 = realDeliverDate.getDate() + "/" + realDeliverDate.getMonth() + "/" + realDeliverDate.getFullYear();

          $("#tab-fecha > table > tbody").append(
            "<tr><th>" + value.componentName + "</th>" +
            "<th>" + "" + "</th>" +
            "<th><input type='text' id='date1-" + value.componentId + "' value='" + date1 +"' class='form-control'></th>" +
            "<th><input type='text' id='date2-" + value.componentId + "' value='" + date2 + "' class='form-control'></th>" +
            "<th><input type='text' id='date3-" + value.componentId + "' value='" + date3 + "' class='form-control'></th>" +
            "<th><input type='text' id='date4-" + value.componentId + "' value='" + date4 + "' class='form-control'></th>" +
            "<th><input type='text' id='estado-" + value.componentId + "' value='' class='form-control' readonly ></th></tr>"

          );
          $("#date1-" + value.componentId).datetimepicker({ format: 'DD/MM/YYYY' });
          $("#date2-" + value.componentId).datetimepicker({ format: 'DD/MM/YYYY' });
          $("#date3-" + value.componentId).datetimepicker({ format: 'DD/MM/YYYY' });
          $("#date4-" + value.componentId).datetimepicker({ format: 'DD/MM/YYYY' });

          $("#tab-cierre > table > tbody").append(
            "<tr><th>" + value.componentName + "</th>" +
            "<th>" + "" + "</th>" +
            "<th><select class='form-control' id='tipFin-" + value.componentId + "'><option></option><option></option></select></th>" +
            "<th><input type='text' id='difFin-" + value.componentId + "' value='' class='form-control' readonly></th>" +
            "<th><input type='text' id='costFin-" + value.componentId + "' value='' class='form-control' readonly></th>" +
            "<th><input type='text' id='horFin-" + value.componentId + "' value='' class='form-control' readonly></th>" +
            "<th><input type='text' id='comments-" + value.componentId + "' value='' class='form-control'></th>" +
            "<th><select class='form-control' id='estatusTip-" + value.componentId + "'><option value=''></option></select></th>" +
            "<th><select class='form-control' id='facturar-" + value.componentId + "'><option value='1'>SI</option><option value='0'>NO</option></select></th></tr>"
          );

        });

        $("#tab-fecha > table > tbody").append(
          "<tr style='background-color:#004582;'><th></th>" +
          "<th></th>" +
          "<th><input type='text' id='date1' value='' class='form-control'></th>" +
          "<th><input type='text' id='date2' value='' class='form-control'></th>" +
          "<th><input type='text' id='date3' value='' class='form-control'></th>" +
          "<th><input type='text' id='date4' value='' class='form-control'></th>" +
          "<th></th></tr>"
        );

        $('#date1').datetimepicker({format: 'DD/MM/YYYY'});
        $('#date2').datetimepicker({format: 'DD/MM/YYYY'});
        $('#date3').datetimepicker({format: 'DD/MM/YYYY'});
        $('#date4').datetimepicker({format: 'DD/MM/YYYY'});
      } else {
        new jBox('Notice', {
          content: 'Tu búsqueda no devolvió resultados',
          animation: 'pulse',
          color: 'red'
        });
      }

      HoldOn.close();
    }).fail(function (fail) {
      HoldOn.close();
    });
  });


  $("#btn-clear").click(function () {
    
    $("#slct_subidreccion").addClass("mdc-select--disabled");

    direccion.selectedIndex = -1;
    subidreccion.selectedIndex = -1;
    empresa.selectedIndex = -1;
    tecnologia.selectedIndex = -1;
    nuevo_modificado.selectedIndex = -1;
    estado.selectedIndex = -1;
    tipologia_inicial.selectedIndex = -1;
    tipologia_final.selectedIndex = -1;
    estado_tipificado.selectedIndex = -1;

    $("#principalId").val("");
    $("#subPrincipalId").val("");
    $("#companyId").val("");
    $("#technologyId").val("");
    $("#typologyNewComponent").val("");
    $("#statusId").val("");
    $("#startProductId").val("");
    $("#finalProductId").val("");
    $("#typologyStartSeverity").val("");
    $("#statusTypologyId").val("");
    $("#typologyFinalSeverity").val("");

    $("#componentName").val("");
    $("#requirementName").val("");
    $("#componentVersion").val("");
    $("#componentDesignRealDeliverDate").val("");
    $("#componentPreviewDeliverDate").val("");
    $("#componentPossibleDeliverDate").val("");
    $("#componentRealDeliverDate").val("");
    $("#typologyStartSeverityHours").val("");
    $("#typologyFinalSeverityHours").val("");

    $("#tab-componentes > table > tbody").html("");
    $("#tab-fecha > table > tbody").html("");
    $("#tab-cierre > table > tbody").html("");

    $("#row-title-results").hide();
    $("#row-content-results").hide();
    $("#row-buttons-results").hide();

    $("#mdc-group-typologyStartSeverity > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-typologyStartSeverityHours > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-typologyFinalSeverity > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-typologyFinalSeverityHours > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-componentName > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-requirementName > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-componentVersion > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-componentDesignRealDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-componentPreviewDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-componentPossibleDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-componentRealDeliverDate > label").removeClass("mdc-text-field__label--float-above");

    $("#slct_direccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_subidreccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_empresa > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_tecnologia > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_nuevo_modificado > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_estado > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_tipologia_inicial > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_tipologia_final > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_estado_tipificado > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
  });

  $("#update-all-dates").click(function(){});
  
  $("#update-dates").click(function(){});
  
  $("#update-closure").click(function(){});
});

mdc.autoInit()
