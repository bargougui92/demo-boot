package com.example.demo.helloworld;

public class HelloWorldBean {

	//getters and setters are mandatory for Spring to be able to display the Json object
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HelloWorldBean(String string) {
		setMessage(string);
	}
	
	@Override
	public String toString() {
		return String.format("Hello world bean [message = %s]", message);
	}

}
