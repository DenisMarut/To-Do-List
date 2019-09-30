package com.myproject.app.ToDoList.service;

import java.util.List;

import com.myproject.app.ToDoList.entity.Tasks;
import com.myproject.app.ToDoList.entity.TasksArchive;

public interface TaskService {

	public List<Tasks> findAll();
	
	public Tasks findById(int theId);
	
	public void save(Tasks theTask);
	
	public void deleteById(int theId);
	
	
	
	public List<TasksArchive> showArchivedTasks();
	
	public void saveToArch(TasksArchive theTask);
	
	public void archive(TasksArchive theTaskArchived);
	
}
