package simple;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths_257 {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList();
//        if(root==null) return ret;
        String path = "";  //String鎷兼帴鏁堢巼杈冧綆锛屽彲浠ヤ娇鐢⊿tringBuilder浠ｆ浛
        iterPath(root,path,ret);
        return ret;
    }
	
	public void iterPath(TreeNode node , String path , List<String> list){
		if(node!=null){
			if(node.left==null&&node.right==null){
				//濡傛灉褰撳墠涓哄彾瀛愯妭鐐癸紝鍒欒璺緞宸查亶鍘嗗畬
				path+=node.val;
				list.add(path);
			}else{
				//濡傛灉涓嶆槸鍙跺瓙鑺傜偣锛岀户缁悜涓嬮亶鍘?
				path+=node.val+"->";
				iterPath(node.left,path,list);
				iterPath(node.right,path,list);
			}			
		}
//		else{
//			//閬囧埌绌鸿妭鐐圭洿鎺ヨ繑鍥?
//			return;
//		}
	}
	
	//璁ㄨ鍖?-鏂规硶2锛氬彧鍦ㄤ竴涓嚱鏁颁腑閫掑綊
	public List<String> binaryTreePaths1(TreeNode root) {
		List<String> ret = new ArrayList();
		if(root==null) return ret;
		if(root.left==null&&root.right==null){
			ret.add(root.val+"");
			return ret;
		}
		for(String lp : binaryTreePaths1(root.left)){
			ret.add(root.val+"->"+lp);
		}
		for(String rp : binaryTreePaths1(root.right)){
			ret.add(root.val+"->"+rp);
		}
		return ret;
	}
	
	//璁ㄨ鍖猴細BFS
	public List<String> binaryTreePaths2(TreeNode root) {
		List<String> ret = new ArrayList();
		if(root==null) return ret;
		//鎹㈡垚stack灏卞彉鎴愪簡DFS
		Queue<TreeNode> queue = new LinkedList();
		Queue<String> strq = new LinkedList();
		queue.offer(root);
		strq.offer(root.val+"");
		while(queue.size()>0){			
			TreeNode node = queue.poll();
			String path = strq.poll();
			if(node.left==null&&node.right==null){
				ret.add(path);
				continue;
			}
			if(node.left!=null){
				strq.offer(path+"->"+node.left.val);
				queue.offer(node.left);
			}
			if(node.right!=null){
				strq.offer(path+"->"+node.right.val);
				queue.offer(node.right);
			}
		}
		return ret;
	}
}
