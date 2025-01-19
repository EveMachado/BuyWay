package com.gestaoseries.poo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoseries.poo.entities.Order;
import com.gestaoseries.poo.repositories.OrderRepository;


@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository repository;
	
	
	public List<Order> findAll(){
		return repository.findAll();
		
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = Optional.empty();
		return obj.get();
		
	}

}
