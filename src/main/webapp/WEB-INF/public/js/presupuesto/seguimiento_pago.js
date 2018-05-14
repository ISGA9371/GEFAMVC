var mdc_text_solicitud = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_solicitud'));
var mdc_text_aceptacion = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_aceptacion'));
var mdc_text_orden_compra = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_orden_compra'));
var mdc_text_fecha_envio = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_fecha_envio'));
var mdc_text_hoja_entrada = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_hoja_entrada'));
var mdc_select_estado_pago = new mdc.select.MDCSelect(document.querySelector('#mdc_select_estado_pago'));
var mdc_text_fecha_desde = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_fecha_desde'));
var mdc_text_fecha_hasta = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_fecha_hasta'));
var mdc_select_empresa = new mdc.select.MDCSelect(document.querySelector('#mdc_select_empresa'));
var mdc_select_tecnologia = new mdc.select.MDCSelect(document.querySelector('#mdc_select_tecnologia'));
var mdc_select_area_atencion = new mdc.select.MDCSelect(document.querySelector('#mdc_select_area_atencion'));

$(document).ready(function(){

  $("#fecha_envio").datepicker({
     dateFormat: "dd/mm/yy"
  });
  

  function getDate(element) {
    var date;
    try {
      date = $.datepicker.parseDate("dd/mm/yy", element.value);
    } catch (error) {
      date = null;
    }
    return date;
  }

  /** 
   * Technologies ajax call
   */
  $.ajax({
    url: "/api/technologies",
    method: "GET",
    dataType: "json",
    beforeSend: function () {
      $("#mdc_select_tecnologia").addClass("mdc-select--disabled");
      $("#mdc_select_tecnologia > .mdc-select__surface > .mdc-select__selected-text").html("");
      $("#mdc_select_tecnologia > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    }
  }).done(function (data) {
    lis = "";
    if ('undefined' !== typeof data.data && 0 < data.data.length && null !== data.data) {
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
  /************************ */


  /** 
   * Companies ajax call
   */
  $.ajax({
    url: "/api/companies",
    method: "GET",
    dataType: "json",
    beforeSend: function () {
      $("#mdc_select_empresa").addClass("mdc-select--disabled");
      $("#mdc_select_empresa > .mdc-select__surface > .mdc-select__selected-text").html("");
      $("#mdc_select_empresa > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    }
  }).done(function (data) {
    lis = "";
    if ('undefined' !== typeof data.data && 0 < data.data.length && null !== data.data) {
      $.each(data.data, function (index, value) {
        lis += "<li class='mdc-list-item' role='option' tabindex='0' id='" + value.companyId + "'>" + value.companyName + "</li>";
      });

      $("#mdc_select_empresa > .mdc-menu > ul").append(lis);
      $("#mdc_select_empresa").removeClass("mdc-select--disabled");
    } else {
      lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
      $("#mdc_select_empresa > .mdc-menu > ul").append(lis);
      $("#mdc_select_empresa").addClass("mdc-select--disabled");
    }
  }).fail(function () {
    lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
    $("#mdc_select_empresa > .mdc-menu > ul").append(lis);
    $("#mdc_select_empresa").addClass("mdc-select--disabled");
  });
  /************************ */


  /** 
   * Area Attention ajax call
   */
  $.ajax({
    url: "/api/areas",
    method: "GET",
    dataType: "json",
    beforeSend: function () {
      $("#mdc_select_area_atencion").addClass("mdc-select--disabled");
      $("#mdc_select_area_atencion > .mdc-select__surface > .mdc-select__selected-text").html("");
      $("#mdc_select_area_atencion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    }
  }).done(function (data) {
    lis = "";
    if ('undefined' !== typeof data.data && 0 < data.data.length && null !== data.data) {
      $.each(data.data, function (index, value) {
        lis += "<li class='mdc-list-item' role='option' tabindex='0' id='" + value.areaId + "'>" + value.areaName + "</li>";
      });

      $("#mdc_select_area_atencion > .mdc-menu > ul").append(lis);
      $("#mdc_select_area_atencion").removeClass("mdc-select--disabled");
    } else {
      lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
      $("#mdc_select_area_atencion > .mdc-menu > ul").append(lis);
      $("#mdc_select_area_atencion").addClass("mdc-select--disabled");
    }
  }).fail(function () {
    lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
    $("#mdc_select_area_atencion > .mdc-menu > ul").append(lis);
    $("#mdc_select_area_atencion").addClass("mdc-select--disabled");
  });
  /************************ */


  /** 
   * Payment Status ajax call ( id = 18, EDO_PAGO ) 
   */
  $.ajax({
    url: "/api/status-types/18/status",
    method: "GET",
    dataType: "json",
    beforeSend: function () {
      $("#mdc_select_estado_pago").addClass("mdc-select--disabled");
      $("#mdc_select_estado_pago > .mdc-select__surface > .mdc-select__selected-text").html("");
      $("#mdc_select_estado_pago > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    }
  }).done(function (data) {
    lis = "";
    if ('undefined' !== typeof data.data && 0 < data.data.length && null !== data.data ) {
      $.each(data.data, function (index, value) {
        lis += "<li class='mdc-list-item' role='option' tabindex='0' id='" + value.statusId + "'>" + value.statusName + "</li>";
      });

      $("#mdc_select_estado_pago > .mdc-menu > ul").append(lis);
      $("#mdc_select_estado_pago").removeClass("mdc-select--disabled");
    } else {
      lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
      $("#mdc_select_estado_pago > .mdc-menu > ul").append(lis);
      $("#mdc_select_estado_pago").addClass("mdc-select--disabled");
    }
  }).fail(function () {
    lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
    $("#mdc_select_estado_pago > .mdc-menu > ul").append(lis);
    $("#mdc_select_estado_pago").addClass("mdc-select--disabled");
  });
  /************************ */



  $("#fecha_envio").change(function(){
    if ( "" != mdc_text_fecha_envio.value ) {
      $("#mdc_text_fecha_envio > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_text_fecha_envio > label").removeClass("mdc-text-field__label--float-above");
    }
  });


  $("#fecha_desde").datepicker({
    dateFormat: "dd/mm/yy"
  }).on("change", function () {
    $("#fecha_hasta").datepicker("option", "minDate", getDate(this));

    if ("" != mdc_text_fecha_desde.value) {
      $("#mdc_text_fecha_desde > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_text_fecha_desde > label").removeClass("mdc-text-field__label--float-above");
    }
  });


  $("#fecha_hasta").datepicker({
    dateFormat: "dd/mm/yy"
  }).on("change", function () {
    $("#fecha_desde").datepicker("option", "maxDate", getDate(this));

    if ("" != mdc_text_fecha_hasta.value) {
      $("#mdc_text_fecha_hasta > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_text_fecha_hasta > label").removeClass("mdc-text-field__label--float-above");
    }
  });


  $("#btn_clear").click(function(){
    mdc_text_solicitud.value = "";
    mdc_text_aceptacion.value = "";
    mdc_text_orden_compra.value = "";
    mdc_text_fecha_envio.value = "";
    mdc_text_hoja_entrada.value = "";
    mdc_select_estado_pago.value = "";
    mdc_text_fecha_desde.value = "";
    mdc_text_fecha_hasta.value = "";
    mdc_select_empresa.value = "";
    mdc_select_tecnologia.value = "";
    mdc_select_area_atencion.value = "";

    mdc_select_estado_pago.selectedIndex = -1;
    mdc_select_empresa.selectedIndex = -1;
    mdc_select_tecnologia.selectedIndex = -1;
    mdc_select_area_atencion.selectedIndex = -1;

    $("#mdc_select_estado_pago > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above"); 
    $("#mdc_select_empresa > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above"); 
    $("#mdc_select_tecnologia > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above"); 
    $("#mdc_select_area_atencion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above"); 

    $("#fecha_hasta").datepicker("option", "minDate", null);
    $("#fecha_desde").datepicker("option", "maxDate", null);
  });


  $("#btn_submit").click(function(){

    var params = {
      paymentId: mdc_text_solicitud.value,
      paymentReception: mdc_text_aceptacion.value,
      paymentOrder: mdc_text_orden_compra.value,
      modificationSendDate: changeFormatDate(mdc_text_fecha_envio.value),
      paymentInPaper: mdc_text_hoja_entrada.value,
      statusId: mdc_select_estado_pago.value,
      invoiceCutDateFrom: changeFormatDate(mdc_text_fecha_desde.value),
      invoiceCutDateTo: changeFormatDate(mdc_text_fecha_hasta.value),
      companyId: mdc_select_empresa.value,
      technologyId: mdc_select_tecnologia.value,
      areaId: mdc_select_area_atencion.value,
    };

    console.log( params );

    $.ajax({
      url: "/budgets/payments/search",
      method: "GET",
      data: $.param(params),
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
    }).done(function ( data ) {
      if (1 <= data.length) {
        HoldOn.close();  
      } else {
        customHolder("info", "Tu búsqueda no devolvió resultados.");
      }
    }).fail(function (xhr, status, error) {
      HoldOn.close();
      customHolder("error", xhr.responseJSON.message)
    });
  });


  $("#delete_request").click(function(){});


  $("#btn_excel").click(function(){});


  function changeFormatDate(date) {
    if ('undefined' !== typeof date && 0 < date.length) {
      split = date.split("/");
      return split[2] + "-" + split[1] + "-" + split[0];
    } else {
      return "";
    }
  }

});
