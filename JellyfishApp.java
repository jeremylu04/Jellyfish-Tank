
/**
 * Jellyfish Tank
 *  
 * @author:      Jeremy Lu
 * @since:       Dec. 12, 2016
 * 
 * My program is a simulation of a fish tank, where jellyfish are freely swimming about.
 * 
 * The program starts with 1 jellyfish in the tank
 * Left mouse click adds more jellyfish, and right mouse click removes jellyfish to the tank
 * 
 * The minimum amount of jellyfish in the tank is set to 1
 */

import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

public class JellyfishApp extends PApplet {

	// create dimensions for the canvas
	int xMax = 800;
	int yMax = 800;

	// coordinates for my placement of water image inside tank
	int x_water = 87;
	int y_water = 225;
	int width = 625;
	int height = 430;

	// declare PImage of fish tank and water
	PImage fishTank;
	PImage water;

	// declare an ArrayList of my object, Jellyfish
	ArrayList<Jellyfish> myFish = new ArrayList<Jellyfish>();

	// minimum amount of fish in the tank is 1
	int minFish = 1;

	public void setup() {
		size(xMax, yMax);
		frameRate(25);
		// load up fish tank image
		fishTank = loadImage("tank.jpg");
		water = loadImage("water.png");

		// create 1 jellyfish first
		myFish.add(new Jellyfish(this));

	}

	public void draw() {

		// redraw the background in each iteration of the draw method
		image(fishTank, 0, 0, xMax, yMax);
		image(water, x_water, y_water, width, height);

		// if user presses mouse
		if (mousePressed) {

			// check if it's left mouse button, we append a new jellyfish
			if (mouseButton == LEFT) {
				image(fishTank, 0, 0, xMax, yMax);
				image(water, x_water, y_water, width, height);
				myFish.add(new Jellyfish(this));

				// if it's right mouse, and the amount of fish is more than 1,
				// we can remove fish
			} else if (mouseButton == RIGHT) {
				image(fishTank, 0, 0, xMax, yMax);
				image(water, x_water, y_water, width, height);

				if (myFish.size() > 1)
					myFish.remove(myFish.size() - 1);
			}
		}

		// all fish swim in the meantime
		for (int i = 0; i < myFish.size(); i++)
			myFish.get(i).swim();
	}

}