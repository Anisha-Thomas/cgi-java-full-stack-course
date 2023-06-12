package com.example.todo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.todo.model.Todo;
import com.example.todo.repo.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoServiceImp implements TodoService {
	
	public TodoRepository todoRepository;
	@Override
	public Todo createTodo(Todo todo) {
		// TODO Auto-generated method stub
		return todoRepository.save(todo);
	}

	@Override
	public Iterable<Todo> fetchAllData() {
		// TODO Auto-generated method stub
		return todoRepository.findAll();
	}

	@Override
	public Optional<Todo> findById(int id) {
		// TODO Auto-generated method stub
		return todoRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		 todoRepository.deleteById(id);
	}
	//@Override
//	public void updateById(Integer id,Todo todo) {
//		todoRepository.updateById(id,todo);
//	}
}
