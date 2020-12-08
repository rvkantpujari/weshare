package com.weshare.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weshare.model.Comment;
import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.service.CommentService;
import com.weshare.service.PostService;
import com.weshare.service.UserService;


@Controller
@RequestMapping("/user/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PostService postService;
	
	@Autowired UserService userService;
	
	@GetMapping("/insert")
	public String insertComment(Model m,Principal principal)
	{
		User user=this.userService.findUserByUserName(principal.getName());
		Comment c=new Comment();
		m.addAttribute("comment", c);
		c.setUser(user);
		return "user/addComment";
	}
	
	@GetMapping("/all")
	public String commentList(Model m,HttpServletRequest request)
	{
		//int id=Integer.parseInt(request.getParameter(""));
		Post post=postService.getPostById(1);
		List<Comment> commentList = commentService.getCommentsByPost(post);
		m.addAttribute("comList", commentList);
		return "user/commentList";
	}
	
	@PostMapping("/save")
	public String saveComment(@ModelAttribute("comment")Comment c)
	{
		commentService.saveComment(c);
		return "redirect:/user/comment/all";
	}

}
