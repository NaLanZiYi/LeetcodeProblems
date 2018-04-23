package simple;

public class ImplementStrStr_28 {
	//讨论区-方法1
	 public int strStr(String haystack, String needle) {
	     for(int i=0;;i++){
	    	 for(int j=0;;j++){
	    		 if(j==needle.length()) return i;
	    		 if(i+j==haystack.length()) return -1;
	    		 if(haystack.charAt(i+j)!=needle.charAt(j)) break;
	    	 }
	     }
	 }
	 
	 //讨论区-方法2：Brute-Force算法（暴力算法）
	 public int strStr1(String haystack, String needle) {
		 int i = 0, j = 0;
		 while(i+j<haystack.length()&&j<needle.length()){
			 if(needle.charAt(j)==haystack.charAt(i+j)){
				 ++j;
			 }else{
				 ++i;
				 j = 0;
			 }			
		 }
		 if(j==needle.length()) return i;
		 else return -1;
	 }
}
