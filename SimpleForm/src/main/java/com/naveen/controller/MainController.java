package com.naveen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naveen.model.Student;
import com.naveen.service.StudentService;

@Controller
public class MainController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String listStudents(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("listStudents", studentService.getStudentsList());
		return "home";
	}

	// For add and update Student both
	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("Student") Student p) {

		if (p.getId() == 0) {
			// new Student, add it
			studentService.addStudent(p);
		} else {
			// existing Student, call update
			studentService.updateStudent(p);
		}

		return "redirect:/students";

	}

	@RequestMapping("/remove/{id}")
	public String removeStudent(@PathVariable("id") long id) {

		studentService.removeStudent(id);
		return "redirect:/students";
	}

	@RequestMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		model.addAttribute("listStudents", studentService.getStudentsList());
		return "home";
	}

}