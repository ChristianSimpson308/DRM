package com.example.drmlecturer;

import java.io.Serializable;

public class ActivityC implements Serializable {
	
	int ActivityID;
	String description;
	public ActivityC(int activityID, String description) {
		super();
		ActivityID = activityID;
		this.description = description;
	}
	public int getActivityID() {
		return ActivityID;
	}
	public void setActivityID(int activityID) {
		ActivityID = activityID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

		
	

}
