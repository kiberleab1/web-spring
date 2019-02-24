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

import com.hhhkk.eHotels.domains.User;
import com.hhhkk.eHotels.repositories.UserRepository;
import com.hhhkk.eHotels.services.UserService;
import com.hhhkk.eHotels.services.UserServiceImplementation;


@Controller
@RequestMapping("/Admin/register")
public class RegisterAdminController {
	

	private UserService userService;
	
	
	@Autowired
	public RegisterAdminController(UserService userService) {
		
		this.userService=userService;
	}
	/*@Autowired
	public RegistrationController(HotelRepository hotelRepository, ManagerRepository managerRepository) {
		this.hotelRepository=hotelRepository;
		this.managerRepository=managerRepository;
	}*/
	
	@GetMapping
	public String getRegisterHotelForm() {
		return "registerAdmin";
	}
	
	
	@ModelAttribute(name="registerAdmin")
	public User registerManager(Model model) {
		return new User();
	}
	
	
	@PostMapping
	public String processRegisterHotel( @Valid 	@ModelAttribute("registerAdmin")
User Admin, Errors errors){

		if(errors.hasErrors()) {
			
			return "registerAdmin";
		}
		
		
		userService.saveAdminManager(Admin);
		// User registedManager=userRepository.save(manager);
		
		
		
		
		return "index";

		
	

	}
		
}
	
