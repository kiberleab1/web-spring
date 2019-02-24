package com.hhhkk.eHotels.configurations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.hhhkk.eHotels.repositories.UserRepository;

@Component
public class UserCountInformation implements InfoContributor{
	
	private UserRepository userRepository;
	@Autowired
	public UserCountInformation(UserRepository userRepo) {
		this.userRepository=userRepo;
	}
	@Override
	public void contribute(Builder builder) {
		// TODO Auto-generated method stub
		long tacoCount=this.userRepository.count();
		Map<String, Object> tacoMap = new HashMap<String, Object>();
		tacoMap.put("UserCount",tacoCount);
		builder.withDetail("Taco-States",tacoMap);
		
	}

}
