package com.sabji.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabji.entity.FarmerInfoEntity;

public interface DriverDetailRepo extends JpaRepository<FarmerInfoEntity, Integer>{

}
