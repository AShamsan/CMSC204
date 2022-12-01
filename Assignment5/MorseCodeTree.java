import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>  {

	private TreeNode<String> root;
	
	/**
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}
	
	/**
	 * Adds element to the correct position in the tree based on the code This method will call the recursive method addNode
	 * 
	 * @param code
	 * @param result
	 */
	@Override
	public void insert(String code, String result) {
//		if (this.root == null) {
//            this.root = new TreeNode<String>(result);
        //} else 
		addNode(root, code, result);
		
	}
	
	/**
	 * Returns a reference to the root
	 */
	public TreeNode <String> getRoot(){
		
		return root;
	}
	
	/**
	 * sets the root of the MorseCodeTree
	 */
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}
	
	

	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code.
	 */
	public void addNode (TreeNode<String> root, String code, String letter) {
		
		TreeNode<String> temp = root;
		if (code.length() == 1)
		{
			if (code.equals("."))
			{
				temp.leftChild = new TreeNode<String>(letter);
			}
			else if (code.equals("-"))
			{
				temp.rightChild = new TreeNode<String>(letter);
			}
		}
		
		else
		{
			if (code.charAt(0) == '.')
			{
				temp = root.leftChild;
			}
			if (code.charAt(0) == '-')
			{
				temp = root.rightChild;
			}
			
			addNode(temp, code.substring(1), letter);
		}
	}
	
	/**
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(getRoot(), code); 

	}


	/**
	 * This is the recursive method that fetches the data of the TreeNode that corresponds with the code A '.' (dot) means traverse to the left.
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		TreeNode<String> tempNode = root;
		String str = "";
		
		if (code.length()==1) {
			if (code.equals(".")){
				str = tempNode.leftChild.getData();
			}
			 if(code.equals("-")) {
				str = tempNode.rightChild.getData();
				}
			return str;
		}
		else {
			if (code.charAt(0) == '.') 
			{
				tempNode = tempNode.leftChild;
			}
			else if (code.charAt(0) == '-') 
			{
				tempNode = tempNode.rightChild;
				
			}
		}
		return fetchNode(tempNode, code.substring(1));
	}
	
	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code.
	 */
	@Override
	public void buildTree() {
			insert(".", "e");
	        insert("-", "t");
	        insert("..", "i");
	        insert(".-", "a");
	        insert("-.", "n");
	        insert("--", "m");
	        insert("...", "s");
	        insert("..-", "u");
	        insert(".-.", "r");
	        insert(".--", "w");
	        insert("-..", "d");
	        insert("-.-", "k");
	        insert("--.", "g");
	        insert("---", "o");
	        insert("....", "h");
	        insert("...-", "v");
	        insert("..-.", "f");
	        insert(".-..", "l");
	        insert(".--.", "p");
	        insert(".---", "j");
	        insert("-...", "b");
	        insert("-..-", "x");
	        insert("-.-.", "c");
	        insert("-.--", "y");
	        insert("--..", "z");
	        insert("--.-", "q");
	}

	
	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly
	 */
	@Override
	public ArrayList<String> toArrayList() {

		ArrayList<String> morseList = new ArrayList<>(); 
		
		LNRoutputTraversal(getRoot(), morseList); 
		
		return morseList; 
	}
	

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * @param root
	 * @param list
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
	
		if (root.leftChild != null)
		{
			LNRoutputTraversal(root.leftChild, list);
		}
		
		
		list.add(root.getData());
		
		if (root.rightChild != null)
		{
			LNRoutputTraversal(root.rightChild, list);
		}
		
	}
	
	
	/**
	 * This operation is not supported in the MorseCodeTree
	 */
	public MorseCodeTree delete(String data) throws UnsupportedOperationException{
		
		throw new UnsupportedOperationException();
	}
	
	
	/**
	 * This operation is not supported in the MorseCodeTree
	 */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();	
		}

}


	