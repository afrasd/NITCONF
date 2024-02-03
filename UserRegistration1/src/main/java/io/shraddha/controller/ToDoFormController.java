package io.shraddha.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.shraddha.model.ToDoItem;
import io.shraddha.service.ToDoItemService;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/toreview")
public class ToDoFormController {

    @Autowired
    private ToDoItemService toReviewItemService;

    private final Map<Long, ToDoItem> formDataMap = new HashMap<>();

    @GetMapping("/create")
    public ModelAndView showCreateForm(Model model) {
        ToDoItem toReviewItem = new ToDoItem();
        model.addAttribute("toreviewItem", toReviewItem);

        // Retrieve stored form data if available
        if (formDataMap.containsKey(toReviewItem.getId())) {
            toReviewItem = formDataMap.get(toReviewItem.getId());
            model.addAttribute("toreviewItem", toReviewItem);
        }

        return new ModelAndView("edit-toreview");
    }

    @PostMapping("/create")
    public ModelAndView createToReview(@Valid @ModelAttribute("toreviewItem") ToDoItem toReviewItem, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("edit-toreview");
        }

        // Store form data for the given ToDoItem ID
        formDataMap.put(toReviewItem.getId(), toReviewItem);

        toReviewItemService.save(toReviewItem);
        return new ModelAndView("/"); // Redirect to the home page or another appropriate page
    }
}
