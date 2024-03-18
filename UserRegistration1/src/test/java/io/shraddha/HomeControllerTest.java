package io.shraddha;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import io.shraddha.controller.HomeController;
import io.shraddha.model.PutFormData;
import io.shraddha.model.ToDoItem;
import io.shraddha.repo.ToAddFormRepository;
import io.shraddha.repo.ToDoItemRepository;
import io.shraddha.service.ToDoItemService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class HomeControllerTest {

    @Mock
    private ToDoItemService toDoItemService;

    @Mock
    private ToDoItemRepository toDoItemRepository;

    @Mock
    private ToAddFormRepository toAddFormRepository;

    @InjectMocks
    private HomeController homeController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(homeController)
                                 .setViewResolvers(viewResolver)
                                 .build();
    }

    
    public void testGetExpiredItems() throws Exception {
        // Arrange
        Date currentDate = new Date();
        ToDoItem item1 = new ToDoItem();
        item1.setId(1L);
        item1.setTitle("Test Item 1");
        ToDoItem item2 = new ToDoItem();
        item2.setId(2L);
        item2.setTitle("Test Item 2");
        List<ToDoItem> expiredItems = Arrays.asList(item1, item2);

        when(toDoItemService.getExpiredItems(currentDate)).thenReturn(expiredItems);

        // Act & Assert
        mockMvc.perform(get("/api/v1.0/history"))
               .andExpect(status().isOk())
               .andExpect(view().name("history"))
               .andExpect(model().attribute("expiredItems", expiredItems));
    }

    @Test
    public void testGetReviewedItems() throws Exception {
        // Arrange
        ToDoItem item1 = new ToDoItem();
        item1.setId(1L);
        item1.setTitle("Test Item 1");
        ToDoItem item2 = new ToDoItem();
        item2.setId(2L);
        item2.setTitle("Test Item 2");
        List<ToDoItem> reviewedItems = Arrays.asList(item1, item2);

        when(toDoItemService.getReviewedItems()).thenReturn(reviewedItems);

        // Act & Assert
        mockMvc.perform(get("/api/v1.0/reviewed"))
               .andExpect(status().isOk())
               .andExpect(view().name("reviewed"))
               .andExpect(model().attribute("reviewedItems", reviewedItems));
    }

    @Test
    public void testSubmit() throws Exception {
        // Arrange
        String pdfId = "test_pdf_id";
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setPdfId(pdfId);
        when(toDoItemRepository.findByPdfId(pdfId)).thenReturn(toDoItem);

        // Act & Assert
        mockMvc.perform(get("/api/v1.0/submit").param("pdfId", pdfId))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/api/v1.0/toreview"));
    }

    @Test
    public void testShowCreateForm() throws Exception {
        // Arrange
        String pdfId = "test_pdf_id";
        PutFormData formData = new PutFormData();
        formData.setPdfId(pdfId);
        when(toAddFormRepository.findByPdfId(pdfId)).thenReturn(Collections.singletonList(formData));

        // Act & Assert
        mockMvc.perform(get("/api/v1.0/form").param("pdfId", pdfId))
               .andExpect(status().isOk())
               .andExpect(view().name("form"))
               .andExpect(model().attribute("formItem", formData));
    }
//
//    @Test
//    public void testCreateToForm_ValidInput() throws Exception {
//        // Arrange
//        String pdfId = "test_pdf_id";
//        PutFormData addFormItem = new PutFormData();
//        addFormItem.setPdfId(pdfId);
//        addFormItem.setStatus("accept");
//
//        // Mock the behavior of the repository methods
//        when(toAddFormRepository.findByPdfId(pdfId)).thenReturn(Collections.emptyList());
//
//        // Act & Assert
//        mockMvc.perform(post("/api/v1.0/form")
//                .param("pdfId", pdfId)
//                .param("status", "accept"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/")); // Redirects to the "To Review" page
//    }

    @Test
    public void testCreateToForm_InvalidInput() throws Exception {
        // Arrange
        String pdfId = "test_pdf_id";
        PutFormData addFormItem = new PutFormData();
        addFormItem.setPdfId(pdfId);

        // Mock the behavior of the repository methods
        when(toAddFormRepository.findByPdfId(pdfId)).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(post("/api/v1.0/form")
                .param("pdfId", pdfId))
                .andExpect(status().isOk())
                .andExpect(view().name("form")); // Stays on the form page due to validation errors
    }
    
    @Test
    public void testCreateToForm_ValidInput() throws Exception {
        // Arrange
        String pdfId = "227";
        PutFormData addFormItem = new PutFormData();
        addFormItem.setPdfId(pdfId);
        addFormItem.setStatus("accept");

        // Mock the behavior of the repository methods
        when(toAddFormRepository.findByPdfId(pdfId)).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(post("/api/v1.0/form?pdfId=" + pdfId)  // Include pdfId in the request URL
                .param("confidence", "5")
                .param("relevance", "3")
                .param("originality", "5")
                .param("significance", "3")
                .param("techsound", "5")
                .param("vocabulary", "3")
                .param("quality", "5")
                .param("readability", "3")
                .param("commentval", "Good")
                .param("status", "accept"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/")); // Redirects to the "To Review" page
    }


    @Test
    public void testDelete() throws Exception {
        // Arrange
        String pdfId = "test_pdf_id";

        // Act & Assert
        mockMvc.perform(get("/api/v1.0/delete").param("pdfId", pdfId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/api/v1.0/toreview"));
    }

    @Test
    public void testViewToReviewItems() throws Exception {
        // Arrange
        ToDoItem item1 = new ToDoItem();
        item1.setId(1L);
        item1.setTitle("Test Item 1");
        ToDoItem item2 = new ToDoItem();
        item2.setId(2L);
        item2.setTitle("Test Item 2");
        List<ToDoItem> toReviewItems = Arrays.asList(item1, item2);

        // Mock the behavior of the service method
        when(toDoItemService.getToReviewItemsWithSubmittedZero()).thenReturn(toReviewItems);

        // Act & Assert
        mockMvc.perform(get("/api/v1.0/toreview"))
                .andExpect(status().isOk())
                .andExpect(view().name("toreview"))
                .andExpect(model().attribute("toReviewItems", toReviewItems));
    }

    @Test
    public void testDisplayAll() throws Exception {
        // Arrange
        String pdfId = "test_pdf_id";
        PutFormData formData = new PutFormData();
        //formData.setPdfId(1L);
        //formData.setPdfId(pdfId);
        List<PutFormData> formDataList = Collections.singletonList(formData);

        // Mock the behavior of the repository method
        when(toAddFormRepository.findByPdfId(pdfId)).thenReturn(formDataList);

        // Act & Assert
        mockMvc.perform(get("/api/v1.0/display-all").param("pdfId", pdfId))
                .andExpect(status().isOk())
                .andExpect(view().name("display-all"))
                .andExpect(model().attribute("formDataList", formDataList));
    }
}
