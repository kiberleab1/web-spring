package com.hhhkk.eHotels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/about")
public class AboutController {
	@GetMapping
	public String getAbout() {
		log.info("ads");
		return "about";
	}
}
