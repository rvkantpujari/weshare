package com.weshare.service;

import java.util.List;

import com.weshare.model.Feedback;

public interface FeedbackService {
	
	public void saveFeedback(Feedback fd);
	
	public List<Feedback> getAllFeedbacks();
	

}
