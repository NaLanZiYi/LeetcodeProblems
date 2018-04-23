package simple;

public class RotateFunction_396 {
	//时间复杂度O(n^2)
	public int maxRotateFunction(int[] A) {
        if(A==null||A.length<=1) return 0;
        int max = A[0];  //记录返回值
        int fx = 0;  //f(x)函数值
        int count = 0;  //从0-A.length-1的值
        //外层循环记录A.length-1个fx，内层循环记录每个fx的计算过程
        for(int i=0;i<A.length;i++){
        	//重置
        	count = 0;
        	fx = 0;
        	//顺时针旋转k，相当于从A.length-k处开始遍历，k=0时不执行
        	for(int j=A.length-i;j<A.length;j++){
        		fx += count++*A[j];
        	}
        	//从头遍历
        	for(int j=0;j<A.length-i;j++){
        		fx +=count++*A[j];
        	}
        	if(i==0) max = fx;  //首次循环需要将max设置为第一个fx；
        	if(fx>max) max = fx;
        }
        return max;
    }
	
	//讨论区-方法1：由f0推到fx
	//核心思想：由于会循环每一次旋转的结果，所有顺时针和逆时针旋转都一样，按逆时针旋转来算
	//先计算f0和数组各元素之和sum,f1等于f0-sum+被该轮被移到数组末尾的元素乘以数组长度
//	Consider we have 5 coins A,B,C,D,E
//	According to the problem statement
//	F(0) = (0A) + (1B) + (2C) + (3D) + (4E)
//	F(1) = (4A) + (0B) + (1C) + (2D) + (3E)
//	F(2) = (3A) + (4B) + (0C) + (1D) + (2*E)
	public int maxRotateFunction1(int[] A) {
		int len = A.length, f0 = 0, sum = 0;
		//计算f0和数组元素和sum
		for(int i=0;i<len;i++){
			sum += A[i];
			f0 += i*A[i];
		}
		int max = f0;
		//由f0依次推导f1,f2....
		for(int j=1;j<len;j++){
			f0 = f0-sum+A[j-1]*len;
			max = Math.max(max, f0);
		}
		return max;
	}
	
	//讨论区-方法2：顺时针旋转
//	F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]
//	F(k-1) = 0 * Bk-1[0] + 1 * Bk-1[1] + ... + (n-1) * Bk-1[n-1]
//	       = 0 * Bk[1] + 1 * Bk[2] + ... + (n-2) * Bk[n-1] + (n-1) * Bk[0]
//	Then,
//	F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] + (1-n)Bk[0]
//	              = (Bk[0] + ... + Bk[n-1]) - nBk[0]
//	              = sum - nBk[0]
	public int maxRotateFunction2(int[] A) {
		int allSum = 0;
		int len = A.length;
		int F = 0;
		for (int i = 0; i < len; i++) {
		    F += i * A[i];
		    allSum += A[i];
		}
		int max = F;
		for (int i = len - 1; i >= 1; i--) {
		    F = F + allSum - len * A[i];
		    max = Math.max(F, max);
		}
		return max;  
	}
}
