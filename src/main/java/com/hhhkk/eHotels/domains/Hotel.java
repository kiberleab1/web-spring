package com.hhhkk.eHotels.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="Hotel")

public class Hotel {
	public Hotel() {}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long hotelId;
	
	
	@NotNull(message="Hotel Name Cannot Be Empty")
	@NotEmpty(message="Hotel Name Cannot Be Empty")
	@Size(min=4,message="Hotel Name Cannot Be Empty")
	private String hotelName;
	
	@NotNull(message="Hotel Name Cannot Be Empty")
	@NotEmpty(message="Hotel Name Cannot Be Empty")
	@Size(min=4,message="City Cannot Be Empty")
	private String city;
	

	@NotNull(message="Hotel Name Cannot Be Empty")
	@NotEmpty(message="Hotel Name Cannot Be Empty")
	@Size(min=4,message="City Cannot Be Empty")
	private String subCity;
	

	
	private String phone;

	


	private short star;
	private String moto;
	private String description;
	
	@NotNull
	private short isConfirmed=0;

//	@OneToMany(targetEntity=Room.class)
//	private List<Room> rooms= new ArrayList<>();
	
//	public void addRoom(Room room) {
//		this.rooms.add(room);
//	}
	
	@OneToMany(mappedBy="hotel")
	private Set<User> user;

	
	@OneToMany(mappedBy="reserveHotel", cascade = CascadeType.PERSIST, 
            fetch = FetchType.LAZY)

    private Set<ReserveRoom> reserveRoom;
	
	@OneToMany(mappedBy="onHotel", cascade = CascadeType.PERSIST, 
            fetch = FetchType.LAZY)

    private Set<Comment> Commment;
	private User getUser() {
		return null;
	}
	
	
	
//
	@OneToMany(mappedBy="hotelId",cascade = CascadeType.PERSIST, 
            fetch = FetchType.LAZY)
	private Set<ImageModel> imageModel;
	

}
