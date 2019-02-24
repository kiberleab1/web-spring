package com.hhhkk.eHotels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.ImageModel;

public interface ImageModelRepository extends CrudRepository<ImageModel,Long>{
	List<ImageModel> findByHotelId(Hotel Id);

}
