package com.example.todo.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="todo_table")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="todo_id")
	public int todoId;
	@Column(name="todo_name")
	public String todoName;
	@Column(name="is_completed")
	//@Enumerated(EnumType.STRING)
	public Completed isCompleted;
	public Todo(int todoId, String todoName, Completed isCompleted) {
		super();
		this.todoId = todoId;
		this.todoName = todoName;
		this.isCompleted = isCompleted;
	}
	public Todo() {
		super();
	}
	
	
}
