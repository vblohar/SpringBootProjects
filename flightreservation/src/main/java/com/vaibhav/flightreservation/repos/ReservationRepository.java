package com.vaibhav.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
