package com.weshare.service;

import java.util.List;


import com.weshare.model.Comment;

public interface CommentService {
	
	public void saveComment(Comment c);
	
	public List<Comment> getAllComments();

}
