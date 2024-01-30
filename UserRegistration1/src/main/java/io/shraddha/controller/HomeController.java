package io.shraddha.controller;

import javax.validation.Valid;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.shraddha.model.ToDoItem;
import io.shraddha.service.ToDoItemService;

@Controller
public class HomeController {
    
    @Autowired
    private ToDoItemService toReviewItemService;

//    @GetMapping("/toreview")
//    public String showToReviewForm(Model model) {
//    	List<ToDoItem> toreviewItems = toReviewItemService.getAll();
//    	System.out.println("Number of items: " + toreviewItems.size());
//        for (ToDoItem item : toreviewItems) {
//            System.out.println("Paper Title: " + item.getTitle());
//            // Print other fields as needed
//        }
	    @GetMapping("/toreview")
	    public String viewToReviewItems(Model model) {
	        List<ToDoItem> toReviewItems = toReviewItemService.getAll();
	        System.out.println("Number of items: " + toReviewItems.size()); // Add this line for debugging
	        model.addAttribute("toReviewItems", toReviewItems);
	        //return "toreview"; // Assuming you want to view the items in the same "toreview.html"
	    
//    	model.addAttribute("toreviewItem", new ToDoItem());
    	//return "new-todo-item"; // Assuming "new-todo-item.html" is the correct Thymeleaf template
    	return "toreview";
    }
    @PostMapping("/toreview")
    public String createToReview(@Valid @ModelAttribute("toreviewItem") ToDoItem toReviewItem, BindingResult result) {
        if (result.hasErrors()) {
            return "toreview";
        }

        toReviewItemService.save(toReviewItem);
        return "redirect:/"; // Redirect to the home page or another appropriate page
    }
    
//    @PostMapping("/update-review")
//    public String updateReview(@RequestParam("action") String action,
//                               @RequestParam("id") Long id) {
//        // Assuming you have a service method to update the status based on the action
//        toReviewItemService.updateStatus(action, Collections.singletonList(id));
//
//        // Get the corresponding PDF ID
//        Optional<ToDoItem> optionalToDoItem = toReviewItemService.getById(id);
//        String pdfId = optionalToDoItem.map(ToDoItem::getPdfId).orElse("PDF ID not found");
//
//        // Print the PDF ID (you can modify this based on your logging needs)
//        System.out.println("PDF ID: " + pdfId);
//
//        return "redirect:/toreview"; // Redirect back to the to-review page
//    }
//    
}

