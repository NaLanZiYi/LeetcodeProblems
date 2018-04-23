package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_144 {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	//递归
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(list,root);
        return list;
    }
	
	public void preorder(List<Integer> list, TreeNode node){
		if(node==null) return;
		list.add(node.val);
		preorder(list,node.left);
		preorder(list,node.right);
	}
	
	//迭代
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur!=null||stack.size()>0){
			while(cur!=null){
				stack.push(cur);
				list.add(cur.val);
				cur = cur.left;
			}
			cur = stack.pop();
			cur = cur.right;
		}
		return list;
	}
	
	//讨论-方法3：迭代，使用stack，先将根元素入栈，然后按照右-左的顺序方法元素，则出栈的顺序是左-右，从而实现前序遍历
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if(root==null) return list;
		stack.push(root);
		while(!stack.empty()){
			TreeNode node = stack.pop();
			list.add(node.val);
			if(node.right!=null) stack.push(node.right);
			if(node.left!=null) stack.push(node.left);
		}
		return list;
	}
	
	//讨论-方法4：递归，但不使用辅助函数
	public List<Integer> preorderTraversal3(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if(root==null) return list;
		list.add(root.val);
		list.addAll(preorderTraversal3(root.left));
		list.addAll(preorderTraversal3(root.right));
		return list;
	}
	
	//讨论区-方法5：stack迭代，改进在于只存储右节点，做节点直接添加到结果集
	public List<Integer> preorderTraversal4(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while(node!=null){
			list.add(node.val);
			if(node.right!=null) stack.push(node.right);
			node = node.left;
			if(node==null&&stack.size()>0) node = stack.pop();
		}
		return list;
	}
}
