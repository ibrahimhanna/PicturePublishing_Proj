package com.picture.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.picture.model.Adminstrators;


@Repository
public interface adminRepository extends JpaRepository<Adminstrators, Long> {

	
	
}

