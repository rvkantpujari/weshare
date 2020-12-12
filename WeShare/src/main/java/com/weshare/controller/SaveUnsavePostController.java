package com.weshare.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weshare.model.Community;
import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.service.CommunityService;
import com.weshare.service.PostService;
import com.weshare.service.UserService;

@Controller
@RequestMapping("/user/community")
public class SaveUnsavePostController
{
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	@Autowired
	private CommunityService communityService;
	
	
	@GetMapping("/{communityName}/{postId}/save")
    public String savePost(Model m, Principal principal,
    							@PathVariable("communityName") String communityName , 
    							@PathVariable("postId") int postId )
	{
		User user=this.userService.findUserByUserName(principal.getName());
//		Community community = communityService.getCommunityByName(communityName);
		Post post=postService.getPostById(postId);
		System.out.println("\n\nUser:"+user.getUserName());
		System.out.println("\nComm:"+communityName);
		System.out.println("\nPostId"+postId);
        if(user.getSavedPostList().contains(post))
        {
        	m.addAttribute("saved", true);
        	return "redirect:/user/community/{communityName}";
        }

        user.getSavedPostList().add(post);
        userService.updateUser(user);
        m.addAttribute("saved", true);
        return "redirect:/user/community/{communityName}";
    }
	
	@GetMapping("/{communityName}/{postId}/unsave")
    public String unsavePost(Model m, Principal principal,
    							@PathVariable("communityName") String communityName , 
    							@PathVariable("postId") int postId )
	{
		User user=this.userService.findUserByUserName(principal.getName());
//		Community community = communityService.getCommunityByName(communityName);
		Post post=postService.getPostById(postId);
		System.out.println("\n\nUser:"+user.getUserName());
		System.out.println("\nComm:"+communityName);
		System.out.println("\nPostId"+postId);
        if(!user.getSavedPostList().contains(post))
        {
        	m.addAttribute("saved", false);
        	return "redirect:/user/community/{communityName}";
        }

        user.getSavedPostList().remove(post);
        userService.updateUser(user);
        m.addAttribute("saved", false);
        return "redirect:/user/community/{communityName}";
    }
    
	
}
