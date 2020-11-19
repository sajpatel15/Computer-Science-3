
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Homework14Driver {

	public static void main(String[] args) {

		BST<String> warAndPeace = new BST<String>();
		BST<String> danishWords = new BST<String>();
		File war = new File("warAndPeace.txt");
		File words = new File("wordlist.txt");
		try {
			Scanner warScan = new Scanner(war);

			// Since this file has a random words that are inserted in random orders that
			// would mean that the words would be added to both left sub tree and right
			// subtree and that would mean that the trees height is increasing at a rate of
			// log n where n is the number of nodes in the tree.

			// This means that the complexity of the algorithm is O(log n)

			long start = System.currentTimeMillis();

			while (warScan.hasNext()) {

				warAndPeace.insert(warScan.next());
			}

			long end = System.currentTimeMillis();
			System.out.println("War and Peace\ttime\t" + (end - start) + " ms");

			warScan.close();
			System.out.println(warAndPeace.getSize());

			// Since this file has words that are already sorted it will always add new
			// words to the right sub-tree repeatedly because the next word read always
			// ranks higher than the previous one since they are sorted this makes the
			// height of the tree a lot larger that the previous one and since the
			// complexity
			// of this function would be O(n * h) since the while loop has a complexity of
			// O(n+1) and the insert method has a complexity of O(h) combining the two would
			// make the complexityO(n * h). But h in this case would be n because every time
			// a right sub-tree is added when a new word is read.

			// This means the complexity for this program to run is O(n^2)
			Scanner wordScan = new Scanner(words);
			start = System.currentTimeMillis();

			while (wordScan.hasNext()) {

				danishWords.insert(wordScan.next());
			}

			end = System.currentTimeMillis();
			System.out.println("danishWords\ttime\t" + (end - start) + " ms");
			System.out.println(danishWords.getSize());
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

}
