package io.shraddha;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import io.shraddha.model.ToDoItem;
import io.shraddha.repo.ToDoItemRepository;
import io.shraddha.service.ToDoItemService;


class ToReviewTest {

		@Mock
	    private ToDoItemRepository toDoItemRepository;

	    @InjectMocks
	    private ToDoItemService toDoItemService;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }


	@Test
	void test() {
		//fail("Not yet implemented");
	}



	@Test
    void testGetAll() {
        // Mocking the repository behavior
        when(toDoItemRepository.findAll()).thenReturn(List.of(
                createToDoItem(1L, "pdf123", "Task 1", "Pending", "first", Date.valueOf("2022-12-31")),
                createToDoItem(2L, "pdf456", "Task 2", "Accepted", "second", Date.valueOf("2022-12-15"))
        ));

        // Testing the service method
        List<ToDoItem> allToDoItems = toDoItemService.getAll();

        // Verifying the result
        assertEquals(2, allToDoItems.size());
    }


	@Test
	public void ToreviewTestMethod() {

		System.out.print("executing junit test cases");
	}

	private final String baseUrl = "http://localhost:8080";



  

//Helper method to create ToDoItem instances
  private ToDoItem createToDoItem(Long id, String pdfId, String title, String paperstatus, String revision, Date deadline) {
      ToDoItem toDoItem = new ToDoItem();
      toDoItem.setId(id);
      toDoItem.setPdfId(pdfId);
      toDoItem.setTitle(title);
      toDoItem.setStatus(paperstatus);
      toDoItem.setRevision(revision);
      toDoItem.setDeadline(deadline);
      return toDoItem;
  }
}

//class TodoItemStub implements ToDoItemService{
//	@Override
//	public List<ToDoItem> getAll(){
//		return {(1L, "pdf123", "Task 1", "Pending", "0.1", Date.valueOf("2022-12-31")),(2L, "pdf456", "Task 2", "Accepted", "1.0", Date.valueOf("2022-12-15")) };
//	}
//}