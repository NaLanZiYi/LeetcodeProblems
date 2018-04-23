package simple;

public class MaximumSubarray_53 {
	
	 //数组连续元素和的最大值
	 public int maxSubArray(int[] nums) {
	     if(nums == null || nums.length == 0) return 0;
	     
	     int sum = nums[0], max = sum;
	     for(int i=1;i<nums.length;i++){
	    	 sum = nums[i] + (sum < 0 ? 0 : sum);
	    	 max = Math.max(sum, max);
	     }
	     return max;
	 }
	 
	 public static void main(String[] args) {
		 MaximumSubarray_53 test = new MaximumSubarray_53();
		 int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		 System.out.println(test.maxSubArray(arr));
	}
}
