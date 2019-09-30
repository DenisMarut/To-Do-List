package com.myproject.app.ToDoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.app.ToDoList.entity.Tasks;
import com.myproject.app.ToDoList.entity.TasksArchive;
import com.myproject.app.ToDoList.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	//Inject service layer (field injection)
	@Autowired
	private TaskService theTaskService;
	
	//Add mapping for "/list"
	@GetMapping("/list")
	public String listOfTasks(Model theModel)
	{
		//Retrieve tasks from DataBase
		List<Tasks> theTasks = theTaskService.findAll();
		
		//Add data to model
		theModel.addAttribute("tasks", theTasks);
		
		return "tasks/task-list";
	}
	
	@GetMapping("/archive")
	public String listOfArchivedTasks(Model theModel)
	{
		List<TasksArchive> theTasksArchived = theTaskService.showArchivedTasks();
		
		theModel.addAttribute("tasksArchived", theTasksArchived);
		
		return "tasks/task-arch-list";
	}
	
	
	//Add mapping for "/add"
	@GetMapping("/add")
	public String addTask(Model theModel)
	{
		//Create model attribute to bind data
		Tasks theTask = new Tasks();
		
		theModel.addAttribute("task",theTask);
		
		return "tasks/task-form";
	}
	
	//Add mapping for "/update"
	@GetMapping("/update")
	public String updateTask(@RequestParam("taskId") int theId, Model theModel)
	{
		//Get existing task from service
		Tasks theTask = theTaskService.findById(theId);
		
		//Pre-populate the form
		theModel.addAttribute("task",theTask);
		
		return "tasks/task-form";
	}
	
	//Add mapping for "/save"
	@PostMapping("/save")
	public String saveTask(@ModelAttribute("task") Tasks theTask)
	{
		//save task
		theTaskService.save(theTask);
		
		//Redirect to main page (avoid duplication)
		return "redirect:/tasks/list";
	}
	
	//Add mapping for "/delete"
	@GetMapping("/delete")
	public String deleteTask(@RequestParam("taskId") int theId)
	{
		//delete task found by Id
		theTaskService.deleteById(theId);
		
		//Redirect to main page (list of tasks)
		return "redirect:/tasks/list";
	}
	
	@GetMapping("/arch")
	public String archiveTask(@RequestParam("taskId") int theId, Model theModel)
	{
		
		//Get the existing task from table (tasks)
		Tasks theTask = theTaskService.findById(theId);
		
		//theTask.getTitle();
		//theTask.getDate();
		//theTask.getDescription();
		
		TasksArchive theTaskArch = new TasksArchive();
		
		theTaskArch.setId(0);
		theTaskArch.setTitle(theTask.getTitle());
		theTaskArch.setDescription(theTask.getDescription());
		theTaskArch.setDate(theTask.getDate());
		// save this task to another table (tasks_arch)
		theTaskService.saveToArch(theTaskArch);
		
		//theTaskService.archive(theTask);
		
		//delete the task from table (tasks)
		theTaskService.deleteById(theId);
		
		return "redirect:/tasks/list";
	}
}
