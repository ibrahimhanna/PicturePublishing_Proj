package com.picture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.picture.model.Photo;




@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

	
	@Query(value = "SELECT * FROM photos p WHERE p.user_id = :userID", nativeQuery = true)
	List<Photo> findPhotoByUser_id(@Param("userID") long userID);
	
	
	
	
	
	
}
