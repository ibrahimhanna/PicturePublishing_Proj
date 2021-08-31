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
import com.picture.service.UserService;





@Controller
public class RegisterController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model) {
		 model.addAttribute("users", new Users());
		return "registration";
	}
	
	
	@PostMapping("/register_form")
	 public String registerForm(@ModelAttribute("users") Users user,Model model,HttpSession session) {
		
		if(userService.emailExists(user.getEmail())) {
			model.addAttribute("emailExists",1);
			return "registration";
		}
		
		
		userService.saveUser(user);
		
		Users usr = userService.getUser(user.getEmail());
		session.setAttribute("userID", usr.getUser_id());
		
		model.addAttribute("fullname",user.getFullname());
		model.addAttribute("photo", new Photo());

		
		 return "home";
	 }
	
	
	
}
