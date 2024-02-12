package io.shraddha.controller;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import io.shraddha.model.ToDoItem;
import io.shraddha.service.ToDoItemService;

@Controller
@RequestMapping("/api/v1.0")
public class ToDoFormController {

    @Autowired
    private ToDoItemService toReviewItemService;

    private final Map<Long, ToDoItem> formDataMap = new HashMap<>();

    /**
     * showCreateForm
     * Controller method for displaying the create form
     * @param model : {@link Model} Model object to add attributes for the view
     * @return String: Returns the name of the view template for editing or creating a ToDoItem
     * @since 1.0
     * @author <a href="https://github.com/shraddhayelamarthy?tab=repositories"> Shraddha Yelamarthy</a>
     * @GetMapping("/create") // Specifies the mapping for handling GET requests to show the create form
     */
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        ToDoItem toReviewItem = new ToDoItem();
        model.addAttribute("toreviewItem", toReviewItem);

        // Retrieve stored form data if available
        if (formDataMap.containsKey(toReviewItem.getId())) {
            toReviewItem = formDataMap.get(toReviewItem.getId());
            model.addAttribute("toreviewItem", toReviewItem);
        }

        return "edit-toreview";
    }
    
    /**
     * createToReview
     * Controller method to handle form submission for creating a ToDoItem
     * @param toReviewItem : {@link ToDoItem} The ToDoItem object to be created
     * @param action : {@link String} The action parameter indicating the action to be performed
     * @param result : {@link BindingResult} BindingResult to capture validation errors, if any
     * @return String: Redirects to the home page or another appropriate page after successful creation
     * @since 1.0
     * @author <a href="https://github.com/shraddhayelamarthy?tab=repositories"> Shraddha Yelamarthy</a>
     */

    @PostMapping("/create")
    public String createToReview(@Valid @ModelAttribute("toreviewItem") ToDoItem toReviewItem, @RequestParam("action") String action, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-toreview";
        }

        // Store form data for the given ToDoItem ID
        formDataMap.put(toReviewItem.getId(), toReviewItem);

        toReviewItemService.save(toReviewItem);
        return "redirect:/"; // Redirect to the home page or another appropriate page
    }
}
