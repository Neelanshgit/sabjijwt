package com.sabji.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabji.entity.DetailsOfUser;

public interface DetailsUserRepo extends JpaRepository<DetailsOfUser,String> {

}
