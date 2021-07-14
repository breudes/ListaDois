package src;

public class Node {

	protected int value;
	protected int count;
	
	public Node left;
	public Node right;
	public Node parent; // questão 01
	
	public Node() {
		this.left = null;
		this.right = null;
		this.parent = null; // questão 01
	}
	
	public Node(int value) {
		this.value = value;
		this.count = 1;
		this.parent = null; // questão 01
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public void setChilds(Node left, Node right) {
		this.left = left;
		if(this.left!=null) this.left.parent = this; // questão 01
		this.right = right;
		if(this.right!=null) this.right.parent = this; // questão 01
	}
	
	public String toString() {
		return Integer.toString(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
