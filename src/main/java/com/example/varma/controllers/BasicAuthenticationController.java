package com.example.varma.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.varma.vo.AuthenticationBean;

@CrossOrigin
@RestController
@RequestMapping("/basic")
public class BasicAuthenticationController {

	@GetMapping("/auth")
	public AuthenticationBean authenticate() {

		return new AuthenticationBean("You are authenticated");
	}
}
