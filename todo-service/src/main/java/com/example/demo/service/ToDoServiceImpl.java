package com.example.demo.service;



import org.springframework.stereotype.Service;

import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;

@Service
//@AllArgsConstructor
public class ToDoServiceImpl implements TODoService {
	private final ToDoRepository toDoRepository;

	public ToDoServiceImpl(ToDoRepository toDoRepository) {
		super();
		this.toDoRepository = toDoRepository;
	}

	@Override
	public ToDo createToDo(ToDo toDo) {
		// TODO Auto-generated method stub
		return toDoRepository.save(toDo);
	}

	@Override
	public Iterable<ToDo> fetchAllToDos() {
		// TODO Auto-generated method stub
		return toDoRepository.findAll();
	}

}
