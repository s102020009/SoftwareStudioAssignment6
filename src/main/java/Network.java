package main.java;

import java.util.ArrayList;
import java.util.HashMap;

import processing.core.PApplet;

public class Network extends Component implements DetectMouse{
	
	private float radius;
	private ArrayList<Node> nodes;

	//constructor
	public Network(MainApplet parent, float x, float y, float radius){
		super(parent, "Network", x, y);
		this.radius = radius;
		nodes = new ArrayList<Node>();
	}

	//display nodes and links
	@Override
	public void display(){
		super.getParent().noFill();
		if(this.mouseOver() && super.getParent().mousePressed){
			super.getParent().strokeWeight(6);
		}else{
			super.getParent().strokeWeight(3);
		}
		super.getParent().stroke(192, 212, 152);
		super.getParent().ellipse(super.getX(), super.getY(), this.radius, this.radius);
		for(Node node: this.nodes){
			HashMap<Node, Float> targets = node.getTargets();
			for(Node tg: targets.keySet()){
				if(this.nodes.contains(tg)){
					super.getParent().stroke(100);
					super.getParent().strokeWeight(PApplet.log(targets.get(tg)) + 0.5f);
					super.getParent().beginShape();
					super.getParent().vertex(node.getCurrentX(), node.getCurrentY());
					super.getParent().quadraticVertex(super.getX(), super.getY(), tg.getCurrentX(), tg.getCurrentY());
					super.getParent().endShape();
				}
			}
		}
	}

	//detect mouse hovering
	@Override
	public boolean mouseOver() {
		float disX = super.getX() - super.getParent().mouseX;
		float disY = super.getY() - super.getParent().mouseY;
		
		if(PApplet.sqrt(PApplet.sq(disX) + PApplet.sq(disY)) < this.radius){
			return true;
		}else{
			return false;
		}
	}
	
	//check if the node is in the list
	public boolean contain(Node node){
		if(this.nodes.contains(node)){
			return true;
		}else{
			return false;
		}
	}
	
	//update coordinate of nodes
	public void update(){
		int num = this.nodes.size();
		for(int i = 0; i < num; i++){
			float newX = super.getX() + this.radius * PApplet.cos(PApplet.TWO_PI/num*i);
			float newY = super.getY() + this.radius * PApplet.sin(PApplet.TWO_PI/num*i);
			this.nodes.get(i).setPosition(newX, newY);
		}
	}
	
	//add a node
	public void addNode(Node node){
		this.nodes.add(node);
		this.update();
	}
	
	//delete a node
	public void delNode(Node node){
		node.resetPosition();
		this.nodes.remove(node);
		this.update();
	}
	
	//delete all nodes
	public void clearAll(){
		while(!this.nodes.isEmpty()){
			this.delNode(this.nodes.get(0));
		}
	}
	
	//add all nodes from list
	public void addALL(ArrayList<Node> nodes) {
		for(Node node: nodes){
			if(!this.contain(node)){
				this.addNode(node);
			}
		}
	}
}
