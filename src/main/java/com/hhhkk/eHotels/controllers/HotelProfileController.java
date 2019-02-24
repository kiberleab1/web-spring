package com.hhhkk.eHotels.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;

import com.hhhkk.eHotels.domains.Comment;
import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.ImageModel;
import com.hhhkk.eHotels.domains.User;
import com.hhhkk.eHotels.repositories.ImageRepository;
import com.hhhkk.eHotels.services.CommentService;
import com.hhhkk.eHotels.services.HotelService;
import com.hhhkk.eHotels.services.ImageModelService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/User/Profile")
public class HotelProfileController {
	private HotelService hotelService;
	private ImageModelService imageService;
	private CommentService commentService;

	@Autowired
	public HotelProfileController(HotelService hotelService, ImageModelService imageService,
			CommentService commentService) {
		this.hotelService = hotelService;
		this.imageService = imageService;
		this.commentService = commentService;
	}

	@GetMapping
	public String getProfile(@AuthenticationPrincipal UserDetails userDetails, @RequestParam("hotelId") long hotelId,
			Model model) {
		log.info(hotelId + "");

		Hotel hotel = hotelService.findById(hotelId);
		List<Comment> comments = this.commentService.findByOnHotel(hotel);
		List<ImageModel> images = this.imageService.findByHotel(hotel);
		model.addAttribute("user", (User) userDetails);
		model.addAttribute("profile", hotel);
		model.addAttribute("Comments", comments);
		model.addAttribute("comment", new Comment());
		model.addAttribute("images", images);

		return "usersHotelProfile";
	}

	@PostMapping
	public String saveComment(@AuthenticationPrincipal UserDetails userDetails, @Valid Comment comment) {

		User user = (User) userDetails;
		comment.setByUser(user);
		Date date = new Date();
		comment.setOnDate(date.getDate() + "/" + date.getMonth() + "/" + date.getYear());

		this.commentService.saveComment(comment);
		return "redirect:/User/Profile?hotelId=" + comment.getOnHotel().getHotelId();
	}

	@PostMapping(path = "edit")
	public String editComment(@AuthenticationPrincipal UserDetails userDetails, Comment comment, Model model) {
		Hotel hotel = hotelService.findById(comment.getOnHotel().getHotelId());
		List<Comment> comments = this.commentService.findByOnHotel(hotel);
		Comment com = this.commentService.findById(comment.getId());
		model.addAttribute("user", (User) userDetails);
		model.addAttribute("profile", hotel);
		model.addAttribute("Comments", comments);
		model.addAttribute("comment", com);
		return "usersHotelprofile";
	}

	@PostMapping(path = "delete")
	public String deleteComment(Comment comment) {
		this.commentService.deleteComment(comment.getId());
		return "redirect:/User/Profile?hotelId=" + comment.getOnHotel().getHotelId();

	}

	/*
	 * @ModelAttribute(name = "profile") public Hotel profileHotel(Model model) {
	 * Hotel hotelProfile = hotelService.findById(this.hotel.getHotelId());// yet to
	 * be made specfic for every Manager
	 * 
	 * // log.info(hotelProfile.getHotelName()); return hotelProfile; // return new
	 * Hotel(); }
	 */

}
