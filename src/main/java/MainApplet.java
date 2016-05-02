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
		this.ellipseMode(RADIUS);
		this.textAlign(CENTER, CENTER);
		this.fill(169, 139, 125);
		this.textSize(32);
		this.text(this.info, this.width/2, 30);
		this.network.display();
		this.addAll.display();
		this.clear.display();
		if(!this.mousePressed){
			this.nodeLabel.setLabel("");
		}
		for(Node node: this.episodes.get(this.currentEP)){
			node.display();
			if(node.mouseOver()){
				this.nodeLabel.setLabel(node.getLabel());
			}
		}
		nodeLabel.display();
	}
	
	/*
	 * called after a mouse button has been pressed and then released
	 * trigger buttons
	 */
	public void mouseClicked(){
		if(this.addAll.mouseOver()){
			this.network.addALL(this.episodes.get(this.currentEP));
		}else if(this.clear.mouseOver()){
			this.network.clearAll();
		}
	}
	
	/*
	 * called once after every time a mouse button is pressed
	 * set node to drag
	 */
	@Override
	public void mousePressed(){
		for(Node node: this.episodes.get(this.currentEP)){
			if(node.mouseOver()){
				this.draggingNode = node;
			}
		}
	}
	
	/*
	 * called once every time the mouse moves while a mouse button is pressed
	 * set coordinate of dragging node
	 */
	@Override
	public void mouseDragged(){
		if(this.draggingNode != null){
			Ani.to(this.draggingNode, 0.1f, "currentX", this.mouseX);
			Ani.to(this.draggingNode, 0.1f, "currentY", this.mouseY);
		}
	}
	
	/*
	 * called every time a mouse button is released. 
	 * add/delete dragging node to/from network
	 */
	@Override
	public void mouseReleased(){
		if(this.draggingNode != null){
			if(this.network.mouseOver() && !this.network.contain(draggingNode)){
				this.network.addNode(draggingNode);
			}else if(!this.network.mouseOver() && this.network.contain(draggingNode)){
				this.network.delNode(draggingNode);
			}else if(!this.network.mouseOver() && !this.network.contain(draggingNode)){
				this.draggingNode.resetPosition();
			}else if(this.network.mouseOver() && this.network.contain(draggingNode)){
				this.network.update();
			}
			this.draggingNode = null;
		}
	}
	
	//change current episode
	@Override
	public void keyPressed(){
		if(this.key == '1'){
			this.setEP(0);
		}else if(this.key == '2'){
			this.setEP(1);
		}else if(this.key == '3'){
			this.setEP(2);
		}else if(this.key == '4'){
			this.setEP(3);
		}else if(this.key == '5'){
			this.setEP(4);
		}else if(this.key == '6'){
			this.setEP(5);
		}else if(this.key == '7'){
			this.setEP(6);
		}
	}
	
	//set current episode
	private void setEP(int EP) {
		this.currentEP = EP;
		this.info = "Star Wars " + String.valueOf(EP+1);
		this.network.clearAll();
	}
	
	//load data
	private void loadData(){
		JSONObject data;
		JSONArray nodes, links;	
		int maxRow = 10;
		int offset = 50;
		
		for(int i = 0; i < 7; i++){			
			data = this.loadJSONObject(this.path + this.file[i]);
			nodes = data.getJSONArray("nodes");
			links = data.getJSONArray("links");
			ArrayList<Node> episode = new ArrayList<Node>();
			int row = 0, col = 0;
			
			for(int j = 0; j < nodes.size(); j++){
				JSONObject node = nodes.getJSONObject(j);
				String label = node.getString("name");
				String coloru = node.getString("colour");
				episode.add(new Node(this, label, coloru, (col+2)*offset, (row+2)*offset));
				
				if(row < maxRow-1){
					row++;
				}else{
					row = 0;
					col++;
				}		
			}
			
			for(int j = 0; j < links.size(); j++){
				JSONObject link = links.getJSONObject(j);
				int source = link.getInt("source");
				int target = link.getInt("target");
				float value = (float) link.getInt("value");
				episode.get(source).addTarget(episode.get(target), value);
			}
			
			this.episodes.add(episode);
		}
	}
}
