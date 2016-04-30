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
	}
	
	//detect mouse hovering
	@Override
	public boolean mouseOver(){		
		return false;				
	}
}
