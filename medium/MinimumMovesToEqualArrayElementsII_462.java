package medium;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII_462 {
	//讨论区-方法1：排序找出中间值
	 public int minMoves2(int[] nums) {
		 if(nums==null||nums.length<=1) return 0;
		 Arrays.sort(nums);
		 int medium = nums[nums.length/2];
		 int sum = 0;
		 for(int i=0;i<nums.length;i++){
			 sum += nums[i]<=medium?medium-nums[i]:nums[i]-medium;
		 }
		 return sum;
	 }
	 
	 //讨论区-方法2：排序首尾两端相减
	 public int minMoves21(int[] nums) {
		 if(nums==null||nums.length<=1) return 0;
		 Arrays.sort(nums);
		 int i = 0, j = nums.length-1;
		 int sum = 0;
		 while(i<j){
			 sum += nums[j--]-nums[i++];
		 }
		 return sum;
	 }
}
