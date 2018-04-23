package simple;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FirstUniqueChar_387 {
	 //姝ゆ柟娉曡秴鏃?
	 public int firstUniqChar(String s) {
		if(s==null) return -1;
		if(s.length()==1) return 0;
		char ch;
		int length=s.length();
	    for(int i=0;i<length;i++){	    	
	    	ch=s.charAt(i);
	    	if(!s.substring(i+1).contains(ch+"")&&!s.substring(0,i).contains(ch+""))
	    	return i;
	    }
	    return -1;
	 }
	 
	 public int firstUniqChar1(String s) {
		 //鎬濇兂锛氬畾涔変竴涓暟缁勮褰曟瘡涓瓧姣嶅嚭鐜扮殑娆℃暟锛屽啀閬嶅巻鍘熸暟缁勶紝鎵惧嚭绗竴涓鏁颁负0鐨勫瓧姣?
		 //杞崲鎴愭暟缁勭殑鏁堢巼杩滈珮浜庣洿鎺ラ亶鍘嗗瓧绗︿覆
		 if(s==null) return -1;
		 char[] chs=s.toCharArray();
		 int[] chars=new int[26];
		 for(int i=0;i<chs.length;i++){
			 chars[chs[i]-'a']++;
		 }
		 
		 for(int j=0;j<chs.length;j++){
			 if(chars[chs[j]-'a']==1) return j;
		 }
		 return -1;
	 }
	 
	 //鏂规硶2锛氭壘鍑虹涓?娆″嚭鐜扮殑浣嶇疆鍜屾渶鍚庝竴娆″嚭鐜扮殑浣嶇疆鐩稿悓鐨勫厓绱犲嵆鍙?
	 public int firstUniqChar2(String s) {
		 char[] chars=s.toCharArray();
		 for(int i=0;i<chars.length;i++){
			 if(s.indexOf(chars[i])==s.lastIndexOf(chars[i]))
				 return i;
		 }
		 return -1;
	 }
}
