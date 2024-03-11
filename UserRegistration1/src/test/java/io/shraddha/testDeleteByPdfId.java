	package io.shraddha;
	import static org.junit.jupiter.api.Assertions.*;
	import static org.mockito.Mockito.*;
	
	import org.junit.jupiter.api.Test;
	
	import io.shraddha.repo.ToDoItemRepository;
	import io.shraddha.service.ToDoItemService;
	
	public class testDeleteByPdfId {
	
	    private ToDoItemService toDoItemService;
	
	    @Test
	    public void testDeleteByPdfId1() {
	        // Create a mock repository
	        ToDoItemRepository toDoItemRepository = mock(ToDoItemRepository.class);
	
	        // Instantiate the service with the mocked repository
	        toDoItemService = new ToDoItemService(toDoItemRepository);
	
	        // Call the method to be tested
	        toDoItemService.deleteByPdfId("examplePdfId");
	
	        // Verify that the repository method was called with the correct parameter
	        verify(toDoItemRepository, times(1)).deleteByPdfId("examplePdfId");
	
	        // Optionally, you can also verify that no other interactions occurred with the mock
	        verifyNoMoreInteractions(toDoItemRepository);
	    }
	}
