package com.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.reto3.model.Reservation;
import com.reto3.reto3.repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository; 

    public List<Reservation> getReservationFull() {
        return reservationRepository.getReservationFull();

    }

    public Optional<Reservation> getReservationId(int idReservation) {
        return reservationRepository.getReservationId(idReservation);
    }

    public Reservation saveReservation(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.saveReservation(reservation);
            
        }else{
            Optional<Reservation> reservationAux = reservationRepository.getReservationId(reservation.getIdReservation());
            if (reservationAux.isEmpty()) {
                return reservationRepository.saveReservation(reservation);
                
            }else{
                return reservation;
            }
        }
    }



}
