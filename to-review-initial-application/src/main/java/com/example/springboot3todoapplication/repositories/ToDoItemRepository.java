package com.example.springboot3todoapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot3todoapplication.models.ToDoItem;

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long>{

}
