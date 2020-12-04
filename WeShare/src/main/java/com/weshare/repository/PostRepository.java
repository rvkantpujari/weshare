package com.weshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weshare.model.Post;

public interface PostRepository extends JpaRepository<Post,Integer>
{
	
}
