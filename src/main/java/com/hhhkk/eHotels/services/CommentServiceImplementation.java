package com.hhhkk.eHotels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhhkk.eHotels.domains.Comment;
import com.hhhkk.eHotels.domains.Hotel;
import com.hhhkk.eHotels.repositories.CommentRepository;

@Service
public class CommentServiceImplementation implements CommentService {
	
	private CommentRepository commentRepository;
	
	@Autowired
	public CommentServiceImplementation(CommentRepository commentRepo) {
		this.commentRepository=commentRepo;
	}
	@Override
	public List<Comment> findByOnHotel(Hotel hotel) {
		return this.commentRepository.findByOnHotel(hotel);
	}
	@Override
	public void saveComment(Comment comment) {
		this.commentRepository.save(comment);
		
	}
	@Override
	public Comment findById(long Id) {
		Optional<Comment> com= this.commentRepository.findById(Id);
		return com.get();
	}
	@Override
	public void deleteComment(long Id) {
		this.commentRepository.deleteById(Id);
		
	}

}
