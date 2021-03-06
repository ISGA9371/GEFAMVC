$(document).ready(function(){

  $("#fecha_corte").datepicker({
     dateFormat: "dd-mm-yy",
  });
  
  $("#fecha_desde").datepicker({
     dateFormat: "dd-mm-yy",
  }).on("change", function () {
    $("#fecha_hasta").datepicker("option", "minDate", getDate(this));
  });

  $("#fecha_hasta").datepicker({
     dateFormat: "dd-mm-yy",
  }).on("change", function () {
    $("#fecha_desde").datepicker("option", "maxDate", getDate(this));
  });

  function getDate(element) {
    var date;
    try {
      date = $.datepicker.parseDate("dd-mm-yy", element.value);
    } catch (error) {
      date = null;
    }
    return date;
  }

  $.ajax({
    url: "/api/level-types/1/levels",
    method: "GET",
    beforeSend: function () {
      $("#mdc_select_direccion").addClass("mdc-select--disabled");
      $("#mdc_select_direccion > .mdc-select__surface > .mdc-select__selected-text").html("");
      $("#mdc_select_direccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    }
  }).done(function (data) {
    lis = "";
    if ('undefined' !== typeof data.data && 0 < data.data.length) {
      $.each(data.data, function (index, value) {
        lis += "<li class='mdc-list-item' role='option' tabindex='0' id='" + value.levelId + "'>" + value.levelName + "</li>";
      });

      $("#mdc_select_direccion > .mdc-menu > ul").append(lis);
      $("#mdc_select_direccion").removeClass("mdc-select--disabled");
    } else {
      lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
      $("#mdc_select_direccion > .mdc-menu > ul").append(lis);
      $("#mdc_select_direccion").addClass("mdc-select--disabled");
    }
  }).fail(function () {
    lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
    $("#mdc_select_direccion > .mdc-menu > ul").append(lis);
    $("#mdc_select_direccion").addClass("mdc-select--disabled");
  });


  /** EDO PEP FACT */
  $.ajax({
    url: "/api/status-types/13/status",
    method: "GET",
    beforeSend: function () {
      $("#mdc_select_estado_pep_factura").addClass("mdc-select--disabled");
      $("#mdc_select_estado_pep_factura > .mdc-select__surface > .mdc-select__selected-text").html("");
      $("#mdc_select_estado_pep_factura > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    }
  }).done(function (data) {
    lis = "";
    if ('undefined' !== typeof data.data && 0 < data.data.length) {
      $.each(data.data, function (index, value) {
        lis += "<li class='mdc-list-item' role='option' tabindex='0' id='" + value.statusId + "'>" + value.statusName + "</li>";
      });
      $("#mdc_select_estado_pep_factura > .mdc-menu > ul").append(lis);
      $("#mdc_select_estado_pep_factura").removeClass("mdc-select--disabled");
    } else {
      lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
      $("#mdc_select_estado_pep_factura > .mdc-menu > ul").append(lis);
      $("#mdc_select_estado_pep_factura").addClass("mdc-select--disabled");
    }
  }).fail(function () {
    lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
    $("#mdc_select_estado_pep_factura > .mdc-menu > ul").append(lis);
    $("#mdc_select_estado_pep_factura").addClass("mdc-select--disabled");
  });


  mdc_text_fecha_corte = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_fecha_corte'));
  mdc_text_pep = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_pep'));
  mdc_text_requerimiento = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_requerimiento'));
  mdc_select_direccion = new mdc.select.MDCSelect(document.querySelector('#mdc_select_direccion'));
  mdc_select_subdireccion = new mdc.select.MDCSelect(document.querySelector('#mdc_select_subdireccion'));
  mdc_select_estado_pep_factura = new mdc.select.MDCSelect(document.querySelector('#mdc_select_estado_pep_factura'));
  mdc_select_estado_pago = new mdc.select.MDCSelect(document.querySelector('#mdc_select_estado_pago'));
  mdc_text_fecha_desde = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_fecha_desde'));
  mdc_text_fecha_hasta = new mdc.textField.MDCTextField(document.querySelector('#mdc_text_fecha_hasta'));
  

  $("#fecha_corte").change(function(){
    if ( "" != mdc_text_fecha_corte ) {
      $("#mdc_text_fecha_corte > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_text_fecha_corte > label").removeClass("mdc-text-field__label--float-above");
    }
  });


  $("#fecha_desde").change(function () {
    if ( "" != mdc_text_fecha_desde ) {
      $("#mdc_text_fecha_desde > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_text_fecha_desde > label").removeClass("mdc-text-field__label--float-above");
    }
  });


  $("#fecha_hasta").change(function () {
    if ( "" != mdc_text_fecha_hasta ) {
      $("#mdc_text_fecha_hasta > label").addClass("mdc-text-field__label--float-above");
    } else {
      $("#mdc_text_fecha_hasta > label").removeClass("mdc-text-field__label--float-above");
    }
  });


  mdc_select_direccion.listen('MDCSelect:change', () => {
    idSuperior = mdc_select_direccion.value;

    mdc_select_subdireccion.selectedIndex = -1;
    mdc_select_subdireccion.value = "";

    $.ajax({
      url: "/api/levels/" + idSuperior + "/sub-levels",
      method: "GET",
      beforeSend: function () {
        $("#mdc_select_subdireccion").addClass("mdc-select--disabled");
        $("#mdc_select_subdireccion > .mdc-select__surface > .mdc-select__selected-text").html("");
        $("#mdc_select_subdireccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
      }
    }).done(function (data) {
      $("#mdc_select_subdireccion > .mdc-menu > ul").html("");
      lis = "";
      if ( 'undefined' !== typeof data.data && 0 < data.data.length) {
        $.each(data.data, function (index, value) {
          lis += "<li class='mdc-list-item' role='option' tabindex='0' id='" + value.levelId + "'>" + value.levelName + "</li>";
        });

        $("#mdc_select_subdireccion > .mdc-menu > ul").append(lis);
        $("#mdc_select_subdireccion").removeClass("mdc-select--disabled");
      } else {
        lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
        $("#mdc_select_subdireccion > .mdc-menu > ul").append(lis);
        $("#mdc_select_subdireccion").addClass("mdc-select--disabled");
      }
    }).fail(function () {
      lis = "<li class='mdc-list-item' role='option' tabindex='0'></li>";
      $("#mdc_select_subdireccion > .mdc-menu > ul").append(lis);
      $("#mdc_select_subdireccion").addClass("mdc-select--disabled");
    });
  });


  $("#btn_clear").click(function(){
    mdc_text_fecha_corte.value = "";
    mdc_text_pep.value = "";
    mdc_text_requerimiento.value = "";
    mdc_text_fecha_desde.value = "";
    mdc_text_fecha_hasta.value = "";
    mdc_select_direccion.value = "";
    mdc_select_subdireccion.value = "";
    mdc_select_estado_pep_factura.value = "";
    mdc_select_estado_pago.value = "";

    mdc_select_direccion.selectedIndex = -1;
    mdc_select_subdireccion.selectedIndex = -1;
    mdc_select_estado_pep_factura.selectedIndex = -1;
    mdc_select_estado_pago.selectedIndex = -1;

    $("#mdc_select_direccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#mdc_select_subdireccion > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#mdc_select_estado_pep_factura > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");
    $("#mdc_select_estado_pago > .mdc-select__surface > .mdc-select__label").removeClass("mdc-select__label--float-above");

    $("#fecha_hasta").datepicker("option", "minDate", null);
    $("#fecha_desde").datepicker("option", "maxDate", null);
  });


  $("#btn_search").click(function(){

    var params = {
      principalId: mdc_text_fecha_corte.value,
      subPrincipalId: mdc_text_pep.value,
      companyId: mdc_text_requerimiento.value,
      technologyId: mdc_select_direccion.value,
      typologyNewComponent: mdc_select_subdireccion.value,
      statusId: mdc_select_estado_pep_factura.value,
      startProductId: mdc_select_estado_pago.value,
      finalProductId: mdc_text_fecha_desde.value,
      statusTypologyId: mdc_text_fecha_hasta.value,
    };
    console.log(params);

    /*$.ajax({
      url: "/budgets/payments/search",
      method: "GET",
      data: $.param( params ),
      dataType: "json",
      beforeSend: function (xhr) {
        HoldOn.open({
          theme: "sk-cube",
          content: '',
          message: 'Consultado Información',
          backgroundColor: "#0c71ca",
          textColor: "white",
        });
      }
    }).done(function (data) {
      console.log(data);
    }).fail(function(error){
    });
    */
  });


  $("#btn_generate_break").click(function(){});


  $("#btn_import_request").click(function(){});


  $("#btn_save").click(function(){});




});