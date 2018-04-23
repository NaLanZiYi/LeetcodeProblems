package medium;

public class ArithmeticSlices_413 {
	//本题的难点主要在于计算sum
	//讨论区-方法1：
	//原理，从3个序列开始，序列长度每增加1，对应和增加i-3+1=i-2，用cur记录这个增加的值，加到sum上即为总和
	public int numberOfArithmeticSlices(int[] A) {
		if(A.length<3) return 0;
		int sum = 0, cur = 0;
        for(int i=2;i<A.length;i++){
        	//注意，下面这句可能溢出，例如MAX_VALUE-MIN_VALUE，可能考虑转成long类型
        	if(A[i]-A[i-1]==A[i-1]-A[i-2]){
        		++cur;
        		sum+=cur;
        		//sum+=++cur;
        	}else{
        		cur=0;
        	}
        }
        return sum;
    }
	
	//讨论区-方法2
	//不需要每次都计算sum，只计算序列长度len，然后使用公式计算len对应多少个子序列
	public int numberOfArithmeticSlices1(int[] A) {
	    if(A == null || A.length < 3)
            return 0;
        int sum = 0;
        int len = 2;

        for(int i=2;i<A.length;i++) {
            // keep increasing the splice
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
                len++;
            }
            else {
                if(len > 2) {
                    sum += calculateSlices(len);
                }
                // reset the length of new slice
                len = 2;
            }
        }
        // add up the slice in the rear
        if(len>2)
            sum += calculateSlices(len);
        return sum;
	}
	//计算长度为n的序列包含多少子序列
	 private int calculateSlices(int n){
	        return (n-1)*(n-2)/2;
	    }
}
