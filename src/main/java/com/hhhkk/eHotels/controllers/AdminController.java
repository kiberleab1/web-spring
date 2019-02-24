package com.hhhkk.eHotels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminController {
	
	@RequestMapping("/Admin/Home")
	@GetMapping("/Admin/Home")
	public String getHome(){
		log.info("getHome");
		return "AdminHome";
	}

}
