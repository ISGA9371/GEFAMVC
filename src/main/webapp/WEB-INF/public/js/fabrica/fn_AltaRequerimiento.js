//Funcion inicial
//Variables globales

function init(){

    initGlobal();
    crearCombos();
    asignarCombos();
    desHabilitarDep();
    habilitaFechas();

}

function crearCombos(){

    //mdc.select.MDCSelect.attachTo(document.getElementById('direccion-js-select'));
    //mdc.select.MDCSelect.attachTo(document.getElementById('subdireccion-js-select'));
    //mdc.select.MDCSelect.attachTo(document.getElementById('area-js-select'));
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
    //mdc.select.MDCSelect.attachTo(document.getElementById('responsable-js-select'));
    //mdc.select.MDCSelect.attachTo(document.getElementById('gestor-js-select'));

}

function asignarCombos(){

    //Asigna los valores seleccionados a todos los combos
    $(".mdc-select").each(function(index, element){
        var $parentTd = $(element).parent();
        var $hiddenInput = $parentTd.find("input");
        var rootSelect = document.getElementById($(element).attr("id"));
        var selectObj = new mdc.select.MDCSelect(rootSelect);

        rootSelect.addEventListener('MDCSelect:change', function () {
            $hiddenInput.val(selectObj.value);
        });
    });

    //function direction and subdirection
    const select = new mdc.select.MDCSelect(document.querySelector('#dirs'));
    const subdirs = new mdc.select.MDCSelect(document.querySelector('#subdirs'));
    let coso = 0;
    select.listen('MDCSelect:change', () => {
    if (coso!= 0) return; else coso = 1;
    let id = select.selectedOptions[0].value;
    //SET HIDDEN FIELD VALUE
    $("#hidden-direccion").val(id);
    //clean subdir
    $("#hidden-subdireccion").val("");
    //console.log("seleccion "+ id);
    //console.log("hidden"+ $("#hidden-direccion").val());

    new mdc.select.MDCSelect(document.getElementById('subdirs')).disabled = false;

    $.ajax({
        url: "/api/levels/"+id+"/sub-levels"
    }).done(function(data) {
        //let subdirs = JSON.parse(data);
        let subs = data.data;
        //console.log(subs.length);
        $("#subdir-sel-text").html("");
        subdirs.selectedIndex = -1;
        subdirs.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#subdir-select").html("");
            $.each(subs, function( index, value ) {
                //console.log( index + ": " + value.user.userInternalId );
                //console.log( index + ": " + value.userInternalId );
                $("#subdir-select").append(
                    "<li class='mdc-list-item' role='option' tabindex='0' " +
                    "id='"+value.levelId+"|"+value.user.userInternalId+"'>"+value.levelName+"</li>");
            });
        }else $("#subdir-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
        coso=0;
    });

    });

    var rootSelect = document.getElementById("subdirs");
    var selectObj = new mdc.select.MDCSelect(rootSelect);

    rootSelect.addEventListener('MDCSelect:change', function () {
        $("#subDir").val(selectObj.value.split("|")[1]);
        $("#hidden-subdireccion").val(selectObj.value.split("|")[0]);
        $("#subDir").focus();
    });

    //select userinternal
    const users = new mdc.select.MDCSelect(document.querySelector('#responsable-js-select'));
    $.ajax({
        url: "/api/users/"
    }).done(function(data) {
        //let subdirs = JSON.parse(data);
        let subs = data.data;
        //console.log(subs.length);
        $("#subdir-users-text").html("");
        users.selectedIndex = -1;
        users.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#users-select").html("");
            $.each(subs, function( index, value ) {

                //console.log("impresion"+ value.profileType.profileTypeId );
               if(value.profileType.profileTypeId==7){
                   $("#users-select").append(
                       "<li class='mdc-list-item' role='option' tabindex='0' " +
                       "value='"+value.userInternalId+"'>"+value.userInternalId+"</li>");
               }


            });
        }else $("#users-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");

    });


    //select userinternalarea
    const areaG = new mdc.select.MDCSelect(document.querySelector('#area-js-select'));
    const userG = new mdc.select.MDCSelect(document.querySelector('#gestor-js-select'));
    let valuesS = parseInt("0");
    areaG.listen('MDCSelect:change', () => {
        if (valuesS!= 0) return; else valuesS = 1;
    let id = areaG.selectedOptions[0].id;
    //SET HIDDEN FIELD VALUE
    $("#hidden-direccion").val(id);
    //clean userG
    $("#hidden-gestor").val("");
    //console.log("Seleccion"+id);

    new mdc.select.MDCSelect(document.getElementById('gestor-js-select')).disabled = false;

    $.ajax({
        url: "/api/users/"
    }).done(function(data) {
        //let subdirs = JSON.parse(data);
        let subs = data.data;
        //console.log(subs.length);
        $("#subdir-usersG-text").html("");
        userG.selectedIndex = -1;
        userG.value = "";
        if (typeof subs !== 'undefined' && subs.length > 0) {
            $("#usersG-select").html("");
            $.each(subs, function( index, value ) {

                if(value.profileType.profileTypeId==id){
                    $("#usersG-select").append(
                        "<li class='mdc-list-item' role='option' tabindex='0' " +
                        "value='"+value.userInternalId+"'>"+value.userInternalId+"</li>");
                }

            });
        }else $("#usersG-select").html("<li class='mdc-list-item' role='option' tabindex='0'>SIN DATOS</li>");
        valuesS=0;
    });
    });



}

function funcionCancelar(){

    holder("Cargando...");

    //Lleva a la ventana principal
    window.location="/requirements/filters";

}

function desHabilitarDep(){

    new mdc.select.MDCSelect(document.getElementById('subdirs')).disabled = true;
    new mdc.select.MDCSelect(document.getElementById('gestor-js-select')).disabled = true;

}

function habilitaFechas(){

    var picker1 = $("#datetimepicker1");
    var picker2 = $("#datetimepicker2");

    picker1.datetimepicker({
        format: 'DD/MM/YYYY',
        locale: 'es-mx',
        useCurrent: false
    });

    picker2.datetimepicker({
        format: 'DD/MM/YYYY',
        locale: 'es-mx',
        useCurrent: false
    });

}

function asignHours(){

    $("#hoursRequerimentFinal").val($("#hoursRequirement").val());

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
