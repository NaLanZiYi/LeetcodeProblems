package simple;
import java.util.Deque;
import java.util.LinkedList;


/**
 * 将二叉树每个节点的左右节点互换
 * @author Dian
 *
 */
public class InvertBinaryTree_226 {
	
	//深度优先搜索DFS
	public TreeNode invertTree(TreeNode root) {
	    if(root==null) return null;
		root.left=invertTree(root.right);
		root.right=invertTree(root.left);
		return root;
	}
	
	//广度优先搜索BFS
	public TreeNode invertTree1(TreeNode root) {
	    if(root==null) return null;
		Deque<TreeNode> stack=new LinkedList<TreeNode>();
		stack.offer(root);
		while(!stack.isEmpty()){
			TreeNode node=stack.poll();
			TreeNode left=node.left;
			node.left=node.right;
			node.right=left;
			if(node.left!=null) stack.offer(node.left);
			if(node.right!=null) stack.offer(node.right);			
		}
		return root;
	}
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
