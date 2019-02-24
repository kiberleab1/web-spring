package com.hhhkk.eHotels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.User;

public interface HotelRepository extends CrudRepository<Hotel,Long>{
//	Hotel findById(long id);
	Hotel findById(long id);
	Hotel findByUser(User id);
	List<Hotel> findByIsConfirmed(short confirmation);
	//void updatehotelprofile(Hotel hotel);
	
}
