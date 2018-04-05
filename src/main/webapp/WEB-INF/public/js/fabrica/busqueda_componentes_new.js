$(function () {

  $('#txt_datetimepickerReal').datetimepicker({
    format: 'DD/MM/YYYY'
  });

  $('#txt_datetimepickerPrev').datetimepicker({
    format: 'DD/MM/YYYY'
  });

  $('#txt_datetimepickerNego').datetimepicker({
    format: 'DD/MM/YYYY'
  });

  $('#txt_datetimepickerRealFact').datetimepicker({
    format: 'DD/MM/YYYY'
  });

  $("#tabs").tabs();
  

  const direccion    = new mdc.select.MDCSelect(document.querySelector('#slct_direccion'));
  const subidreccion = new mdc.select.MDCSelect(document.querySelector('#slct_subidreccion'));
  const empresa      = new mdc.select.MDCSelect(document.querySelector('#slct_empresa'));
  const tecnologia   = new mdc.select.MDCSelect(document.querySelector('#slct_tecnologia'));
  const nuevo_modificado  = new mdc.select.MDCSelect(document.querySelector('#slct_nuevo_modificado'));
  const estado            = new mdc.select.MDCSelect(document.querySelector('#slct_estado'));
  const tipologia_inicial = new mdc.select.MDCSelect(document.querySelector('#slct_tipologia_inicial'));
  const tipologia_final   = new mdc.select.MDCSelect(document.querySelector('#slct_tipologia_final'));
  const dificultad_inicial = new mdc.select.MDCSelect(document.querySelector('#slct_dificultad_inicial'));
  const estado_tipificado  = new mdc.select.MDCSelect(document.querySelector('#slct_estado_tipificado'));
  const dificultad_final   = new mdc.select.MDCSelect(document.querySelector('#slct_dificultad_final '));


  direccion.listen('MDCSelect:change', () => {
    //  alert(`Selected "${tecnologia.selectedOptions[0].textContent}" at index ${tecnologia.selectedIndex} ` +
    //    `with value "${tecnologia.value}"`);


  });

  
  $("#btn-submit").click(function(){

    $("#hdn_slct_direccion").val(direccion.value);
    $("#hdn_slct_subidreccion").val(subidreccion.value);
    $("#hdn_slct_empresa").val(empresa.value);
    $("#hdn_slct_tecnologia").val(tecnologia.value);
    $("#hdn_slct_nuevo_modificado").val(nuevo_modificado.value);
    $("#hdn_slct_estado").val(estado.value);
    $("#hdn_slct_tipologia_inicial").val(tipologia_inicial.value);
    $("#hdn_slct_tipologia_final").val(tipologia_final.value);
    $("#hdn_slct_dificultad_inicial").val(dificultad_inicial.value);
    $("#hdn_slct_estado_tipificado").val(estado_tipificado.value);
    $("#hdn_slct_dificultad_final").val(dificultad_final.value);


    // $("#form").submit();
  });




  // const select = new mdc.select.MDCSelect(document.querySelector('#dirs'));
  // let coso = parseInt("0");
  // select.listen('MDCSelect:change', () => {
  //   if (++coso > 1) { coso = 0; return; }

  //   let id = select.selectedOptions[0].value;

  //   $.ajax({
  //     url: "/nivel/" + id + "/subdir"
  //   }).done(function (data) {
  //     let subdirs = JSON.parse(data);
  //     console.log(subdirs.length);
  //     $("#subdir-sel-text").html("");
  //     if (typeof subdirs !== 'undefined' && subdirs.length > 0) {
  //       $("#subdir-select").html("");
  //       $.each(subdirs, function (index, value) {
  //         console.log(index + ": " + value.levelSerial);
  //         $("#subdir-select").append(
  //           "<li class='mdc-list-item' role='option' tabindex='0' " +
  //           "value='" + value.levelSerial + "'>" + value.levelName + "</li>");

  //       });
  //     } else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");

  //   });
  // });

  mdc.autoInit()
});

