package com.hhhkk.eHotels.controllers;

import javax.servlet.Registration;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hhhkk.eHotels.domains.User;
import com.hhhkk.eHotels.services.UserService;
import com.hhhkk.eHotels.services.UserServiceImplementation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/register/user")

public class RegistrationController {
	
	

	private UserService userService;
	@Autowired
	public RegistrationController(UserService userService) {
		this.userService=userService;
		
	}


	
	@ModelAttribute(name="register")
	public User registerUser(Model model) {
		return new User();
	}
	@GetMapping
	public String getRegisterHotelForm() {
		return "registerUser";
	}
	/*@ModelAttribute(name="registerManager")
	public User registerManager(Model model) {
		return new User();
	}
	*/
	@PostMapping
	public String processRegisterHotel(Model model, @Valid @ModelAttribute("register") User user,Errors errors){
		if(errors.hasErrors()) {
			return "registerUser";
		}
		userService.saveUser(user);
		//User registerManager=userRepository.save(manager);
		//log.info("Order Submited:"+registerUser);
		//log.info("Manager Submited:"+registerManager);
		log.info("asdasd");
		return "index";
	}



	public static String create(Registration bulkRegistration, BindingResult result, ModelMap model) {
		// TODO Auto-generated method stub
		return null;
	}
	
}