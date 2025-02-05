package com.gestaoseries.poo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gestaoseries.poo.entities.User;
import com.gestaoseries.poo.repositories.UserRepository;
import com.gestaoseries.poo.services.exceptions.DatabaseException;
import com.gestaoseries.poo.services.exceptions.ResourceNotFoundException;


@Service
public class UserService {
	
	//Para que o spring faça essa incerssão de dependencia de forma transparente
	@Autowired
	private UserRepository repository;
	
	//método para retornar todos os usuarios do banco de dado
	public List<User> findAll(){
		return repository.findAll();
		
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}
	
	//salvar no banco de dados um dado usuario
	public User insert(User obj) {
		   return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
		    throw new ResourceNotFoundException(id);
     	}catch (RuntimeException e) {
     		throw new DatabaseException(e.getMessage());
     	}
	}

	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		uptadeData(entity, obj);
		return repository.save(entity);
		
		}

	private void uptadeData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
}
