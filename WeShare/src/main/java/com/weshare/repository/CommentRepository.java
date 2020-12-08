package com.weshare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weshare.model.Comment;
import com.weshare.model.Post;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
	
	public List<Comment> findByPost(Post post);

}
