package io.shraddha;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.apache.tomcat.util.json.ParseException;
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

public class HistoryTestCases {

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
	public void ToreviewTestMethod() {

		System.out.print("executing junit test cases");
	}

	private final String baseUrl = "http://localhost:8080";



  @Test
  void TestToReviewEndpointReturns200() {
      String ToreviewEndpoint = "/history"; 
      String url = baseUrl + ToreviewEndpoint;

      try {
          ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(url, String.class);

          assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
          assertTrue(responseEntity.getBody() != null && !responseEntity.getBody().isEmpty());
      } catch (HttpClientErrorException ex) {
          // If an exception is thrown due to non-200 status, fail the test
          assertEquals(HttpStatus.OK, ex.getStatusCode()); // Adjust as needed
      }
  }

  @Test
  void testViewHistoryPage() {
      // Mocking the repository behavior
      LocalDate currentDate = LocalDate.now();
      Date currentDateSql = Date.valueOf(currentDate);

      when(toDoItemRepository.findExpiredItems(currentDateSql)).thenReturn(List.of(
              createToDoItem(1L, "pdf123", "Task 1", "Accepted", "first", Date.valueOf("2022-12-15")),
              createToDoItem(2L, "pdf456", "Task 2", "Rejected", "second", Date.valueOf("2022-12-10"))
      ));

      // Testing the service method
      List<ToDoItem> expiredItems = toDoItemService.getExpiredItems(currentDateSql);

      // Verifying the result
      assertEquals(2, expiredItems.size());
  }


//  @Test
//  void testGetExpiredPapers() throws ParseException {
//      // Mocking the repository behavior
//      LocalDate currentDate = LocalDate.now();
//      Date currentDateSql = Date.valueOf(currentDate);
//
//      // Set up sample data with deadlines before the current date
//      ToDoItem expiredItem1 = createToDoItem(1L, "pdf123", "Task 1", "Accepted", "first", Date.valueOf("2022-12-15"));
//      ToDoItem expiredItem2 = createToDoItem(2L, "pdf456", "Task 2", "Rejected", "second", Date.valueOf("2022-12-10"));
//      
//      // Set up a sample data with a deadline after the current date
//      ToDoItem notExpiredItem = createToDoItem(3L, "pdf789", "Task 3", "Pending", "third", Date.valueOf("2025-02-01"));
//
//      when(toDoItemRepository.findExpiredItems(currentDateSql)).thenReturn(List.of(expiredItem1, expiredItem2, notExpiredItem));
//
//      // Testing the service method
//      List<ToDoItem> expiredItems = toDoItemService.getExpiredItems(currentDateSql);
//
//      // Verifying the result
//      assertEquals(2, expiredItems.size());
//
//      // Check if all retrieved papers have deadlines before the current date
//      assertTrue(expiredItems.stream().allMatch(item -> item.getDeadline().before(currentDateSql)));
//  }


  @Test
  void testGetExpiredPapers() throws ParseException {
      // Mocking the repository behavior
      LocalDate currentDate = LocalDate.now();
      Date currentDateSql = Date.valueOf(currentDate);

      // Log the current date and SQL date for debugging
      System.out.println("Current Date: " + currentDate);
      System.out.println("Current SQL Date: " + currentDateSql);

      // Set up sample data with deadlines before the current date
      ToDoItem expiredItem1 = createToDoItem(1L, "pdf123", "Task 1", "Accepted", "first", Date.valueOf("2022-12-15"));
      ToDoItem expiredItem2 = createToDoItem(2L, "pdf456", "Task 2", "Rejected", "second", Date.valueOf("2022-12-10"));

      // Log the sample data for debugging
      System.out.println("Sample Data: " + List.of(expiredItem1, expiredItem2));

      when(toDoItemRepository.findExpiredItems(currentDateSql)).thenReturn(List.of(expiredItem1, expiredItem2));

      // Testing the service method
      List<ToDoItem> expiredItems = toDoItemService.getExpiredItems(currentDateSql);

      // Log the retrieved items for debugging
      System.out.println("Retrieved Items: " + expiredItems);

      // Verifying the result
      assertEquals(2, expiredItems.size());

      // Check if all retrieved papers have deadlines before the current date
      assertTrue(expiredItems.stream().allMatch(item -> item.getDeadline().before(currentDateSql)));
  }


  private ToDoItem createToDoItem(Long id, String pdfId, String title, String status, String revision, Date deadline) {
      ToDoItem toDoItem = new ToDoItem();
      toDoItem.setId(id);
      toDoItem.setPdfId(pdfId);
      toDoItem.setTitle(title);
      toDoItem.setStatus(status);
      toDoItem.setRevision(revision);
      toDoItem.setDeadline(deadline);
      return toDoItem;
  }

}