package com.weshare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.model.Vote;

@Service
public interface VoteService {
	Vote findByPostAndUser(Post post, User user);
	 List<Vote> findByPost(Post post);
	 void save(Vote vote);
	 void delete(Vote vote);
	Vote findByVoteId(int voteId);
}
