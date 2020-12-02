package com.weshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.weshare.model.User;
import com.weshare.service.UserService;

@Controller
public class HomeController {

	 @Autowired
	 private UserService userService;
	
	 @GetMapping(value={"/", "/login", "/registration"})
	 public String home(Model model)
	 {
		 User user = new User();
	     model.addAttribute("user", user);
	     return "index";
	 }
	 
	 
	 @GetMapping("/user/manageProfile")
	 public String manageProfile(Model model)
	 {
		 return "user/manageProfile";
	 }
	 
	 @GetMapping("/user/contact")
	 public String contact(Model model)
	 {
		 return "user/contact";
	 }
	 
	 @GetMapping("/user/createPost")
	 public String createPost(Model model)
	 {
		 model.addAttribute("loggedIn", true);
		 model.addAttribute("joined", false);
		 return "user/createPost";
	 }
	 
	 @GetMapping("/admin/home")
	 public String adminHome(Model model)
	 {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     User user = userService.findUserByUserName(auth.getName());
	     model.addAttribute("userName", "Welcome " + user.getUserName() + "/" + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
	     model.addAttribute("adminMessage","Content Available Only for Admin Role");
	     return "admin/home";
	 }
	    
	    
	 @GetMapping("/user/home")
	 public String userHome(Model model)
	 {
	     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     User user = userService.findUserByUserName(auth.getName());
	     model.addAttribute("userName", "Welcome " + user.getUserName() + "/" + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
	     model.addAttribute("userMessage","Content Available Only for User Role");
	     return "user/home";
	 }
	 @GetMapping(value= {"/admin/getFeedback"})
	 public String getFeedback(Model model)
	 {
		 model.addAttribute("loggedIn", true);
		 return "admin/getFeedback";	 
	 }
	 @GetMapping(value= {"/user/feedback"})
	 public String feedback(Model model)
	 {
		 model.addAttribute("loggedIn", true);
		 return "user/feedback";	 
	 }
}

