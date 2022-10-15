package com.reto3.reto3.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.reto3.model.Client;
import com.reto3.reto3.model.Reservation;
import com.reto3.reto3.model.Data.TotalAllCient;
import com.reto3.reto3.repository.crud.ReservationCrudRepositoryInterface;



@Repository
public class ReservationRepository {

    @Autowired
    public ReservationCrudRepositoryInterface reservationCrudRepositoryInterface;
    

    public List<Reservation> getReservationFull(){
        return (List<Reservation>) reservationCrudRepositoryInterface.findAll();
    } 

    public Optional<Reservation> getReservationId(int idReservation){
        return reservationCrudRepositoryInterface.findById(idReservation);
    }

    public Reservation saveReservation(Reservation reservation){
    return reservationCrudRepositoryInterface.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepositoryInterface.delete(reservation);
    }

    public List<Reservation> getReservationsBetweenDatesReport(Date date1, Date date2) {
        return reservationCrudRepositoryInterface.findAllByStartDateAfterAndDevolutionDateBefore(date1, date2);
    }

    public List<Reservation> getReservationByStatus(String status) {
        return reservationCrudRepositoryInterface.findAllByStatus(status);
    }

    public List<TotalAllCient> getTopClients() {
        List<TotalAllCient> respuesta =new ArrayList<>();
        List<Object[]> reporte= reservationCrudRepositoryInterface.getTotalReservationByClient();
        for (int i=0; i<reporte.size(); i++){
            respuesta.add(new TotalAllCient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return respuesta;
    }
}


