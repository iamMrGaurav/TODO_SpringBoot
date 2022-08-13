package com.example.todoproject.services;

import com.example.todoproject.entities.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {
    List<Todo> getTodos();

    Todo createTodo(Todo todo);

    Todo getTodoById(int todoId);

    Todo updateTodoById(int id);

    Todo deleteTodo(int id);
}
