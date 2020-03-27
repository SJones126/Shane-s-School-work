import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HW_2_0389 {

	public static void main(String[] args) {

		AVL_Tree apple = new AVL_Tree();

		Scanner after = null; 
		String fileName; 
							

		// Opnes the txt file with the indicated name 
		// in this case we have input.txt 
		fileName = "data.txt";
		try {
			after = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Error openning file..");
			System.exit(1);
		} // End try-catch1.

		try {
			String line;
			
			int lineNumber = 1; // Line Number

			// locates words 
			while ((line = after.nextLine()) != null) {

				StringTokenizer st = new StringTokenizer(line);

				while (st.hasMoreTokens()) {

					String tokenWord = st.nextToken();
					String editedWord = ""; // Holds the words that have been edited

					// Remove any punctuation
					for (int i = 0; i < tokenWord.length(); i++) {
						if (Character.isLetterOrDigit(tokenWord.charAt(i))) {
							editedWord += tokenWord.charAt(i);
						} // End if
					} // End for

					apple.insertNode(editedWord, lineNumber);
				} // End while
				lineNumber++;
			} // End while
		} catch (NoSuchElementException e) {

		} // End try-catch

		apple.printInOrder();
	}
}

// AVL Tree methods 
class AVL_Tree {

	private Node root;

	private static class Node {

		private String list;
		LinkedList<Integer> numberLines;
		private int length;
		private int balance;
		private Node left;
		private Node right;
		private Node previous;

		Node(String word, Node parent, int line) {
			this.list = list;
			this.previous = parent;
			numberLines = new LinkedList<Integer>();
			numberLines.add(line);
		}
	}

	public boolean insertNode(String word, int line) {
		if (root == null) {
			root = new Node(word, null, line);
			return true;
		}

		Node n = root;
		while (true) {
			if (n.list.compareToIgnoreCase(word) == 0) {
				n.numberLines.add(line);
				return false;
			}

			Node parent = n;

			boolean goLeft = n.list.compareToIgnoreCase(word) > 0;

			n = goLeft ? n.left : n.right;

			if (n == null) {
				if (goLeft) {
					parent.left = new Node(word, parent, line);
				} else if (!goLeft) {
					parent.right = new Node(word, parent, line);
				}
				rebalance(parent);
				break;
			}
		}
		return true;
	}

	private void rebalance(Node n) {

		if (n.balance == -2) {
			if (height(n.left.left) >= height(n.left.right))
				n = rotateRight(n);
			else
				n = rotateLeftThenRight(n);

		} else if (n.balance == 2) {
			if (height(n.right.right) >= height(n.right.left))
				n = rotateLeft(n);
			else
				n = rotateRightThenLeft(n);
		}

		if (n.previous != null) {
			rebalance(n.previous);
		} else {
			root = n;
		}
	}
	// rotate left 
	private Node rotateLeft(Node a) {

		Node b = a.right;
		b.previous = a.previous;

		a.right = b.left;

		if (a.right != null)
			a.right.previous = a;

		b.left = a;
		a.previous = b;

		if (b.previous != null) {
			if (b.previous.right == a) {
				b.previous.right = b;
			} else {
				b.previous.left = b;
			}
		}

		return b;
	}
	// rotate right 
	private Node rotateRight(Node a) {

		Node b = a.left;
		b.previous = a.previous;

		a.left = b.right;

		if (a.left != null)
			a.left.previous = a;

		b.right = a;
		a.previous = b;

		if (b.previous != null) {
			if (b.previous.right == a) {
				b.previous.right = b;
			} else {
				b.previous.left = b;
			}
		}

		return b;
	}

	private Node rotateLeftThenRight(Node n) {
		n.left = rotateLeft(n.left);
		return rotateRight(n);
	}

	private Node rotateRightThenLeft(Node n) {
		n.right = rotateRight(n.right);
		return rotateLeft(n);
	}

	private int height(Node n) {
		if (n == null)
			return -1;
		return n.length;
	}

	private void reheight(Node node) {
		if (node != null) {
			node.length= 1 + Math.max(height(node.left), height(node.right));
		}
	}

	public void printInOrder() {
		printInOrder(root);
	}

	// prints out the in order list 
	private void printInOrder(Node n) {
		if (n != null) {
			printInOrder(n.left);
			System.out.printf(" %-20s ", n.list);
			for (Integer line : n.numberLines) {
				if (n.numberLines.size() == 1) {
					System.out.printf(" %d ", line);
				} else {
					System.out.printf(" %d ", line);
				}
			}
			System.out.println();
			printInOrder(n.right);
		}
	}
}