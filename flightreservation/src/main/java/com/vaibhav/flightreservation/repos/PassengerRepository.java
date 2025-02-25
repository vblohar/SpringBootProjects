package com.vaibhav.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
