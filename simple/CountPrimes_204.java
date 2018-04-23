package simple;
import java.util.BitSet;

public class CountPrimes_204 {
	public int countPrimes(int n) {
		if(n<=2) return 0;
		if(n<=4) return n-2;
		int count = 0, i = 0;
		for(int j=4;j<n;j++){
			 for(i=2;i<=Math.round(Math.sqrt(j));i++){
	        	if(j%i==0) break;
		     }
			 if(i==Math.round(Math.sqrt(j))+1) ++count;
		}
       return count+2;
    }
	
	//讨论区-方法1：
	public int countPrimes1(int n) {
		boolean[] notPrimes = new boolean[n];
		int count = 0;
		for(int i=2;i<n;i++){
			if(notPrimes[i]==false){
				count++;
				for(int j=2;i*j<n;j++){
					if(i>Math.sqrt(n)) break;
					notPrimes[i*j] = true;
				}
			}
		}
		return count;
	}
	
	//讨论区-方法2：Sieve of Eratosthenes算法
	public int countPrimes2(int n) {
		if(n<=2) return 0;
		boolean[] notPrimes = new boolean[n];
		notPrimes[0] = notPrimes[1] = true;
		for(int i=2;i<Math.sqrt(n);i++){
			//从2开始，去掉i的整数倍，余下的就是质数
			for(int j=i*i;j<n;j+=i){
				notPrimes[j] = true;
			}
		}
		int count = 0;
		for(int j=2;j<n;j++){
			if(!notPrimes[j]) ++count;
		}
		return count;
	}
	
	//讨论区-方法3：2的不同版本
	public int countPrimes3(int n) {
		if(n<=2) return 0;
		int sum = 0;
		boolean[] notPrimes = new boolean[n];
		notPrimes[0] = notPrimes[1] = true;
		for(int i=2;i<n;i++){
			if(!notPrimes[i]) ++sum;
			if(i>Math.sqrt(n)) continue;
			for(int j=i*i;j<n;j+=i){
				notPrimes[j] = true;
			}
		}
		return sum;
	}
	
	//讨论区-方法4：Sieve of Eratosthenes算法的改进
	public int countPrimes4(int n) {
		if(n<=2) return 0;
		boolean[] notPrimes = new boolean[n];
		//从3开始的偶数都是非质数，可以直接跳过，注意此时i*i<n不能加=号，因为在n刚好为平方数时会造成数组溢出
		//这里不需要考虑在n<10循环不执行的问题，因为在9之前的奇数除了1都是质数
		for(int i=3;i*i<n;i+=2){
			if(notPrimes[i]) continue;
			//由于i是奇数，i*i也是奇数，后续只用遍历奇数即可，因而j=j+2*i
			for(int j=i*i;j<n;j+=2*i){
				notPrimes[j] = true;
			}
		}
		int count = 0;
		for(int j=3;j<n;j+=2){
			if(!notPrimes[j]) ++count;
		}
		//+1是为了加上漏掉的质数2
		return count+1;
	}
	
	//讨论区-方法5：方法2的改进，节省空间占用
	//由于一个布尔值占1个字节8位，n个数字总共至少占用8*n位
	//使用BitSet，可以使空间占用降低到n位
	public int countPrimes5(int n) {
	    BitSet bs = new BitSet(n);
	    bs.set(0); bs.set(1);
	    int ind = 0, count = 0;
	    while(ind < n){
	    	//取出下标在ind+1或其后第一个设置为false的元素的下标
	        ind = bs.nextClearBit(ind + 1);
	        if(ind >= n)
	            return count;
	        count++;
	        for(int i = 2 * ind; i < n; i += ind)
	            bs.set(i);
	    }
	    return count;
	}
	
	//讨论区-方法6：还没看懂
	public int countPrimes6(int n) {
	    if(--n < 2) return 0;
	    int m = (n + 1)/2, count = m, k, u = (int) ((Math.sqrt(n) - 1)/2);
	    boolean[] notPrime = new boolean[m];
	    
	    for(int i = 1; i <= u;i++)
	        if(!notPrime[i])
	          for(k = (i+ 1)*2*i; k < m;k += i*2 + 1)
	              if (!notPrime[k])
	              {
	                  notPrime[k] = true;
	                  count--;
	              }
	    return count;
	}
	
	public static void main(String[] args) {
		CountPrimes_204 test = new CountPrimes_204();
		System.out.println(test.countPrimes(6));
	}
	
	
}
