package com.example.demo.services;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }
    public Users setUser(Users user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
         userRepository.deleteById(userId);
    }

    public Users updateUser(Users user) throws Exception {
        Optional<Users> currentUser = userRepository.findById(user.getId());
        if(currentUser.isPresent()){
           Users existingUser = currentUser.get();
            existingUser.setEmail(user.getEmail());
            existingUser.setName(user.getName());
           return userRepository.save(existingUser);
        } else {
            throw new Exception("User with id "+ user.getId() + " not found.");
        }
    }

    public Optional<Users> getUserByEmail(String username) {
        return userRepository.findByEmail(username);
    }
}
