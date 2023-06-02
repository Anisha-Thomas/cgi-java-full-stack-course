package org.demo.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity(name = "Todo")
public class Todo {

	@Id
	@Column(name = "todo_id")
	public int todoId;
	@Column(name = "todo_name")
	public String todoName;
	@Column(name = "is_completed")
	public boolean isCompleted=true;

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		if(isCompleted==true) {
			this.isCompleted= true;
		}else {
			this.isCompleted= false;
		}
	}

	public Todo(int todoId, String todoName, boolean isCompleted) {
		this.todoId = todoId;
		this.todoName = todoName;
		this.isCompleted = isCompleted;
	}

	public Todo() {
	}

	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", todoName=" + todoName + ", isCompleted=" + isCompleted + "]";
	}

}
