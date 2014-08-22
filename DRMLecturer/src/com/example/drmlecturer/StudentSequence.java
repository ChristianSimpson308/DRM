package com.example.drmlecturer;

import java.io.Serializable;

public class StudentSequence implements Serializable {
	int StudentNumber,StudentSequenceID, ListID, ActivityID, Step, InitialX, InitialY, FinalX, FinalY;

	public StudentSequence(int studentID, int studentSequenceID, int listID,
			int activityID, int step, int initialX, int initialY, int finalX,
			int finalY) {
		super();
		StudentNumber = studentID;
		StudentSequenceID = studentSequenceID;
		ListID = listID;
		ActivityID = activityID;
		Step = step;
		InitialX = initialX;
		InitialY = initialY;
		FinalX = finalX;
		FinalY = finalY;
	}

	public int getStudentSequenceID() {
		return StudentSequenceID;
	}

	public int getStudentID() {
		return StudentNumber;
	}

	public void setStudentID(int studentID) {
		StudentNumber = studentID;
	}

	public void setStudentSequenceID(int studentSequenceID) {
		StudentSequenceID = studentSequenceID;
	}

	public int getListID() {
		return ListID;
	}

	public void setListID(int listID) {
		ListID = listID;
	}

	public int getActivityID() {
		return ActivityID;
	}

	public void setActivityID(int activityID) {
		ActivityID = activityID;
	}

	public int getStep() {
		return Step;
	}

	public void setStep(int step) {
		Step = step;
	}

	public int getInitialX() {
		return InitialX;
	}

	public void setInitialX(int initialX) {
		InitialX = initialX;
	}

	public int getInitialY() {
		return InitialY;
	}

	public void setInitialY(int initialY) {
		InitialY = initialY;
	}

	public int getFinalX() {
		return FinalX;
	}

	public void setFinalX(int finalX) {
		FinalX = finalX;
	}

	public int getFinalY() {
		return FinalY;
	}

	public void setFinalY(int finalY) {
		FinalY = finalY;
	}
}
