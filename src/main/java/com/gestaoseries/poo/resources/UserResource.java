package com.gestaoseries.poo.resources;

import java.net.URI;
import java.net.URI;
import java.net.URI;
import java.net.URI;
import java.net.URI;
import java.net.URI;
import java.net.URI;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gestaoseries.poo.entities.User;
import com.gestaoseries.poo.services.UserService;

//controlador REST que responde o caminho /users

//indica que esta classe é um controlador REST
@RestController
//define a URL base
@RequestMapping(value = "/users")

public class UserResource {
	
	//dependencia
	@Autowired
	private UserService service;
	
	//anota o metodo para lidar com requisiçoes HTTP GET
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();	

		//retorna uma resposta HTTP com status ok e o corpo da resposta conté o objeto 'User' criado
		return ResponseEntity.ok().body(list);
		
	}
	
	//retornar o usuario por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	
}
