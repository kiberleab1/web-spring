package com.hhhkk.eHotels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hhhkk.eHotels.domains.Comment;
import com.hhhkk.eHotels.domains.Hotel;

public interface CommentRepository extends CrudRepository<Comment,Long>{
	List<Comment> findByOnHotel(Hotel hotel);
}
