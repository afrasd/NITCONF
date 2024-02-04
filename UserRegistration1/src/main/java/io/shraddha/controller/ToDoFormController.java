package io.shraddha.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import io.shraddha.model.ToDoItem;
import io.shraddha.service.ToDoItemService;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/toreview")
public class ToDoFormController {

    @Autowired
    private ToDoItemService toReviewItemService;

    private final Map<Long, ToDoItem> formDataMap = new HashMap<>();

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

    @PostMapping("/create")
    public String createToReview(@Valid @ModelAttribute("toreviewItem") ToDoItem toReviewItem, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-toreview";
        }

        // Store form data for the given ToDoItem ID
        formDataMap.put(toReviewItem.getId(), toReviewItem);

        toReviewItemService.save(toReviewItem);
        return "redirect:/"; // Redirect to the home page or another appropriate page
    }
}
