package io.shraddha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.shraddha.model.ToDoItem;
import io.shraddha.model.PutFormData;
import io.shraddha.repo.ToDoItemRepository;
import io.shraddha.repo.ToAddFormRepository;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class ToDoItemService {

    private final ToDoItemRepository toreviewRepository;
    private final ToAddFormRepository toaddFormData;

    @Autowired
    public ToDoItemService(ToDoItemRepository toReviewRepository, ToAddFormRepository toAddFormRepository) {
        this.toreviewRepository = toReviewRepository;
        this.toaddFormData = toAddFormRepository;
    }

    public void deleteByPdfId(String pdfIdToDelete) {
        toreviewRepository.deleteByPdfId(pdfIdToDelete);
    }

    public List<ToDoItem> getAll() {
        return toreviewRepository.findAll();
    }

    public List<ToDoItem> getExpiredItems(Date currentDate) {
        return toreviewRepository.findExpiredItems(currentDate);
    }

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
