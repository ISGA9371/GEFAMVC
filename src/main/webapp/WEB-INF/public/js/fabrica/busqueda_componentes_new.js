$(function () {

  $('#datetimepickerReal').datetimepicker({
    format: 'DD/MM/YYYY'
  });

  $('#datetimepickerPrev').datetimepicker({
    format: 'DD/MM/YYYY'
  });

  $('#datetimepickerNego').datetimepicker({
    format: 'DD/MM/YYYY'
  });

  $('#datetimepickerRealFact').datetimepicker({
    format: 'DD/MM/YYYY'
  });

  $("#tabs").tabs();

  const tecnologia = new mdc.select.MDCSelect(document.querySelector('#slct_tecnologia'));
  
  console.log(tecnologia);

  tecnologia.listen('MDCSelect:change', () => {
     alert(`Selected "${tecnologia.selectedOptions[0].textContent}" at index ${tecnologia.selectedIndex} ` +
       `with value "${tecnologia.value}"`);
  });


  $("#btn-submit").click(function(){
    $("#hdn_txt_componente").val( $("#txt_componente").val() );
    $("#hdn_txt_requerimiento").val( $("#txt_requerimiento").val() );
    $("#hdn_txt_version").val( $("#txt_version").val() );
    $("#hdn_txt_datetimepickerReal").val( $("#txt_datetimepickerReal").val() );
    $("#hdn_txt_datetimepickerPrev").val( $("#txt_datetimepickerPrev").val() );
    $("#hdn_txt_datetimepickerNego").val( $("#txt_datetimepickerNego").val() );
    $("#hdn_txt_datetimepickerRealFact").val( $("#txt_datetimepickerRealFact").val() );
    $("#hdn_txt_horas_iniciales").val( $("#txt_horas_iniciales").val() );
    $("#hdn_txt_horas_finales").val( $("#txt_horas_finales").val() );

    $("#form").submit();
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

