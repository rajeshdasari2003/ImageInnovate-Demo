package com.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.UserRepository;
import com.demo.model.UserEntity;
import com.demo.request.UserRequest;
import com.demo.service.UserService;



@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String saveDetails(List<UserRequest> requestList) {
	    if (requestList == null || requestList.isEmpty()) {
	        return "No user details to save.";
	    }

	    List<UserEntity> entities = requestList.stream()
	        .map(request -> {
	            UserEntity entity = new UserEntity();
	            entity.setName(request.getName());
	            entity.setPlays(request.getPlays());
	            return entity;
	        })
	        .collect(Collectors.toList());

	    userRepository.saveAll(entities);

	    return "User details saved successfully.";
	}


}
