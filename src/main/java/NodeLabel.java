package main.java;

public class NodeLabel extends Component{

private float width, height;
	
	//constructor
	public NodeLabel(MainApplet parent){
		super(parent, "", 0, 0);
		this.width = 200;
		this.height = 30;
	}
	
	//display label on a rectangle beside mouse when label is not ""
	@Override
	public void display(){
		if(!super.getLabel().equals("")){
			super.setX(super.getParent().mouseX);
			super.setY(super.getParent().mouseY - this.height/2);
			super.getParent().noStroke();
			super.getParent().fill(173, 204, 180);
			super.getParent().rect(super.getX(), super.getY(), this.width, this.height, 7);
			super.getParent().textSize(15);
			super.getParent().fill(255);
			super.getParent().text(super.getLabel(), super.getX() + this.width/2, super.getY() + this.height/2);
		}
	}
}
