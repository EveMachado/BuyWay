package com.gestaoseries.poo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoseries.poo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
