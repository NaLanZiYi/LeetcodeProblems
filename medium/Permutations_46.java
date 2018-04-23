package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations_46 {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,nums,0);
        return list;
    }
	
	//讨论区-方法1：不断的交换两个数组元素，模拟全排列的过程
	private void helper(List<List<Integer>> list, int[] nums, int begin) {
		if(begin>=nums.length){
			List<Integer> list1 = new ArrayList<>();
			for(int i : nums){
				list1.add(i);
			}
			list.add(list1);
			return;
		}
		for(int i=begin;i<nums.length;i++){
			swap(nums,begin,i);
			helper(list,nums,begin+1);
			swap(nums,begin,i);
		}
	}
	
	public void swap(int[] nums,int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	//讨论区-方法2：迭代
	//以{1，2，3}为例，首先add 1，ans={1}，接着将{{1}}复制，2有两个位置可以，分别是ans={{1,2},{2,1}}
	//接着再次复制{1,2}和{2,1}，add 3，有三种可能，后面以此类推
	public List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
        if(nums==null||nums.length==0) return list;
        list.add(new ArrayList<Integer>(nums[0]));
        for(int i = 1;i < nums.length; i++){
        	List<List<Integer>> templist = new ArrayList<>();
        	for(int j=0;j<=i;j++){
        		for(List<Integer> ls : list){
        			List<Integer> list1 = new ArrayList<>(ls);
        			ls.add(j,nums[i]);
        			templist.add(ls);
        		}
        	}
        	list = templist;
        }
        return list;
	}
	
	//讨论区-方法3：方法2的简化
	public List<List<Integer>> permute2(int[] num) {
	    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
	    res.add(new ArrayList<Integer>());
	    for (int n : num) {
	        int size = res.size();
	        for (; size > 0; size--) {
	            List<Integer> r = res.pollFirst();
	            for (int i = 0; i <= r.size(); i++) {
	                List<Integer> t = new ArrayList<Integer>(r);
	                t.add(i, n);
	                res.add(t);
	            }
	        }
	    }
	    return res;
	}
}
