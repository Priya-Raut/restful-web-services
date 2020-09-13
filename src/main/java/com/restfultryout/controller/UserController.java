package com.restfultryout.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restfultryout.model.entity.User;
import com.restfultryout.model.repository.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/users/{id}")
	public com.restfultryout.model.entity.User getUserWithId(@PathVariable long id) {
		return userRepository.findById(id).get();
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		Iterator<User> userIterator = userRepository.findAll().iterator();
		while(userIterator.hasNext()) {
			users.add(userIterator.next());
		}
		return users;
	}
	
	//update
	@PutMapping("/users")
	public void updateUserWithId(@PathVariable long id) {
		//question: how to accept what will change like name or birthday or both can change 
	}
	
	//delete
	@DeleteMapping("/user/{id}")
	public void deleteUserWithId(@PathVariable long id) {
		userRepository.deleteById(id);
	}
}
