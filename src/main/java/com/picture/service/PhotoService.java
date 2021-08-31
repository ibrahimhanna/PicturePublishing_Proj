package com.picture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picture.model.Photo;
import com.picture.model.Users;
import com.picture.repository.PhotoRepository;
import com.picture.repository.UserRepository;


@Service
public class PhotoService {

	

	@Autowired 
	PhotoRepository photoRepository;
	
	
	
	public boolean savePhoto(Photo photo) {
		
		photoRepository.save(photo);
		
		return true;
	}
	
	
	public List<Photo> getPhotosFromUserID(long user_id){
     	return photoRepository.findPhotoByUser_id(user_id);
		
	}
	
	public List<Photo> getPhotos(){
     	return photoRepository.findAll();
		
	}
	
}
