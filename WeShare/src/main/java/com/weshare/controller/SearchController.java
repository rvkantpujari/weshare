package com.weshare.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weshare.model.Category;
import com.weshare.model.Community;
import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.service.CategoryService;
import com.weshare.service.CommunityService;
import com.weshare.service.PostService;
import com.weshare.service.SavePostService;
import com.weshare.service.UserService;
import com.weshare.service.VoteService;

@Controller
@RequestMapping("/search")
public class SearchController
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private SavePostService savePostService;
	
	@Autowired
	private VoteService voteService;
	
	@Autowired
	private CommunityService communityServiceImpl;
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("")
    public String seach(Model model, Principal principal,
    		@ModelAttribute("query") String query, @ModelAttribute("queryType") String queryType)
	{
		System.out.println("inside search: " + queryType + " " + query);
		User user = principal!=null ? this.userService.findUserByUserName(principal.getName()) : null;
		if(user != null)
		{
			System.out.println("user is not null");
		}
		model.addAttribute("user", user);
		model.addAttribute("savePostService", savePostService);
		model.addAttribute("voteService", voteService);
		
		if(queryType.equals("post"))
		{
			List<Post> posts = postService.blurrySearch(query);
			if(posts.isEmpty())
			{
				model.addAttribute("noPosts", true);
				model.addAttribute("query", query);
			}
			model.addAttribute("posts", posts);
			return "user/searchResultPost";
		}
		else
		{
			List<Category> categoryList = categoryService.getAllCategories();
			model.addAttribute("catList", categoryList);
			
			List<Community> communities = communityServiceImpl.blurrySearch(query);
			model.addAttribute("communities", communities);
			
			if(communities.isEmpty())
			{
				model.addAttribute("noCommunities", true);
				model.addAttribute("query", query);
			}
			
			return "user/searchResultCommunity";
		}
	}
}
