package com.weshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.weshare.model.Post;

public interface PostRepository extends JpaRepository<Post,Integer>
{
}
