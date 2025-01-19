package com.gestaoseries.poo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoseries.poo.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{

}
