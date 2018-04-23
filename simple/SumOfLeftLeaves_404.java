package simple;
import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves_404 {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	 //璁＄畻宸﹀彾瀛愯妭鐐圭殑鍜岋細娣卞害浼樺厛
	 public int sumOfLeftLeaves(TreeNode root) {
	    if(root==null) return 0;
	    if(root.left!=null){
	    	if(root.left.left==null&&root.left.right==null) 
	    		return root.left.val+sumOfLeftLeaves(root.right);
	    	return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
	    }else{
	    	return sumOfLeftLeaves(root.right);
	    }    
	 }
	 //娣卞害浼樺厛鐨勭畝鍖栫増鏈細閬垮厤閲嶅璁＄畻鍙宠妭鐐?
	 public int sumOfLeftLeaves1(TreeNode root) {
		    if(root==null) return 0;
		    int sum=0;
		    if(root.left!=null){
		    	if(root.left.left==null&&root.left.right==null) 
		    		sum+=root.left.val;
		    	sum+=sumOfLeftLeaves(root.left);
		    }
		    if(root.right!=null)
		    	sum+=sumOfLeftLeaves(root.right);
		    return sum;
		 }
	 
	 //骞垮害浼樺厛
	 public int sumOfLeftLeaves2(TreeNode root) {
		 if(root==null) return 0;
		 Queue<TreeNode> list=new LinkedList<TreeNode>();
		 list.offer(root);
		 int sum=0;
		 while(list.size()>0){
			 TreeNode node=list.poll();
			 if(node!=null){
				 if(node.left!=null){
					 if(node.left.left==null&&node.left.right==null){
						 sum+=node.left.val;
					 }else{
						 list.offer(node.left);
					 }
				 }
				 if(node.right!=null)
					 list.offer(node.right);
				 
			 }			 
		 }
		 return sum;
	 }
	 
	 //璁ㄨ鍖猴細鍊熷姪棰濆鍙傛暟锛氭爣璁板綋鍓嶈妭鐐规槸鍚︽槸宸﹁妭鐐?
	 public int sumOfLeftLeaves3(TreeNode root){
		 return helper(root,false);  //澧炲姞姝ゅ嚱鏁板彲浠ユ帓闄ゅ绔嬪ご缁撶偣鐨勫共鎵?
		 
	 }
	private int helper(TreeNode root, boolean isLeft) {
		 if(root==null) return 0;
		 if(root.left==null&&root.right==null)
			 return isLeft?root.val:0;
		 return helper(root.left,true)+helper(root.right,false);
	}
	 
}
