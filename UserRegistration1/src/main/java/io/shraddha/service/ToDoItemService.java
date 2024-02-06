package io.shraddha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.shraddha.model.ToDoItem;
import io.shraddha.model.PutFormData;
import io.shraddha.repo.ToDoItemRepository;
import io.shraddha.repo.ToAddFormRepository;

import java.util.List;
import java.util.Optional;
import java.util.Date; // Import Date class

@Service
public class ToDoItemService {

	@Autowired
	private ToDoItemRepository toreviewRepository;
	
	public List<ToDoItem> getAll() {
        return toreviewRepository.findAll();
    }

	public List<ToDoItem> getExpiredItems(Date currentDate) {
        // Implement logic to fetch items with dates less than the current date
        return toreviewRepository.findExpiredItems(currentDate);
    }
    
//	public List<ToDoItem> getHistoryItems() {
//	    return toreviewRepository.findByDeadlineBefore(LocalDate.now());
//	}
	public List<ToDoItem> getReviewedItems() {
	    return toreviewRepository.findBySubmitted(1);
	}
    public List<ToDoItem> getToReviewItemsWithSubmittedZero() {
        return toreviewRepository.findBySubmitted(0);
    }
	public Optional<ToDoItem> getById(Long id) {
        return toreviewRepository.findById(id);
    }
	
	public ToDoItem save(ToDoItem toReviewItem) {

        return toreviewRepository.save(toReviewItem);
    }
	
	@Autowired
	private ToAddFormRepository toaddFormData;

	public PutFormData saveform(PutFormData addFormItem) {

        return toaddFormData.save(addFormItem);
    }
	
	public void delete(ToDoItem toReviewItem) {
        toreviewRepository.delete(toReviewItem);
    }
	
	public List<ToDoItem> getNotifications(Date currentDate, Date twoDaysLater) {
        return toreviewRepository.findNotifications(currentDate, twoDaysLater);
    }
	
}
