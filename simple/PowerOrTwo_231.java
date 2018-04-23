package simple;
//鍒ゆ柇鏄惁鏄?2鐨勫箓
public class PowerOrTwo_231 {
	public boolean isPowerOfTwo(int n) {
		return n>0 && (int)Math.pow(2, 31)%n==0;
	}
	
	//浣嶈繍绠?:濡傛灉鑳借2鏁撮櫎锛岄偅涔堜簩杩涘埗鏁板彧鏈変竴浣嶆槸1锛屽垰濂戒笌姣旇嚜宸卞皬1鐨勬暟浣嶄笌寰?0
	public boolean isPowerOfTwo1(int n) {
		return n>0&&(n&n-1)==0;
	}
	
	//璁ㄨ鍖烘柟娉?1锛氳绠椾簩杩涘埗涓殑1鐨勪釜鏁?
	public boolean isPowerOfTwo2(int n) {
		return n>0&&Integer.bitCount(n)==1;
		
		//鎴栬?呰В娉曗憽
//		if(n<=0) return false;
//		int count=0;
//		while(n!=0){
//			count+=n&1;
//			n=n>>>1;
//		}
//		return count==1;
	}
	
	//璁ㄨ鍖烘柟娉?2锛氫綅杩愮畻鐨勫彉褰?
	public boolean isPowerOfTwo3(int n) {
//		return n>0&&n==(n&-n);
		return n>0&&n==(n&(~n+1));
	}
	
	//寰幆
	public boolean isPowerOfTwo4(int n) {
		if(n<=0) return false;
		while(n%2==0) n/=2;
		return n==1;
	}
	
	//杩唬
	public boolean isPowerOfTwo5(int n) {
		return n>0&&((n==1)||(n%2==0)&&isPowerOfTwo5(n/2));
	}
}
