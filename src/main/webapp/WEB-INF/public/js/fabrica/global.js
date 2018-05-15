function initGlobal(){
    $(".mdc-menu").width($(".mdc-select").filter(":visible").filter(":first").width());
    scrollLockerOnSelec();
}

function scrollLockerOnSelec(){
    $("html").on("click", function(event){
        openedSelect = $(".mdc-select--open");
        if($(event.target).attr("class") == "mdc-list-item"){
            $("body").css({"overflow": "auto", "margin-right": "0px"});
            $("footer").css({"width": "100%"});
        } else {
            if(openedSelect.length > 0 && (window.innerHeight < (document.body.clientHeight+40))){
                $("body").css({"overflow": "hidden", "margin-right": getScrollBarWidth()+"px"});
                $("footer").css({"width":"100%"});
                $("footer").css({"width":+(100-(getScrollBarWidth()*100)/$("footer").width()).toFixed(2)+"%"});
            } else {
                $("body").css({"overflow": "auto", "margin-right": "0px"});
                $("footer").css({"width": "100%"});
            }
        }
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

function getScrollBarWidth() {
    var inner = document.createElement('p');
    inner.style.width = "100%";
    inner.style.height = "200px";

    var outer = document.createElement('div');
    outer.style.position = "absolute";
    outer.style.top = "0px";
    outer.style.left = "0px";
    outer.style.visibility = "hidden";
    outer.style.width = "200px";
    outer.style.height = "150px";
    outer.style.overflow = "hidden";
    outer.appendChild (inner);

    document.body.appendChild (outer);
    var w1 = inner.offsetWidth;
    outer.style.overflow = 'scroll';
    var w2 = inner.offsetWidth;
    if (w1 == w2) w2 = outer.clientWidth;

    document.body.removeChild (outer);

    return (w1 - w2);
};

var msgAssets = new Object();
msgAssets.info = new Object();
msgAssets.info.defaultMsg = "Mesaje de Aviso no especificado.";
msgAssets.info.icon = "iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAQAAAD/5HvMAAADgElEQVR4Ae3a30tUaRzH8SescevMaMjMGt2Kf8DSLyqxaLcGvAnWi/6KklOE4p8QtIIKCsuaw27k1k0yEkHBVJLIEvsPLGNepTWMQ3fNmaH3evfl4Xh+zDnPA17M6/MPvMHzeMZ5VF1dXYcVDkWmKbHJNnU8POpss0mJaW5wApVsis43yF3W8QjT5B0uP9oPusoabeJqUWbUXtA13pPEOlfMB53mb9J4zCmTQbf4SloNxs0E9bLIwXZ5wgRFhhggs78BhigywQqfOdgcmbRBfVTwqzPHOVTIzjPPHn6vyKYJKvAvoPuEi4OKMYd77AC6DxSSBvX5cjwexIqRZXlIy5eUSxLUSwXdf/yESrAzVNG9JtN50AK6VXKohOtnDd1sp0G30P1ODyrFjrKE7tdOgk7zFT1HGZie1GAwftAKIFbpMRLUQxkQf8YNuqY/ypHPDiLyWaoCYjRe0HuEJycrRZDsLG3E2zhBVwHxAGUkSDYDiJHooDXEJxzjQTl2EatRQYO0ES7KWJDsPqJFITzoLqKOYyUoyx7iTnjQOmIOZWkLiDdhQQ4e4py1oIuIbxwPDioidlHWdoQa4npw0DTiCcriniKmgoNKiAmrQS7iUXDQJqJoNWgMsREctI0YQskMHXvZMGIrOKiOGLAalEfUgoM8RMZqUC+ieXiDDv+P7FA91MmPPcL0sdd/MdoMchFL8V4dK1aDniEmg4NuID5bDNJfrr8EB53AQ5y3FRT98UP2DjFvLWgRUUGFBbmIPRwrQTkaiNtRH/JbiHtWgiYRHvnwIEUZsUPWeFAfXxDPUVFBo4B4aDxoFgGXgoNk64gWZ4wGXaCtP9Bxgq4goEq/saCTfER853J4kOwxAsqGvo45ygsELKPiBp2igYA/jPzps4yAOoXoINk46Empv9IrobvZ6Zee8+jK9CfOOckLdDOoToMyvEJX5WyinAt8RPeSY/GDZDk+oGsxQ66jmD5maaP7Byfx1YIvCXa5TzbmO2uKL+DLyae5fMnxGr89FrjIkZATdYlFGvi9xEl7PZVhjoPVeIrLGMPk6d1fnmHGcHlGjYP9xjEzF3jjNEirzk2TV5yD/EVy31mmYP4SeJS3JFFhxN41+QirtIjL4zmX7f8jQYE7vKFJmG9UuC0H3F6Q7DjXmeIRG2xRo7m/GltssMQkP/MDKtkUdtcN6gZ1g/4Hcx7nSGjajrgAAAAASUVORK5CYII=";
msgAssets.info.textColor = "#0c71ca";
msgAssets.error = new Object();
msgAssets.error.defaultMsg = "Ocurrio un Error no Identificado.";
msgAssets.error.icon = "iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAQAAAD/5HvMAAACuUlEQVR4Ae3ay0obURjA8bOaeKmXlYnBZ9Fq8AJeoCpk4UMouhF9jS6yEEQptIKbmuiqoI4hZGVLH0CyF6HBTWcS+BfpTjhfznwzR1zkf7YRfpCZc8b5Yt5r/fr1Y5glDjmlSYsnYmKeaNHkhAMWGcboluaPJtmjToxUzB275P2DSlzRxbUul8z6Ay3QRFODUvagKc5J0xnFLEFbPJO2NuVsQAMckVUVcmlB44Rk2TWjaUAFfpN1P8lrQePoOTJpVAMaIMRXN+SSg47wWSUpaAvflZOApnjGd22K7qBz3qKvrqAFpL6zSYRLf1mnhtScG6gpcgIMa0QOnGUMgUiqu4BKPTkva5XIgfOyAqrYm+kNunLgCKRXnP+kC2zVeoEm6WJrA4Oxkyycl7WJrQ55GbSHvYjVV59eIXLgyFfcjgyqg0hakUgKDoQS6AMx6EkKDkQM2UFLABqSmgMwbwcdgoq0TKTmwL4ddAqOpOXXJDUHju2gJmhJag407KAWKEl6DjzYQU+ICTuOngOPdlAMSpKeA9H7B73fr6yl5cjHrv6ibuo5epJ025+oOWusqknCxnig5kTyw4n26FhUc+RjV324DhNrOWpSxKAdZLhTcvSkW4wE2tVzxIcTe9syqEAXW58EjnzsrmOrw4QMMlxiq0YgcyykHDVsVTG9QLPYqxLYORaSxIHp3iBDA3sXCf+VljkhxgVUerOXDTNuIMMZb9EXjCuoSBvf/aHgDjKU8d1G0peeFXz2GZMUlOMaX/0gSA4yjPELH90zoh0t5D2Q7plIM3wZ4ybjL2sk7XgqRyXDSznIZoBXpp3BvrOR5YizyLeUu3Ih+yHwHHU0hcz4G5N/pEYH1zpUmfb/Q4I8O4Q9n4du2RZucAGkXUPMs88xDR54JCLikQcaHLPPPIP6n1r4XX1QH9QH/QM0RtJPclbiqwAAAABJRU5ErkJggg==";
msgAssets.error.textColor = "#ff0000";
msgAssets.warn = new Object();
msgAssets.warn.defaultMsg = "Ocurrio un Evento Inesperado.";
msgAssets.warn.icon = "iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAQAAAD/5HvMAAABoElEQVR4AezOMQ7BcBhA8aZJh06d2BiZmblAL8ABuAAH4AIcgAtwDWZmRjamTh2aNE86NJGm2g7N9/0l/b0LPKvxHxoNfHysOrKoI4c7NxxzhpYkFqYMtQlIBLTMGNqT2pkwNCQmFTPQHzrz7aQ9NCVrojnk8iTrgas3tCbPSmuoS0iekI7O0JFfDhpDY4qMpIdsrhS5YMsOzSkzkxzyeFPmhSc3tKWKjdRQn4gqInoyQ59269gGQBgGomjmy76wnmkRouDpIqDweYHfWHp7Pd32RtAs2fQgxyrMYetYpTlsHas0h61iFeewVazebZzuMoetY5WCHLaOVQpy2DpWKchh61ilIIetY5WCHLaOVQpy2DpWKchh61ilIIetY5WCHLaOVQpy2DpWKchhS1j1OWwJqz6HLWHV57AlrPoctoRVn8OWsOpz2DpW/e0JtoDVIAhgC1gNggC2gNUgCGALWA2CALaA1SAIYAtYDQawBawGA9gCVoMBbAGrwQC2gNVgAFvAajCALWA1GMA2xOp62IZYXQ/bUb+6DuqgDuqg7+8AxTRCLX3G8n0AAAAASUVORK5CYII=";
msgAssets.warn.textColor = "#e6ac00";

$(function () {
    $("ul.sub-menu li a").click(function () {
        HoldOn.open({
            theme: "sk-cube",
            content: '',
            message: 'Cargando...',
            // backgroundColor: "#004582",
            backgroundColor: "#0c71ca",
            textColor: "white",
        });
    });

    $("#header-profiles").change(function(){
      alert("perfil: " + $(this).val() );
    });
});
