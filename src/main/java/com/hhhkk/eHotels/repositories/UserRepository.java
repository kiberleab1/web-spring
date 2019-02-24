package com.hhhkk.eHotels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.hhhkk.eHotels.domains.User;

public interface UserRepository extends CrudRepository<User,String>{

	//com.hhhkk.eHotels.domains.User findByEmail(String email);
	User findUserByEmail(String email);

	List<User> findAllByRole(String role);

	UserDetails findByEmail(String email);





}
