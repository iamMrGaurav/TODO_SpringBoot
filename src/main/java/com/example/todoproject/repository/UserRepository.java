package com.example.todoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<com.example.todoproject.entities.User, Integer> {

}
