package com.hhhkk.eHotels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/User/Home")
public class UserController {
	@GetMapping
	public String getHome() {
		return "UserHome";
	}
}
