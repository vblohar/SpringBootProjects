package com.vaibhav.location.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.location.entities.Location;
import com.vaibhav.location.repos.LocationRepository;
import com.vaibhav.location.service.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationRestController {
	
	@Autowired
	LocationRepository repository;
	
	@Autowired
	LocationService service;
	
	@GetMapping
	public List<Location> getLocations() {
		return repository.findAll();  
	}
	
	@PostMapping
	public Location createLocation(@RequestBody Location location) {
		return repository.save(location);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return repository.save(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable ("id") int id) {
//		Location location = service.getLocationById(id);
		
		repository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Location getLocationById (@PathVariable ("id") int id) {
		 Optional<Location> location = repository.findById(id);
		 Location loc = location.get();
		 return loc;
	}
}









