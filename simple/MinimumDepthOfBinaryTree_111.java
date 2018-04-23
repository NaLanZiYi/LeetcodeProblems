package simple;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDepthOfBinaryTree_111 {
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	 public int minDepth(TreeNode root) {
		if(root==null) return 0;
	    List<Integer> ret = new ArrayList();
	    iterPath(root,ret,0);
	    int min=Integer.MAX_VALUE;
	    for(int i : ret){
	    	if(min>i) min = i;
	    }
	    return min;
	 }
	 
	 public void iterPath(TreeNode node, List<Integer> list, int level){
		 if(node!=null){
			 if(node.left==null&&node.right==null){
				list.add(level+1);
			 }else{
				 iterPath(node.left,list,level+1);
				 iterPath(node.right,list,level+1);
			 }
		 }
		 else return;
	 }
	 
	 //对上述方法的改进：使用一个list用其第一个元素代表最小值，只遍历比最小值小的路径
	 public int minDepth1(TreeNode root) {
		if(root==null) return 0;
		List<Integer> ret = new ArrayList();
		ret.add(Integer.MAX_VALUE);
	    iterPath1(root,ret,0);		    
	    return ret.get(0);
	 }
	 
	 public void iterPath1(TreeNode node, List<Integer> ret, int level){
		 if(node!=null){
			 if(node.left==null&&node.right==null){
				if(ret.get(0)>level+1) ret.set(0, level+1);
			 }else if(ret.get(0)>level+1){  //只遍历比目前最小值小的路径
				 iterPath1(node.left,ret,level+1);
				 iterPath1(node.right,ret,level+1);
			 }
		 }
		 else return;
	 }
	 
	 //讨论区-3：不借助额外的函数
	 public int minDepth2(TreeNode root) {
		 if(root==null) return 0;
		 int l = minDepth2(root.left);
		 int r = minDepth2(root.right);
		 if(root.left==null||root.right==null) return l+r+1;
		 else return Math.min(l, r)+1;
		 //上两行代码的若干变种
		 //1
//		 if(root.left==null||root.right==null) 
//			 return Math.max(minDepth2(root.left), minDepth2(root.right))+1;
//		 return Math.min(minDepth2(root.left), minDepth2(root.right))+1;
		 
		 //2
//		 if(root.left==null) return minDepth2(root.left)+1;
//		 if(root.right==null) return minDepth2(root.right)+1;
//		 return Math.min(minDepth2(root.left), minDepth2(root.right))+1;
	 }
	 
	 //讨论区-4：
	 public int minDepth3(TreeNode root) {
	    if (root == null) return 0;
	    int L = minDepth(root.left), R = minDepth(root.right);
	    return 1 + (Math.min(L, R) > 0 ? Math.min(L, R) : Math.max(L, R));
	}
	 
	 //讨论区-5：BFS
	 //由于BFS是按顺序层次遍历，一旦发现有叶子节点，直接返回就是了，没有必要继续遍历
	public int minDepth4(TreeNode root) {
		    if (root == null) return 0;
		    Queue<TreeNode> Q = new LinkedList();
		    Q.offer(root);
		    int i = 0;
		    while (Q.size()>0) {
		        i++;
		        int k = Q.size();
		        for (int j=0; j<k; j++) {
		            TreeNode rt = Q.poll();
		            if (rt.left!=null) Q.offer(rt.left);
		            if (rt.right!=null) Q.offer(rt.right);
		            if (rt.left==null && rt.right==null) return i;
		        }
		    }
		    return -1; //For the compiler thing. The code never runs here.
		}
}
