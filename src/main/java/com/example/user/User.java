package com.example.user;

import java.util.Date;

public class User {
	private Integer id;
	
	private String name;
	
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
