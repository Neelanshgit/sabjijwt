package com.sabji.services;

import java.util.ArrayList;
import java.util.Optional;

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

	@Override
	public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {

		try {
			Optional<GdmsApiUsers> user = apiUserRepo.findByMobileNo(mobile);
			if (user == null || !user.isPresent()) {
				throw new UsernameNotFoundException("User not found with username: " + mobile);

			} else {
				return new User(user.get().getUsername(), user.get().getPassword(), new ArrayList<>());
			}

		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found with username: " + mobile);
		}

	}

}