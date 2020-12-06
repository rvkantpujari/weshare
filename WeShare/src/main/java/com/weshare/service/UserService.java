package com.weshare.service;

import org.springframework.stereotype.Service;

import com.weshare.model.User;
@Service
public interface UserService {

	  public User findUserByEmail(String email);

	  public User findUserByUserName(String userName);
	  
	  public User saveUser(User user);

	User updateUser(User user);
}
