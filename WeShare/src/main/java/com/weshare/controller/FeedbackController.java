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

import com.weshare.model.Comment;
import com.weshare.model.Feedback;
import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.service.FeedbackService;
import com.weshare.service.PostService;
import com.weshare.service.UserService;


@Controller
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired 
	private UserService userService;
	
	@GetMapping("/user/feedback/insert")
	public String insertFeedback(Model m,Principal principal)
	{
		User user=this.userService.findUserByUserName(principal.getName());
		m.addAttribute("user", user);
		return "user/addComment";
	}
	
	@GetMapping("/admin/feedback/all")
	public String commentList(Model m,HttpServletRequest request)
	{
		List<Feedback> feedbacktList = feedbackService.getAllFeedbacks();
		m.addAttribute("fdList", feedbacktList);
		return "user/commentList";
	}
	
	@PostMapping("/save")
	public String saveFeedback(@ModelAttribute("feedback")Feedback fd)
	{
		feedbackService.saveFeedback(fd);
		return "redirect:/user/home";
	}

}
