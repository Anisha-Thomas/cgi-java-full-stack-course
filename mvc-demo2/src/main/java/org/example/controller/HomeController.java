package org.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST,path = "/hello")
	public String welcomePage(HttpServletRequest request ) {
		request.setAttribute("fname", request.getParameter("firstname"));
		request.setAttribute("lname", request.getParameter("lastname"));
		request.setAttribute("email", request.getParameter("email"));
		return "hello";
	}
}
