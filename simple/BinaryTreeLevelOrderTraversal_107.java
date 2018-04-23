package simple;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//瀵逛簬缁欏畾鐨勪簩鍙夋爲锛岃繑鍥炶嚜搴曞悜涓婂眰绾ч亶鍘?
public class BinaryTreeLevelOrderTraversal_107 {
	
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	//娣卞害浼樺厛鎼滅储DFS
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        List<Integer> list;
        queue.offer(root);
        List<List<Integer>> resultlist = new ArrayList();
        while(queue.size()>0){
        	list = new ArrayList();
        	int size = queue.size();
        	for(int i=0;i<size;i++){
        		TreeNode node = queue.poll();
        		list.add(node.val);
        		if(node.left!=null) queue.offer(node.left);
        		if(node.right!=null) queue.offer(node.right);
        	}
        	//resultlist.add(0,list);  //鎶婂厓绱犳坊鍔犲湪寮?澶寸殑浣嶇疆瀹炵幇鍊掑簭
        	resultlist.add(list);        	
        }
        //鍊掑簭
        List<List<Integer>> resultlist1 = new ArrayList();
        for(int i=resultlist.size();i>0;i--){
        	resultlist1.add(resultlist.get(i-1));
        }
        return resultlist1;
    }
	
	//璁ㄨ鍖?2锛氬箍搴︿紭鍏堟悳绱FS
	public List<List<Integer>> levelOrderBottom1(TreeNode root) {
		List<List<Integer>> list = new ArrayList();
		leverSearch(list,root,0);
		return list;
	}

	private void leverSearch(List<List<Integer>> list, TreeNode root, int level) {
		if(root==null) return;

		//level鏄眰鏁拌鏁板櫒锛屾瘡閬嶅巻涓?涓柊鐨勫眰娆★紝鍏堟坊鍔犱竴涓柊鍏冪礌
		if(level>=list.size()){
			list.add(0,new ArrayList<Integer>());
		}
		//灏嗗厓绱犳坊鍔犲埌瀵瑰簲灞傛鐨刲ist涓?,姝ゆ柟娉曠洿鎺ユ槸鍊掑簭鐨勭粨鏋?
		list.get(list.size()-level-1).add(root.val);
		//list.get(0).add(root.val);  //涓婇潰杩欏彞涓嶇瓑浜庤鍙ワ紝鍥犱负鍦ㄦ繁搴︿紭鍏堜腑锛屾湁鍙兘涓嶅悓鐨勫眰绾у悓鏃堕亶鍘嗭紝姝ゆ椂list.size()-level-1灏变笉涓?瀹氫綅0
		leverSearch(list,root.left,level+1);
		leverSearch(list,root.right,level+1);
	}	
	
	
	//璁ㄨ鍖?-鏂规硶3锛氭繁搴︿紭鍏堟悳绱㈢殑鍙樺舰
	List<List<Integer>> res;
	public void DFS(TreeNode root, int level)
	{
	    if (root == null) return;
	    if (level == res.size()) // The level does not exist in output
	    {
	        res.add(new ArrayList<Integer>()); // Create a new level
	    }
	    
	    res.get(level).add(root.val); // Add the current value to its level
	    DFS(root.left, level+1); // Go to the next level
	    DFS(root.right,level+1);
	}

	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
	    DFS(root, 0);
	    List<List<Integer>> result = new ArrayList();
	    for(int i=res.size();i>0;i--){
	    	result.add(res.get(i-1));
	    }
	    return result;
	}
}
