package com.weshare.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weshare.model.Category;
import com.weshare.model.Community;
import com.weshare.model.User;
import com.weshare.service.CategoryService;
import com.weshare.service.CommunityService;
import com.weshare.service.UserService;

@Controller
@RequestMapping("/user/community")
public class CommunityController {

	@Autowired
	private CommunityService communityService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public String communityList(Model m)
	{
		List<Community> communityList = communityService.getAllCommunities();
		m.addAttribute("comList", communityList);
		
		return "user/communityList";	
	}
	
	@GetMapping("/insert")
	public String insertCommunity(Model m)
	{
		Community com=new Community();
		m.addAttribute("community", com);
		
		List<Category> categoryList = categoryService.getAllCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "user/insertCommunity";
	}
	
	@PostMapping("/save")
	public String saveCommunity(@ModelAttribute("community")Community com,	
									Principal principal)
	{
		User user=this.userService.findUserByUserName(principal.getName());
		com.setUser(user);		
		communityService.saveCommunity(com);
		return "redirect:/user/community/all";
	}
	


}
