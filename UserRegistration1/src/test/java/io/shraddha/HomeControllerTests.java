package io.shraddha;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import io.shraddha.controller.HomeController;
import io.shraddha.model.PutFormData;
import io.shraddha.model.ToDoItem;
import io.shraddha.repo.ToAddFormRepository;
import io.shraddha.repo.ToDoItemRepository;
import io.shraddha.service.ToDoItemService;

@ExtendWith(MockitoExtension.class)
public class HomeControllerTests {

    @Mock
    private ToDoItemService toDoItemService;

    @Mock
    private ToDoItemRepository toDoItemRepository;

    @Mock
    private ToAddFormRepository toAddFormRepository;

    @InjectMocks
    private HomeController homeController;

    

        @Test
    public void testGetReviewedItems() {
        List<ToDoItem> reviewedItems = new ArrayList<>();
        when(toDoItemService.getReviewedItems()).thenReturn(reviewedItems);

        ModelAndView modelAndView = homeController.getReviewedItems();

        assertThat(modelAndView.getViewName()).isEqualTo("reviewed");
        assertThat(modelAndView.getModel().get("reviewedItems")).isEqualTo(reviewedItems);
    }

    @Test
    public void testSubmit() {
        String pdfId = "123";
        ToDoItem toDoItem = new ToDoItem();
        when(toDoItemRepository.findByPdfId(pdfId)).thenReturn(toDoItem);

        RedirectView redirectView = homeController.submit(pdfId);

        assertThat(redirectView.getUrl()).isEqualTo("/api/v1.0/toreview");
        assertThat(toDoItem.getSubmitted()).isEqualTo(1);
        verify(toDoItemRepository).save(toDoItem);
    }

    
   

    @Test
    public void testDelete() {
        String pdfId = "123";

        ModelAndView modelAndView = homeController.delete(pdfId);

        assertThat(modelAndView.getViewName()).isEqualTo("toreview");
        verify(toDoItemRepository).deleteByPdfId(pdfId);
    }

    @Test
    public void testViewToReviewItems() {
        List<ToDoItem> toReviewItems = new ArrayList<>();
        when(toDoItemService.getToReviewItemsWithSubmittedZero()).thenReturn(toReviewItems);

        ModelAndView modelAndView = homeController.viewToReviewItems();

        assertThat(modelAndView.getViewName()).isEqualTo("toreview");
        assertThat(modelAndView.getModel().get("toReviewItems")).isEqualTo(toReviewItems);
    }

    @Test
    public void testCreateToReview() {
        ToDoItem toReviewItem = new ToDoItem();
        BindingResult result = mock(BindingResult.class);

        String viewName = homeController.createToReview(toReviewItem, result);

        assertThat(viewName).isEqualTo("redirect:/api/v1.0/toreview");
        verify(toDoItemService).save(toReviewItem);
    }

   

    

}
