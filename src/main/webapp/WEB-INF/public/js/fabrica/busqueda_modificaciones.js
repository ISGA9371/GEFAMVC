$(function () {
  $('#datetimepicker4').datetimepicker({
    format: 'DD/MM/YYYY'
  });
});


demoReady(function () {
  mdc.select.MDCSelect.attachTo(document.getElementById('direccion-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('subdireccion-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('empresa-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('vuelo-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('estado-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('prioridad-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('mes-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('anio-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('estatus-js-select'));
});