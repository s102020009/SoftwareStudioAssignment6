package main.java;

import java.util.ArrayList;

import de.looksgood.ani.Ani;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

@SuppressWarnings("serial")
public class MainApplet extends PApplet{
	
	private String path = "main/resources/";
	private String[] file = {"starwars-episode-1-interactions.json",
							 "starwars-episode-2-interactions.json",
							 "starwars-episode-3-interactions.json",
							 "starwars-episode-4-interactions.json",
							 "starwars-episode-5-interactions.json",
							 "starwars-episode-6-interactions.json",
							 "starwars-episode-7-interactions.json"};
	
	private final int width = 1200, height = 650;
	private ArrayList<ArrayList<Node>> episodes;
	private Node draggingNode = null;
	private NodeLabel nodeLabel;
	private Network network;
	private Button addAll, clear;
	private int currentEP;
	private String info;	
	
	//setup
	@Override
	public void setup() {
		this.size(width, height);
		Ani.init(this);
		this.episodes = new ArrayList<ArrayList<Node>>();
		this.nodeLabel = new NodeLabel(this);
		this.network = new Network(this, this.width/2, this.height/2, 240);
		this.addAll = new Button(this, "ADD ALL", 950, 100, 150, 50);
		this.clear = new Button(this, "CLEAR", 950, 200, 150, 50);
		this.setEP(0);
		this.loadData();
		this.smooth();		
	}
	
	//draw components
	@Override
	public void draw() {
		this.background(255);
	}
	
	//trigger buttons
	@Override
	public void mouseClicked(){
	}
	
	//set node to drag
	@Override
	public void mousePressed(){
	}
	
	//set coordinate of dragging node
	@Override
	public void mouseDragged(){
	}
	
	//add / delete dragging node to / from network
	@Override
	public void mouseReleased(){
	}
	
	//change current episode
	@Override
	public void keyPressed(){
	}
	
	//set current episode
	private void setEP(int EP) {
	}
	
	//load data
	private void loadData(){
	}
}
