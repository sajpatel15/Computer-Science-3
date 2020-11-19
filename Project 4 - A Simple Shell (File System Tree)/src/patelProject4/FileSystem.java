package patelProject4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

/*
 * Author: Saj Patel
 * 
 * Description: This is the frame of a simple file system that is Serializable,
 * it has all the methods a basic file system would have to help navigate 
 * around the system.
 *  
 *  Date: 5/15/2020
 */

public class FileSystem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Declaring the inner class of the file System
	private class Node implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		// Declaring the variables used in the class
		private String name;
		private ArrayList<Node> children;
		private Node parent;
		private boolean isDirectory;

		// Declaring a constructor that takes in a name, parent Node, and a value for
		// isDirectory
		public Node(String n, Node p, boolean v) {
			// initializing all the variables
			this.name = n;
			this.parent = p;
			this.isDirectory = v;
			children = new ArrayList<Node>();
		}

		// Method that returns true is this node is a directory, false if it is a file
		public boolean isDirectory() {
			return isDirectory;
		}

		// Method that returns the ArrayList of child Nodes
		public ArrayList<Node> children() {
			return children;
		}

		// Method that adds a new child to this Node
		public void appendChild(String n, boolean b) {
			// creates a new node and adds it to the arraylist of children
			Node child = new Node(n, this, b);
			children.add(child);
		}

		// Method that returns true if that Node is the root
		public boolean isRoot() {
			// Node is the root if its parents are null hence returns true when parent is
			// null
			if (parent == null) {
				return true;
			} else {
				return false;
			}
		}
	}

	// Declaring instance variables for the FileSystem Class
	private Node root;
	private Node currentDirectory;

	// Declaring a No-Argument Constructor
	public FileSystem() {
		// Makes the root node with an empty string for the name and sets the current
		// directory to the newly made root Node
		this.root = new Node("", null, true);
		currentDirectory = root;
	}

	// Method that throws an exception if the current directory has a child with
	// name already, otherwise it does nothing
	public void checkMakeFile(String name) throws IllegalArgumentException {
		// checks for the number of children the directory has
		int numChild = currentDirectory.children().size();

		// loop that checks if any of the children match the one that was in the method
		for (int i = 0; i < numChild; i++) {
			if (currentDirectory.children().get(i).name.equals(name)) {
				// if the names match it throws a exception saying the file already exists
				throw new IllegalArgumentException(
						"File or directory already exists in the current directory with this name");
			}
		}
	}

	// Method that prints all the children of the directory
	public void ls() {
		// checks for the number of children the directory has
		int numChild = currentDirectory.children().size();

		// checks to see if the directory is empty
		if (numChild == 0) {
			System.out.println("The directory has no children");
		}

		// loop that gets each child of the directory and prints it
		for (int i = 0; i < numChild; i++) {
			System.out.println(currentDirectory.children.get(i).name);
		}
	}

	// Method that adds a new directory child Node to the current
	public void mkdir(String dirname) throws IllegalArgumentException {
		// checks to see if the name already exists in the current directory
		checkMakeFile(dirname);

		// adds the new node to the current directory as a child
		currentDirectory.appendChild(dirname, true);
	}

	// Method that makes a new file Node and adds it to the current directory
	public void touch(String name) throws IllegalArgumentException {
		// checks to see if the name already exists in the current directory
		checkMakeFile(name);

		// adds the new node to the current directory as a child
		currentDirectory.appendChild(name, false);
	}

	// Method that changes the current directory to the name passed in the method
	public void cd(String name) throws IllegalArgumentException {
		// checks for the number of children the directory has
		int numChild = currentDirectory.children().size();

		// a variables that remains false until the current directory has a child that
		// matches the name passed in the method
		boolean childExists = false;

		if (name.equals("..")) {
			currentDirectory = currentDirectory.parent;
			return;
		}
		// loops that goes through each child of the current directory and sees if it is
		// the child that needs to be set as the current directory
		for (int i = 0; i < numChild; i++) {
			// checks to see if the current directory has a child with the name that was
			// passed and checks to see if that child is a directory
			if (currentDirectory.children().get(i).name.equals(name)
					&& currentDirectory.children().get(i).isDirectory) {
				// sets the current directory to the child that was passed in the method
				currentDirectory = currentDirectory.children().get(i);
				// sets the child exists to true
				childExists = true;
				// returns which means the method will end at this point
				return;
			}
		}

		// checks to see if the boolean childExists is still false and throws a
		// exception if that is the case;
		if (!childExists) {
			throw new IllegalArgumentException("This directory does not exist within the current directory");
		}
	}

	// Method that removes the file with the name that is passed from the current
	// directory
	public void rm(String filename) throws IllegalArgumentException {
		// checks for the number of children the directory has
		int numChild = currentDirectory.children().size();

		// a variables that remains false until the current directory has a child that
		// matches the name passed in the method and a variable that remains true unless
		// the child found is not a directory
		boolean childExists = false;
		boolean isDirectory = true;

		// loop that goes over each child in the directory to see if is the file that is
		// being looked for
		for (int i = 0; i < numChild; i++) {
			// checks to see if the child has a name that is equal to the one that has been
			// passed and checks whether the file is a directory
			if (currentDirectory.children().get(i).name.equals(filename)
					&& !currentDirectory.children().get(i).isDirectory) {
				// it removes the file if it meets the criteria above
				currentDirectory.children().remove(i);

				// sets the childExists to true and the is directory to false as it has passed
				// the test
				childExists = true;
				isDirectory = false;
				// the loop stops at this point because it does not need to iterate any longer
				return;
			}
		}
		// this statement checks to see if a child was found and that it was not a
		// directory or else it would throw an exception
		if (!childExists) {
			throw new IllegalArgumentException("The current Directory is empty or the file does not exist");
		} else if (isDirectory) {
			throw new IllegalArgumentException("The " + filename + " is a directory");
		}

	}

	// Method that removes the directory with the name that is passed from the
	// current directory
	public void rmdir(String filename) throws IllegalArgumentException {
		// checks for the number of children the directory has
		int numChild = currentDirectory.children().size();

		// a variables that remains false until the current directory has a child that
		// matches the name passed in the method and a variable that remains true unless
		// the child found is not a directory
		boolean childExists = false;
		boolean isDirectory = false;

		// loop that goes over each child in the directory to see if is the directory
		// that is being looked for
		for (int i = 0; i < numChild; i++) {
			// checks to see if the child has a name that is equal to the one that has been
			// passed and checks whether the filename is a directory
			if (currentDirectory.children().get(i).name.equals(filename)
					&& currentDirectory.children().get(i).isDirectory) {
				// if the filename has other children in it, it will throw an exception
				if (!currentDirectory.children().get(i).children().isEmpty()) {
					throw new IllegalArgumentException("The directory contains other children in it");
				} else {
					// or else it will remove that child from the current directory
					currentDirectory.children().remove(i);

					// sets the childExists to true and the isDirectory to true;
					childExists = true;
					isDirectory = true;
					// stops the loop because it does not need to iterate anymore
					return;
				}
			}
		}
		// this statement checks to see if a child was found and that it was a
		// directory or else it would throw an exception
		if (!childExists || !isDirectory) {
			throw new IllegalArgumentException("The current directory does not have a child by the name " + filename
					+ ", or " + filename + " is not a directory");
		}

	}

	// Helper method that used pre-order traversal and a string builder to pretty
	// prints the contents of the file system and takes in three parameters one is
	// the root of the tree, next is the string builder that will constantly keep
	// growing and finally the number of tabs that will be required to pretty print
	// the whole thing
	private void recursivePrint(StringBuilder sb, Node r, int level) {

		// Base case: the tree is empty
		if (r == null) {
			return;
		}

		// print root value
		for (int i = 0; i < level; i++) {
			sb.append("   ");
		}
		sb.append(r.name + "\n");

		// Recursively print all children of the current root

		for (int i = 0; i < r.children().size(); i++) {
			recursivePrint(sb, r.children().get(i), 1 + level);
		}
	}

	// Method that makes use of the helper class to pretty print the tree starting
	// from the currentDirectory
	public void tree() {
		// Declaring a new string builder
		StringBuilder sb = new StringBuilder();

		// making the call to the recursive function that makes the final string
		recursivePrint(sb, root, 0);

		// prints out the final tree with a pretty printed style
		System.out.println(sb.toString());

	}

	// Method that prints the full path name of the current directory starting with
	// the root of the file system
	public void pwd() {

		// creates a temporary node that works its way up the tree
		Node temp = currentDirectory;
		// Initializing a new stack
		Stack<String> stack = new Stack<>();
		// base case as the temp is pushed onto the stack
		stack.push(temp.name);
		// a loop that runs until the temp node has reached the node
		while (temp.parent != null) {
			// it moves up the tree
			temp = temp.parent;
			// it pushes each name onto the stack
			stack.push(temp.name);
		}
		// initializing a new string builder
		StringBuilder sb = new StringBuilder();
		// start off the string builder with a forward slash
		sb.append("");
		// run the loop until the stack is empty
		while (!stack.isEmpty()) {
			// pops the stack and adds that to the string builder
			sb.append(stack.pop() + "/");
		}
		// uses the string builders toString method to print the contents of the string
		// builder
		System.out.println(sb.toString());

	}

}
