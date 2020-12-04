package com.weshare.service;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.weshare.model.Category;
import com.weshare.model.Community;


public interface CommunityService {

	public List<Community> getAllCommunities();
	
	public void saveCommunity(Community com);

	public Community getCommunityById(int id);

	public List<Community> findCommunitiesByCategory(Category c);
	
	public Community getCommunityByName(String communityName);
	
//	public List<Community> getCommunityByCategory(String category);
}
