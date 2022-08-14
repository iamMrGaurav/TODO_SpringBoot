package com.example.todoproject.serviceImplementation;

import com.example.todoproject.entities.Todo;
import com.example.todoproject.exception.ResourceNotFoundException;
import com.example.todoproject.repository.TodoRepository;
import com.example.todoproject.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TodoServiceImplementation implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImplementation(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo getTodoById(int todoId) {
        return todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("Data NOT FOUND"));
    }

    @Override
    public Todo updateTodoById(int id, Todo todo) {
        Todo dbTodo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data NOT FOUND"));
        dbTodo.setTitle(todo.getTitle());
        dbTodo.setDescription(todo.getDescription());
        dbTodo.setDate(todo.getDate());

        return todoRepository.save(dbTodo);
    }

    @Override
    public void deleteTodo(int id) {
        Todo dbTodo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data NOT FOUND"));
        todoRepository.deleteById(id);
    }
}
