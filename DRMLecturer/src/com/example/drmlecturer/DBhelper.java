package com.example.drmlecturer;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;


import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class DBhelper extends SQLiteAssetHelper {
	

	Context context;
	public static final String DBName = "DRMdatabase";
	public static final int DBversion = 1;
	

	public DBhelper(Context context)
	{
		super(context, DBName, null, DBversion);
		this.context = context;
		
	}
	
	
	public ArrayList<Student>  getAllStudents()
	{
		
		SQLiteDatabase myDB = getWritableDatabase();
		String SQL = "SELECT * FROM Student";
		Cursor c = myDB.rawQuery(SQL, null);
		c.moveToFirst();
		ArrayList<Student> StudentList = new ArrayList<Student>();
		boolean check = false;
		while(c.moveToNext() != false)
		{
			if(check = false)
			{
				c.moveToFirst();
				check = true;
			}
			else
			{
				String StudentNumber = c.getString(c.getColumnIndex("StudentNumber"));
				String Name = c.getString(c.getColumnIndex("Name"));
				String Surname = c.getString(c.getColumnIndex("Surname"));
				StudentList.add(new Student(StudentNumber, Name, Surname));
				
			}
			
		}
		myDB.close();
		
		return StudentList;
	}
	
	public void InsertStudent(Student S)
	{
		SQLiteDatabase myDB = getWritableDatabase();
		
		
		ContentValues values = new ContentValues();
		
		values.put("StudentNumber", S.getStudentNumber());
		values.put("Name", S.getName());
		values.put("Surname", S.getSurname());
		myDB.insert("Student", "nullColumnHack", values);
		myDB.close();

	}
	
	
	
	
//	public void InsertDriveBooking(GameDrive GD)
//	{
//		SQLiteDatabase myDB = getWritableDatabase();
//		
//		 ContentValues values = new ContentValues();
//		 values.put("CustomerID", GD.CustID );   
//		 values.put("NoCustomers", GD.NoCusts); 
//		 values.put("Date", GD.Date);
//		myDB.insert("GameDrive", "nullColumnHack", values);
//		myDB.close();
//	}
	


	
	
	
//	public int getSpeciesCount(String SPCode)
//	{
//		SQLiteDatabase myDB = getWritableDatabase();
//		Cursor c = myDB.rawQuery("SELECT Count(*) FROM Species WHERE SpeciesID = '"+SPCode+"';", null);
//		c.moveToFirst();
//		int count= c.getInt(0);
//		c.close();
//		myDB.close();
//		return count;
//	}
	

}
