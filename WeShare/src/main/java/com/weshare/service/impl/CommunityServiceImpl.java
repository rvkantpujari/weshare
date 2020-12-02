package com.weshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weshare.model.Category;
import com.weshare.model.Community;
import com.weshare.repository.CommunityRepository;
import com.weshare.service.CommunityService;

@Service
public class CommunityServiceImpl implements CommunityService {

	@Autowired
	private CommunityRepository communityRepository;

	@Override
	public List<Community> getAllCommunities() {
		return communityRepository.findAll();
	}

	@Override
	public void saveCommunity(Community com) {
		communityRepository.save(com);
		
	}

	@Override
	public Community getCommunityById(int id) {
		return communityRepository.findById(id).get();
	}

	@Override
	public List<Community> findCommunitiesByCategory(Category c) {
		return communityRepository.findByCategory(c);
	}

	public Community getCommunityByName(String communityName) {
		return communityRepository.findByCommunityName(communityName);
	}

}
