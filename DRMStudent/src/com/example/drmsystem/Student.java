package com.example.drmsystem;

public class Student {

	String Name, Surname;
	int StudentNumber;
	
	public Student(String Name, String Surname, int StudentNumber)
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

	public int getStudentNumber() {
		return StudentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		StudentNumber = studentNumber;
	}
}
