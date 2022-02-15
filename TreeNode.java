/**
 * Nodes of a Binary Tree
 */
public class TreeNode{
	
	private String data;
	private TreeNode left, right;
	/**
	 * Constructor
	 * @param data The value of the tree node
	 */
	public TreeNode(String data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	/**
	 * @return the node's data
	 */
	public String getData(){
		return this.data;
	}
	/**
	 * @return the left child
	 */
	public TreeNode getLeft(){
		return this.left;
	}
	/**
	 * @return the right child
	 */
	public TreeNode getRight(){
		return this.right;
	}
	/**
	 * @param value the node's data
	 */
	public void setData(String value){
		data = value;
	}
	/**
	 * @param value the node's new left child
	 */
	public void setLeft(TreeNode value){
		left = value;
	}
	/**
	 * @param value the node's new right child
	 */
	public void setRight(TreeNode value){
		right = value;
	}
}
