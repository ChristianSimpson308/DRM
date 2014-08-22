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

public class ActivityList extends Activity {
	public ArrayList<ActivityC> StudentsDownloaded = new ArrayList<ActivityC>();
	String TAG_SUCCESS = "success"; 
	 ActivityListAdapter AdaptStudents;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blank);
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
			List.add(new BasicNameValuePair("Activity", StudentNumber));
			List.add(new BasicNameValuePair("Description", StudentName));


			JSONParser jParser = new JSONParser();
			JSONObject json = jParser.makeHttpRequest("http://drm.csdev.nmmu.ac.za/getActivities.php", "GET", List);
			
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
						
						String StNumber = c.getString("ActivityID");
						String Name = c.getString("Description");
					
						ActivityC S = new ActivityC(Integer.valueOf(StNumber), Name);
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
					ListView ListOfStudents = (ListView)findViewById(R.id.activitiesListView);
					AdaptStudents = new ActivityListAdapter(ActivityList.this, StudentsDownloaded);
					ListOfStudents.setAdapter(AdaptStudents);
				}
			});
		}
			
		}
}
	
