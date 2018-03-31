$(function () {
  demoReady(function () {
    mdc.select.MDCSelect.attachTo(document.getElementById('Dirección-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('Subdirección-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('Empresa-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('Estado-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('Prioridad-js-select'));
  });
  
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
