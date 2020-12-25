package com.weshare.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.service.CommunityService;
import com.weshare.service.PostService;
import com.weshare.service.UserService;

@Controller
@RequestMapping("/user/post")
public class SaveUnsavePostController
{
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	@Autowired
	private CommunityService communityService;
	
	
	@PostMapping("/{postId}/save")
    public ResponseEntity<String> savePost(Model m, Principal principal, 
    							@PathVariable("postId") int postId )
	{
		User user=this.userService.findUserByUserName(principal.getName());
//		Community community = communityService.getCommunityByName(communityName);
		Post post=postService.getPostById(postId);
		System.out.println("\n\nin save post User:"+user.getUserName());
		System.out.println("\nin save post PostId"+postId);
        if(user.getSavedPostList().contains(post))
        {
        	System.out.println("post is already saved!!!");
        	m.addAttribute("saved", true);
        	return new ResponseEntity<>("success", 
 				   HttpStatus.OK);
        }

        user.getSavedPostList().add(post);
        userService.updateUser(user);
        m.addAttribute("saved", true);
        return new ResponseEntity<>("success", 
				   HttpStatus.OK);
    }
	
	@PostMapping("/{postId}/unsave")
    public ResponseEntity<String> unsavePost(Model m, Principal principal, 
    							@PathVariable("postId") int postId )
	{
		User user=this.userService.findUserByUserName(principal.getName());
//		Community community = communityService.getCommunityByName(communityName);
		Post post=postService.getPostById(postId);
		System.out.println("\n\nin unsave post User:"+user.getUserName());
		System.out.println("\nin unsave post PostId"+postId);
        if(!user.getSavedPostList().contains(post))
        {
        	m.addAttribute("saved", false);
        	return new ResponseEntity<>("success", 
 				   HttpStatus.OK);
        }

        user.getSavedPostList().remove(post);
        userService.updateUser(user);
        m.addAttribute("saved", false);
        return new ResponseEntity<>("success", 
				   HttpStatus.OK);
    }
    
	
}
