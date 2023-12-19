package com.sabji.services;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sabji.entity.GdmsApiUsers;
import com.sabji.model.ProfileModel;
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
			gdmsApiUsers.setUsername(gdmsApiUsers.getMobileNo());
			gdmsApiUsers.setDateOfCreation(LocalDate.now());
			gdmsApiUserRepo.save(gdmsApiUsers);
			return "Success";
		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
			return "Error";
		}

	}

	public String findByMobile(@Valid RegisterModal userMstr) {

		try {
			Optional<GdmsApiUsers> mobileCheck = gdmsApiUserRepo.findByMobileNo(userMstr.getMobileno());
			if (mobileCheck.isPresent()) {
				return "A";
			} else {
				return "NA";
			}

		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
			return "A";
		}

	}

	public ProfileModel getProfileData(String userCode) {
		ProfileModel profile = new ProfileModel();
		try {

			Optional<GdmsApiUsers> users = gdmsApiUserRepo.findByMobileNo(userCode);
			if (users.isPresent()) {
				profile.setEmail(users.get().getEmail());
				profile.setMobileno(userCode);
				profile.setUsername(users.get().getUsername());
				profile.setFlagofuser(users.get().getFlgOfUser());
				profile.setAadharNo(users.get().getAadharNo());
						
			}

			return profile;

		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
			return profile;
		}

	}
	
}
