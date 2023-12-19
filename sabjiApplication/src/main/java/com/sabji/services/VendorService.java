package com.sabji.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sabji.entity.VendorEntity;

import com.sabji.model.VendorModel;
import com.sabji.repo.VendorRepo;

import com.sabji.util.MapperUtil;

@Service
public class VendorService {
	@Autowired
	VendorRepo vendorRepo;
	@Autowired
	ModelMapper mapper;
	@Autowired
	MapperUtil mapperUtil;
	
	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(VendorService.class);

	
	public String saveVendorData(@Valid VendorModel vendormodel) {

		try {
			VendorEntity vendor = mapper.map(vendormodel, VendorEntity.class);
			vendorRepo.save(vendor);
			return "Success";

		} catch (Exception e) {
			log.error("there is an exception in   not save the data {} ", e.getMessage());
			return "Error";
		}

	}
	
	public List<VendorModel> findAllvendorByUserCode(String userCode) {
		List<VendorModel> vendormodel = new ArrayList<>();
		try {
			//List<VendorEntity> vendor = vendorRepo.findAllVendorByUserCode(userCode);
			List<VendorEntity> vendor = vendorRepo.findByUserCode(userCode);
			vendormodel=mapperUtil.mapList(vendor, VendorModel.class);
			return vendormodel;
		} catch (Exception e) {
			log.error("there is an exception in not  fetching the  vendor data  {} ", e.getMessage());
			return vendormodel;
		}

	}
	public List<VendorEntity> getallVendorEntity() {
		return vendorRepo.findAll();
	}
	public Long getvendorcountByUserCode(String userCode) {
		Long count = 0L;
		try {
			count = vendorRepo.countByUserCode(userCode);
			return count;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the count of vendor {} ", e.getMessage());
			return count;
		}
	}


}
