package com.weshare.service;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.weshare.model.Category;
import com.weshare.model.Community;

@Service
public interface CommunityService {

	public List<Community> getAllCommunities();
	
	public void saveCommunity(Community com);

	public Community getCommunityById(int id);

	public List<Community> findCommunitiesByCategory(Category c);
	
	public Community getCommunityByName(String communityName);

	List<Community> blurrySearch(String query);
	
//	public List<Community> getCommunityByCategory(String category);
}
