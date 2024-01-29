package com.example.springboot3todoapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springboot3todoapplication.services.ToDoItemService;

@Controller
public class HomeController {
	@Autowired
	private ToDoItemService todoItemService;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("todoItems", todoItemService.getAll());
		return modelAndView;
	}
}
