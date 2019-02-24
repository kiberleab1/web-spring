package com.hhhkk.eHotels.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.ReadOnlyProperty;

import lombok.Data;

@Data
@Entity
@Table(name="comments")
@Transactional
public class Comment {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long Id;
		
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "hotelId")
		private Hotel onHotel;
	
		private String  onDate;
		

	//	@NotNull
	//	@NotEmpty
		//@Email(message="email should be valid")
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "email")
		private User byUser;


		
		private String Comment;
}