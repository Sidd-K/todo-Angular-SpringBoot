package com.fullstackpractice.fullstackpractice.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.fullstackpractice.fullstackpractice.todo.todoBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class todoService {

	
	private static List<todoBean> todos = new ArrayList();
	private static int idCounter = 0;
	
	
	static {
		todos.add(new todoBean(++idCounter, "Sidd", "Order pizza", new Date(), false));
		todos.add(new todoBean(++idCounter, "Sidd", "Go Cult", new Date(), false));
		todos.add(new todoBean(++idCounter, "Sidd", "Eat pizza", new Date(),false));
		todos.add(new todoBean(++idCounter, "Sidd", "Sleep Tight", new Date(),false));

	}
	
	// Get All(with Static block)
	public List<todoBean> getAll(){
		return todos;
	}
	
//	public List<todoBean> findAll(){
//		return todoRepository.findAll();
//	}
	
	public todoBean save(todoBean todo) {
		if(todo.getId()==-1 || todo.getId()== 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}
		else {
			deleteByID(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

	public todoBean deleteByID(int id) {
		todoBean todo = findByID(id);
		if(todo == null)
			return null;
		if(todos.remove(todo))
			return todo;
		return null;
	}

	public todoBean findByID(int id) {
		for(todoBean todo: todos) {
			if(todo.getId()== id) {
				return todo;
			}
		}
		return null;
	}
	
}
