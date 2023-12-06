package com.sabji.services;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sabji.entity.DriverDetails;
import com.sabji.entity.FarmerInfo;
import com.sabji.entity.FarmerInfoEntity;
import com.sabji.entity.Items;
import com.sabji.entity.VegetableEntity;
import com.sabji.model.BasicDetailsDTO;
import com.sabji.repo.DeliveryPartnerRepo;
import com.sabji.repo.DriverDetailRepo;
import com.sabji.repo.FarmerInfoRepo;
import com.sabji.repo.ItemsRepo;
import com.sabji.repo.VegetableRepo;

;

@Service
public class ItemServiceImplement implements ItemService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	ItemsRepo itemrepo;

	@Autowired
	DriverDetailRepo driverrepo;

	@Autowired
	VegetableRepo vegetablerepo;

	@Autowired
	DeliveryPartnerRepo deliveryrepo;

	@Autowired
	FarmerInfoRepo farmerrepo;

//
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ItemServiceImplement.class);

	@Override
	public VegetableEntity VegetableService(VegetableEntity vegetablentity) {

		return vegetablerepo.save(vegetablentity);
	}

	@Override
	public FarmerInfoEntity farmerService(FarmerInfoEntity farmerentity) {

		return deliveryrepo.save(farmerentity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BasicDetailsDTO> getallItems() {

		List<Items> itemss = itemrepo.findAll();
		List<BasicDetailsDTO> basicdtoo = null;
		try {

			basicdtoo = (List<BasicDetailsDTO>) mapper.map(itemss, BasicDetailsDTO.class);

		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
		}
		return basicdtoo;

	}

	@Override
	public List<Items> getItemsById() {

		return null;
	}

	@Override
	public List<FarmerInfoEntity> getallFarmardetail() {

		return deliveryrepo.findAll();
	}

	@Override
	public List<FarmerInfoEntity> getFarmerdetailById() {

		return null;
	}

	@Override
	public List<VegetableEntity> getallVegetableDetail() {

		return vegetablerepo.findAll();
	}

	@Override
	public List<VegetableEntity> getVegetableDetailById() {

		return null;
	}

	@Override
	public FarmerInfo farmerinfo(FarmerInfo farmerinformation) {

		return null;
	}

	@Override
	public DriverDetails driverdetailservice(DriverDetails driverdetails) {

		return null;
	}

	@Override
	public List<FarmerInfo> getallFarmerinfo() {
		return farmerrepo.findAll();
	}

	@Override
	public List<FarmerInfo> getFarmerinfoById() {

		return null;
	}

	@Override
	public List<DriverDetails> getdriverdetailsinfo() {

		return driverrepo.findAll();
	}

	@Override
	public List<DriverDetails> getdrivDetailsById() {

		return null;
	}

	@Override
	public BasicDetailsDTO itemservice(BasicDetailsDTO basicDetailsDTO) {
		try {

			Items basicdetaildto = mapper.map(basicDetailsDTO, Items.class);
			itemrepo.save(basicdetaildto);

		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
		}
		return basicDetailsDTO;
	}

	@Override
	public String saveVegeatableImage(@Valid MultipartFile pic, String userCode, String vegId) {

		return null;
	}

}
