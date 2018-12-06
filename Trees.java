/*TRESS*/
import java.util.Arrays;


class Node {

	public int data;
	Node left, right;

	Node(int d){
		this.data = d;
		left = right = null;
	}

}

class Index {
	int index = 0;
}

class Trees {

	Node first, middle, last, prev;
	Index preIndex = new Index();

	private void correctBSTUtil(Node root){

		if (root != null) {

			correctBSTUtil(root.left);
			
			if (prev != null && root.data < prev.data) {
				
				if (first == null) {
					first = prev;
					middle = root;
				}
				else 
					last = root;
			
			}

			prev = root;

			if (root.right != null) correctBSTUtil(root.right);
		}
	}

	/*
	* Two nodes of a BST are swapped, correct the BST
	* https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
	* O(n)
	*/
	private void correctBST(Node root){

		first = middle = last = prev = null;
		correctBSTUtil(root);

		if(first != null && last != null) {

			int temp = first.data; 
            first.data = last.data; 
            last.data = temp;

		} else if(first != null && middle != null) {

			int temp = first.data; 
            first.data = middle.data; 
            middle.data = temp;

		}
	}

	private Node constructTreeUtil(int[] pre, Index preIndex, int low, int high, int size) {

		if (preIndex.index >= size || low > high) return null;

		Node root = new Node(pre[preIndex.index]);
		preIndex.index = preIndex.index + 1;

		if(low == high) return root;

		int i;
		for (i = low; i <= high; i++) {
			if(pre[i] > root.data) break;
		}

		root.left = constructTreeUtil(pre, preIndex, preIndex.index, i - 1, size);
		root.right = constructTreeUtil(pre, preIndex, i, high, size);
		return root;
	}

	/*
	* Construct BST from given preorder traversal | Set 1
	* https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
	* O(n^2)
	*/
	private Node constructTree(int[] pre) {
		return constructTreeUtil(pre, preIndex, 0, pre.length - 1, pre.length);
	}

	private Node constructTreeUtilBis(int[] pre, Index preIndex, int key, int min, int max, int size) {
		if (preIndex.index >= size) return null;
		Node root = null;
		if (key > min && key < max) {
			root = new Node(key);
			preIndex.index = preIndex.index + 1;
			if (preIndex.index < size) {
				root.left = constructTreeUtilBis(pre, preIndex, pre[preIndex.index], min, key, size);
				root.right = constructTreeUtilBis(pre, preIndex, pre[preIndex.index], key, max, size);
			}
		}
		return root;
	}

	/*
	* Construct BST from given preorder traversal | Set 2
	* https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
	* O(n)
	*/
	private Node constructTreeBis(int[] pre) {
		preIndex.index = 0;
		return constructTreeUtilBis(pre, preIndex, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, pre.length);
	}

	void printInorder(Node node) 
    { 
        if (node == null) return;
        printInorder(node.left); 
        System.out.print(" " + node.data); 
        printInorder(node.right); 
    } 

	public static void main(String[] args) {

		Node root = new Node(6); 
        root.left = new Node(10); 
        root.right = new Node(2); 
        root.left.left = new Node(1); 
        root.left.right = new Node(3); 
        root.right.right = new Node(12); 
        root.right.left = new Node(7); 
  
        System.out.println("Inorder Traversal"+ 
                        " of the original tree"); 
        
        Trees tree = new Trees(); 
        tree.printInorder(root); 
        System.out.println("");
  
        tree.correctBST(root); 
  
        System.out.println("\nInorder Traversal"+ 
                          " of the fixed tree"); 
        tree.printInorder(root); 
        System.out.println("");



        int[] pre = new int[]{10, 5, 1, 7, 40, 50}; 
        root = tree.constructTree(pre);
        System.out.println("Inorder traversal of the constructed tree is "); 
        tree.printInorder(root);
        System.out.println("");

        System.out.println(Arrays.toString(pre));
        root = tree.constructTreeBis(pre);
        System.out.println("Inorder traversal of the constructed tree is -"); 
        tree.printInorder(root);
        System.out.println("");
		
	}
}