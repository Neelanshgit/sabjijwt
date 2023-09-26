package com.sabji.services;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sabji.entity.DriverDetails;
import com.sabji.model.DriverDetailDTO;
import com.sabji.repo.DriverDetailRepo;

@Service
public class DriverDetailService {

	@Autowired
	DriverDetailRepo driverdetailrepo;
	
	@Autowired
	ModelMapper mapper;
	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DriverDetailService.class);

	 DriverDetailDTO 	driverdetaildto = null;
	
	public DriverDetailDTO findByuserCode(String userCode) {
	
		try {
			 DriverDetails  driverdetails = driverdetailrepo.findByuserCode(userCode);
		 	driverdetaildto =  mapper.map(driverdetails, DriverDetailDTO.class);
			return driverdetaildto;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by ID {} ", e.getMessage());
			return driverdetaildto;
		}

	}
	

	public DriverDetailDTO findByDriverbydriverNumber(String driverNumber) {
		 
		try {
			 DriverDetails  driverdetails = driverdetailrepo.findBydriverNumber(driverNumber);
		 	driverdetaildto =  mapper.map(driverdetails, DriverDetailDTO.class);
			return driverdetaildto;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by ID {} ", e.getMessage());
			return driverdetaildto;
		}
	}

 


	public DriverDetailDTO findByDriverbydriverarea(String area) {
		try {
			 DriverDetails  driverdetails = driverdetailrepo.findBydriverArea(area);
		 	driverdetaildto =  mapper.map(driverdetails, DriverDetailDTO.class);
			return driverdetaildto;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by ID {} ", e.getMessage());
			return driverdetaildto;
		}
 
}
}