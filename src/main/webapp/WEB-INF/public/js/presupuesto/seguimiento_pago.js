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


  mdc_solicitud = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_solicitud'));
  mdc_aceptacion = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_aceptacion'));
  mdc_fecha_envio = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_fecha_envio'));
  mdc_hoja_entrada = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_hoja_entrada'));
  mdc_estado = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_estado'));
  mdc_fecha_desde = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_fecha_desde'));
  mdc_fecha_hasta = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_fecha_hasta'));
  mdc_empresa = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_empresa'));
  mdc_tecnologia = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_tecnologia'));
  mdc_area_atencion = new mdc.textField.MDCTextField(document.querySelector('#mdc_group_area_atencion'));
  mdc_orden_compra = new mdc.select.MDCSelect(document.querySelector('#mdc_group_orden_compra'));
  

  $("#fecha_envio").change(function(){
    if ( "" != mdc_fecha_envio ) {
      $("#mdc_group_fecha_envio > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_group_fecha_envio > label").removeClass("mdc-text-field__label--float-above");
    }
  });


  $("#fecha_desde").change(function () {
    if ( "" != mdc_fecha_desde ) {
      $("#mdc_group_fecha_desde > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_group_fecha_desde > label").removeClass("mdc-text-field__label--float-above");
    }
  });


  $("#fecha_hasta").change(function () {
    if ( "" != mdc_fecha_hasta ) {
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
    mdc_empresa.value = "";
    mdc_tecnologia.value = "";
    mdc_area_atencion.value = "";

    mdc_orden_compra.selectedIndex = -1;
    mdc_orden_compra.value = "";
    $("#mdc_group_orden_compra > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");

    $("#fecha_hasta").datepicker("option", "minDate", null);
    $("#fecha_desde").datepicker("option", "maxDate", null);
  });


  $("#btn_submit").click(function(){});
  $("#delete_request").click(function(){});
  $("#btn_excel").click(function(){});
});