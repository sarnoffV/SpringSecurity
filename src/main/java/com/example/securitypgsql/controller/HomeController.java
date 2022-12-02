package com.example.securitypgsql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securitypgsql.entities.Role;
import com.example.securitypgsql.entities.User;
import com.example.securitypgsql.repositories.RoleRepository;
import com.example.securitypgsql.service.UserService;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
    UserService userService;
    
	@GetMapping(value = "home")
	public String home() {
		return "Home";
	}
	
	@GetMapping(value = "admin")
	public String admin() {
		return "Admin";
	}
	
	@PostMapping(value = "ajouterRole")
	public Role addRole(@RequestBody Role role) {
		return roleRepository.save(role);
	}
	
	@PostMapping(value = "ajouterUser")
	public User addUser(@RequestBody User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userService.addUser(user);
	}
}