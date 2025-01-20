package com.gestaoseries.poo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoseries.poo.entities.Category;
import com.gestaoseries.poo.services.CategoryService;

//controlador REST que responde o caminho /users

//indica que esta classe é um controlador REST
@RestController
//define a URL base
@RequestMapping(value = "/categories")

public class CategoryResource {
	
	//dependencia
	@Autowired
	private CategoryService service;
	
	//anota o metodo para lidar com requisiçoes HTTP GET
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();	

		//retorna uma resposta HTTP com status ok e o corpo da resposta conté o objeto 'User' criado
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
}
