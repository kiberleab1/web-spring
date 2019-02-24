package com.hhhkk.eHotels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.User;
import com.hhhkk.eHotels.services.HotelService;
import com.hhhkk.eHotels.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("Hotel/editprofile")
public class EditHotelProfileController {
		
		private HotelService hotelService;
		private UserService userService;
		@Autowired
		public  EditHotelProfileController(HotelService hotelService,UserService userService) {
		
			this.hotelService=hotelService;
			this.userService=userService;
		}
		
		@ModelAttribute(name="editprofile")
		public Hotel EditprofileHotel(@AuthenticationPrincipal UserDetails userDetails,Model model) {
			User user=userService.findByEmail(userDetails.getUsername());
			log.info(user.getId()+"");
			Hotel hotel=hotelService.findByUser(user);//yet to be made specfic for every Manager
			log.info(hotel.getHotelId()+"");
			log.info(hotel.getHotelName());
			return hotel;
		}
		
		@GetMapping
		public String getEditHotelProfile() {
			return "hotel/edithotel";
		}
		@PostMapping
		public String updateuser(@Valid Hotel hotel) {
			ModelAndView modelandview=new ModelAndView();
			hotelService.updatehotelprofile(hotel);
			modelandview.setViewName("Hotel/editprofile");
			return "redirect:/Hotel/profile";
		}
	}

