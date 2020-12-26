package com.weshare.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.weshare.model.Feedback;
import com.weshare.model.User;
import com.weshare.service.FeedbackService;
import com.weshare.service.UserService;


@Controller
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired 
	private UserService userService;
	
	@GetMapping("/user/contact")
	public String insertFeedback(Model m,Principal principal)
	{
		Feedback feedback=new Feedback();
		if(principal!=null)
		{
			User user=this.userService.findUserByUserName(principal.getName());
			m.addAttribute("user", user);
			feedback.setEmail(user.getEmail());
		}
		m.addAttribute("feedback", feedback);		
		return "user/contact";
	}
	
	@PostMapping("/user/contact")
	public String saveFeedback(@ModelAttribute("feedback")Feedback fd,Model m)
	{
		feedbackService.saveFeedback(fd);
		m.addAttribute("success", true);
		return "user/contact";
	}
	
}