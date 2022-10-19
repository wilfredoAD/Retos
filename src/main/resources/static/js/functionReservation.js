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







function consultClient() {
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