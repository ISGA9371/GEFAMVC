mdc.autoInit()

$(function () {

  /** 
   * datepicker
   * dateFormat: "dd-mm-yy"
  */
  $('#componentDesignRealDeliverDate').datepicker({
    format: 'DD/MM/YYYY'
  });

  $('#componentPreviewDeliverDate').datepicker({
    format: 'DD/MM/YYYY'
  });

  $('#componentPossibleDeliverDate').datepicker({
    format: 'DD/MM/YYYY'
  });

  $('#componentRealDeliverDate').datepicker({
    format: 'DD/MM/YYYY'
  });


  $.ajax({
    url: "/api/technologies",
    method: "GET",
    beforeSend: function () {
      $("#slct_tecnologia").addClass("mdc-select--disabled");
      $("#slct_tecnologia > .mdc-select__surface > .mdc-select__selected-text").html("");
      $("#slct_tecnologia > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    }
  }).done(function (data) {
    lis = "";
    if ('undefined' !== typeof data.data && 0 < data.data.length) {
      $.each(data.data, function (index, value) {
        lis += "<li class='mdc-list-item' role='option' tabindex='0' id='" + value.technologyId + "'>" + value.technologyName + "</li>";
      });

      $("#slct_tecnologia > .mdc-menu > ul").append(lis);
      $("#slct_tecnologia").removeClass("mdc-select--disabled");
    } else {
      lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
      $("#slct_tecnologia > .mdc-menu > ul").append(lis);
      $("#slct_tecnologia").addClass("mdc-select--disabled");
    }
  }).fail(function () {
    lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
    $("#slct_tecnologia > .mdc-menu > ul").append(lis);
    $("#slct_tecnologia").addClass("mdc-select--disabled");
  });


  var typologiesModified = [];
  var optionsModified = "";
  $.ajax({
    url: "/api/typologies/types?componentModified=true",
    method: "GET",
  }).done(function (data) {
    $.each(data.data, function(index, value){
      typologiesModified.push({
        id: value.typologyId,
        severity: value.typologySeverity,
        hours: value.typologySeverityHours,
        year: value.typologyYear,
        typology: value.product.productId
      });
      optionsModified += "<option value='" + value.typologyId + "' data-severity='" + value.typologySeverity + "' data-hours='" + value.typologySeverityHours+"'>" + value.product.productId + "</option>";
    });
  }).fail(function () {
  });

  var typologiesNew = [];
  var optionsNew = "";
  $.ajax({
    url: "/api/typologies/types?componentModified=false",
    method: "GET",
  }).done(function (data) {
    $.each(data.data, function (index, value) {
      typologiesNew.push({
        id: value.typologyId,
        severity: value.typologySeverity,
        hours: value.typologySeverityHours,
        year: value.typologyYear,
        typology: value.product.productId
      });
      optionsNew += "<option value='" + value.typologyId + "' data-severity='" + value.typologySeverity + "' data-hours='" + value.typologySeverityHours + "'>" + value.product.productId + "</option>";
    });
  }).fail(function () {
  });


  var optionsTipif = "<option value=''></option>";
  $.ajax({
    url: "/api/status-types/3/status",
    method: "GET",
  }).done(function (data) {
    $.each(data.data, function (index, value) {
      optionsTipif += "<option value='" + value.statusId + "'>" + value.statusName + "</option>";
    });
  }).fail(function () {
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

  componentDesignRealDeliverDate = new mdc.textField.MDCTextField(document.querySelector('#mdc-group-componentDesignRealDeliverDate'));
  componentPreviewDeliverDate = new mdc.textField.MDCTextField(document.querySelector('#mdc-group-componentPreviewDeliverDate'));
  componentPossibleDeliverDate = new mdc.textField.MDCTextField(document.querySelector('#mdc-group-componentPossibleDeliverDate'));
  componentRealDeliverDate = new mdc.textField.MDCTextField(document.querySelector('#mdc-group-componentRealDeliverDate'));

  $("#componentDesignRealDeliverDate").change(function () {
    if ("" != componentDesignRealDeliverDate.value) {
      $("#mdc-group-componentDesignRealDeliverDate > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc-group-componentDesignRealDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    }
  });

  $("#componentPreviewDeliverDate").change(function () {
    if ("" != componentPreviewDeliverDate.value) {
      $("#mdc-group-componentPreviewDeliverDate > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc-group-componentPreviewDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    }
  });

  $("#componentPossibleDeliverDate").change(function () {
    if ("" != componentPossibleDeliverDate.value) {
      $("#mdc-group-componentPossibleDeliverDate > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc-group-componentPossibleDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    }
  });

  $("#componentRealDeliverDate").change(function () {
    if ("" != componentRealDeliverDate.value) {
      $("#mdc-group-componentRealDeliverDate > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc-group-componentRealDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    }
  });


  $("#tab-componentes > table > tbody").on("click", "a.changeWindow", function (event) {
    HoldOn.open({
      theme: "sk-cube",
      content: '',
      message: 'Cargando...',
      backgroundColor: "#0c71ca",
      textColor: "white",
    });
  });
  

  direccion.listen('MDCSelect:change', () => {
    idSuperior = direccion.value;

    subidreccion.selectedIndex = -1;
    subidreccion.value = "";

    $.ajax({
      url: "/api/levels/" + idSuperior + "/sub-levels",
      method: "GET",
      beforeSend: function() {
        $("#slct_subidreccion").addClass("mdc-select--disabled");
        $("#slct_subidreccion > .mdc-select__surface > .mdc-select__selected-text").html("");
        $("#slct_subidreccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
      }
    }).done(function (data) {
      $("#slct_subidreccion > .mdc-menu > ul").html("");
      lis = "";
      if ( 'undefined' !== typeof data.data && 0 < data.data.length) {
        $.each(data.data, function (index, value) {
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

    var params = {
      principalId: $("#principalId").val(),
      subPrincipalId: $("#subPrincipalId").val(),
      companyId: $("#companyId").val(),
      technologyId: $("#technologyId").val(),
      typologyNewComponent: $("#typologyNewComponent").val(),
      statusId: $("#statusId").val(),
      startProductId: $("#startProductId").val(),
      finalProductId: $("#finalProductId").val(),
      statusTypologyId: $("#statusTypologyId").val(),
      componentName: $("#componentName").val(),
      requirementName: $("#requirementName").val(),
      componentVersion: $("#componentVersion").val(),
      componentDesignRealDeliverDate: $("#componentDesignRealDeliverDate").val(),
      componentPreviewDeliverDate: $("#componentPreviewDeliverDate").val(),
      componentPossibleDeliverDate: $("#componentPossibleDeliverDate").val(),
      componentRealDeliverDate: $("#componentRealDeliverDate").val(),
      typologyStartSeverity: $("#typologyStartSeverity").val(),
      typologyStartSeverityHours: $("#typologyStartSeverityHours").val(),
      typologyFinalSeverity: $("#typologyFinalSeverity").val(),
      typologyFinalSeverityHours: $("#typologyFinalSeverityHours").val(),
    };

    $.ajax({
      url: "/components/search",
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

      if (1 <= data.length) {

        $("#row-title-results").show();
        $("#row-content-results").show();
        $("#row-buttons-results").show();

        $("#tab-componentes > table > tbody").html("");
        $("#tab-fecha > table > tbody").html("");
        $("#tab-cierre > table > tbody").html("");

        idsSearch = [];

        $.each(data, function (index, value) {

          if ( value.startTypology.typologyComponentModified ) {
            newModified = "MODIFICADO";
            options = optionsModified;
            classIdentifier = "component-modified";
          } else {
            newModified = "NUEVO";
            options = optionsNew;
            classIdentifier = "component-new";
          }

          $("#tab-componentes > table > tbody").append(
            "<tr><td></td>" +
            "<td>" + value.componentName + "</td>" +
            "<td>" + value.requirement.requirementName + "</td>" +
            "<td>" + value.componentVersion + "</td>" +
            "<td>" + value.requirement.level.levelSuperior.levelName + "</td>" +
            "<td>" + value.requirement.level.levelName  + "</td>" +
            "<td>" + value.requirement.company.companyName + "</td>" +
            "<td>" + value.requirement.application.technology.technologyName + "</td>" +
            "<td>" + newModified + "</td>" +
            "<td><a class='btn btn-primary btn-xs changeWindow' style='color:white;' href='/modifications/add?componentId=" + value.componentId + 
              "'><span class='glyphicons glyphicons-edit' aria-hidden='true'></span> +</a></td>" + 
            "<td><a class='btn btn-primary btn-xs changeWindow' style='color:white;' href='/doubts/add?componentId=" + value.componentId + 
              "'><span class='glyphicons glyphicons-edit' aria-hidden='true'></span> +</a></td>" + 
            "<td><a class='btn btn-primary btn-xs changeWindow' style='color:white;' href='/issues/add?componentId=" + value.componentId + 
              "'><span class='glyphicons glyphicons-edit' aria-hidden='true'></span> +</a></td>" + 
            "<td><a class='btn btn-primary btn-xs changeWindow' style='color:white;' href='/components/" + value.componentId + 
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
            "<td><input type='text' id='date1-" + value.componentId + "' value='" + date1 +"' class='form-control date1Text'></td>" +
            "<td><input type='text' id='date2-" + value.componentId + "' value='" + date2 + "' class='form-control date2Text'></td>" +
            "<td><input type='text' id='date3-" + value.componentId + "' value='" + date3 + "' class='form-control date3Text'></td>" +
            "<td><input type='text' id='date4-" + value.componentId + "' value='" + date4 + "' class='form-control date4Text'></td>" +
            "<td>"+ value.status.statusName +"</td></tr>"
          );
          $("#date1-" + value.componentId).datepicker({ format: 'DD/MM/YYYY' });
          $("#date2-" + value.componentId).datepicker({ format: 'DD/MM/YYYY' });
          $("#date3-" + value.componentId).datepicker({ format: 'DD/MM/YYYY' });
          $("#date4-" + value.componentId).datepicker({ format: 'DD/MM/YYYY' });

          $("#tab-cierre > table > tbody").append(
            "<tr><td>" + value.componentName + "</td>" +
            "<td>" + value.requirement.requirementName + "</td>" +
            "<td><select class='form-control "+classIdentifier+"' id='tipFin-" + value.componentId + "'>"+options+"</select></td>" +
            "<td><input type='text' id='difFin-" + value.componentId + "' value='' class='form-control text-center' readonly></td>" +
            "<td><input type='text' id='costFin-" + value.componentId + "' value='' class='form-control text-center' readonly></td>" +
            "<td><input type='text' id='horFin-" + value.componentId + "' value='' class='form-control text-center' readonly></td>" +
            "<td><input type='text' id='comments-" + value.componentId + "' value='" + value.componentTypoComment + "' class='form-control'></td>" +
            "<td><select class='form-control' id='estatusTip-" + value.componentId + "'>" + optionsTipif+"</select></td>" +
            "<td><select class='form-control' id='facturar-" + value.componentId + "'><option value='1'>SI</option><option value='0'>NO</option></select></td></tr>"
          );

          $("#tipFin-" + value.componentId).val(value.finalTypology.typologyId);
          $("#difFin-" + value.componentId).val(value.finalTypology.typologySeverity);
          $("#horFin-" + value.componentId).val(value.finalTypology.typologySeverityHours);
          $("#estatusTip-" + value.componentId).val(value.statusTypology.statusId);

          idsSearch.push(value.componentId);
        });
        $(".component-modified").change(function () {
          var idElement = $(this).attr("id").substring(7, $(this).attr("id").length);
          var optionElement = $("#tipFin-" + idElement).find("option[value=" + $(this).val() + "]");
          $("#difFin-" + idElement).val( optionElement.data("severity") );
          $("#horFin-" + idElement).val( optionElement.data("hours") );
        });

        $(".component-new ").change(function () {
          var idElement = $(this).attr("id").substring(7, $(this).attr("id").length);
          var optionElement = $("#tipFin-" + idElement).find("option[value=" + $(this).val() + "]");
          $("#difFin-" + idElement).val(optionElement.data("severity"));
          $("#horFin-" + idElement).val(optionElement.data("hours"));
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

    componentDesignRealDeliverDate.value = "";
    componentPreviewDeliverDate.value = "";
    componentPossibleDeliverDate.value = "";
    componentRealDeliverDate.value = "";

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

  $("#update-all-dates").click(function(){
    data = {
      'designRealDeliverDate': date1,
      'possibleDeliverDate': date2,
      'previewDeliverDate': date3,
      'realDeliverDate': date4,
      'ids': idsSearch,
    };
    console.log(data);

  });
  
  $("#update-dates").click(function(){
    data = [];

    var date1 = $(".date1Text");
    var date2 = $(".date2Text");
    var date3 = $(".date3Text");
    var date4 = $(".date4Text");

    $.each(date1, function(index, value){
      data.push({
        'id': value.id,
        'designRealDeliverDate': value.value,
        'possibleDeliverDate': date2[index].value,
        'previewDeliverDate': date3[index].value,
        'realDeliverDate': date4[index].value,
      });
    });
    console.log(data);
  });
  
  $("#update-closure").click(function(){
    data = [];

    var tr = $("#tab-cierre > table > tbody").children();
    $.each(tr, function(index, value){
      tds = $(value).children();;
      id = $(tds[2]).children().attr("id").substring(7, $(tds[2]).children().attr("id").length);

      data.push({
        'tipFinal': $(tds[2]).children().val(),
        'difFinal': $(tds[3]).children().val(),
        'cosFinal': $(tds[4]).children().val(),
        'horsFinal': $(tds[5]).children().val(),
        'comments': $(tds[6]).children().val(),
        'statusTipif': $(tds[7]).children().val(),
        'facturar': $(tds[8]).children().val(),
        'id': id,
      });

    });

    console.log(data);
  });
});
