package com.fullstackpractice.fullstackpractice.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<todoBean, Integer>{
	List<todoBean> findAll();
	
}
