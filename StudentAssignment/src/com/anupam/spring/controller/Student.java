package com.anupam.spring.controller;

public class Student {
	private String name;
	private int rollNo;
	private String result;
	
	public Student(String name, int rollNo, String result) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", result="
				+ result + "]";
	}
	
}
