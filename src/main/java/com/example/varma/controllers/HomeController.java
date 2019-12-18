package com.example.varma.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HomeController {

	@GetMapping(value = "/user")
	public String getMsg() {
		return new String("Welcome Message");
	}

}
