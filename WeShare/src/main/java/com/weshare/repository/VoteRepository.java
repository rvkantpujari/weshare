package com.weshare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.model.Vote;
@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer>
{
	Vote findByPostAndUser(Post post, User user);
	 List<Vote> findByPost(Post post);
	 
}
