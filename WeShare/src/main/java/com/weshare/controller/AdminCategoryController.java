package com.weshare.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.weshare.model.Category;
import com.weshare.model.Comment;
import com.weshare.model.Community;
import com.weshare.model.Post;
import com.weshare.service.CategoryService;
import com.weshare.service.CommentService;
import com.weshare.service.CommunityService;
import com.weshare.service.PostService;

@Controller
@RequestMapping("/admin")
public class AdminCategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommunityService communityService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/category/all")
	public String categoryList(Model m)
	{
		List<Category> categoryList = categoryService.getAllCategories();
		m.addAttribute("catList", categoryList);
		return "admin/categoryList";
	}
	
	@GetMapping("/category/insert")
	public String insertCategory(Model m)
	{
		Category c=new Category();
		m.addAttribute("category", c);
		return "admin/insertCategory";
	}
	
	@PostMapping("/category/save")
	public String saveCategory(@ModelAttribute("category")Category c)
	{
		categoryService.saveCategory(c);
		return "redirect:/admin/category/all";
	}
	
	
	@GetMapping("/category/update/{id}")
	public String updateCategory(@PathVariable("id")int cid, Model m)
	{
		Category c=categoryService.getCategoryById(cid);
		m.addAttribute("category", c);
		return "admin/updateCategory";
	}
	
	@GetMapping("/category/all/communities")
	public String communityList(Model m)
	{
		List<Category> categoryList = categoryService.getAllCategories();
		m.addAttribute("catList", categoryList);
		
		List<Community> communityList=communityService.getAllCommunities();
		m.addAttribute("comList", communityList);
		
		m.addAttribute("allCom",true);
//		return "user/FindAllCommunitiesByCategory";
		return "admin/getAllCommunities";
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
		
		return "admin/getAllCommunities";
	}
	
	@GetMapping("/community/{communityName}")
	public String singleCommunity(@PathVariable("communityName")String comName,Model m)
	{
		Community c = communityService.getCommunityByName(comName);
		m.addAttribute("com", c);
		
		List<Post> comunityPosts = c.getPosts().stream()
				  								.sorted(Comparator.comparing(Post::getCreationDate).reversed())
				  								.collect(Collectors.toList());
		m.addAttribute("comunityPosts", comunityPosts);
	
		return "admin/ViewCommunity";
	}
	
	@GetMapping("/community/{communityName}/{postId}")
	public String viewPost(Model model, HttpServletRequest request,
    						@PathVariable String communityName, @PathVariable int postId)
	{
		System.out.println("\n\n\n in ViewPost "+communityName+" "+postId+"\n\n\n");
		
		Post post=postService.getPostById(postId);
		model.addAttribute("post",post);
		List<Comment> comments=commentService.getCommentsByPost(post);
		model.addAttribute("comments",comments);
		return "admin/viewPost";
	}
	
}
