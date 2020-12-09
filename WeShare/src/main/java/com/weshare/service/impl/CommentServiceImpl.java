package com.weshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weshare.model.Comment;
import com.weshare.model.Post;
import com.weshare.repository.CommentRepository;
import com.weshare.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public void saveComment(Comment c) {
		commentRepository.save(c);
	}

	@Override
	public List<Comment> getAllComments() {
		return commentRepository.findAll();
	}

	@Override
	public List<Comment> getCommentsByPost(Post post) {
	
		return commentRepository.findByPost(post);
	}

	@Override
	public Comment findCommentById(int commentId)
	{
		return commentRepository.findById(commentId).get();
	}

	@Override
	public void deleteComment(Comment c) {
		commentRepository.delete(c);
	}

}
