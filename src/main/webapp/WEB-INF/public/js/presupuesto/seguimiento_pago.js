$(document).ready(function(){

  $("#fecha_envio").datepicker({
     dateFormat: "dd-mm-yy",
  });
  
  $("#fecha_desde").datepicker({
     dateFormat: "dd-mm-yy",
  }).on("change", function () {
    $("#fecha_hasta").datepicker("option", "minDate", getDate(this));
  });

  $("#fecha_hasta").datepicker({
     dateFormat: "dd-mm-yy",
  }).on("change", function () {
    $("#fecha_desde").datepicker("option", "maxDate", getDate(this));
  });

  function getDate(element) {
    var date;
    try {
      date = $.datepicker.parseDate("dd-mm-yy", element.value);
    } catch (error) {
      date = null;
    }
    return date;
  }

  $.ajax({
    url: "/technologies",
    method: "GET",
    beforeSend: function () {
      $("#mdc_group_tecnologia").addClass("mdc-select--disabled");
      $("#mdc_group_tecnologia > .mdc-select__surface > .mdc-select__selected-text").html("");
      $("#mdc_group_tecnologia > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    }
  }).done(function (data) {
    lis = "";
    if ('undefined' !== typeof data.data && 0 < data.data.length) {
      $.each(data.data, function (index, value) {
        lis += "<li class='mdc-list-item' role='option' tabindex='0' id='" + value.technologyId + "'>" + value.technologyName + "</li>";
      });

      $("#mdc_group_tecnologia > .mdc-menu > ul").append(lis);
      $("#mdc_group_tecnologia").removeClass("mdc-select--disabled");
    } else {
      lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
      $("#mdc_group_tecnologia > .mdc-menu > ul").append(lis);
      $("#mdc_group_tecnologia").addClass("mdc-select--disabled");
    }
  }).fail(function () {
    lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
    $("#mdc_group_tecnologia > .mdc-menu > ul").append(lis);
    $("#mdc_group_tecnologia").addClass("mdc-select--disabled");
  });


  $.ajax({
    url: "/companies",
    method: "GET",
    beforeSend: function () {
      $("#mdc_group_empresa").addClass("mdc-select--disabled");
      $("#mdc_group_empresa > .mdc-select__surface > .mdc-select__selected-text").html("");
      $("#mdc_group_empresa > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    }
  }).done(function (data) {
    lis = "";
    if ('undefined' !== typeof data.data && 0 < data.data.length) {
      $.each(data.data, function (index, value) {
        lis += "<li class='mdc-list-item' role='option' tabindex='0' id='" + value.companyId + "'>" + value.companyName + "</li>";
      });

      $("#mdc_group_empresa > .mdc-menu > ul").append(lis);
      $("#mdc_group_empresa").removeClass("mdc-select--disabled");
    } else {
      lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
      $("#mdc_group_empresa > .mdc-menu > ul").append(lis);
      $("#mdc_group_empresa").addClass("mdc-select--disabled");
    }
  }).fail(function () {
    lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
    $("#mdc_group_empresa > .mdc-menu > ul").append(lis);
    $("#mdc_group_empresa").addClass("mdc-select--disabled");
  });


  mdc_solicitud = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_solicitud'));
  mdc_aceptacion = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_aceptacion'));
  mdc_fecha_envio = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_fecha_envio'));
  mdc_hoja_entrada = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_hoja_entrada'));
  mdc_estado = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_estado'));
  mdc_fecha_desde = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_fecha_desde'));
  mdc_fecha_hasta = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_fecha_hasta'));
  mdc_empresa = new mdc.select.MDCSelect(document.querySelector('#mdc_group_empresa'));
  mdc_tecnologia = new mdc.select.MDCSelect(document.querySelector('#mdc_group_tecnologia'));
  mdc_area_atencion = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_area_atencion'));
  mdc_orden_compra = new mdc.select.MDCSelect(document.querySelector('#mdc_group_orden_compra'));
  

  $("#fecha_envio").change(function(){
    if ( "" != mdc_fecha_envio.value ) {
      $("#mdc_group_fecha_envio > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_group_fecha_envio > label").removeClass("mdc-text-field__label--float-above");
    }
  });


  $("#fecha_desde").change(function () {
    if ( "" != mdc_fecha_desde.value ) {
      $("#mdc_group_fecha_desde > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_group_fecha_desde > label").removeClass("mdc-text-field__label--float-above");
    }
  });


  $("#fecha_hasta").change(function () {
    if ( "" != mdc_fecha_hasta.value ) {
      $("#mdc_group_fecha_hasta > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_group_fecha_hasta > label").removeClass("mdc-text-field__label--float-above");
    }
  });


  $("#btn_clear").click(function(){
    mdc_solicitud.value = "";
    mdc_aceptacion.value = "";
    mdc_fecha_envio.value = "";
    mdc_hoja_entrada.value = "";
    mdc_estado.value = "";
    mdc_fecha_desde.value = "";
    mdc_fecha_hasta.value = "";
    mdc_empresa.selectedIndex = -1;
    mdc_empresa.value = "";
    $("#mdc_group_empresa > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    mdc_tecnologia.selectedIndex = -1;
    mdc_tecnologia.value = "";
    $("#mdc_group_tecnologia > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    mdc_area_atencion.value = "";
    mdc_orden_compra.selectedIndex = -1;
    mdc_orden_compra.value = "";
    $("#mdc_group_orden_compra > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");

    $("#fecha_hasta").datepicker("option", "minDate", null);
    $("#fecha_desde").datepicker("option", "maxDate", null);
  });


  $("#btn_submit").click(function(){

    var params = {
      solicitud: mdc_solicitud.value,
      aceptacion: mdc_aceptacion.value,
      fecha_envio: mdc_fecha_envio.value,
      hoja_entrada: mdc_hoja_entrada.value,
      estado: mdc_estado.value,
      fecha_desde: mdc_fecha_desde.value,
      fecha_hasta: mdc_fecha_hasta.value,
      empresa: mdc_empresa.value,
      tecnologia: mdc_tecnologia.value,
      area_atencion: mdc_area_atencion.value,
      orden_compra: mdc_orden_compra.value,
    };

    console.log( $.param(params) );

    // $.ajax({
    //   url: "/components/search",
    //   method: "GET",
    //   data: $.param(params),
    //   dataType: "json",
    //   beforeSend: function (xhr) {
    //     HoldOn.open({
    //       theme: "sk-cube",
    //       content: '',
    //       message: 'Consultado Información',
    //       backgroundColor: "#0c71ca",
    //       textColor: "white",
    //     });
    //   }
    // }).done(function ( data ) {

    // }).fail(function( error ){

    // });
  });


  $("#delete_request").click(function(){});


  $("#btn_excel").click(function(){});

});