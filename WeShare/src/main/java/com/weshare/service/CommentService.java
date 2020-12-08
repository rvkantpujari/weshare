package com.weshare.service;

import java.util.List;

import com.weshare.model.Comment;
import com.weshare.model.Post;

public interface CommentService {
	
	public void saveComment(Comment c);
	
	public List<Comment> getAllComments();
	
	public List<Comment> getCommentsByPost(Post post);

}
