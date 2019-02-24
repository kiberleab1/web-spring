package com.hhhkk.eHotels.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.ReserveRoom;
import com.hhhkk.eHotels.services.ReserveRoomService;
import com.hhhkk.eHotels.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/User/myreservation")

public class MyReservationController {
	private ReserveRoomService reserveRoomService;
	private UserService userService;
	
	@Autowired
	public MyReservationController(ReserveRoomService reserveRoomService,UserService userService) {
		this.reserveRoomService=reserveRoomService;
		this.userService=userService;
	}
	@GetMapping
	public String getReservation(@AuthenticationPrincipal UserDetails userDetails) {
		return "myreservation";
		
	}
	@ModelAttribute(name="requests")
	public List<ReserveRoom> hotelRequests(Model model,@AuthenticationPrincipal UserDetails userDetails){
		List<ReserveRoom> rooms=this.reserveRoomService.findAllByUser(this.userService.findByEmail(userDetails.getUsername()));
		for(ReserveRoom room:rooms ) {
			log.info(room.getGuests());
		}
		return rooms;
	}
	
	@PostMapping
	public String getRequests(String reserveId) {
			
		this.reserveRoomService.deleteByReservation((long)(Integer.parseInt(reserveId)));
		return "redirect:/User/myreservation";
		
	}
	@GetMapping(path="edit")
	public String editReservation(String reserveId,Model model) {
		Optional<ReserveRoom> reserveRoom=this.reserveRoomService.findById((long)Integer.parseInt(reserveId));
		model.addAttribute("reserve", reserveRoom.get());
		return "booknow";
	}

}
