package com.example.springboot3todoapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Correct import statement
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springboot3todoapplication.models.ToDoItem;
import com.example.springboot3todoapplication.services.ToDoItemService;

import jakarta.validation.Valid;

@Controller
public class ToDoFormController {
	
	@Autowired
	private ToDoItemService todoItemService;
	
	@GetMapping("/create-todo")
	public String showCreateForm(@ModelAttribute("todoItem")ToDoItem todoItem) {
		return "new-todo-item";
	}
	
	@PostMapping("/todo")
	public String createToDoItem(@Valid ToDoItem todoItem, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "new-todo-item";
		}
		
		ToDoItem item = new ToDoItem();
		item.setDescription(todoItem.getDescription());
		item.setIsComplete(todoItem.getIsComplete());
		
		todoItemService.save(item); // Save the new item, not the original todoItem
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
        ToDoItem todoItem = todoItemService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        todoItemService.delete(todoItem);
        return "redirect:/";
    }
	
	@GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        ToDoItem todoItem = todoItemService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        model.addAttribute("todo", todoItem);
        return "edit-todo-item";
    }
	
	 @PostMapping("/todo/{id}")
	    public String updateTodoItem(@PathVariable("id") Long id, @Valid ToDoItem todoItem, BindingResult result, Model model) {

	        ToDoItem item = todoItemService
	                .getById(id)
	                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

	        item.setIsComplete(todoItem.getIsComplete());
	        item.setDescription(todoItem.getDescription());

	        todoItemService.save(item);

	        return "redirect:/";
	    }
}
