package com.weshare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weshare.model.Post;
import com.weshare.model.User;
@Service
public interface PostService
{
	public List<Post> getAllPosts();
	
	public void savePost(Post post);

	public Post getPostById(int id);
	
	public void setPostScoreById(int score, int postId);
}
