const mdc_text_componentName = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_componentName"));
const mdc_text_requirementName = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_requirementName"));
const mdc_text_componentVersion = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_componentVersion"));
const mdc_select_direccion = new mdc.select.MDCSelect(document.querySelector("#mdc_select_direccion"));
const mdc_select_subdireccion = new mdc.select.MDCSelect(document.querySelector("#mdc_select_subdireccion"));
const mdc_select_empresa = new mdc.select.MDCSelect(document.querySelector("#mdc_select_empresa"));
const mdc_select_tecnologia = new mdc.select.MDCSelect(document.querySelector("#mdc_select_tecnologia"));
const mdc_select_nuevo_modificado = new mdc.select.MDCSelect(document.querySelector("#mdc_select_nuevo_modificado"));
const mdc_select_estado = new mdc.select.MDCSelect(document.querySelector("#mdc_select_estado"));
const mdc_text_componentDesignRealDeliverDate = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_componentDesignRealDeliverDate"));
const mdc_text_componentPreviewDeliverDate = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_componentPreviewDeliverDate"));
const mdc_select_tipologia_inicial = new mdc.select.MDCSelect(document.querySelector("#mdc_select_tipologia_inicial"));
const mdc_text_componentPossibleDeliverDate = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_componentPossibleDeliverDate"));
const mdc_text_componentRealDeliverDate = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_componentRealDeliverDate"));
const mdc_select_tipologia_final = new mdc.select.MDCSelect(document.querySelector("#mdc_select_tipologia_final"));
const mdc_text_typologyStartSeverity = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_typologyStartSeverity"));
const mdc_text_typologyStartSeverityHours = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_typologyStartSeverityHours"));
const mdc_select_estado_tipificado = new mdc.select.MDCSelect(document.querySelector("#mdc_select_estado_tipificado"));
const mdc_text_typologyFinalSeverity = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_typologyFinalSeverity"));
const mdc_text_typologyFinalSeverityHours = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_typologyFinalSeverityHours"));

$(document).ready(function () {

  /** 
   * datepicker
   * dateFormat: "dd-mm-yy"
  */  
  $('#componentDesignRealDeliverDate').datepicker({
    dateFormat: "dd/mm/yy"
  });

  $('#componentPreviewDeliverDate').datepicker({
    dateFormat: "dd/mm/yy"
  });

  $('#componentPossibleDeliverDate').datepicker({
    dateFormat: "dd/mm/yy"
  });

  $('#componentRealDeliverDate').datepicker({
    dateFormat: "dd/mm/yy"
  });

  var numberMonths = ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'];


  /**
   * Technologies ajax call
   */
  $.ajax({
    url: "/api/technologies",
    method: "GET",
    beforeSend: function () {
      $("#mdc_select_tecnologia").addClass("mdc-select--disabled");
      $("#mdc_select_tecnologia > .mdc-select__surface > .mdc-select__selected-text").html("");
      $("#mdc_select_tecnologia > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    }
  }).done(function (data) {
    lis = "";
    if ('undefined' !== typeof data.data && 0 < data.data.length) {
      $.each(data.data, function (index, value) {
        lis += "<li class='mdc-list-item' role='option' tabindex='0' id='" + value.technologyId + "'>" + value.technologyName + "</li>";
      });

      $("#mdc_select_tecnologia > .mdc-menu > ul").append(lis);
      $("#mdc_select_tecnologia").removeClass("mdc-select--disabled");
    } else {
      lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
      $("#mdc_select_tecnologia > .mdc-menu > ul").append(lis);
      $("#mdc_select_tecnologia").addClass("mdc-select--disabled");
    }
  }).fail(function () {
    lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
    $("#mdc_select_tecnologia > .mdc-menu > ul").append(lis);
    $("#mdc_select_tecnologia").addClass("mdc-select--disabled");
  });
  /******************* */


  /**
   * Typologies [ modified=true ] ajax call
   */
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
  /******************* */


  /**
   * Typologies [ modified=false ] ajax call
   */
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
  /******************* */


  /**
   * Status ajax call
   */
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
  /******************* */


  $("#tabs").tabs();


  $("#componentDesignRealDeliverDate").change(function () {
    if ("" != mdc_text_componentDesignRealDeliverDate.value) {
      $("#mdc_text_componentDesignRealDeliverDate > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_text_componentDesignRealDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    }
  });

  $("#componentPreviewDeliverDate").change(function () {
    if ("" != mdc_text_componentPreviewDeliverDate.value) {
      $("#mdc_text_componentPreviewDeliverDate > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_text_componentPreviewDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    }
  });

  $("#componentPossibleDeliverDate").change(function () {
    if ("" != mdc_text_componentPossibleDeliverDate.value) {
      $("#mdc_text_componentPossibleDeliverDate > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_text_componentPossibleDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    }
  });

  $("#componentRealDeliverDate").change(function () {
    if ("" != mdc_text_componentRealDeliverDate.value) {
      $("#mdc_text_componentRealDeliverDate > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_text_componentRealDeliverDate > label").removeClass("mdc-text-field__label--float-above");
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

  $("body").on("change", "select.component-modified", function (event) {
    var idElement = $(this).attr("id").substring(7, $(this).attr("id").length);
    var optionElement = $("#tipFin-" + idElement).find("option[value=" + $(this).val() + "]");
    $("#difFin-" + idElement).val(optionElement.data("severity"));
    $("#horFin-" + idElement).val(optionElement.data("hours"));

    theFare = $("#costFin-" + idElement).data("costo");
    newFare = parseInt(theFare) * parseInt(optionElement.data("hours"));
    $("#costFin-" + idElement).val(newFare);
  });

  $("body").on("change", "select.component-new", function (event) {
    var idElement = $(this).attr("id").substring(7, $(this).attr("id").length);
    var optionElement = $("#tipFin-" + idElement).find("option[value=" + $(this).val() + "]");
    $("#difFin-" + idElement).val(optionElement.data("severity"));
    $("#horFin-" + idElement).val(optionElement.data("hours"));

    theFare = $("#costFin-" + idElement).data("costo");
    newFare = parseInt(theFare) * parseInt(optionElement.data("hours"));
    $("#costFin-" + idElement).val(newFare);
  });


  $("body").on("change", "#date1", function (event) {
    if ( $(this).val() != "" && $("#date2").val() != "" && $("#date3").val() != "" && $("#date4").val() != "" ) {
      $("#update-all-dates").removeAttr("disabled");
    } else {
      $("#update-all-dates").attr("disabled", "disabled");
    }
  });
  $("body").on("change", "#date2", function (event) {
    if ( $(this).val() != "" && $("#date1").val() != "" && $("#date3").val() != "" && $("#date4").val() != "" ) {
      $("#update-all-dates").removeAttr("disabled");
    } else {
      $("#update-all-dates").attr("disabled", "disabled");
    }
  });
  $("body").on("change", "#date3", function (event) {
    if ( $(this).val() != "" && $("#date2").val() != "" && $("#date1").val() != "" && $("#date4").val() != "" ) {
      $("#update-all-dates").removeAttr("disabled");
    } else {
      $("#update-all-dates").attr("disabled", "disabled");
    }
  });
  $("body").on("change", "#date4", function (event) {
    if ( $(this).val() != "" && $("#date2").val() != "" && $("#date3").val() != "" && $("#date1").val() != "" ) {
      $("#update-all-dates").removeAttr("disabled");
    } else {
      $("#update-all-dates").attr("disabled", "disabled");
    }
  });
  

  mdc_select_direccion.listen('MDCSelect:change', () => {
    idSuperior = mdc_select_direccion.value;

    mdc_select_subdireccion.selectedIndex = -1;
    mdc_select_subdireccion.value = "";

    $.ajax({
      url: "/api/levels/" + idSuperior + "/sub-levels",
      method: "GET",
      beforeSend: function() {
        $("#mdc_select_subdireccion").addClass("mdc-select--disabled");
        $("#mdc_select_subdireccion > .mdc-select__surface > .mdc-select__selected-text").html("");
        $("#mdc_select_subdireccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
      }
    }).done(function (data) {
      $("#mdc_select_subdireccion > .mdc-menu > ul").html("");
      lis = "";
      if ( 'undefined' !== typeof data.data && 0 < data.data.length) {
        $.each(data.data, function (index, value) {
          lis += "<li class='mdc-list-item' role='option' tabindex='0' id='" + value.levelId + "'>" + value.levelName + "</li>";  
        });
        
        $("#mdc_select_subdireccion > .mdc-menu > ul").append(lis);
        $("#mdc_select_subdireccion").removeClass("mdc-select--disabled");
      } else {
        lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
        $("#mdc_select_subdireccion > .mdc-menu > ul").append(lis);
        $("#mdc_select_subdireccion").addClass("mdc-select--disabled");
      }
    }).fail(function(){
      lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
      $("#mdc_select_subdireccion > .mdc-menu > ul").append(lis);
      $("#mdc_select_subdireccion").addClass("mdc-select--disabled");
    });
  });


  mdc_select_tipologia_inicial.listen('MDCSelect:change', () => {
    $("#typologyStartSeverity").val( $(mdc_select_tipologia_inicial.selectedOptions[0]).data("severity") );
    $("#mdc_text_typologyStartSeverity").addClass("mdc-text-field--upgraded");
    $("#mdc_text_typologyStartSeverity > label").addClass("mdc-text-field__label--float-above");

    $("#typologyStartSeverityHours").val( $(mdc_select_tipologia_inicial.selectedOptions[0]).data("hours") );
    $("#mdc_text_typologyStartSeverityHours").addClass("mdc-text-field--upgraded");
    $("#mdc_text_typologyStartSeverityHours > label").addClass("mdc-text-field__label--float-above");
  });

  mdc_select_tipologia_final.listen('MDCSelect:change', () => {
    $("#typologyFinalSeverity").val($(mdc_select_tipologia_final.selectedOptions[0]).data("severity"));
    $("#mdc_text_typologyFinalSeverity").addClass("mdc-text-field--upgraded");
    $("#mdc_text_typologyFinalSeverity > label").addClass("mdc-text-field__label--float-above");

    $("#typologyFinalSeverityHours").val($(mdc_select_tipologia_final.selectedOptions[0]).data("hours"));
    $("#mdc_text_typologyFinalSeverityHours").addClass("mdc-text-field--upgraded");
    $("#mdc_text_typologyFinalSeverityHours > label").addClass("mdc-text-field__label--float-above");
  });


  $("#btn-submit").click(function () {

    /** Results section */
    $("#tab-componentes > table > tbody").html("");
    $("#tab-fecha > table > tbody").html("");
    $("#tab-cierre > table > tbody").html("");
    $("#row-title-results").hide();
    $("#row-content-results").hide();
    $("#row-buttons-results").hide();
    $("#tabs").tabs("option", "active", 0);

    if ( "1" == mdc_select_nuevo_modificado.value ) {
      var newMod = true;
    } else if ( "0" == mdc_select_nuevo_modificado.value ) {
      var newMod = false;
    } else {
      var newMod = "";
    }

    var params = {
      principalId: mdc_select_direccion.value,
      subPrincipalId: mdc_select_subdireccion.value,
      companyId: mdc_select_empresa.value,
      technologyId: mdc_select_tecnologia.value,
      typologyComponentModified: newMod,
      statusId: mdc_select_estado.value,
      startProductId: mdc_select_tipologia_inicial.value,
      finalProductId: mdc_select_tipologia_final.value,
      statusTypologyId: mdc_select_estado_tipificado.value,
      componentName: mdc_text_componentName.value,
      requirementName: mdc_text_requirementName.value,
      componentVersion: mdc_text_componentVersion.value,
      
      componentDesignRealDeliverDate: changeFormatDate(mdc_text_componentDesignRealDeliverDate.value),
      componentPreviewDeliverDate: changeFormatDate(mdc_text_componentPreviewDeliverDate.value),
      componentPossibleDeliverDate: changeFormatDate(mdc_text_componentPossibleDeliverDate.value),
      componentRealDeliverDate: changeFormatDate(mdc_text_componentRealDeliverDate.value),
      
      typologyStartSeverity: mdc_text_typologyStartSeverity.value,
      typologyStartSeverityHours: mdc_text_typologyStartSeverityHours.value,
      typologyFinalSeverity: mdc_text_typologyFinalSeverity.value,
      typologyFinalSeverityHours: mdc_text_typologyFinalSeverityHours.value,
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
            "<tr>" +
            "<td>" + value.componentName + "</td>" +
            "<td>" + value.requirement.requirementName + "</td>" +
            "<td>" + value.componentVersion + "</td>" +
            "<td>" + value.requirement.level.levelSuperior.levelName + "</td>" +
            "<td>" + value.requirement.level.levelName  + "</td>" +
            "<td>" + value.requirement.company.companyName + "</td>" +
            "<td>" + value.requirement.application.technology.technologyName + "</td>" +
            "<td>" + newModified + "</td>" +
            "<td><a class='changeWindow' style='color:white;' href='/modifications/add?componentId=" + value.componentId + 
              "'><img src='/img/edit_icon.png' style='width: 30px;'></a></td>" +
            "<td><a class='changeWindow' style='color:white;' href='/doubts/add?componentId=" + value.componentId + 
              "'><img src='/img/question_icon.png' style='width: 30px;'></a></td>" + 
            "<td><a class='changeWindow' style='color:white;' href='/issues/add?componentId=" + value.componentId + 
              "'><img src='/img/cancel_icon.png' style='width: 30px;'></a></td>" + 
            "<td><a class='btn btn-primary btn-xs changeWindow' style='color:white;' href='/components/" + value.componentId + 
              "'><span class='glyphicons glyphicons-edit' aria-hidden='true'></span> Editar</a></td></tr>"
          );

          $("#tab-fecha > table > tbody").append(
            "<tr><td>" + value.componentName + "</td>" +
            "<td>" + value.requirement.requirementName + "</td>" +
            "<td><input type='text' id='date1-" + value.componentId + "' value='" + value.componentDesignRealDeliverDate + "' class='form-control date1Text' readonly='readonly'></td>" +
            "<td><input type='text' id='date2-" + value.componentId + "' value='" + value.componentPossibleDeliverDate + "' class='form-control date2Text' readonly='readonly'></td>" +
            "<td><input type='text' id='date3-" + value.componentId + "' value='" + value.componentPreviewDeliverDate + "' class='form-control date3Text' readonly='readonly'></td>" +
            "<td><input type='text' id='date4-" + value.componentId + "' value='" + value.componentRealDeliverDate + "' class='form-control date4Text' readonly='readonly'></td>" +
            "<td>"+ value.status.statusName +"</td></tr>"
          );
          $("#date1-" + value.componentId).datepicker({ dateFormat: "dd/mm/yy" });
          $("#date2-" + value.componentId).datepicker({ dateFormat: "dd/mm/yy" });
          $("#date3-" + value.componentId).datepicker({ dateFormat: "dd/mm/yy" });
          $("#date4-" + value.componentId).datepicker({ dateFormat: "dd/mm/yy" });

          $("#tab-cierre > table > tbody").append(
            "<tr><td>" + value.componentName + "</td>" +
            "<td>" + value.requirement.requirementName + "</td>" +
            "<td><select class='form-control "+classIdentifier+"' id='tipFin-" + value.componentId + "'>"+options+"</select></td>" +
            "<td><input type='text' id='difFin-" + value.componentId + "' value='' class='form-control text-center' readonly></td>" +
            "<td><input type='text' id='costFin-" + value.componentId + "' value='' class='form-control text-center' readonly data-costo='"+value.requirement.fareValue+"'></td>" +
            "<td><input type='text' id='horFin-" + value.componentId + "' value='' class='form-control text-center' readonly></td>" +
            "<td><input type='text' id='comments-" + value.componentId + "' value='" + value.componentTypoComment + "' class='form-control'></td>" +
            "<td><select class='form-control' id='estatusTip-" + value.componentId + "'>" + optionsTipif+"</select></td>" +
            "<td><select class='form-control' id='facturar-" + value.componentId + "'><option value='1'>SI</option><option value='0'>NO</option></select></td></tr>"
          );

          fare = parseInt(value.requirement.fareValue) * parseInt(value.finalTypology.typologySeverityHours);
          $("#tipFin-" + value.componentId).val(value.finalTypology.typologyId);
          $("#difFin-" + value.componentId).val(value.finalTypology.typologySeverity);
          $("#costFin-" + value.componentId).val(fare);
          $("#horFin-" + value.componentId).val(value.finalTypology.typologySeverityHours);
          $("#estatusTip-" + value.componentId).val(value.statusTypology.statusId);
          if ( value.componentForBill ) {
            $("#facturar-" + value.componentId).val("1");
          } else {
            $("#facturar-" + value.componentId).val("0");
          }

          idsSearch.push(parseInt(value.componentId));
        });

        $("#tab-fecha > table > tbody").append(
          "<tr style='background-color:#004582;'><td></td>" +
          "<td></td>" +
          "<td><input type='text' id='date1' value='' class='form-control' readonly='readonly'></td>" +
          "<td><input type='text' id='date2' value='' class='form-control' readonly='readonly'></td>" +
          "<td><input type='text' id='date3' value='' class='form-control' readonly='readonly'></td>" +
          "<td><input type='text' id='date4' value='' class='form-control' readonly='readonly'></td>" +
          "<td></td></tr>"
        );

        $('#date1').datepicker({dateFormat: "dd/mm/yy"});
        $('#date2').datepicker({dateFormat: "dd/mm/yy"});
        $('#date3').datepicker({dateFormat: "dd/mm/yy"});
        $('#date4').datepicker({dateFormat: "dd/mm/yy"});

        HoldOn.close();
      } else {
        customHolder("info", "Tu búsqueda no devolvió resultados.");
      }
    }).fail(function (xhr, status, error) {
      HoldOn.close();
      customHolder("error", xhr.responseJSON.message)
    });
  });


  $("#btn-clear").click(function () {
    
    $("#slct_subidreccion").addClass("mdc-select--disabled");

    mdc_text_componentName.value = "";
    mdc_text_requirementName.value = "";
    mdc_text_componentVersion.value = "";
    mdc_select_direccion.value = "";
    mdc_select_subdireccion.value = "";
    mdc_select_empresa.value = "";
    mdc_select_tecnologia.value = "";
    mdc_select_nuevo_modificado.value = "";
    mdc_select_estado.value = "";
    mdc_text_componentDesignRealDeliverDate.value = "";
    mdc_text_componentPreviewDeliverDate.value = "";
    mdc_select_tipologia_inicial.value = "";
    mdc_text_componentPossibleDeliverDate.value = "";
    mdc_text_componentRealDeliverDate.value = "";
    mdc_select_tipologia_final.value = "";
    mdc_text_typologyStartSeverity.value = "";
    mdc_text_typologyStartSeverityHours.value = "";
    mdc_select_estado_tipificado.value = "";
    mdc_text_typologyFinalSeverity.value = "";
    mdc_text_typologyFinalSeverityHours.value = "";

    mdc_select_direccion.selectedIndex = -1;
    mdc_select_subdireccion.selectedIndex = -1;
    mdc_select_empresa.selectedIndex = -1;
    mdc_select_tecnologia.selectedIndex = -1;
    mdc_select_nuevo_modificado.selectedIndex = -1;
    mdc_select_estado.selectedIndex = -1;
    mdc_select_tipologia_inicial.selectedIndex = -1;
    mdc_select_tipologia_final.selectedIndex = -1;
    mdc_select_estado_tipificado.selectedIndex = -1;

    $("#mdc_text_componentName > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc_text_requirementName > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc_text_componentVersion > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc_text_componentDesignRealDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc_text_componentPreviewDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc_text_componentPossibleDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc_text_componentRealDeliverDate > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc_text_typologyStartSeverity > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc_text_typologyStartSeverityHours > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc_text_typologyFinalSeverity > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc_text_typologyFinalSeverityHours > label").removeClass("mdc-text-field__label--float-above");

    /** Results section */
    $("#tab-componentes > table > tbody").html("");
    $("#tab-fecha > table > tbody").html("");
    $("#tab-cierre > table > tbody").html("");
    $("#row-title-results").hide();
    $("#row-content-results").hide();
    $("#row-buttons-results").hide();

    /** MDC SELECT */
    $("#mdc_select_direccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#mdc_select_subdireccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#mdc_select_empresa > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#mdc_select_tecnologia > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#mdc_select_nuevo_modificado > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#mdc_select_estado > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#mdc_select_tipologia_inicial > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#mdc_select_tipologia_final > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#mdc_select_estado_tipificado > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");

    $("#mdc_select_direccion").removeClass("mdc-select--upgraded");
    $("#mdc_select_subdireccion").removeClass("mdc-select--upgraded");
    $("#mdc_select_empresa").removeClass("mdc-select--upgraded");
    $("#mdc_select_tecnologia").removeClass("mdc-select--upgraded");
    $("#mdc_select_nuevo_modificado").removeClass("mdc-select--upgraded");
    $("#mdc_select_estado").removeClass("mdc-select--upgraded");
    $("#mdc_select_tipologia_inicial").removeClass("mdc-select--upgraded");
    $("#mdc_select_tipologia_final").removeClass("mdc-select--upgraded");
    $("#mdc_select_estado_tipificado").removeClass("mdc-select--upgraded");

    $("#tabs").tabs("option", "active", 0);
    $("#update-all-dates").attr("disabled", "disabled");
    
  });

  $("#update-all-dates").click(function(){
    var updateDate1 = $("#date1").val();
    var updateDate2 = $("#date2").val();
    var updateDate3 = $("#date3").val();
    var updateDate4 = $("#date4").val();

    data = [{
      'componentDesignRealDeliverDate': changeFormatDate(updateDate1),
      'componentPossibleDeliverDate': changeFormatDate(updateDate2),
      'componentPreviewDeliverDate': changeFormatDate(updateDate3),
      'componentRealDeliverDate': changeFormatDate(updateDate4),
      'componentIds': idsSearch,
    }];

    $.ajax({
      url: "/components/update-dates",
      method: "PUT",
      data: JSON.stringify(data),
      dataType: "json",
      contentType: 'application/json',
      beforeSend: function () {
        HoldOn.open({
          theme: "sk-cube",
          content: '',
          message: 'Actualizando Información.',
          backgroundColor: "#0c71ca",
          textColor: "white",
        });
      }
    }).done(function (data ) {
      var date1 = $(".date1Text");

      $.each(date1, function (index, value) {
        var id = value.id.substring(6, value.id.length);
        $("#date1-" + id).val(updateDate1);
        $("#date2-" + id).val(updateDate2);
        $("#date3-" + id).val(updateDate3);
        $("#date4-" + id).val(updateDate4);
      });

      HoldOn.close();
      customHolder("info", "Información actualizada exitosamente.");
    }).fail(function (xhr, status, error) {
      HoldOn.close();
      customHolder("error", xhr.responseJSON.message)
    });
  });
  
  $("#update-dates").click(function(){
    data = [];

    var date1 = $(".date1Text");
    var date2 = $(".date2Text");
    var date3 = $(".date3Text");
    var date4 = $(".date4Text");

    $.each(date1, function(index, value){
      var id = value.id.substring(6, value.id.length);
      data.push({
        'componentId': parseInt(id),
        'componentDesignRealDeliverDate': changeFormatDate(value.value),
        'componentPossibleDeliverDate': changeFormatDate(date2[index].value),
        'componentPreviewDeliverDate': changeFormatDate(date3[index].value),
        'componentRealDeliverDate': changeFormatDate(date4[index].value),
      });
    });

    $.ajax({
      url: "/components/update-dates",
      method: "PUT",
      data: JSON.stringify(data),
      dataType: "json",
      contentType: 'application/json',
      beforeSend: function () {
        HoldOn.open({
          theme: "sk-cube",
          content: '',
          message: 'Actualizando Información',
          backgroundColor: "#0c71ca",
          textColor: "white",
        });
      }
    }).done(function (data) {
      HoldOn.close();
      customHolder("info", "Información actualizada exitosamente.");
    }).fail(function (xhr, status, error) {
      HoldOn.close();
      customHolder("error", xhr.responseJSON.message);
    });
  });
  
  $("#update-closure").click(function(){
    data = [];

    var tr = $("#tab-cierre > table > tbody").children();
    $.each(tr, function(index, value){
      tds = $(value).children();
      id = $(tds[2]).children().attr("id").substring(7, $(tds[2]).children().attr("id").length);

      if ($(tds[8]).children().val() == "1" ) {
        bill = true;
      } else {
        bill = false;
      }

      data.push({
        'finalTypologyId': $(tds[2]).children().val(),
        'componentTypoComment': $(tds[6]).children().val(),
        'statusTypologyId': $(tds[7]).children().val(),
        'componentForBill': bill,
        'componentId': parseInt(id),
      });

    });

    $.ajax({
      url: "/components/closure",
      method: "PUT",
      data: JSON.stringify(data),
      dataType: "json",
      contentType: 'application/json',
      beforeSend: function () {
        HoldOn.open({
          theme: "sk-cube",
          content: '',
          message: 'Actualizando Información',
          backgroundColor: "#0c71ca",
          textColor: "white",
        });
      }
    }).done(function (data) {
      HoldOn.close();
      customHolder("info", "Información actualizada exitosamente.");
    }).fail(function (xhr, status, error) {
      HoldOn.close();
      customHolder("error", xhr.responseJSON.message);
    });
  });

});

function changeFormatDate(date) {
  if ('undefined' !== typeof date && 0 < date.length) {
    split = date.split("/");
    return split[2] + "-" + split[1] + "-" + split[0];
  } else {
    return "";
  }
}

mdc.autoInit();
