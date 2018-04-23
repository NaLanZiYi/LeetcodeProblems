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
        	//这里讲numbers[i]与numbers[n]互换，numbers[i]不被换的概率是1/i+1
        	//numbers[i]被换的概率是i/i+1,其前面任意一个被换的概率是1/i
        	//则numbers[i]与numbers[n]互换的概率是i/i+1*1/i = 1/i+1;，每个元素被换的概率相同
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
