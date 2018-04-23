package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
  }
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        if(root==null) return nodeList;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(stack.size()>0){
        	TreeNode node = stack.peek();
        	if(node.left==null){
        		nodeList.add(stack.pop().val);
        		//下面这句会改变原来的二叉树，由于在判断node.left的时候，已经遍历过的节点会产生干扰，因此将便利过的节点的左节点置为null
        		if(stack.size()>0) stack.peek().left=null;
        		if(node.right!=null) stack.push(node.right);
        	}else{
        		stack.push(node.left);
        	}
        }
        return nodeList;
	}
	
	//讨论区-方法1：迭代
	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> nodeList = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur!=null||stack.size()>0){
			//如果左孩子存在，添加到栈顶并继续遍历左分支
			while(cur!=null){
				stack.push(cur);
				cur = cur.left;
			}
			//当左孩子为空时，弹出栈顶元素存入结果列表，然后遍历右孩子
			cur = stack.pop();
			nodeList.add(cur.val);
			cur = cur.right;
		}
		return nodeList;
	}
	
	//讨论区-方法2：递归
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> nodeList = new ArrayList<>();
		inorder(root,nodeList);
		return nodeList;
	}
	
	public void inorder(TreeNode node, List<Integer> list){
		if(node==null) return;
		inorder(node.left,list);
		list.add(node.val);
		inorder(node.right,list);
	}
}
