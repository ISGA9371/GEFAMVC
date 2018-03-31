$(function () {
  
  $('#datetimepicker4').datetimepicker({
    format: 'DD/MM/YYYY'
  });
  
  $('#datetimepicker5').datetimepicker({
    format: 'DD/MM/YYYY'
  });

});

demoReady(function () {
  mdc.select.MDCSelect.attachTo(document.getElementById('direccion-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('Subdirección-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('Area-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('Gestor-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('Tecnología-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('Aplicación-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('Canal-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('Empresa-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('Tipodeservicio-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('PI-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('Nombredelproyecto-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('Estadodelproyecto-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('Facturado-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('Estatus Tipif.-js-select'));
});