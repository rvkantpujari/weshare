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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weshare.model.Category;
import com.weshare.model.Comment;
import com.weshare.model.Community;
import com.weshare.model.Feedback;
import com.weshare.model.Pager;
import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.service.CategoryService;
import com.weshare.service.CommentService;
import com.weshare.service.CommunityService;
import com.weshare.service.FeedbackService;
import com.weshare.service.PostService;
import com.weshare.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminControllers {
	
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
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("/feedbacks")
	public String feedbackList(Model m,HttpServletRequest request)
	{
		List<Feedback> feedbacktList = feedbackService.getAllFeedbacks();
		m.addAttribute("fdList", feedbacktList);
		return "admin/getFeedback";
	}
	
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
		
		m.addAttribute("communityPosts", communityPosts);
		m.addAttribute("communityPostsPager", communityPostsPager);
		m.addAttribute("pageSizes", PAGE_SIZES);
		m.addAttribute("selectedPageSize", setPageSize);
		
		return "admin/viewCommunity";
	}
	
	@GetMapping("/community/{communityName}/{postId}")
	public String viewPost(Model model, HttpServletRequest request,
    						@PathVariable String communityName, @PathVariable int postId)
	{
		System.out.println("\n\n\n in ViewPost "+communityName+" "+postId+"\n\n\n");
		
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
		return "admin/viewPost";
	}
	
	@GetMapping("/manageUsers")
	public String manageUsers(Model m)
	{
		
		List<User> userList = userService.getAllUsers();
		userList=userList.subList(1, userList.size());
		m.addAttribute("userList", userList);
		return "admin/manageUsers";
	}

	@GetMapping("/manageUsers/{userName}/block")
	public String blockUser(@PathVariable("userName")String userName,
    								Principal principal, Model m)
	{
		User user=userService.findUserByUserName(userName);
		if(user.getActive()==true)
		{
			user.setActive(false);
			userService.updateUser(user);
		}
		return "redirect:/admin/manageUsers";
	}
	
	@GetMapping("/manageUsers/{userName}/unblock")
	public String unblockUser(@PathVariable("userName")String userName,
    								Principal principal, Model m)
	{
		User user=userService.findUserByUserName(userName);
		if(user.getActive()==false)
		{
			user.setActive(true);
			userService.updateUser(user);
		}
		return "redirect:/admin/manageUsers";
	}
	
	@GetMapping("/community/{communityName}/{postId}/delete")
	public String deletePost(@PathVariable(value = "postId") int postId) {
		Post post = postService.getPostById(postId);
		List<User> users=userService.getAllUsers();
		for (User user : users) {
		     user.getSavedPostList().remove(post);
		     userService.updateUser(user);
		}
        
		this.postService.deletePost(post);
		return "redirect:/admin/home";
	}
	
	@PostMapping("/comment/delete/{commentId}")
	public ResponseEntity<String> deleteComment(@PathVariable(value = "commentId") int commentId) {
		Comment comment = commentService.findCommentById(commentId);
		System.out.println("\n\nin del comment: " + comment.getContent());
		Post post = comment.getPost();
		commentService.deleteComment(comment);
		postService.setCommentsNumById(post.getPostId(), post.getCommentsNum()-1);
		postService.savePost(post);
		System.out.println("\n\nsuccessfully deleted comment " + ' ' + commentId);
		return new ResponseEntity<>("success",
				   HttpStatus.OK);
	}
	
	
	@PostMapping("/search")
    public String adminSearch(Model model, Principal principal,
    		@ModelAttribute("query") String query, @ModelAttribute("queryType") String queryType)
	{
		System.out.println("inside admin search: " + queryType + " " + query);
		if(queryType.equals("post"))
		{
			List<Post> posts = postService.blurrySearch(query);
			if(posts.isEmpty())
			{
				model.addAttribute("noPosts", true);
				model.addAttribute("query", query);
			}
			model.addAttribute("posts", posts);
			return "admin/searchResultPost";
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
			
			return "admin/searchResultCommunity";
		}
	}
	
	
}
