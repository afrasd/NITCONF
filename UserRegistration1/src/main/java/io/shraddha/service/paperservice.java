//package io.shraddha.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import io.shraddha.repo.PaperRepository;
//import org.springframework.stereotype.Service;
//import io.shraddha.model.Paper;
//import io.shraddha.service.paperservice;
//
//import java.util.List;
//
//@Service
//public class paperservice {
//
//    private final PaperRepository paperRepository;
//
//    @Autowired
//    public paperservice(PaperRepository paperRepository) {
//        this.paperRepository = paperRepository;
//    }
//
//    public List<Paper> getAllPapers() {
//        return paperRepository.findAll();
//    }
//}
////package io.shraddha.service;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////import java.util.List;
////import io.shraddha.model.Paper;
////import io.shraddha.repo.PaperRepository;
////
////@Service
////public class paperservice {
////
////    private final PaperRepository paperRepository;
////
////    @Autowired
////    public PaperService(PaperRepository paperRepository) {
////        this.paperRepository = paperRepository;
////    }
////
////    public List<Paper> getAllPapers() {
////        return paperRepository.findAll();
////    }
////}

package io.shraddha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import io.shraddha.model.Paper;
import io.shraddha.repo.PaperRepository;

@Service
public class paperservice {
//
    private final PaperRepository paperRepository;

    @Autowired
    public paperservice(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public List<Paper> getAllPapers() {
        return paperRepository.findAll();
    }

        public List<Paper> getAllPapersID() {
            return paperRepository.findAllID();
    }
//    private final PaperRepository paperRepository;
//
//    
//    @Autowired
//    public paperservice(PaperRepository paperRepository) {
//        this.paperRepository = paperRepository;
//    }
//
//    public List<String> getAllPaperTitles() {
//        return paperRepository.findPaperTitles();
//    }
}

