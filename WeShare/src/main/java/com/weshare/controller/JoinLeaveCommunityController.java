package com.weshare.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("/{communityName}/join")
	public ResponseEntity<String> joinCommunity(@PathVariable("communityName") String comName, Principal principal, Model m) {

		User user = userService.findUserByUserName(principal.getName());
		Community c = communityService.getCommunityByName(comName);

		if (user.getJoinedCommunityList().contains(c)) {
			return new ResponseEntity<>("success", 
					   HttpStatus.OK);
		}
		c.setMembersCount(c.getMembersCount() + 1);

		user.getJoinedCommunityList().add(c);
		userService.updateUser(user);
		return new ResponseEntity<>("success", 
				   HttpStatus.OK);
	}

	@PostMapping("/{communityName}/leave")
	public ResponseEntity<String> leaveCommunity(@PathVariable("communityName") String comName, Principal principal, Model m) {

		User user = userService.findUserByUserName(principal.getName());

		Community c = communityService.getCommunityByName(comName);
		c.setMembersCount(c.getMembersCount() - 1 > 0 ? c.getMembersCount() - 1 : 0);

		user.getJoinedCommunityList().remove(c);
		userService.updateUser(user);
		return new ResponseEntity<>("success", 
				   HttpStatus.OK);
	}

}
