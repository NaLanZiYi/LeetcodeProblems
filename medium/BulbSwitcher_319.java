package medium;

public class BulbSwitcher_319 {
	 //求出每个数的公因数个数-----毫无疑问超时
	 public int bulbSwitch(int n) {
	     if(n<=0) return 0;
	     int[] count = new int[n];
	     for(int i=1;i<=n;i++){
	    	 for(int j=1;j<=i/2;j++){
	    		 if(i%j==0)count[i-1]++;
	    	 }
	     }
	     int num = 0;
	     for(int count1 : count){
	    	 if(count1%2==0) num++;
	     }
	     return num;
	 }
	 
	 //讨论区-方法1
	 //灯泡会在奇数次变化后 处在开的状态，而每个灯泡变化的次数就是其所有公约数的个数
	 //一般的数的公约数都是成对存在的，因而经过偶数次变化仍处在关的状态，除了平方数
	 //所以问题就变成了求出n个数中的平方数的个数，squt(n)是几即表示 出现了几个平方数
	 public int bulbSwitch1(int n) {
		 return (int)Math.sqrt(n);
	 }
}
