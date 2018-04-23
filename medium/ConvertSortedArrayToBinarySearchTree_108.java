package medium;

import java.util.Stack;

public class ConvertSortedArrayToBinarySearchTree_108 {
	
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	//讨论区-方法1：递归
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums==null) return null;
        return helper(nums,0,nums.length);
    }
	
	private TreeNode helper(int[] nums, int start, int end) {
		int mid = start + (end - start)/2;
		if(end<=start){
			return null;
		}
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums,start,mid-1);
		node.right = helper(nums,mid+1,end);
		return node;
	}
	
	//讨论区-方法2：迭代
	public TreeNode sortedArrayToBST1(int[] nums) {
		if(nums==null||nums.length==0) return null;
		int len = nums.length;
		TreeNode head = new TreeNode(0);
		Stack<TreeNode> nodeStack = new Stack<>();
		Stack<Integer> leftStack = new Stack<>();
		Stack<Integer> rightStack = new Stack<>();
		nodeStack.push(head);
		leftStack.push(0);
		rightStack.push(len-1);
		while(nodeStack.size()>0){
			TreeNode cur = nodeStack.pop();
			int left = leftStack.pop();
			int right = rightStack.pop();
			int mid = left + (right-left)/2;
			cur.val = nums[mid];
			if(mid-1 >= left){
				nodeStack.push(cur.left = new TreeNode(0));
				leftStack.push(left);
				rightStack.push(mid-1);
			}
			if(right-1 >= mid){
				nodeStack.push(cur.right = new TreeNode(0));
				leftStack.push(mid+1);
				rightStack.push(right);
			}
		}
		return head; 
	}
	
	//讨论区-方法3：递归
	public TreeNode sortedArrayToBST2(int[] num) {
	    if (num == null || num.length == 0) return null;
	    TreeNode root = new TreeNode(0);
	    insertNode(root,num,0,num.length-1);
	    return root;
	}

	public void insertNode(TreeNode root, int[] num, int s, int e){
		if (s==e){
			root.val = num[s];
			return;
		}
		int mid = (s+e)%2 == 0 ? (s+e)/2 : (s+e)/2+1;
		root.val = num[mid];
		if (mid-s >= 1){
			root.left = new TreeNode(0);
			insertNode(root.left,num,s,mid-1);
		}
		
		if (e-mid >=1){
			root.right = new TreeNode(0);
			insertNode(root.right,num,mid+1,e);
		}
		return;
	}
}
