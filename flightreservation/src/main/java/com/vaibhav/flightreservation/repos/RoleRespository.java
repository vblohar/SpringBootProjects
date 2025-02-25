package com.vaibhav.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.flightreservation.entities.Role;

public interface RoleRespository extends JpaRepository<Role, Long> {

}
