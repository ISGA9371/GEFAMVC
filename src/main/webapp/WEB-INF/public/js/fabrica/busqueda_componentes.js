mdc.autoInit()

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
    $("#slct_subidreccion").addClass("mdc-select--disabled");

    idSuperior = direccion.value;

    $.ajax({
      url: "/levels/" + idSuperior + "/sublevel",
      method: "GET"
    }).done(function (data) {

      $("#slct_subidreccion > .mdc-select__surface > .mdc-select__selected-text").html("");
      $("#slct_subidreccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
      subidreccion.selectedIndex = -1;
      subidreccion.value = "";

      lis = "";
      if ( 'undefined' !== typeof data && 0 < data.length) {
        
        $("#slct_subidreccion > .mdc-menu > ul").html("");

        $.each(data, function (index, value) {
          lis += "<li class='mdc-list-item' role='option' tabindex='0' id='" + value.levelId + "'>" + value.levelName + "</li>";  
        });
        
        $("#slct_subidreccion > .mdc-menu > ul").append(lis);
        $("#slct_subidreccion").removeClass("mdc-select--disabled");
      } else {
        lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
        $("#slct_subidreccion > .mdc-menu > ul").append(lis);
        $("#slct_subidreccion").addClass("mdc-select--disabled");
      }
    }).fail(function(){
      $("#slct_subidreccion > .mdc-select__surface > .mdc-select__selected-text").html("");
      $("#slct_subidreccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
      subidreccion.selectedIndex = -1;
      subidreccion.value = "";

      lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
      $("#slct_subidreccion > .mdc-menu > ul").append(lis);
      $("#slct_subidreccion").addClass("mdc-select--disabled");
    });
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
            "<tr><td></td>" +
            "<td>" + value.componentName + "</td>" +
            "<td>" + value.requirement.requirementName + "</td>" +
            "<td>" + value.componentVersion + "</td>" +
            "<td>" + value.requirement.level.levelSuperior.levelName + "</td>" +
            "<td>" + value.requirement.level.levelName  + "</td>" +
            "<td>" + value.requirement.company.companyName + "</td>" +
            "<td>" + value.requirement.application.technology.technologyName + "</td>" +
            "<td>" + "" + "</td>" +
            "<td><a class='btn btn-primary btn-xs' href='/modifications/add?componentId=" + value.componentId + 
              "'><span class='glyphicons glyphicons-edit' aria-hidden='true'></span> +</a></td>" + 
            "<td><a class='btn btn-primary btn-xs' href='/doubts/add?componentId=" + value.componentId + 
              "'><span class='glyphicons glyphicons-edit' aria-hidden='true'></span> +</a></td>" + 
            "<td><a class='btn btn-primary btn-xs' href='/issues/add?componentId=" + value.componentId + 
              "'><span class='glyphicons glyphicons-edit' aria-hidden='true'></span> +</a></td>" + 
            "<td><a class='btn btn-success btn-xs' href='/components/" + value.componentId + 
              "'><span class='glyphicons glyphicons-edit' aria-hidden='true'></span> Editar</a></td></tr>"
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
            "<tr><td>" + value.componentName + "</td>" +
            "<td>" + value.requirement.requirementName + "</td>" +
            "<td><input type='text' id='date1-" + value.componentId + "' value='" + date1 +"' class='form-control'></td>" +
            "<td><input type='text' id='date2-" + value.componentId + "' value='" + date2 + "' class='form-control'></td>" +
            "<td><input type='text' id='date3-" + value.componentId + "' value='" + date3 + "' class='form-control'></td>" +
            "<td><input type='text' id='date4-" + value.componentId + "' value='" + date4 + "' class='form-control'></td>" +
            /* "<td><input type='text' id='estado-" + value.componentId + "' value='"+ value.status.statusName +"' class='form-control' readonly ></td></tr>" */
            "<td>"+ value.status.statusName +"</td></tr>"
          );
          $("#date1-" + value.componentId).datetimepicker({ format: 'DD/MM/YYYY' });
          $("#date2-" + value.componentId).datetimepicker({ format: 'DD/MM/YYYY' });
          $("#date3-" + value.componentId).datetimepicker({ format: 'DD/MM/YYYY' });
          $("#date4-" + value.componentId).datetimepicker({ format: 'DD/MM/YYYY' });

          $("#tab-cierre > table > tbody").append(
            "<tr><td>" + value.componentName + "</td>" +
            "<td>" + value.requirement.requirementName + "</td>" +
            "<td><select class='form-control' id='tipFin-" + value.componentId + "'><option></option><option></option></select></td>" +
            "<td><input type='text' id='difFin-" + value.componentId + "' value='' class='form-control' readonly></td>" +
            "<td><input type='text' id='costFin-" + value.componentId + "' value='' class='form-control' readonly></td>" +
            "<td><input type='text' id='horFin-" + value.componentId + "' value='' class='form-control' readonly></td>" +
            "<td><input type='text' id='comments-" + value.componentId + "' value='" + value.componentTypoComment + "' class='form-control'></td>" +
            "<td><select class='form-control' id='estatusTip-" + value.componentId + "'><option value=''></option></select></td>" +
            "<td><select class='form-control' id='facturar-" + value.componentId + "'><option value='1'>SI</option><option value='0'>NO</option></select></td></tr>"
          );

        });

        $("#tab-fecha > table > tbody").append(
          "<tr style='background-color:#004582;'><td></td>" +
          "<td></td>" +
          "<td><input type='text' id='date1' value='' class='form-control'></td>" +
          "<td><input type='text' id='date2' value='' class='form-control'></td>" +
          "<td><input type='text' id='date3' value='' class='form-control'></td>" +
          "<td><input type='text' id='date4' value='' class='form-control'></td>" +
          "<td></td></tr>"
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
    // subidreccion.selectedIndex = -1;
    empresa.selectedIndex = -1;
    tecnologia.selectedIndex = -1;
    nuevo_modificado.selectedIndex = -1;
    estado.selectedIndex = -1;
    tipologia_inicial.selectedIndex = -1;
    tipologia_final.selectedIndex = -1;
    estado_tipificado.selectedIndex = -1;

    /** for hidden values related to MDC Select */
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

    /** mdc TEXT field */
    $("#componentName").val("");
    $("#requirementName").val("");
    $("#componentVersion").val("");
    $("#componentDesignRealDeliverDate").val("");
    $("#componentPreviewDeliverDate").val("");
    $("#componentPossibleDeliverDate").val("");
    $("#componentRealDeliverDate").val("");
    $("#typologyStartSeverity").val("");
    $("#typologyStartSeverityHours").val("");
    $("#typologyFinalSeverity").val("");
    $("#typologyFinalSeverityHours").val("");

    $("#mdc-group-componentName > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-requirementName > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-componentVersion > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-componentDesignRealDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-componentPreviewDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-componentPossibleDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-componentRealDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-typologyStartSeverity > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-typologyStartSeverityHours > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-typologyFinalSeverity > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-typologyFinalSeverityHours > label").removeClass("mdc-text-field__label--float-above");

    /** Results section */
    $("#tab-componentes > table > tbody").html("");
    $("#tab-fecha > table > tbody").html("");
    $("#tab-cierre > table > tbody").html("");
    $("#row-title-results").hide();
    $("#row-content-results").hide();
    $("#row-buttons-results").hide();

    /** MDC SELECT */
    $("#slct_direccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_subidreccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_empresa > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_tecnologia > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_nuevo_modificado > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_estado > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_tipologia_inicial > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_tipologia_final > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_estado_tipificado > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");

    $("#slct_direccion > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_subidreccion > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_empresa > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_tecnologia > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_nuevo_modificado > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_estado > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_tipologia_inicial > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_tipologia_final > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_estado_tipificado > .mdc-select__surface > .mdc-select__selected-text").html("");

    $("#slct_direccion").removeClass("mdc-select--upgraded");
    $("#slct_subidreccion").removeClass("mdc-select--upgraded");
    $("#slct_empresa").removeClass("mdc-select--upgraded");
    $("#slct_tecnologia").removeClass("mdc-select--upgraded");
    $("#slct_nuevo_modificado").removeClass("mdc-select--upgraded");
    $("#slct_estado").removeClass("mdc-select--upgraded");
    $("#slct_tipologia_inicial").removeClass("mdc-select--upgraded");
    $("#slct_tipologia_final").removeClass("mdc-select--upgraded");
    $("#slct_estado_tipificado").removeClass("mdc-select--upgraded");
    
  });

  $("#update-all-dates").click(function(){});
  
  $("#update-dates").click(function(){});
  
  $("#update-closure").click(function(){});
});
