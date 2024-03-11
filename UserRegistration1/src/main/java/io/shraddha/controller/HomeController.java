package io.shraddha.controller;

import javax.validation.Valid;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import io.shraddha.model.ToDoItem;
import io.shraddha.model.PutFormData;
import io.shraddha.service.ToDoItemService;
import io.shraddha.repo.ToAddFormRepository;
import io.shraddha.repo.ToDoItemRepository;

import java.util.Date;


@RestController
@RequestMapping("/api/toreview")
public class HomeController {

	 @Autowired
	    private ToDoItemService toReviewItemService;
	 
	 @GetMapping("/notifications")
	    public ResponseEntity<List<ToDoItem>> getNotifications() {
	        Date currentDate = new Date();
	        Date twoDaysLater = new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000); // Two days later

	        List<ToDoItem> notifications = toReviewItemService.getNotifications(currentDate, twoDaysLater);

	        return new ResponseEntity<>(notifications, HttpStatus.OK);
	    }

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
	    
	    // Code snippet to fetch data from the database
	    @GetMapping("/reviewed")
	    public ModelAndView viewReviewedItems(Model model) {
	        List<ToDoItem> reviewedItems = toReviewItemService.getReviewedItems();
	        System.out.println("Number of reviewed items: " + reviewedItems.size());
	        model.addAttribute("reviewedItems", reviewedItems);
	        return new  ModelAndView("reviewed"); // Assuming "reviewed.html" is the view file for displaying reviewed items
	    }
//		  
	    @GetMapping("/toreview")
	    public ModelAndView viewToReviewItems(Model model) {
	        List<ToDoItem> toReviewItems = toReviewItemService.getToReviewItemsWithSubmittedZero();
	        System.out.println("Number of items with submitted 0: " + toReviewItems.size());
	        model.addAttribute("toReviewItems", toReviewItems);
	        return new ModelAndView ("toreview");
	    }
	    @PostMapping("/toreview")
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
	    public RedirectView submit(@RequestParam("pdfId") String pdfId) {
	        System.out.println("PDF ID: " + pdfId);
	        ToDoItem toDoItem = toDoItemRepository.findByPdfId(pdfId);
	        toDoItem.setSubmited(1);
	        toDoItemRepository.save(toDoItem);
	        
	        return new RedirectView("/api/toreview/toreview"); 
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
	    private ToAddFormRepository toAddFormData;

	    @GetMapping("/form")
	    public RedirectView getFormData(@RequestParam("pdfId") String pdfId) {
	        System.out.println("PDF ID: " + pdfId);

	        // Check if PutFormData already exists in the database for the given pdfId
	        List<PutFormData> existingDataList = toAddFormData.findByPdfId(pdfId);
	        if (!existingDataList.isEmpty()) {
	            // If data exists, retrieve the first item and return it
	            PutFormData existingData = existingDataList.get(0);
	            return new RedirectView("/api/toreview/form");
	        } else {
	            // If data does not exist, return an empty object
	        	return new RedirectView("/api/toreview/form");
	        }
	    }

	    @PostMapping("/form")
	    public RedirectView createToForm(@Valid @RequestBody PutFormData addFormItem) {
	        // Validate the incoming data
	        if (addFormItem == null) {
	        	 return new RedirectView("/api/toreview/form");
	        }

	        // Set the pdfId in the form item
	        String pdfId = addFormItem.getPdfId();
	        addFormItem.setPdfId(pdfId);

	        // Save or update the form data
	        toAddFormData.deleteByPdfId(pdfId);
	        toAddFormData.save(addFormItem);

	        return new RedirectView("/api/toreview/form");
	    }
	    //private ToDoItem itemchange = new ToDoItem();
	    
	    @GetMapping("/delete")
	    public RedirectView delete(@RequestParam("pdfId") String pdfId) {
	        System.out.println("PDF ID: " + pdfId);

	        // Your delete logic here
	        toDoItemRepository.deleteByPdfId(pdfId);

	        // Redirect to /toreview
	        return new RedirectView("/api/toreview/toreview");
	    }
	    
	    

}