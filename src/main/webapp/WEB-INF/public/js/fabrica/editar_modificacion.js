  var mdc_text_empresa = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_empresa"));
  var mdc_text_requerimiento = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_requerimiento"));
  var mdc_text_version = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_version"));
  var mdc_text_componente = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_componente"));
  var mdc_text_tecnologia = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_tecnologia"));
  var mdc_text_fecha_envio = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_fecha_envio"));
  var mdc_text_tipologia = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_tipologia"));
  var mdc_text_dificultad = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_dificultad"));
  var mdc_text_estado = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_estado"));
  var mdc_text_tipologia_modificacion = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_tipologia_modificacion"));
  var mdc_text_descripcion_modificacion = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_descripcion_modificacion"));
  var mdc_select_prioridad = new mdc.select.MDCSelect(document.querySelector("#mdc_select_prioridad"));
  var mdc_text_usuario_peticionario = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_usuario_peticionario"));
  var mdc_select_origen = new mdc.select.MDCSelect(document.querySelector("#mdc_select_origen"));
  var mdc_text_fecha_prevista_finalizacion = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_fecha_prevista_finalizacion"));
  var mdc_text_fecha_negociada = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_fecha_negociada"));
  var mdc_text_modificacion_vuelo = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_modificacion_vuelo"));
  var mdc_select_estado = new mdc.select.MDCSelect(document.querySelector("#mdc_select_estado"));
  var mdc_text_responsable_resolucion = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_responsable_resolucion"));
  var mdc_text_fecha_cierre = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_fecha_cierre"));
  var mdc_select_modifiacion_realizada_dyd = new mdc.select.MDCSelect(document.querySelector("#mdc_select_modifiacion_realizada_dyd"));
  var mdc_text_comentarios = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_comentarios"));
  var mdc_select_dificultad_modificacion_inicial = new mdc.select.MDCSelect(document.querySelector("#mdc_select_dificultad_modificacion_inicial"));
  var mdc_text_horas_modificacion_inicial = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_horas_modificacion_inicial"));
  var mdc_text_costo_modificacion_inicial = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_costo_modificacion_inicial"));
  var mdc_select_dificultad_modificacion_final = new mdc.select.MDCSelect(document.querySelector("#mdc_select_dificultad_modificacion_final"));
  var mdc_text_horas_modificacion_final = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_horas_modificacion_final"));
  var mdc_text_costo_modificacion_final = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_costo_modificacion_final"));
  var mdc_text_comentario_tipificacion_proveedor = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_comentario_tipificacion_proveedor"));
  var mdc_text_comentario_tipificacion_proyecto = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_comentario_tipificacion_proyecto"));
  var mdc_text_estado_tipificacion_final = new mdc.textField.MDCTextField(document.querySelector("#mdc_text_estado_tipificacion_final"));
  var mdc_select_facturar = new mdc.select.MDCSelect(document.querySelector("#mdc_select_facturar"));


$(document).ready(function () {



  mdc_select_facturar.listen('MDCSelect:change', () => {
    console.log(mdc_select_facturar.value);
    if ( "1" == mdc_select_facturar.value ) {
      $("#asociar-pep").show();
    } else {
      $("#asociar-pep").hide();
    }
  });

});



function init() {

    initGlobal();
    crearCombos();
    asignarCombos();
    addCalendars();
    addMissing();


}

function crearCombos() {

    mdc.select.MDCSelect.attachTo(document.getElementById('DifMod-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('prioridad-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('origen-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('modvuelo-js-select'));
    mdc.select.MDCSelect.attachTo(document.getElementById('moddyd-js-select'));
}

function asignarCombos (){

    $(".mdc-select").each(function(index, element){
        var $parentTd = $(element).parent();
        var $hiddenInput = $parentTd.find("input");
        var rootSelect = document.getElementById($(element).attr("id"));
        var selectObj = new mdc.select.MDCSelect(rootSelect);

        rootSelect.addEventListener('MDCSelect:change', function () {
            $hiddenInput.val(selectObj.value);
        });
    });
}

function addCalendars() {

    type="text/javascript">

        $("#datetimepicker4").datepicker({
            dateFormat: "dd-mm-yy",
        }).on("change", function () {
            $("#datetimepicker5").datepicker("option", "minDate", getDate(this));
        });


    $("#datetimepicker5").datepicker({
        dateFormat: "dd-mm-yy",
    }).on("change", function () {
        $("#datetimepicker6").datepicker("option", "minDate", getDate(this));
    });

    $('#datetimepicker6').datetimepicker({
        format: 'DD/MM/YYYY'
    });

    $('#datetimepicker7').datetimepicker({
        format: 'DD/MM/YYYY'
    });

    $('#datetimepicker8').datetimepicker({
        format: 'DD/MM/YYYY'
    });

    $('#datetimepicker9').datetimepicker({
        format: 'DD/MM/YYYY'
    });


}

function addMissing() {

    $("#hidden-status").val("5");

    $("#hidden-modificationStatus").val("5");

    $("#hidden-comp").val( $("#hidden-envcomponente").val());

    $("#hidden-startTyp").val($("#hidden-startTypology").val());

    $("#hidden-finalTyp").val($("#hidden-finalTypology").val());

    $("#hidden-status").val($("#hidden-modificationStatus").val());

    $("#hidden-userre").val("XMY3080");




}

function holder(msg){
    HoldOn.open({
        theme: "sk-cube",
        content: '',
        message: msg,
// backgroundColor: "#004582",
        backgroundColor: "#0c71ca",
        textColor: "white",
    });
}
