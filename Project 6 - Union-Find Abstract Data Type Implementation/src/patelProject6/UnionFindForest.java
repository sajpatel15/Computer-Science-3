package patelProject6;

import java.util.TreeMap;

public class UnionFindForest<T> implements UnionFind<T> {

	// inner-class that stores the value and a reference to the parent of that value
	private class Node {
		private T value;
		private Node parent;
		private int rank;

		// constructor that sets the value of the node and reference to the parent to
		// null
		public Node(T val) {
			this.value = val;
			parent = null;
			rank = 0;
		}

		public String toString() {
			return this.value.toString();
		}

	}

	private TreeMap<T, Node> forest;

	public UnionFindForest() {
		forest = new TreeMap<>();
	}

	@Override
	public void makeSet(T x) {
		// TODO Auto-generated method stub
		if (!forest.containsKey(x)) {
			Node newNode = new Node(x);
			newNode.parent = newNode;
			forest.put(x, newNode);
		}
	}

	@Override
	public void union(T x, T y) {
		// TODO Auto-generated method stub
		Node repx = forest.get(find(x));
		Node repy = forest.get(find(y));
		
		if(repx == repy){
			return;
		}
		
		if(repx.rank > repy.rank) {
			repy.parent = repx;
		} else {
			repx.parent = repy;
			if(repx.rank == repy.rank) {
				repy.rank++;
			}
		}
		
	}

	@Override
	public T find(T x) {
		// TODO Auto-generated method stub
		Node newNode = forest.get(x);
		if(newNode == null) {
			throw new IllegalArgumentException();	
		}
		Node representative = recursiveFind(newNode);
		return representative.value;
			
	}
	
	private Node recursiveFind(Node n) {
		if(n.parent == n) {
			return n;
		}
		
		n.parent = recursiveFind(n.parent);
		
		return n.parent;
		
	
	}

}
