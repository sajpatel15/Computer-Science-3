package patelProject1;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

/*
 * Author: Saj Patel
 * Class Description: This class represents each block of the snake and the food 
 */
public class Segment {

	// declaring the variables for the segments
	protected int xPos;
	protected int yPos;
	protected int length;

	// a constructor that takes the x and y coordinated of the segments
	public Segment(int x, int y) {
		xPos = x;
		yPos = y;
		setLength(10);
	}

	// a method that draws the segment 
	public void draw() {
		StdDraw.filledSquare(xPos, yPos, getLength());
	}

	// a getter for the length variable
	public int getLength() {
		return length;
	}

	// a setter for the length variable
	public void setLength(int length) {
		this.length = length;
	}

}
