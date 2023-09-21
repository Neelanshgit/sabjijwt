package com.sabji.services;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sabji.entity.GdmsApiUsers;
import com.sabji.model.RegisterModal;
import com.sabji.repo.GdmsApiUserRepo;

@Service
public class RegistrationService {

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	ModelMapper mapper;

	@Autowired
	GdmsApiUserRepo gdmsApiUserRepo;

	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RegistrationService.class);

	public String registerByMobileApplication(RegisterModal usrMstrDto) {

		try {
			GdmsApiUsers gdmsApiUsers = mapper.map(usrMstrDto, GdmsApiUsers.class);
			gdmsApiUsers.setPassword(bcryptEncoder.encode(gdmsApiUsers.getPassword()));
			gdmsApiUsers.setUserstatus("Y");
			gdmsApiUsers.setDateOfCreation(LocalDate.now());
			gdmsApiUserRepo.save(gdmsApiUsers);
			return "Success";
		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
			return "Error";
		}

	}
}