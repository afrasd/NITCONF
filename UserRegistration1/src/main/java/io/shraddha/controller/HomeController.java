//package io.shraddha.controller;
//
//import javax.validation.Valid;
//import java.util.List;
//import org.springframework.ui.Model;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import io.shraddha.model.ToDoItem;
//import io.shraddha.model.PutFormData;
//import io.shraddha.service.ToDoItemService;
//import io.shraddha.repo.ToAddFormRepository;
//import io.shraddha.repo.ToDoItemRepository;
//import java.util.Date;
//
//
//@Controller
//public class HomeController {
//    
//    @Autowired
//    private ToDoItemService toReviewItemService;
//
//    @GetMapping("/history")
//    public String showExpiredItems(Model model) {
//        // Get the current date
//        Date currentDate = new Date();
//
//        // Retrieve history items with dates less than the current date
//        List<ToDoItem> expiredItems = toReviewItemService.getExpiredItems(currentDate);
//
//        // Display expired items on the console
//        System.out.println("Expired Items:");
//        for (ToDoItem item : expiredItems) {
//            System.out.println(item.toString());
//        }
//
//        // Add the list to the model
//        model.addAttribute("expiredItems", expiredItems);
//
//        return "history";
//    }
//    
//    // Code snippet to fetch data from the database
//    @GetMapping("/reviewed")
//    public String viewReviewedItems(Model model) {
//        List<ToDoItem> reviewedItems = toReviewItemService.getReviewedItems();
//        System.out.println("Number of reviewed items: " + reviewedItems.size());
//        model.addAttribute("reviewedItems", reviewedItems);
//        return "reviewed"; // Assuming "reviewed.html" is the view file for displaying reviewed items
//    }
////	  
//    @GetMapping("/toreview")
//    public String viewToReviewItems(Model model) {
//        List<ToDoItem> toReviewItems = toReviewItemService.getToReviewItemsWithSubmittedZero();
//        System.out.println("Number of items with submitted 0: " + toReviewItems.size());
//        model.addAttribute("toReviewItems", toReviewItems);
//        return "toreview";
//    }
//    @PostMapping("/toreview")
//    public String createToReview(@Valid @ModelAttribute("toreviewItem") ToDoItem toReviewItem, BindingResult result) {
//        if (result.hasErrors()) {
//            return "toreview";
//        }
//
//        toReviewItemService.save(toReviewItem);
//        return "redirect:/"; 
//    }	
//
//
//    @Autowired
//    private ToDoItemRepository toDoItemRepository;
//    
//    @GetMapping("/submit")
//    public String submit(@RequestParam("pdfId") String pdfId) {
//        System.out.println("PDF ID: " + pdfId);
//        ToDoItem toDoItem = toDoItemRepository.findByPdfId(pdfId);
//        toDoItem.setSubmited(1);
//        toDoItemRepository.save(toDoItem);
//        
//        return "redirect:/toreview"; 
//    }
//
//    private PutFormData formchange = new PutFormData();
//
//    @Autowired
//    private ToAddFormRepository toaddFormData;
//
//    @GetMapping("/form")
//    public String showCreateForm(Model model, @RequestParam("pdfId") String pdfId) {
//        System.out.println("PDF ID: " + pdfId);
//        
//        // Set the pdfId in formchange
//        formchange.setPdfId(pdfId);
//        
//        // Check if PutFormData already exists in the database for the given pdfId
//        List<PutFormData> existingDataList = toaddFormData.findByPdfId(pdfId);
//        if (!existingDataList.isEmpty()) {
//            // If data exists, retrieve the first item and pass it to the form
//            PutFormData existingData = existingDataList.get(0);
//            model.addAttribute("formItem", existingData);
//        } else {
//            // If data does not exist, create a new instance of PutFormData
//            model.addAttribute("formItem", new PutFormData());
//        }
//        
//        return "form"; 
//    }
//
//    @PostMapping("/form")
//    public String createToForm(@Valid @ModelAttribute("formItem") PutFormData addFormItem, BindingResult result) {
//        if (result.hasErrors()) {
//            return "form";
//        }
//        toaddFormData.deleteByPdfId(formchange.getPdfId());
//        // Set the pdfId in the form item
//        addFormItem.setPdfId(formchange.getPdfId());
//        
//        // Save or update the form data
//        toaddFormData.save(addFormItem);
//        
//        return "redirect:/toreview"; // Redirect to the home page or another appropriate page
//    }
//
//    
//    @GetMapping("/delete")
//    public String delete(@RequestParam("pdfId") String pdfId) {
//        System.out.println("PDF ID: " + pdfId);
//
//        // Your delete logic here
//        toDoItemRepository.deleteByPdfId(pdfId);
//        
//        return "redirect:/toreview"; 
//    }
//    
//    @GetMapping("/display-all")
//    public String displayAll(@RequestParam("pdfId") String pdfId, Model model) {
//        System.out.println("PDF ID: " + pdfId);
//
//        // Retrieve all records from the to_form table with the specified pdfId
//        List<PutFormData> formDataList = toaddFormData.findByPdfId(pdfId);
//
//        // Add the retrieved records to the model for rendering in the Thymeleaf template
//        model.addAttribute("formDataList", formDataList);
//
//        return "display-all"; // Assuming you have a Thymeleaf template named display-all.html
//    }  
//}
package io.shraddha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import io.shraddha.model.ToDoItem;
import io.shraddha.model.PutFormData;
import io.shraddha.service.ToDoItemService;
import io.shraddha.repo.ToAddFormRepository;
import io.shraddha.repo.ToDoItemRepository;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

@RestController
public class HomeController {

    @Autowired
    private ToDoItemService toReviewItemService;

    @GetMapping("/api/v1.0/display-all")
    public ModelAndView displayAll(@RequestParam("pdfId") String pdfId) {
        List<PutFormData> formDataList = toaddFormData.findByPdfId(pdfId);
        return new ModelAndView("display-all", "formDataList", formDataList);
    }

    @GetMapping("/api/v1.0/history")
    public ModelAndView getExpiredItems() {
        // Get the current date
        Date currentDate = new Date();

        // Retrieve history items with dates less than the current date
        List<ToDoItem> expiredItems = toReviewItemService.getExpiredItems(currentDate);

        // Create a ModelAndView object and pass the data to the view
        ModelAndView modelAndView = new ModelAndView("history");
        modelAndView.addObject("expiredItems", expiredItems);
        return modelAndView;
    }

    @GetMapping("/api/v1.0/reviewed")
    public ModelAndView getReviewedItems() {
        List<ToDoItem> reviewedItems = toReviewItemService.getReviewedItems();

        // Create a ModelAndView object and pass the data to the view
        ModelAndView modelAndView = new ModelAndView("reviewed");
        modelAndView.addObject("reviewedItems", reviewedItems);
        return modelAndView;
    }

  @Autowired
  private ToDoItemRepository toDoItemRepository;
  
  @GetMapping("/api/v1.0/submit")
  public RedirectView submit(@RequestParam("pdfId") String pdfId) {
      System.out.println("PDF ID: " + pdfId);
      ToDoItem toDoItem = toDoItemRepository.findByPdfId(pdfId);
      toDoItem.setSubmited(1);
      toDoItemRepository.save(toDoItem);
      
      return new RedirectView("/api/v1.0/toreview", true);
  }

//    private PutFormData formchange = new PutFormData();
//
//    @Autowired
//    private ToAddFormRepository toaddFormData;
//
//    @GetMapping("/api/v1.0/form")
//    public ModelAndView showCreateForm(@RequestParam("pdfId") String pdfId) {
//        formchange.setPdfId(pdfId);
//        List<PutFormData> formDataList = toaddFormData.findByPdfId(pdfId);
//        return new ModelAndView("form", "formDataList", formDataList);
//    }
//
//    @PostMapping("/api/v1.0/form")
//    public void createToForm(@ModelAttribute("formItem") PutFormData addFormItem) {
//        toaddFormData.deleteByPdfId(formchange.getPdfId());
//        addFormItem.setPdfId(formchange.getPdfId());
//        toaddFormData.save(addFormItem);
//    }
// break
    
    
  private PutFormData formchange = new PutFormData();

  @Autowired
  private ToAddFormRepository toaddFormData;

  @GetMapping("/api/v1.0/form")
  public ModelAndView showCreateForm(Model model, @RequestParam("pdfId") String pdfId) {
      System.out.println("PDF ID: " + pdfId);
      
      // Set the pdfId in formchange
      formchange.setPdfId(pdfId);
      
      // Check if PutFormData already exists in the database for the given pdfId
      List<PutFormData> existingDataList = toaddFormData.findByPdfId(pdfId);
      if (!existingDataList.isEmpty()) {
          // If data exists, retrieve the first item and pass it to the form
          PutFormData existingData = existingDataList.get(0);
          model.addAttribute("formItem", existingData);
      } else {
          // If data does not exist, create a new instance of PutFormData
          model.addAttribute("formItem", new PutFormData());
      }
      
      return new ModelAndView("form"); 
  }

  @PostMapping("/api/v1.0/form")
  public ModelAndView createToForm(@Valid @ModelAttribute("formItem") PutFormData addFormItem, BindingResult result) {
      if (result.hasErrors()) {
    	  return new ModelAndView("form"); 
      }
      toaddFormData.deleteByPdfId(formchange.getPdfId());
      // Set the pdfId in the form item
      addFormItem.setPdfId(formchange.getPdfId());
      
      // Save or update the form data
      toaddFormData.save(addFormItem);
      
      return new ModelAndView("toreview"); // Redirect to the home page or another appropriate page
  }
  
    @GetMapping("/api/v1.0/delete")
    public ModelAndView delete(@RequestParam("pdfId") String pdfId) {
        toDoItemRepository.deleteByPdfId(pdfId);
        return new ModelAndView("toreview");
    }
    
    @GetMapping("/api/v1.0/toreview")
    public ModelAndView viewToReviewItems() {
        List<ToDoItem> toReviewItems = toReviewItemService.getToReviewItemsWithSubmittedZero();
        ModelAndView modelAndView = new ModelAndView("toreview");
        modelAndView.addObject("toReviewItems", toReviewItems);
        return modelAndView;
    }

    @PostMapping("/api/v1.0/toreview")
    public void createToReview(@ModelAttribute("toreviewItem") ToDoItem toReviewItem, BindingResult result) {
        if (!result.hasErrors()) {
            toReviewItemService.save(toReviewItem);
        }
    }
/*
	 @GetMapping("/api/v1.0/notifications")
	    public ResponseEntity<List<ToDoItem>> getNotifications() {
	        Date currentDate = new Date();
	        Date twoDaysLater = new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000); // Two days later

	        List<ToDoItem> notifications = toReviewItemService.getNotifications(currentDate, twoDaysLater);

	        return new ResponseEntity<>(notifications, HttpStatus.OK);
	    }
	 */
//    @GetMapping("/api/v1.0/notifications")
//    public ModelAndView getNotifications() {
//        Date currentDate = new Date();
//        Date twoDaysLater = new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000);
//
//        List<ToDoItem> notifications = toReviewItemService.getNotifications(currentDate, twoDaysLater);
//
//        ModelAndView modelAndView = new ModelAndView("notifications"); // Thymeleaf template name
//        modelAndView.addObject("notifications", notifications);
//
//        return new ModelAndView("notifications");
//    }
	   // private ToDoItem toReviewItemService;

	    @GetMapping("/api/v1.0/notifications")
	    public ModelAndView getNotifications() {
	        Date currentDate = new Date();
	        Date twoDaysLater = new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000);

	        List<ToDoItem> notifications = toReviewItemService.getNotifications(currentDate, twoDaysLater);

	        ModelAndView modelAndView = new ModelAndView("notifications");
	        modelAndView.addObject("notifications", notifications);

	        return modelAndView;
	    }
}
