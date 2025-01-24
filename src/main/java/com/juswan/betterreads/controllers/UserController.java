package com.juswan.betterreads.controllers;


import com.juswan.betterreads.repository.UserRepository;
import com.juswan.betterreads.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.juswan.betterreads.domain.User;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;


    public UserController( UserService userService) {
        this.userService = userService;
    }
//    @GetMapping("/api/users/")
//    List<User> all() {
//        return userService.getUsers();
//    }
//
//    @GetMapping("/api/users/{id}")
//    public User getUserByID(@PathVariable Long id) {
//        User byId = userService.getUserByID(id);
//        return byId;
//    }

}
