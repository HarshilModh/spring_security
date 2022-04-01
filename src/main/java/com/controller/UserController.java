package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.UserEntity;
import com.repository.UserRepository;

@Controller
//@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	BCryptPasswordEncoder bcrypt;

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
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

	@PostMapping("/public/saveuser")
	public String saveUser(UserEntity user) {

		System.out.println(user.getUsername());
		System.out.println(user.getPassword());// plain text
		user.setPassword(bcrypt.encode(user.getPassword()));
		
		user.setRole("ROLE_USER"); //prefix ROLE 
		userRepo.save(user); // insert

		return "";
	}
}
