package org.demo;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String goHome() {
		return "welcome";
	}
}
