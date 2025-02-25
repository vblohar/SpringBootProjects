package com.vaibhav.flightreservation.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.flightreservation.dto.ReservationRequest;
import com.vaibhav.flightreservation.entities.Flight;
import com.vaibhav.flightreservation.entities.Passenger;
import com.vaibhav.flightreservation.entities.Reservation;
import com.vaibhav.flightreservation.repos.FlightRepository;
import com.vaibhav.flightreservation.repos.PassengerRepository;
import com.vaibhav.flightreservation.repos.ReservationRepository;
import com.vaibhav.flightreservation.util.EmailUtil;
import com.vaibhav.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtil util;
	
		@Override
	public Reservation bookFlight(ReservationRequest request) {
		// make payment
		
		Long flightId = request.getFlightId();
		Optional<Flight> flt =  flightRepository.findById(flightId);
		Flight flight = flt.get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		Passenger svaedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation =new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(svaedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = "C:\\Users\\Vaibhav\\Documents\\reservations"+savedReservation.getId()+".pdf";
		
		pdfGenerator.generateItinerary(savedReservation, filePath);
		
		util.sendItinerary(passenger.getEmail(), filePath); 
		
		
		return savedReservation;
	}

}
