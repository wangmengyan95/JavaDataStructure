
public class MyBST {
	private TreeNode root;
	public MyBST(){
		root = null;
	}
	public void insert(int key){
		if(root == null){
			root = new TreeNode(key);
			return;
		}
		
		TreeNode node = root;
		TreeNode parent = null;
		while(node != null){
			parent = node;
			if(node.val < key) node = node.right;
			else node = node.left;
		}
		
		if(parent.val < key) parent.right = new TreeNode(key);
		else parent.left = new TreeNode(key);
		
		return;
	}
	public void print(){
		inOrder(root);
		System.out.println();
	}
	private void inOrder(TreeNode node){
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.val+" ");
		inOrder(node.right);
	}
	
	private TreeNode[] find(int key){
		if(root == null) return null;
		
		TreeNode node = root;
		TreeNode parent = null;
		while(node != null){
			parent = node;
			if(node.val < key) node = node.right;
			else if(node.val > key) node = node.left;
			else break;
		}
		return new TreeNode[]{parent, node};
	}
	public void delete(int key){
		TreeNode[] target = find(key);
		if(target[1] == null) throw new IndexOutOfBoundsException();
		
		TreeNode node = target[1];
		TreeNode parent = target[0];
		
		if(node.left == null && node.right == null){
			if(parent.left == node) parent.left = null;
			else parent.right = null;
		}
		else if(node.left == null || node.right == null){
			if(parent.left == node) parent.left = node.left != null ? node.left : node.right;
			else  parent.right = node.left != null ? node.left : node.right;
		}
		else{
			
		}
	}
}
