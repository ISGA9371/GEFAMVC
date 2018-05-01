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


  $.ajax({
    url: "/api/companies",
    method: "GET",
    beforeSend: function () {
      $("#mdc_select_empresa").addClass("mdc-select--disabled");
      $("#mdc_select_empresa > .mdc-select__surface > .mdc-select__selected-text").html("");
      $("#mdc_select_empresa > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    }
  }).done(function (data) {
    lis = "";
    if ('undefined' !== typeof data.data && 0 < data.data.length) {
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


  mdc_text_solicitud = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_solicitud'));
  mdc_text_aceptacion = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_aceptacion'));
  mdc_text_orden_compra = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_orden_compra'));
  mdc_text_fecha_envio = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_fecha_envio'));
  mdc_text_hoja_entrada = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_hoja_entrada'));
  mdc_select_estado = new mdc.select.MDCSelect(document.querySelector('#mdc_select_estado'));
  mdc_text_fecha_desde = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_fecha_desde'));
  mdc_text_fecha_hasta = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_fecha_hasta'));
  mdc_select_empresa = new mdc.select.MDCSelect(document.querySelector('#mdc_select_empresa'));
  mdc_select_tecnologia = new mdc.select.MDCSelect(document.querySelector('#mdc_select_tecnologia'));
  mdc_text_area_atencion = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_area_atencion'));



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
    mdc_select_estado.value = "";
    mdc_text_fecha_desde.value = "";
    mdc_text_fecha_hasta.value = "";
    mdc_select_empresa.value = "";
    mdc_select_tecnologia.value = "";
    mdc_text_area_atencion.value = "";

    mdc_select_estado.selectedIndex = -1;
    mdc_select_empresa.selectedIndex = -1;
    mdc_select_tecnologia.selectedIndex = -1;

    $("#mdc_select_estado > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above"); 
    $("#mdc_select_empresa > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above"); 
    $("#mdc_select_tecnologia > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above"); 

    $("#fecha_hasta").datepicker("option", "minDate", null);
    $("#fecha_desde").datepicker("option", "maxDate", null);
  });


  $("#btn_submit").click(function(){

    var params = {
      solicitud: mdc_text_solicitud.value,
      aceptacion: mdc_text_aceptacion.value,
      orden_compra: mdc_text_orden_compra.value,
      fecha_envio: mdc_text_fecha_envio.value,
      hoja_entrada: mdc_text_hoja_entrada.value,
      estado: mdc_select_estado.value,
      fecha_desde: mdc_text_fecha_desde.value,
      fecha_hasta: mdc_text_fecha_hasta.value,
      empresa: mdc_select_empresa.value,
      tecnologia: mdc_select_tecnologia.value,
      area_atencion: mdc_text_area_atencion.value,
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

});