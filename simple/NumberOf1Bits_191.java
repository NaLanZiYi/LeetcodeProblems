package simple;

public class NumberOf1Bits_191 {
	//缁熻浜岃繘鍒朵腑鐨?1鐨勪釜鏁? 
	public int hammingWeight(int n) {
	     int sum=0;
	     while(n!=0){
	    	 sum+=n&1;
	    	 n=n>>>1;
	     }
	     return sum;
	 }
	
	//浣跨敤Java鑷甫鐨勫嚱鏁?
	public int hammingWeight1(int n) {
		return Integer.bitCount(n);
	}
	
	//璁ㄨ鍖猴細浣跨敤n&(n-1)
	//each time will turn right most 1 into 0, until all 1s becomes 0, 
	//then we just need to count how many times we turn
	public int hamminWeight2(int n){
		int count=0;
		while(n!=0){
			n=n&(n-1);
			count++;
		}
		//鎴栬?呴?掑綊 return n==0:0?1+hamminWeight2(n&(n-1));
		return count;
	}
}
