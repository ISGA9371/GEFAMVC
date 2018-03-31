$(function () {
  $('#datetimepicker4').datetimepicker({
    format: 'DD/MM/YYYY'
  });
});

demoReady(function () {
    mdc.select.MDCSelect.attachTo(document.getElementById('Prioridad-js-select'));
});


//Asignacion de campos de texto a los hidden
demoReady(function() {
    var rootName = document.getElementById('nombre-js-text');
    var inputName = rootName.querySelector('input');
    var hiddenName = document.getElementById('nombre-js-hidden');
    var textName = new mdc.textField.MDCTextField(rootName);

    inputName.addEventListener('keyup', function() {
        hiddenName.value = textName.value;
    });
    inputName.addEventListener('change', function() {
        hiddenName.value = textName.value;
    });
    inputName.addEventListener('blur', function() {
        hiddenName.value = textName.value;
    });
});
demoReady(function() {
    var rootdireccion = document.getElementById('direccion-js-text');
    var inputdireccion = rootdireccion.querySelector('input');
    var hiddendireccion = document.getElementById('direccion-js-hidden');
    var textdireccion = new mdc.textField.MDCTextField(rootdireccion);

    inputdireccion.addEventListener('keyup', function() {
        hiddendireccion.value = textdireccion.value;
    });
    inputdireccion.addEventListener('change', function() {
        hiddendireccion.value = textdireccion.value;
    });
    inputdireccion.addEventListener('blur', function() {
        hiddendireccion.value = textdireccion.value;
    });
});
demoReady(function() {
    var rootsubdireccion = document.getElementById('subdireccion-js-text');
    var inputsubdireccion = rootsubdireccion.querySelector('input');
    var hiddensubdireccion = document.getElementById('subdireccion-js-hidden');
    var textsubdireccion = new mdc.textField.MDCTextField(rootsubdireccion);

    inputsubdireccion.addEventListener('keyup', function() {
        hiddensubdireccion.value = textsubdireccion.value;
    });
    inputsubdireccion.addEventListener('change', function() {
        hiddensubdireccion.value = textsubdireccion.value;
    });
    inputsubdireccion.addEventListener('blur', function() {
        hiddensubdireccion.value = textsubdireccion.value;
    });
});
demoReady(function() {
    var rootversion = document.getElementById('version-js-text');
    var inputversion = rootversion.querySelector('input');
    var hiddenversion = document.getElementById('version-js-hidden');
    var textversion = new mdc.textField.MDCTextField(rootversion);

    inputversion.addEventListener('keyup', function() {
        hiddenversion.value = textversion.value;
    });
    inputversion.addEventListener('change', function() {
        hiddenversion.value = textversion.value;
    });
    inputversion.addEventListener('blur', function() {
        hiddenversion.value = textversion.value;
    });
});
demoReady(function() {
    var rootrequerimiento = document.getElementById('requerimiento-js-text');
    var inputrequerimiento = rootrequerimiento.querySelector('input');
    var hiddenrequerimiento = document.getElementById('requerimiento-js-hidden');
    var textrequerimiento = new mdc.textField.MDCTextField(rootrequerimiento);

    inputrequerimiento.addEventListener('keyup', function() {
        hiddenrequerimiento.value = textrequerimiento.value;
    });
    inputrequerimiento.addEventListener('change', function() {
        hiddenrequerimiento.value = textrequerimiento.value;
    });
    inputrequerimiento.addEventListener('blur', function() {
        hiddenrequerimiento.value = textrequerimiento.value;
    });
});
demoReady(function() {
    var roottecnologia = document.getElementById('tecnologia-js-text');
    var inputtecnologia = roottecnologia.querySelector('input');
    var hiddentecnologia = document.getElementById('tecnologia-js-hidden');
    var texttecnologia = new mdc.textField.MDCTextField(roottecnologia);

    inputtecnologia.addEventListener('keyup', function() {
        hiddentecnologia.value = texttecnologia.value;
    });
    inputtecnologia.addEventListener('change', function() {
        hiddentecnologia.value = texttecnologia.value;
    });
    inputtecnologia.addEventListener('blur', function() {
        hiddentecnologia.value = texttecnologia.value;
    });
});
demoReady(function() {
    var roottipologia = document.getElementById('tipologia-js-text');
    var inputtipologia = roottipologia.querySelector('input');
    var hiddentipologia = document.getElementById('tipologia-js-hidden');
    var texttipologia = new mdc.textField.MDCTextField(roottipologia);

    inputtipologia.addEventListener('keyup', function() {
        hiddentipologia.value = texttipologia.value;
    });
    inputtipologia.addEventListener('change', function() {
        hiddentipologia.value = texttipologia.value;
    });
    inputtipologia.addEventListener('blur', function() {
        hiddentipologia.value = texttipologia.value;
    });
});
demoReady(function() {
    var rootfechaAlta = document.getElementById('fechaAlta-js-text');
    var inputfechaAlta = rootfechaAlta.querySelector('input');
    var hiddenfechaAlta = document.getElementById('fechaAlta-js-hidden');
    var textfechaAlta = new mdc.textField.MDCTextField(rootfechaAlta);

    inputfechaAlta.addEventListener('keyup', function() {
        hiddenfechaAlta.value = textfechaAlta.value;
    });
    inputfechaAlta.addEventListener('change', function() {
        hiddenfechaAlta.value = textfechaAlta.value;
    });
    inputfechaAlta.addEventListener('blur', function() {
        hiddenfechaAlta.value = textfechaAlta.value;
    });
});
demoReady(function() {
    var rootusuarioPeticionario = document.getElementById('usuarioPeticionario-js-text');
    var inputusuarioPeticionario = rootusuarioPeticionario.querySelector('input');
    var hiddenusuarioPeticionario = document.getElementById('usuarioPeticionario-js-hidden');
    var textusuarioPeticionario = new mdc.textField.MDCTextField(rootusuarioPeticionario);

    inputusuarioPeticionario.addEventListener('keyup', function() {
        hiddenusuarioPeticionario.value = textusuarioPeticionario.value;
    });
    inputusuarioPeticionario.addEventListener('change', function() {
        hiddenusuarioPeticionario.value = textusuarioPeticionario.value;
    });
    inputusuarioPeticionario.addEventListener('blur', function() {
        hiddenusuarioPeticionario.value = textusuarioPeticionario.value;
    });
});
demoReady(function() {
    var rootdescripcion = document.getElementById('descripcion-js-text');
    var inputdescripcion = rootdescripcion.querySelector('input');
    var hiddendescripcion = document.getElementById('descripcion-js-hidden');
    var textdescripcion = new mdc.textField.MDCTextField(rootdescripcion);

    inputdescripcion.addEventListener('keyup', function() {
        hiddendescripcion.value = textdescripcion.value;
    });
    inputdescripcion.addEventListener('change', function() {
        hiddendescripcion.value = textdescripcion.value;
    });
    inputdescripcion.addEventListener('blur', function() {
        hiddendescripcion.value = textdescripcion.value;
    });
});