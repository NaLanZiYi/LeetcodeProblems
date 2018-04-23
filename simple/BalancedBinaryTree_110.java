package simple;
//鍒ゆ柇涓?妫垫爲鏄惁鏄钩琛′簩鍙夋爲
public class BalancedBinaryTree_110 {
	
	public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
	
	public boolean isBalanced(TreeNode root) {
        //if(root==null) return true;  //璇ュ垽鏂笉蹇呰锛屽洜涓哄湪鍚庨潰鐨刧etLength1涓凡缁忓仛杩囧垽鏂?
//        if(Math.abs(getLength(root.left)-getLength(root.right))<2) return true;
//        return isBalanced(root.left)&&isBalanced(root.right);
        return getLength1(root)!=-1;
    }
	
	//getLength鏂规硶灏嗘墍鏈夎妭鐐圭殑楂樺害閮借绠椾簡涓?閬嶏紝浣嗘槸骞舵湭缂撳瓨锛屾墍鏈夎绠楀啑浣欑壒鍒ぇ锛屼細閫犳垚鏍堟孩鍑?
	//澶嶆潅搴(NlogN)
	public int getLength(TreeNode node){
		if(node==null) return 0;
		return 1+Math.max(getLength(node.left), getLength(node.right));
	}
	
	//璁ㄨ鍖?-1锛氭敼杩涳紝鍒嗗埆姹傚嚭宸﹀彸瀛愯妭鐐圭殑楂樺害锛岀劧鍚庢瘮杈冿紝閬垮厤鏃犺皳鐨勮绠?
	//澶嶆潅搴(N)
	public int getLength1(TreeNode node){
		if(node==null) return 0;
		//return 1+Math.max(getLength(node.left), getLength(node.right));
		int lh = getLength(node.left);
		if(lh==-1) return -1;
		int rh = getLength(node.right);
		if(rh==-1) return -1;
		if(lh-rh>1||rh-lh>1) return -1;
		return Math.max(lh, rh)+1;
		
		//涓婅堪浠ｇ爜鐨勬敼杩?-鐗堟湰1
//		int lh = getLength(node.left);
//		if(lh!=-1){
//			int rh = getLength(node.right);
//			if(rh!=-1){
//				return Math.abs(lh,rh)<2?Math.max(lh,rh):-1;
//			}
//		}
//		return -1;
	}

}
