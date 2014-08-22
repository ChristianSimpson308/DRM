package com.example.drmlecturer;

import org.apache.http.client.CircularRedirectException;

import android.os.Bundle;
import android.R.menu;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;


import java.util.ArrayList;

public class CreateNewActivity extends Activity{


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new DrawingClass(this));
		
		
		
		
		


		
	}
	
	

}

