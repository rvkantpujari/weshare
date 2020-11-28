package com.weshare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weshare.model.Category;
import com.weshare.model.Community;
import com.weshare.service.CategoryService;
import com.weshare.service.CommunityService;
import com.weshare.service.UserService;

@Controller
@RequestMapping("/user")
public class UserCategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommunityService communityService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/CommunitiesByCategory/all")
	public String categoryList(Model m)
	{
		List<Category> categoryList = categoryService.getAllCategories();
		m.addAttribute("catList", categoryList);
		return "user/getCommunitiesByCategory";
	}
	
	@GetMapping("/category/{categoryName}/communities")
	public String searchByCategory(@PathVariable("categoryName")String cname, Model m)
	{
		Category c=categoryService.getCategoryByName(cname);
		List<Community> communityList = communityService.findCommunitiesByCategory(c);
		
		m.addAttribute("comList", communityList);
		return "user/getCommunitiesByCategory2";
	}
	
//	@RequestMapping("/searchByCategory")
//	public String searchByCategory(@RequestParam("category") String category,
//									Model model, Principal principal)
//	{		
//		if(principal!=null) {
//			String username = principal.getName();
//			User user = userService.findUserByUserName(username);
//			model.addAttribute("user", user);
//		}
//		
//		String classActiveCategory = "active"+category;
//		classActiveCategory = classActiveCategory.replaceAll("\\s+", "");
//		classActiveCategory = classActiveCategory.replaceAll("&", "");
//		model.addAttribute(classActiveCategory, true);
//		
//		List<Community> comList = cate.findByCategory(category);
//		
//		if (bookList.isEmpty()) {
//			model.addAttribute("emptyList", true);
//			return "bookshelf";
//		}
//		
//		model.addAttribute("bookList", bookList);
//		
//		return "bookshelf";
//	}
	
	
}
