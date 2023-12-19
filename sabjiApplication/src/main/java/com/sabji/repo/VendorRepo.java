package com.sabji.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sabji.entity.VendorEntity;

public interface VendorRepo extends JpaRepository <VendorEntity, Long>{
	
	

	List<VendorEntity> findByUserCode(String userCode);
	Long countByUserCode(String userCode);
    
    

	
}

