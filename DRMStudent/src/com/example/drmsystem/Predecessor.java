package com.example.drmsystem;

import java.io.Serializable;

public class Predecessor implements Serializable {
int NodeID, PredecessorNodeID, PStartX, PStartY, PEndX, PEndY;

public Predecessor(int nodeID, int predecessorNodeID, int pStartX, int pStartY,
		int pEndX, int pEndY) {
	super();
	NodeID = nodeID;
	PredecessorNodeID = predecessorNodeID;
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

public int getPredecessorNodeID() {
	return PredecessorNodeID;
}

public void setPredecessorNodeID(int predecessorNodeID) {
	PredecessorNodeID = predecessorNodeID;
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
