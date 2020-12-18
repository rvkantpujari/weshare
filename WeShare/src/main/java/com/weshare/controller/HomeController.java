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
	
	 @GetMapping(value={"/", "/login"})
	 public String home(Model model)
	 {
		 User user = new User();
	     model.addAttribute("user", user);
	     model.addAttribute("classActiveLogin", true);
	     return "index";
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
}
