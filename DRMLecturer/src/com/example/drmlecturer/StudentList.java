package com.example.drmlecturer;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

public class StudentList extends Activity {
	public ArrayList<Student> StudentsDownloaded = new ArrayList<Student>();
	String TAG_SUCCESS = "success"; 
	 StudentListAdapter AdaptStudents;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_list);
		 getStudents s = new getStudents();
		 s.execute();
		
		
	}



	public class getStudents extends AsyncTask<String, String, String>
	{
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String StudentNumber = "";
			String StudentName = "";
			String StudentSurname= "";

			ArrayList<NameValuePair> List = new ArrayList<NameValuePair>();
			List.add(new BasicNameValuePair("StudentNumber", StudentNumber));
			List.add(new BasicNameValuePair("Name", StudentName));
			List.add(new BasicNameValuePair("Surname", StudentSurname));

			JSONParser jParser = new JSONParser();
			JSONObject json = jParser.makeHttpRequest("http://drm.csdev.nmmu.ac.za/getStudents.php", "GET", List);
			
			String TAG_NODES = "no";
			JSONArray NodesArray = null;
		
			try
			{
				
				int success = (json.getInt(TAG_SUCCESS));
				if(success == 1)
				{
					NodesArray = json.getJSONArray(TAG_NODES);
					
					for(int x = 0; x <= NodesArray.length()-1; x++)
					{
						JSONObject c = NodesArray.getJSONObject(x);
						
						String StNumber = c.getString("StudentNumber");
						String Name = c.getString("Name");
						String Surname = c.getString("Surname");
						Student S = new Student(StNumber, Name, Surname);
						StudentsDownloaded.add(S);
						
					}
			

				}
				
			}catch (JSONException d)
			{
				d.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					ListView ListOfStudents = (ListView)findViewById(R.id.listViewStudents);
					AdaptStudents = new StudentListAdapter(StudentList.this, StudentsDownloaded);
					ListOfStudents.setAdapter(AdaptStudents);
				}
			});
		}
			
		}
}
	
