package medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SingleNumberIII_260 {
	public int[] singleNumber(int[] nums) {		
        if(nums==null||nums.length<2) return new int[]{};
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
        	if(!set.add(n)) set.remove(n);
        }
        Iterator iter = set.iterator();
        return new int[]{(int) iter.next(),(int) iter.next()};
    }
	
	//讨论区-方法1：使用异或
	//对所有数进行异或，得到要寻找的两个数的异或值，根据异或的原理，出现二进制1的位置说明这两个数在该位置是不同的
	//如果有多个1位，则任意取一个1位即可，根据该位将原数组数据分为两组，那么这两个数必定落在不同的组内
	//参考：http://stackoverflow.com/questions/7405438/why-if-n-n-n-then-n-is-a-power-of-2
	public int[] singleNumber1(int[] nums) {
		int diff = 0;
		for(int n : nums){
			diff ^= n;
		}
		
		//取diff的最后一个二进制1位置，根据该位对数组元素进行分组
		//diff &= ~(diff-1)
		//diff ^= diff&(diff-1)
		//diff = Integer.highestOneBit(diff);
		diff &= -diff;
		int[] ret = {0,0};
		for(int n : nums){
			if((n & diff) == 0){
				ret[0] ^= n;
			}else{
				ret[1] ^= n;
			}
		}
		return ret;
	}
	
	//讨论区-方法2：与方法1相同，只有些微变化
	public int[] singleNumber2(int[] nums) {
		int xXor = nums[0];
	    for (int i = 1; i<nums.length; i++) {
	        xXor = xXor ^ nums[i];
	    }
	    
	    int marker = 1; 
	    while ((marker & xXor) != marker) {
	        marker = marker << 1;
	    }
	    
	    int resultX = 0;
	    for (int i = 0; i<nums.length; i++) {
	        if ((nums[i] & marker)!=0) {
	            resultX = resultX^nums[i];
	        }
	    }
	    //由于已经求出了其中一个，只需要在原异或结果上继续异或即可得出另外一个
	    int resultY = resultX^xXor;
	    
	    return new int[]{resultX, resultY};
	}
	
	
	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE+"--"+-Integer.MIN_VALUE);
	}
}
