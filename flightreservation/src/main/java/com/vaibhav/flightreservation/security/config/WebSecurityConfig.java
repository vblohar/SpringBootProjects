package com.vaibhav.flightreservation.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).build();
	}

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
//				.requestMatchers("/", "/showReg", "/index.html", "/login/registerUser", "/showLogin").permitAll() // Public
//																													// pages
//				.anyRequest().authenticated() // All other requests require authentication
//		).formLogin(form -> form.loginPage("/showLogin") // Custom login page URL
//				.permitAll() // Ensure the login page is accessible to everyone
//		).logout(logout -> logout.permitAll() // Ensure logout is available to everyone
//		).build();
//	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http
	    		 .csrf(AbstractHttpConfigurer::disable)
	        // Configure URL access rules
	        .authorizeHttpRequests(authz -> authz
	            .requestMatchers("/login", "/register", "/showLogin", "/showReg", "/WEB-INF/**", "/registerUser" ).permitAll() // Allow unauthenticated access to login and register pages
	              // Require authentication for all other requests
	        )
	        // Enable form-based login
	        .formLogin(
					form -> form // Custom login page URL (or default /login)
	        		.loginPage("/showLogin")
	            .permitAll() // Allow unauthenticated access to the login page
	        )
	        // Enable logout functionality
	        .logout(LogoutConfigurer::permitAll  // Allow unauthenticated access to logout
	        )
	        .build();  // Return the configured SecurityFilterChain
	}


//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
//				.requestMatchers("/", "/showReg", "/index.html", "/login/registerUser", "/showLogin").permitAll() // Public
//																													// pages
//
//		).build();
//	}
}
