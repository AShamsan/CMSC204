/**
 * This generic class is used in the MorseCodeTree classes.
 * The class consists of a reference to the data and a reference to the left and right child
 * 
 * @author Abdullah Shamsan
 *
 * @param <T>
 */
public class TreeNode<T> {

	private T data;
	protected TreeNode<T> leftChild, rightChild;

	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode
	 */
	public TreeNode(T dataNode){
		this.leftChild = null;
		this.rightChild = null;
		this.data = dataNode;
	}
	

	/**
	 * used for making deep copies
	 * @param node
	 */
	public TreeNode(TreeNode<T> node){
		
		this.leftChild = node.leftChild;
		this.rightChild = node.rightChild;
		this.data = node.getData();
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return
	 */
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}


	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}


	public TreeNode<T> getRightChild() {
		return rightChild;
	}


	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

}
