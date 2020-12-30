package com.weshare.controller;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weshare.model.PasswordResetToken;
import com.weshare.model.User;
import com.weshare.service.UserService;
import com.weshare.utility.MailConstructor;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    
    @Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MailConstructor mailConstructor;
	
    @PostMapping("/registration")
    public String createNewUser(@Valid User user, BindingResult bindingResult, Model model,
    							HttpServletRequest request) {
        
    	model.addAttribute("classActiveRegister", true);
        User userExists = userService.findUserByUserName(user.getUserName());
        User emailExists = userService.findUserByEmail(user.getEmail());
        
        if (userExists != null) {
            bindingResult.rejectValue("userName", "error.user","Username already exists!");
        }
        
        if (emailExists != null) {
            bindingResult.rejectValue("email", "error.user","Email already exists!");
        }
        
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            userService.saveUser(user);
            
            String token = UUID.randomUUID().toString();
    		userService.createPasswordResetTokenForUser(user, token);
    		
    		String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    		
    		SimpleMailMessage email = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token, user);
    		
    		mailSender.send(email);
    		
            model.addAttribute("successMessage", "An email has been sent to you. "
            										+ "\n Please validate it to confirm your registration.");
            model.addAttribute("user", new User());
            return "index";
        }
    }
    
    @GetMapping("/confirmRegistration")
    public String confirmRegistration(Locale locale, @RequestParam("token") String token, Model model) 
	{
		PasswordResetToken passToken = userService.getPasswordResetToken(token);

		if (passToken == null) {
			String message = "Invalid Token.";
			model.addAttribute("errorMsg", message);
			return "redirect:/error";
		}
	  
		User user = passToken.getUser();
		if(user.getActive()==true) {
			model.addAttribute("classActiveRegister", true);
			model.addAttribute("alreadyVerified", "You have already verified. Go to login!");
			model.addAttribute("user", user);
			return "index";
		}
		
		user.setActive(true);
		userService.updateUser(user);
		
		model.addAttribute("user", user);
		model.addAttribute("classActiveRegister", true);
		model.addAttribute("verified", "You are successfully verified. Go to login!");
		return "index";
	}
    
}
