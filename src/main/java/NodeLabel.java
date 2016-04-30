package main.java;

public class NodeLabel extends Component{

private float width, height;
	
	//constructor
	public NodeLabel(MainApplet parent){
		super(parent, "", 0, 0);
		this.width = 200;
		this.height = 50;
	}
	
	//display label on a rectangle beside mouse
	@Override
	public void display(){
	}
}
