package com.example.demo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.springboot.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
