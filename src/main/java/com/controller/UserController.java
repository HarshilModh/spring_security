package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/home")
	public String getHome() {
		System.out.println();
		return "Home";
	}
	@GetMapping("/public/signup")
	public String signUp() {
		return "signUp";
	}
	@GetMapping("/public/login")
	public String login() {
		return "login";
	}@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
}
