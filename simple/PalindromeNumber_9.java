package simple;
//鍒ゆ柇鏄惁鏄洖鏂囨暟瀛?
public class PalindromeNumber_9 {
	public boolean isPalindrome(int x) {
		if(x<0) return false;
        String str = x+"";
        String temp = new StringBuilder(str).reverse().toString();
        if(str.equals(temp)){
        	return true;
        }
        return false;
    }
	
	public boolean isPalindrome1(int x) {
		try{
			int rev = 0, temp = x;
			while(x>0){
				rev = rev*10+(x%10);
				x/=10;
			}
			if(temp==rev)	return true;
		}catch(Exception e){
			return false;
		}
		return false;
	}
	
	public static void main(String[] args){
		PalindromeNumber_9 test = new PalindromeNumber_9();
		System.out.println(test.isPalindrome1(1));
	}
}
