package com.hhhkk.eHotels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.ReserveRoom;
import com.hhhkk.eHotels.domains.User;

public interface ReserveRoomRepository extends CrudRepository<ReserveRoom,Long> {
	List<ReserveRoom> findAllByReserveuser(User user);
	List<ReserveRoom> findAllByReserveHotel(Hotel hotel);
}
