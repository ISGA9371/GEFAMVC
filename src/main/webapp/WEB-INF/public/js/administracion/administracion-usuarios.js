
var editUser= $("#container-user-edit");

function init() {
    mdc.select.MDCSelect.attachTo(document.getElementById('slct_perfil'));
    mdc.select.MDCSelect.attachTo(document.getElementById('slct_empresa'));
    mdc.select.MDCSelect.attachTo(document.getElementById('slct_estadoEdit'));
    mdc.select.MDCSelect.attachTo(document.getElementById('slct_perfilEdit'));
}


$('tr.clickable').click(function() {
    editUser.attr("class","collapse-in");
    let target = $(this).attr("aria-controls");

    $("#"+target).collapse('toggle');
});

editUser.click(function () {
    if($(this).attr("href")) {
        showHoldOn();
        $("#table-data tbody").html("");
    }
});

$.ajax({
    async: false,
    url: "/api/companies"
}).done(function(json){
    $.each(json.data, function(i, data) {
        $liElement = $("<li>");
        $liElement.attr("class","mdc-list-item");
        $liElement.attr("role","option");
        $liElement.attr("id",data.companyId);
        $liElement.append(data.companyBusinessName);
        $("#slct_empresa").find("ul:first").append($liElement);
    });
}).fail(function(xhr, status, error) {
    console.log('¡Error al consultar combos!');
    customHolder('error','¡Error al consultar combos!');
    showingError = true;
    //$('#slct_empresa').val("");
});
$.ajax({
    async: false,
    url: "/api/status-types/1/status"
}).done(function(json){
    $.each(json.data, function(i, data) {
        $liElement = $("<li>");
        $liElement.attr("class","mdc-list-item");
        $liElement.attr("role","option");
        $liElement.attr("id",data.statusId);
        $liElement.append(data.statusName);
        $("#slct_estadoEdit").find("ul:first").append($liElement);
    });
}).fail(function(xhr, status, error) {
    console.log('¡Error al consultar combos!');
    customHolder('error','¡Error al consultar combos!');
    showingError = true;
    //$('#slct_estadoEdit').val("");
});

$.ajax({
    async: false,
    url: "/api/profile-types"
}).done(function(json){
    $.each(json.data, function(i, data) {
        $liElement = $("<li>");
        $liElement.attr("class","mdc-list-item");
        $liElement.attr("role","option");
        $liElement.attr("id",data.profileTypeId);
        $liElement.append(data.profileTypeName);
        $("#slct_perfil").find("ul:first").append($liElement);
    });
}).fail(function(xhr, status, error) {
    console.log('¡Error al consultar combos!');
    customHolder('error','¡Error al consultar combos!');
    showingError = true;
    //$('#slct_perfil').val("");
});

$.ajax({
    async: false,
    url: "/api/profile-types"
}).done(function(json){
    $.each(json.data, function(i, data) {
        $liElement = $("<li>");
        $liElement.attr("class","mdc-list-item");
        $liElement.attr("role","option");
        $liElement.attr("id",data.profileTypeId);
        $liElement.append(data.profileTypeName);
        $("#slct_perfilEdit").find("ul:first").append($liElement);
    });
}).fail(function(xhr, status, error) {
    console.log('¡Error al consultar combos!');
    customHolder('error','¡Error al consultar combos!');
    showingError = true;
    //$('#slct_perfilEdit').val("");
});

$.ajax({
    async: false,
    url: "/api/users"
}).done(function(json){
        $.each(json.data, function(i, data) {
        console.log(data.userInternalId);
        cloned = $("#base").clone();
        cloned.find("#user").html(data.userInternalId);
        cloned.find("#status").html(data.status.statusName);
        cloned.find("#profile").html(data.profileType.profileTypeName);
        $("#base").parent().append(cloned);
        $("#base").parent().append($("#base").next().clone());
        document.getElementById("noUsers").style.display="none";
    });
}).fail(function(xhr, status, error) {
    console.log('¡Error al consultar combos!');
    customHolder('error','¡Error al consultar combos!');
    showingError = true;
});
/*
function paginar(numPage){
    var limiter = (10 * (numPage - 1));
    $.ajax({
        async: false,
        url: "/api/users"
    }).done(function(json){
        $.each(json.data.slice(0 + limiter, 10 + limiter), function (i, data) {
            console.log(data.userInternalId);
            cloned = $("#base").clone();
            cloned.find("#user").html(data.userInternalId);
            cloned.find("#status").html(data.status.statusName);
            cloned.find("#profile").html(data.profileType.profileTypeName);
            $("#base").parent().append(cloned);
            $("#base").parent().append($("#base").next().clone());
            document.getElementById("noUsers").style.display="none";
        });
    }).fail(function(xhr, status, error) {
        console.log('¡Error al consultar combos!');
        customHolder('error','¡Error al consultar combos!');
        showingError = true;
    });
}*/


$($.find("#base")).eq(0).css("display", "none");