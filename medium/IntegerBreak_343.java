package medium;

public class IntegerBreak_343 {
	//讨论区：证明分解后的因子为何是3和2
	//假设f>4，那么2*(f-2)=2*f-4>4，说明当f>4时，总是应该将其分解成更小的数
	//再根据6=3+3=2+2+2但是3*3>2*2*2，所以优先考虑3
	public int integerBreak(int n) {
		//基于如下事实：4=2+2，2*2=4，因而在4的时候没有必要继续分解，
		//5=2+3，2*3=6，6=3+3=2+2+2,但是3*3>2*2*2，
		//所以从5开始，所有的数都可以逐渐分成较小的数，而且优先分成3，当分到最后等于2、3、4时就停止
        if(n<4) return n-1;
        int product = 1;
        while(n>2){
        	if(n==4||n==3||n==2) break;
        	if(n>3){
        		product *= 3;
        		n -= 3;
        	}
        }
        
        //上述语句等于下面4行
//        while(n>4){
//        	product *= 3;
//        	n -= 3;
//        }
        product *= n;
        return product;
    }
	
	//讨论区-方法1:思想差不多，这里对分解的结果进行了三种情况的讨论：无2，1个2，2个2
	public int integerBreak1(int n) {
		if(n<4) return n-1;
		if(n%3==0) return (int)Math.pow(3, n/3);
		if(n%3==1) return 4*(int)Math.pow(3, (n-4)/3);
		return 2*(int)Math.pow(3, (n-2)/3);
	}
	
	//讨论区-方法2：DP动态规划
//	(1) i is the sum of two numbers, i.e. S=i-j is one number, and so maxArr[i]=j*(i-j)
//  (2) i is the sum of at least three numbers, i.e. S=i-j is a sum of at least 2 numbers,
	public int integerBreak2(int n) {
		int[] dp = new int[n+1];
		dp[1] = dp [2] = 1;
		for(int i=3;i<n;i++){
			for(int j=1;j<i;j++){
			//for(int j=1;2*j<i;j++)   // 可以如此加速
				//dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
				dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*(dp[i-j])));
			}
		}
		return dp[n];
	}
	
	//讨论区-方法3，DP的变体
	int integerBreak3(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        for (int i = 5; i <= n; ++i) {
            dp[i] = 3 * Math.max(i - 3, dp[i - 3]);
        }
        return dp[n];
    }
}
