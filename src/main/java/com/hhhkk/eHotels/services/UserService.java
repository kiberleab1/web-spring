package com.hhhkk.eHotels.services;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.hhhkk.eHotels.domains.User;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User findUserByEmail(String email);
	void saveUser(User user);
	void saveHotelManager(User user);
	void saveAdminManager(User user);
	List<User> findAllUsersByRole(String role);
}
