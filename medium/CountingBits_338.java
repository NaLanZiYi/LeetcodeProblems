package medium;

public class CountingBits_338 {
	/**
	 * 寻找0-num之间所有数字的二进制各含有几个1
	 * @param num
	 * @return
	 */
	
	//讨论奇葩-方法1：迭代
	//原理：f[i]=f[i/2]+i%2
	//把i分为两部分，最后一位和前31位，最后一位是否是1等价于%2,前面部分则与i/2相同
	public int[] countBits(int num) {
        int[] ret = new int[num+1];
        for(int i=0;i<ret.length;i++){
        	ret[i] = ret[i>>1]+i%2;   //或者  ret[i] = ret[i>>1]+i&1;
        }
        return ret;
    }
	
	//讨论区-方法2
	public int[] countBits1(int num) {
		int[] ret = new int[num+1];
        for(int i=1;i<ret.length;i++){
        	ret[i] = ret[i&(i-1)]+1;  //i&(i-1)会去掉i的最后一个1位，所以要在后面加1
        }
        return ret;
	}
	
	//讨论区-方法3：按2的幂分开计算
	//0-7与8-15相对应，唯一的区别在于8-15首位都多一个1
	public int[] countBits2(int num) {
		int[] ret = new int[num+1];	
		int pow = 1, t = 0;
        for(int i=1;i<ret.length;i++,t++){
        	if(pow==i) {
        		pow *= 2;
        		t = 0;
        	}
        	ret[i] = ret[t]+1;
        }
        return ret;
	}
	
	//讨论区-方法4，与3原理相同   
	//result[index] = result[index - offset] + 1;
//	dp[1] = dp[1-1] + 1;
//	dp[2] = dp[2-2] + 1;
//	dp[3] = dp[3-2] +1;
//	dp[4] = dp[4-4] + 1;
//	dp[5] = dp[5-4] + 1;
//	dp[6] = dp[6-4] + 1;
//	dp[7] = dp[7-4] + 1;
//	dp[8] = dp[8-8] + 1;
	public int[] countBits3(int num) {
		int result[] = new int[num + 1];
	    int offset = 1;
	    for (int index = 1; index < num + 1; ++index){
	        if (offset * 2 == index){
	            offset *= 2;
	        }
	        result[index] = result[index - offset] + 1;
	    }
	    return result;
	}
}
