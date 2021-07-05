package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home/index")
	public String index() {
		return "home/index";
	}
	
	@GetMapping("/home/about")
	public String about() {
		return "home/about";
	}
	
	@GetMapping("/home/contact")
	public String contact() {
		return "home/contact";
	}
	
	@GetMapping("/home/feedback")
	public String feedback() {
		return "home/feedback";
	}
}
