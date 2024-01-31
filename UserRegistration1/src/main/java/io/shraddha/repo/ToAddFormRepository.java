package io.shraddha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import io.shraddha.model.ToDoItem;
import io.shraddha.model.PutFormData;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;


@SuppressWarnings("unused")
@Repository
public interface ToAddFormRepository extends JpaRepository<PutFormData, Long>{
   
}


