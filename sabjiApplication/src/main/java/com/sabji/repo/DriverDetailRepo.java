package com.sabji.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabji.entity.DriverDetails;

@Repository
public interface DriverDetailRepo extends JpaRepository<DriverDetails, Long> {

	List<DriverDetails> findByUserCode(String userCode);

	DriverDetails findByDriverNumber(String driverNumber);

	DriverDetails findByDriverArea(String area);

	Long countByUserCode(String userCode);

}
