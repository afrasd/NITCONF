package io.shraddha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import io.shraddha.model.ToDoItem;
import io.shraddha.model.PutFormData;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;


@SuppressWarnings("unused")
@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long>{
	ToDoItem findByPdfId(String pdfId);
	List<ToDoItem> findBySubmitted(int submitted);

	 @Query("SELECT t FROM ToDoItem t WHERE t.deadline < :currentDate")
	    List<ToDoItem> findExpiredItems(@Param("currentDate") Date currentDate);
    
//    List<ToDoItem> findByDeadlineBefore(Date currentDate);
		@Transactional
		@Modifying
	    @Query("DELETE FROM ToDoItem p WHERE p.pdfId = :pdfId")
	    void deleteByPdfId(@Param("pdfId") String pdfId); 
}


