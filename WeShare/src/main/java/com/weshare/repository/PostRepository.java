package com.weshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.weshare.model.Post;
@Repository
public interface PostRepository extends JpaRepository<Post,Integer>
{

	 @Modifying
	 @Transactional
	 @Query("update Post p set p.score= :score where p.postId= :postId")
	 void setPostScoreById(int score, int postId);
}
