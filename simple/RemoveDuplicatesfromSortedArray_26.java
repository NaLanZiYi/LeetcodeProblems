package simple;
//绉婚櫎鎺掑簭鏁扮粍涓浉鍚岀殑鍏冪礌
public class RemoveDuplicatesfromSortedArray_26 {
	 public int removeDuplicates(int[] nums) {
	      if(nums==null||nums.length==0) return 0;
	      int len = 1;  //濡傛灉鏁扮粍鏈夊?硷紝鑷冲皯杩斿洖1
	      for(int i=0;i<nums.length-1;i++){
	    	  if(nums[i]!=nums[i+1]){
	    		  nums[len++] = nums[i+1];
	    	  }	    	  
	      }
	      return len;
	 }
}
