////package io.shraddha.model;
////
////import javax.persistence.Entity;
////import javax.persistence.GeneratedValue;
////import javax.persistence.GenerationType;
////import javax.persistence.Id;
////
////
////@Entity
////public class Paper {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Integer pdfId;
////    private String paperTitle;
////    private Integer paperId;
////    private String reviewStatus;
////    private String revisionStatus;
////    private String deadline;
////
////    public Integer getPdfId() {
////        return pdfId;
////    }
////
////    public void setPdfId(Integer pdfId) {
////        this.pdfId = pdfId;
////    }
////
////    public String getPaperTitle() {
////        return paperTitle;
////    }
////
////    public void setPaperTitle(String paperTitle) {
////        this.paperTitle = paperTitle;
////    }
////
////    public Integer getPaperId() {
////        return paperId;
////    }
////
////    public void setPaperId(Integer paperId) {
////        this.paperId = paperId;
////    }
////
////    public String getReviewStatus() {
////        return reviewStatus;
////    }
////
////    public void setReviewStatus(String reviewStatus) {
////        this.reviewStatus = reviewStatus;
////    }
////
////    public String getRevisionStatus() {
////        return revisionStatus;
////    }
////
////    public void setRevisionStatus(String revisionStatus) {
////        this.revisionStatus = revisionStatus;
////    }
////
////    public String getDeadline() {
////        return deadline;
////    }
////
////    public void setDeadline(String deadline) {
////        this.deadline = deadline;
////    }
////
////    @Override
////    public String toString() {
////        return "Paper [pdfId=" + pdfId + ", paperTitle=" + paperTitle + ", paperId=" + paperId +
////               ", reviewStatus=" + reviewStatus + ", revisionStatus=" + revisionStatus + ", deadline=" + deadline + "]";
////    }
////}
package io.shraddha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "toreview1")
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private String papertitle;

    // Add other fields based on your table structure


    public String getPapertitle() {
        return papertitle;
    }

    private String paperid;

    // Add other fields based on your table structure


    public String getPaperId() {
        return papertitle;
    }
//    public void setPapertitle(String papertitle) {
//        this.papertitle = papertitle;
//    }

    // Add getters and setters for other fields

    @Override
    public String toString() {
        return "Paper [papertitle=" + papertitle + " + " + paperid + "]";
    }
}
//package io.shraddha.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "toreview")
//public class Paper {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "papertitle")
//    private String papertitle;
//
//    // Add other fields based on your table structure
//
//    // Constructors, getters, and setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getPapertitle() {
//        return papertitle;
//    }
//
//    public void setPapertitle(String papertitle) {
//        this.papertitle = papertitle;
//    }
//
//    // Add getters and setters for other fields
//
//    @Override
//    public String toString() {
//        return "Paper [id=" + id + ", papertitle=" + papertitle + "]";
//    }
//}
