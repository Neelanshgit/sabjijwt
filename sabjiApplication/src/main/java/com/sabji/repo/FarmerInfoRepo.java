package com.sabji.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabji.entity.FarmerInfo;

public interface FarmerInfoRepo extends JpaRepository<FarmerInfo, Integer> {

}
