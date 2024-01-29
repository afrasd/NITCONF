package com.example.springboot3todoapplication.models;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo-items")
public class ToDoItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String description;
	
	private Boolean isComplete;
	
	private Instant createdAt;
	
	private Instant updatedAt;
	
	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsComplete() {
        return this.isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

	
	@Override
	public String toString() {
		return String.format("ToDoItem{id=%d, description='%s',isComplete='%s',createdAt='%s',updatedAt='%s}",
				id, description, isComplete, createdAt, updatedAt);
	}
}
