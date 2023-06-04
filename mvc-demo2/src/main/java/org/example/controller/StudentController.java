package org.example.controller;

import org.example.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")
public class StudentController {
	@GetMapping("/")
	public String showStudentForm(Model theModel) {
		theModel.addAttribute("student",new Student());
		return "studentForm";
	}
	@RequestMapping(path = "/processForm",method = RequestMethod.POST)
	public String processForm(@ModelAttribute("student") Student ss, Model theModel) {
		theModel.addAttribute("s", ss);
		return "processForm";
	}
}
