package com.hhhkk.eHotels.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.User;
import com.hhhkk.eHotels.services.HotelService;
import com.hhhkk.eHotels.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/registration")

public class RegistrationHotelController {
	
	private HotelService hotelService;

	
	private UserService userService;
	
	
	@Autowired
	public RegistrationHotelController(HotelService hotelService, UserService userService) {
		this.hotelService=hotelService;
		
		this.userService=userService;
	}
	/*@Autowired
	public RegistrationController(HotelRepository hotelRepository, ManagerRepository managerRepository) {
		this.hotelRepository=hotelRepository;
		this.managerRepository=managerRepository;
	}*/
	
	@GetMapping
	public String getRegisterHotelForm() {
		return "registerHotel";
	}
	
	@ModelAttribute(name="register")
	public Hotel registerHotel(Model model) {
		return new Hotel();
	}
	@ModelAttribute(name="registerManager")
	public User registerManager(Model model) {
		return new User();
	}
	
	
	@PostMapping
	public String processRegisterHotel(@Valid @ModelAttribute("register") Hotel hotel, @Valid User manager, Errors errors){

		if(errors.hasErrors()) {
			
			return "registration";
		}
		Hotel registerHotel=hotelService.saveHotel(hotel);
		manager.setHotel(registerHotel);
		userService.saveHotelManager(manager);
		// User registedManager=userRepository.save(manager);
		
		log.info("Order Submited:"+registerHotel);
		
		
		return "redirect:/";

		
	

	}
	
}
