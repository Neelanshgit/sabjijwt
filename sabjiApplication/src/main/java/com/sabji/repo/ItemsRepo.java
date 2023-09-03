package com.sabji.repo;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabji.entity.Items;

 


@Repository
public interface ItemsRepo extends JpaRepository<Items, Integer> {

}
