package com.hhhkk.eHotels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.User;
import com.hhhkk.eHotels.repositories.HotelRepository;

@Service
public class HotelServiceImplementation implements HotelService{
	 @Autowired
	 private HotelRepository hotelRepository;

	@Override
	public Hotel findById(long id) {
		return hotelRepository.findById(id);
	}

	@Override
	public Hotel findByUser(User id) {
		
		return hotelRepository.findByUser(id);
	}

	@Override
	public List<Hotel> findByIsConfirmed(short confirmation) {
		
		return hotelRepository.findByIsConfirmed(confirmation);
	}

	@Override
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
		
	}

	@Override
	public Iterable<Hotel> findAll() {
	
		return hotelRepository.findAll();
	}

	@Override
	public void updatehotelprofile(Hotel hotel) {
		// TODO Auto-generated method stub
		hotelRepository.save(hotel);
		
	}

	@Override
	public void deletById(long id) {
		// TODO Auto-generated method stub
		hotelRepository.deleteById(id);
	}

}
