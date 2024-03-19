package io.shraddha;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.shraddha.model.PutFormData;

public class PutFormDataTest {

    @Test
    public void testGetAndSetPdfId() {
        PutFormData formData = new PutFormData();
        formData.setPdfId("123456");
        assertEquals("123456", formData.getPdfId());
    }

    @Test
    public void testGetAndSetSn() {
        PutFormData formData = new PutFormData();
        formData.setSn(1L);
        assertEquals(1L, formData.getSn());
    }

    @Test
    public void testGetAndSetConfidence() {
        PutFormData formData = new PutFormData();
        formData.setConfidence("High");
        assertEquals("High", formData.getConfidence());
    }

    @Test
    public void testGetAndSetRelevance() {
        PutFormData formData = new PutFormData();
        formData.setRelevance("Very relevant");
        assertEquals("Very relevant", formData.getRelevance());
    }

    @Test
    public void testGetAndSetOriginality() {
        PutFormData formData = new PutFormData();
        formData.setOriginality("Unique");
        assertEquals("Unique", formData.getOriginality());
    }

    @Test
    public void testGetAndSetSignificance() {
        PutFormData formData = new PutFormData();
        formData.setSignificance("Very significant");
        assertEquals("Very significant", formData.getSignificance());
    }

    @Test
    public void testGetAndSetTechsound() {
        PutFormData formData = new PutFormData();
        formData.setTechsound("Loud");
        assertEquals("Loud", formData.getTechsound());
    }

    @Test
    public void testGetAndSetVocabulary() {
        PutFormData formData = new PutFormData();
        formData.setVocabulary("Extensive");
        assertEquals("Extensive", formData.getVocabulary());
    }

    @Test
    public void testGetAndSetQuality() {
        PutFormData formData = new PutFormData();
        formData.setQuality("High quality");
        assertEquals("High quality", formData.getQuality());
    }

    @Test
    public void testGetAndSetReadability() {
        PutFormData formData = new PutFormData();
        formData.setReadability("Clear");
        assertEquals("Clear", formData.getReadability());
    }

    @Test
    public void testGetAndSetCommentval() {
        PutFormData formData = new PutFormData();
        formData.setCommentval("Informative");
        assertEquals("Informative", formData.getCommentval());
    }

    @Test
    public void testGetAndSetStatus() {
        PutFormData formData = new PutFormData();
        formData.setStatus("Completed");
        assertEquals("Completed", formData.getStatus());
    }
}
