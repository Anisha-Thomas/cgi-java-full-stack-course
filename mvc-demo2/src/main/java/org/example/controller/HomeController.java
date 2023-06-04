package org.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST,path = "/hello")
	public String welcomePage(HttpServletRequest request,Model theModel ) {
		theModel.addAttribute("fname", request.getParameter("firstname"));
		theModel.addAttribute("lname", request.getParameter("lastname"));
		theModel.addAttribute("email", request.getParameter("email"));
		return "hello";
	}
}
