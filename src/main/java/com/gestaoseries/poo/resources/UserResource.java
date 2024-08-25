package com.gestaoseries.poo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoseries.poo.entities.User;

//controlador REST que responde o caminho /users

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		
		User u = new User(1L, "evellyn", "evellyn@gmail.com", "8419640", "eve123");
		return ResponseEntity.ok().body(u);
		
	}
	
}
