package com.weshare.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weshare.model.Category;
import com.weshare.model.Community;
import com.weshare.model.Pager;
import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.service.CategoryService;
import com.weshare.service.CommunityService;
import com.weshare.service.PostService;
import com.weshare.service.SavePostService;
import com.weshare.service.UserService;
import com.weshare.service.VoteService;

@Controller
@RequestMapping("/user/community")
public class CommunityController {

	private static final int NUM_OF_BUTTONS = 5;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 10;
	private static final int[] PAGE_SIZES = { 5, 10, 15 };

	@Autowired
	private CommunityService communityService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private VoteService voteService;

	@Autowired
	private SavePostService savePostService;
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/insert")
	public String insertCommunity(Model m)
	{
		Community com=new Community();
		m.addAttribute("community", com);
		
		List<Category> categoryList = categoryService.getAllCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "user/createCommunity";
	}
	
	@PostMapping("/save")
	public String saveCommunity(@ModelAttribute("community")Community com,	
									Principal principal)
	{
		User user=this.userService.findUserByUserName(principal.getName());
		com.setUser(user);		
		communityService.saveCommunity(com);
		return "redirect:/user/category/all/communities";
	}
	
	@GetMapping("/{communityName}")
	public String viewSingleCommunity(
			@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page,
            @PathVariable("communityName") String comName,
            Principal principal, Model m)
	{
		Community c = communityService.getCommunityByName(comName);
		m.addAttribute("com", c);

		int setPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int setPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Post> communityPosts =  postService.findAllCommunityPostsByPage(c,
        		PageRequest.of(setPage, setPageSize, Sort.by(Sort.Direction.DESC, "creationDate")));
        
        Pager communityPostsPager = new Pager(communityPosts.getTotalPages(),
        		communityPosts.getNumber(), NUM_OF_BUTTONS);

		if (communityPosts.isEmpty()) {
			m.addAttribute("noPosts", true);
		}

		m.addAttribute("communityPostsPager", communityPostsPager);
		m.addAttribute("communityPosts", communityPosts);
		m.addAttribute("voteService", voteService);
		m.addAttribute("pageSizes", PAGE_SIZES);
		m.addAttribute("selectedPageSize", setPageSize);
		
		if (principal != null) {
			User user = userService.findUserByUserName(principal.getName());
			m.addAttribute("user", user);
			if (user.getJoinedCommunityList().contains(c)) {
				// m.addAttribute("communityName", comName);
				m.addAttribute("exist", true);
			} else {
				m.addAttribute("exist", false);
			}
			m.addAttribute("savePostService", savePostService);
		}
		else
			m.addAttribute("user", null);
		return "user/ViewCommunity";
	}
	
	@GetMapping("/{communityName}/top")
	public String viewSingleCommunityTop(
			@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page,
            @PathVariable("communityName") String comName,
            Principal principal, Model m)
	{
		Community c = communityService.getCommunityByName(comName);
		m.addAttribute("com", c);

		int setPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int setPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Post> communityPosts =  postService.findAllCommunityPostsByPage(c,
        		PageRequest.of(setPage, setPageSize, Sort.by(Sort.Direction.DESC, "score")));
        
        Pager communityPostsPager = new Pager(communityPosts.getTotalPages(),
        		communityPosts.getNumber(), NUM_OF_BUTTONS);

		if (communityPosts.isEmpty()) {
			m.addAttribute("noPosts", true);
		}

		m.addAttribute("communityPostsPager", communityPostsPager);
		m.addAttribute("communityPosts", communityPosts);
		m.addAttribute("voteService", voteService);
		m.addAttribute("pageSizes", PAGE_SIZES);
		m.addAttribute("selectedPageSize", setPageSize);
		
		if (principal != null) {
			User user = userService.findUserByUserName(principal.getName());
			m.addAttribute("user", user);
			if (user.getJoinedCommunityList().contains(c)) {
				// m.addAttribute("communityName", comName);
				m.addAttribute("exist", true);
			} else {
				m.addAttribute("exist", false);
			}
			m.addAttribute("savePostService", savePostService);
		}
		else
			m.addAttribute("user", null);
		return "user/ViewCommunity";
	}
	
	@GetMapping("/{communityName}/popular")
	public String viewSingleCommunityPopular(
			@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page,
            @PathVariable("communityName") String comName,
            Principal principal, Model m)
	{
		Community c = communityService.getCommunityByName(comName);
		m.addAttribute("com", c);

		int setPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int setPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Post> communityPosts =  postService.findAllCommunityPostsByPage(c,
        		PageRequest.of(setPage, setPageSize, Sort.by(Sort.Direction.DESC, "commentsNum")));
        
        Pager communityPostsPager = new Pager(communityPosts.getTotalPages(),
        		communityPosts.getNumber(), NUM_OF_BUTTONS);

		if (communityPosts.isEmpty()) {
			m.addAttribute("noPosts", true);
		}

		m.addAttribute("communityPostsPager", communityPostsPager);
		m.addAttribute("communityPosts", communityPosts);
		m.addAttribute("voteService", voteService);
		m.addAttribute("pageSizes", PAGE_SIZES);
		m.addAttribute("selectedPageSize", setPageSize);
		
		if (principal != null) {
			User user = userService.findUserByUserName(principal.getName());
			m.addAttribute("user", user);
			if (user.getJoinedCommunityList().contains(c)) {
				// m.addAttribute("communityName", comName);
				m.addAttribute("exist", true);
			} else {
				m.addAttribute("exist", false);
			}
			m.addAttribute("savePostService", savePostService);
		}
		else
			m.addAttribute("user", null);
		return "user/ViewCommunity";
	}
}
