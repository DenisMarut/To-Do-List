package com.myproject.app.ToDoList.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.app.ToDoList.entity.TasksArchive;

public interface TasksRepositoryArchive extends JpaRepository<TasksArchive, Integer> {

	// Using JpaRepository to get access to all CRUD methods
	
}
