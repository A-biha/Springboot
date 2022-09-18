package com.example.demo.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")

public class Course {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;

	 @Column(name = "course_code")
	 private String Ccode;
	 @Column(name = "course_name")
	 private String Cname;
 
	 public Course() {
	 
	 }
 
	 public long getId() {
		return id;
	 }
	
	 public void setId(long id) {
		this.id = id;
	 }
	
	 public Course(String ccode, String cname) {
		super();
		Ccode = ccode;
		Cname = cname;
	 }
	
	 public String getCcode() {
		return Ccode;
	 }
	
	 public void setCcode(String ccode) {
		Ccode = ccode;
	 }
	
	 public String getCname() {
		return Cname;
	 }
	
	 public void setCname(String cname) {
		Cname = cname;
	 }
 
}