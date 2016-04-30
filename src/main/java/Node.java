package main.java;

import java.util.HashMap;

import de.looksgood.ani.Ani;
import processing.core.PApplet;

public class Node extends Component implements DetectMouse{

	private String colour;
	private float radius, currentX, currentY;
	private HashMap<Node, Float> targets;

	//constructor
	public Node(MainApplet parent, String label, String colour, float x, float y){
		super(parent, label, x, y);
		this.colour = colour.substring(1);
		this.targets = new HashMap<Node, Float>();
		this.currentX = super.getX();
		this.currentY = super.getY();
		this.radius = 18;
	}
	
	//display node
	@Override
	public void display(){
	}
	
	//detect mouse hovering
	@Override
	public boolean mouseOver(){
		return false;
	}
	
	//add targets
	public void addTarget(Node target, float value){
		this.targets.put(target, value);
	}
	
	//return all targets of node
	public HashMap<Node, Float> getTargets(){
		return this.targets;
	}
	
	//set the coordinate
	public void setPosition(float x, float y) {
	}
	
	//reset the coordinate
	public void resetPosition(){
	}
	
	//return the current X coordinate
	public float getCurrentX(){
		return this.currentX;
	}
	
	//return the current Y coordinate
	public float getCurrentY(){
		return this.currentY;
	}
}
