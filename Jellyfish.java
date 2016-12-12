import processing.core.PApplet;
import processing.core.PImage;

public class Jellyfish {
	
	//declare my water coordinates
	private float xMin_water;
	private float xMax_water;
	private float yMin_water;
	private float yMax_water;
	
	// declare my fish coordinates
	private float x;
	private float y;
	
	//declare my fish size
	private float xSize;
	private float ySize;
	
	//declare my fish speed
	private float xSpeed;
	private float ySpeed;
	
	//create new PApplet so we can use this later to draw onto canvas in JellyfishApp
	PApplet canvas;
	
	//declare image 
	PImage fish;
	
	//constructor
	public Jellyfish(PApplet canvas) {
		
		this.canvas = canvas;
		
		//set the water coordinates
		xMin_water = 85;
		xMax_water = xMin_water + 630;
		yMin_water = 260;
		yMax_water = yMin_water + 390;
		
		//import my image
		fish = canvas.loadImage("jellyfish.png");
		
		//spawn jellyfish at random coordinates within water
		x = canvas.random(xMin_water, xMax_water);
		y = canvas.random(xMin_water, xMax_water);
		
		//size of jellyfish
		xSize = 88;
		ySize = 110;
		
		//speed of jellyfish
		xSpeed = canvas.random(-4, 4);
		ySpeed = canvas.random(-4, 4);
		
	}

	public void swim() {

		// update position based on speed
		x += xSpeed;
		y += ySpeed;

		// This is to make sure that jellyfish bounces off
		// the sides of tank instead of swimming past the tank
		// and water.
		// Once it hits an edge, we multiple its speed by -1
		// so that it moves the exact opposite direction.
		
		// Here, I define the boundaries minus certain integers
		// to correctly space the jellyfish to float slightly above
		// water surface

		if (x > xMax_water - (xSize / 2) - 45) {
			x = xMax_water - (xSize / 2) - 45;
			xSpeed *= -1;
			
		}
		if (x < xMin_water + (xSize / 2) - 45) {
			x = xMin_water + (xSize / 2) -45;
			xSpeed *= -1;

		}
		if (y > yMax_water - ySize/2 - 45) {
			y = yMax_water - ySize/ 2 - 45;
			ySpeed *= -1;

		}
		if (y < yMin_water - 20) {
			y = yMin_water - 20;
			ySpeed *= -1;

		}
		
		// call the image method on the PApplet object to draw onto canvas
		this.canvas.image(fish, x, y, xSize, ySize);
	}

}