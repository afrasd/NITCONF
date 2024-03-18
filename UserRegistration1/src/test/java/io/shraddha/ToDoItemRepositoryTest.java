package io.shraddha;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import io.shraddha.model.ToDoItem;
import io.shraddha.repo.ToDoItemRepository;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoItemRepositoryTest {

    @Test
    public void testFindByPdfId() {
        // Create a mock ToDoItemRepository
        ToDoItemRepository toDoItemRepository = mock(ToDoItemRepository.class);

        // Create a sample ToDoItem object
        ToDoItem sampleToDoItem = new ToDoItem();
        sampleToDoItem.setPdfId("testPdfId");

        // Stub the behavior of findByPdfId method
        when(toDoItemRepository.findByPdfId("testPdfId")).thenReturn(sampleToDoItem);

        // Call the method to be tested
        ToDoItem result = toDoItemRepository.findByPdfId("testPdfId");

        // Verify that the method was called with the correct parameter
        verify(toDoItemRepository, times(1)).findByPdfId("testPdfId");

        // Verify that the returned value matches the expected ToDoItem object
        assertEquals("testPdfId", result.getPdfId());
    }

    // Similarly write tests for other custom query methods

    // Ensure to cover all custom query methods

}
