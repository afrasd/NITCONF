package io.shraddha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.shraddha.repo.ToDoItemRepository;
import io.shraddha.model.ToDoItem;

@RestController
public class PdfLinkController {

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    public PdfLinkController(ToDoItemRepository toDoItemRepository2) {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/pdf-link/{pdfId}")
    public String getPdfLink(@PathVariable String pdfId) {
        ToDoItem toDoItem = toDoItemRepository.findByPdfId(pdfId);
        if (toDoItem != null) {
            return toDoItem.getPdf_link();
        } else {
            // Handle case where no ToDoItem with the provided pdfId is found
            return "PDF link not found";
        }
    }
}
