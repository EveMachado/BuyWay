package com.gestaoseries.poo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoseries.poo.entities.OrderItem;
import com.gestaoseries.poo.entities.pk.OrderItemPk;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk>{

}



