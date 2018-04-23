package simple;
//瀵绘壘鏈?杩戝叕鍏辩鍏?
public class LowestCommonAncestor_235 {	
	
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  /*
   * 鏌ユ壘涓や釜node鐨勬渶鏃╃殑鍏叡绁栧厛锛屽垎涓夌鎯呭喌锛?
  	1. 濡傛灉涓や釜node鍦╮oot鐨勪袱杈癸紝閭ｄ箞鏈?鏃╃殑鍏叡绁栧厛灏辨槸root銆?
  	2. 濡傛灉涓や釜node鍦╮oot鐨勫乏杈癸紝閭ｄ箞鎶妑oot.leftChild浣滀负root锛屽啀閫掑綊銆?
  	3. 濡傛灉涓や釜node鍦╮oot鐨勫彸杈癸紝閭ｄ箞鎶妑oot.rightChild浣滀负root锛屽啀閫掑綊銆?
      	閭ｄ箞鎴戜滑濡備綍鐭ラ亾鑳藉惁閫氳繃鍘熷鑺傜偣鍒拌揪鏌愪竴涓妭鐐瑰憿锛熻繖閲屾垜浠渶瑕佸畾涔変竴涓?掑綊鍑芥暟
  		search (Node root, Node node)锛岃root鐨勫乏鍙冲瓙鑺傜偣涓嶆柇鐨勮皟鐢ㄨ繖涓嚱鏁帮紝
      	濡傛灉鏌愪竴涓瓙鑺傜偣灏辨槸瑕佹壘鍒扮殑鑺傜偣锛岄偅涔堣繑鍥瀟rue锛屽惁鍒欒繑鍥瀎alse. 鍏蜂綋浠ｇ爜濡備笅锛?
  */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    if(root==null||p==null||q==null) return null;
	    if(search(root.left,p)&&search(root.left, q))
	    	return lowestCommonAncestor(root.left, p, q);
	    if(search(root.right,p)&&search(root.right, q))
	    	return lowestCommonAncestor(root.right, p, q);
	    return root;
	}
	
	//鏌ユ壘t鏄惁鍦ㄦ爲涓?
	public boolean search(TreeNode root,TreeNode t){
		if(root==null||t==null) return false;
		if(root==t) return true;
		return search(root.left, t)||search(root.right, t);
	}
	
	//鏂规硶2锛氬埄鐢ㄤ簩鍙夋悳绱㈡爲杩欎釜鍓嶆彁鏉′欢
	//姣旇緝璺熻妭鐐圭殑鍊煎拰涓や釜寰呮悳绱㈣妭鐐圭殑鍊硷紝濡傛灉閮芥瘮璺熻妭鐐瑰皬鍒欏湪宸﹁竟锛屾瘮鏍硅妭鐐瑰ぇ灏卞湪鍙宠竟锛屽惁鍒欏氨鍦ㄤ袱杈癸紝姝ゆ椂杩斿洖鏍硅妭鐐?
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
	    if(root==null||p==null||q==null) return null;
	    if(Math.max(p.val, q.val)<root.val)
	    	return lowestCommonAncestor1(root.left, p, q);
	    if(Math.min(p.val, q.val)>root.val)
	    	return lowestCommonAncestor1(root.right, p, q);
	    //涔熷彲浠ュ啓鎴愯凯浠ｇ殑褰㈠紡锛屽彧闇?瑕佸皢涓婇潰鐨剅eturn璇彞鏀规垚root=root.left鎴杛oot.right;
	    return root;
	}
	
	//璁ㄨ鍖?3锛氶潪閫掑綊褰㈠紡
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
	    if(root==null||p==null||q==null) return null;
	    while((root.val-p.val)*(root.val-q.val)>0)
	    	root=root.val>q.val?root.left:root.right;
	    return root;
	}
	
	//璁ㄨ鍖?4锛氭柟娉?2鐨勭畝鍖栧舰寮?
	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
	    if(root==null||p==null||q==null) return null;
	    return ((root.val-q.val)*(root.val-p.val)<1?root:
	    	lowestCommonAncestor3(root.val>q.val?root.left:root.right,p,q));
	}
}
