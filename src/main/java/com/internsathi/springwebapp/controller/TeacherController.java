package com.internsathi.springwebapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.internsathi.springwebapp.model.Assignments;
import com.internsathi.springwebapp.repository.AssignmentRepository;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private AssignmentRepository assignmentRepository;
	@GetMapping("/")
	public String home() {
		return "teacher/home";
	}
	@PostMapping("/createAssignment")
	public String createAssignment(@ModelAttribute Assignments assignments,HttpSession session) {
		assignmentRepository.save(assignments);
		session.setAttribute("msg", "Assignment Added Successfully");
		return "redirect:teacher/add";
	}
	
	@GetMapping("/editAssignment")
	public String editAssignment() {
		return "teacher/edit";
	}
	
}
	
