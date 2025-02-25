package com.vaibhav.flightreservation.services;

import com.vaibhav.flightreservation.dto.ReservationRequest;
import com.vaibhav.flightreservation.entities.Reservation;

public interface ReservationService {
	
	Reservation bookFlight(ReservationRequest request);

}
