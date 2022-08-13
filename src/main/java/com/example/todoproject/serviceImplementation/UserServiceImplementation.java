package com.example.todoproject.serviceImplementation;

import com.example.todoproject.entities.User;
import com.example.todoproject.exception.ResourceNotFoundException;
import com.example.todoproject.repository.UserRepository;
import com.example.todoproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(Integer.parseInt(id)).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));

    }


    @Override
    public User updateUserById(int id, User user) {
        User userObj = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));
        userObj.setEmail(user.getEmail());
        userObj.setFirstName(user.getFirstName());
        userObj.setLastName(user.getLastName());
        userObj.setPassword(user.getPassword());
        return userRepository.save(userObj);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));
        userRepository.deleteById(id);
    }
}
