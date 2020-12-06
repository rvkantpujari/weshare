package com.weshare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weshare.model.Category;
import com.weshare.model.Comment;
import com.weshare.service.CommentService;


@Controller
@RequestMapping("/user/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/insert")
	public String insertComment(Model m)
	{
		Comment c=new Comment();
		m.addAttribute("comment", c);
		return "user/addComment";
	}
	
	@GetMapping("/all")
	public String commentList(Model m)
	{
		List<Comment> commentList = commentService.getAllComments();
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
