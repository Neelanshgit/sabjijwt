package com.sabji.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sabji.entity.FarmerInfoEntity;
import com.sabji.entity.Items;
import com.sabji.entity.VegetableEntity;
import com.sabji.repo.DriverDetailRepo;
import com.sabji.repo.ItemsRepo;
import com.sabji.repo.VegetableRepo;

 ;

@Service 
public class ItemServiceImplement implements ItemService{

	
	@Autowired
	ItemsRepo itemrepo;
	
	@Autowired
	DriverDetailRepo driverrepo;
	
	@Autowired
	VegetableRepo vegetablerepo;
	
	@Override
	public Items itemservice(Items items) {
		 
		 return itemrepo.save(items);
	}
 
	@Override
	public VegetableEntity VegetableService(VegetableEntity vegetablentity) {
		 
		return vegetablerepo.save(vegetablentity);
	}

 
	@Override
	public FarmerInfoEntity farmerService(FarmerInfoEntity farmerentity) {
		// TODO Auto-generated method stub
		return driverrepo.save(farmerentity);
	}

	@Override
	public List<Items> getallItems() {
		// TODO Auto-generated method stub
		return itemrepo.findAll();
	}

	@Override
	public List<Items> getItemsById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FarmerInfoEntity> getallFarmardetail() {
		// TODO Auto-generated method stub
		return driverrepo.findAll();
	}

	@Override
	public List<FarmerInfoEntity> getFarmerdetailById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VegetableEntity> getallVegetableDetail() {
		// TODO Auto-generated method stub
		return vegetablerepo.findAll();
	}

	@Override
	public List<VegetableEntity> getVegetableDetailById() {
		// TODO Auto-generated method stub
		return null;
	}



 

 
}
