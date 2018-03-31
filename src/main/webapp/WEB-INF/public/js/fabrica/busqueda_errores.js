$(function () {

  $('#datetimepicker4').datetimepicker({
    format: 'DD/MM/YYYY'
  });
  
  $('#datetimepicker5').datetimepicker({
    format: 'DD/MM/YYYY'
  });
  
  $('#datetimepicker6').datetimepicker({
    format: 'DD/MM/YYYY'
  });
  
  $('#datetimepicker7').datetimepicker({
    format: 'DD/MM/YYYY'
  });

});



demoReady(function () {
  mdc.select.MDCSelect.attachTo(document.getElementById('direccion-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('subdireccion-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('empresa-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('estado-js-select'));
});