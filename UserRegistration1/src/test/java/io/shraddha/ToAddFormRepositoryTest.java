package io.shraddha;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import io.shraddha.model.PutFormData;
import io.shraddha.repo.ToAddFormRepository;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ToAddFormRepositoryTest {

    @Test
    public void testFindByPdfId() {
        // Create a mock ToAddFormRepository
        ToAddFormRepository toAddFormRepository = mock(ToAddFormRepository.class);

        // Create sample PutFormData objects
        PutFormData formData1 = new PutFormData();
        formData1.setPdfId("pdfId1");

        PutFormData formData2 = new PutFormData();
        formData2.setPdfId("pdfId2");

        List<PutFormData> sampleFormDataList = new ArrayList<>();
        sampleFormDataList.add(formData1);
        sampleFormDataList.add(formData2);

        // Stub the behavior of findByPdfId method
        when(toAddFormRepository.findByPdfId("pdfId1")).thenReturn(sampleFormDataList);

        // Call the method to be tested
        List<PutFormData> result = toAddFormRepository.findByPdfId("pdfId1");

        // Verify that the method was called with the correct parameter
        verify(toAddFormRepository, times(1)).findByPdfId("pdfId1");

        // Verify that the returned list matches the expected list
        assertEquals(2, result.size());
        assertEquals("pdfId1", result.get(0).getPdfId());
        assertEquals("pdfId2", result.get(1).getPdfId());
    }

    @Test
    public void testDeleteByPdfId() {
        // Create a mock ToAddFormRepository
        ToAddFormRepository toAddFormRepository = mock(ToAddFormRepository.class);

        // Call the method to be tested
        toAddFormRepository.deleteByPdfId("pdfId1");

        // Verify that the method was called with the correct parameter
        verify(toAddFormRepository, times(1)).deleteByPdfId("pdfId1");
    }
}
