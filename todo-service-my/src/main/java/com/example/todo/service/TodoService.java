package com.example.todo.service;

import java.util.Optional;

import com.example.todo.model.Todo;

public interface TodoService {
	public Todo createTodo(Todo todo);

	public Iterable<Todo> fetchAllData();
	
	public Optional<Todo> findById(int id);

	public void deleteById(Integer id);

	//void updateById(Integer id, Todo todo);
}
