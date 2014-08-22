package com.example.drmlecturer;

import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.widget.Toast;

public class DownloadNodes extends AsyncTask<String, String, String> {
	public ArrayList<Node> NodesDownloaded = new ArrayList<Node>();
	String TAG_SUCCESS = "success"; 
	public DownloadNodes()
	{
		
	}

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		String NODEID = "";
		String X_val = "";
		String Y_val = "";
		String LX = "";
		String LY = "";
		String Ques = "";
		ArrayList<NameValuePair> List = new ArrayList<NameValuePair>();
		List.add(new BasicNameValuePair("NodeID", NODEID));
		List.add(new BasicNameValuePair("X", X_val));
		List.add(new BasicNameValuePair("Y", Y_val));
		List.add(new BasicNameValuePair("LtoX", LX));
		List.add(new BasicNameValuePair("LtoY", LY));
		List.add(new BasicNameValuePair("Content", Ques));
		JSONParser jParser = new JSONParser();
		JSONObject json = jParser.makeHttpRequest("http://drm.csdev.nmmu.ac.za/getnodes.php", "GET", List);
		
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
					
					String NodeID = c.getString("NodeID");
					String xVal = c.getString("X");
					String yVal = c.getString("Y");
					String L_X = c.getString("LtoX");
					String L_Y = c.getString("LtoY");
					String cnt = c.getString("Content");
				}
				

			}
			
		}catch (JSONException d)
		{
			d.printStackTrace();
		}
		return null;
	}
	

	
	

}
