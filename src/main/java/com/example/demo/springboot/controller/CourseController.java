package com.example.demo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.exception.ResouceNotFoundException;
import com.example.demo.springboot.model.Course;
import com.example.demo.springboot.repository.CourseRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	// get all courses
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	//save a course
	//http://localhosst:8080/api/v1/courses
	@PostMapping("/courses")
	public Course addCourses(@RequestBody Course co) {
		Course getco = courseRepository.save(co);
		return getco;
	}
	
	@GetMapping("/courses/{id}")
	ResponseEntity<Course> getCoursebyId(@PathVariable Long id) { 
		@SuppressWarnings("deprecation")
		Course cou = courseRepository.findById(id)
			.orElseThrow(() -> new ResouceNotFoundException("Course does not exist with id: "+id));
		return ResponseEntity.ok().body(cou);
	}
	
	@PutMapping("/updatecourses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable long id, @RequestBody Course co) {
		//return null;
		Course cou = courseRepository.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Course does not exist with id: "+id));
		//long id1 = co.getId();
		//@SuppressWarnings("deprecation")
		//Course c = courseRepository.findById(id1).get();
		
		cou.setCname(co.getCname());
		cou.setCcode(co.getCcode());
		
		Course updatedCourse = courseRepository.save(cou);
		//return courseRepository.save(c);
		return ResponseEntity.ok(updatedCourse);
	}
	
	//delete mapping
	@DeleteMapping("/deletecourses")

	+
	blic void deleteCourse(@RequestParam long id) {
		courseRepository.deleteById(id);
	}

}
