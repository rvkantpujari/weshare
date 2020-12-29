package com.weshare.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weshare.model.Community;
import com.weshare.model.Pager;
import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.service.CommunityService;
import com.weshare.service.PostService;
import com.weshare.service.SavePostService;
import com.weshare.service.UserService;
import com.weshare.service.VoteService;

@Controller
@RequestMapping("/user/community")
public class JoinLeaveCommunityController {

	private static final int NUM_OF_BUTTONS = 5;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 10;
	private static final int[] PAGE_SIZES = { 5, 10, 15 };

	@Autowired
	private CommunityService communityService;

	@Autowired
	private UserService userService;

	@Autowired
	private VoteService voteService;

	@Autowired
	private SavePostService savePostService;
	
	@Autowired
	private PostService postService;

	@GetMapping("/{communityName}")
	public String viewSingleCommunity(
			@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page,
            @PathVariable("communityName") String comName,
            Principal principal, Model m)
	{
		Community c = communityService.getCommunityByName(comName);
		m.addAttribute("com", c);

//		List<Post> communityPosts = c.getPosts().stream().sorted(Comparator.comparing(Post::getCreationDate).reversed())
//				.collect(Collectors.toList());

		int setPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int setPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Post> communityPosts =  postService.findAllCommunityPostsByPage(c,
        		PageRequest.of(setPage, setPageSize, Sort.by(Sort.Direction.DESC, "creationDate")));
        
        Pager communityPostsPager = new Pager(communityPosts.getTotalPages(),
        		communityPosts.getNumber(), NUM_OF_BUTTONS);
        
		System.out.println("\n\nprint all post of : " + comName);
//		for (Post post : comunityPosts)
//		{
//			System.out.println("\n\npost title: "+post.getTitle());
//		}

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

	@GetMapping("/{communityName}/join")
	public String joinCommunity(@PathVariable("communityName") String comName, Principal principal, Model m) {

		User user = userService.findUserByUserName(principal.getName());
		Community c = communityService.getCommunityByName(comName);

		if (user.getJoinedCommunityList().contains(c)) {
			m.addAttribute("exist", true);
			return "redirect:/user/community/{communityName}";
		}
		c.setMembersCount(c.getMembersCount() + 1);

		user.getJoinedCommunityList().add(c);
		userService.updateUser(user);
		m.addAttribute("exist", true);
		return "redirect:/user/community/{communityName}";
//      return "user/ViewCommunity";
	}

	@GetMapping("/{communityName}/leave")
	public String leaveCommunity(@PathVariable("communityName") String comName, Principal principal, Model m) {

		User user = userService.findUserByUserName(principal.getName());

		Community c = communityService.getCommunityByName(comName);
		c.setMembersCount(c.getMembersCount() - 1 > 0 ? c.getMembersCount() - 1 : 0);
//        c.updateCommunity(c);

		user.getJoinedCommunityList().remove(c);
		userService.updateUser(user);
		m.addAttribute("exist", false);
		return "redirect:/user/community/{communityName}";
//      return "user/ViewCommunity";
	}

}
