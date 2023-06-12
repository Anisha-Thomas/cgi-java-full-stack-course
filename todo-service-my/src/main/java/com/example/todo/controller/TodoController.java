package com.example.todo.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class TodoController {
	private TodoService todoService;

	@PostMapping
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(todo));
	}

	@GetMapping
	public ResponseEntity<Iterable<Todo>> getAllToDos() {
		return ResponseEntity.status(HttpStatus.OK).body(todoService.fetchAllData());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Todo>> getByIdTodos(@PathVariable("id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(todoService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByIdTodos(@PathVariable("id") Integer id) {
		todoService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
	}
}
