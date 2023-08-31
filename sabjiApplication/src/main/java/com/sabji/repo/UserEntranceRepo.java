package com.sabji.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabji.entity.EntranceUser;

public interface UserEntranceRepo  extends JpaRepository<EntranceUser,Integer>{
	
	EntranceUser findByUsername(String username);

}
