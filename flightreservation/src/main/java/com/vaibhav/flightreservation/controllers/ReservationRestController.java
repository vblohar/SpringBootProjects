package com.vaibhav.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.flightreservation.dto.ReservationUpdateRequest;
import com.vaibhav.flightreservation.entities.Reservation;
import com.vaibhav.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation getReservation(@PathVariable ("id") Long id) {
		Optional <Reservation> res = reservationRepository.findById(id);
		Reservation reservation = res.get();
		return reservation;
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Optional<Reservation> res = reservationRepository.findById(request.getId());
		Reservation reservation = res.get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		reservationRepository.save(reservation);
		return reservation;
	}
}
