package com.example.todoproject.services;

import com.example.todoproject.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsers();

    User createUser(User user);

    User getUserById(String id);

    User updateUserById(int id, User user);

    void deleteUser(int id);
}
