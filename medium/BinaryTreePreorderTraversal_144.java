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
	//�ݹ�
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
	
	//����
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
	
	//����-����3��������ʹ��stack���Ƚ���Ԫ����ջ��Ȼ������-���˳�򷽷�Ԫ�أ����ջ��˳������-�ң��Ӷ�ʵ��ǰ�����
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
	
	//����-����4���ݹ飬����ʹ�ø�������
	public List<Integer> preorderTraversal3(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if(root==null) return list;
		list.add(root.val);
		list.addAll(preorderTraversal3(root.left));
		list.addAll(preorderTraversal3(root.right));
		return list;
	}
	
	//������-����5��stack�������Ľ�����ֻ�洢�ҽڵ㣬���ڵ�ֱ����ӵ������
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
