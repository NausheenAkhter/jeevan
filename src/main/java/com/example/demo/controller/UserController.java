package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public Users setUser(@RequestBody Users user) {
        return userService.setUser(user);
    }
    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
         userService.deleteUser(id);
         return "User with ID " + id+ " deleted!";
    }

    @PutMapping
    public Users updateUser(@RequestBody Users user) throws Exception {
        return userService.updateUser(user);
    }
}
