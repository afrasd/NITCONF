package io.shraddha.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "form")
public class PutFormData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long sn;
    private String confidence;
    private String relevance;
    private String originality;
    private String significance;
    private String techsound;
    private String vocabulary;
    private String quality;
    private String readability;
    private String commentval;
    
   
    public Long getSn() {
        return this.sn;
    }

    public void setSn(Long sn) {
        this.sn = sn;
    }

    // break
    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }
    
    // break	
    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }
    
    // break
    public String getOriginality() {
        return originality;
    }

    public void setOriginality(String originality) {
        this.originality = originality;
    }

    // break
    public String getSignificance() {
        return significance;
    }

    public void setSignificance(String significance) {
        this.significance = significance;
    }
    
    // break
    public String getTechsound() {
        return techsound;
    }

    public void setTechsound(String techsound) {
        this.techsound = techsound;
    }

    // break
    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }
    
    // break
    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
    
    // break
    public String getReadability() {
        return readability;
    }

    public void setReadability(String readability) {
        this.readability = readability;
    }
    
    // break
    public String getCommentval() {
        return commentval;
    }

    public void setCommentval(String commentval) {
        this.commentval = commentval;
    }
    
    @Override
    public String toString() {
        return String.format("FormData{sn=%d, confidence='%s', relevance='%s', originality='%s', significance='%s', techsound='%s', vocabulary='%s',quality='%s',readability='%s',commentval='%s'}",
                sn, confidence, relevance, originality, significance, techsound,vocabulary,quality,readability,commentval);
    }
}