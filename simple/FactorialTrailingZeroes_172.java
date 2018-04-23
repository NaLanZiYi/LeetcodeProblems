package simple;
//姹傞樁灞傚悗闈?0鐨勪釜鏁?
public class FactorialTrailingZeroes_172 {
	//杩欑鏂瑰紡寰堝鏄撻?犳垚婧㈠嚭
	public int trailingZeroes(int n) {
        int product = 1;
        while(n!=1){
        	product*=n;
        	n--;
        }
        int count = 0;
        while(product%10==0){
        	product/=10;
        	count++;
        }
        return count;
    }
	
	public int trailingZeroes1(int n) {
		int count = 0;
		n=n-n%5;
		while(n>4){
			int temp = n;
			while(temp%5==0){
				temp/=5;
				count++;
			}
			n-=5;
		}
		return count;
	}
	
	//璁ㄨ鍖?-1:5鐨勫?嶆暟鎻愪緵1涓?0,25鐨勫?嶆暟鎻愪緵2涓?...
	//return n/5 + n/25 + n/125 + n/625 + n/3125+...;
	public int trailingZeroes2(int n) {
		int count = 0;
		while(n>=5){
			//鍙互浣跨敤temp缂撳瓨n/5鐨勬搷浣滐紝閬垮厤璁＄畻涓ゆ
			//int temp = n/5;
			count+=n/5;
			n/=5;
			//n=temp;
			
			//濡備笅鏂瑰紡鏇村ソ
			//n/=5;
			//count+=n;
		}
		return count;
	}
	
	//璁ㄨ鍖?-2锛氳凯浠?
	public int trainlingZeroes3(int n){
		if(n==0) return 0;
		return n/5+trainlingZeroes3(n/5);
	}
	
	
	public static void main(String[] args){
		FactorialTrailingZeroes_172 test = new FactorialTrailingZeroes_172();
		System.out.println(test.trailingZeroes(13));
		System.out.println((int)Math.pow(2, 32)-1);
	}
}
