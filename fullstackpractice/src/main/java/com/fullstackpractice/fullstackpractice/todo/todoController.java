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
public class todoController {
	
	@Autowired
	private todoService todoService;
	
	@GetMapping("users/{username}/todos")
	public List<todoBean> getAll(@PathVariable String username){
		return todoService.getAll();
	}
	
	@DeleteMapping("users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String username, @PathVariable int id){
		todoBean todo = todoService.deleteByID(id);
		if(todo!= null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("users/{username}/todos/{id}")
	public todoBean getTodo(@PathVariable String username, @PathVariable int id){
		return todoService.findByID(id);
	}
	
	@PutMapping("users/{username}/todos/{id}")
	public ResponseEntity<todoBean> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody todoBean todo){
		todoBean todoBean = todoService.save(todo);
		
		return new ResponseEntity<todoBean>(todo, HttpStatus.OK);
	}
	
	@PostMapping("users/{username}/todos")
	public ResponseEntity<Void> addTodo(@PathVariable String username, @RequestBody todoBean todo){
		todoBean addedTodo = todoService.save(todo);
		// location  --> location is a response Header
		// get current resource URL
		// {id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedTodo.getId()).toUri();
		return  ResponseEntity.created(location).build();
	}
}