package com.weshare.controller;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weshare.model.Category;
import com.weshare.model.Comment;
import com.weshare.model.Community;
import com.weshare.model.Pager;
import com.weshare.model.Post;
import com.weshare.service.CategoryService;
import com.weshare.service.CommentService;
import com.weshare.service.CommunityService;
import com.weshare.service.PostService;

@Controller
public class AnonymousPublicControllers {
	
	private static final int NUM_OF_BUTTONS = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {5, 10, 15};
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommunityService communityService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping(value = {"/", "/home"})
	public String visitorHome(Model model,
			@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page)
	{
		int setPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int setPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        
        Page<Post> posts = postService.findAlPostsByPage(
				PageRequest.of(setPage, setPageSize, Sort.by(Sort.Direction.DESC, "creationDate")));
		
		Pager postsPager = new Pager(posts.getTotalPages(),
				posts.getNumber(), NUM_OF_BUTTONS);
		
		List<Community> topCommunities = communityService.findTopCommunities(5);
		
		model.addAttribute("posts", posts);
		model.addAttribute("postsPager", postsPager);
		model.addAttribute("pageSizes", PAGE_SIZES);
		model.addAttribute("selectedPageSize", setPageSize);
		model.addAttribute("topCommunities", topCommunities);
		
		return "home";
	}
	
	@GetMapping("/home/top")
	public String visitorHomeTop(Model model,
			@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page)
	{
		int setPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int setPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        
        Page<Post> posts = postService.findAlPostsByPage(
				PageRequest.of(setPage, setPageSize, Sort.by(Sort.Direction.DESC, "score")));
		
		Pager postsPager = new Pager(posts.getTotalPages(),
				posts.getNumber(), NUM_OF_BUTTONS);
		
		List<Community> topCommunities = communityService.findTopCommunities(5);
		
		model.addAttribute("posts", posts);
		model.addAttribute("postsPager", postsPager);
		model.addAttribute("pageSizes", PAGE_SIZES);
		model.addAttribute("selectedPageSize", setPageSize);
		model.addAttribute("topCommunities", topCommunities);
		
		return "home";
	}
	
	@GetMapping("/home/popular")
	public String visitorHomePopular(Model model,
			@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page)
	{
		int setPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int setPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        
        Page<Post> posts = postService.findAlPostsByPage(
				PageRequest.of(setPage, setPageSize, Sort.by(Sort.Direction.DESC, "commentsNum")));
		
		Pager postsPager = new Pager(posts.getTotalPages(),
				posts.getNumber(), NUM_OF_BUTTONS);
		
		List<Community> topCommunities = communityService.findTopCommunities(5);
		
		model.addAttribute("posts", posts);
		model.addAttribute("postsPager", postsPager);
		model.addAttribute("pageSizes", PAGE_SIZES);
		model.addAttribute("selectedPageSize", setPageSize);
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
	public String singleCommunity(@PathVariable("communityName")String comName,Model m,
			@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page)
	{
		Community c = communityService.getCommunityByName(comName);
		m.addAttribute("com", c);
		
		int setPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int setPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Post> communityPosts =  postService.findAllCommunityPostsByPage(c,
        		PageRequest.of(setPage, setPageSize, Sort.by(Sort.Direction.DESC, "creationDate")));
        
        Pager communityPostsPager = new Pager(communityPosts.getTotalPages(),
        		communityPosts.getNumber(), NUM_OF_BUTTONS);
        
		if(communityPosts.isEmpty())
		{
			m.addAttribute("noPosts", true);
		}
		
		m.addAttribute("communityName", comName);
		m.addAttribute("communityPostsPager", communityPostsPager);
		m.addAttribute("communityPosts", communityPosts);
		m.addAttribute("pageSizes", PAGE_SIZES);
		m.addAttribute("selectedPageSize", setPageSize);
	
		return "viewCommunityVisitor";
	}
	
	@GetMapping("/community/{communityName}/top")
	public String singleCommunityTop(@PathVariable("communityName")String comName,Model m,
			@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page)
	{
		Community c = communityService.getCommunityByName(comName);
		m.addAttribute("com", c);
		
		int setPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int setPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Post> communityPosts =  postService.findAllCommunityPostsByPage(c,
        		PageRequest.of(setPage, setPageSize, Sort.by(Sort.Direction.DESC, "score")));
        
        Pager communityPostsPager = new Pager(communityPosts.getTotalPages(),
        		communityPosts.getNumber(), NUM_OF_BUTTONS);
        
		if(communityPosts.isEmpty())
		{
			m.addAttribute("noPosts", true);
		}
		
		m.addAttribute("communityName", comName);
		m.addAttribute("communityPostsPager", communityPostsPager);
		m.addAttribute("communityPosts", communityPosts);
		m.addAttribute("pageSizes", PAGE_SIZES);
		m.addAttribute("selectedPageSize", setPageSize);
	
		return "viewCommunityVisitor";
	}
	
	@GetMapping("/community/{communityName}/popular")
	public String singleCommunityPopular(@PathVariable("communityName")String comName,Model m,
			@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page)
	{
		Community c = communityService.getCommunityByName(comName);
		m.addAttribute("com", c);
		
		int setPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int setPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Post> communityPosts =  postService.findAllCommunityPostsByPage(c,
        		PageRequest.of(setPage, setPageSize, Sort.by(Sort.Direction.DESC, "commentsNum")));
        
        Pager communityPostsPager = new Pager(communityPosts.getTotalPages(),
        		communityPosts.getNumber(), NUM_OF_BUTTONS);
        
		if(communityPosts.isEmpty())
		{
			m.addAttribute("noPosts", true);
		}
		
		m.addAttribute("communityName", comName);
		m.addAttribute("communityPostsPager", communityPostsPager);
		m.addAttribute("communityPosts", communityPosts);
		m.addAttribute("pageSizes", PAGE_SIZES);
		m.addAttribute("selectedPageSize", setPageSize);
	
		return "viewCommunityVisitor";
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
