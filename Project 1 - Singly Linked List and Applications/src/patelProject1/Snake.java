package patelProject1;

import edu.princeton.cs.introcs.StdDraw;

/*
 * Author: Saj Patel
 * Class Description: This is the most important class for the game. it creates the game canvas and all the mechanics of the game that moves the snake
 * and record user input that moves the snake
 */

public class Snake {

	// Declaring enumerated type to mark the direction that the snake is moving in
	private enum Direction {
		UP, DOWN, LEFT, RIGHT
	};

	// Declaring variables for the snake class
	private SinglyLinkedList<Segment> snake; // A singlyLinkedList of type segment that stores the body of the snake
	private Segment head; // a single segment that stores the information about the snake's head
	private boolean gameOver; // a boolean variable that becomes true if the game is over
	private SinglyLinkedList<Segment> food; // another singly linked list of type segment that stores the food
	private int size; // a variable that stores the size of the snake
	private Direction direction; // the enumerated variable that stores the direction of the snake

	// A no-imput constructor for the snake class
	public Snake() {

		// enables double buffering and sets the canvas size and its scale
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(500, 500);
		StdDraw.setXscale(0, 500);
		StdDraw.setYscale(0, 500);

		// initializes the snake linked list
		snake = new SinglyLinkedList<Segment>();

		// adds 4 new segments to the list to the snakes body to start the game of with.
		for (int i = 0; i < 4; i++) {
			snake.addLast(new Segment(200 + (i * 20), 50)); // calls on the add last method of the singlyListClass
		}
		size = 4; // initializes the size of the snake to 4
		head = snake.get(0); // sets the head segment to equal the head of the snake list
		gameOver = false; // starts of the game over with false because the game has not ended
		direction = direction.LEFT; // starts of the direction of the snake to be moving left

		// creating a variable to store the random x and y coordinates for the food
		int foodX = (int) ((Math.random() * 480));
		int foodY = (int) ((Math.random() * 480));
		food = new SinglyLinkedList<Segment>(); // initializes the food linked list
		food.addFirst(new Segment(foodX, foodY)); // adds a new segment to the list with the random x and y location of
													// the food

	}

	// a draw method that draws the content of the game
	public void draw() {
		StdDraw.clear(); // starts of by clearing the canvas
		StdDraw.setPenColor(StdDraw.BLACK); // sets the pen color to black

		// a for loop that gets all the content of the snake and draws it by calling the
		// draw method of the segment class
		for (int i = 0; i < snake.size(); i++) {
			snake.get(i).draw();
		}

		// series of if statements that draws the eyes and mouth of the snake depending
		// on the direction it is moving in
		if (direction == Direction.UP) {
			StdDraw.setPenColor(StdDraw.WHITE); // sets the pen color to white
			// draws the eyes of the snake
			StdDraw.filledCircle(head.xPos + 5, head.yPos + 5, 2);
			StdDraw.filledCircle(head.xPos - 5, head.yPos + 5, 2);
			StdDraw.setPenColor(StdDraw.RED); // sets the pen color to red
			StdDraw.filledSquare(head.xPos, head.yPos + 13, 3); // draws the mouth of the snake
		}
		if (direction == Direction.DOWN) {
			StdDraw.setPenColor(StdDraw.WHITE); // sets the pen color to white
			// draws the eyes of the snake
			StdDraw.filledCircle(head.xPos + 5, head.yPos - 5, 2);
			StdDraw.filledCircle(head.xPos - 5, head.yPos - 5, 2);
			StdDraw.setPenColor(StdDraw.RED); // sets the pen color to red
			StdDraw.filledSquare(head.xPos, head.yPos - 13, 3); // draws the mouth of the snake
		}
		if (direction == Direction.LEFT) {
			StdDraw.setPenColor(StdDraw.WHITE); // sets the pen color to white
			// draws the eyes of the snake
			StdDraw.filledCircle(head.xPos - 5, head.yPos + 5, 2);
			StdDraw.filledCircle(head.xPos - 5, head.yPos - 5, 2);
			StdDraw.setPenColor(StdDraw.RED); // sets the pen color to red
			StdDraw.filledSquare(head.xPos - 13, head.yPos, 3); // draws the mouth of the snake
		}
		if (direction == Direction.RIGHT) {
			StdDraw.setPenColor(StdDraw.WHITE); // sets the pen color to white
			// draws the eyes of the snake
			StdDraw.filledCircle(head.xPos + 5, head.yPos + 5, 2);
			StdDraw.filledCircle(head.xPos + 5, head.yPos - 5, 2);
			StdDraw.setPenColor(StdDraw.RED); // sets the pen color to red
			StdDraw.filledSquare(head.xPos + 13, head.yPos, 3); // draws the mouth of the snake
		}

		// checks if there is a collision
		StdDraw.setPenColor(StdDraw.BLACK); // changes the pen color to black
		if (collision()) {
			StdDraw.text(250, 250, "Game Over!"); // draws a text to the canvas
			StdDraw.show(); // shows the canvas
			return; // returns to the start of the method
		}

		drawFood();// calls on the draw food method to draw a new food on the canvas

		StdDraw.show(); // calls on the show method to draw everything on the canvas
	}

	// a draw food method that draw the food segment at a random position on the
	// canvas
	public void drawFood() {
		// only creates a new food segment if the list is empty
		if (food.size() == 0) {
			int foodX = (int) ((Math.random() * 480)); // variable that gives a random x position for the food
			int foodY = (int) ((Math.random() * 480)); // variable that gives a random y position for the food
			food.addFirst(new Segment(foodX, foodY)); // adds the new food item to the list
		}
		food.get(0).draw(); // calls on the get method in the singly linked list class that returns a
							// segment which the calls on its draw method.
	}

	// this is the main frame of the game all activities happen here
	public void playGame() {

		// a counter varaible that is later used to change the speed of the game
		int counter = 0;
		// creating a loop that runs until the game is over
		while (!gameOver) {

			draw(); // calls on the draw method that draws all of the content of the game including
					// the food and the snake

			// first it checks for collision by calling on the collision method
			if (collision()) {
				gameOver = true; // if there is a collision the game is over
				break; // the loop breaks
			}

			// it then checks to see if a food has been eaten
			if (eaten()) {
				food.removeFirst(); // it it has then it removes it from the food list
				grow(); // it then calls on the grow method that grows the snake to become longer
			}

			snake.removeLast(); // this removes the last segment of the snake

			Segment newHead = null; // creates a new temporary segment that is started of as null

			// series of if-statements that assigns a new segment to the newHead depending
			// on the direction that the snake is moving in

			if (direction == Direction.LEFT) {
				newHead = new Segment((head.xPos - 20), head.yPos);
			}
			if (direction == Direction.RIGHT) {
				newHead = new Segment((head.xPos + 20), head.yPos);
			}
			if (direction == Direction.UP) {
				newHead = new Segment((head.xPos), head.yPos + 20);
			}
			if (direction == Direction.DOWN) {
				newHead = new Segment((head.xPos), head.yPos - 20);
			}

			// the next two statements is to move the snake
			// it adds the newHead to the front of the snake list so it becomes the newhead
			// of the snake
			snake.addFirst(newHead);
			head = snake.get(0); // the head segment is updated so that it stores the value of the upated head

			// series of if-statements that check what the button the user is pressing and
			// changes the direction of the snake accordinging.
			// w is for up, s is for down, a is for left and d is for right
			if (StdDraw.hasNextKeyTyped()) {
				char input = StdDraw.nextKeyTyped();
				if (input == 'w') {
					direction = Direction.UP;
				}
				if (input == 's') {
					direction = Direction.DOWN;
				}
				if (input == 'a') {
					direction = Direction.LEFT;
				}
				if (input == 'd') {
					direction = Direction.RIGHT;
				}

			}

			// a delay variable that is used to vary the speed of the game
			int delay = 1000;

			// every time the loop iterates the counter updates and after a given number the
			// delay time reduces which increases the speed of the game
			// and the rate at which the snake moves is alot faster
			if (counter < 15) {
				delay = 1000;
				counter++;
			} else if (counter < 75) {
				delay = 750;
				counter++;
			} else if (counter < 200) {
				delay = 500;
				counter++;
			} else if (counter < 350) {
				delay = 250;
				counter++;
			} else if (counter < 500) {
				delay = 150;
				counter++;
			} else {
				delay = 50;
			}
			System.out.println(counter);
			StdDraw.pause(delay);

		}

	}

	// an eaten method that checks to see if the snake has eaten the food on the
	// canvas
	public boolean eaten() {
		int distanceX = Math.abs(head.xPos - food.get(0).xPos); // a variable that stores the distance between the x
																// position of the food and the snakes head
		int distanceY = Math.abs(head.yPos - food.get(0).yPos); // a variable that stores the distance between the y
																// position of the food and the snakes head

		// checks to see if the distance is within the range of the food in which case
		// the size increases and returns true
		if (distanceX < head.length * 2 && distanceY < head.length * 2) {
			size++;
			return true;
		}

		return false;

	}

	// method that checks for collision
	public boolean collision() {

		// checking for the vertical wall of the canvas
		if (head.xPos < 0 || head.xPos > 500) {
			return true;
		}

		// checking for the horizontal walls of the canvas
		if (head.yPos < 0 || head.yPos > 500) {
			return true;
		}

		// checks to see if the snake has eaten itself
		for (int i = 1; i < snake.size(); i++) {
			if (snake.get(i).xPos == head.xPos && snake.get(i).yPos == head.yPos) {
				return true;
			}
		}

		return false;
	}

	// a grow method that increases the size of the snake when it eats some food
	public void grow() {

		// series of if-statements that extends the length of the snake by adding a
		// segment at the end of the snake according to the direction the snake is
		// moving in
		if (direction == Direction.UP) {
			snake.addLast(new Segment(snake.get(snake.size() - 1).xPos, snake.get(snake.size() - 1).yPos - 20));
		}

		if (direction == Direction.DOWN) {
			snake.addLast(new Segment(snake.get(snake.size() - 1).xPos, snake.get(snake.size() - 1).yPos + 20));
		}

		if (direction == Direction.LEFT) {
			snake.addLast(new Segment(snake.get(snake.size() - 1).xPos + 20, snake.get(snake.size() - 1).yPos));
		}

		if (direction == Direction.RIGHT) {
			snake.addLast(new Segment(snake.get(snake.size() - 1).xPos - 20, snake.get(snake.size() - 1).yPos));
		}

	}

}
