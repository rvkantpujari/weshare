package com.weshare.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.weshare.model.Community;
import com.weshare.model.Post;
@Service
public interface PostService
{
	public List<Post> getAllPosts();
	
	public void savePost(Post post);

	public Post getPostById(int id);
	
	public void setPostScoreById(int score, int postId);

	void setCommentsNumById(int postId, int commentNum);

	void deletePost(Post post);

	List<Post> blurrySearch(String query);
	
	Page<Post> findByPage(Pageable pageable);

	Page<Post> findAllPostsByPage(Community community, Pageable pageable);

	Page<Post> findByJoinedCommunitiesByPage(int userId, Pageable pageable);
}
