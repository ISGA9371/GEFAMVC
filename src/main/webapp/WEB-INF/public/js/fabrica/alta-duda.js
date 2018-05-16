function init() {

    camp();
    loadSelects2();
    addButtonEvents();
    userLog();

    $("#hidden-status").val("11");
    $("#hidden-doubtType").val("13");
    $("#hidden-envcomponente").val($("#hidden-componente").val());

    var fecha=$("#datetimepicker").val();
    var dia = fecha.substring(8,10);
    var mes = fecha.substring(5,7);
    var anio = fecha.substring(0,4);
    $("#datetimepickerformat").val(dia+"/"+mes+"/"+anio);

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var ho = today.getHours();
    var mi = today.getMinutes();

    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }
    if (ho < 10) {
        ho = '0' + ho;
    }
    if (mi < 10) {
        mi = '0' + mi;
    }
    var today = 'v' + yyyy + mm + dd;

    $('#doubtVersion').val(today);
    $('#datetimepickerformat').val(dd+ '/' + mm + '/' + yyyy + ' ' + ho + ':' + mi);

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



demoReady(function() {
    var rootEst = document.getElementById('prioridad');
    var hiddenEst = document.getElementById('hidden-prioridad');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});

demoReady(function() {
    var rootEst = document.getElementById('Duda-js-select');
    var hiddenEst = document.getElementById('hidden-dudaSelect');
    var selectEst = new mdc.select.MDCSelect(rootEst);

    rootEst.addEventListener('MDCSelect:change', function() {
        hiddenEst.value = selectEst.value;
    });
});


function camp() {
    new mdc.textField.MDCTextField(document.getElementById("nombre-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("direccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("subdireccion-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("version-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("requerimiento-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tecnologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("tipologia-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("fechaAlta-js-text")).disabled = true;
    new mdc.textField.MDCTextField(document.getElementById("Peticionario-js-text")).disabled = true;
}


function loadSelects2() {
    const prioridad = new mdc.select.MDCSelect(document.querySelector('#prioridad'));
    $.ajax({
        url: "/api/prioritys"
    }).done(function(data) {
        let subs = data.data;
        $("#prioridad-sel-text").html("");
        prioridad.selectedIndex = -1;
        prioridad.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#prioridad-select").html("");
            $.each(subs, function( index, value ) {
                $("#prioridad-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.priorityId+"' value='"+value.priorityId+"'>"+value.priorityName+"</li>");
            });
        }else $("#prioridad-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
    });

    const DudaType = new mdc.select.MDCSelect(document.querySelector('#Duda-js-select'));
    $.ajax({
        url: "/api/doubt-types"
    }).done(function(data) {
        let subs = data.data;
        $("#Duda-sel-text").html("");
        DudaType.selectedIndex = -1;
        DudaType.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#Duda-select").html("");
            $.each(subs, function( index, value ) {
                $("#Duda-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.doubtTypeId+"' value='"+value.doubtTypeId+"'>"+value.doubtTypeName+"</li>");
            });
        }else $("#Duda-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
    });
}

function addButtonEvents() {
    //Actions for save requirements
    $('form').on('submit', function (e) {
        e.preventDefault();
        HoldOn.open({
            theme: "sk-cube",
            content: '',
            message: 'Registrando Duda',
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

function getBase64(file) {
    var reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function () {
        //console.log(reader.result);
    };
    reader.onerror = function (error) {
        //console.log('Error: ', error);
    };
}

function ajaxGuardar() {
    var $form = $("form");
    var url = $form.attr("action");
    var formData = $($form).serializeArray();

    //var file = document.querySelector('#files > input[type="file"]').files[0];
    var file = document.querySelector('input[type=file]').files[0];
    var base = getBase64(file)
    $("#fileData").val(base);


    //console.log(base);

    /*var data = new FormData();
    jQuery.each($('input[type=file]')[0].files, function(i, file) {
        //data.append('file-'+i, file);
        data.append('DoubtFile', file);
    });
    var other_data = $('form').serializeArray();
    $.each(other_data,function(key,input){
        data.append(input.name,input.value);
    });*/



    $.ajax({
        cache: false,
        //contentType: false,
        //processData: false,
        url: url,
        type: 'post',
        data: formData
        //data: data,
        /*success: function(data){
            alert(data);
        }*/
    }).done(function (data) {
        customHolder("info", "Modificacion Registrada Exitosamente.","window.location.href = '/components/filters'; holder('Cargando...')");
        //customHolder("info", "Componente Dado de Alta Exitosamente.","$('html').html(okData);");
    }).fail(function (xhr, status, error) {
        console.log("fail");
        customHolder("error", xhr.responseJSON.message);
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


function userLog() {

    var user=0;
    $.ajax({
        url: "/users/info"
    }).done(function(data) {
        //let subs = data.data;
        user=data.data.profileType.profileTypeId;
        if(user === 4 || user === 5 || user === 8 ){
            $("#responsabletxt").val(data.data.userInternalId);
            $("#hidden-responsable").val(data.data.userInternalId);
        }else{
            holder("Cargando...usuario sin acceso");
            window.location.href = "/";
        }
    });
}