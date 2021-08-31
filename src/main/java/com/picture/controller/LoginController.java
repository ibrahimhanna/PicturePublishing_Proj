package com.picture.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.picture.model.Photo;
import com.picture.model.Users;
import com.picture.service.PhotoService;
import com.picture.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	PhotoService photoService;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		 model.addAttribute("login", new Users());
		return "login";
	}
	
	
	
	@PostMapping("/login_form")
	 public String registerForm(@ModelAttribute("login") Users user,Model model,HttpSession session) {
		
		Users loginner= null;
		loginner = userService.login(user.getEmail(), user.getPassword());
		
		
		
		
		if(loginner!=null) {
			session.setAttribute("userID", loginner.getUser_id());
			model.addAttribute("fullname", loginner.getFullname());
			model.addAttribute("photo", new Photo());
			model.addAttribute("userPhotos",photoService.getPhotosFromUserID(loginner.getUser_id()));
			return "home";
		}
		else {
			model.addAttribute("login", new Users());
			model.addAttribute("loginFailed", 1);
			return "login";
		}
		 
	 }
	
	
}
