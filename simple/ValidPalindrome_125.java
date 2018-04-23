package simple;

public class ValidPalindrome_125 {
	 public boolean isPalindrome(String s) {
	    if(s==null) return false;
	    //只保留字母和数字
	    s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	    System.out.println(s);
	    StringBuilder builder = new StringBuilder(s);
	    return builder.toString().equals(builder.reverse().toString());
	 }
	 
	 public boolean isPalindrome1(String s) {
	    if(s==null) return false;
	    //只保留字母和数字
	    s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	    char[] cs = s.toCharArray();
	    for(int i=0,j=cs.length-1;i<j;i++,j--){
	    	if(cs[i]!=cs[j]) return false;
	    }
	    return true;
	}
	 
	 public boolean isPalindrome2(String s) {
		    if(s==null) return false;
		    //避免因为正则替换而花费的时间
		    char[] cs = s.toCharArray();
		    for(int i=0,j=cs.length-1;i<j;i++,j--){
		    	while(i<j&&!Character.isLetterOrDigit(cs[i])) i++;
		    	while(i<j&&!Character.isLetterOrDigit(cs[j])) j--;
		    	if(Character.toLowerCase(cs[i])!=Character.toLowerCase(cs[j])) return false;
		    }
		    return true;
		}
	 
	 
	 
	 public static void main(String[] args) {
		 ValidPalindrome_125 test = new ValidPalindrome_125();
		 System.out.println(test.isPalindrome("a."));
	 }
}
