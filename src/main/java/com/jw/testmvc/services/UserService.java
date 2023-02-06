package com.jw.testmvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jw.testmvc.models.User;
import com.jw.testmvc.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public List<User> allUsers() {
		return userRepo.getAllUsers();
	}
	
	public User createUser(User u) {
		return userRepo.save(u);
	}
	
	public User byID(Long id) {
		Optional<User> opt = userRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}
	
	public void destroy(Long id) {
		userRepo.deleteById(id);
	}
	
}
