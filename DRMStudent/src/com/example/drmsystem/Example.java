package com.example.drmsystem;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.content.Context;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import android.widget.LinearLayout;
import android.widget.PopupMenu;


public class Example extends View {
    int Radius = 50;
    int LineEndX = 250;
    int LineEndY = 250;
    //ArrayLists for Data on lists
    ArrayList<ActivityC> ActivityList = new ArrayList<ActivityC>();
    ArrayList<Node> NodesList = new ArrayList<Node>();
    ArrayList<Successor> SuccessorList = new ArrayList<Successor>();
    ArrayList<Predecessor> PredecessroList = new ArrayList<Predecessor>();
    ArrayList<LinkedList> LinkListList = new ArrayList<LinkedList>();
  

    Paint BackP;
	ArrayList<Node> Nodes = new ArrayList<Node>();

    int x = 150;
    int y = 150;
    int TouchX, TouchY;
    View CaptionView;
    public Example(Context context) {
        super(context);
        setFocusable(true);
  
      
        BackP = new Paint();
        BackP.setColor(Color.BLACK);
       

    }
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		//canvas.translate(100f, 100f);
		canvas.drawColor(Color.rgb(153, 187, 188));
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.recycle);

       canvas.drawBitmap(bmp, 1100, 530, null); // 24 is the height of image

       //Bitmap SaveActivity = BitmapFactory.decodeResource(getResources(), R.drawable.save);
       // canvas.drawBitmap(SaveActivity, 1100, 50, null );


       Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.newnode);
        canvas.drawBitmap(bmp1, 1100, 400, null); // 24 is the height of image

        //Foreground Color
        Paint FrontP = new Paint();
        FrontP.setColor(Color.CYAN);
        //Pointer Color

        Paint PointerP = new Paint();
        PointerP.setColor(Color.BLACK);
        PointerP.setStrokeWidth(5f);


        //Text Setting
        Paint Textp = new Paint();
        Textp.setTextSize(15);
        Textp.setColor(Color.BLACK);

        for(int u = 0; u <= Nodes.size()-1;u++)
        {

            canvas.drawCircle(Nodes.get(u).getX(), Nodes.get(u).getY(), Radius+4,BackP);
            canvas.drawCircle(Nodes.get(u).getX(), Nodes.get(u).getY(), Radius,FrontP);
            canvas.drawText(Nodes.get(u).getContent(), Nodes.get(u).getX()-15, Nodes.get(u).getY()-5, Textp);
            canvas.drawLine(Nodes.get(u).getX()+45, Nodes.get(u).getY()+20, Nodes.get(u).getLtoX(),Nodes.get(u).getLtoY(),PointerP);
            canvas.drawLine(Nodes.get(u).getLtoX()+3, Nodes.get(u).getLtoY(), Nodes.get(u).getLtoX()-15,Nodes.get(u).getLtoY(),PointerP);
            canvas.drawLine(Nodes.get(u).getLtoX(), Nodes.get(u).getLtoY()+3, Nodes.get(u).getLtoX(),Nodes.get(u).getLtoY()-15,PointerP);
        }


	}



	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
        int EventAction = event.getAction();
        int X = (int)event.getX();
        int Y = (int)event.getY();
        double XPart = 0;
        double YPart = 0;
        double distance =0;
        double XPartNode = 0;
        double YPartNode = 0;
        double distanceNComp = 0;
        //Find which object im clicking on
        //calculate length of line from center of circle to point clicked - if less than 50 move it :)
        boolean isOverNode = false;
        boolean TopPointer = false;
        boolean top = false;
        int IDtoChange = 0;
        switch(EventAction)
        {
            case MotionEvent.ACTION_MOVE:
            {

                //Checking to see of the Node is taken to trashcan:


                    //To move a Node
                     for(int u = Nodes.size()-1; u >= 0; u--)
                         {
                             
                             distance = CalculateDistance(X, Y, Nodes.get(u).getX(), Nodes.get(u).getY());
                                   if(distance <= 50 && top == false)
                                       {
                                           Nodes.get(u).setX(X);
                                           Nodes.get(u).setY(Y);
                                           top = true;

                                         if(Nodes.get(u).getPrevNodeID()!=0)
                                         {
                                           for(int d = 0; d <= Nodes.size()-1; d++)
                                           {
                                               if(Nodes.get(u).getPrevNodeID() == (Nodes.get(d).getNodeID()))
                                               {
                                                   Nodes.get(d).setLtoX(Nodes.get(u).getX() - 40);
                                                   Nodes.get(d).setLtoY(Nodes.get(u).getY() - 40);
                                               }
                                           }
                                         }

                                           if(1100 - Nodes.get(u).getX() <= 50 && 530 - Nodes.get(u).getY() <= 50 )
                                           {
                                               deleteNode(Nodes.get(u).NodeID);
                                           }

                                       }
                         }
                //To move a pointer
                boolean onlyOne = false;
                for(int c = Nodes.size()-1; c >= 0; c--)
                {
                    //finding out if you want to drag a pointer
                    distance = CalculateDistance(X, Y, Nodes.get(c).getLtoX(), Nodes.get(c).getLtoY());
                    if(distance <= 25 && TopPointer == false)
                    {
                        //touching the pointer
                        IDtoChange = Nodes.get(c).getNodeID();
                        //moving the Pointer
                        Nodes.set(c, new Node(Nodes.get(c).getX(),Nodes.get(c).getY(), X, Y,Nodes.get(c).getNodeID(), Nodes.get(c).getContent() ));
                        TopPointer = true;

                        //GO THROUGH EACH ONE IN  THE LIST
                        for(int r = Nodes.size()-1; r >= 0; r--)
                        {
                          
                            distanceNComp = CalculateDistance(X, Y, Nodes.get(r).getX(), Nodes.get(r).getY());
                        if(distanceNComp <= 50)
                        {
                        	Nodes.get(c).setLtoX(Nodes.get(r).getX());
                        	Nodes.get(c).setLtoY(Nodes.get(r).getY());
                           ///Set Position of Pointer to Top-Left of Node Selected
                           Nodes.get(r).setPrevNodeID(Nodes.get(c).getNodeID());
                           Nodes.get(c).setNextNodeID(Nodes.get(r).getNodeID());
                       //    Log.e("NODE ID:",String.valueOf(Nodes.get(r).getNodeID()));
                       //     Log.e("PREV Node",String.valueOf(Nodes.ge) );


                      
                        } else
                        {

                            Nodes.get(r).setNextNodeID(0);


                            for(int t = 0; t <= Nodes.size()-1; t++)
                            {
                                if(Nodes.get(t).getNodeID() == IDtoChange)
                                {
                                    Nodes.get(t).setNextNodeID(0);
                                }
                                if(Nodes.get(r).getPrevNodeID() == IDtoChange)
                                {
                                    Nodes.get(r).setPrevNodeID(0);
                                }
                            }
                        }
                            //This is not working properly

                      }

                    }

                }

                break;
            }
            case MotionEvent.ACTION_UP:
            {
                break;
            }
            case MotionEvent.ACTION_DOWN:
            {
                for( int u = Nodes.size()-1; u >= 0; u--)
                {
                    
                    distance = CalculateDistance(X, Y, Nodes.get(u).getX(), Nodes.get(u).getY());

                //Sorting out the naming of nodes
                    if(distance <= 50)
                    {
                        int thisID = Nodes.get(u).getNodeID();
                        //Change the Writing on the Node (Content)
                        for(int z =0; z <= Nodes.size()-1; z++)
                        {

                        }
                    }


                    }

                final int X_New_Node_Position = 1100;
                final int X_New_Node_Width = 50;
                final int Y_New_Node_Position = 400;
                final int Y_New_Node_Height = 50;
                //If add new node button clicked
                if(X_New_Node_Position-X <= X_New_Node_Width && Y_New_Node_Position-Y <= Y_New_Node_Height)
                {
                    int max = 0;
                    for (int v = 0; v <= Nodes.size()-1; v++)
                    {
                        if(Nodes.get(v).getNodeID() > max)
                        {
                            max = Nodes.get(v).getNodeID() ;
                        }
                    }
                    Nodes.add(new Node(500,400,600,600,max+1,"Node" + max));
                }



                final int X_Save = 1100;
                final int X_Save_Height = 40;
                final int Y_Save_Width = 100;
                if(X_Save-X <= X_Save_Height && Y <= Y_Save_Width) {
                    //Save the data Structure
                //	Context context = getContext();
                	//Intent ToQuestion = new Intent(context, ChangeQuestion.class);
                //	Bundle SendNodes = new Bundle();
                //	SendNodes.putSerializable("ActivityNodes", Nodes);
                //	ToQuestion.putExtra("ActivityNodes", SendNodes);
                //	context.startActivity(ToQuestion);
                }
                break;
            }

        }


        invalidate();
            return true;
        }

    public void deleteNode(int NodeID)
    {
        for(int x = 0; x <= Nodes.size()-1;x++)
        {
            if(Nodes.get(x).getNodeID() == (NodeID))
            {
                Nodes.remove(x);
            }

        }
    }
    
    private double CalculateDistance(int ClickX, int ClickY, int ObjectX, int ObjectY)
    {
    
    	double x_Section_of_Formula =   Math.pow(ObjectX - ClickX, 2);
    	double y_Section_of_Formula    =   Math.pow(ObjectY - ClickY,2);
    	double distance = Math.sqrt(x_Section_of_Formula + y_Section_of_Formula);
    	
    	return distance;
    }
    

    public class getActivity extends AsyncTask<String, String, String>
    {
    	
    	String TAG_SUCCESS = "success"; 
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			//Get Activity
			getActivity();
			getPredecessor();
			getSuccessor();
			getNodes();
			getLinkedList()
    	return null;
    }
		
		private void getActivity()
		{
			String StudentNumber = "";
			String StudentName = "";
			//GetActivty
			ArrayList<NameValuePair> List = new ArrayList<NameValuePair>();
			List.add(new BasicNameValuePair("ActivityID", StudentNumber));
			List.add(new BasicNameValuePair("Description", StudentName));
			

			JSONParser jParser = new JSONParser();
			JSONObject json = jParser.makeHttpRequest("http://drm.csdev.nmmu.ac.za/getActivities.php", "GET", List);
			
			String TAG_NODES = "no";
			JSONArray ActivityArray = null;
		
			try
			{
				
				int success = (json.getInt(TAG_SUCCESS));
				if(success == 1)
				{
					ActivityArray = json.getJSONArray(TAG_NODES);
					
					for(int x = 0; x <= ActivityArray.length()-1; x++)
					{
						JSONObject c = ActivityArray.getJSONObject(x);
						
						String ActivityID = c.getString("ActivityID");
						String descr = c.getString("Description");
					
						ActivityC S = new ActivityC(Integer.valueOf(ActivityID), descr);
						ActivityList.add(S);
						
					}
			

				}
				
			}catch (JSONException d)
			{
				d.printStackTrace();
			}
			
		
		}
		
		private void getLinkedList()
		{
			String NodeID = "";
			String ListID = "";
			//GetActivty
			ArrayList<NameValuePair> List = new ArrayList<NameValuePair>();
			List.add(new BasicNameValuePair("ListID", ListID));
			List.add(new BasicNameValuePair("NodeID", NodeID));
			

			JSONParser jParser = new JSONParser();
			JSONObject json = jParser.makeHttpRequest("http://drm.csdev.nmmu.ac.za/getListList.php", "GET", List);
			
			String TAG_NODES = "no";
			JSONArray LListArray = null;
		
			try
			{
				
				int success = (json.getInt(TAG_SUCCESS));
				if(success == 1)
				{
					LListArray = json.getJSONArray(TAG_NODES);
					
					for(int x = 0; x <= LListArray.length()-1; x++)
					{
						JSONObject c = LListArray.getJSONObject(x);
						
						String LListID = c.getString("ListID");
						String ListNodeID = c.getString("NodeID");
					
						LinkedList L = new LinkedList(Integer.valueOf(LListID), Integer.valueOf(ListNodeID));
						LinkListList.add(L);
						
					}
			

				}
				
			}catch (JSONException d)
			{
				d.printStackTrace();
			}
			
		
		}
		
		private void getSuccessor()
		{
			String NodeID  = "";
			String SuccessorID = "";
			String StartX = "";
			String StartY = "";
			String EndX = "";
			String EndY = "";
			//GetActivty
			ArrayList<NameValuePair> List = new ArrayList<NameValuePair>();
			List.add(new BasicNameValuePair("NodeID", NodeID));
			List.add(new BasicNameValuePair("SuccessorId", SuccessorID));
			List.add(new BasicNameValuePair("StartX", StartX));
			List.add(new BasicNameValuePair("StartY", StartY));
			List.add(new BasicNameValuePair("EndX", EndX));
			List.add(new BasicNameValuePair("EndY", EndY));
			

			JSONParser jParser = new JSONParser();
			JSONObject json = jParser.makeHttpRequest("http://drm.csdev.nmmu.ac.za/getSuccessor.php", "GET", List);
			
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
						
						String ID = c.getString("NodeID");
						String Successor_NodeID = c.getString("SuccessorID");
						String Successor_StartX = c.getString("StartX");
						String Successor_StartY = c.getString("StartY");
						String Successor_EndX = c.getString("EndX");
						String Successor_EndY = c.getString("EndY");
					    Successor S = new Successor(Integer.valueOf(ID),Integer.valueOf(Successor_NodeID), Integer.valueOf(Successor_StartX), Integer.valueOf(Successor_StartY), Integer.valueOf(Successor_EndX), Integer.valueOf(Successor_EndY));
						SuccessorList.add(S);
						
					}
			

				}
				
			}catch (JSONException d)
			{
				d.printStackTrace();
			}
			
		
		}

		private void getPredecessor()
		{
			String Predecessor_NodeID = "";
			String PreDecessorID = "";
			String Predecessor_StartX = "";
			String Predecessor_StartY = "";
			String Predecessor_EndX = "";
			String Predecessor_EndY = "";
			
			//GetActivty
			ArrayList<NameValuePair> List = new ArrayList<NameValuePair>();
			List.add(new BasicNameValuePair("NodeID", Predecessor_NodeID));
			List.add(new BasicNameValuePair("PredecessorID", PreDecessorID));
			List.add(new BasicNameValuePair("StartX", Predecessor_StartX));
			List.add(new BasicNameValuePair("StartY", Predecessor_StartY));
			List.add(new BasicNameValuePair("EndX", Predecessor_EndX));
			List.add(new BasicNameValuePair("EndY", Predecessor_EndY));
			

			JSONParser jParser = new JSONParser();
			JSONObject json = jParser.makeHttpRequest("http://drm.csdev.nmmu.ac.za/getPredecessor.php", "GET", List);
			
			String TAG_NODES = "no";
			JSONArray PredecessorArray = null;
		
			try
			{
				
				int success = (json.getInt(TAG_SUCCESS));
				if(success == 1)
				{
					PredecessorArray = json.getJSONArray(TAG_NODES);
					
					for(int x = 0; x <= PredecessorArray.length()-1; x++)
					{
						JSONObject c = PredecessorArray.getJSONObject(x);
						
						String NodeID = c.getString("NodeID");
						String PredecessorID = c.getString("PredecessorID");
						String StartX = c.getString("StartX");
						String StartY = c.getString("StartY");
						String EndX = c.getString("EndX");
						String EndY = c.getString("EndY");
						Predecessor P = new Predecessor(Integer.valueOf(NodeID), Integer.valueOf(PredecessorID), Integer.valueOf(StartX), Integer.valueOf(StartY), Integer.valueOf(EndX), Integer.valueOf(EndY));
						PredecessroList.add(P);
						
					}
			

				}
				
			}catch (JSONException d)
			{
				d.printStackTrace();
			}
			
		
		}

		private void getNodes()
		{
			String NodeID = "";
			String X = "";
			String Y = "";
			String LtoX = "";
			String LtoY = "";
			String Content = "";
			
			//GetActivty
			ArrayList<NameValuePair> List = new ArrayList<NameValuePair>();
			List.add(new BasicNameValuePair("NodeID", NodeID));
			List.add(new BasicNameValuePair("X", X));
			List.add(new BasicNameValuePair("Y", Y));
			List.add(new BasicNameValuePair("LtoX", LtoX));
			List.add(new BasicNameValuePair("LtoY", LtoY));
			List.add(new BasicNameValuePair("Content", Content));
			

			JSONParser jParser = new JSONParser();
			JSONObject json = jParser.makeHttpRequest("http://drm.csdev.nmmu.ac.za/getPredecessor.php", "GET", List);
			
			String TAG_NODES = "no";
			JSONArray PredecessorArray = null;
		
			try
			{
				
				int success = (json.getInt(TAG_SUCCESS));
				if(success == 1)
				{
					PredecessorArray = json.getJSONArray(TAG_NODES);
					
					for(int x = 0; x <= PredecessorArray.length()-1; x++)
					{
						JSONObject c = PredecessorArray.getJSONObject(x);
						
						String NodesNodeID = c.getString("NodeID");
						String NodeX = c.getString("X");
						String NodeY = c.getString("Y");
						String Node_LtoX = c.getString("LtoX");
						String Node_LtoY = c.getString("LtoY");
						String Node_Content = c.getString("Content");
						Node N = new Node(Integer.valueOf(NodesNodeID), Integer.valueOf(NodeX), Integer.valueOf(NodeY), Integer.valueOf(Node_LtoX), Integer.valueOf(Node_LtoY), Node_Content);
						NodesList.add(N);
						
					}
			

				}
				
			}catch (JSONException d)
			{
				d.printStackTrace();
			}
			
		
		}


}


}
