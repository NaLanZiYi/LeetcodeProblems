package simple;
import java.util.ArrayList;
import java.util.List;

public class RangeSumQueryImmutable_303 {
	private int[] nums;
//	public RangeSumQueryImmutable_303(int[] nums) {
//        this.nums = nums;
//    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for(int k=i;k<=j;k++){
        	sum += nums[k];
        }
        return sum;
    }
    
    //讨论区-方法1：提前计算好前n项之和，但是可能会溢出，而且改变了原数组
//    public RangeSumQueryImmutable_303(int[] nums) {
//        for(int i=1;i<nums.length;i++){
//        	nums[i] += nums[i-1];
//        }
//        this.nums = nums;        
//    }
    
  //使用arraylist避免改变原数组
    private List<Integer> list;
    public RangeSumQueryImmutable_303(int[] nums) {
    	list = new ArrayList<>();
        for(int i=1;i<nums.length;i++){
        	if(i==1) list.add(nums[i-1]);
        	list.add(list.get(i-1)+nums[i]);
        }
    }

    public int sumRange1(int i, int j) {
       if(i==0) return this.nums[j];
       return this.nums[j] - this.nums[i-1];
    }
}
