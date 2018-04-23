package simple;
/**
 * 灏唀xcel琛ㄦ牸鏍囬杞崲鎴愬垪瀵瑰簲鐨勬暟瀛?
 * @author Dian
 *
 */
public class SheetColumns_171 {
	//灏咥-Z瑙嗕负26杩涘埗锛屼笉鍚屼箣澶勫湪浜庢病鏈?0杩欎釜鏁板瓧
	public int titleToNumber(String s) {
		//1.杞崲鎴愬瓧绗︽暟缁?
//	    char[] chars = s.toCharArray();
//	    int length=chars.length;
//	    int sum=0,i=0;
//	    for(char c:chars){
//	    	sum+=((int)c-64)*Math.pow(26, length-i-1);
//	    	i++;
//	    }
		
		//2.浣跨敤charAt
		int length=s.length();
		int sum=0;
		for(int i=0;i<length;i++){
			sum+=((int)s.charAt(i)-64)*Math.pow(26, length-i-1);
		}
	    return sum;
	}
	
	public int titleToNumber1(String s) {
		//3.鐩存帴浣跨敤瀛楃鐩稿噺
		int length=s.length();
		int sum=0;
		for(int i=0;i<length;i++){
			sum+=(s.charAt(i)-'A'+1)*Math.pow(26, length-i-1);
		}
	    return sum;
	}
	
	//4.璁ㄨ鍖?-绫讳技浜庤凯浠?
	public int titleToNumber2(String s) {
		int sum=0;
		for(int i=0;i<s.length();i++){
			sum=26*sum+s.charAt(i)-'A'+1;
		}
		return sum;
		//杩唬--return s!=null?s.charAt(s.length()-1)-'A'+1+26*titleToNumber2(s.substr(0.s.length()-1)):0;
	}
	
}
