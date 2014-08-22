package com.example.drmlecturer;

public class SolutionSequence {
	int SequenceID, ListID, ActivityID, Step, InitialX, InitialY, EndX, EndY;
	
	public int getSequenceID() {
		return SequenceID;
	}

	public void setSequenceID(int sequenceID) {
		SequenceID = sequenceID;
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

	public int getEndX() {
		return EndX;
	}

	public void setEndX(int endX) {
		EndX = endX;
	}

	public int getEndY() {
		return EndY;
	}

	public void setEndY(int endY) {
		EndY = endY;
	}

	public SolutionSequence(int sequenceID, int listID, int activityID,
			int step, int initialX, int initialY, int endX, int endY) {
		super();
		SequenceID = sequenceID;
		ListID = listID;
		ActivityID = activityID;
		Step = step;
		InitialX = initialX;
		InitialY = initialY;
		EndX = endX;
		EndY = endY;
	}
	
	
}
