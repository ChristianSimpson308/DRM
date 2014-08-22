package com.example.drmsystem;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class UploadStudent extends Activity {
	
	
	private ProgressDialog pDialog;
	 
    // JSON parser class
    JSONParser jsonParser = new JSONParser();
 

    int StudentNum;
    static InputStream is = null;
    String StudentName;
    String StudentSurname;
    private static final String url_update_attendance = "http://drm.csdev.nmmu.ac.za/UploadStudent2.php";
    public UploadStudent( int StudentNum,String StudentName,String StudentSurname)
    {
    	this.StudentNum = StudentNum;
    	this.StudentName = StudentName; 
    	this.StudentSurname = StudentSurname;
    	new updateAttendanceDetails().execute();
    	
    }
 
    // url to update product
 
    // url to delete product
 
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_PRODUCT = "product";
    private static final String TAG_PID = "pid";
    private static final String TAG_NAME = "name";
    private static final String TAG_PRICE = "price";
    private static final String TAG_DESCRIPTION = "description";
    private int seshID = -1; 
    private int arrayPos = -1;
    ArrayList<Student> searchResults;

    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
       
	}
		

	
	class updateAttendanceDetails extends AsyncTask<String, String, String> {
		 
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           
        }
 
        /**
         * Saving product
         * */
        
        protected String doInBackground(String... args) {
        	
            // getting updated data from EditTexts
  
            // Building Parameters
        	

	            List<NameValuePair> params = new ArrayList<NameValuePair>();
	            params.add(new BasicNameValuePair("StudentNumber", String.valueOf(StudentNum)));
	            params.add(new BasicNameValuePair("Name", StudentName ));
	            params.add(new BasicNameValuePair("Surname",StudentSurname));
	           
	          
             
	  
	            // Notice that update product url accepts POST method
	            JSONObject json = jsonParser.makeHttpRequest(url_update_attendance, "POST", params);
        		
	           

        	
            return null;
            
        }
 
        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product uupdated
         //   Toast.makeText(getApplicationContext(), "Session successfully uploaded", Toast.LENGTH_LONG).show();
        }
    }

}
