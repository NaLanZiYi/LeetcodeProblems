package medium;

import java.util.Arrays;

public class CombinationSumIV_377 {
	 //³¬Ê±
	 public int combinationSum4(int[] nums, int target) {
	      if(nums==null||nums.length==0) return 0;
	      Arrays.sort(nums);
	      if(target==0) return 1;
	      int ret = 0;
	      for(int i=0;i<nums.length;i++){
	    	  if(target>=nums[i]){
	    		  ret += combinationSum4(nums,target-nums[i]);
	    	  }else{
	    		  break;
	    	  }
	      }
	      return ret;
	 }
}
