package com.sabji.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabji.entity.VegetableEntity;

public interface VegetableRepo extends JpaRepository<VegetableEntity, Integer> {

	VegetableEntity findByVegIdAndUserCode(Long vegId, String userCode);

	VegetableEntity findByVegId(Long vegId);

	List<VegetableEntity> findByUserCode(String userCode);

	List<VegetableEntity> findByVegetableNameLike(String vegName);

	Long countByUserCode(String userCode);

}
