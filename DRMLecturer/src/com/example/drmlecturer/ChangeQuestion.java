package com.example.drmlecturer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangeQuestion extends Activity implements Serializable {

	ArrayList<Node> Nodes ;
	ArrayList<Successor> SuccessorNode;
	ArrayList<Predecessor> PredecessorNode;
	ArrayList<Successor> LinkList;
	
	JSONParser jsonParser = new JSONParser();
	EditText Ques;
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_question);
		Intent tt = getIntent();
		
		Nodes = (ArrayList<Node>)tt.getSerializableExtra("ActivityNode");
	    SuccessorNode = (ArrayList<Successor>)tt.getSerializableExtra("Successor");
		PredecessorNode = (ArrayList<Predecessor>)tt.getSerializableExtra("Predecessor");
		LinkList = (ArrayList<Successor>)tt.getSerializableExtra("LinkedList");
		final TextView Question = (TextView)findViewById(R.id.textViewActivityQuestion);
		ImageButton Saveit = (ImageButton)findViewById(R.id.imageButtonSaveActivity);
		
		 Ques = (EditText)findViewById(R.id.editTextConnect);
		
		Saveit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			String textval ;
			textval = Question.getText().toString();
			 new sentToDB().execute();
				Intent t = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(t);
				
			}
		});
	}
	
	
	public class sentToDB extends AsyncTask<String, String, String>
	{
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			//Send Nodes to MySQL Server
			final String url_update_attendance = "http://drm.csdev.nmmu.ac.za/UploadNode.php";
			 List<NameValuePair> param1 = new ArrayList<NameValuePair>();
			for(int x = 0; x <= Nodes.size()-1;x++)
			{
				
			   
			    param1.add(new BasicNameValuePair("NodeID", String.valueOf(Nodes.get(x).NodeID)));
	            param1.add(new BasicNameValuePair("X", String.valueOf(Nodes.get(x).getX())));
	            param1.add(new BasicNameValuePair("Y",String.valueOf(Nodes.get(x).getY())));
	            param1.add(new BasicNameValuePair("LtoX",String.valueOf(Nodes.get(x).getLtoX())));
	            param1.add(new BasicNameValuePair("LtoY",String.valueOf(Nodes.get(x).getLtoY())));
	            param1.add(new BasicNameValuePair("Content",Nodes.get(x).getContent()));
	            JSONObject json = jsonParser.makeHttpRequest(url_update_attendance, "POST", param1);
			} 
           //Send Activity to MySQL Server
			final String URL5 = "http://drm.csdev.nmmu.ac.za/UploadSuccessor.php";
			List<NameValuePair> param2 = new ArrayList<NameValuePair>();
			for(int x = 0; x <= SuccessorNode.size()-1;x++)
			{	
				
			    
			    param2.add(new BasicNameValuePair("NodeID", String.valueOf(SuccessorNode.get(x).NodeID)));
	            param2.add(new BasicNameValuePair("SuccessorID", String.valueOf(SuccessorNode.get(x).SuccessorNodeID)));
	            param2.add(new BasicNameValuePair("StartX",String.valueOf(SuccessorNode.get(x).PStartX)));
	            param2.add(new BasicNameValuePair("StartY",String.valueOf(SuccessorNode.get(x).PStartY)));
	            param2.add(new BasicNameValuePair("EndX",String.valueOf(SuccessorNode.get(x).PEndX)));
	            param2.add(new BasicNameValuePair("EndY",String.valueOf(SuccessorNode.get(x).PEndY)));
	            JSONObject json = jsonParser.makeHttpRequest(URL5, "POST", param2);
			}   
			
			 List<NameValuePair> param3 = new ArrayList<NameValuePair>();
				final String URL1 = "http://drm.csdev.nmmu.ac.za/UploadPredecessor.php";
			//Upload PredecessorList
			for(int x = 0; x <= PredecessorNode.size()-1;x++)
			{	
			
			   
			    param3.add(new BasicNameValuePair("NodeID", String.valueOf(PredecessorNode.get(x).NodeID)));
	            param3.add(new BasicNameValuePair("PredecessorID", String.valueOf(PredecessorNode.get(x).PredecessorNodeID)));
	            param3.add(new BasicNameValuePair("StartX",String.valueOf(PredecessorNode.get(x).PStartX)));
	            param3.add(new BasicNameValuePair("StartY",String.valueOf(PredecessorNode.get(x).PStartY)));
	            param3.add(new BasicNameValuePair("EndX",String.valueOf(PredecessorNode.get(x).PEndX)));
	            param3.add(new BasicNameValuePair("EndY",String.valueOf(PredecessorNode.get(x).PEndY)));
	            JSONObject json = jsonParser.makeHttpRequest(URL1, "POST", param3);
			}    
	  
	            // Notice that update product url accepts POST method
	           
      		
			final String URL2 = "http://drm.csdev.nmmu.ac.za/UploadActivity.php";
		    List<NameValuePair> param = new ArrayList<NameValuePair>();
		    param.add(new BasicNameValuePair("ListID", "1"));
            param.add(new BasicNameValuePair("NodeID", "0"));
            param.add(new BasicNameValuePair("ActivityID", "1"));
            param.add(new BasicNameValuePair("Description", Ques.getText().toString()));
            JSONObject json = jsonParser.makeHttpRequest(URL2, "POST", param);
      	
          return null;
          
		}

	}
}
