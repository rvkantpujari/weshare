package com.weshare.controller;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.weshare.model.Community;
import com.weshare.model.Post;
import com.weshare.model.User;
import com.weshare.service.UserService;

@Controller
public class UserProfileController {

	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	 @GetMapping("/user/manageProfile")
	 public String manageProfile(Model m,Principal principal)
	 {
		 User user=this.userService.findUserByUserName(principal.getName());
		 m.addAttribute("u", user);
		 return "user/manageProfile";
	 }
	 
	 @PostMapping("/user/manageProfile/save")
	 public String updateProfile(@ModelAttribute("u")User u,Principal principal)
	 {
		 User userUpdate=this.userService.findUserByUserName(principal.getName());
		 userUpdate.setFirstName(u.getFirstName());
		 userUpdate.setLastName(u.getLastName());
		 userService.updateUser(userUpdate);
		 return "redirect:/user/manageProfile";
	 }
	 
	 @GetMapping("/user/changePassword")
	 public String changePassword(Model m,Principal principal)
	 {
		 User user=this.userService.findUserByUserName(principal.getName());
		 m.addAttribute("u", user);
		 return "user/changePassword";
	 }
	 
	 
	    @PostMapping("user/changePassword")
	    public String postUserPassword(Model m,HttpServletRequest request,Principal principal) {

	        User user=this.userService.findUserByUserName(principal.getName());

	        String oldPass=request.getParameter("oldPass");
	        String newPass=request.getParameter("newPass");
//	        System.out.println("oldPass:"+oldPass);
//	        System.out.println("newPass:"+newPass);
	        boolean isPasswordMatch = bCryptPasswordEncoder.matches(oldPass, user.getPassword());
	        
	        if(oldPass!=null && newPass!=null && isPasswordMatch==true) {
	        	user.setPassword(bCryptPasswordEncoder.encode(newPass));
	            userService.updateUser(user);
	            m.addAttribute("success", true);
	            
	        } else {
	            m.addAttribute("reject", true);
	        }
	        m.addAttribute("u", user);

	        return "user/changePassword";
	    }
	    
		 @GetMapping("/user/myCommunities")
		 public String myCommunities(Model m,Principal principal)
		 {
			 User user=this.userService.findUserByUserName(principal.getName());
			 m.addAttribute("u", user);
			 
			 if(user.getCommunities().isEmpty())
			 {
				 m.addAttribute("emptyList", true);
			 }
			 else
			 {
				 List<Community> myComList = user.getCommunities().stream()
						  .sorted(Comparator.comparing(Community::getCreationDate).reversed())
						  .collect(Collectors.toList());
				 
				 m.addAttribute("myComList", myComList);
			 }
			 return "user/myCommunities";
		 }
		 
		 
		    @GetMapping("/user/myPosts")
		    public String myPosts(Model m,Principal principal)
		    {
				User user=this.userService.findUserByUserName(principal.getName());
				m.addAttribute("u", user);
				
				 if(user.getPosts().isEmpty())
				 {
					 m.addAttribute("emptyList", true);
				 }
				 else
				 {
					 List<Post> myPostList = user.getPosts().stream()
							  .sorted(Comparator.comparing(Post::getCreationDate).reversed())
							  .collect(Collectors.toList());
					 m.addAttribute("myPostList", myPostList);
				 }
				
				
		        return "user/myPosts";
		    }
		    
		    @GetMapping("/user/myComments")
		    public String myComments(Model m,Principal principal) 
		    {
				User user=this.userService.findUserByUserName(principal.getName());
				m.addAttribute("u", user);
				

				return "user/myComments";
		    }	 
		 
		    
}
