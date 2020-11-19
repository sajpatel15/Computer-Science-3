package patelProject1;

import java.awt.Color;
import javax.swing.JFrame;
import edu.princeton.cs.introcs.Draw;
import edu.princeton.cs.introcs.DrawListener;

public class SimpleGame<T> implements DrawListener {

	// declaring variables for the game
	private Draw draw; // a type draw to show that the method uses the drawListner
	private int xPos; // a variable to store the X coordinate of the main player
	private int yPos; // a variable to store the Y coordinate of the main player
	private int size; // a variable to store the radius of the circle that is the player
	private Color c; // a color variable to assign all the objects in the game a color
	private SinglyLinkedList<Food> food; // a singly linked list of type Food that stores the information about the
											// group of food that is shown on the board

	// Declaring an inner class Food
	private class Food {
		private int xPos; // a variable to store the X coordinate of the food
		private int yPos; // a variable to store the Y coordinate of the food

		// A constructor for the food
		public Food() {

			// sets the xy coordinates of the food to a random position on the board
			this.xPos = (int) (Math.random() * 499);
			this.yPos = (int) (Math.random() * 499);
		}

		// Declaring a draw method that draws the food on the board
		public void draw() {
			// it sets a pen color and draws a filled circle of raduis 10 at the given xy
			// position on the board
			draw.setPenColor();
			draw.filledCircle(this.xPos, this.yPos, 10);
		}

		// Declaring a setter for the X Coordinate for the food
		public void setX(int x) {
			this.xPos = x;
		}

		// Declaring a setter for the Y cordinate for the food
		public void setY(int y) {
			this.yPos = y;
		}
	}

	// Declaring the constructor for the game
	public SimpleGame() {
		// initializes the draw
		draw = new Draw();
		// initializes the singlylinkedList and uses a loop to add items into the list
		food = new SinglyLinkedList<>();

		for (int i = 0; i < 15; i++) {
			food.addFirst(new Food());
		}

		// setting the canvas size and the Xy scale of the canvas
		draw.setCanvasSize(500, 500);
		draw.setXscale(0, 500);
		draw.setYscale(0, 500);

		// initializing the xy coordinate to a random point on the canvas
		this.xPos = (int) (Math.random() * 499);
		this.yPos = (int) (Math.random() * 499);
		// initializing the starting size of the main player to have a radius of 25
		this.size = 25;
		// initializing the color to a random color
		this.c = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
		new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

		draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		draw.addListener(this); // this adds a listener to the class that implements all th drawlistner methods

	}

	@Override
	public void mousePressed(double x, double y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(double x, double y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(double x, double y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(double x, double y) {
		// TODO Auto-generated method stub

		// a variable to store the distance between the player and the click
		double distance = 0;

		// finding the x^2 and y^2 of the difference between the x and y values of the
		// player and the click
		double diffX = Math.pow(Math.abs(x - (xPos)), 2);
		double diffY = Math.pow(Math.abs(y - (yPos)), 2);
		// takes the square root of the two above and store that as the distance
		distance = Math.sqrt(diffX + diffY);

		// checks to see if the player has clicked inside the circle or outside
		if (distance <= size) {
			// if the click is inside the circle then the color of the players circle will
			// change color to another random color
			c = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
			draw.setPenColor(c);
			draw.filledCircle(xPos, yPos, size);
		} else {
			// if it is outside the circle then it will change position to some other random
			// place on the canvas
			draw.clear(); // it clears the canvas

			// draws all the food again
			for (int i = 0; i < food.size(); i++) {
				food.get(i).draw();
			}
			// changes the color of the pen
			draw.setPenColor(c);

			// gives new coordinates for the players circle
			this.xPos = (int) (Math.random() * 499);
			this.yPos = (int) (Math.random() * 499);
			draw.filledCircle(xPos, yPos, size); // draws the circles again at a new position
		}

		System.out.println("Mouse Clicked");
	}

	@Override
	public void keyTyped(char c) {
		// TODO Auto-generated method stub
		// checks to see if the key 'd' is pressed in which case it will move the player
		// to the right until it hits a the end of the canvas
		if (Character.toString(c).equals("d") && ((xPos + size) != 500)) {
			xPos++;
		}
		// checks to see if the key 'a' is pressed in which case it will move the player
		// to the left until it hits a the end of the canvas
		else if (Character.toString(c).equals("a") && ((xPos - size) != 0)) {
			xPos--;
		}
		// checks to see if the key 'w' is pressed in which case it will move the player
		// to the up until it hits a the end of the canvas
		else if (Character.toString(c).equals("w") && ((yPos + size) != 500)) {
			yPos++;
		}
		// checks to see if the key 's' is pressed in which case it will move the player
		// to the down until it hits a the end of the canvas
		else if (Character.toString(c).equals("s") && ((yPos - size) != 0)) {
			yPos--;
		}

		// loop that checks if any of the food has been eaten using geometry again
		for (int i = 0; i < food.size(); i++) {
			// gets the distance between the player and the food
			double distance = 0;
			double diffX = Math.pow(Math.abs(food.get(i).xPos - (xPos)), 2);
			double diffY = Math.pow(Math.abs(food.get(i).yPos - (yPos)), 2);
			distance = Math.sqrt(diffX + diffY);

			// if the distance is less than size it means that the player is above the food
			// cell at that moment;
			if (distance <= (size)) {
				food.removeAtIndex(i); // it will remove the food at that index
				System.out.println("Food removed");
				size += 3; // it will increase the size of the player by 3
				System.out.println(food.size());
				System.out.println("Distance " + distance + " raduis " + (size));

			}
		}

		// checks to see if there are no more food item left on the board in which case
		// the game is over and it returns
		if (isEmpty()) {
			draw.clear();
			draw.text(250, 250, "Game Over, You win!");
			return;
		}

		draw();

	}

	@Override
	public void keyPressed(int keycode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int keycode) {
		// TODO Auto-generated method stub

	}

	// draw method to draw all the contents of the game on the canvas
	public void draw() {
		draw.clear(); // clears the board
		// draws all the food
		for (int i = 0; i < food.size(); i++) {
			food.get(i).draw();
		}
		draw.setPenColor(c); // sets the pen color to the assigned color
		draw.filledCircle(xPos, yPos, size); // draws a filled circle that color
	}

	// method that checks to see of there are any more food items left on the canvas
	public boolean isEmpty() {
		if (food.size() == 0) {
			return true;
		}

		return false;
	}
}
