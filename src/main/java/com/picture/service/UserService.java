package com.picture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picture.model.Users;
import com.picture.repository.UserRepository;



@Service
public class UserService {

	@Autowired 
	UserRepository userRepository;
	
	
	
	public List<Users> fetchPersons(){
		
		return userRepository.findAll();
	}
	
	
	
	public boolean saveUser(Users user) {
		
		userRepository.save(user);
		
		return true;
	}
	
	
	
	public boolean emailExists(String email) {
		
		List<Users> user = userRepository.findByEmail(email);
		if(user.size()>0) 
			return true;
		else
			return false;
		
	}
	
	
	public Users getUser(String email) {
		
		List<Users> user = userRepository.findByEmail(email);
		if(user.size()>0) {
		return user.get(0);
		}
		return null;
	}
	
	public Users getUserByID(long id) {
		
		 Optional < Users > optional  = userRepository.findById(id);
		   if (optional.isPresent()) {
	            return optional.get();
	        } else {
	            return null;
	        }
	
	}
	
	public Users login(String email, String password) {
		
		List<Users> user = userRepository.findByEmail(email);
		if(user!=null && user.get(0).getPassword().equals(password)) {
			return user.get(0);
		}
		
		
		return null;
	}
	
	
	
	
}
