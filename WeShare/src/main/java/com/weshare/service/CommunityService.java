package com.weshare.service;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.weshare.model.Category;
import com.weshare.model.Community;

@Controller
public interface CommunityService {

	public List<Community> getAllCommunities();
	
	public void saveCommunity(Community com);

	public Community getCommunity(int id);

	public List<Community> findCommunitiesByCategory(Category c);
	
//	public List<Community> getCommunityByCategory(String category);
}
