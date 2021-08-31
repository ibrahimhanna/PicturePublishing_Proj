package com.picture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.picture.model.Users;






@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	
	List<Users> findByEmail(String email);
	
	
}
