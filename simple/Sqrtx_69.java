package simple;

public class Sqrtx_69 {
	
	//计算x平方根的整数部分
	public int mySqrt(int x) {
        if(x == 0) return 0;
        
        int left = 1, right = x, mid = 1;
        while(left <= right){
        	mid = left + (right - left)/2;
        	if(mid > x/mid)
        		right = mid - 1;
        	else{
        		if(mid + 1 > x/(mid + 1)) return mid;
        		left = mid + 1;
        	}
        }
        return mid;
    }
	
	public int mySqrt1(int x) {
        if(x == 0) return 0;
        
        int left = 1, right = x, mid = 1;
        while(left <= right){
        	mid = left + (right - left)/2;
        	if(mid == x/mid)
        		return mid;
        	else if(mid > x/mid) right = mid - 1;
        	else left = mid + 1;
        }
        return right;
    }
	
	public static void main(String[] args) {
		Sqrtx_69 test = new Sqrtx_69();
		System.out.println(test.mySqrt(4));
	}
}
