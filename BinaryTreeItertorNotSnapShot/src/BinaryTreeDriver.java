import java.util.Iterator;

public class BinaryTreeDriver 
{
	public static void main(String[] args)
	{
		BinaryTree<String> t = new BinaryTree<>();
		
		Position<String> r = t.addRoot("The duality of self");
		Position<String> rl = t.addLeft(r, "Good");
		Position<String> rr = t.addRight(r, "Bad");

		Position<String> rll = t.addLeft(rl, "Selfless");
		Position<String> rlr = t.addRight(rl, "Kind");

		Position<String> rrl = t.addLeft(rr, "selfish");
		Position<String> rrr = t.addRight(rr, "hurtful");
		
//		Position<String> rrrl = t.addLeft(rrr, "evil");
//		Position<String> rrrr = t.addRight(rrr, "lucifer");
		
//		System.out.println(t);
//
//		
//		System.out.println("Root: " + t.root());
//		System.out.println("Root's left: " + t.left(r));
//		System.out.println("Root's right: " + t.right(r));
//		System.out.println("rrr's parent: " + t.parent(rrr));
		
//		System.out.println(t.isExternal(rrl));
//		System.out.println(t.isExternal(rl));
//		System.out.println(t.isExternal(r));
//		
//		System.out.println(t.isInternal(rrl));
//		System.out.println(t.isInternal(rl));
//		System.out.println(t.isInternal(r) + "\n");
//		
//		
//		System.out.println(t.outputAncestors(rrrr));
//		System.out.println();
//		System.out.println(t.depth(rrrr));
//		
//		System.out.println(t.recursiveDepth(rrrr));
//		
//		System.out.println(t.nodeHeight(rrrr));
		
		//For-each loop

		System.out.println("using for-each loop");
		for(String s : t ) {
			System.out.println(s);
		}
		
		//using iterator
		System.out.println("using  iterator object");
		Iterator<String> it = t.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
