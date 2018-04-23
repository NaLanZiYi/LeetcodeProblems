package simple;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PathSum_112 {
	
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	 //閫掑綊:杩欑鎯呭喌闇?瑕佸?熷姪涓?涓澶栫殑鍙傛暟鏉ヨ褰曚骇鐢熺殑涓棿缁撴灉s
	public boolean hasPathSum(TreeNode root, int sum ) {
        return iterNodes(root , 0 , sum);
        
    }
	
	public boolean iterNodes(TreeNode node , int s, int sum){
		if(node!=null){
			s+=node.val;
			if(node.left==null&&node.right==null){				
				if(s==sum) return true;
			}
			return iterNodes(node.left,s,sum)||iterNodes(node.right,s,sum);
		}else{
			return false;
		}		
	}
	
	//寰幆
	public boolean hasPathSum1(TreeNode root, int sum ) {
		if(root==null) return false;
		Queue<TreeNode> queue = new LinkedList();
		Queue<Integer> sums = new LinkedList();
		queue.offer(root);
		sums.offer(root.val);
		while(queue.size()>0){
			TreeNode node = queue.poll();
			int sum1 = sums.poll();
			if(node.left==null&&node.right==null){
				if(sum1==sum) return true;
			}else{
				if(node.left!=null) {
					queue.offer(node.left);
					sums.offer(sum1+node.left.val);
				}
				if(node.right!=null) {
					queue.offer(node.right);
					sums.offer(sum1+node.right.val);
				}
			}
		}
		return false;
	}
	
	//濡傛灉鍙互淇敼鑺傜偣鐨勫??
	public boolean hasPathSum2(TreeNode root, int sum ) {
		if(root==null) return false;
		Queue<TreeNode> queue = new LinkedList();
		queue.offer(root);
		int sum1 = 0;
		while(queue.size()>0){
			TreeNode node = queue.poll();
			sum1 = node.val;
			if(node.left==null&&node.right==null){
				if(sum1==sum) return true;
			}else{
				if(node.left!=null) {
					node.left.val+=sum1;
					queue.offer(node.left);
				}
				if(node.right!=null) {
					node.right.val+=sum1;
					queue.offer(node.right);
				}
			}
		}
		return false;
	}
	
	//璁ㄨ鍖猴細鏂规硶4
	//甯哥敤sum鍑忓幓姣忎釜鑺傜偣鍊肩殑鏂瑰紡锛岄伩鍏嶄娇鐢ㄩ澶栫殑鍑芥暟
	public boolean hasPathSum3(TreeNode root, int sum ) {
		if(root==null) return false;
		if(root.left==null&&root.right==null&&root.val==sum) return true;
		//鐢╯um鍑忓幓閬嶅巻杩囩殑鐖惰妭鐐圭殑鍊?--濂芥兂娉?
		return hasPathSum3(root.left,sum-root.val)||hasPathSum3(root.right,sum-root.val);
	}
	
	//璁ㄨ鍖?-鏂规硶5锛氬悗搴忛亶鍘嗭紝浣嗘槸杩樻病鐪嬫噦
	public boolean hasPathSum4(TreeNode root, int sum ) {
		Stack<TreeNode> s = new Stack();
        TreeNode pre = null, cur = root;
        int SUM = 0;
        while (cur!=null|| !s.empty()) {
            while (cur!=null) {
                s.push(cur);
                SUM += cur.val;
                cur = cur.left;
            }
            cur = s.firstElement();
            if (cur.left == null && cur.right == null && SUM == sum) {
                return true;
            }
            if (cur.right!=null && pre != cur.right) {
                cur = cur.right;
            } else {
                pre = cur;
                s.pop();
                SUM -= cur.val;
                cur = null;
            }
        }
        return false;
	}
}
