package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.util.Courses;


@RestController
public class MyController {
	
	@Autowired
	private Courses courses;

	@Value("${message}")
	private String message;
	
	@Value("${databaseName}")
	private String databaseName;
	
	@GetMapping("/greet")
	public String greet() {
		return message;
	}
	@GetMapping("/show-db")
	public String showDB() {
		return "The adatabase used is "+ databaseName;
	}
	@GetMapping("/show-courses")
	public List<String> showCourses(){
		return courses.getCourseNames();
	}
	
	
}













