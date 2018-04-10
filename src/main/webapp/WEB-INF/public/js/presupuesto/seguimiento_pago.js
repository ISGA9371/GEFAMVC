$(document).ready(function(){

  $("#fecha_envio").datepicker({});
  $("#fecha_desde").datepicker({});
  $("#fecha_hasta").datepicker({});

  $("#fecha_envio").change(function(){
    if ( $("#fecha_envio").val() !== "" ) {
      $("#mdc_group_fecha_envio > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_group_fecha_envio > label").removeClass("mdc-text-field__label--float-above");
    }
  });

  $("#fecha_desde").change(function () {
    if ($("#fecha_desde").val() !== "") {
      $("#mdc_group_fecha_desde > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_group_fecha_hasta > label").removeClass("mdc-text-field__label--float-above");
    }
  });

  $("#fecha_hasta").change(function () {
    if ($("#fecha_hasta").val() !== "") {
      $("#mdc_group_fecha_desde > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_group_fecha_hasta > label").removeClass("mdc-text-field__label--float-above");
    }
  });

  $("#btn_submit").click(function(){});
  $("#btn_clear").click(function(){});
  $("#delete_request").click(function(){});
  $("#btn_excel").click(function(){});
});