package com.hhhkk.eHotels.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity

@Table(name="bookedroom")
@Transactional
public class ReserveRoom {
		public ReserveRoom() {}
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long reserveId;
		
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "hotelId")
		private Hotel reserveHotel;
		@NotNull
		@NotEmpty
		private String arrivaldate;
		
		@NotNull
		@NotEmpty
		private String departuredate;
		

		@NotNull
		@NotEmpty
		private String room;


		@NotNull
		@NotEmpty
		private String guests;
		
		
		@NotNull
		@NotEmpty
		private String bedtype;
		
		private int statues=0;


	//	@NotNull
	//	@NotEmpty
		//@Email(message="email should be valid")
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "email")
		private User reserveuser;


		
		private String note;
}
