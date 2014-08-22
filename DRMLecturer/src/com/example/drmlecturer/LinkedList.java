package com.example.drmlecturer;

import java.io.Serializable;

public class LinkedList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int ListID, NodeID;
	public LinkedList(int ListID, int NodeID)
	{
		this.ListID = ListID;
		this.NodeID = NodeID;
		
	}
	public int getListID() {
		return ListID;
	}
	public void setListID(int listID) {
		ListID = listID;
	}
	public int getNodeID() {
		return NodeID;
	}
	public void setNodeID(int nodeID) {
		NodeID = nodeID;
	}

}
