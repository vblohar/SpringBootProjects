package com.vaibhav.flightcheckin.integration;

import com.vaibhav.flightcheckin.integration.dto.Reservation;
import com.vaibhav.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}
