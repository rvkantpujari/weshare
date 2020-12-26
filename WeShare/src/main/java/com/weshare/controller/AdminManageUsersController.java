package com.weshare.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weshare.model.User;
import com.weshare.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminManageUsersController {

	@Autowired
	private UserService userService;
	
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
	
	
}
