package com.jw.testmvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jw.testmvc.models.User;
import com.jw.testmvc.services.UserService;

@RestController
public class BooksApi {
	private final UserService uServ;
	
	public BooksApi(UserService uServ) {
		this.uServ = uServ;
	}
	
	@GetMapping("/api/users")
	public List<User> index() {
		return uServ.allUsers();
	}
	
	@PostMapping("/api/users")
	public User create(
			@RequestParam(value="first") String first,
			@RequestParam(value="last") String last,
			@RequestParam(value="email") String email
			) {
		
		User user = new User(first, last, email);
		return uServ.createUser(user);
	}
	
	@GetMapping("/api/users/{id}")
	public User show(@PathVariable("id") Long id) {
		User user = uServ.byID(id);
		return user;
	}
	
	@PutMapping("/api/users/{id}")
	public User update(
			@PathVariable("id")Long id,
			@RequestParam(value="first") String first,
			@RequestParam(value="last") String last,
			@RequestParam(value="email") String email
			){

		User user = uServ.byID(id);
		user.setEmail(email);
		user.setFirst(first);
		user.setLast(last);
		return uServ.createUser(user);
	}
	
	@PostMapping("/api/users/delete")
	public String destroy(@RequestParam(value="id")Long id) {
			uServ.destroy(id);
			return "You deleted user at id " + id;
	}
}
