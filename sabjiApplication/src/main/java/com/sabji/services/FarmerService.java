package com.sabji.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabji.entity.FarmerInfo;
import com.sabji.model.FarmerInfoDTO;
import com.sabji.repo.FarmerInfoRepo;
import com.sabji.util.MapperUtil;

@Service
public class FarmerService {
	@Autowired
	ModelMapper mapper;

	@Autowired
	FarmerInfoRepo farmerInfoRepo;

	@Autowired
	MapperUtil mapperUtil;
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FarmerService.class);

	public String saveFarmerData(@Valid FarmerInfoDTO farmerInfoDTO) {

		try {
			FarmerInfo farmerInfo = mapper.map(farmerInfoDTO, FarmerInfo.class);
			farmerInfoRepo.save(farmerInfo);
			return "Success";

		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
			return "Error";
		}

	}

	public FarmerInfoDTO getFarmerData(@Valid FarmerInfoDTO farmerInfoDTO) {

		try {
			FarmerInfo farmerInfo = farmerInfoRepo.findByPhoneNumber(farmerInfoDTO.getPhoneNumber());
			farmerInfoDTO = mapper.map(farmerInfo, FarmerInfoDTO.class);
			return farmerInfoDTO;
		} catch (Exception e) {
			log.error("there is an exception in  getting the farmer {} ", e.getMessage());
			return farmerInfoDTO;
		}

	}

	public FarmerInfoDTO getFarmerDatabyId(@Valid FarmerInfoDTO farmerInfoDTO) {

		try {
			FarmerInfo farmerInfo = farmerInfoRepo.findByFarmerId(farmerInfoDTO.getFarmerId());
			farmerInfoDTO = mapper.map(farmerInfo, FarmerInfoDTO.class);
			return farmerInfoDTO;
		} catch (Exception e) {
			log.error("there is an exception in  getting the farmer {} ", e.getMessage());
			return farmerInfoDTO;
		}

	}

	public FarmerInfoDTO getFarmerName(@Valid FarmerInfoDTO farmerInfoDTO) {

		try {
			FarmerInfo farmerInfo = farmerInfoRepo.findByFarmerName(farmerInfoDTO.getFarmerName());
			farmerInfoDTO = mapper.map(farmerInfo, FarmerInfoDTO.class);
			return farmerInfoDTO;
		} catch (Exception e) {
			log.error("there is an exception in  getting the farmer {} ", e.getMessage());
			return farmerInfoDTO;
		}

	}

	public Long getfarmerCountByUserCode(String userCode) {
		Long count = 0L;
		try {
			count = farmerInfoRepo.countByUserCode(userCode);
			return count;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by vegName {} ", e.getMessage());
			return count;
		}
	}

	public List<FarmerInfo> getallFarmerinfo() {
		return farmerInfoRepo.findAll();
	}

	public List<FarmerInfoDTO> getfarmerByUserCode(String userCode) {
		List<FarmerInfoDTO> farmerInfoDTOs = new ArrayList<>();
		try {
			List<FarmerInfo> farmerInfo = farmerInfoRepo.findByUserCode(userCode);
			farmerInfoDTOs = mapperUtil.mapList(farmerInfo, FarmerInfoDTO.class);
			return farmerInfoDTOs;
		} catch (Exception e) {
			log.error("there is an exception in  getting the farmer {} ", e.getMessage());
			return farmerInfoDTOs;
		}
	}

}
