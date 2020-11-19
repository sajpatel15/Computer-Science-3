package patelHomework17;

public class Homework17Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		AVLTree<Integer> avl = new AVLTree<Integer>();

		// the BST takes longer because it is not balance hence when calling the add
		// function it will always add the the right of the tree which would make the
		// complexity of the add function would be O(n) and and for the remove function
		// it would be O(n^2) because of this fact
		long start = System.currentTimeMillis();

		for (int i = 0; i < 15001; i++) {
			bst.add(i);
		}

		for (int i = 15000; i >= 0; i--) {
			bst.remove(i);
		}

		long end = System.currentTimeMillis();

		System.out.println("Binary Search Tree time: " + (end - start) + "ms");

		// for the AVL tree it is much faster because the complexity of the add function
		// and the remove function would be O(n log(n)) because every time we add an
		// element we balance the tree and that has a complexity of O(1) which is why it
		// is a lot faster
		long start2 = System.currentTimeMillis();

		for (int i = 0; i < 15001; i++) {
			avl.add(i);
		}

		for (int i = 15000; i >= 0; i--) {
			avl.remove(i);
		}

		long end2 = System.currentTimeMillis();

		System.out.println("AVLTree time: " + (end2 - start2) + "ms");

	}

}
