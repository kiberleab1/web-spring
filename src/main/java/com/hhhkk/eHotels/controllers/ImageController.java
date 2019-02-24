package com.hhhkk.eHotels.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.ImageModel;
import com.hhhkk.eHotels.domains.User;
import com.hhhkk.eHotels.services.HotelService;
import com.hhhkk.eHotels.services.ImageModelService;
import com.hhhkk.eHotels.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("Hotel/Image")
public class ImageController {
	ImageModelService imageModelService;
	UserService userService;
	HotelService hotelService;
	@Autowired
	public ImageController(ImageModelService imageModelService,UserService userService,HotelService hotelService) {
		this.imageModelService=imageModelService;
		this.userService=userService;
		this.hotelService=hotelService;
	}
	@ModelAttribute(name="images")
	public List<ImageModel> getImage(@AuthenticationPrincipal UserDetails userDetails,Model model) {
		User user=userService.findByEmail(userDetails.getUsername());
		log.info(user.getId()+"");
		Hotel hotel=hotelService.findByUser(user);//yet to be made specfic for every Manager
		return this.imageModelService.findByHotel(hotel);
		
	}
	@ModelAttribute(name="newImages")
	public ImageModel uploadImage(Model model) {
		return new ImageModel();
	}
	@GetMapping
	public String getImages() {
		return "hotelImages";
	}
	@PostMapping
	public  String UploadPost(ImageModel post,Errors errors,
			@RequestParam("img")MultipartFile file,
			@AuthenticationPrincipal UserDetails userDetails
			) 
	{
		
		
		if (errors.hasErrors()) {
			  return "uploadPost";
		  }
		User user = userService.findByEmail(userDetails.getUsername());
		Hotel hotel=this.hotelService.findByUser(user);
		post.setHotelId(hotel);
		
		
		try {
			int i=1;
			String filename=file.getOriginalFilename();
			int pos = filename.lastIndexOf(".");
            String dir="src/main/resources/static/image";
            File directory = new File(dir);
            if (! directory.exists()){
                directory.mkdir();
            }
			String name="";
			if (pos > 0) {
			    name += filename.substring(0, pos);
			}
			String absPath=directory.getAbsolutePath();
			//absPath.replaceAll("\\","/");
			log.info("abs: "+absPath);
			String filePath = absPath + "/" + name+"/";
			File destFolder = new File(filePath);
			
			while(destFolder.exists()) {
				filePath=directory.getAbsolutePath()+"/"+ name+"("+i+")/";
				destFolder=new File(filePath);
				i++;
			}
			
			destFolder.mkdir();
			
			
			
			filePath+=filename;
			log.info(filePath);
			File dest=new File(filePath);
		
			file.transferTo(dest);
			
			post.setPath("../image/"+name+"/"+name+".jpg");
			
		}
		catch(FileNotFoundException e) {
			log.info(e.getMessage());
		}
		catch(IOException e) {
			log.info(e.getMessage());
		}
		
		this.imageModelService.save(post);
		///attribute.addFlashAttribute("success","Resource has been added successfully");

		return "redirect:/Hotel/profile";
		
	}
	@GetMapping(path="delete")
	public String deleteImage(String Id) {
		this.imageModelService.deleteImage((long)Integer.parseInt(Id));
		return "redirect:/Hotel/Image";
	}

}
