package com.weshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.weshare.model.User;
import com.weshare.model.Post;

import com.weshare.service.impl.UserServiceImpl;
import com.weshare.service.impl.PostServiceImpl;
//import com.weshare.service.impl.CommunityServiceImpl;

@Controller
public class PostController
{
	private final UserServiceImpl userService;
	private final PostServiceImpl postService;
	
//	@Autowired
//    private CommunityServiceImpl communityService;
	@Autowired
    public PostController(UserServiceImpl userService,
    			PostServiceImpl postService) 
	{
        this.userService = userService;
        this.postService = postService;
    }
	
	@GetMapping("/createpost")
    public String getCreatePost(Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		model.addAttribute("use", user); 
        return "user/createPost";
    }
	@PostMapping("/createpost")
    public String addPost(Model model, HttpServletRequest request)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		model.addAttribute("use", user);
        System.out.println("\n\n\n create post\n\n\n");
        String title = request.getParameter("addtitle");
        String content = request.getParameter("addcontent");
        String link = request.getParameter("addLink");
        String imageUrl = request.getParameter("addImageUrl");
        String videoUrl = request.getParameter("addVideoUrl");
        String videoThumbnail = "/images/video-icon.png";
        String subRedditName = request.getParameter("addSubReddit");
        
        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setContent(content);
        newPost.setImageUrl(imageUrl);
        newPost.setLink(link);
        newPost.setVideoUrl(videoUrl);
        newPost.setVideoThumbnail(videoThumbnail);
        newPost.setSubReddit(subReddit);
        user.addPost(newPost);
        newPost.setUser(user);

        userService.save(user);
        postServiceDb.save(newPost);

		return "user/createPost";
    }
}
