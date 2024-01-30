package io.shraddha.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.shraddha.service.ToDoItemService;

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
    private String decline; 



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
    public String getDecline() {
        return decline;
    }	

    public void setDecline(int i) {
        this.decline = decline;
    }

    public void updateDeclineStatus(Long id) {
        Optional<ToDoItem> optionalToDoItem = ToDoItemService.getById(id);
        if (optionalToDoItem.isPresent()) {
            ToDoItem toDoItem = optionalToDoItem.get();

            // Set the decline attribute to 0
            toDoItem.setDecline(0);

            ToDoItemService toDoItemService = new ToDoItemService();
			// Save the updated ToDoItem back to the database
            toDoItemService.save(toDoItem);
        }
    }

    @Override
    public String toString() {
        return String.format("ToReview{id=%d, pdfId='%s', title='%s', status='%s', revision='%s', deadline='%s'}",
                id, pdfId, title, paperstatus, revision, deadline);
    }
}
//package io.shraddha.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "to_review")
//public class ToDoItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    // Add other fields as needed, for example:
//    private String pdfId;
//    private String title;
//	  public String getPdfId() {
//	  return pdfId;
//	}
//    public String getTitle() {
//    return title;
//}
//    // Getters and setters
//    // ...
//}
