package com.picture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.picture.model.Photo;
import com.picture.model.Users;
import com.picture.service.PhotoService;
import com.picture.service.UserService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;


@Controller
public class UploadController {

	@Autowired
	PhotoService photoService;
	
	@Autowired
	UserService userService;
	
	
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = new File("src\\main\\resources\\static\\uploads").getAbsolutePath();



    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file, @ModelAttribute("photo") Photo photo,      
                                   Model model,HttpSession session) {
    	  Users user = userService.getUserByID((Long)session.getAttribute("userID"));
        if (file.isEmpty()) {
        	model.addAttribute("message", "Please select a file to upload");
            model.addAttribute("fullname", user.getFullname());
            return "home";
        }

        try {

        	FileOutputStream output = new FileOutputStream(UPLOADED_FOLDER + "\\" +file.getOriginalFilename());

    		output.write(file.getBytes());
        	
       
            photo.setName(file.getOriginalFilename());
            
         
           photo.setUser(user);
           photoService.savePhoto(photo);
            
           
           model.addAttribute("fullname", user.getFullname());
           model.addAttribute("photo", new Photo());
           model.addAttribute("userPhotos",photoService.getPhotosFromUserID(user.getUser_id()));
           
           model.addAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "home";
    }

 
}