package simple;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树的最大深度
 * @author Dian
 *
 */
public class TreeDepth_104 {
	//深度优先DFS
	public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
	
	//广度优先BFS
	public int maxDepth1(TreeNode root) {
        if(root==null) return 0;
        Queue que=new LinkedList<TreeNode>();
        que.offer(root);
        int len = 0;
        while(que.size()>0){
        	int size = que.size();
        	len++;
        	for(int i=0;i<size;i++){
            	TreeNode node=(TreeNode) que.poll();
            	if(node.left!=null) que.offer(node.left);
            	if(node.right!=null) que.offer(node.right);
            }
        }        
        return len;
    }
}


// class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
// }
