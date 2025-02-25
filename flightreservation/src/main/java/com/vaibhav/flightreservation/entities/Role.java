package com.vaibhav.flightreservation.entities;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Role extends AbstractEntity implements GrantedAuthority {
	
	private String name;
	@ManyToMany(mappedBy="roles")
	private Set<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String getAuthority() {
		
		return name;
	}
}
