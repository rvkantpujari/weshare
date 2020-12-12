package com.weshare.service;

import org.springframework.stereotype.Service;

import com.weshare.model.Post;
import com.weshare.model.User;

@Service
public interface SavePostService {
	boolean findByPostAndUser(Post post, User user);
}
