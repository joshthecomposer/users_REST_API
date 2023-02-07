package com.jw.testmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jw.testmvc.models.User;
import com.jw.testmvc.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService uServ;
	
	@GetMapping("/users/{id}")
	public String viewOne(
			Model m,
			@PathVariable("id") Long id
			) {
		User u = uServ.byID(id);
		m.addAttribute("u", u);
		return "/show.jsp";
	}
	
	@GetMapping("/users")
	public String index(Model m) {
		m.addAttribute("users", uServ.allUsers());
		return "/index.jsp";
	}
	
}
