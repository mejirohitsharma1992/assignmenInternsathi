package com.internsathi.springwebapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.internsathi.springwebapp.model.User;
import com.internsathi.springwebapp.service.UserService;
import com.mysql.cj.Session;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signIn")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/createUser")
	public String createUser(@ModelAttribute User user, HttpSession session) {
//        System.out.println(user);
		boolean f = userService.checkEmail(user.getEmail());
		if (f) {
			session.setAttribute("msg", "Email Id already exists");
		} else {
			User createdUser = userService.createUser(user);
			if (createdUser != null) {
				session.setAttribute("msg", "User registration successful");
			} else {
				session.setAttribute("msg", "Something went wrong on server");
			}
		}

		return "redirect:/register";
	}

}
