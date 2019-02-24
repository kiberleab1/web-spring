package com.hhhkk.eHotels.controllers;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.User;
import com.hhhkk.eHotels.services.HotelService;
import com.hhhkk.eHotels.services.UserService;
import com.hhhkk.eHotels.services.UserServiceImplementation;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/default")
public class DefaultController {
	
	private HotelService hotelService;
	private UserService userService;
	private User user;
	private Hotel hotel;
	
	@Autowired
	public DefaultController( HotelService hotelService, UserService userService) {
		this.hotelService=hotelService;
		this.userService=userService;
	} 
	
	@GetMapping
	public String getDfault(@AuthenticationPrincipal UserDetails userDetails) {
		
		if(userDetails.getAuthorities().toString().equals("[MANAGER]")) {
		
		//	user=(User)userDetails;
			user=this.userService.findByEmail(userDetails.getUsername());
			//Hibernate.initialize(user.getHotel());
			hotel=user.getHotel();
		//	log.info("username:"+user.getHotel().toString());
			if(hotel.getIsConfirmed()==1) {
				
				return "redirect:/Hotel/profile";
			}else {
				
				return "redirect:/Manager/blog";
			}
			
			
			
		}else if(userDetails.getAuthorities().toString().equals("[ADMIN]")){
			return "redirect:/Admin/Home";
		}else if(userDetails.getAuthorities().toString().equals("[USER]")){
			return "redirect:/User/Home";
		}else {
			return "/";
		}
	}
}
