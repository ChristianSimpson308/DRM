package com.example.drmsystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		Button login = (Button)findViewById(R.id.bttn1);
		final DBhelper help = new DBhelper(this);
		login.setOnClickListener(new OnClickListener() {
		
		Intent StudentIntent;
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				EditText Name = (EditText)findViewById(R.id.edtTxtName);
				EditText Surname = (EditText)findViewById(R.id.EdttxtSurname);
				EditText StudentNumber = (EditText)findViewById(R.id.edttxtStudentNumber);
				if(Name != null && Surname != null && StudentNumber != null)
				{
					UploadStudent Up = new UploadStudent(Integer.valueOf(StudentNumber.getText().toString()), Name.getText().toString(), Surname.getText().toString());
					Intent To_Main_Menu = new Intent(getApplicationContext(), StudentMenu.class);
					startActivity(To_Main_Menu);
//					String RealName = Name.getText().toString();
//					String RealSurname = (Surname.getText().toString());
//					int RealStudnetNumber = Integer.valueOf(StudentNumber.getText().toString());
//					//I need to check that the S is in the correct order!
//					Student S = new Student(RealName, RealSurname, RealStudnetNumber);
//					help.InsertStudent(S);
//					StudentIntent = new Intent(getApplicationContext(), StudentMenu.class);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		
		return true;
	}

}
