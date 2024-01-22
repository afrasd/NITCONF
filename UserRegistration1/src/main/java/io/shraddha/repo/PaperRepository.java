//package io.shraddha.repo;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import io.shraddha.model.Paper;
//import io.shraddha.model.User;
//
//public interface PaperRepository extends JpaRepository<Paper, Integer> {
//
////	List<Paper> findAll();
//    // Custom query method to retrieve only paper titles
//    @Query("SELECT paperitle FROM toreview")
//    List<String> findPaperTitles();
//}
package io.shraddha.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import io.shraddha.model.Paper;

public interface PaperRepository extends JpaRepository<Paper, Integer> {
//from User where user_email=?1
    // Corrected JPQL syntax in the query
//    @Query("SELECT p FROM Paper p")
//    List<String> findPaperTitles();
    
	  @Query("SELECT p.papertitle FROM Paper p")
	  List<Paper> findAll();

	  @Query("SELECT p.paperid FROM Paper p")
	  List<Paper> findAllID();
	  
}
