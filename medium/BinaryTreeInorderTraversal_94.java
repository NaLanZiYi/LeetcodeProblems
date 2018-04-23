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
        		//��������ı�ԭ���Ķ��������������ж�node.left��ʱ���Ѿ��������Ľڵ��������ţ���˽��������Ľڵ����ڵ���Ϊnull
        		if(stack.size()>0) stack.peek().left=null;
        		if(node.right!=null) stack.push(node.right);
        	}else{
        		stack.push(node.left);
        	}
        }
        return nodeList;
	}
	
	//������-����1������
	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> nodeList = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur!=null||stack.size()>0){
			//������Ӵ��ڣ���ӵ�ջ���������������֧
			while(cur!=null){
				stack.push(cur);
				cur = cur.left;
			}
			//������Ϊ��ʱ������ջ��Ԫ�ش������б�Ȼ������Һ���
			cur = stack.pop();
			nodeList.add(cur.val);
			cur = cur.right;
		}
		return nodeList;
	}
	
	//������-����2���ݹ�
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
