package com.weshare.service.impl;

import org.springframework.stereotype.Controller;

import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.service.SavePostService;

@Controller
public class SavePostServiceImpl implements SavePostService 
{
	@Override
	  public boolean findByPostAndUser(Post post, User user)
	{
		if(user!=null && user.getSavedPostList().contains(post))
			return true;
		return false;
	  }
	  
}
