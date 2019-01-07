package com.example.demo.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class User {
	private Integer id;
	
	@Size(min = 2, message = "name should have at least two characters")
	private String name;
	
	@Past
	private Date birthday;
	
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}
	public User(Integer id , String name, java.util.Date date) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = date;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	//Oussama U need this for post call
	public User() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
