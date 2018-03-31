demoReady(function () {
  mdc.select.MDCSelect.attachTo(document.getElementById('direccion-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('subdireccion-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('area-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('tecnologia-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('tipoProyecto-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('aplicacion-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('canal-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('empresa-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('servicio-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('pi-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('proy-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('estado-js-select'));
  mdc.select.MDCSelect.attachTo(document.getElementById('facturado-js-select'));
});

//Asignacion de combos a los hidden
demoReady(function () {
  var rootDir = document.getElementById('direccion-js-select');
  var hiddenDir = document.getElementById('hidden-direccion');
  var selectDir = new mdc.select.MDCSelect(rootDir);

  rootDir.addEventListener('MDCSelect:change', function () {
    hiddenDir.value = selectDir.value;
  });
});

demoReady(function () {
  var rootSD = document.getElementById('subdireccion-js-select');
  var hiddenSD = document.getElementById('hidden-subdireccion');
  var selectSD = new mdc.select.MDCSelect(rootSD);

  rootSD.addEventListener('MDCSelect:change', function () {
    hiddenSD.value = selectSD.value;
  });
});

demoReady(function () {
  var rootArea = document.getElementById('area-js-select');
  var hiddenArea = document.getElementById('hidden-area');
  var selectArea = new mdc.select.MDCSelect(rootArea);

  rootArea.addEventListener('MDCSelect:change', function () {
    hiddenArea.value = selectArea.value;
  });
});

demoReady(function () {
  var rootTecnologia = document.getElementById('tecnologia-js-select');
  var hiddenTecnologia = document.getElementById('hidden-tecnologia');
  var selectTecnologia = new mdc.select.MDCSelect(rootTecnologia);

  rootTecnologia.addEventListener('MDCSelect:change', function () {
    hiddenTecnologia.value = selectTecnologia.value;
  });
});

demoReady(function () {
  var rootAp = document.getElementById('aplicacion-js-select');
  var hiddenAp = document.getElementById('hidden-aplicacion');
  var selectAp = new mdc.select.MDCSelect(rootAp);

  rootAp.addEventListener('MDCSelect:change', function () {
    hiddenAp.value = selectAp.value;
  });
});

demoReady(function () {
  var rootCn = document.getElementById('canal-js-select');
  var hiddenCn = document.getElementById('hidden-canal');
  var selectCn = new mdc.select.MDCSelect(rootCn);

  rootCn.addEventListener('MDCSelect:change', function () {
    hiddenCn.value = selectCn.value;
  });
});

demoReady(function () {
  var rootEmp = document.getElementById('empresa-js-select');
  var hiddenEmp = document.getElementById('hidden-empresa');
  var selectEmp = new mdc.select.MDCSelect(rootEmp);

  rootEmp.addEventListener('MDCSelect:change', function () {
    hiddenEmp.value = selectEmp.value;
  });
});

demoReady(function () {
  var rootFct = document.getElementById('facturado-js-select');
  var hiddenFct = document.getElementById('hidden-facturado');
  var selectFct = new mdc.select.MDCSelect(rootFct);

  rootFct.addEventListener('MDCSelect:change', function () {
    hiddenFct.value = selectFct.value;
  });
});


//Asignacion de campos de texto a los hidden
demoReady(function () {
  var rootName = document.getElementById('nombre-js-text');
  var inputName = rootName.querySelector('input');
  var hiddenName = document.getElementById('selected-name');
  var textName = new mdc.textField.MDCTextField(rootName);

  inputName.addEventListener('keyup', function () {
    hiddenName.value = textName.value;
  });
  inputName.addEventListener('chage', function () {
    hiddenName.value = textName.value;
  });
  inputName.addEventListener('blur', function () {
    hiddenName.value = textName.value;
  });

});