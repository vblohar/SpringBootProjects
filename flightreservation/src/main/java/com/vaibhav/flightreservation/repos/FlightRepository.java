package com.vaibhav.flightreservation.repos;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vaibhav.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

//	@Query("select from Flight where departureCity=:departureCity and "+ "arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
//	List<Flight> findFlights(@Param("departureCity") String from,@Param ("arrivalCity")
//		String to,@Param ("dateOfDeparture") Date departureDate);
	
//	@Query("SELECT f FROM Flight f WHERE f.departureCity = :departureCity AND f.arrivalCity = :arrivalCity AND f.dateOfDeparture = :dateOfDeparture")
	@Query(value = "SELECT * FROM Flight WHERE departure_city = :departure_city AND arrival_city = :arrival_city AND DATE(date_of_departure) = :date_of_departure", nativeQuery = true)
	List<Flight> findFlights(@Param("departure_city") String from, @Param("arrival_city") String to, @Param("date_of_departure") Date departureDate);

}
