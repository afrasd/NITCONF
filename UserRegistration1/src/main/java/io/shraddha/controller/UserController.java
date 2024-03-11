package io.shraddha.controller;

import java.beans.JavaBean;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.shraddha.model.User;
import io.shraddha.repo.UserRepository;

@CrossOrigin
@JavaBean
@RestController
@RequestMapping("/api/toreview")
public class UserController {

    @Autowired
    UserRepository urepo;

    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @RequestMapping("/signup")
    public String getSignup() {
        return "signup";
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        return new ModelAndView("loginpage");
    }

    @PostMapping("/addUser")
    public ModelAndView addUser(@RequestParam("user_email") String user_email, User user) {
        ModelAndView mv = new ModelAndView("success");
        List<User> list = urepo.findByEMAIL(user_email);

        if (list.size() != 0) {
            mv.addObject("message", "Oops! There is already a user registered with the email provided.");

        } else {
            urepo.save(user);
            mv.addObject("message", "User has been successfully registered.");
        }

        return mv;
    }

    @PostMapping("/dummy")
    public ModelAndView dummy(ModelMap model) {
        return new ModelAndView("dummy");
    }
    @GetMapping("/dummy")
    public ModelAndView dummy1(ModelMap model) {
        return new ModelAndView("dummy");
    }
    
//    @RequestMapping("/toreview")
//    public String toReviewPage() {
//        return "toreview"; // Assuming "new-todo-item.html" is in the "src/main/resources/templates" directory
//    }

    @PostMapping("/login")
    public ModelAndView login_user(@RequestParam("username") String username, @RequestParam("password") String password,
            HttpSession session, ModelMap modelMap) {

        User auser = urepo.findByUsernamePassword(username, password);

        if (auser != null) {
            String uname = auser.getUser_email();
            String upass = auser.getUser_pass();

            if (username.equalsIgnoreCase(uname) && password.equalsIgnoreCase(upass)) {
                session.setAttribute("username", username);
                return new ModelAndView ("api/toreview/dummy");
            } else {
                modelMap.put("error", "Invalid Account");
                return new ModelAndView("loginpage");
            }
        } else {
            modelMap.put("error", "Invalid Account");
            return new ModelAndView("loginpage");
        }

    }

    @GetMapping(value = "/logout")
    public ModelAndView logout_user(HttpSession session) {
        session.removeAttribute("username");
        session.invalidate();
        return new ModelAndView ("api/oreview/login");
    }
    
//    @GetMapping("/toreview")
//    public String showToReviewForm(@ModelAttribute("toreviewItem") ToDoItem toReviewItem) {
//        return "new-todo-item";
//    }

    

        
    }

