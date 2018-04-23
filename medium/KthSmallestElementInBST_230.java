package medium;

import java.util.Stack;

public class KthSmallestElementInBST_230 {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	//������-����1
	//ʹ�ø�������������ڵ���
	public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if(k<=count){
        	return kthSmallest(root.left,k);
        }else if(k>count+1){
        	return kthSmallest(root.right,k-count-1);
        }
        return root.val;
    }
	
	private int countNodes(TreeNode node) {
		if(node==null) return 0;
		return 1+countNodes(node.left)+countNodes(node.right);
	}
	
	//������-����2��DFS
	//�÷��������൱��BFS��������������մ�С����Ľڵ�Ѱ�ҵ�k��ڵ�
	private static int number = 0;
    private static int count = 0;
	public int kthSmallest1(TreeNode root, int k) {
		count = k;
		helper(root);
		return number;
	}

	private void helper(TreeNode root) {
		if(root.left!=null) helper(root.left);
		if(--count==0){  //�ҵ���k����Сֵ�ڵ�
			number = root.val;
			return ;
		}
		if(root.right!=null) helper(root.right);
	}
	
	//������-����3������2�ı���
	public int kthSmallest2(TreeNode root, int k) {
	    traverse(root, k);
	    return number;
	}

	public void traverse(TreeNode root, int k) {
	    if(root == null) return;
	    traverse(root.left, k);
	    count ++;
	    if(count == k) number = root.val;
	    traverse(root.right, k);       
	}
	
	//������-����4������2�ĵ�����ʽ
	public int kthSmallest3(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        
        while (root != null) {
            st.push(root);
            root = root.left;
        }
            
        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }
        
        return -1; // never hit if k is valid
	}
}
