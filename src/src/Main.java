package src;

public class Main {

	public static void main(String[] args) {
		Node root = new Node(2);
		
		Node node1 = new Node(1);
		Node node2 = new Node(3);
		
		root.setChilds(node1, node2);
		
		NewBinarySearchTree newTree = new NewBinarySearchTree();
		newTree.setRoot(root);
		
		newTree.inOrder();
		System.out.print("\n");
		newTree.insert(1);
		newTree.insert(1);
		System.out.print("\n");
		newTree.inOrder();
		System.out.print("\n");
		newTree.quantidadeElementos(newTree.getRoot());
	}

}
