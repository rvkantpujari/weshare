package com.weshare.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.weshare.model.Community;
import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.service.SavePostService;
import com.weshare.service.UserService;
import com.weshare.service.VoteService;
import com.weshare.service.impl.CommunityServiceImpl;
import com.weshare.service.impl.PostServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private PostServiceImpl postService;
	
	@Autowired
	private SavePostService savePostService;
	
	@Autowired
	private VoteService voteService;

	@Autowired
	private CommunityServiceImpl communityService;

	@GetMapping(value = { "/", "/login" })
	public String home(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("classActiveLogin", true);
		return "index";
	}

	@GetMapping("/admin/home")
	public String adminHome(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		model.addAttribute("userName", "Welcome " + user.getUserName() + "/" + user.getFirstName() + " "
				+ user.getLastName() + " (" + user.getEmail() + ")");
		model.addAttribute("adminMessage", "Content Available Only for Admin Role");
		return "admin/home";
	}

	@GetMapping("/user/home")
	public String userHome(Model model, Principal principal) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user=this.userService.findUserByUserName(principal.getName());
//	     model.addAttribute("userName", "Welcome " + user.getUserName() + "/" + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
//	     model.addAttribute("userMessage","Content Available Only for User Role");

		List<Post> posts = new ArrayList<Post>();
		
		for (Community community : user.getJoinedCommunityList())
		{
			for(Post post: community.getPosts())
			{
				posts.add(post);
			}
		}
		posts = posts.stream()
				  .sorted(Comparator.comparing(Post::getCreationDate).reversed())
				  .collect(Collectors.toList());
		
		Set<Community> joinedCommunities = user.getJoinedCommunityList();
		
		List<Community> topCommunities = communityService.findTopCommunities(5);
		
		model.addAttribute("posts", posts);
		model.addAttribute("savePostService",savePostService);
		model.addAttribute("voteService", voteService);
		model.addAttribute("user", user);
		model.addAttribute("joinedCommunities", joinedCommunities);
		model.addAttribute("topCommunities", topCommunities);
		return "user/home_new";
	}
}
