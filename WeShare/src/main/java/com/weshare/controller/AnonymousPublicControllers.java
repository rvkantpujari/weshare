package com.weshare.controller;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.weshare.model.Category;
import com.weshare.model.Comment;
import com.weshare.model.Community;
import com.weshare.model.Post;
import com.weshare.service.CategoryService;
import com.weshare.service.CommentService;
import com.weshare.service.CommunityService;
import com.weshare.service.PostService;

@Controller
public class AnonymousPublicControllers {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommunityService communityService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/home")
	public String visitorHome(Model model) {
		
		List<Post> posts = postService.getAllPosts().stream()
				  .sorted(Comparator.comparing(Post::getCreationDate).reversed())
				  .collect(Collectors.toList());
		List<Community> topCommunities = communityService.findTopCommunities(5);
		
		model.addAttribute("posts", posts);
		model.addAttribute("topCommunities", topCommunities);
		
		return "home";
	}

	@GetMapping("/category/all/communities")
	public String communityList(Model m)
	{
		List<Category> categoryList = categoryService.getAllCategories();
		m.addAttribute("catList", categoryList);
		
		List<Community> communityList=communityService.getAllCommunities();
		m.addAttribute("comList", communityList);
		
		m.addAttribute("allCom",true);
		return "getAllCommunities";
	}
	
	
	@GetMapping("/category/{categoryName}/communities")
	public String searchByCategory(@PathVariable("categoryName")String cname, Model m)
	{
		Category c=categoryService.getCategoryByName(cname);
		List<Community> communityList = communityService.findCommunitiesByCategory(c);
		
		if (communityList.isEmpty()) {
			m.addAttribute("emptyList", true);
		}
		
		m.addAttribute("comList", communityList);
		
		List<Category> categoryList = categoryService.getAllCategories();
		m.addAttribute("catList", categoryList);
		m.addAttribute("categoryName",cname);
		
		return "getAllCommunities";
	}
	
	@GetMapping("/community/{communityName}")
	public String singleCommunity(@PathVariable("communityName")String comName,Model m)
	{
		Community c = communityService.getCommunityByName(comName);
		m.addAttribute("com", c);
		
		List<Post> comunityPosts = c.getPosts().stream()
				  								.sorted(Comparator.comparing(Post::getCreationDate).reversed())
				  								.collect(Collectors.toList());
		if(comunityPosts.isEmpty())
		{
			m.addAttribute("noPosts", true);
		}
		m.addAttribute("comunityPosts", comunityPosts);
	
		return "viewCommunity";
	}
	
	@GetMapping("/community/{communityName}/{postId}")
	public String viewPost(Model model, HttpServletRequest request,
    						@PathVariable String communityName, @PathVariable int postId)
	{
		Post post=postService.getPostById(postId);
		model.addAttribute("post",post);
		List<Comment> comments=commentService.getCommentsByPost(post).stream()
  								.sorted(Comparator.comparing(Comment::getCreationDate).reversed())
  								.collect(Collectors.toList());
		if(comments.isEmpty())
		{
			model.addAttribute("noComments", true);
		}
		model.addAttribute("comments",comments);
		return "viewPost";
	}
	
	
	@PostMapping("/search")
    public String anonymousSearch(Model model, Principal principal,
    		@ModelAttribute("query") String query, @ModelAttribute("queryType") String queryType)
	{
		if(queryType.equals("post"))
		{
			List<Post> posts = postService.blurrySearch(query);
			if(posts.isEmpty())
			{
				model.addAttribute("noPosts", true);
				model.addAttribute("query", query);
			}
			model.addAttribute("posts", posts);
			return "searchResultPost";
		}
		else
		{
			List<Category> categoryList = categoryService.getAllCategories();
			model.addAttribute("catList", categoryList);
			
			List<Community> communities = communityService.blurrySearch(query);
			model.addAttribute("communities", communities);
			
			if(communities.isEmpty())
			{
				model.addAttribute("noCommunities", true);
				model.addAttribute("query", query);
			}
			
			return "searchResultCommunity";
		}
	}
	
	
}
