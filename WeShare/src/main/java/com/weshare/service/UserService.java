package com.weshare.service;

import com.weshare.model.User;

public interface UserService {

	  public User findUserByEmail(String email);

	  public User findUserByUserName(String userName);
	  
	  public User saveUser(User user);
}
