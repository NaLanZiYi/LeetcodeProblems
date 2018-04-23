package medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber_268 {
	//最蠢的方法-排序后遍历
	public int missingNumber(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        Arrays.sort(nums);
        if(nums.length==1){
        	if(nums[0]==0) return 1;
        	else return 0;
        }
        int i = 0;
        for(;i<nums.length;i++){
        	if(nums[i]!=i){
        		return i;
        	}     	
        }
        return nums.length;
    }
	
	//讨论区-方法1：异或
	public int missingNumber1(int[] nums) {
		//如果中间出现缺失，那么最后一个数字必然是数组长度，此时与之取异或就得到正确值，如果没有缺失值，则直接返回数组长度
		int xor = 0, index = 0;
		for(int n : nums){
			xor ^= n ^ (index++);
		}
		return xor^index;
	}
	
	//讨论区-方法2：求和、
	//1.中间缺失，那么sum=i-len，最后加上数组长度len即可得出i
	//2.无缺失值，则sum=0,返回数组长度len即可
	public int missingNumber2(int[] nums) {
		int sum = nums.length;
		for(int i=0;i<nums.length;i++){
			sum += i-nums[i];
		}
		return sum;
		
		//或者
//		int n = nums.length, sum = 0;
//		for(int i=0;i<nums.length;i++){
//			sum+=i;
//		}
//		return n*(n+1)/2-sum;
	}
	
	//讨论区-方法3：二分查找
	public int missingNumber3(int[] nums) {
		int left = 0, right = nums.length, mid = left+(right-left)/2;
		Arrays.sort(nums);
		while(left<right){
			if(nums[mid]>mid){
				right = mid;
			}else{
				left = mid +1;
			}
			mid = left+(right-left)/2;
		}
		return left;
	}
	
	//讨论区-方法4：IntStream
	public int missingNumber4(int[] nums) {
		int n = nums.length;
		return (n*(n+1)/2-IntStream.of(nums).sum());
	}
}
