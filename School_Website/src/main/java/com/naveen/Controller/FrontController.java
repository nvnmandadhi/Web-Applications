package com.naveen.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naveen.model.Student;
import com.naveen.service.StudentService;

@Controller
public class FrontController {

    @Autowired
    StudentService studentService;

    @Autowired
    UserDetailsService userService;

    @RequestMapping("/")
    public String home() {
	return "app.homepage";
    }

    @RequestMapping("/login")
    public String login() {
	return "app.login";
    }

    @RequestMapping("/about")
    public String about() {
	return "app.about";
    }

    @RequestMapping("/contact")
    public String contact() {
	return "app.contact";
    }

    @RequestMapping("/register")
    public String register() {
	return "app.register";
    }

    @RequestMapping("/users")
    public String users(Model model) {
	List<Student> users = studentService.findAll();
	model.addAttribute("students", users);
	return "app.admin";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerSubmit(@ModelAttribute("student") Student student) {

	studentService.addStudent(student);
	return "app.login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(@RequestParam("username") String username, Model model) {

	if (username.equals("admin") && username.equals("admin")) {
	    return "app.admin";
	} else {
	    UserDetails user = userService.loadUserByUsername(username);

	    if (user != null) {
		model.addAttribute("username", user.getUsername());
		return "redirect:app.userHome";
	    } else {
		return "redirect:error";
	    }
	}
    }

    /*
     * @RequestMapping("/logout") public String logoutPage(HttpServletRequest
     * request, HttpServletResponse response) { Authentication auth =
     * SecurityContextHolder.getContext().getAuthentication(); if (auth != null)
     * { new SecurityContextLogoutHandler().logout(request, response, auth); }
     * return "redirect:/login"; }
     */

}
