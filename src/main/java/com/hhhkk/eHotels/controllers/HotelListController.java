package com.hhhkk.eHotels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.services.HotelService;

@Controller
@RequestMapping("/User/ViewHotels")
public class HotelListController {

    private HotelService hotelService;

    @Autowired
    public HotelListController(HotelService hotelRepository){

        this.hotelService=hotelRepository;

    }

    @ModelAttribute
    public void listHotel(Model model){
        Iterable<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels",hotels);
        
    }

    @GetMapping
    public String ListHotels(){

        return "Hotels";
    }

    @PostMapping
    public String bookHotel(Hotel hotel){

       // Hotel booked = hotelService.save(hotel);
        return "HotelList";
    }
}
