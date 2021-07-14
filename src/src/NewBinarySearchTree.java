package src;

public class NewBinarySearchTree extends BinarySearchTree{
	/* QUESTÃO 2.A: Inserção em Árvore Binária com valores repetidos */
	public boolean insert(int value) {
		return newInsert(value,this.getRoot());
	}
	
	private boolean newInsert(int value, Node node) {
		if(value>node.value) {
			if (node.hasRight()) {
				return newInsert(value,node.right);
			} else {
				node.right = new Node(value);
				return true;
			}
		} else if(value < node.value) {
			if(node.hasLeft()) {
				return newInsert(value,node.left);
			}else {
				node.left = new Node(value);
				return true;
			}
		} else if(value == node.value){			
			Node newNode = new Node(value);
			newNode.setCount(0);
			Node auxNode = node.left;
			
			if(auxNode!=null) auxNode.setCount(0);
			
			newNode.setChilds(auxNode, null);
			node.setChilds(newNode, node.right);
			node.setCount(node.getCount()+1);
			return true;
		}
		
		return false;
	}
	
	/* QUESTÃO 2.B: Remoção em Árvore Binária com valores repetidos */
	public boolean remove(int value) {
		return newRemove(value, this.getRoot());
	}
	
	public boolean newRemove(int value, Node node) {
		return false;
	}
	
	/* QUESTÃO 2.C: Quantidade de Elementos em Árvore Binária com valores repetidos */
	public void quantidadeElementos(Node node) {
		if(node!=null && node.getCount()!=0) {
			System.out.print(""+node.value+ " ["+node.count+"]\n");
			
			quantidadeElementos(node.left);
			quantidadeElementos(node.right);
		}else {
			return;
		}
	}
}
