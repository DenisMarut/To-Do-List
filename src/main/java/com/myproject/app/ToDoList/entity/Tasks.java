package com.myproject.app.ToDoList.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Tasks {

	//Define fields and map them to MySql table
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//auto generated value for this field (primary Key)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date")
	private Date date;
	
	// Constructors
	public Tasks() {
		
	}

	public Tasks(int id, String title, String description, Date date) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
	}

	public Tasks(String title, String description, Date date) {
		this.title = title;
		this.description = description;
		this.date = date;
	}

	// Define getters / setters for fields
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

	
}
