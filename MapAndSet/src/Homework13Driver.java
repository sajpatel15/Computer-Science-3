import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Homework13Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArraySet<String> girlNames = new ArraySet<String>();

		File girl = new File("girlNames2016.txt");

		try {
			Scanner sc = new Scanner(girl);

			while (sc.hasNext()) {
				String name = sc.nextLine();
				String[] split = name.split(" ");
				girlNames.add(split[0]);
			}

			System.out.println(girlNames);

			sc.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not found");
		}

		ArraySet<String> boyNames = new ArraySet<String>();

		File boy = new File("boyNames2016.txt");

		try {
			Scanner sc = new Scanner(boy);

			while (sc.hasNext()) {
				String name = sc.nextLine();
				String[] split = name.split(" ");
				boyNames.add(split[0]);
			}

			System.out.println(boyNames);

			sc.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not found");
		}
		
		boyNames.retainAll(girlNames);
		
		System.out.println(boyNames.size());
		System.out.println(boyNames);
	}

}
