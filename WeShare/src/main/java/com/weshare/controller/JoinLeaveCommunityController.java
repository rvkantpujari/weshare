package com.weshare.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weshare.model.Community;
import com.weshare.model.User;
import com.weshare.service.CommunityService;
import com.weshare.service.UserService;

@Controller
@RequestMapping("/user/community")
public class JoinLeaveCommunityController {

	@Autowired
	private CommunityService communityService;

	@Autowired
	private UserService userService;

	@GetMapping("/{communityName}/join")
	public String joinCommunity(@PathVariable("communityName") String comName, Principal principal, Model m) {

		User user = userService.findUserByUserName(principal.getName());
		Community c = communityService.getCommunityByName(comName);

		if (user.getJoinedCommunityList().contains(c)) {
			m.addAttribute("exist", true);
			return "redirect:/user/community/{communityName}";
		}
		c.setMembersCount(c.getMembersCount() + 1);

		user.getJoinedCommunityList().add(c);
		userService.updateUser(user);
		m.addAttribute("exist", true);
		return "redirect:/user/community/{communityName}";
	}

	@GetMapping("/{communityName}/leave")
	public String leaveCommunity(@PathVariable("communityName") String comName, Principal principal, Model m) {

		User user = userService.findUserByUserName(principal.getName());

		Community c = communityService.getCommunityByName(comName);
		c.setMembersCount(c.getMembersCount() - 1 > 0 ? c.getMembersCount() - 1 : 0);

		user.getJoinedCommunityList().remove(c);
		userService.updateUser(user);
		m.addAttribute("exist", false);
		return "redirect:/user/community/{communityName}";
	}

}
