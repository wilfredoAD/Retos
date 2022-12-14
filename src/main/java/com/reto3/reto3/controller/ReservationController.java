package com.reto3.reto3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto3.reto3.Reports.CompleteAndCancelled;
import com.reto3.reto3.Reports.CustomerCounter;
import com.reto3.reto3.model.Reservation;
import com.reto3.reto3.service.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })

public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservationFull() {
        return reservationService.getReservationFull();

    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationId(@PathVariable("id") int idReservation) {
        return reservationService.getReservationId(idReservation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateFull(@RequestBody Reservation reservation) {
        return reservationService.updateFull(reservation);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteservices(@PathVariable("id") int id) {
        return reservationService.deleteservices(id);
    }

    @GetMapping("/report-dates/{date1}/{date2}")
    public List<Reservation> getReservationsBetweenDatesReport
    (@PathVariable("date1") String date1, @PathVariable("date2") String date2) {           
        return reservationService.getReservationsBetweenDatesReport(date1, date2);
    }

    @GetMapping("/report-status")
    public CompleteAndCancelled getReservationsStatusReport() {
        return reservationService.getReservationStatusReport();
    }

    @GetMapping("/report-clients")
    public List<CustomerCounter> getTopClientsReport() {
        return reservationService.getTopClientsReport();
    }

}
