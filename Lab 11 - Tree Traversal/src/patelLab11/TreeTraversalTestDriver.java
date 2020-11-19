package patelLab11;

public class TreeTraversalTestDriver {

	// creates the tree shown in Lab 11, COMP 2673
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		Position<Integer> one = tree.addRoot(1);
		Position<Integer> two = tree.addLeft(one, 2);
		Position<Integer> three = tree.addRight(one, 3);
		Position<Integer> four = tree.addLeft(two, 4);
		tree.addRight(two, 5);
		tree.addLeft(four, 7);
		tree.addRight(four, 8);
		Position<Integer> six = tree.addLeft(three, 6);
		tree.addLeft(six,9);
		tree.addRight(six,  10);
		//System.out.println(preorderOutput(tree,tree.root()));

	}
	
//	public static <T> String preorderOutput(BinaryTree<T> t, Position<T> p) {
//		
//	}

}
