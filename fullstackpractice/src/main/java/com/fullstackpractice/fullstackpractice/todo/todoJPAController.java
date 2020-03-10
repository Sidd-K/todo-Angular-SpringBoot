package com.fullstackpractice.fullstackpractice.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class todoJPAController {
	
	@Autowired
	private todoService todoService;
	
	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping("jpa/users/{username}/todos")
	public List<todoBean> getAll(@PathVariable String username){
		return todoRepository.findAll();
	}
	
	@DeleteMapping("jpa/users/{username}/todos/{id}")
	public void deleteById(@PathVariable String username, @PathVariable int id){
		todoRepository.deleteById(id);
	}
	
	@GetMapping("jpa/users/{username}/todos/{id}")
	public todoBean getTodo(@PathVariable String username, @PathVariable int id){
		return todoRepository.findById(id).get();
	}
	
	@PutMapping("jpa/users/{username}/todos/{id}")
	public void updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody todoBean todo){
		 todoRepository.save(todo);

	}
	
	@PostMapping("jpa/users/{username}/todos")
	public void addTodo(@PathVariable String username, @RequestBody todoBean todo){
		 todoBean TODO =  todoRepository.save(todo);
		 System.out.println(TODO);
	}
}