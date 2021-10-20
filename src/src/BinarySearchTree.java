package src;

import java.util.LinkedList;

public class BinarySearchTree implements Tree {

	private Node root;
	
	protected void setRoot(Node root) {
		this.root = root;
	}

	public boolean insert(int value) {
		if (root == null) {
			root = new Node(value);
			return true;
		} else {
			return insert(root, value);
		}
	}

	private boolean insert(Node node, int value) {
		if (value > node.value) {
			if (node.hasRight()) {
				return insert(node.right, value);
			} else {
				node.right = new Node(value);
			}
		} else if (value < node.value) {
			if (node.hasLeft()) {
				return insert(node.left, value);
			} else {
				node.left = new Node(value);
			}
		} else {
			return false; // contains value
		}
		return true;
	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node node, int value) {
		if (node == null) {
			return false;
		} else {
			if (node.value == value) {
				return true;
			} else if (value > node.value) {
				return contains(node.right, value);
			} else if (value < node.value) {
				return contains(node.left, value);
			}
		}
		return false;
	}

	public boolean remove(int value) {
		root = remove(root, value);
		return true;
	}

	private Node remove(Node node, int value) {
		if (node == null) {
			return null;
		} else if (node.value == value) {
			if (node.isLeaf()) {
				return null;
			} else if (node.hasLeft() && !node.hasRight()) {
				return node.left;
			} else if (node.hasRight() && !node.hasLeft()) {
				return node.right;
			} else {
				Node child = node.right;
				if (!child.hasLeft()) {
					child.left = node.left;
					return child;
				} else {
					Node successor = removeSuccessor(child);
					successor.left = node.left;
					successor.right = node.right;
					return successor;
				}
			}
		} else if (value > node.value) {
			node.right = remove(node.right, value);
			return node;
		} else if (value < node.value) {
			node.left = remove(node.left, value);
			return node;
		}
		return node;
	}

	protected Node removeSuccessor(Node node) {
		if (!node.left.hasLeft()) {
			Node successor = node.left;
			node.left = successor.right;
			return successor;
		} else {
			return removeSuccessor(node.left);
		}
	}

	public int height() {
		return height(root, 0);
	}

	private int height(Node node, int level) {
		if (node == null) { // root
			return level;
		}
		return Math.max(height(node.left, level + 1), height(node.right, level + 1));
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node root) {
		if (root != null) {
			System.out.print(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root);
			inOrder(root.right);
		}
	}

	public void posOrder() {
		posOrder(root);
	}

	private void posOrder(Node root) {
		if (root != null) {
			posOrder(root.left);
			posOrder(root.right);
			System.out.print(root);
		}
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node current = queue.removeFirst();
			if (current != null) {
				System.out.println(current);
				queue.addLast(current.left);
				queue.addLast(current.right);
			}
		}
	}

	public String toString() {
		return toString(root, "", 0);
	}

	public String toString(Node current, String tabs, int level) {
		if (current == null) {
			return "";
		}
		String str = toString(current.right, tabs + "\t", level + 1);
		str += String.format("%s%s [Level:%d]\n", tabs, current, level + 1);
		str += toString(current.left, tabs + "\t", level + 1);
		return str;
	}

	private boolean equals(Node aNode, Node bNode) {
		if (aNode != null && bNode != null) {
			boolean left = equals(aNode.left, bNode.left);
			boolean right = equals(aNode.right, bNode.right);
			return aNode.value == bNode.value && left && right;
		} else {
			return aNode == null && bNode == null;
		}
	}

	public boolean equals(Object obj) {
		if (obj instanceof BinarySearchTree) {
			BinarySearchTree tree = (BinarySearchTree) obj;
			return equals(root, tree.root);
		} else {
			return super.equals(obj);
		}
	}
	
	public boolean buscaElemento(int valor) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node current = queue.removeFirst();
			if (current != null) {
				if(current.value == valor) {
					System.out.println("Elemento encontrado.");
					return true;
				}
				queue.addLast(current.left);
				queue.addLast(current.right);
			}
		}
		System.out.println("Elemento não encontrado.");
		return false;
	}
	
	public boolean inserirElemento(int valor) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node current = queue.removeFirst();
			if (current != null) {
				queue.addLast(current.left);
				queue.addLast(current.right);
			} else if( current == null ) {
				Node novoNode = new Node(valor);
				current = novoNode;
				return true;
			}
		}
		return false;
	}
	
	public boolean removerElemento(int valor) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node current = queue.removeFirst();
			if (current != null) {
				if(current.value == valor) {
					current.value = -1;
					System.out.print("Elemento removido");
					return true;
				}
				queue.addLast(current.left);
				queue.addLast(current.right);
			} 
		}
		System.out.print("Elemento não removido/encontrado");
		return false;
	}

	public Node getRoot() {
		return root;
	}
	
}
