package patelProject3;
/*
 * Author: Saj Patel
 * Date: 4/30/2020
 * 
 * Description: This class includes an array of cells that have three values(Wall, Open, Explored)
 *  and each cell is displayed on the canvas with a different color. The methods in the class generate 
 *  a maze draws it on the canvas and the solves the maze 
 */

import java.util.ArrayList;
import java.util.Collections;


import edu.princeton.cs.introcs.StdDraw;

public class Maze {
	// creating an enumerated type to check is the cell is empty open or a wall
	private enum CellValue {
		WALL, OPEN, EXPLORED
	};

	// declaring an inner class Cell that stores the row and column each cell is
	// stored in
	private class Cell {
		private int row;
		private int column;

		// constructor for the inner class
		public Cell(int r, int c) {
			row = r;
			column = c;

		}
	}

	// declaring the variables for the Maze class
	private CellValue[][] maze; // a 2-D array of type CellValue to store the contents of each cell
	private int width; // the width of the maze(number of cells that would be across the cell
	private int height; // the height of the maze(number of cells that would be vertically across the
						// canvas
	private StackList<Cell> stack; // a stack that is used for the Depth-First technique used to generate the maze
	private DoublyLinkedListQueue<Cell> queue; // a queue that is used for the Breath-First technique used to solve the
												// maze
	private Cell currentCell; // a single cell that stores the location of the current cell

	// a constructor for the maze that takes two variables as an input to set the
	// width and height of the canvas
	public Maze(int w, int h) {

		// setting the width and height of the canvas
		this.width = w;
		this.height = h;

		// setting the canvas size and the scale of the canvas
		StdDraw.setCanvasSize(500, 500);
		StdDraw.setXscale(0, w);
		StdDraw.setYscale(0, h);

		maze = new CellValue[w][h]; // initializing the 2-D array of CellValue type

		// setting all the contents of that array to wall
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				maze[i][j] = CellValue.WALL;
			}
		}

		// declaring a new stack and queue
		stack = new StackList<>();
		queue = new DoublyLinkedListQueue<>();

		// setting the location of the current cell
		currentCell = new Cell(1, 1);

	}

	// a draw method that draws all the contents of the maze array according to
	// their cell value
	public void draw() {

		// enables double buffering and clears the canvas every time the draw function
		// is called
		StdDraw.enableDoubleBuffering();
		StdDraw.clear();

		// a loop that goes through the whole array and checks the contents of each cell
		// and draws it with the appropriate color
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {

				// draws a black square if the cell is of value wall
				if (maze[i][j] == CellValue.WALL) {
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(i + 0.5, j + 0.5, 0.5, 0.5);
				}
				// draws a green square if the cell has been explored
				if (maze[i][j] == CellValue.EXPLORED) {
					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.filledRectangle(i + 0.5, j + 0.5, 0.5, 0.5);
				}
				// draws a white sqaure if the cell is open
				if (maze[i][j] == CellValue.OPEN) {
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledRectangle(i + 0.5, j + 0.5, 0.5, 0.5);
				}

			}
		}

		StdDraw.show(); // calls the show function to show the updated canvas
	}

	// a method that generates the maze using Depth-First Search
	public void generateMaze() {

		maze[currentCell.row][currentCell.column] = CellValue.OPEN; // sets the current cell to open

		stack.push(currentCell); // pushes the current cell onto the stack

		// runs a loop while the stack is not empty
		while (!stack.isEmpty()) {
			currentCell = stack.pop(); // popping the stack into the current cell
			ArrayList<Cell> neighbors = new ArrayList<Cell>(); // initializing an arrayList neighbors

			// checks to see if there is a neighboring cell that is two away in the north
			// direction
			if ((currentCell.row + 2) < height) {
				// creates a new cell that stores the location of the cell that is two about the
				// current cell
				Cell north = new Cell(currentCell.row + 2, currentCell.column);
				// statement that checks to see if that cell is a wall
				if (maze[north.row][north.column] == CellValue.WALL) {
					maze[north.row][north.column] = CellValue.OPEN; // it opens the cell
					neighbors.add(north); // it adds it to the array list neighbors
					maze[north.row - 1][north.column] = CellValue.OPEN; // opens the cell that is between the two cells
				}
			}

			// Checks to see if there is a neighboring cell that is two away in the south
			// direction and carries out the same process as the previous statement
			if ((currentCell.row - 2) > 0) {
				Cell south = new Cell(currentCell.row - 2, currentCell.column);

				if (maze[south.row][south.column] == CellValue.WALL) {
					maze[south.row][south.column] = CellValue.OPEN;
					neighbors.add(south);
					maze[south.row + 1][south.column] = CellValue.OPEN;
					System.out.println("South added!");

				}

			}
			// Checks to see if there is a neighboring cell that is two away in the east
			// direction and carries out the same process as the previous statement
			if ((currentCell.column + 2) < width) {
				Cell east = new Cell(currentCell.row, currentCell.column + 2);

				if (maze[east.row][east.column] == CellValue.WALL) {
					maze[east.row][east.column] = CellValue.OPEN;
					neighbors.add(east);
					maze[east.row][east.column - 1] = CellValue.OPEN;
					System.out.println("East added!");

				}

			}
			// Checks to see if there is a neighboring cell that is two away in the west
			// direction and carries out the same process as the previous statement
			if ((currentCell.column - 2) > 0) {
				Cell west = new Cell(currentCell.row, currentCell.column - 2);

				if (maze[west.row][west.column] == CellValue.WALL) {
					maze[west.row][west.column] = CellValue.OPEN;
					neighbors.add(west);
					maze[west.row][west.column + 1] = CellValue.OPEN;
					System.out.println("West added!");

				}

			}

			Collections.shuffle(neighbors); // shuffles the direction in which new neighbors are added

			// loop that pushsest all the neighbors onto the stack
			for (int i = 0; i < neighbors.size(); i++) {
				stack.push(neighbors.get(i));
			}
			StdDraw.pause(25); // a brief pause to make the animation go a little slower so you can see the
								// maze generate
			draw(); // calls on the draw function to draw the updated maze before the process goes
					// back to the top of the loop

		}
	}

	// a method to solve the maze that was generated using Breath-First-Search
	public void solveMaze() {

		Cell start = new Cell(1, 1); // setting a starting point for the maze
		Cell goal = new Cell(width - 2, height - 2); // setting a ending point for the maze

		currentCell = start; // setting the current cell as the starting cell so that their values are the
								// same
		maze[currentCell.row][currentCell.column] = CellValue.EXPLORED; // setting the current cell as explored

		queue.enqueue(currentCell); // adding the current cell to the queue

		// loop that runs while the queue is not empty
		while (!queue.isEmpty()) {

			currentCell = queue.dequeue(); // it removes the current cell from the queue

			// check to see if the location of the current cell is at the ending point of
			// the maze in which case the process is over and the method with stop
			if (currentCell.column == goal.column && currentCell.row == goal.row) {
				return;
			}
			// nested IF-Statements that check is the cell to the north of the current cell
			// and explores it to see if that leads it to the ending point
			if ((currentCell.row + 1) < height) {
				Cell north = new Cell(currentCell.row + 1, currentCell.column);

				if (maze[north.row][north.column] == CellValue.OPEN) {
					maze[north.row][north.column] = CellValue.EXPLORED;
					queue.enqueue(north);
				}

			}
			// nested IF-Statements that check is the cell to the east of the current cell
			// and explores it to see if that leads it to the ending point
			if ((currentCell.row + 1) < width) {
				Cell east = new Cell(currentCell.row, currentCell.column + 1);

				if (maze[east.row][east.column] == CellValue.OPEN) {
					maze[east.row][east.column] = CellValue.EXPLORED;
					queue.enqueue(east);
				}

			}

			// nested IF-Statements that check is the cell to the south of the current cell
			// and explores it to see if that leads it to the ending point
			if ((currentCell.row - 1) > 0) {
				Cell south = new Cell(currentCell.row - 1, currentCell.column);

				if (maze[south.row][south.column] == CellValue.OPEN) {
					maze[south.row][south.column] = CellValue.EXPLORED;
					queue.enqueue(south);
				}

			}
			// nested IF-Statements that check is the cell to the west of the current cell
			// and explores it to see if that leads it to the ending point
			if ((currentCell.row - 1) > 0) {
				Cell west = new Cell(currentCell.row, currentCell.column - 1);

				if (maze[west.row][west.column] == CellValue.OPEN) {
					maze[west.row][west.column] = CellValue.EXPLORED;
					queue.enqueue(west);
				}

			}

			// calls the draw function to update the solved maze
			draw();
			StdDraw.pause(25); // a brief pause to see the way the solver is moving around the canvas
		}

	}

}
