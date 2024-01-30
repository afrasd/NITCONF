package io.shraddha.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.shraddha.model.ToDoItem;

@SuppressWarnings("unused")
@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long>{
	 @Query("SELECT t FROM ToDoItem t WHERE t.deadline > :currentDate")
	    List<ToDoItem> findExpiredItems(@Param("currentDate") Date currentDate);
	 
	 Optional<ToDoItem> findById(Long id);
}
