package io.shraddha;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.shraddha.model.PutFormData;

public class PutFormDataTest {

    private PutFormData putFormData;

    @BeforeEach
    public void setUp() {
        putFormData = new PutFormData();
    }

    @Test
    public void testGettersAndSetters() {
        putFormData.setPdfId("testPdfId");
        assertEquals("testPdfId", putFormData.getPdfId());

        putFormData.setSn(123L);
        assertEquals(123L, putFormData.getSn());

        putFormData.setConfidence("high");
        assertEquals("high", putFormData.getConfidence());

        putFormData.setRelevance("relevant");
        assertEquals("relevant", putFormData.getRelevance());

        putFormData.setOriginality("original");
        assertEquals("original", putFormData.getOriginality());

        putFormData.setSignificance("significant");
        assertEquals("significant", putFormData.getSignificance());

        putFormData.setTechsound("clear");
        assertEquals("clear", putFormData.getTechsound());

        putFormData.setVocabulary("rich");
        assertEquals("rich", putFormData.getVocabulary());

        putFormData.setQuality("good");
        assertEquals("good", putFormData.getQuality());

        putFormData.setReadability("easy");
        assertEquals("easy", putFormData.getReadability());

        putFormData.setCommentval("comment");
        assertEquals("comment", putFormData.getCommentval());

        putFormData.setStatus("completed");
        assertEquals("completed", putFormData.getStatus());
    }

    @Test
    public void testToString() {
        putFormData.setPdfId("testPdfId");
        putFormData.setSn(123L);
        putFormData.setConfidence("high");
        putFormData.setRelevance("relevant");
        putFormData.setOriginality("original");
        putFormData.setSignificance("significant");
        putFormData.setTechsound("clear");
        putFormData.setVocabulary("rich");
        putFormData.setQuality("good");
        putFormData.setReadability("easy");
        putFormData.setCommentval("comment");
        putFormData.setStatus("completed");

        String expectedString = "FormData{sn=123, confidence='high', relevance='relevant', originality='original', significance='significant', techsound='clear', vocabulary='rich',quality='good',readability='easy',commentval='comment',pdfId='testPdfId'}";

        assertEquals(expectedString, putFormData.toString());
    }

    @Test
    public void testGetDeadline() {
        // As getDeadline() method is not implemented yet, it should return null
        assertNull(putFormData.getDeadline());
    }
}
