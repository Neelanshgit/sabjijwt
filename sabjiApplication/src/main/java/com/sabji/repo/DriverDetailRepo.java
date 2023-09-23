package com.sabji.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabji.entity.DriverDetails;
 

public interface DriverDetailRepo extends JpaRepository<DriverDetails, Integer>{

}
