package com.example.todoproject.controller;

import com.example.todoproject.entities.Todo;
import com.example.todoproject.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllTodo() {
        return new ResponseEntity<>(todoService.getTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTodoById(@PathVariable String id) {
        return new ResponseEntity<>(todoService.getTodoById(Integer.parseInt(id)), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createTodo(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateTodo(@RequestBody Todo todo, @PathVariable String id) {
        return new ResponseEntity<>(todoService.updateTodoById(Integer.parseInt(id), todo), HttpStatus.OK);
    }
}
