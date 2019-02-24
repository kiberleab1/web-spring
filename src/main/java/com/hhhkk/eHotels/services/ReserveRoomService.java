package com.hhhkk.eHotels.services;

import java.util.List;
import java.util.Optional;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.ReserveRoom;
import com.hhhkk.eHotels.domains.User;

public interface ReserveRoomService {
	void saveReserveRoom(ReserveRoom reserveRoom);
	List<ReserveRoom> findAllByUser(User Id);
	List<ReserveRoom> findAllByHotel(Hotel hotel);
	Optional<ReserveRoom> findById(Long Id);
	void deleteByReservation(long Id);
}
