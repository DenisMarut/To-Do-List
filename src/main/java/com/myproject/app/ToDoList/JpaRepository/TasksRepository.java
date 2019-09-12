package com.myproject.app.ToDoList.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.app.ToDoList.entity.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Integer> {

	// Using JpaRepository to get access to all CRUD methods
}
