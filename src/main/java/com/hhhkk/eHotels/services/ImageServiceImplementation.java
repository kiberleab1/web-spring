package com.hhhkk.eHotels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.ImageModel;
import com.hhhkk.eHotels.repositories.ImageModelRepository;

@Service
public class ImageServiceImplementation implements ImageModelService {

	ImageModelRepository imageRepository;

	@Autowired
	public ImageServiceImplementation(ImageModelRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	@Override
	public List<ImageModel> findByHotel(Hotel hotel) {
		
		return imageRepository.findByHotelId(hotel);
	}

	@Override
	public void save(ImageModel image) {
		this.imageRepository.save(image);
		
	}

	@Override
	public void deleteImage(long Id) {
		// TODO Auto-generated method stub
		this.imageRepository.deleteById(Id);
		
	}

}
