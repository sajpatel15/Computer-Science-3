package patelProject3;

/*
 * Author: Saj Patel
 * Date: 4/30/2020
 * 
 * Description: This is the driver class that runs the program it calls the generate maze and it then solves 
 * the maze that has been generated
 */
public class MazeDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Maze newMaze = new Maze(41, 41);
		newMaze.draw();
		newMaze.generateMaze();
		newMaze.solveMaze();

	}

}
