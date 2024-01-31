package io.shraddha.controller;

import javax.validation.Valid;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.shraddha.model.ToDoItem;
import io.shraddha.model.PutFormData;
import io.shraddha.service.ToDoItemService;
import io.shraddha.repo.ToAddFormRepository;
import io.shraddha.repo.ToDoItemRepository;
import java.util.Date;


@Controller
public class HomeController {
    
    @Autowired
    private ToDoItemService toReviewItemService;

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
    
    // Code snippet to fetch data from the database
    @GetMapping("/reviewed")
    public String viewReviewedItems(Model model) {
        List<ToDoItem> reviewedItems = toReviewItemService.getReviewedItems();
        System.out.println("Number of reviewed items: " + reviewedItems.size());
        model.addAttribute("reviewedItems", reviewedItems);
        return "reviewed"; // Assuming "reviewed.html" is the view file for displaying reviewed items
    }
//	  
    @GetMapping("/toreview")
    public String viewToReviewItems(Model model) {
        List<ToDoItem> toReviewItems = toReviewItemService.getToReviewItemsWithSubmittedZero();
        System.out.println("Number of items with submitted 0: " + toReviewItems.size());
        model.addAttribute("toReviewItems", toReviewItems);
        return "toreview";
    }
    @PostMapping("/toreview")
    public String createToReview(@Valid @ModelAttribute("toreviewItem") ToDoItem toReviewItem, BindingResult result) {
        if (result.hasErrors()) {
            return "toreview";
        }

        toReviewItemService.save(toReviewItem);
        return "redirect:/"; 
    }	


    @Autowired
    private ToDoItemRepository toDoItemRepository;
    
    @GetMapping("/submit")
    public String submit(@RequestParam("pdfId") String pdfId) {
        System.out.println("PDF ID: " + pdfId);
        ToDoItem toDoItem = toDoItemRepository.findByPdfId(pdfId);
        toDoItem.setSubmited(1);
        toDoItemRepository.save(toDoItem);
        
        return "redirect:/toreview"; 
    }

	@Autowired
	private ToAddFormRepository toaddFormData;

    @GetMapping("/form")
    public String showCreateForm(Model model) {
        model.addAttribute("formItem", new PutFormData()); 
        return "form"; 
    }

    @PostMapping("/form")
    public String createToForm(@Valid @ModelAttribute("formItem") PutFormData addFormItem, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }

        toaddFormData.save(addFormItem);
        return "redirect:/"; // Redirect to the home page or another appropriate page
    }
}
