package io.shraddha;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import io.shraddha.model.ToDoItem;
import io.shraddha.model.PutFormData;
import io.shraddha.repo.ToDoItemRepository;
import io.shraddha.service.ToDoItemService;
import io.shraddha.repo.ToAddFormRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ToDoItemServiceTest {

    private ToDoItemService toDoItemService;
    private ToDoItemRepository toDoItemRepository;
    private ToAddFormRepository toAddFormRepository;

    @BeforeEach
    public void setUp() {
        toDoItemRepository = mock(ToDoItemRepository.class);
        toAddFormRepository = mock(ToAddFormRepository.class);
        toDoItemService = new ToDoItemService(toDoItemRepository);
    }

    @Test
    public void testDeleteByPdfId() {
        // Call the method to be tested
        toDoItemService.deleteByPdfId("pdfIdToDelete");

        // Verify that the method was called with the correct parameter
        verify(toDoItemRepository, times(1)).deleteByPdfId("pdfIdToDelete");
    }

    @Test
    public void testGetAll() {
        // Create sample ToDoItem data
        ToDoItem toDoItem1 = new ToDoItem();
        ToDoItem toDoItem2 = new ToDoItem();
        List<ToDoItem> sampleToDoItems = new ArrayList<>();
        sampleToDoItems.add(toDoItem1);
        sampleToDoItems.add(toDoItem2);

        // Stub the behavior of ToDoItemRepository
        when(toDoItemRepository.findAll()).thenReturn(sampleToDoItems);

        // Call the method to be tested
        List<ToDoItem> result = toDoItemService.getAll();

        // Verify that the method returned the expected data
        assertEquals(2, result.size());
    }

    @Test
    public void testGetExpiredItems() {
        // Create a sample date
        Date currentDate = new Date();

        // Create sample ToDoItem data
        ToDoItem expiredItem1 = new ToDoItem();
        ToDoItem expiredItem2 = new ToDoItem();
        List<ToDoItem> sampleExpiredItems = new ArrayList<>();
        sampleExpiredItems.add(expiredItem1);
        sampleExpiredItems.add(expiredItem2);

        // Stub the behavior of ToDoItemRepository
        when(toDoItemRepository.findExpiredItems(currentDate)).thenReturn(sampleExpiredItems);

        // Call the method to be tested
        List<ToDoItem> result = toDoItemService.getExpiredItems(currentDate);

        // Verify that the method returned the expected data
        assertEquals(2, result.size());
    }

    @Test
    public void testGetReviewedItems() {
        // Create sample ToDoItem data
        ToDoItem reviewedItem1 = new ToDoItem();
        ToDoItem reviewedItem2 = new ToDoItem();
        List<ToDoItem> sampleReviewedItems = new ArrayList<>();
        sampleReviewedItems.add(reviewedItem1);
        sampleReviewedItems.add(reviewedItem2);

        // Stub the behavior of ToDoItemRepository
        when(toDoItemRepository.findBySubmitted(1)).thenReturn(sampleReviewedItems);

        // Call the method to be tested
        List<ToDoItem> result = toDoItemService.getReviewedItems();

        // Verify that the method returned the expected data
        assertEquals(2, result.size());
    }

    @Test
    public void testGetToReviewItemsWithSubmittedZero() {
        // Create sample ToDoItem data
        ToDoItem toReviewItem1 = new ToDoItem();
        ToDoItem toReviewItem2 = new ToDoItem();
        List<ToDoItem> sampleToReviewItems = new ArrayList<>();
        sampleToReviewItems.add(toReviewItem1);
        sampleToReviewItems.add(toReviewItem2);

        // Stub the behavior of ToDoItemRepository
        when(toDoItemRepository.findBySubmitted(0)).thenReturn(sampleToReviewItems);

        // Call the method to be tested
        List<ToDoItem> result = toDoItemService.getToReviewItemsWithSubmittedZero();

        // Verify that the method returned the expected data
        assertEquals(2, result.size());
    }

    @Test
    public void testGetById() {
        // Create a sample ToDoItem
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setId(123L);

        // Stub the behavior of ToDoItemRepository
        when(toDoItemRepository.findById(123L)).thenReturn(Optional.of(toDoItem));

        // Call the method to be tested
        Optional<ToDoItem> result = toDoItemService.getById(123L);

        // Verify that the method returned the expected data
        assertTrue(result.isPresent());
        assertEquals(123L, result.get().getId());
    }

    @Test
    public void testSave() {
        // Create a sample ToDoItem
        ToDoItem toDoItem = new ToDoItem();

        // Stub the behavior of ToDoItemRepository
        when(toDoItemRepository.save(toDoItem)).thenReturn(toDoItem);

        // Call the method to be tested
        ToDoItem result = toDoItemService.save(toDoItem);

        // Verify that the method returned the expected data
        assertNotNull(result);
        assertEquals(toDoItem, result);
    }

  

    @Test
    public void testDelete() {
        // Create a sample ToDoItem
        ToDoItem toDoItem = new ToDoItem();

        // Call the method to be tested
        toDoItemService.delete(toDoItem);

        // Verify that the method was called with the correct parameter
        verify(toDoItemRepository, times(1)).delete(toDoItem);
    }

    @Test
    public void testGetNotifications() {
        // Create sample dates
        Date currentDate = new Date();
        Date twoDaysLater = new Date(currentDate.getTime() + (2 * 24 * 60 * 60 * 1000)); // Adding two days

        // Create sample ToDoItem data
        ToDoItem notificationItem1 = new ToDoItem();
        ToDoItem notificationItem2 = new ToDoItem();
        List<ToDoItem> sampleNotificationItems = new ArrayList<>();
        sampleNotificationItems.add(notificationItem1);
        sampleNotificationItems.add(notificationItem2);

        // Stub the behavior of ToDoItemRepository
        when(toDoItemRepository.findNotifications(currentDate, twoDaysLater)).thenReturn(sampleNotificationItems);

        // Call the method to be tested
        List<ToDoItem> result = toDoItemService.getNotifications(currentDate, twoDaysLater);

        // Verify that the method returned the expected data
        assertEquals(2, result.size());
    }
}
