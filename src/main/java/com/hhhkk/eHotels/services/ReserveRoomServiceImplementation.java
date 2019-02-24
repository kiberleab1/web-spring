package com.hhhkk.eHotels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.domains.ReserveRoom;
import com.hhhkk.eHotels.domains.User;
import com.hhhkk.eHotels.repositories.ReserveRoomRepository;

@Service
public class ReserveRoomServiceImplementation implements ReserveRoomService {

	@Autowired
	private ReserveRoomRepository reserveRoomRepostoriy;

	@Override
	public void saveReserveRoom(ReserveRoom reserveRoom) {
		this.reserveRoomRepostoriy.save(reserveRoom);
		
	}

	@Override
	public List<ReserveRoom> findAllByUser(User user) {
		return this.reserveRoomRepostoriy.findAllByReserveuser(user);
	}

	@Override
	public void deleteByReservation(long Id) {
		this.reserveRoomRepostoriy.deleteById(Id);
		
	}

	@Override
	public List<ReserveRoom> findAllByHotel(Hotel hotel) {
		return this.reserveRoomRepostoriy.findAllByReserveHotel(hotel);
	}

	@Override
	public Optional<ReserveRoom> findById(Long Id) {
		// TODO Auto-generated method stub
		return this.reserveRoomRepostoriy.findById(Id);
	}

	

	
	

}
