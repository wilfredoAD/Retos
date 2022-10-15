package com.reto3.reto3.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reto3.reto3.model.Reservation;

public interface ReservationCrudRepositoryInterface  extends CrudRepository<Reservation,Integer>{

    List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date date1, Date date2);

    List<Reservation> findAllByStatus(String status);

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    List<Object[]> getTotalReservationByClient();
    
}
