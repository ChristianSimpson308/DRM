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
public class StudentListAdapter extends ArrayAdapter<Student> {

	
	private Context context;
	private ArrayList<Student> ListStudents;	
	public StudentListAdapter(Context context, ArrayList<Student> StudentList)
	{	
		super(context, R.layout.activity_student_list_adapter, StudentList);
		this.context = context;
		this.ListStudents = StudentList;
	}


@Override
public View getView(int Position, View convertView, ViewGroup parent){
	
	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	View StudentsView = inflater.inflate(R.layout.activity_student_list_adapter, parent,false);
	StudentsView.setTag(ListStudents.get(Position));
	
	TextView StudentNum = (TextView)StudentsView.findViewById(R.id.textVstuN);
	TextView StudentName = (TextView)StudentsView.findViewById(R.id.textVname);
	TextView StudentSurname = (TextView)StudentsView.findViewById(R.id.textvSurname);
	
	StudentNum.setText(ListStudents.get(Position).StudentNumber);
	StudentName.setText(ListStudents.get(Position).Name);
	StudentSurname.setText(ListStudents.get(Position).Surname);
	
	
	return StudentsView;
}

}