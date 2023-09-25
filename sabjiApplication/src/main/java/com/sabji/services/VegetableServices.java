package com.sabji.services;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sabji.entity.VegetableEntity;
import com.sabji.model.VegetableDetailsDTO;
import com.sabji.repo.VegetableRepo;
import com.sabji.util.MapperUtil;

@Service
public class VegetableServices {

	@Autowired
	ModelMapper mapper;

	@Autowired
	VegetableRepo vegetablerepo;

	@Autowired
	MapperUtil mapperUtil;

	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(VegetableServices.class);

	public String saveVegetableService(VegetableDetailsDTO vegetableDetailsDTO) {

		try {
			VegetableEntity vegetableEntity = mapper.map(vegetableDetailsDTO, VegetableEntity.class);
			vegetablerepo.save(vegetableEntity);
			return "Success";

		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
			return "Error";
		}

	}

	public VegetableDetailsDTO saveVegetableServiceWithId(VegetableDetailsDTO vegetableDetailsDTO) {

		try {
			VegetableEntity vegetableEntity = mapper.map(vegetableDetailsDTO, VegetableEntity.class);
			vegetableEntity = vegetablerepo.save(vegetableEntity);
			vegetableDetailsDTO = mapper.map(vegetableEntity, VegetableDetailsDTO.class);
			return vegetableDetailsDTO;

		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
			return vegetableDetailsDTO;
		}

	}

	public String saveVegeatableImage(@Valid MultipartFile pic, String userCode, String vegId) {

		try {

			VegetableEntity vegetableEntity = vegetablerepo.findByVegIdAndUserCode(Long.parseLong(vegId), userCode);
			vegetableEntity.setPic(Base64.getEncoder().encode(pic.getBytes()));
			vegetablerepo.save(vegetableEntity);
			return "Success";

		} catch (Exception e) {
			log.error("there is an exception in  saving image of the vegetable {} ", e.getMessage());
			return "Error";
		}
	}

	public VegetableDetailsDTO findVegetable(Long vegId) {
		VegetableDetailsDTO vegetableDetailsDTO = new VegetableDetailsDTO();
		try {
			VegetableEntity vegetableEntity = vegetablerepo.findByVegId(vegId);
			vegetableDetailsDTO = mapper.map(vegetableEntity, VegetableDetailsDTO.class);
			return vegetableDetailsDTO;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by ID {} ", e.getMessage());
			return vegetableDetailsDTO;
		}

	}

	public List<VegetableDetailsDTO> findVegetableByUserCode(String userCode) {
		List<VegetableDetailsDTO> vegetableDetailsDTO = new ArrayList<>();
		try {
			List<VegetableEntity> vegetableEntity = vegetablerepo.findByUserCode(userCode);
			vegetableDetailsDTO = mapperUtil.mapList(vegetableEntity, VegetableDetailsDTO.class);
			return vegetableDetailsDTO;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by usercode {} ", e.getMessage());
			return vegetableDetailsDTO;
		}

	}

	public List<VegetableDetailsDTO> findVegetablebyName(String vegName) {
		List<VegetableDetailsDTO> vegetableDetailsDTO = new ArrayList<>();
		try {
			List<VegetableEntity> vegetableEntity = vegetablerepo.findByVegetableNameLike(vegName);
			vegetableDetailsDTO = mapperUtil.mapList(vegetableEntity, VegetableDetailsDTO.class);
			return vegetableDetailsDTO;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by vegName {} ", e.getMessage());
			return vegetableDetailsDTO;
		}

	}

	public Long findVegetableCount(String userCode) {
		Long count = 0L;
		try {
			count = vegetablerepo.countByUserCode(userCode);

			return count;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by vegName {} ", e.getMessage());
			return count;
		}

	}

}
