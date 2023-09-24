package com.sabji.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sabji.entity.DriverDetails;
import com.sabji.entity.FarmerInfo;
import com.sabji.entity.FarmerInfoEntity;
import com.sabji.entity.Items;
import com.sabji.entity.VegetableEntity;
import com.sabji.model.BasicDetailsDTO;
import com.sabji.model.VegetableDetailsDTO;

@Service
public interface ItemService {

//	public Items itemservice(Items items);

	public BasicDetailsDTO itemservice(BasicDetailsDTO basicDetailsDTO);

	public FarmerInfoEntity farmerService(FarmerInfoEntity farmerentity);

	public VegetableEntity VegetableService(VegetableEntity vegetableEntity);

	public String saveVegetableService(VegetableDetailsDTO vegetableDetailsDTO);

	public FarmerInfo farmerinfo(FarmerInfo farmerinformation);

	public DriverDetails driverdetailservice(DriverDetails driverdetails);

	public List<DriverDetails> getdriverdetailsinfo();

	public List<FarmerInfo> getallFarmerinfo();

//	public List<Items> getallItems();

	public List<BasicDetailsDTO> getallItems();

	public List<FarmerInfoEntity> getallFarmardetail();

	public List<VegetableEntity> getallVegetableDetail();

	public List<Items> getItemsById();

	public List<FarmerInfoEntity> getFarmerdetailById();

	public List<VegetableEntity> getVegetableDetailById();

	public List<FarmerInfo> getFarmerinfoById();

	public List<DriverDetails> getdrivDetailsById();
}
