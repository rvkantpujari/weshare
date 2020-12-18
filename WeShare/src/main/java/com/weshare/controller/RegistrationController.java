package com.weshare.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.weshare.model.User;
import com.weshare.service.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
        
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
            model.addAttribute("successMessage", "You have been registered successfully");
            model.addAttribute("user", new User());
            return "index";
        }
    }
 

}
