package com.hhhkk.eHotels.services;

import java.util.List;

import com.hhhkk.eHotels.domains.Comment;
import com.hhhkk.eHotels.domains.Hotel;

public interface CommentService {
	List<Comment> findByOnHotel(Hotel hotel);
	void saveComment(Comment comment);
	Comment findById(long Id);
	void deleteComment(long Id);
}
