package com.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.reto3.model.Reservation;
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

}
