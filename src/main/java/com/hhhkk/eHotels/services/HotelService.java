package com.hhhkk.eHotels.services;

import java.util.List;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.User;

public interface HotelService {
	Hotel findById(long id);
	Hotel findByUser(User id);
	List<Hotel> findByIsConfirmed(short confirmation);
	Iterable<Hotel> findAll();
	Hotel saveHotel(Hotel hotel);
	void updatehotelprofile(Hotel hotel);
	void deletById(long id);
}
