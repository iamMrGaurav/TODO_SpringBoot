package com.example.todoproject.repository;

import com.example.todoproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<User, Integer> {
}
