package com.internsathi.springwebapp.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.internsathi.springwebapp.model.User;
import com.internsathi.springwebapp.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@ModelAttribute
	private void userDetails(Model model, Principal principal) {
		String email = principal.getName();
		User user = userRepository.findByEmail(email);
		model.addAttribute("user", user);
	}

	@GetMapping("/")
	public String home() {
		return "user/home";
	}
}
