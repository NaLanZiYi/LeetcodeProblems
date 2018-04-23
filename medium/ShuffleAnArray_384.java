package medium;

import java.util.Random;

public class ShuffleAnArray_384 {
    private int[] nums;
    private Random rand;
	public ShuffleAnArray_384(int[] nums) {
	     this.nums = nums;
	     this.rand = new Random();
	}
	    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] numbers = nums.clone();
        for(int i=1;i<numbers.length;i++){
        	//���ｲnumbers[i]��numbers[n]������numbers[i]�������ĸ�����1/i+1
        	//numbers[i]�����ĸ�����i/i+1,��ǰ������һ�������ĸ�����1/i
        	//��numbers[i]��numbers[n]�����ĸ�����i/i+1*1/i = 1/i+1;��ÿ��Ԫ�ر����ĸ�����ͬ
        	int n = rand.nextInt(i+1);
        	if(n!=i){
        		int temp = numbers[i];
        		numbers[i] = numbers[n];
        		numbers[n] = temp;
        	}
        }
        return numbers;
    }
}
