package com.vaibhav.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vaibhav.flightreservation.entities.User;
import com.vaibhav.flightreservation.repos.UserRepository;
import com.vaibhav.flightreservation.services.SecurityService;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return"login/registerUser";
	}
	@RequestMapping("/showLogin")
	public String login() {
//		return "login/login";
		return "forward:/WEB-INF/jsps/login/login.jsp";
	}
	
	@RequestMapping(value="/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute ("user") User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping(value="/login1234", method=RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam ("password") String password, ModelMap modelMap) {
//		User user = userRepository.findByEmail(email);
		boolean loginResponse = securityService.login(email, password);
		if(loginResponse) {
		return "findFlights";
		}else {
			modelMap.addAttribute("msg", "Invalid user name or password. Please try again.");
			
		}
		return "login/login";
	}
	
	
	
}
