package com.myproject.app.ToDoList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.app.ToDoList.JpaRepository.TasksRepository;
import com.myproject.app.ToDoList.entity.Tasks;

@Service
public class TaskServiceImpl implements TaskService{

	// Inject JpaRepository (old DAO)
	
	private TasksRepository theTasksRepository;

	@Autowired
	public TaskServiceImpl(TasksRepository theTasksRepository) {
		this.theTasksRepository = theTasksRepository;
	}

	//Bring CRUD methods given by JpaRepository
	
	@Override
	public List<Tasks> findAll() {
		
		return theTasksRepository.findAll();
	}

	@Override
	public Tasks findById(int theId) {
		
		//Check if value is null or not null
		Optional<Tasks> result = theTasksRepository.findById(theId);
		
		Tasks theTask = null;
		if (result.isPresent())
		{
			//if value is not null
			theTask = result.get();
		}
		else
		{
			//if value is null
			throw new RuntimeException("Task with given ID couldn't be found " +theId );
		}
		
		return theTask;
	}

	@Override
	public void save(Tasks theTask) {
		
		theTasksRepository.save(theTask);
		
	}

	@Override
	public void deleteById(int theId) {
		
		theTasksRepository.deleteById(theId);
	}
	
	
}
