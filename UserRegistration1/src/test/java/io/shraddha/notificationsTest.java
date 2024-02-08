package io.shraddha;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.shraddha.model.ToDoItem;
import io.shraddha.repo.ToDoItemRepository;
import io.shraddha.service.ToDoItemService;

public class notificationsTest {

//    // Assuming you have a ToDoItemService with the getNotifications method
//    private ToDoItemService toDoItemService;
//    @Test
//    public void testGetNotifications() {
//        // Create a mock repository
//        ToDoItemRepository toReviewRepository = mock(ToDoItemRepository.class);
//
//        // Set up sample data
//        Date currentDate = new Date();
//        Date twoDaysLater = new Date(currentDate.getTime() + 2 * 24 * 60 * 60 * 1000); // Adding two days in milliseconds
//
//        // Create sample ToDoItems
//        ToDoItem item1 = new ToDoItem();
//        ToDoItem item2 = new ToDoItem();
//        List<ToDoItem> mockItems = new ArrayList<>();
//        mockItems.add(item1);
//        mockItems.add(item2);
//
//        // Stub the repository method to return the sample data
//        when(toReviewRepository.findNotifications(currentDate, twoDaysLater)).thenReturn(mockItems);
//
//        // Instantiate the service with the mocked repository
//        toDoItemService = new ToDoItemService(toReviewRepository);
//
//        // Call the method to be tested
//        List<ToDoItem> result = toDoItemService.getNotifications(currentDate, twoDaysLater);
//
//        // Verify that the repository method was called with the correct parameters
//        verify(toReviewRepository, times(1)).findNotifications(currentDate, twoDaysLater);
//
//        // Assert that the result matches the expected data
//        assertEquals(mockItems, result);
//    }
}
