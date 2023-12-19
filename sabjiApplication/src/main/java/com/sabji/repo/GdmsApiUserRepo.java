package com.sabji.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabji.entity.GdmsApiUsers;

public interface GdmsApiUserRepo extends JpaRepository<GdmsApiUsers, String> {

	GdmsApiUsers findByUsername(String username);

	Optional<GdmsApiUsers> findByMobileNo(String mobileno);

	Optional<GdmsApiUsers> findByAadharNo(String aadharNo);
}
