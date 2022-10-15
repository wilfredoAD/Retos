package com.reto3.reto3.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.reto3.model.Reservation;
import com.reto3.reto3.model.Data.CompleteAndCancelled;
import com.reto3.reto3.model.Data.TotalAllCient;
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

        } else {
            Optional<Reservation> reservationAux = reservationRepository
                    .getReservationId(reservation.getIdReservation());
            if (reservationAux.isEmpty()) {
                return reservationRepository.saveReservation(reservation);

            } else {
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
        Boolean result = getReservationId(reservationId).map(element -> {
            reservationRepository.delete(element);
            return true;
        }).orElse(false);
        return result;
    }

    public List<Reservation> getReservationsBetweenDatesReport(String date1, String date2) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();

        try {
            a = parser.parse(date1);
            b = parser.parse(date2);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        if (a.before(b)) {
            return reservationRepository.getReservationsBetweenDatesReport(a, b);
        } else {
            return new ArrayList<>();
        }
    }

    public CompleteAndCancelled getReservationStatusReport() {
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");

        int cantidadCompletadas = completed.size();
        int cantidadCanceladas = cancelled.size();

        return new CompleteAndCancelled((long) cantidadCompletadas, (long) cantidadCanceladas);
    }

    public List<TotalAllCient> getTopClientsReport() {
        return reservationRepository.getTopClients();
    }

}
