package io.shraddha;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.shraddha.model.ToDoItem;

public class ToDoItemTest {

    private ToDoItem toDoItem;

    @BeforeEach
    public void setUp() {
        toDoItem = new ToDoItem();
    }

    @Test
    public void testGettersAndSetters() {
        toDoItem.setPdfId("testPdfId");
        assertEquals("testPdfId", toDoItem.getPdfId());

        toDoItem.setTitle("Test Title");
        assertEquals("Test Title", toDoItem.getTitle());

        toDoItem.setStatus("In Progress");
        assertEquals("In Progress", toDoItem.getStatus());

        toDoItem.setRevision("1");
        assertEquals("1", toDoItem.getRevision());

        Date deadline = new Date(System.currentTimeMillis());
        toDoItem.setDeadline(deadline);
        assertEquals(deadline, toDoItem.getDeadline());

        toDoItem.setPdf_link("test.pdf");
        assertEquals("test.pdf", toDoItem.getPdf_link());

        toDoItem.setSubmited(1);
        assertEquals(1, toDoItem.getSubmitted());
    }

    @Test
    public void testToString() {
        toDoItem.setPdfId("testPdfId");
        toDoItem.setTitle("Test Title");
        toDoItem.setStatus("In Progress");
        toDoItem.setRevision("1");
        Date deadline = new Date(System.currentTimeMillis());
        toDoItem.setDeadline(deadline);
        toDoItem.setSubmited(1);
        toDoItem.setPdf_link("test.pdf");

        String expectedString = "ToReview{id=null, pdfId='testPdfId', title='Test Title', status='In Progress', revision='1', deadline='" + deadline.toString() + "', submitted=1, pdf_link='test.pdf'}";

        assertEquals(expectedString, toDoItem.toString());
    }
}
