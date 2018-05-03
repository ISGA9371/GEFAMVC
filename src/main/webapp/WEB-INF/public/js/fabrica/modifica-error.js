function init() {
    camp();
    addButtonEvents();

    $("#hidden-envcomponente").val($("#hidden-componente").val());

    var fecha=$("#datetimepicker").val();
    var dia = fecha.substring(8,10);
    var mes = fecha.substring(5,7);
    var anio = fecha.substring(0,4);
    $("#datetimepickerformat").val(dia+"/"+mes+"/"+anio);
}

function rojelia(){
    var descrip = $('#descripcion2').val();
    var descri = $('#descripcion').val();
    var des = $('#desfijo').val();

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;

    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }
    var today = 'v' + yyyy + mm + dd;

    $('#desfijo').val(descri + " | " + descrip + " - "+ dd+"/"+mm+"/"+yyyy);
}

$(function () {
    $('#datetimepicker4').datetimepicker({
        format: 'DD/MM/YYYY'
    });
});

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

function camp() {
    new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Subdireccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Version-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Requerimiento")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Tecnologia")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Prioridad")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Origen")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Incidencia")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("descripcion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Peticionario")).disabled = true;
}

function addButtonEvents() {
    //Actions for save requirements
    $('form').on('submit', function (e) {
        e.preventDefault();
        HoldOn.open({
            theme: "sk-cube",
            content: '',
            message: 'Registrando Incidencia',
            // backgroundColor: "#004582",
            backgroundColor: "#0c71ca",
            textColor: "white"
        });
        setTimeout("ajaxGuardar();", 500)
    });

    //Actions for cancel requirements
    var btnCancel = document.getElementById('cancelar-btn');
    btnCancel.addEventListener("click", function () {
        holder("Cargando...");
        window.location.href = "/components/filters";
    })
}

function ajaxGuardar() {
    var $form = $("form");
    var url = $form.attr("action");
    var formData = $($form).serializeArray();

    $.ajax({
        async: false,
        url: url,
        type: 'post',
        data: formData
    }).done(function (data) {
        customHolder("info", "Duda Registrada Exitosamente.","window.location.href =  '/issues/" + $(data).find("#issueId").val() + "'; holder('Cargando...')");
        //customHolder("info", "Componente Dado de Alta Exitosamente.","$('html').html(okData);");
    }).fail(function (xhr, status, error) {
        console.log("fail");
        customHolder("error", xhr.responseJSON.message)
    });
}

function customHolder(type, msg, fctn) {
    var options = null;
    fctn = fctn == undefined ? "" : fctn;
    switch(type){
        case "Error":
        case "ERROR":
        case "error":
            options = msgAssets.error;
            break;
        case "Aviso":
        case "AVISO":
        case "aviso":
            options = msgAssets.warn;
            break;
        default:
            options = msgAssets.info;
    }
    msg = msg == undefined ? options.defaultMsg : msg;
    HoldOn.open({
        theme: "custom",
        // If theme == "custom" , the content option will be available to customize the logo
        content: '<img style="height: 57px; margin-left: -5px;" src="data:image/png;base64,' + options.icon + '" >',
        message: "<br>" + msg +'<br><br><input type="button" value="Aceptar" class="btn btn-default" onclick="HoldOn.close();'+fctn+'">',
        backgroundColor: "#0c71ca",
        textColor: "white"
    });
}
