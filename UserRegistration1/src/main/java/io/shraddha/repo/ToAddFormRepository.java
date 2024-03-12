package io.shraddha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import io.shraddha.model.ToDoItem;
import io.shraddha.model.PutFormData;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;


@SuppressWarnings("unused")
@Repository
public interface ToAddFormRepository extends JpaRepository<PutFormData, Long>{
	//Optional<PutFormData> findByPdfId(String pdfId);
	List<PutFormData> findByPdfId(String pdfId);
    @Transactional
    @Modifying
    @Query("DELETE FROM PutFormData p WHERE p.pdfId = :pdfId")
    void deleteByPdfId(@Param("pdfId") String pdfId);
//    List<ToDoItem> findByDeadlineBefore(LocalDate deadline);
}


