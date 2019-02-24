package com.hhhkk.eHotels.services;

import java.util.List;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.ImageModel;;

public interface ImageModelService {
	List<ImageModel> findByHotel(Hotel hotel);
	void save(ImageModel image);
	void deleteImage(long Id);
}
