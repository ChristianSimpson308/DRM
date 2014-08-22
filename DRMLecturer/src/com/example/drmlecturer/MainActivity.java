package com.example.drmlecturer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	Intent IseeStudents;
	Intent CreatenewActi;


	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		IseeStudents = new Intent(this, StudentList.class);
		CreatenewActi = new Intent(this, CreateNewActivity.class);
		Button SeeStudents = (Button)findViewById(R.id.Button02);
		Button UseBlank = (Button)findViewById(R.id.Button01);
		Button CreateAct = (Button)findViewById(R.id.btnNewActivity);
		Button DeployQuest = (Button)findViewById(R.id.Button03);
		Button ViewAct = (Button)findViewById(R.id.ButtonViewActivities);
		
		ViewAct.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent t = new Intent(getApplicationContext(), ActivityList.class);
				startActivity(t);
			}
		});
		

		SeeStudents.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(IseeStudents);
			}
		});
		
		CreateAct.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(CreatenewActi);
			}
		});
	
	}
	

	
	
		
	}
	




