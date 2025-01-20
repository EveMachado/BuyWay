package com.gestaoseries.poo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoseries.poo.entities.Category;

//ele vai ser resposavel por fazer operações com a entidade 'User'
//ele vai reutiizar o JpaRepository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}



