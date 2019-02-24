package com.hhhkk.eHotels.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.ReserveRoom;
import com.hhhkk.eHotels.domains.User;
import com.hhhkk.eHotels.services.ReserveRoomService;
@Controller
@RequestMapping("Hotel/Requests")
public class BookedController {
	private ReserveRoomService reserveRoomService;
	@Autowired
	public BookedController(ReserveRoomService reserveRoomService) {
		this.reserveRoomService=reserveRoomService;
	}
	@ModelAttribute(name="requests")
	public List<ReserveRoom> hotelRequests(Model model,@AuthenticationPrincipal UserDetails userDetails){
		User user=(User)userDetails;
		Hotel hotel=user.getHotel();
		List<ReserveRoom> rooms=this.reserveRoomService.findAllByHotel(hotel);
		
		return rooms;
	}
	
	@GetMapping
	public String getRequests(Model model) {
		model.addAttribute("requests");
		return "bookRequests";
		
	}
	@PostMapping
	public String processRegisterHotel(String status,String reserveId){

		
		
		// User registedManager=userRepository.save(manager);
		Optional<ReserveRoom> roomFromDb=this.reserveRoomService.findById((long)Integer.parseInt(reserveId));
		if(roomFromDb.isPresent()) {}
		//	Hotel hotelFromDb=hotelOptional.get();
			roomFromDb.get().setStatues(Integer.parseInt(status));
			this.reserveRoomService.saveReserveRoom(roomFromDb.get());;
		//}
		
		
		
		
		return "redirect:/Hotel/Requests";

		
	

	}
}
