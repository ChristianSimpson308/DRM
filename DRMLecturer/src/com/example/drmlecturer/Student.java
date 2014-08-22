package com.example.drmlecturer;

import java.io.Serializable;

public class Student implements Serializable {

	String Name, Surname, StudentNumber;
	
	public Student(String Name, String Surname, String StudentNumber)
	{
		this.Name = Name;
		this.Surname = Surname;
		this.StudentNumber = StudentNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getStudentNumber() {
		return StudentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		StudentNumber = studentNumber;
	}
}
