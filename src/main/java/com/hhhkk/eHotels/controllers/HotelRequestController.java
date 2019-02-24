package com.hhhkk.eHotels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.services.HotelService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/Admin/Request")
public class HotelRequestController {
	private HotelService hotelService;

	@Autowired
	public HotelRequestController(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@ModelAttribute(name = "requests")
	public List<Hotel> hotelRequests(Model model) {
		List<Hotel> hotels = this.hotelService.findByIsConfirmed((short) 0);
		for (Hotel hotel : hotels) {
			log.info(hotel.getHotelName());
		}
		return hotels;
	}

	@GetMapping
	public String getRequests(Model model) {
		model.addAttribute("requests");
		return "request";

	}

	@PostMapping
	public String processRegisterHotel(@Valid Hotel hotel) {
		//Hotel Delete
		if (hotel.getIsConfirmed()== -2) {
			try{
				hotelService.deletById(hotel.getHotelId());
				}catch(Exception e){};
			log.info("asds");
		} else {
			// User registedManager=userRepository.save(manager);
			Hotel hotelFromDb = hotelService.findById(hotel.getHotelId());
			// if(hotelOptional.isPresent()) {
			// Hotel hotelFromDb=hotelOptional.get();
			hotelFromDb.setIsConfirmed(hotel.getIsConfirmed());

			this.hotelService.saveHotel(hotelFromDb);
			// }
		}
		log.info("Order Submited:" + hotel.getIsConfirmed());

		return "redirect:/Admin/Request";

	}
	/*
	 * @PatchMapping public String confirmRegisterHotel(@Valid Hotel hotel) {
	 * 
	 * // User registedManager=userRepository.save(manager); Hotel hotelFromDb =
	 * hotelService.findById(hotel.getHotelId()); // if(hotelOptional.isPresent()) {
	 * // Hotel hotelFromDb=hotelOptional.get(); //
	 * hotelFromDb.setIsConfirmed(hotel.getIsConfirmed());
	 * 
	 * this.hotelService.saveHotel(hotelFromDb); // }
	 * 
	 * log.info("Order Submited:" + hotelFromDb.getIsConfirmed());
	 * 
	 * return "redirect:/Admin/Request";
	 * 
	 * }
	 * 
	 * @DeleteMapping(params = "hotelId") public String
	 * RegisterHotel(@RequestParam("hotelId") long hotelId) {
	 * 
	 * // User registedManager=userRepository.save(manager); Hotel hotelFromDb =
	 * hotelService.findById(hotelId); // if(hotelOptional.isPresent()) { // Hotel
	 * hotelFromDb=hotelOptional.get(); //
	 * hotelFromDb.setIsConfirmed(hotel.getIsConfirmed());
	 * 
	 * this.hotelService.saveHotel(hotelFromDb); // }
	 * 
	 * log.info("Order Submited:" + hotelFromDb.getIsConfirmed());
	 * 
	 * return "redirect:/Admin/Request";
	 * 
	 * }
	 */
}
