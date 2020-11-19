package patelProject4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/*
 * Author: Saj Patel
 * 
 * Purpose: This is the driver that operates the while file system with the
 * help of the File system class that carries out all the operations that the driver
 * takes from the user. It saves its progress so that the user can resume from they 
 * has left off when the run the program again
 * 
 * Date: 5/15/2020
 */
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating an instance of FileSystem
		FileSystem fs;

		try {
			FileInputStream fileIn = new FileInputStream("fs.data");
			ObjectInputStream objIn = new ObjectInputStream(fileIn);

			// Reads the object and sets the variable whatever is being read
			fs = (FileSystem) objIn.readObject();

			fileIn.close();
			objIn.close();

		} catch (IOException | ClassNotFoundException e) {
			fs = new FileSystem();
		}

		// Scanner and read user input and a boolean variable that is false until the
		// user inputs quit
		boolean quit = false;
		Scanner key = new Scanner(System.in);

		// loop that runs until quit is true
		while (!quit) {

			// prints the path of the file system that shows the user what directory they
			// currently are in
			System.out.print("/patelProject4");
			fs.pwd();

			// reads the users command and splits into as many words as there are in the
			// command and stores those words in an array
			System.out.println("Enter a commad: ");
			String command = key.nextLine();
			String[] split = command.split(" ", 2);

			// series of if- else statements that checks to see what the user input is and
			// calls the appropriate method from the fileSystem class
			if (split[0].equals("CheckMakeFile")) {
				try {
					fs.checkMakeFile(split[1]);
				} catch (IllegalArgumentException e) {
					System.out.println(e);
				}
				continue;
			}
			if (split[0].equals("ls")) {
				fs.ls();
				continue;
			}
			if (split[0].equals("mkdir")) {
				try {
					fs.mkdir(split[1]);
				} catch (IllegalArgumentException e) {
					System.out.println(e);
				}
				continue;
			}
			if (split[0].equals("touch")) {
				try {
					fs.touch(split[1]);
				} catch (IllegalArgumentException e) {
					System.out.println(e);
				}
				continue;
			}
			if (split[0].equals("cd")) {
				try {
					fs.cd(split[1]);
				} catch (IllegalArgumentException e) {
					System.out.println(e);
				}
				continue;
			}
			if (split[0].equals("rm")) {
				try {
					fs.rm(split[1]);
				} catch (IllegalArgumentException e) {
					System.out.println(e);
				}
				continue;
			}
			if (split[0].equals("rmdir")) {
				try {
					fs.rmdir(split[1]);
				} catch (IllegalArgumentException e) {
					System.out.println(e);
				}
				continue;
			}
			if (split[0].equals("tree")) {
				fs.tree();
				continue;
			}
			if (split[0].equals("pwd")) {
				fs.pwd();
				continue;
			}
			if (split[0].equalsIgnoreCase("quit")) {
				quit = true;
				break;
			}else {
				for(int i = 0; i < split.length; i++) {
					System.out.print(split[i] + " ");
				}
				System.out.println("is an invalid command, Try again!");
			}
			
			

		}

		// this saves the content of the file system for later use
		try {
			// Set up the streams
			FileOutputStream fileOut = new FileOutputStream("fs.data");
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

			// Write the object using writeObject
			objOut.writeObject(fs);

			// Close the streams
			objOut.close();
			fileOut.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
