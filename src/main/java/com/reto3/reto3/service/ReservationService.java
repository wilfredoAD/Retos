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

    public Reservation updateFull(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reservationEncontrado = getReservationId(reservation.getIdReservation());
            if (!reservationEncontrado.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    reservationEncontrado.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    reservationEncontrado.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.saveReservation(reservationEncontrado.get());
            }
        }
        return reservation;
    }


    public boolean deleteservices(int reservationId) {
        Boolean result =getReservationId(reservationId).map(element ->{
            reservationRepository.delete(element);
            return true;
        } ).orElse(false);
        return result;
    }



}
