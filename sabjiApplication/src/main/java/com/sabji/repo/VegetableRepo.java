package com.sabji.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabji.entity.VegetableEntity;

public interface VegetableRepo extends JpaRepository<VegetableEntity, Integer> {

}
