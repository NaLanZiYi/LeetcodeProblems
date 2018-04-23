package simple;
/*
 * Given a non-negative integer num, repeatedly add all its 
 * digits until the result has only one digit.
 */
public class AddDigits_258 {
	 public int addDigits(int num) {
	    int sum=0;
	    if(num>=0&num<10){
	    	return num;
	    }else{
	    	String str=num+"";
	    	for(int i=0;i<str.length();i++){
	    		sum+=Integer.parseInt(str.substring(i,i+1));
	    		if(i!=str.length()-1){
	    			System.out.print(str.substring(i,i+1)+" + ");
	    		}else{
	    			System.out.print(str.substring(i,i+1)+" = "+sum+" ; ");
	    		}
	    		
	    	}
	    	return addDigits(sum);
	    }
	 }
	 
	 public static void main(String[] args){
		 AddDigits_258 test=new AddDigits_258();
		 System.out.println(test.addDigits(258));
	 }
}
