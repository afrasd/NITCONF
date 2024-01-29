package com.example.springboot3todoapplication.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot3todoapplication.models.ToDoItem;
import com.example.springboot3todoapplication.repositories.ToDoItemRepository;

@Service
public class ToDoItemService {
	@Autowired
	private ToDoItemRepository todoItemRepository;
	
	
	public Iterable<ToDoItem> getAll(){
		return todoItemRepository.findAll();
	}
	
	public Optional<ToDoItem> getById(Long id){
		return todoItemRepository.findById(id);
	}
	
	public ToDoItem save(ToDoItem todoItem) {
		if(todoItem.getId() == null) {
			todoItem.setCreatedAt(Instant.now());
		}
		
		todoItem.setUpdatedAt(Instant.now());
		return todoItemRepository.save(todoItem);
	}
	
	public void delete(ToDoItem todoItem) {
		todoItemRepository.delete(todoItem);
	}

}
