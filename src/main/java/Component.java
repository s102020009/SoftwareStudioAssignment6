package main.java;

public abstract class Component {
	
	private MainApplet parent;
	private String label;
	private float x, y;
	
	//constructor
	public Component(MainApplet parent, String label, float x, float y){
		this.setParent(parent);
		this.setLabel(label);
		this.setX(x);
		this.setY(y);
	}
	
	//setter
	public void setParent(MainApplet parent){ this.parent = parent; }
	public void setLabel(String label){ this.label = label; }
	public void setX(float x){ this.x = x; }
	public void setY(float y){ this.y = y; }
	
	//getter
	public MainApplet getParent(){ return this.parent; }
	public String getLabel(){ return this.label; }
	public float getX(){ return this.x; }
	public float getY(){ return this.y; }
	
	//method needs to implement
	public abstract void display();
}
