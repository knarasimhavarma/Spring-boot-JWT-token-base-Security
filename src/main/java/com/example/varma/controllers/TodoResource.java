package com.example.varma.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.varma.vo.Todo;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/todos")
public class TodoResource {
	List<Todo> list = new ArrayList<Todo>();
	long count = 101;
	{

		list.add(new Todo(count++, "Abhi", "Learn Dance", new Date(), false));
		list.add(new Todo(count++, "Ram", "Learn Angular", new Date(), false));
		list.add(new Todo(count++, "Varma", "Learn Microservice", new Date(), false));
		list.add(new Todo(count++, "Nani", "Learn DataStructure", new Date(), true));
	}
	LocalDate localDate = LocalDate.now();
	LocalTime localTime = LocalTime.now();
	LocalDateTime localDateTime = LocalDateTime.now();

	@GetMapping("/{username}/todos")
	public List<Todo> fetchTodos(@PathVariable String username) {
		return list;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id) {
		Todo todo = delete(id);
		if (todo != null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/user/{id}")
	public Todo getTodo(@PathVariable long id) {
		Todo todo = findById(id);
		if (todo != null)
			return todo;
		return todo;
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable long id, @RequestBody Todo todo) {
		int index = 0;
		if (todo != null)
			for (Todo td : list) {
				if (todo.getId() == td.getId())
					list.set(index, todo);
				index++;
			}
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}

	@PostMapping("/user/save")
	public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
		todo.setId(count++);
		list.add(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	public Todo delete(long id) {
		Todo todo = findById(id);
		if (todo == null)
			return null;
		if (list.remove(todo))
			return todo;
		return null;
	}

	private Todo findById(long id) {
		for (Todo todo : list)
			if (todo.getId() == id)
				return todo;

		return null;
	}
}
