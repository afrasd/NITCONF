package io.shraddha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.shraddha.model.ToDoItem;
import io.shraddha.repo.ToDoItemRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoItemService {

	@Autowired
	private ToDoItemRepository toreviewRepository;
	
	
	public List<ToDoItem> getAll() {
        return toreviewRepository.findAll();
    }
	
	public Optional<ToDoItem> getById(Long id) {
        return toreviewRepository.findById(id);
    }
	
//	public List<ToReviewItem> getByPdfId(String pdfId) {
//        return toreviewRepository.findByPdfId(pdfId);
//    }
	
	public ToDoItem save(ToDoItem toReviewItem) {
        if (toReviewItem.getId() == null) {
            // New ToReviewItem, set createdAt and an initial revision
            toReviewItem.setRevision("0.0"); // or use another appropriate identifier for revisions
        } else {
            // Existing ToReviewItem, increment the revision
            toReviewItem.setRevision(toReviewItem.getRevision() + 1);
        }

        return toreviewRepository.save(toReviewItem);
    }
	
	public void delete(ToDoItem toReviewItem) {
        toreviewRepository.delete(toReviewItem);
    }
	public List<ToDoItem> getExpiredItems(Date currentDate) {
        // Implement logic to fetch items with dates less than the current date
        return toreviewRepository.findExpiredItems(currentDate);
    }
	public void updateStatus(String action, List<Long> itemIds) {
        for (Long itemId : itemIds) {
            Optional<ToDoItem> optionalToDoItem = toreviewRepository.findById(itemId);
            if (optionalToDoItem.isPresent()) {
                ToDoItem toDoItem = optionalToDoItem.get();

                // Assuming 'Submit' and 'Decline' are the possible actions
                if ("Submit".equalsIgnoreCase(action)) {
                    // Update status to 'Accepted' or another appropriate value
                    toDoItem.setStatus("Accepted");
                } else if ("Decline".equalsIgnoreCase(action)) {
                    // Update status to 'Rejected' or another appropriate value
                    toDoItem.setStatus("Rejected");
                }

                // Save the updated ToDoItem back to the database
                toreviewRepository.save(toDoItem);
            }
        }
    }

	public void updateDeclineStatus(Long id) {
		// TODO Auto-generated method stub
		
	}

	public static Optional<ToDoItem> getId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

//package io.shraddha.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import io.shraddha.model.ToDoItem;
//import io.shraddha.repo.ToDoItemRepository;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ToDoItemService {
//
//    @Autowired
//    private ToDoItemRepository toReviewRepository;
//
//    public List<ToDoItem> getAll() {
//        return toReviewRepository.findAll();
//    }
//
//    public Optional<ToDoItem> getById(Long id) {
//        return toReviewRepository.findById(id);
//    }
//
//    public ToDoItem save(ToDoItem toReviewItem) {
//        // Your save logic here
//        return toReviewRepository.save(toReviewItem);
//    }
//
//    public void delete(ToDoItem toReviewItem) {
//        toReviewRepository.delete(toReviewItem);
//    }
//}
