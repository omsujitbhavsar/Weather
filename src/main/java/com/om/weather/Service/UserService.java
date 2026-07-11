package com.om.weather.Service;

import com.om.weather.DTO.LoginRequest;
import com.om.weather.Model.User;
import com.om.weather.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authmanager;

    @Autowired
    private JWTService jwtservice;


    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User register(User user) {

        if (userRepo.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");

        return userRepo.save(user);
    }

    public String verify(User user) {
        Authentication authentication =
                authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtservice.generateToken(user.getUsername());

        }
        return "fail";
    }

}
/*
    public String login(LoginRequest request) {
            User user = userRepo.findByUsername(request.getUsername())
                    .orElseThrow(() ->new RuntimeException("user not found"));

            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                return "Login succesful";
            }
        throw new RuntimeException("Invalid Password");
    }
}*/


