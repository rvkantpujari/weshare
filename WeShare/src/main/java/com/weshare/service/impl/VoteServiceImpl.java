package com.weshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.model.Vote;
import com.weshare.repository.VoteRepository;
import com.weshare.service.VoteService;

@Controller
public class VoteServiceImpl implements VoteService 
{
	@Autowired
	private VoteRepository voteRepository;
	
	@Override
	  public Vote findByPostAndUser(Post post, User user) {
		Vote vote = voteRepository.findByPostAndUser(post, user);
		if(vote == null)
			return null;
		return voteRepository.findById(vote.getVoteId()).get();
	  }

	  @Override
	  public List<Vote> findByPost(Post post) {
	    return voteRepository.findByPost(post);
	  }

	  @Override
	  public void save(Vote vote) {
	    voteRepository.save(vote);
	  }

	  @Override
	  public void delete(Vote vote) {
	    voteRepository.delete(vote);
	  }
	  @Override
	  public Vote findByVoteId(int voteId) {
	    return voteRepository.findById(voteId).get();
	  }
	  
}
