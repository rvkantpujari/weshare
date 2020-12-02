package com.weshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weshare.model.Comment;
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

}
