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

  const select = new mdc.select.MDCSelect(document.querySelector('#dirs'));
  let coso = parseInt("0");
  select.listen('MDCSelect:change', () => {
    if (++coso > 1) { coso = 0; return; }

    let id = select.selectedOptions[0].value;

    $.ajax({
      url: "/nivel/" + id + "/subdir"
    }).done(function (data) {
      let subdirs = JSON.parse(data);
      console.log(subdirs.length);
      $("#subdir-sel-text").html("");
      if (typeof subdirs !== 'undefined' && subdirs.length > 0) {
        $("#subdir-select").html("");
        $.each(subdirs, function (index, value) {
          console.log(index + ": " + value.levelSerial);
          $("#subdir-select").append(
            "<li class='mdc-list-item' role='option' tabindex='0' " +
            "value='" + value.levelSerial + "'>" + value.levelName + "</li>");

        });
      } else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'></li>");

    });
  });

  mdc.autoInit()
});

