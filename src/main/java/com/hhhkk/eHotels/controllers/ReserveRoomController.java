package com.hhhkk.eHotels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.ReserveRoom;
import com.hhhkk.eHotels.domains.User;
import com.hhhkk.eHotels.services.HotelService;
import com.hhhkk.eHotels.services.ReserveRoomService;
import com.hhhkk.eHotels.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/User/booknow")
public class ReserveRoomController {

	private ReserveRoomService reserveRoomService;
	private UserService userService;
	private HotelService hotelService;
	private Hotel hotel;

	@Autowired
	public ReserveRoomController(ReserveRoomService reserveRoomService, UserService userService,
			HotelService hotelService) {
		this.userService = userService;
		this.reserveRoomService = reserveRoomService;
		this.hotelService = hotelService;

	}

	@GetMapping
	public String getRegisterHotelForm(String hotelId,Model model) {
		log.info(hotelId);

		this.hotel = hotelService.findById((long) (Integer.parseInt(hotelId)));
		log.info(hotel.getHotelName());
		ReserveRoom reserveRoom = new ReserveRoom();
		
		reserveRoom.setReserveHotel(this.hotel);

		model.addAttribute("reserve", reserveRoom);
		return "booknow";
	}



	@PostMapping
	public String processReserveRoom(@Valid ReserveRoom room, Errors errors,
			@AuthenticationPrincipal UserDetails userDetails) {
		log.info(userDetails.getUsername());
		if (errors.hasErrors()) {

			return "booknow";
		}
		User user = userService.findByEmail(userDetails.getUsername());
		room.setReserveuser(user);
		if (hotel != null) {
			room.setReserveHotel(hotel);
		}
		log.info(userDetails.getUsername());
		reserveRoomService.saveReserveRoom(room);

		return "redirect:/User/Home";
	}
}
