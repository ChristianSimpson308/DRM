package com.example.drmlecturer;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
public class ActivityListAdapter extends ArrayAdapter<ActivityC> {

	
	private Context context;
	private ArrayList<ActivityC> ListStudents;	
	public ActivityListAdapter(Context context, ArrayList<ActivityC> StudentList)
	{	
		super(context, R.layout.activity_activity_list_adapter, StudentList);
		this.context = context;
		this.ListStudents = StudentList;
	}


@Override
public View getView(int Position, View convertView, ViewGroup parent){
	
	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	View StudentsView = inflater.inflate(R.layout.activity_activity_list_adapter, parent,false);
	StudentsView.setTag(ListStudents.get(Position));
	
	TextView StudentNum = (TextView)StudentsView.findViewById(R.id.ActivityListNumber);
	TextView StudentName = (TextView)StudentsView.findViewById(R.id.ActivityListName);
	
	
	StudentNum.setText(String.valueOf(ListStudents.get(Position).ActivityID));
	StudentName.setText(ListStudents.get(Position).description);

	
	
	return StudentsView;
}

}