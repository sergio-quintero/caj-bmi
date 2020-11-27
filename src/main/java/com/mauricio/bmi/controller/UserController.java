package com.mauricio.bmi.controller;

import com.mauricio.bmi.resource.User;
import com.mauricio.bmi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/registration")
    public String registerUser(User user, HttpServletRequest request) throws ServletException {
        log.info("User input: {}", user);
        User registeredUser = userService.registerUser(user);
        log.info("Registered user: {}", registeredUser);
        request.login(user.getUsername(), user.getPassword());
        return "redirect:/dashboard";
    }
}
