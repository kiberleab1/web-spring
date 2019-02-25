package com.web.NoticeBoard.controllers;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.NoticeBoard.domains.Resource;
import com.web.NoticeBoard.domains.User;
import com.web.NoticeBoard.services.PostService;
import com.web.NoticeBoard.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/uploadPost")
public class UploadPostController {
	
	@Autowired
	 private PostService postService;
	@Autowired
	 private UserService userService;
	
	@GetMapping
	public String uploadPost(Model model) {
		model.addAttribute("post", new Resource());
		return "uploadPost";
	}
	
	@PostMapping(params="post")
	public  String UploadPost(@Valid @ModelAttribute("post") Resource post,Errors errors,
			@RequestParam("file")MultipartFile file,
			@AuthenticationPrincipal UserDetails userDetails,
			RedirectAttributes attribute) 
	{
		
		
		if (errors.hasErrors()) {
			  return "uploadPost";
		  }
		User user = userService.findUserByUsername(userDetails.getUsername());
		post.setUser(user);
		
		
		try {
			int i=1;
			String filename=file.getOriginalFilename();
			int pos = filename.lastIndexOf(".");
            String dir="SpringUploads";
            File directory = new File(dir);
            if (! directory.exists()){
                directory.mkdir();
            }
			String name="";
			if (pos > 0) {
			    name += filename.substring(0, pos);
			}
			String filePath = directory.getAbsolutePath() + "/" + name+"/";
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
			
			post.setResourcePath(filePath.substring(1));
			
		}
		catch(FileNotFoundException e) {
			log.info(e.getMessage());
		}
		catch(IOException e) {
			log.info(e.getMessage());
		}
		
		postService.savePost(post);
		attribute.addFlashAttribute("success","Resource has been added successfully");

		return "redirect:/uploadPost";
		
	}
}
