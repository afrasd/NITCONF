package io.shraddha.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "to_review")
public class ToDoItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pdfId;
    private String title;
    private String paperstatus;
    private String revision;
    private Date deadline;
    private String pdf_link;
    private int submitted;
    
    ////
    public String getPdf_link() {
        return pdf_link;
    }

    public void setPdf_link(String pdf_link) {
        this.pdf_link = pdf_link;
    }
    
    ////
    
    public int getSubmitted() {
    	return this.submitted;
    }
    
    public void setSubmited(int submitted) {
    	this.submitted = submitted;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPdfId() {
        return pdfId;
    }

    public void setPdfId(String pdfId) {
        this.pdfId = pdfId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return paperstatus;
    }

    public void setStatus(String status) {
        this.paperstatus = status;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return String.format("ToReview{id=%d, pdfId='%s', title='%s', status='%s', revision='%s', deadline='%s', submitted=%d, pdf_link='%s'}",
                id, pdfId, title, paperstatus, revision, deadline,submitted,pdf_link);
    }
}