package simple;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree_101 {
	
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	//1锛氶?掑綊
	public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isEqual(root.left,root.right);
    }
	
	public boolean isEqual(TreeNode left,TreeNode right){
		if(left==null||right==null) return left==right;
		if(left.val!=right.val) return false;
		return isEqual(left.left,right.right)&&isEqual(left.right,right.left);
	}
	
	//2锛氳凯浠?
	public boolean isSymmetric1(TreeNode root) {
        if(root==null) return true;
        if(root.left==null||root.right==null) return root.left==root.right;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root.left);
        queue.offer(root.right);
        while(queue.size()>0){
        	//get nodes in pairs
        	TreeNode node1 = queue.poll();
        	TreeNode node2 = queue.poll();
        	if(node1.val!=node2.val) return false;
        	//deal null condition
        	if(node1.left==null||node2.right==null){
        		if(node1.left!=node2.right) return false;
        	};
        	if(node1.right==null||node2.left==null) {
        		if(node1.right!=node2.left) return false;
        	}
        	//add nodes in pairs
        	if(node1.left!=null) queue.offer(node1.left);
        	if(node2.right!=null) queue.offer(node2.right);
        	if(node1.right!=null) queue.offer(node1.right);
        	if(node2.left!=null) queue.offer(node2.left);
        }
        return true;
    }
	
	//璁ㄨ鍖?-3锛欴FS
	public boolean isSymmetric2(TreeNode root) {
	    if (root == null) {
	        return true;
	    }
	    Stack<TreeNode> leftStack = new Stack<>();
	    Stack<TreeNode> rightStack = new Stack<>();
	    TreeNode left = root.left;
	    TreeNode right = root.right;
	    while (left != null || right != null || !leftStack.isEmpty() || !rightStack.isEmpty()) {
	        if (left == null && right != null) {
	            return false;
	        }
	        if (left != null && right == null) {
	            return false;
	        }
	        if (left != null && right != null) {
	            if (left.val != right.val) {
	                return false;
	            }
	            leftStack.push(left);
	            rightStack.push(right);
	            left = left.left;
	            right = right.right;
	        } else {  //閮戒笉涓虹┖鐨勬儏鍐碉紝寮瑰嚭澶磋妭鐐?
	            left = leftStack.pop().right;
	            right = rightStack.pop().left;
	        }
	    }
	    return true;
	}
}
