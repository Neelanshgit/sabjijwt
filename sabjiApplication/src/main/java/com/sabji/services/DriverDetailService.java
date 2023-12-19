package com.sabji.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabji.entity.DriverDetails;
import com.sabji.model.DriverDetailDTO;
import com.sabji.repo.DriverDetailRepo;
import com.sabji.util.MapperUtil;

@Service
public class DriverDetailService {

	@Autowired
	DriverDetailRepo driverdetailrepo;

	@Autowired
	ModelMapper mapper;

	@Autowired
	MapperUtil mapperUtil;

	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DriverDetailService.class);

	public List<DriverDetailDTO> findDriverDetailsByuserCode(String userCode) {
		List<DriverDetailDTO> driverdetaildto = new ArrayList<>();
		try {
			List<DriverDetails> driverdetails = driverdetailrepo.findByUserCode(userCode);
			driverdetaildto = mapperUtil.mapList(driverdetails, DriverDetailDTO.class);
			return driverdetaildto;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  driver details {} ", e.getMessage());
			return driverdetaildto;
		}

	}

	public DriverDetailDTO findByDriverbydriverNumber(String driverNumber) {
		DriverDetailDTO driverdetaildto = new DriverDetailDTO();
		try {
			DriverDetails driverdetails = driverdetailrepo.findByDriverNumber(driverNumber);
			driverdetaildto = mapper.map(driverdetails, DriverDetailDTO.class);
			return driverdetaildto;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by ID {} ", e.getMessage());
			return driverdetaildto;
		}
	}

	public DriverDetailDTO findByDriverbydriverarea(String area) {
		DriverDetailDTO driverdetaildto = new DriverDetailDTO();
		try {
			DriverDetails driverdetails = driverdetailrepo.findByDriverArea(area);
			driverdetaildto = mapper.map(driverdetails, DriverDetailDTO.class);
			return driverdetaildto;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by ID {} ", e.getMessage());
			return driverdetaildto;
		}

	}

	public Long findVegetableCount(String userCode) {
		Long count = 0L;
		try {
			count = driverdetailrepo.countByUserCode(userCode);
			return count;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by vegName {} ", e.getMessage());
			return count;
		}
	}
	public List<DriverDetailDTO> findAllDriverDetailsByUserCode(String userCode) {
		List<DriverDetailDTO> driverdetaildto = new ArrayList<>();
		try {
			List<DriverDetails> driverdetails = driverdetailrepo.findAllByUserCode(userCode);
			driverdetaildto = mapperUtil.mapList(driverdetails, DriverDetailDTO.class);
			return driverdetaildto;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  driver details {} ", e.getMessage());
			return driverdetaildto;
		}

	}

	
}
