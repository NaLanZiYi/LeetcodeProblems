package simple;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	 }
	
	//BFS
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList();        
        if(root==null) return ret;
        List<Integer> list;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        TreeNode node;
        while(queue.size()>0){
        	list = new ArrayList();
        	int size = queue.size();
        	for(int i=0;i<size;i++){
        		node = queue.poll();
        		list.add(node.val);
        		if(node.left!=null) queue.offer(node.left);
        		if(node.right!=null) queue.offer(node.right);
        		//绛変环浜庝笅闈笁鍙ヨ瘽
//        		if(queue.peek().left!=null) queue.offer(queue.peek().left);
//        		if(queue.peek().left!=null) queue.offer(queue.peek().left);
//        		list.add(queue.poll().val);
        	}
        	ret.add(list);        	
        }
        return ret;
    }
	
	//DFS
	public List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> ret = new ArrayList();
		leverSearch(ret,root,0);
		return ret;
	}

	private void leverSearch(List<List<Integer>> ret, TreeNode root, int level) {
		if(root==null) return;
		if(level>=ret.size()){
			ret.add(new ArrayList());
		}
		ret.get(level).add(root.val);
		leverSearch(ret,root.left,level+1);
		leverSearch(ret,root.right,level+1);
	}
	
	//璁ㄨ鍖?-鏂规硶3锛欱FS鏀硅繘鐗堬紝涓嶄娇鐢╯ize鍙橀噺锛岃浆鑰屼互null浣滃眰娆″垎鍓?
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> ret = new ArrayList();
		if(root==null) return ret;
		Queue<TreeNode> queue = new LinkedList();
		List<Integer> list = new ArrayList();
		queue.offer(root);
		queue.offer(null);
		while(queue.size()>0){
			TreeNode node = queue.poll();
			if(node==null){
				ret.add(list);
				list = new ArrayList();
				if(queue.size()>0){
					queue.offer(null);
				}				
			}else{
				list.add(node.val);
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
			}
		}
		return ret;
	}
}
