package com.sabji.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sabji.entity.GdmsApiUsers;
import com.sabji.repo.GdmsApiUserRepo;
import com.sabji.repo.UserEntranceRepo;

@Service
public class JwtUserDetailsService implements UserDetailsService {


	@Autowired
	UserEntranceRepo entranceRepo;

     @Autowired
	GdmsApiUserRepo apiUserRepo;
	
     Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);
     
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			GdmsApiUsers user = apiUserRepo.findByUsername(username);
            if (user == null) {
				throw new UsernameNotFoundException("User not found with username: " + username);
				
			} else {
				return new User(user.getUsername(), user.getPassword(),
						new ArrayList<>());
			}

		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

	}
	 
}