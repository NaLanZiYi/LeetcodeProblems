package simple;

public class ReverseString_344 {
	//鏂规硶涓?
	public String reverseStr(String str){
		StringBuffer result=new StringBuffer();
		for(int i=str.length()-1;i>=0;--i){
			result.append(str.charAt(i));
		}
		return result.toString();
	}
	//鏂规硶浜?
	 public String reverseString(String s) {
	        return new StringBuilder(s).reverse().toString();
	    }
	 //鏂规硶涓?
	 public String reverseString1(String s) {
		 	StringBuffer buffer=new StringBuffer();
	        char[] strarr=s.toCharArray();
	        for(int i=strarr.length-1;i>=0;i--){
	        	buffer.append(strarr[i]);
	        }
	        return buffer.toString();
	    }
	
	public static void main(String[] args){
		String str="abcdefghigklmn";
		ReverseString_344 test = new ReverseString_344();
		long startTime=System.currentTimeMillis();
		String str1=test.reverseStr(str);
		long endTime1=System.currentTimeMillis();
		String str2=test.reverseString(str);
		long endTime2=System.currentTimeMillis();
		String str3=test.reverseString1(str);
		long endTime3=System.currentTimeMillis();
		System.out.println("鏂规硶涓?锛?"+str1+"-----"+(endTime1-startTime));
		System.out.println("鏂规硶浜岋細"+str2+"-----"+(endTime2-endTime1));
		System.out.println("鏂规硶涓夛細"+str3+"-----"+(endTime3-endTime2));
	}
}
