

function guardarInformacion() {

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




function editarInformacion() {
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

function guardarInformacion() {
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



function editarInformacion() {
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

function guardarInformacion() {
    $("#resultado").empty();

    let myData = {
        messageText: $("#messageText").val(),
        partyroom: { id: $("#partyroomId").val() },
        client: { idClient: $("#clientId").val() },
    };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Message/save",
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
        url: "http://localhost:8080/api/Message/all",
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
        url: "http://localhost:8080/api/Message/update",
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
        url: "http://localhost:8080/api/Message/" + idElemento,
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

function guardarInformacion() {

    $("#resultado").empty();

    let myData = { startDate: $("#startDate").val(), devolutionDate: $("#devolutionDate").val(), status: $("#status").val(), partyroom: { id: $("#partyroomId").val() }, client: { idClient: $("#clientId").val() }, score: $("#score").val() }
    let dataToSend = JSON.stringify(myData);

    $.ajax({

        url: 'http://localhost:8080/api/Reservation/save',
        type: 'POST',
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function(respuesta) {
            alert("Inserción exitosa");
            traerInformacion();
            $("#startDate").val('');
            $("#devolutionDate").val('');
            $("#status").val('');
            $("#partyroomId").val('');
            $("#clientId").val('');
            $("#score").val('');
        },
        error: function(xhr, status) {
            alert('Operacion no satisfactoria,' + xhr.status);
            traerInformacion();
        }

    });
}

function traerInformacion() {
    $.ajax({
            url: "http://localhost:8080/api/Reservation/all",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                pintarRespuestaResevacion(respuesta);
                traerInformacion();

            },
            error: function(xhr, status) {
                alert('Operacion no satisfactoria,' + xhr.status);

            }


        }

    );
}


function pintarRespuestaResevacion(items) {

    $("#resultado").empty();

    let myTable = "<table>";
    myTable += "<caption>Info Reservas</caption><tr><th>Id Reservacion</th><th>Fecha de inicio</th><th>Fecha de Devolucion</th><th>Estado Reserva</th><th>Salon</th><th>Id Cliente</th><th>Cliente</th><th>Correo Cliente</th><th>Calificacion</th><th>Acciones</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].idReservation + "</td>";
        myTable += "<td>" + items[i].startDate + "</td>";
        myTable += "<td>" + items[i].devolutionDate + "</td>";
        myTable += "<td>" + items[i].status + "</td>";
        myTable += "<td>" + items[i].partyroom.name + "</td>";
        myTable += "<td>" + items[i].client.idClient + "</td>"
        myTable += "<td>" + items[i].client.name + "</td>"
        myTable += "<td>" + items[i].client.email + "</td>"
        myTable += "<td>" + items[i].score + "</td>";;
        myTable += "<td><button onclick='borrarElemento(" + items[i].idReservation + ")'>Borrar</button></td>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultado").append(myTable);
}



function editarInformacion() {
    let myData = {
        idReservation: $("#idReservation").val(),
        startDate: $("#startDate").val(),
        devolutionDate: $("#devolutionDate").val(),
        status: $("#status").val(),
        partyroom: { id: $("#partyroomId").val() },
        client: { idClient: $("#clientId").val() },
        score: $("#score").val(),
    };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Reservation/update",
        type: "PUT",
        data: dataToSend,
        datatype: "JSON",
        contentType: "application/json",
        success: function(respuesta) {
            alert("Actualizacion exitosa");
            traerInformacion();
            $("#idReservation").val('');
            $("#startDate").val('');
            $("#devolutionDate").val('');
            $("#status").val('');
            $("#partyroomId").val('');
            $("#clientId").val('');
            $("#score").val('');
        },
        error: function(xhr, status) {
            alert("Operacion no satisfactoria," + xhr.status);
            traerInformacion();
        },
    });
}

function borrarElemento(idElemento) {
    let myData = { idReservation: idElemento };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: "http://localhost:8080/api/Reservation/" + idElemento,
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

function consultarTopClientes() {
    $.ajax({
            url: "http://localhost:8080/api/Reservation/report-clients",
            type: "GET",
            datatype: "JSON",
            success: function(respuestas) {
                pintarRespuestaTopclients(respuestas);

            },
            error: function(xhr, status) {
                alert('Operacion no satisfactoria,' + xhr.status);
            }


        }

    );
}

function pintarRespuestaTopclients(items) {

    $("#resultados").empty();

    let myTables = "<table>";
    myTables += "<caption>Top Clientes</caption><tr><th>Cliente</th><th>Total</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTables += "<tr>";
        myTables += "<td>" + items[i].client.name + "</td>";
        myTables += "<td>" + items[i].total + "</td>";
        myTables += "</tr>";
    }
    myTables += "</table>";
    $("#resultados").append(myTables);
}


function traerReporteStatus() {
    console.log("test");
    $.ajax({
        url: "http://localhost:8080/api/Reservation/report-status",
        type: "GET",
        datatype: "JSON",
        success: function(respuesta) {
            console.log(respuesta);
            pintarRespuestastatus(respuesta);
        }
    });
}

function pintarRespuestastatus(respuesta) {
    $("#count-completed").empty();
    $("#count-cancelled").empty();
    $("#count-completed").append("Reservas Completadas " + respuesta.completed);
    $("#count-cancelled").append("Reservas Canceladas   " + respuesta.cancelled);


}

function traerReporteDate() {

    var dateOne = document.getElementById("RstarDate").value;
    var dateTwo = document.getElementById("RdevolutionDate").value;
    console.log(dateOne);
    console.log(dateTwo);

    $.ajax({
        url: "http://localhost:8080/api/Reservation/report-dates/" + dateOne + "/" + dateTwo,
        type: "GET",
        datatype: "JSON",
        success: function(respuesta) {
            console.log(respuesta);
            pintarRespuestaDate(respuesta);
        }
    });
}

function pintarRespuestaDate(respuesta) {

    let myTable = "<table>";
    myTable += "<caption>Info Reservas</caption>";
    myTable += "<tr>";
    myTable += "<th>Fecha de devolucion</th>";
    myTable += "<th>Fecha de Inicio</th>";
    myTable += "<th>Estado</th>";
    myTable += "</tr>";
    for (i = 0; i < respuesta.length; i++) {

        myTable += "<tr>";
        myTable += "<td>" + respuesta[i].devolutionDate + "</td>";
        myTable += "<td>" + respuesta[i].startDate + "</td>";
        myTable += "<td>" + respuesta[i].status + "</td>";
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultadoDate").html(myTable);
}

function guardarInformacion() {

    $("#resultado").empty();

    let myData = { name: $("#name").val(), owner: $("#owner").val(), capacity: $("#capacity").val(), description: $("#description").val(), category: { id: $("#categoryId").val() } }
    let dataToSend = JSON.stringify(myData);

    $.ajax({

        url: 'http://localhost:8080/api/Partyroom/save',
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
            url: "http://localhost:8080/api/Partyroom/all",
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



function editarInformacion() {
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
        url: "http://localhost:8080/api/Partyroom/update",
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
        url: "http://localhost:8080/api/Partyroom/" + idElemento,
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