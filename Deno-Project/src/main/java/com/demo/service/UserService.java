package com.demo.service;

import java.util.List;

import com.demo.request.UserRequest;


public interface UserService {
	
	public String saveDetails(List<UserRequest> requestList);

}
