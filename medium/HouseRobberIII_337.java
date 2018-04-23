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
	
	//������-����1���ݹ�
	//���ǲ��ݹ���ȥ���ᵼ��root.left.left�Ƚڵ��ظ������������������
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
	
	//������-����2���ݹ飬ʹ��map�洢�м�ڵ�����ظ�����
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
	
	//������-����3����̬�滮
	//��һ������Ԫ�ص����鱣��ÿ���ڵ�ı����������һ��Ԫ���ǲ�����ǰ�ڵ�����µ����ֵ���ڶ���Ԫ��������ǰԪ�ص����ֵ
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
