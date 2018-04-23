package medium;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII_337 {
	
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	//讨论区-方法1：递归
	//但是层层递归下去，会导致root.left.left等节点重复计算两遍甚至更多遍
	public int rob(TreeNode root) {
        if(root == null) return 0;
        int val = 0;
        if(root.left != null){
        	val += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
        	val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
	
	//讨论区-方法2：递归，使用map存储中间节点避免重复计算
	public int rob1(TreeNode root) {
		return robHelper(root,new HashMap<>());
	}

	private int robHelper(TreeNode root, Map<TreeNode,Integer> map) {
		if(root == null) return 0;
		if(map.containsKey(root)) return map.get(root);
		int val = 0;
		if(root.left != null){
        	val += robHelper(root.left.left,map) + robHelper(root.left.right,map);
        }
        if(root.right != null){
        	val += robHelper(root.right.left,map) + robHelper(root.right.right,map);
        }
        val = Math.max(val + root.val, robHelper(root.left,map) + robHelper(root.right,map));
        map.put(root, val);
        return val;
	}
	
	//讨论区-方法3：动态规划
	//用一个两个元素的数组保存每个节点的遍历结果，第一个元素是不抢当前节点情况下的最大值，第二个元素是抢当前元素的最大值
	public int rob2(TreeNode root) {
	    int[] res = robSub(root);
	    return Math.max(res[0], res[1]);
	}

	private int[] robSub(TreeNode root) {
	    if (root == null) return new int[2];
	    
	    int[] left = robSub(root.left);
	    int[] right = robSub(root.right);
	    int[] res = new int[2];

	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    res[1] = root.val + left[0] + right[0];
	    
	    return res;
	}
}
