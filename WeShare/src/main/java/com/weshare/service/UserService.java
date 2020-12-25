package com.weshare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weshare.model.User;
@Service
public interface UserService {

	  public User findUserByEmail(String email);

	  public User findUserByUserName(String userName);
	  
	  public User saveUser(User user);
	  
	  public User updateUser(User user);
	 
	  public List<User> getAllUsers();
}