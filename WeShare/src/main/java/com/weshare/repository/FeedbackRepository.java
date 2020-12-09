package com.weshare.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.weshare.model.Feedback;


@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
	

}
