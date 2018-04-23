package medium;

public class ProductOfArrayExceptSelf_238 {
	//讨论区-方法1：两次遍历，第一次计算前i-1项的积，第二次计算后length-i-1项
	public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        //第一次循环，计算每一项的前i-1项的乘积
        for(int i=1;i<n;i++){
        	result[i] = result[i-1]*nums[i-1];
        }
        //第二次循环，乘以后n-i-1项的乘积
        int right = 1;
        for(int i=n-1;i>=0;i--){
        	result[i] *= right;
        	right *= nums[i];
        }
        return result;
    }
	
	//讨论区-方法2：方法1的变形
	//区别在于在一次循环中完成对数组的赋值
	public int[] productExceptSelf1(int[] nums) {
		int[] result = new int[nums.length];
		for(int i=0;i<result.length;i++) result[i] = 1;
		int ltor = 1, rtol = 1;
		for(int i=0, j=nums.length-1;i<nums.length-1;i++,j--){
			ltor *= nums[i];
			rtol *= nums[j];
			result[i+1] *= ltor;
			result[j-1] *= rtol;
		}
		return result;
	}
}
