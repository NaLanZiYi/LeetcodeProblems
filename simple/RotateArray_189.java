package simple;
import java.util.Arrays;

public class RotateArray_189 {
	//由于数组传地址，在赋值前用额外的数组将原数组备份
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		if(k%len==0) return ;
		int rotate = k%len;
        int[] arrs = new int[len];
        for(int i=0;i<len;i++) arrs[i] = nums[i];
        for(int i=rotate;i<len;i++){
        	nums[i] = arrs[i-rotate];
        }
        for(int i=0;i<rotate;i++){
        	nums[i] = arrs[len-rotate+i];
        }
        
        //上述代码可简化如下：
        for(int i=0;i<len;i++){
        	nums[(i+rotate)%len] = arrs[i];
        }
    }
	
	//讨论区-方法1：交换元素
	public void rotate1(int[] nums, int k) {
		int len = nums.length;
		k %= len;
		//先翻转所有元素，再分两段分别翻转
		reverse(nums,0,len-1);
		reverse(nums,0,k-1);
		reverse(nums,k,len-1);
		
		//或者先分段翻转，再整体翻转
		reverse(nums,0,len-k-1);
		reverse(nums,len-k,0);
		reverse(nums,0,len-1);
	}
	
	public void reverse(int[] nums,int start,int end){
		while(start<end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			++start;
			--end;
		}
	}
	
	
	public static void main(String[] args) {
//		RotateArray_189 test = new RotateArray_189();
		System.out.println(Arrays.toString(new int[]{1,2,3}));
	}
}
