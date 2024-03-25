package io.shraddha;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import io.shraddha.controller.UserController;
import io.shraddha.model.User;
import io.shraddha.repo.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Test
    public void testHome() {
        String viewName = userController.home();
        assertThat(viewName).isEqualTo("home");
    }

    @Test
    public void testGetSignup() {
        String viewName = userController.getSignup();
        assertThat(viewName).isEqualTo("signup");
    }

    @Test
    public void testGetLogin() {
        String viewName = userController.getLogin();
        assertThat(viewName).isEqualTo("loginpage");
    }

    @Test
    public void testGetLandingPage() {
        String viewName = userController.getLandingPage();
        assertThat(viewName).isEqualTo("landingpage");
    }

    @Test
    public void testAddUser_UserExists() {
        String userEmail = "test@example.com";
        User user = new User();
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findByEMAIL(userEmail)).thenReturn(userList);

        ModelAndView modelAndView = userController.addUser(userEmail, user);

        assertThat(modelAndView.getViewName()).isEqualTo("success");
        assertThat(modelAndView.getModel().get("message")).isEqualTo("Oops! There is already a user registered with the email provided.");
    }

    @Test
    public void testAddUser_UserDoesNotExist() {
        String userEmail = "test@example.com";
        User user = new User();
        List<User> userList = new ArrayList<>();
        when(userRepository.findByEMAIL(userEmail)).thenReturn(userList);

        ModelAndView modelAndView = userController.addUser(userEmail, user);

        assertThat(modelAndView.getViewName()).isEqualTo("success");
        assertThat(modelAndView.getModel().get("message")).isEqualTo("User has been successfully registered.");
        verify(userRepository).save(user);
    }

    @Test
    public void testDummy() {
        String viewName = userController.dummy(null);
        assertThat(viewName).isEqualTo("dummy");
    }

    @Test
    public void testLoginUser_ValidCredentials() {
        String username = "test";
        String password = "password";
        HttpSession session = mock(HttpSession.class);
        User user = new User();
        user.setUser_email("test@example.com");
        user.setUser_pass("password");
        when(userRepository.findByUsernamePassword(username, password)).thenReturn(user);

        String viewName = userController.login_user(username, password, session, null);

        assertThat(viewName).isEqualTo("redirect:/dummy");
        verify(session).setAttribute("username", username);
    }

    @Test
    public void testLoginUser_InvalidCredentials() {
        String username = "test";
        String password = "password";
        HttpSession session = mock(HttpSession.class);
        when(userRepository.findByUsernamePassword(username, password)).thenReturn(null);

        String viewName = userController.login_user(username, password, session, null);

        assertThat(viewName).isEqualTo("landingpage");
    }

    @Test
    public void testLogoutUser() {
        HttpSession session = mock(HttpSession.class);

        String viewName = userController.logout_user(session);

        assertThat(viewName).isEqualTo("redirect:/login");
        verify(session).removeAttribute("username");
        verify(session).invalidate();
    }

    @Test
    public void testLandingPage() {
        String viewName = userController.landingPage();
        assertThat(viewName).isEqualTo("landingpage");
    }
}
