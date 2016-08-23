package com.naveen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naveen.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submitLogin(@RequestParam("username") String username,@RequestParam("password") String password,Model model) {
		
		boolean status = studentService.authenticateUser(username, password);

		model.addAttribute("username",username);
		
		if (status) {
			return "adminHome";
		} else {
			return "error";
		}
	}
}
