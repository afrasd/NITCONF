package io.shraddha.controller;

import javax.validation.Valid;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.shraddha.model.ToDoItem;
import io.shraddha.model.PutFormData;
import io.shraddha.service.ToDoItemService;
import io.shraddha.repo.ToAddFormRepository;
import io.shraddha.repo.ToDoItemRepository;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/toreview")
//@RestController
//@RequestMapping("/api/toreview")
//@CrossOrigin(origins = "http://localhost:3001") // Allow requests from the React app
public class HomeController {

	 @Autowired
	    private ToDoItemService toReviewItemService;

	 @GetMapping("/history")
	    public ModelAndView showExpiredItems(Model model) {
	        // Get the current date
	        Date currentDate = new Date();

	        // Retrieve history items with dates less than the current date
	        List<ToDoItem> expiredItems = toReviewItemService.getExpiredItems(currentDate);

	        // Display expired items on the console
	        System.out.println("Expired Items:");
	        for (ToDoItem item : expiredItems) {
	            System.out.println(item.toString());
	        }

	        // Add the list to the model
	        model.addAttribute("expiredItems", expiredItems);

	        // Create and return a ModelAndView with the view name
	        return new ModelAndView("history");
	        
	    }
	    
	 // here were rendering it as a html view and not getting a json response, json repsonse makes it easier for integration with react js
	 //need to modify all instances of the api integration so that they return valid json responses for integration with react.js
	 
	    // Code snippet to fetch data from the database
//	    @GetMapping("/reviewed")
//	    public ModelAndView viewReviewedItems(Model model) {
//	        List<ToDoItem> reviewedItems = toReviewItemService.getReviewedItems();
//	        System.out.println("Number of reviewed items: " + reviewedItems.size());
//	        model.addAttribute("reviewedItems", reviewedItems);
//	        return new  ModelAndView("reviewed"); // Assuming "reviewed.html" is the view file for displaying reviewed items
//	    }
//		
	 @GetMapping("/reviewed")
	 public ResponseEntity<List<ToDoItem>> viewReviewedItems() {
	     List<ToDoItem> reviewedItems = toReviewItemService.getReviewedItems();
	     System.out.println("Number of reviewed items: " + reviewedItems.size());
	     return ResponseEntity.ok(reviewedItems);
	 }
	    @GetMapping("/toreview")
	    @CrossOrigin(origins = "http://localhost:3001/toreview")
	    public ModelAndView viewToReviewItems(Model model) {
	        List<ToDoItem> toReviewItems = toReviewItemService.getToReviewItemsWithSubmittedZero();
	        System.out.println("Number of items with submitted 0: " + toReviewItems.size());
	        model.addAttribute("toReviewItems", toReviewItems);
	        return new ModelAndView ("toreview");
	    }
	    //@CrossOrigin(origins = "http://localhost:3001/toreview")
	    @PostMapping("/toreview")
	    @CrossOrigin(origins = "http://localhost:3001/toreview")
	    public ModelAndView createToReview(@Valid @ModelAttribute("toreviewItem") ToDoItem toReviewItem, BindingResult result) {
	        if (result.hasErrors()) {
	            return new ModelAndView("toreview");
	        }

	        toReviewItemService.save(toReviewItem);
	        return new ModelAndView("toreview");
	        
	    }	


	    @Autowired
	    private ToDoItemRepository toDoItemRepository;
	    
	    @GetMapping("/submit")
	    public ModelAndView submit(@RequestParam("pdfId") String pdfId) {
	        System.out.println("PDF ID: " + pdfId);
	        ToDoItem toDoItem = toDoItemRepository.findByPdfId(pdfId);
	        toDoItem.setSubmited(1);
	        toDoItemRepository.save(toDoItem);
	        
	        return new ModelAndView("toreview"); 
	    }
	    
//	    @GetMapping("/submit")
//	    public ResponseEntity<String> submit1(@RequestParam("pdfId") String pdfId) {
//	        System.out.println("PDF ID: " + pdfId);
//	        ToDoItem toDoItem = toDoItemRepository.findByPdfId(pdfId);
//
//	        if (toDoItem != null) {
//	            toDoItem.setSubmited(1);
//	            toDoItemRepository.save(toDoItem);
//	            return ResponseEntity.ok("Submission successful");
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
		@Autowired
		private ToAddFormRepository toaddFormData;

	    @GetMapping("/form")
	    public ModelAndView showCreateForm(Model model) {
	        model.addAttribute("formItem", new PutFormData()); 
	        return new ModelAndView ("form"); 
	    }

	    @PostMapping("/form")
	    public ModelAndView createToForm(@Valid @ModelAttribute("formItem") PutFormData addFormItem, BindingResult result) {
	        if (result.hasErrors()) {
	            return new ModelAndView("form");
	        }

	        toaddFormData.save(addFormItem);
	        return new ModelAndView("/"); // Redirect to the home page or another appropriate page
	    }
}