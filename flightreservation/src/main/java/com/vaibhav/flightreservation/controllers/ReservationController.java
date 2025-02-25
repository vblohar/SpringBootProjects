package com.vaibhav.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vaibhav.flightreservation.dto.ReservationRequest;
import com.vaibhav.flightreservation.entities.Flight;
import com.vaibhav.flightreservation.entities.Reservation;
import com.vaibhav.flightreservation.repos.FlightRepository;
import com.vaibhav.flightreservation.services.ReservationService;


@Controller
public class ReservationController {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired 
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam ("flightId") Long flightId, ModelMap modelMap) {
		Optional<Flight>  flt = flightRepository.findById(flightId);
		Flight flight = flt.get();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@RequestMapping(value= "/completeReservation", method = RequestMethod.POST)
	public String completeReservation( ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and the id is"+reservation.getId());
		return "reservationConfirmation";
	}
}
