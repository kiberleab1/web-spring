package com.hhhkk.eHotels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.ImageModel;
import com.hhhkk.eHotels.domains.User;
import com.hhhkk.eHotels.repositories.ImageRepository;
import com.hhhkk.eHotels.services.HotelService;
import com.hhhkk.eHotels.services.ImageModelService;
import com.hhhkk.eHotels.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/Hotel/profile")
public class HotelController {

	private HotelService hotelService;
	private ImageModelService imageService;
	private UserService userService;

	@Autowired
	public HotelController(HotelService hotelService, ImageModelService imageService, UserService userService) {
		this.hotelService = hotelService;
		this.imageService = imageService;
		this.userService = userService;
	}

	@ModelAttribute(name = "profile")
	public Hotel profileHotel(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		User user = (User) this.userService.findByEmail(userDetails.getUsername());

		Hotel hotel = hotelService.findByUser(user);// yet to be made specfic for every Manager

		log.info(hotel.getHotelName());
		return hotel;
	}

	@GetMapping
	public String getHotelProfile(@AuthenticationPrincipal UserDetails userDetails,Model model) {
		User user = (User) this.userService.findByEmail(userDetails.getUsername());

		Hotel hotel = hotelService.findByUser(user);
		List<ImageModel> images = this.imageService.findByHotel(hotel);
		model.addAttribute("images",images);
		return "hotelProfile";
	}

	

}
