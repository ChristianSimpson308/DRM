package com.example.drmlecturer;

import java.io.Serializable;

public class Successor implements Serializable {

	int NodeID, SuccessorNodeID, PStartX, PStartY, PEndX, PEndY;

	public Successor(int nodeID, int successorNodeID, int pStartX, int pStartY,
			int pEndX, int pEndY) {
		super();
		NodeID = nodeID;
		SuccessorNodeID = successorNodeID;
		PStartX = pStartX;
		PStartY = pStartY;
		PEndX = pEndX;
		PEndY = pEndY;
	}

	public int getNodeID() {
		return NodeID;
	}

	public void setNodeID(int nodeID) {
		NodeID = nodeID;
	}

	public int getSuccessorNodeID() {
		return SuccessorNodeID;
	}

	public void setSuccessorNodeID(int successorNodeID) {
		SuccessorNodeID = successorNodeID;
	}

	public int getPStartX() {
		return PStartX;
	}

	public void setPStartX(int pStartX) {
		PStartX = pStartX;
	}

	public int getPStartY() {
		return PStartY;
	}

	public void setPStartY(int pStartY) {
		PStartY = pStartY;
	}

	public int getPEndX() {
		return PEndX;
	}

	public void setPEndX(int pEndX) {
		PEndX = pEndX;
	}

	public int getPEndY() {
		return PEndY;
	}

	public void setPEndY(int pEndY) {
		PEndY = pEndY;
	}

}
