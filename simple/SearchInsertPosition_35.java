package simple;

public class SearchInsertPosition_35 {
	
	 //从排序数组找到target的位置
	 public int searchInsert(int[] nums, int target) {
	     if(nums == null) return 0;
	     
	     int left=0, right = nums.length-1, mid = 0;
	     if(target >= nums[right]) return right+1;
	     while(left < right){
	    	 mid = left + (right-left)/2;
	    	 if(nums[mid] < target){
	    		 left = mid + 1;
	    	 }else if(nums[mid] > target){
	    		 right = mid;
	    	 }else return mid;
	     }
	     
	     return right;
	 }
	 
	 public static void main(String[] args) {
		 SearchInsertPosition_35 test = new SearchInsertPosition_35();
		 int[] arr = {1,3,4,5,7,9};
		 System.out.println(test.searchInsert(arr, 2));
	}
}
