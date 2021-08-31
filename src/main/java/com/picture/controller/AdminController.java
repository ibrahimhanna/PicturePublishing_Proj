package com.picture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.picture.model.Adminstrators;
import com.picture.model.Users;
import com.picture.service.PhotoService;


@Controller
public class AdminController {

	@Autowired
	PhotoService photoService;
	
	@RequestMapping(value="/adminLogin", method=RequestMethod.GET)
	public String adminLogin(Model model) {
		 model.addAttribute("adminLogin", new Adminstrators());
		return "adminLogin";
	}
	
	
	
	
	
	@PostMapping("/adminLoginForm")
	 public String registerForm(@ModelAttribute("adminLogin") Adminstrators adminstrator,Model model) {
		
	      if(adminstrator.getUsername() .equals("admin")  && adminstrator.getPassword().equals("admin123")) {
	    	  
	    	  model.addAttribute("adminLogin", new Adminstrators());
	    	  model.addAttribute("usersPhotos",photoService.getPhotos());
	           
	    	  
	    	  
	    	  return "adminstratorHome";
	      }
	      
	      else {
	    	  return "adminLogin";
	      }
		
	}
	
	
	
	
	
	
	
	
}
