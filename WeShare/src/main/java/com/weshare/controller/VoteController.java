package com.weshare.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.model.Vote;
import com.weshare.repository.PostRepository;
import com.weshare.service.PostService;
import com.weshare.service.UserService;
import com.weshare.service.VoteService;

@Controller
public class VoteController
{
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	
	@Autowired
	private VoteService voteService;
	@Autowired
	private PostRepository postRepository;
	
//	@Autowired
//    private CommunityServiceImpl communityService;
		
    @PostMapping("/upvote")
	public ResponseEntity<String> upvote(Model model, HttpServletRequest request,
			Principal principal)
	{
		int postId = Integer.parseInt(request.getParameter("postId"));
		System.out.println(" in upvote postid: "+postId);
		User user=this.userService.findUserByUserName(principal.getName());
		Post post = postService.getPostById(postId);
		System.out.println(" in upvote post : "+post.getTitle());
		System.out.println(" in upvote email : "+user.getEmail());
		Vote vote = voteService.findByPostAndUser(post, user);
		
        if (vote == null) {
            Vote upvote = new Vote(user, post, 1);
            voteService.save(upvote);
        } else if (vote.getVote() == -1) {
        	vote.setVote(1);
            voteService.save(vote);
        } else {
            post.getVotes().remove(vote);
            voteService.delete(vote);
        }
//        postRepository.setCustomScore(post.getVotes().stream().mapToInt(Vote::getVote).sum(), post.getPostId());
//        post.setScore(post.getVotes().stream().mapToInt(Vote::getVote).sum());
//        postService.savePost(post);
        int score = (post.getVotes().stream().mapToInt(Vote::getVote).sum());
        postService.setPostScoreById(score, postId);
        postService.savePost(post);
        model.addAttribute("voteService", voteService);
		return new ResponseEntity<>("success", 
				   HttpStatus.OK);
	}
	
	@PostMapping("/downvote")
	public ResponseEntity<String> downvote(Model model, HttpServletRequest request,
			Principal principal)
	{
		int postId = Integer.parseInt(request.getParameter("postId"));
		System.out.println(" in upvote postid: : "+postId);
		User user=this.userService.findUserByUserName(principal.getName());
		Post post = postService.getPostById(postId);
		Vote vote = voteService.findByPostAndUser(post, user);
        if (vote == null) {
            Vote downvote = new Vote(user, post, -1);
            voteService.save(downvote);
        } else if (vote.getVote() == 1) {
        	vote.setVote(-1);
            voteService.save(vote);
        } else {
            post.getVotes().remove(vote);
            voteService.delete(vote);
        }
        int score = (post.getVotes().stream().mapToInt(Vote::getVote).sum());
        postService.setPostScoreById(score, postId);
        postService.savePost(post);
        model.addAttribute("voteService", voteService);
        return new ResponseEntity<>("success", 
				   HttpStatus.OK);
	}
	
}
