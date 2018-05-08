mdc.autoInit()

$(function () {

  /** 
   * datepicker
   * dateFormat: "dd-mm-yy"
  */
  $('#componentCurrentDate').datepicker({
      dateFormat: "dd/mm/yy"
  });

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

    const areas = new mdc.select.MDCSelect(document.querySelector('#areas'));
    const tiposServ = new mdc.select.MDCSelect(document.querySelector('#tipos-serv'));

    if($("#areas li[aria-selected]").length > 0)
        $("#areas div.mdc-select__label").addClass("mdc-select__label--float-above");

    let index5 = parseInt("0");

    areas.listen('MDCSelect:change', () => {
        if (index5++ === 0) return; else index5 = 0;
    let id = areas.selectedOptions[0].value;
    //SET HIDDEN FIELD VALUE
    console.log("AREAID " +id);
    $("#areaId").val(id);

    /*$("#tipos-serv div.mdc-select__label").removeClass("mdc-select__label--float-above");
    if(id === 1){
        $("#service-type-select").html( $("#service-types-ul").html() );
        $("#tipos-serv").removeClass("mdc-select--disabled");
    }else {
        tiposServ.selectedIndex = -1;
        tiposServ.value = "";
        $("#tipos-serv").addClass("mdc-select--disabled");
        $("#service-type-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");
    }*/
    /*
    $.ajax({
        url: "/service-types/area/"+id
    }).done(function(data) {
        //let subdirs = JSON.parse(data);
        let services = data;
        console.log(services.length);
        $("#service-type-sel-text").html("");
        tiposServ.selectedIndex = -1;
        tiposServ.value = "";

        if (typeof services !== 'undefined' && services.length > 0) {
            $("#service-type-select").html("");
            $.each(services, function( index, value ) {
                console.log( index + ": " + value.serviceTypeName );
                $("#service-type-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "value='"+value.serviceTypeId+"'>"+value.serviceTypeName+"</li>");

            });
        }else $("#service-type-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");

    });
    */
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

    const tiposProy = new mdc.select.MDCSelect(document.querySelector('#tipos-proy'));
    if($("#tipos-proy li[aria-selected]").length > 0)
        $("#tipos-proy div.mdc-select__label").addClass("mdc-select__label--float-above");
    let index6 = parseInt("0");
    tiposProy.listen('MDCSelect:change', () => {
        if (index6++ === 0) return; else index6 = 0;
          let id = tiposProy.selectedOptions[0].value;
          //SET HIDDEN FIELD VALUE
          console.log("PROYECTTYPEID " +id);
          $("#methodologyId").val(id);
    });

  $("#tabs").tabs();

  const tipo = new mdc.select.MDCSelect(document.querySelector('#slct_tipo'));
  const direccion = new mdc.select.MDCSelect(document.querySelector('#slct_direccion'));
  const area = new mdc.select.MDCSelect(document.querySelector('#slct_area'));
  const subidreccion = new mdc.select.MDCSelect(document.querySelector('#slct_subidreccion'));
  const empresa = new mdc.select.MDCSelect(document.querySelector('#slct_empresa'));
  const tecnologia = new mdc.select.MDCSelect(document.querySelector('#slct_tecnologia'));
  const nuevo_modificado = new mdc.select.MDCSelect(document.querySelector('#slct_nuevo_modificado'));
  const estado = new mdc.select.MDCSelect(document.querySelector('#slct_estado'));
  const tipologia_inicial = new mdc.select.MDCSelect(document.querySelector('#slct_tipologia_inicial'));
  const tipologia_final = new mdc.select.MDCSelect(document.querySelector('#slct_tipologia_final'));
  const estado_tipificado = new mdc.select.MDCSelect(document.querySelector('#slct_estado_tipificado'));

  componentCurrentDate = new mdc.textField.MDCTextField(document.querySelector('#mdc-group-componentCurrentDate'));
  componentDesignRealDeliverDate = new mdc.textField.MDCTextField(document.querySelector('#mdc-group-componentCurrentDate'));
  componentPreviewDeliverDate = new mdc.textField.MDCTextField(document.querySelector('#mdc-group-componentPreviewDeliverDate'));
  componentPossibleDeliverDate = new mdc.textField.MDCTextField(document.querySelector('#mdc-group-componentPossibleDeliverDate'));
  componentRealDeliverDate = new mdc.textField.MDCTextField(document.querySelector('#mdc-group-componentRealDeliverDate'));

    $("#componentCurrentDate").change(function () {
        if ("" != componentCurrentDate.value) {
            $("#mdc-group-componentCurrentDate > label").addClass("mdc-text-field__label--float-above");
        } else {
            $("#mdc-group-componentCurrentDate > label").removeClass("mdc-text-field__label--float-above");
        }
    });

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

    /** Results section */
    $("#tab-componentes > table > tbody").html("");
    $("#tab-fecha > table > tbody").html("");
    $("#tab-cierre > table > tbody").html("");
    $("#row-title-results").hide();
    $("#row-content-results").hide();
    $("#row-buttons-results").hide();
    $("#tabs").tabs("option", "active", 0);

    $("#principalId").val(direccion.value);
    $("#subPrincipalId").val(subidreccion.value);
    $("#companyId").val(empresa.value);
    $("#technologyId").val(tecnologia.value);
    $("#typologyNewComponent").val(nuevo_modificado.value);
    $("#statusId").val(estado.value);
    $("#startProductId").val(tipologia_inicial.value);
    $("#finalProductId").val(tipologia_final.value);
    $("#statusTypologyId").val(estado_tipificado.value);

    if ($("#typologyNewComponent").val() == "1") {
      var newMod = true;
    } else if ($("#typologyNewComponent").val() == "0") {
      var newMod = false;
    } else {
      var newMod = "";
    }

    var params = {
      principalId: $("#principalId").val(),
      subPrincipalId: $("#subPrincipalId").val(),
      companyId: $("#companyId").val(),
      technologyId: $("#technologyId").val(),
      typologyNewComponent: newMod,
      statusId: $("#statusId").val(),
      startProductId: $("#startProductId").val(),
      finalProductId: $("#finalProductId").val(),
      statusTypologyId: $("#statusTypologyId").val(),
      componentName: $("#componentName").val(),
      requirementName: $("#requirementName").val(),
      componentVersion: $("#componentVersion").val(),
      componentCurrentDate: $("#componentCurrentDate").val(),
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
            "<td><a class='changeWindow' style='color:white;' href='/modifications/add?componentId=" + value.componentId +
              "'><img src='/img/edit_icon.png' style='width: 30px;'></a></td>" +
            "<td><a class='changeWindow' style='color:white;' href='/doubts/add?componentId=" + value.componentId +
              "'><img src='/img/question_icon.png' style='width: 30px;'></a></td>" +
            "<td><a class='changeWindow' style='color:white;' href='/issues/add?componentId=" + value.componentId +
              "'><img src='/img/cancel_icon.png' style='width: 30px;'></a></td>" +
            "<td><a class='btn btn-primary btn-xs changeWindow' style='color:white;' href='/components/" + value.componentId +
              "'><span class='glyphicons glyphicons-edit' aria-hidden='true'></span> Editar</a></td></tr>"
          );

          date1 = "";
          designRealDeliverDate = new Date(value.componentDesignRealDeliverDate);
          if ( parseInt(designRealDeliverDate.getDate()) < 10 ) { date1 += "0" + designRealDeliverDate.getDate(); }
          else { date1 += designRealDeliverDate.getDate(); }
          date1 += "/" + numberMonths[designRealDeliverDate.getMonth()] + "/" + designRealDeliverDate.getFullYear();

          date2 = "";
          possibleDeliverDate = new Date(value.componentPossibleDeliverDate);
          if ( parseInt(possibleDeliverDate.getDate()) < 10 ) { date2 += "0" + possibleDeliverDate.getDate(); }
          else { date2 += possibleDeliverDate.getDate(); }
          date2 += "/" + numberMonths[possibleDeliverDate.getMonth()] + "/" + possibleDeliverDate.getFullYear();

          date3 = "";
          previewDeliverDate = new Date(value.componentPreviewDeliverDate);
          if ( parseInt(previewDeliverDate.getDate()) < 10 ) { date3 += "0" + previewDeliverDate.getDate(); }
          else { date3 += previewDeliverDate.getDate(); }
          date3 += "/" + numberMonths[previewDeliverDate.getMonth()] + "/" + previewDeliverDate.getFullYear();

          date4 = "";
          realDeliverDate = new Date(value.componentRealDeliverDate);
          if ( parseInt(realDeliverDate.getDate()) < 10 ) { date4 += "0" + realDeliverDate.getDate(); }
          else { date4 += realDeliverDate.getDate(); }
          date4 += "/" + numberMonths[realDeliverDate.getMonth()] + "/" + realDeliverDate.getFullYear();


          $("#tab-fecha > table > tbody").append(
            "<tr><td>" + value.componentName + "</td>" +
            "<td>" + value.requirement.requirementName + "</td>" +
            "<td><input type='text' id='date1-" + value.componentId + "' value='" + date1 +"' class='form-control date1Text'></td>" +
            "<td><input type='text' id='date2-" + value.componentId + "' value='" + date2 + "' class='form-control date2Text'></td>" +
            "<td><input type='text' id='date3-" + value.componentId + "' value='" + date3 + "' class='form-control date3Text'></td>" +
            "<td><input type='text' id='date4-" + value.componentId + "' value='" + date4 + "' class='form-control date4Text'></td>" +
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
          "<td><input type='text' id='date1' value='' class='form-control'></td>" +
          "<td><input type='text' id='date2' value='' class='form-control'></td>" +
          "<td><input type='text' id='date3' value='' class='form-control'></td>" +
          "<td><input type='text' id='date4' value='' class='form-control'></td>" +
          "<td></td></tr>"
        );

        $('#date1').datepicker({dateFormat: "dd/mm/yy"});
        $('#date2').datepicker({dateFormat: "dd/mm/yy"});
        $('#date3').datepicker({dateFormat: "dd/mm/yy"});
        $('#date4').datepicker({dateFormat: "dd/mm/yy"});
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

    direccion.value = "";
    subidreccion.value = "";
    empresa.value = "";
    tecnologia.value = "";
    nuevo_modificado.value = "";
    estado.value = "";
    tipologia_inicial.value = "";
    tipologia_final.value = "";
    estado_tipificado.value = "";
    componentDesignRealDeliverDate.value = "";
    componentPreviewDeliverDate.value = "";
    componentPossibleDeliverDate.value = "";
    componentRealDeliverDate.value = "";

    direccion.selectedIndex = -1;
    subidreccion.selectedIndex = -1;
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

    $("#mdc-group-projectName > label").removeClass("mdc-text-field__label--float-above");
    $("#mdc-group-componentCurrentDate > label").removeClass("mdc-text-field__label--float-above");
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
    $("#slct_tipo > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_direccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_area > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_subidreccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_empresa > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_tecnologia > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_nuevo_modificado > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_estado > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_tipologia_inicial > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_tipologia_final > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#slct_estado_tipificado > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");


    $("#slct_area > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_empresa > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_tecnologia > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_nuevo_modificado > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_estado > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_tipologia_inicial > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_tipologia_final > .mdc-select__surface > .mdc-select__selected-text").html("");
    $("#slct_estado_tipificado > .mdc-select__surface > .mdc-select__selected-text").html("");

    $("#slct_tipo").removeClass("mdc-select--upgraded");
    $("#slct_direccion").removeClass("mdc-select--upgraded");
    $("#slct_area").removeClass("mdc-select--upgraded");
    $("#slct_subidreccion").removeClass("mdc-select--upgraded");
    $("#slct_empresa").removeClass("mdc-select--upgraded");
    $("#slct_tecnologia").removeClass("mdc-select--upgraded");
    $("#slct_nuevo_modificado").removeClass("mdc-select--upgraded");
    $("#slct_estado").removeClass("mdc-select--upgraded");
    $("#slct_tipologia_inicial").removeClass("mdc-select--upgraded");
    $("#slct_tipologia_final").removeClass("mdc-select--upgraded");
    $("#slct_estado_tipificado").removeClass("mdc-select--upgraded");

    $("#tabs").tabs("option", "active", 0);

  });

  $("#update-all-dates").click(function(){
    var updateDate1 = $("#date1").val();
    var updateDate2 = $("#date2").val();
    var updateDate3 = $("#date3").val();
    var updateDate4 = $("#date4").val();

    data = [{
      'componentDesignRealDeliverDate': updateDate1,
      'componentPossibleDeliverDate': updateDate2,
      'componentPreviewDeliverDate': updateDate3,
      'componentRealDeliverDate': updateDate4,
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
          message: 'Actualizando Información',
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
      new jBox('Notice', {
        content: 'Información actualizada exitosamente',
        animation: 'pulse',
        color: 'green'
      });
    }).fail(function ( error ) {
      HoldOn.close();
      new jBox('Notice', {
        content: 'Hubo un error al guardar, intenta de nuevo.',
        animation: 'pulse',
        color: 'red'
      });
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
        'componentDesignRealDeliverDate': value.value,
        'componentPossibleDeliverDate': date2[index].value,
        'componentPreviewDeliverDate': date3[index].value,
        'componentRealDeliverDate': date4[index].value,
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
      new jBox('Notice', {
        content: 'Información actualizada exitosamente',
        animation: 'pulse',
        color: 'green'
      });
    }).fail(function (error) {
      HoldOn.close();
      new jBox('Notice', {
        content: 'Hubo un error al guardar, intenta de nuevo.',
        animation: 'pulse',
        color: 'red'
      });
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
      new jBox('Notice', {
        content: 'Información actualizada exitosamente',
        animation: 'pulse',
        color: 'green'
      });
    }).fail(function (error) {
      HoldOn.close();
      new jBox('Notice', {
        content: 'Hubo un error al guardar, intenta de nuevo.',
        animation: 'pulse',
        color: 'red'
      });
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

setTimeout(function searchComponent() {
    selecMdc = new mdc.select.MDCSelect($("#slct_componente")[0]);
    var endPoint = "";
  //var selecMdc = document.getElementById("slct_componente");
  //var valueSelectCombo = componenteCombo.options[componenteCombo.selectedIndex].text;
  if((selecMdc.value) ==" Modificado ") {
      endPoint = '/modifications/search';
  }else if((selecMdc.value) ==" Dudas ") {
      endPoint = '/doubts/search';
  }else if((selecMdc.value) ==" Incidencia ") {
      endPoint = '/issues/search';
  }

    $.ajax({
        async: false,
        url: endPoint
    }).done(function (json) {
        $.each(json.data, function(i, data){
            $("#results-table").find("tbody").append(
                //"<th:block th:each='requirement, stat : ${requirements}'>"
                "<tr th:href='${'#row-detail-wrapper-' + stat.count}' data-tggle='collapse' class='clickable' th:aria-controls='${'row-detail-wrapper-' + stat.count}'>"
                  +"<td>"
                  //+//"<input type='radio' name='requirements' th:id='${requirement.requirementId}' th:value='${requirement.requirementId}'>"
                  +"</td>"
                  +"<td>"+data.component.requirement.project.methodology.methodologyName
                  +"</td>"
                  +"<td>"+data.component.requirement.project.projectName
                  +"</td>"
                  +"<td>"+""
                  +"</td>"
                  +"<td>"+data.component.requirement.company.companyName
                  +"</td>"
                  +"<td>"+data.component.requirement.level.levelSuperior.levelName
                  +"</td>"
                  +"<td>"+data.component.requirement.area.areaName
                  +"</td>"
                +"</tr>"
                +"<tr>"
                  +"<td colspan='11' class='detail-td'>"
                    +"<div th:id='${'row-detail-wrapper-' + stat.count}' class='collapse'>"
                      +"<table style='width: 100%;'>"
                        +"<tr>"
                          +"<td class='detail-label'>Componente"
                          +"</td>"
                          +"<td>"
                          +"</td>"
                          +"<td class='detail-label'>Fecha"
                          +"</td>"
                          +"<td th:text='${#dates.format(requirement.requirementEndDate, 'dd/MM/yyyy')}'>"
                          +"</td>"
                        +"</tr>"
                      +"</table>"
                    +"</div>"
                  +"</td>"
                +"</tr>"
                //+"</th:block>"
            );
        });
    }).fail(function (xhr, status, error) {
        console.log('¡Error al consultar datos!');
    });
}, 100);

$("#btn-clear").click(function () {
    tipo.value = "";
    tipo.selectedIndex = -1;
    areas.value = "";
    areas.selectedIndex = -1;
    direccion.value = "";
    direccion.selectedIndex = -1;
    empresa.value = "";
    empresa.selectedIndex = -1;
    componentCurrentDate.value = "";
    componentCurrentDate.value.selectedIndex = -1;

    $(".mdc-text-field__input").removeClass("mdc-text-field__label--float-above");

    $("#results-table tbody").html("");
});

