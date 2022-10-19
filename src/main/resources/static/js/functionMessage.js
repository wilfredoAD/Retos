function guardarInformacion() {
    $("#resultado").empty();

    let myData = {
        messageText: $("#messageText").val(),
        partyroom: { id: $("#partyroomId").val() },
        client: { idClient: $("#clientId").val() },
    };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://132.145.219.71:8080/api/Message/save",
        type: "POST",
        data: dataToSend,
        datatype: "JSON",
        contentType: "application/json",
        success: function(respuesta) {
            alert("Inserción exitosa");
            traerInformacion();
            $("#messageText").val('');
            $("#partyroomId").val('');
            $("#clientId").val('');
        },
        error: function(xhr, status) {
            alert("Operacion no satisfactoria," + xhr.status);
            traerInformacion();
        },
    });
}

function traerInformacion() {
    $.ajax({
        url: "http://132.145.219.71:8080/api/Message/all",
        type: "GET",
        datatype: "JSON",
        success: function(respuesta) {
            pintarRespuestaMensaje(respuesta);
            traerInformacion();
        },
        error: function(xhr, status) {
            alert("Operacion no satisfactoria," + xhr.status);
        },
    });
}

function pintarRespuestaMensaje(items) {
    $("#resultado").empty();

    let myTable = "<table>";
    myTable +=
        "<caption>Info Messages</caption><tr><th>Texto del Mensaje</th><th>Acciones</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].messageText + "</td>";
        myTable +=
            "<td><button onclick='borrarElemento(" + items[i].idMessage + ")'>Borrar</button></td>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultado").append(myTable);
}



function editarInformacion() {
    let myData = {
        idMessage: $("#idMessage").val(),
        messageText: $("#messageText").val(),
        partyroom: { id: $("#partyroomId").val() },
        client: { idClient: $("#clientId").val() }
    };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://132.145.219.71:8080/api/Message/update",
        type: "PUT",
        data: dataToSend,
        datatype: "JSON",
        contentType: "application/json",
        success: function(respuesta) {
            alert("Actualizacion exitosa");
            traerInformacion();
            $("#idMessage").val('');
            $("#messageText").val('');
            $("#partyroomId").val('');
            $("#clientId").val('');
        },
        error: function(xhr, status) {
            alert("Operacion no satisfactoria," + xhr.status);
            traerInformacion();
        },
    });
}

function borrarElemento(idElemento) {
    let myData = { idMessage: idElemento };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://132.145.219.71:8080/api/Message/" + idElemento,
        type: "DELETE",
        data: dataToSend,
        contentType: "application/json",
        datatype: "JSON",
        success: function(respuesta) {
            alert("Borrado exitoso");
            traerInformacion();
        },
        error: function(xhr, status) {
            alert("Operacion no satisfactoria," + xhr.status);
            traerInformacion();
        },
    });
}