package com.jw.testmvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@PostMapping("/users")
	public String create(
			@Valid @ModelAttribute("user") User user,
			BindingResult result
			) {

		if (result.hasErrors()) {
			return "/create.jsp";
		}
			uServ.createUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/users/new")
	public String _new(
			@ModelAttribute("user") User user
			) {
		return "/create.jsp";
	}
	
	@RequestMapping("/users/{id}/edit")
	public String edit(
			@PathVariable("id") Long id,
			Model m
			) {
		User u = uServ.byID(id);
		System.out.println(u.getFirst());
		m.addAttribute("user", u);
		return "/edit.jsp";
	}
	
	@PutMapping("/users/{id}")
	public String update(
			@Valid @ModelAttribute("user") User u,
			BindingResult result
			) {
		if (result.hasErrors()) {
			return "/edit.jsp";
		} else {
			uServ.updateUser(u);
			return "redirect:/users";
		}
	}
	
}
