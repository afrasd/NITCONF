//package io.shraddha.controller;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class ProfileController {
//
//    @GetMapping("/profile")
//    public String profile(Authentication authentication, Model model) {
//        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
//        String username = oauth2User.getAttribute("login");
//        String email = oauth2User.getAttribute("email");
//
//        model.addAttribute("username", username);
//        model.addAttribute("email", email);
//
//        return "profile";
//    }
//}

package io.shraddha.controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.shraddha.model.ProfileData;
import io.shraddha.service.ProfileDataService;


@Controller
public class ProfileController {

    @Autowired
    private ProfileDataService profileDataService;

    @GetMapping("/profile")
    public String profile(Authentication authentication,Model model) {
    	OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
    	String username = oauth2User.getAttribute("login");
        ProfileData profileData = profileDataService.findByUsername(username);
        model.addAttribute("username", profileData.getUsername());
        model.addAttribute("email", profileData.getEmailAddress());
        model.addAttribute("tags", profileData.getTags());
        return "profile";
    }
}