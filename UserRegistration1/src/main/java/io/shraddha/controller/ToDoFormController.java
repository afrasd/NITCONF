package io.shraddha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.shraddha.model.ToDoItem;
import io.shraddha.service.ToDoItemService;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@Controller
@RequestMapping("/toreview")
public class ToDoFormController {

    @Autowired
    private ToDoItemService toReviewItemService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("toreviewItem", new ToDoItem()); // Add an instance of ToDoItem to the model
        return "toreview"; // Assuming "new-todo-item.html" is in the "src/main/resources/templates" directory
    }

    @PostMapping("/create")
    public String createToReview(@Valid @ModelAttribute("toreviewItem") ToDoItem toReviewItem, BindingResult result) {
        if (result.hasErrors()) {
            return "toreview";
        }
        toReviewItemService.save(toReviewItem);
        return "redirect:/"; // Redirect to the home page or another appropriate page
    }
    

    @GetMapping("/history")
    public String showExpiredItems(Model model) {
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

        return "history";
    }
    
//    @PostMapping("/update-review")
//    public String updateReview(@RequestParam("action") String action,
//                               @RequestParam("id") Long id) {
//        // Print the corresponding PDF ID when Submit is clicked
//        System.out.println("PDF ID: " + id);
//
//        // Assuming you have a service method to update the status based on the action
//        toReviewItemService.updateStatus(action, Collections.singletonList(id));
//
//        return "redirect:/toreview"; // Redirect back to the to-review page
//    }
//  
    @PostMapping("/update-review")
    public String updateReview(@RequestParam("action") String action,
                               @RequestParam("id") Long id) {
        // Assuming you have a service method to update the status based on the action
        toReviewItemService.updateStatus(action, Collections.singletonList(id));

        // Get the corresponding PDF ID
        Optional<ToDoItem> optionalToDoItem = toReviewItemService.getById(id);
        String pdfId = optionalToDoItem.map(ToDoItem::getPdfId).orElse("PDF ID not found");

        // Print the PDF ID (you can modify this based on your logging needs)
        System.out.println("PDF ID: " + pdfId);

        return "redirect:/toreview"; // Redirect back to the to-review page
    }
    }
