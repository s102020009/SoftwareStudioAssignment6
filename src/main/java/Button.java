package main.java;

public class Button extends Component implements DetectMouse{

	private float width, height;
	
	//constructor
	public Button(MainApplet parent, String label, float x, float y, float width, float height){
		super(parent, label, x, y);
		this.width = width;
		this.height = height;
	}
	
	//display button
	@Override
	public void display(){
		if(this.mouseOver() && !super.getParent().mousePressed){
			super.getParent().fill(185, 228, 199);
		}else if(this.mouseOver() && super.getParent().mousePressed){
			super.getParent().fill(0, 158, 253);
		}else{
			super.getParent().fill(173, 204, 180);
		}
		super.getParent().noStroke();
		super.getParent().rect(super.getX(), super.getY(), this.width, this.height);
		super.getParent().fill(255);
		super.getParent().textSize(20);
		super.getParent().text(super.getLabel(), super.getX()+this.width/2, super.getY()+this.height/2);
	}
	
	//detect mouse hovering
	@Override
	public boolean mouseOver(){		
		if(super.getParent().mouseX >= super.getX() 
		&& super.getParent().mouseX <= super.getX()+this.width
		&& super.getParent().mouseY >= super.getY() 
		&& super.getParent().mouseY <= super.getY()+this.height){
			return true;
		}else{
			return false;
		}				
	}
}
