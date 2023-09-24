package com.sabji.services;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabji.entity.DriverDetails;
import com.sabji.model.DriverDetailDTO;
import com.sabji.repo.DriverDetailRepo;

@Service
public class VehcileService {
	@Autowired
	ModelMapper mapper;

	@Autowired
	DriverDetailRepo driverDetailRepo;

	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(VehcileService.class);

	public String saveDriverData(@Valid DriverDetailDTO driverDetailDTO) {

		try {
			DriverDetails driverDetails = mapper.map(driverDetailDTO, DriverDetails.class);
			driverDetailRepo.save(driverDetails);
			return "Success";

		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
			return "Error";
		}

	}

}
