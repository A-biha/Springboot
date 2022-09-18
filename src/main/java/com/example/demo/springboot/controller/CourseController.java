package com.example.demo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.model.Course;
import com.example.demo.springboot.repository.CourseRepository;



@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/v1/")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	// get all courses
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}

}
