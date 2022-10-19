function saveInformationClient() {
    $("#resultado").empty();

    let myData = {
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val(),
        password: $("#password").val(),
    };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Client/save",
        type: "POST",
        data: dataToSend,
        datatype: "JSON",
        contentType: "application/json",
        success: function(respuesta) {
            alert("Inserción exitosa");
            traerInformacion();
            $("#name").val('');
            $("#email").val('');
            $("#age").val('');
            $("#password").val('');
        },
        error: function(xhr, status) {
            alert("Operacion no satisfactoria," + xhr.status);
            traerInformacion();
        },
    });
}

function traerInformacion() {
    $.ajax({
        url: "http://localhost:8080/api/Client/all",
        type: "GET",
        datatype: "JSON",
        success: function(respuesta) {
            pintarRespuestaCliente(respuesta);
            traerInformacion();
        },
        error: function(xhr, status) {
            alert("Operacion no satisfactoria," + xhr.status);
        },
    });
}

function pintarRespuestaCliente(items) {
    $("#resultado").empty();

    let myTable = "<table>";
    myTable +=
        "<caption>Info Clientes</caption><tr><th>Codigo</th><th>Nombre</th><th>Email</th><th>Edad</th><th>Acciones</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].idClient + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].email + "</td>";
        myTable += "<td>" + items[i].age + "</td>";
        myTable += "<td><button onclick='borrarElemento(" + items[i].idClient + ")'>Borrar</button></td>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultado").append(myTable);
}



function editInformationClient() {
    let myData = {
        idClient: $("#idClient").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val(),
        password: $("#password").val(),
    };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Client/update",
        type: "PUT",
        data: dataToSend,
        datatype: "JSON",
        contentType: "application/json",
        success: function(respuesta) {
            alert("Actualizacion exitosa");
            traerInformacion();
            $("#idClient").val('');
            $("#name").val('');
            $("#email").val('');
            $("#age").val('');
            $("#password").val('');
        },
        error: function(xhr, status) {
            alert("Operacion no satisfactoria," + xhr.status);
            traerInformacion();
        },
    });
}


function borrarElemento(idElemento) {
    let myData = { idClient: idElemento };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Client/" + idElemento,
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