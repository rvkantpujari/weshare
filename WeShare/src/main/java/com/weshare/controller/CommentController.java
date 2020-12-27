package com.weshare.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weshare.model.Comment;
import com.weshare.model.Post;
import com.weshare.model.Role;
import com.weshare.model.User;
import com.weshare.repository.RoleRepository;
import com.weshare.service.CommentService;
import com.weshare.service.PostService;
import com.weshare.service.UserService;


@Controller
@RequestMapping("/user/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PostService postService;
	
	@Autowired UserService userService;
	
	@Autowired RoleRepository roleRepository;
	
	@PostMapping("/update")
	public ResponseEntity<String> updateComment(Model model,Principal principal,
		HttpServletRequest request)
	{
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		String content = request.getParameter("commentDescription");
		User user=this.userService.findUserByUserName(principal.getName());
		Comment comment = commentService.findCommentById(commentId);
		
		if(comment.getUser() == user)
		{
			comment.setContent(content);
			commentService.saveComment(comment);
		}
		
//		int postId = comment.getPost().getPostId();
//		String communityName = comment.getPost().getCommunity().getCommunityName();
		
		System.out.println("\n\nin update comment "+content + ' ' + commentId);
		
//		String redirectUrl = "/user/community/" + communityName + '/' + postId;
		return new ResponseEntity<>("success",
				   HttpStatus.OK);
	}
	
	@PostMapping("/delete/{commentId}")
	public ResponseEntity<String> deleteComment(Model model,Principal principal,
		HttpServletRequest request, @PathVariable int commentId)
	{
		User user=this.userService.findUserByUserName(principal.getName());
		Comment comment = commentService.findCommentById(commentId);
		Post post = comment.getPost();
//		int postId = comment.getPost().getPostId();
//		String communityName = comment.getPost().getCommunity().getCommunityName();
		
		if(comment.getUser()==user)
		{
			commentService.deleteComment(comment);
			postService.setCommentsNumById(post.getPostId(), post.getCommentsNum()-1);
			postService.savePost(post);
			System.out.println("\n\nsuccessfully deleted comment " + ' ' + commentId);
		}
		
		System.out.println("\n\nin delete comment " + ' ' + commentId);
		
//		String redirectUrl = "/user/community/" + communityName + '/' + postId;
		return new ResponseEntity<>("success",
				   HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public String commentList(Model m,HttpServletRequest request)
	{
		Post post=postService.getPostById(1);
		List<Comment> commentList = commentService.getCommentsByPost(post);
		m.addAttribute("comList", commentList);
		return "user/commentList";
	}
	
	@PostMapping("/save")
	public String saveComment(Model model, HttpServletRequest request,
    		Principal principal)
	{
		User user=this.userService.findUserByUserName(principal.getName());
		
		String content = request.getParameter("commentDescription");
		int postId = Integer.parseInt(request.getParameter("postId"));
		Post post=postService.getPostById(postId);

		Comment newComment = new Comment();
		newComment.setContent(content);
		newComment.setUser(user);
		newComment.setPost(post);
		commentService.saveComment(newComment);
		post.setCommentsNum(post.getCommentsNum()+1);
		postService.savePost(post);
		String redirectUrl = "/user/community/" + post.getCommunity().getCommunityName() + '/' + postId;

		return "redirect:" + redirectUrl;
	}

}
