function saveInformationPartyroom() {

    $("#resultado").empty();

    let myData = { name: $("#name").val(), owner: $("#owner").val(), capacity: $("#capacity").val(), description: $("#description").val(), category: { id: $("#categoryId").val() } }
    let dataToSend = JSON.stringify(myData);

    $.ajax({

        url: 'http://132.145.219.71:8080/api/Partyroom/save',
        type: 'POST',
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function(respuesta) {
            alert("Inserción exitosa");
            traerInformacion();
            $("#name").val('');
            $("#owner").val('');
            $("#capacity").val('');
            $("#description").val('');
            $("#categoryId").val('');
        },
        error: function(xhr, status) {
            alert('Operacion no satisfactoria,' + xhr.status);
            traerInformacion();
        }

    });
}

function traerInformacion() {
    $.ajax({
            url: "http://132.145.219.71:8080/api/Partyroom/all",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                pintarRespuestaSalones(respuesta);
                traerInformacion();

            },
            error: function(xhr, status) {
                alert('Operacion no satisfactoria,' + xhr.status);

            }


        }

    );
}


function pintarRespuestaSalones(items) {

    $("#resultado").empty();

    let myTable = "<table>";
    myTable += "<caption>Info Partyroom</caption><tr><th>Nombre</th><th>Dueño</th><th>Capacidad</th><th>Description</th><th>Categoria</th><th>Acciones</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].owner + "</td>";
        myTable += "<td>" + items[i].capacity + "</td>";
        myTable += "<td>" + items[i].description + "</td>";
        myTable += "<td>" + items[i].category.name + "</td>";
        myTable += "<td><button onclick='borrarElemento(" + items[i].id + ")'>Borrar</button></td>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultado").append(myTable);
}



function editInformationPartyroom() {
    let myData = {
        id: $("#id").val(),
        name: $("#name").val(),
        owner: $("#owner").val(),
        capacity: $("#capacity").val(),
        description: $("#description").val(),
        category: { id: $("#categoryId").val() }
    };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://132.145.219.71:8080/api/Partyroom/update",
        type: "PUT",
        data: dataToSend,
        datatype: "JSON",
        contentType: "application/json",
        success: function(respuesta) {
            alert("Actualizacion exitosa");
            traerInformacion();
            $("#id").val('');
            $("#name").val('');
            $("#owner").val('');
            $("#capacity").val('');
            $("#description").val('');
            $("#categoryId").val('');
        },
        error: function(xhr, status) {
            alert("Operacion no satisfactoria," + xhr.status);
            traerInformacion();
        },
    });
}

function borrarElemento(idElemento) {
    let myData = { id: idElemento };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://132.145.219.71:8080/api/Partyroom/" + idElemento,
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