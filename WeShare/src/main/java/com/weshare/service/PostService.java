package com.weshare.service;

import java.util.List;

import com.weshare.model.Post;

public interface PostService
{
	public List<Post> getAllPosts();
	
	public void savePost(Post post);

	public Post getPostById(int id);
}
