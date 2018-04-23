package simple;
/**
 * Given an array nums, write a function to move all 0's to the end of it while 
 * maintaining the relative order of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums 
should be [1, 3, 12, 0, 0].
 * @author Dian
 *
 */
public class MoveZeroes_283 {
	//鏂规硶1锛氬皢鎵?鏈夌殑闈?0鏁板瓧鍓嶇Щ锛屽悗闈㈣ˉ0
	public void moveZeroes(int[] nums) {
		int temp=0;
	    for(int j=0;j<nums.length;j++){
	    	if(nums[j]!=0){
	    		nums[temp++]=nums[j];
	    	}
	    }
	    for(int k=temp;k<nums.length;k++){
	    	nums[k]=0;
	    }
	}
	
	//鏂规硶2锛氬噺灏戜笂闈㈢殑閬嶅巻娆℃暟锛屽皢褰撳墠闈?0鏁板瓧涓庡ご鎸囬拡浜ゆ崲骞剁Щ鍔ㄥご鎸囬拡
	public void moveZeroes1(int[] nums) {
		int front=0,temp=0;
	    for(int i=0;i<nums.length;i++){
	    	if(nums[i]!=0){
	    		temp=nums[front];
	    		nums[front]=nums[i];
	    		nums[i]=temp;
	    		front++;
	    	}
	    }
	}
}
