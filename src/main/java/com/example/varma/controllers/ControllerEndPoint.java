package com.example.varma.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.varma.service.UserService;
import com.example.varma.vo.User;

//@CrossOrigin(origins = "http://localhost:4200/")
@Controller
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerEndPoint {

	@Autowired
	UserService userService;


	@GetMapping("/new")
	public String getDisplayForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "index";
	}

	@PostMapping("/save")
	// @ResponseBody
	public String saveUser(User user) {
		System.out.println(user);
		userService.saveUser(user);
		return "redirect:/users/new";
	}

	@GetMapping("/all")
	@ResponseBody
	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		User user1 = new User("Abhi", 20, "Male", "Hyderabad");
		User user2 = new User("Varma", 30, "Male", "Kakinada");
		User user3 = new User("Ram", 40, "Male", "Vizag");
		User user4 = new User("Nani", 35, "Male", "Hyderabad");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		if (false)
			throw new RuntimeException("Contact to help desk support !");
		return list;

	}

	// @PostMapping("/sav")
	@GetMapping("/sav")
	@ResponseBody
	// @RequestMapping(value = "/sav", method = RequestMethod.GET, consumes = {
	// "text/plain", "application/*" })
	public String userLogin(@RequestParam(value = "firstname") String firstname,
			@PathParam(value = "lastname") String lastname) {

		return "Welcome " + firstname + " " + lastname;
	}

	@GetMapping("/{name}")
	@ResponseBody
	public User getPath(@PathVariable String name) {
		User user = new User();
		user.setName(name);
		return user;

	}
}
