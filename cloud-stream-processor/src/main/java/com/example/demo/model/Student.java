package com.example.demo.model;

public class Student {

	
	private int id;
	private String name;
	private double mark;
	private String result;
	
	public Student() {
		super();
	}
	
	public Student(int id, String name, double mark) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mark=" + mark + ", result=" + result + "]";
	}
	
	
}
