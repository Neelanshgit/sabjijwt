package com.sabji.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabji.entity.GdmsApiUsers;

public interface GdmsApiUserRepo extends JpaRepository<GdmsApiUsers,String> {

	
	GdmsApiUsers findByUsername(String username);
}
