////package io.shraddha.controller;
////
////import org.springframework.stereotype.Controller;
////import org.springframework.web.bind.annotation.RequestMapping;
////
////@Controller
////public class reviewController {
////	@RequestMapping("/toreview")
////	public String Login() {
////		return "toreview";
////	}
////}
//package io.shraddha.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import io.shraddha.service.paperservice;
//
//@Controller
//public class reviewController {
////
////    private final paperservice paperService;
////
////    @Autowired
////    public reviewController(paperservice paperService) {
////        this.paperService = paperService;
////    }
////
////    @GetMapping("/toreview")
////    public String toReviewPage(Model model) {
////        model.addAttribute("listPapers", paperService.getAllPapers());
////        return "toreview";
////    }
//    private final paperservice paperService;
//
//    @Autowired
//    public reviewController(paperservice paperService) {
//        this.paperService = paperService;
//    }
//
//    @GetMapping("/toreview")
//    public String toReviewPage(Model model) {
//        model.addAttribute("listPaperTitles", paperService.getAllPaperTitles());
//        return "toreview";
//    }
//}
package io.shraddha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import io.shraddha.service.paperservice; // Corrected import statement

@Controller
public class reviewController {
    private final paperservice paperService; // Corrected field type

    @Autowired
    public reviewController(paperservice paperService) {
        this.paperService = paperService;
    }

    @GetMapping("/toreview")
    public String toReviewPage(Model model) {
        model.addAttribute("listPaperTitles", paperService.getAllPapers());
        return "toreview";
    }
}
