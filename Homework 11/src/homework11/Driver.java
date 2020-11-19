package homework11;

public class Driver {
	public static void printExpression(BinaryTree<String> t, Position<String> p) {
		// TODO: Complete this method
		if (t.left(p) != null) {
			System.out.print("(");
			printExpression(t, t.left(p));
		}

		System.out.print(p.getValue());

		if (t.right(p) != null) {
			printExpression(t, t.right(p));
			System.out.print(")");
		}

	}

	public static int evaluateExpression(BinaryTree<String> t, Position<String> p) {
		// TODO: Complete this method
		if (t.isExternal(p)) {
			return Integer.parseInt(p.getValue());
		}

		int x = evaluateExpression(t, t.left(p));
		int y = evaluateExpression(t, t.right(p));

		String op = p.getValue();

		switch (op) {

		case "+":
			return x + y;
		case "-":
			return x - y;
		case "*":
			return x * y;
		case "/":
			return x / y;
		default:
			throw new IllegalStateException("Invalid Operand");
		}

	}

	public static void main(String[] args) {// Use this code to test the methods you define above.
		BinaryTree<String> tree = new BinaryTree<>();

//		Position<String> r = tree.addRoot("-");
//		Position<String> rl = tree.addLeft(r, "/");
//		Position<String> rll = tree.addLeft(rl, "*");
//		Position<String> rlll = tree.addLeft(rll, "+");
//		Position<String> rllll = tree.addLeft(rlll, "3");
//		Position<String> rlllr = tree.addRight(rlll, "1");
//		Position<String> rllr = tree.addRight(rll, "3");
//		Position<String> rlr = tree.addRight(rl, "+");
//		Position<String> rlrl = tree.addLeft(rlr, "-");
//		Position<String> rlrll = tree.addLeft(rlrl, "9");
//		Position<String> rlrlr = tree.addRight(rlrl, "5");
//		Position<String> rlrr = tree.addRight(rlr, "2");
//		Position<String> rr = tree.addRight(r, "+");
//		Position<String> rrl = tree.addLeft(rr, "*");
//		Position<String> rrll = tree.addLeft(rrl, "3");
//		Position<String> rrlr = tree.addRight(rrl, "-");
//		Position<String> rrlrl = tree.addLeft(rrlr, "7");
//		Position<String> rrlrr = tree.addRight(rrlr, "4");
//		Position<String> rrr = tree.addRight(rr, "6");
//		printExpression(tree, tree.root());
//		System.out.print(" = " + evaluateExpression(tree, tree.root()));
		
		  Position<String> r = tree.addRoot("+");
			Position<String> rl = tree.addLeft(r, "-");
			Position<String> rll = tree.addLeft(rl, "*");
			Position<String> rlll = tree.addLeft(rll, "-");
			Position<String> rllll = tree.addLeft(rlll, "11");
			Position<String> rlllr = tree.addRight(rlll, "2");
			Position<String> rllr = tree.addRight(rll, "3");
			Position<String> rlr = tree.addRight(rl, "+");
			Position<String> rlrl = tree.addLeft(rlr, "-");
			Position<String> rlrll = tree.addLeft(rlrl, "8");
			Position<String> rlrlr = tree.addRight(rlrl, "15");
			Position<String> rlrr = tree.addRight(rlr, "2");
			Position<String> rr = tree.addRight(r, "-");
			Position<String> rrl = tree.addLeft(rr, "+");
			Position<String> rrll = tree.addLeft(rrl, "42");
			Position<String> rrlr = tree.addRight(rrl, "*");	
			Position<String> rrlrl = tree.addLeft(rrlr, "+");
			Position<String> rrlrll = tree.addLeft(rrlrl, "3");
			Position<String> rrlrlr = tree.addRight(rrlrl, "9");
			Position<String> rrlrr = tree.addRight(rrlr, "+");
			Position<String> rrlrrr = tree.addRight(rrlrr, "7");
			Position<String> rrlrrl = tree.addLeft(rrlrr, "3");
			Position<String> rrr = tree.addRight(rr, "6");
			printExpression(tree, tree.root());
			System.out.println(" = " + evaluateExpression(tree, tree.root()));
	}
}