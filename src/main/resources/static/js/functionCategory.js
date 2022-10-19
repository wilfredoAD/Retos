function saveInformationCategory() {
localhost:8080
    $("#resultado").empty();

    let myData = { name: $("#name").val(), description: $("#description").val() }
    let dataToSend = JSON.stringify(myData);

    $.ajax({

        url: 'http://localhost:8080/api/Category/save',
        type: 'POST',
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function(respuesta) {
            alert("Inserción exitosa");
            traerInformacion();
            $("#name").val('');
            $("#description").val('');
        },
        error: function(xhr, status) {
            alert('Operacion no satisfactoria,' + xhr.status);
            traerInformacion();
        }

    });
}

function traerInformacion() {
    $.ajax({
            url: "http://localhost:8080/api/Category/all",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                pintarRespuestaCategoria(respuesta);
                traerInformacion();

            },
            error: function(xhr, status) {
                alert('Operacion no satisfactoria,' + xhr.status);

            }


        }

    );
}


function pintarRespuestaCategoria(items) {

    $("#resultado").empty();

    let myTable = "<table>";
    myTable += "<caption>Info Categorias</caption><tr><th>Nombre</th><th>Descripcion</th><th>Acciones</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].description + "</td>";
        myTable += "<td><button onclick='borrarElemento(" + items[i].id + ")'>Borrar</button></td>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultado").append(myTable);
}




function editInformationCategory() {
    let myData = {
        id: $("#id").val(),
        name: $("#name").val(),
        description: $("#description").val()
    };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Category/update",
        type: "PUT",
        data: dataToSend,
        datatype: "JSON",
        contentType: "application/json",
        success: function(respuesta) {
            alert("Actualizacion exitosa");
            traerInformacion();
            $("#id").val('');
            $("#name").val('');
            $("#description").val('');
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
        url: "http://localhost:8080/api/Category/" + idElemento,
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