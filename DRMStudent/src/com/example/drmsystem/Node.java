package com.example.drmsystem;

import android.graphics.Paint;

public class Node {

    int x;
    int y;
    int NodeID;
    int NextNodeID;
    int PrevNodeID;
    int LtoX, LtoY;
	String Content;




    public Node(int x, int y,int LtoX ,int LtoY, int NodeID, String Content)
	{
        this.NodeID = NodeID;


		this.x = x ;
		this.y = y;
		this.LtoX = LtoX;
		this.LtoY = LtoY;
        this.Content = Content;
	
		
	}
    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
    public int getLtoX() {
        return LtoX;
    }
    public void setLtoX(int ltoX) {
        LtoX = ltoX;
    }
    public int getLtoY() {
        return LtoY;
    }
    public void setLtoY(int ltoY) {
        LtoY = ltoY;
    }

    public int getNextNodeID() {
        return NextNodeID;
    }

    public void setNextNodeID(int nextNodeID) {
        NextNodeID = nextNodeID;
    }

    public int getPrevNodeID() {
        return PrevNodeID;
    }

    public void setPrevNodeID(int prevNodeID) {
        PrevNodeID = prevNodeID;
    }

    public int getNodeID() {
        return NodeID;

    }

    public void setNodeID(int nodeID) {
        NodeID = nodeID;
    }
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	
}
