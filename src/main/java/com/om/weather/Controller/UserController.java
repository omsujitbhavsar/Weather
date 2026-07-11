package com.om.weather.Controller;

import com.om.weather.DTO.LoginRequest;
import com.om.weather.Model.User;
import com.om.weather.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/register")
    public User Register(@RequestBody User user){

        System.out.println("Request api call");

        return userService.register(user);
    }

    @PostMapping("/login")
    public  String login(@RequestBody User user){

        return userService.verify(user);
    }
}
