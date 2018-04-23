package simple;
//缈昏浆瀛楃涓蹭腑鐨勫厓闊?

public class ReverseVowelsOfString_345 {
	
	 public String reverseVowels(String s) {
	      if(s==null||s.length()<2) return s;
	      char[] sch = s.toCharArray();
	      String vowels = "aeiouAEIOU";
	      char ch;
	      for(int i=0,j=sch.length-1;i<j;){
	    	  if(vowels.indexOf(sch[i])!=-1&&vowels.indexOf(sch[j])!=-1){
	    		  ch=sch[i];
	    		  sch[i] = sch[j];
	    		  sch[j] = ch;
	    		  i++;
	    		  j--;
	    	  }else if(vowels.indexOf(sch[i])!=-1){
	    		  j--;
	    	  }else if(vowels.indexOf(sch[j])!=-1){
	    		  i++;
	    	  }else{
	    		  i++;
	    		  j--;
	    	  }
	      }
	      return new String(sch);
	 }
	 
	 //璁ㄨ鍖?-鏂规硶2锛氱壓鐗茬┖闂存崲鏃堕棿锛岀敱浜巌ndexOf鏂规硶鍦ㄥ瓧绗︿覆涓煡鎵炬晥鐜囧苟涓嶆瘮鏁扮粍绱㈠紩鏁堢巼楂橈紝閲囩敤鏁扮粍鏉ユ浛浠?
	 public String reverseVowels1(String s) {
		 if(s==null||s.length()<2) return s;
		 boolean[] arrs = new boolean[256];  //The ASCII table has 256 characters we should account for
		 arrs['a'] = true;
		 arrs['e'] = true;
		 arrs['i'] = true;
		 arrs['o'] = true;
		 arrs['u'] = true;
		 arrs['A'] = true;
		 arrs['E'] = true;
		 arrs['I'] = true;
		 arrs['O'] = true;
		 arrs['U'] = true;
		 
		 char[] sch = s.toCharArray(); 
		 int first = 0;
		 int last = sch.length-1;
		 char c;
		 while(first<last){
			 while(first<last&&!arrs[sch[first]]) first++;
			 while(first<last&&!arrs[sch[last]]) last++;
			 c=sch[first];
			 sch[first] = sch[last];
			 sch[last] = sch[first];
		 }
		 return new String(sch);
	 }
	 
	 public static void main(String[] args){
		 String s = "hello";
		 System.out.println(s.indexOf(s.charAt(3)));
		 System.out.println(new ReverseVowelsOfString_345().reverseVowels("hello"));
	 }
}
