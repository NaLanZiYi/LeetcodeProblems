package simple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//瀵绘壘瀛楃涓瞫涓瓧绗︿覆p鐨勬墍鏈夐鍊掗『搴忔瀯鎴愮殑瀛楃鐨勮捣濮嬩綅缃?
public class FindAllAnagramsInString_438 {
	
	 public List<Integer> findAnagrams(String s, String p) {
	        List<Integer> ret = new ArrayList();
	        char[] schars = s.toCharArray();
	        int[] charCount = new int[26];
	        int plen = p.length();
	        int slen = s.length();
	        if(s==null||p==null||slen<plen)
	        	return ret;
	        //鍏堝垵濮嬪寲寮?澶寸殑plen涓瓧绗?
	        for(char c : s.substring(0, plen).toCharArray()){
				 charCount[c-'a']++;
			 }
			 for(char c : p.toCharArray()){
				 charCount[c-'a']--;
			 }	
			 int flag = 0;
			 //鎬诲叡杩涜slen-plen+1娆￠亶鍘?
	        for(int i=0;i<=slen-plen;i++){
	        	flag = 0;
	        	//姣忓惊鐜竴娆★紝閮借鍒ゆ柇鏄惁鏄竴涓猘nagram搴忓垪
	        	 for(int j : charCount){
	        		 System.out.println(j);
	    			 if(j!=0){
	    				 flag = 1;
	    				 break;
	    			 }
	    		 }
	        	 if(flag==0) ret.add(i);
	        	 //涓嬪垪浠ｇ爜鐨勬?濇兂鏄細璁板綍charCount鐨勪腑闂寸粨鏋滐紝鍦ㄥ惊鐜粨鏉熸椂锛屽瓧绗︿覆s鍙崇Щ涓?浣嶏紝鍙渶瑕?
	        	 //灏嗗師鏉ョ殑绗竴浣嶅瓧绗︽暟鍑?1,鏂板瓧绗︽暟鍔犱竴鍗冲彲锛岄鐩畝鍖栦负鍒ゆ柇瀛楃鍑虹幇鐨勬鏁版槸鍚︿负0
	        	 if(i+plen<slen){
	        		 charCount[schars[i]-'a']--;
		        	 charCount[schars[i+plen]-'a']++; 
	        	 }	        	 
	        }
	        return ret;
	    }
	 
	 //璁ㄨ鍖?-鏂规硶2锛歄(n)澶嶆潅搴?
	 //姝ゆ柟娉曠殑宸у涔嬪鍦ㄤ簬锛氬彧闇?瑕佸垽鏂璫ount鏄惁涓?0灏卞彲浠ョ煡閬揳nagram鏄惁鍑虹幇
	 public List<Integer> findAnagrams1(String s, String p) {
		 int[] chs = new int[256];
		 List<Integer> ret = new ArrayList();
		 for(char c : p.toCharArray()){
			 chs[c]++;
		 }
		 int left = 0, right = 0, count = p.length();
		 while(right<s.length()){
			 //濡傛灉s鐨勫綋鍓嶄綅缃殑瀛楃鍦╬涓紝鍒欏皢count--锛宺ight鍚庣Щ
			 //缁撴灉鏄紝濡傛灉瀛楃涓嶅湪p涓紝鍒欏叾鏁扮粍缁撴灉涓?-1锛屽惁鍒欐暟缁勪腑鐨勫嚭鐜版鏁板噺1
			 if(chs[s.charAt(right++)]-->=1) count--;
			 //count=0鏃讹紝鎰忓懗鐫?鎵惧埌浜嗕竴涓猘nagram
			 if(count==0) ret.add(left);
			 //濡傛灉right-left杈惧埌p鐨勯暱搴︼紝鍒檒eft灏嗗彸绉伙紝浼氬墧闄eft瀵瑰簲鐨勫瓧绗︼紝闇?瑕佸垽鏂璴eft姝ゆ椂瀵瑰簲鐨勫瓧绗︽槸鍚﹀湪p涓嚭鐜帮紝鑻ュ嚭鐜板皢count+1
			 if(right-left==p.length()&&(chs[s.charAt(left++)]++>=0)) count++;
		 }
		 return ret;
	 }
	 
	 //鍒ゆ柇s鏄惁鏄痯鐨勫瓧姣嶉鍊掗『搴忔瀯鎴愮殑瀛楃
	 public boolean isAnagrams(String s, String p){
		 int[] charCount = new int[26];
		 for(char c : s.toCharArray()){
			 charCount[c-'a']++;
		 }
		 for(char c : p.toCharArray()){
			 charCount[c-'a']--;
		 }		
		 for(int i : charCount){
			 if(i!=0) return false;
		 }
		 return true;
	 }
	 
	 public static void main(String[] args){
		 FindAllAnagramsInString_438 test = new FindAllAnagramsInString_438();
		 test.findAnagrams("cbaebabacd", "abc");
		
	 }
}
