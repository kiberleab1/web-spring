package com.hhhkk.eHotels.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hhhkk.eHotels.domains.ImageModel;

public interface ImageRepository extends CrudRepository<ImageModel, Long> {
	//List<ImageModel> findByHotelId(Long hotelId);
	ImageModel findById(long id);
}
