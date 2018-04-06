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
  const dificultad_inicial = new mdc.select.MDCSelect(document.querySelector('#slct_dificultad_inicial'));
  const estado_tipificado = new mdc.select.MDCSelect(document.querySelector('#slct_estado_tipificado'));
  const dificultad_final = new mdc.select.MDCSelect(document.querySelector('#slct_dificultad_final '));


  direccion.listen('MDCSelect:change', () => {
    //  alert(`Selected "${tecnologia.selectedOptions[0].textContent}" at index ${tecnologia.selectedIndex} ` +
    //    `with value "${tecnologia.value}"`);
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
    $("#typologyStartSeverity").val(dificultad_inicial.value);
    $("#statusTypologyId").val(estado_tipificado.value);
    $("#typologyFinalSeverity").val(dificultad_final.value);

    // serializeArray = $("#searchForm").serializeArray();
    // objectito = {};
    // $.each(serializeArray, function (index, value) {
    //   objectito[value.name] = value.value;
    // });

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

          // componentDesignRealDeliverDate = new Date(value.componentDesignRealDeliverDate);
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
            "<th>" + date1 + "</th>" +
            "<th>" + date2 + "</th>" +
            "<th>" + date3 + "</th>" +
            "<th>" + date4 + "</th>" +
            "<th>" + "" + "</th></tr>"
          );

          /*
          $("#tab-cierre > table > tbody").append(
            "<tr><th>" + "Tip. Final" + "</th>" +
            "<th>" + "Dif. Final" + "</th>" +
            "<th>" + "Costo Final" + "</th>" +
            "<th>" + "Horas Finales" + "</th>" +
            "<th>" + "Comentarios" + "</th>" +
            "<th>" + "Estat Tipif." + "</th>" +
            "<th>" + "Facturar(S/N)" + "</th></tr>"
          );
          */
        });
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
    direccion.selectedIndex = -1;
    subidreccion.selectedIndex = -1;
    empresa.selectedIndex = -1;
    tecnologia.selectedIndex = -1;
    nuevo_modificado.selectedIndex = -1;
    estado.selectedIndex = -1;
    tipologia_inicial.selectedIndex = -1;
    tipologia_final.selectedIndex = -1;
    dificultad_inicial.selectedIndex = -1;
    estado_tipificado.selectedIndex = -1;
    dificultad_final.selectedIndex = -1;

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

  });

  mdc.autoInit()
});

