package com.gestaoseries.poo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoseries.poo.entities.Category;
import com.gestaoseries.poo.repositories.CategoryRepository;


@Service
public class CategoryService {
	
	//Para que o spring faça essa incerssão de dependencia de forma transparente
	@Autowired
	private CategoryRepository repository;
	
	//método para retornar todos os usuarios do banco de dado
	public List<Category> findAll(){
		return repository.findAll();
		
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
		
	}

}
