package patelProject6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project6Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UnionFindForest<String> groups = new UnionFindForest<>();

		
		
		try {
			// Read the names and add them to the data structure using makeSet(name)
			File file = new File("SampleInput1.txt");
			Scanner sc = new Scanner(file);
			int size = sc.nextInt();
			for (int i = 0; i < size; i++) {
				groups.makeSet(sc.next());
			}
			// Read the rest of the file and perform unions
			while(sc.hasNext()) {
				String x = sc.next();
				x = x.substring(0, x.length()-1);
				String y = sc.next();
				
				groups.union(x, y);
				
				System.out.println(x + " " + y);
			}
			
			sc.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

		System.out.println("Tests begin");
		assert groups.find("Barbara")
				.equals(groups.find("Joseph")) : " Barbara and Joseph should be in the same group!";
		assert groups.find("Joseph")
				.equals(groups.find("Patricia")) : " Joseph and Patricia should be in the same group!";
		assert groups.find("Mary").equals(groups.find("Linda")) : " Mary and Linda should be in the same group!";
		assert groups.find("Charles")
				.equals(groups.find("William")) : " Charles and William should be in the same group!";

		assert !groups.find("Michael")
				.equals(groups.find("William")) : " Michael and William should not be in the same group!";
		assert !groups.find("Joseph")
				.equals(groups.find("Steven")) : " Joseph and Steven should not be in the same group!";
		assert !groups.find("Richard")
				.equals(groups.find("Mary")) : " Richard and Mary should not be in the same group!";
		assert !groups.find("William")
				.equals(groups.find("Barbara")) : " William and Barbara should not be in the same group!";

		System.out.println("all tests passed!");

	}

}
