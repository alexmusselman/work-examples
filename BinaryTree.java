import java.util.*;
/**
 * Binary Tree
 */
public class BinaryTree{
	private TreeNode root;
	
	/**
	 * Constructor
	 */
	public BinaryTree(){
		root = null;
	}
	
	/**
	 * Adds a new value to the BST.
	 * 
	 * @param value The new value to be added to the ST.
	 */
	public void addRight(String value){
		root = addR(value, root);
	}
	
	private TreeNode addR(String value, TreeNode temp){
		if(temp == null){
			temp = new TreeNode(value);
		}
		else{
			temp.setRight(addR(value, temp.getRight()));
		}
		return temp;
	}
	/**
	 * adds a new value to the ST
	 * @param value value to be added
	 * */
	public void addLeft (String value) {
		root = addL(value, root);
	}
	
	private TreeNode addL (String value, TreeNode temp) {
		if(temp == null) {
			temp = new TreeNode(value);
		}
		else {
			temp.setLeft(addL(value, temp.getLeft()));
		}
		return temp;
	}
	
	/**
	 * adds a new value to the ST 
	 * @param value value to be added
	 * @param level how many times to the right before adding value to the left 
	 * */
	public void addLeft (String value, int level) {
		root= addL(value, root, level);
	}
	
	private TreeNode addL (String value, TreeNode temp, int level) {
		if(temp == null) {
			temp = new TreeNode(value); 
		}
		else{ if(level != 0) {
			temp.setRight(addL(value, temp.getRight(), level-1));
		}else
		temp.setLeft(addL(value, temp.getLeft(), level));
		}
		return temp;
	} 
/**
	 * adds a new value to the ST 
	 * @param value value to be added
	 * @param level how many times to the left before adding value to the right 
	 * */
	public void addRight (String value, int level) {
		root= addL(value, root, level);
	}
	
	private TreeNode addR (String value, TreeNode temp, int level) {
		if(temp == null) {
			temp = new TreeNode(value); 
		}
		else{ if(level != 0) {
			temp.setLeft(addR(value, temp.getLeft(), level-1));
		}else
		temp.setRight(addL(value, temp.getRight(), level));
		}
		return temp;
	}
	/**
	 * Prints the ST to the terminal horizontally. 
	 */
	public void printBST(){
		printBST(root, "");
	}
	
	private void printBST(TreeNode temp, String padding){
		if(temp == null){
			return;
		}
		printBST(temp.getRight(), padding+ "   ");
		System.out.println(padding + temp.getData());
		printBST(temp.getLeft(), padding+ "   ");
	}
	
	/**
	 * gives the root tree node 
	 * @return the root TreeNode
	 * */
	public TreeNode root () {
		return root;
	}
		
}

