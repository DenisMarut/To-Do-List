package com.myproject.app.ToDoList.service;

import java.util.List;

import com.myproject.app.ToDoList.entity.Tasks;

public interface TaskService {

	public List<Tasks> findAll();
	
	public Tasks findById(int theId);
	
	public void save(Tasks theTask);
	
	public void deleteById(int theId);
}
