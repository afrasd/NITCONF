package io.shraddha.controller;

import java.beans.JavaBean;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.shraddha.model.ToDoItem;
import io.shraddha.model.User;
import io.shraddha.repo.UserRepository;

@JavaBean
@Controller
public class UserController {

    @Autowired
    UserRepository urepo;

    /**
     * home
     * Controller method for displaying the home page
     * @return String: Returns the name of the view template for the home page
     * @since 1.0
     * @author  <a href="https://github.com/shraddhayelamarthy?tab=repositories"> Shraddha Yelamarthy</a>
     * @RequestMapping("/") // Specifies the mapping for handling requests to the home page
     */

    @RequestMapping("/")
    public String home() {
        return "home";
    }
    /**
     * getSignup
     * Controller method for displaying the signup page
     * @return String: Returns the name of the view template for the signup page
     * @since 1.0
     * @author <a href="https://github.com/shraddhayelamarthy?tab=repositories"> Shraddha Yelamarthy</a>
     * @RequestMapping("/signup") // Specifies the mapping for handling requests to the signup page
     */
    @RequestMapping("/signup")
    public String getSignup() {
        return "signup";
    }
    
    /**
     * getLogin
     * Controller method for displaying the login page
     * @return String: Returns the name of the view template for the login page
     * @since 1.0
     * @author <a href="https://github.com/shraddhayelamarthy?tab=repositories"> Shraddha Yelamarthy</a>
     * @GetMapping("/login") // Specifies the mapping for handling GET requests to the login page
     */
    @GetMapping("/login")
    public String getLogin() {
        return "loginpage";
    }
    
//    @CrossOrigin(origins = "http://127.0.0.1:3000")
//    @GetMapping("/login")
//    public ResponseEntity<String> login() {
//        // Redirect to GitHub OAuth authentication page
//        // Handle GitHub callback and exchange code for access token
//        // Return access token to client
//        String accessToken = "3b0e899330d8779065ea";
//        return ResponseEntity.ok("{\"accessToken\": \"" + accessToken + "\"}");
//    }    
    
    /**
     * getLandingPage
     * Controller method for displaying the landing page
     * @return String: Returns the name of the view template for the landing page
     * @since 1.0
     * @author <a href="https://github.com/shraddhayelamarthy?tab=repositories"> Shraddha Yelamarthy</a>
     */
    @GetMapping("/landingpage") // Add a separate mapping for landing page
    public String getLandingPage() {
        return "landingpage"; // Return the landing page template
    }
    /**
     * addUser
     * Controller method for adding a new user
     * @param user_email : {@link String} The email of the user to be added
     * @param user : {@link User} The user object to be added
     * @return ModelAndView: Returns a ModelAndView object with a success message if the user is successfully added, 
     *                      otherwise returns a message indicating that a user with the provided email already exists
     * @since 1.0
     * @author <a href="https://github.com/shraddhayelamarthy?tab=repositories"> Shraddha Yelamarthy</a>
     */
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
    /**
     * dummy
     * Controller method for displaying a dummy page that 
     * has the 3 button "toreview" "reviewed" "history"
     * @param model : {@link ModelMap} ModelMap object to add attributes for the view
     * @return String: Returns the name of the view template for the dummy page
     * @since 1.0
     * @author <a href="https://github.com/shraddhayelamarthy?tab=repositories"> Shraddha Yelamarthy</a>
     */
    @GetMapping("/dummy")
    public String dummy(ModelMap model) {
        return "dummy";
    }
    
//    @RequestMapping("/toreview")
//    public String toReviewPage() {
//        return "toreview"; // Assuming "new-todo-item.html" is in the "src/main/resources/templates" directory
//    }
    /**
     * login_user
     * Controller method for user login
     * @param username : {@link String} The username entered by the user
     * @param password : {@link String} The password entered by the user
     * @param session : {@link HttpSession} HttpSession object to manage user session
     * @param modelMap : {@link ModelMap} ModelMap object to add attributes for the view
     * @return String: Redirects to the "dummy" page if login is successful, otherwise returns to the "landingpage" with an error message
     * @since 1.0
     * @author <a href="https://github.com/shraddhayelamarthy?tab=repositories"> Shraddha Yelamarthy</a>
     */
    @PostMapping("/login")
    public String login_user(@RequestParam("username") String username, @RequestParam("password") String password,
            HttpSession session, ModelMap modelMap) {

        User auser = urepo.findByUsernamePassword(username, password);

        if (auser != null) {
            String uname = auser.getUser_email();
            String upass = auser.getUser_pass();

            if (username.equalsIgnoreCase(uname) && password.equalsIgnoreCase(upass)) {
                session.setAttribute("username", username);
                return "redirect:/dummy";
            } else {
                modelMap.put("error", "Invalid Account");
                return "landingpage";
            }
        } else {
            modelMap.put("error", "Invalid Account");
            return "landingpage";
        }

    }
    /**
     * logout_user
     * Controller method for user logout
     * @param session : {@link HttpSession} HttpSession object to manage user session
     * @return String: Redirects to the "login" page after successfully logging out the user
     * @since 1.0
     * @author <a href="https://github.com/shraddhayelamarthy?tab=repositories"> Shraddha Yelamarthy</a>
     */
    @GetMapping(value = "/logout")
    public String logout_user(HttpSession session) {
        session.removeAttribute("username");
        session.invalidate();
        return "redirect:/login";
    }
    /**
     * landingPage
     * Controller method for displaying the landing page
     * @return String: Returns the name of the view template for the landing page
     * @since 1.0
     * @author <a href="https://github.com/shraddhayelamarthy?tab=repositories"> Shraddha Yelamarthy</a>
     */
    @GetMapping("/")
    public String landingPage() {
        return "landingpage"; // Return the landing page template
    }
    
//    @GetMapping("/toreview")
//    public String showToReviewForm(@ModelAttribute("toreviewItem") ToDoItem toReviewItem) {
//        return "new-todo-item";
//    }

    

        
    }

