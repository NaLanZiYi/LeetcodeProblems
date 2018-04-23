package simple;
//璁＄畻涓や釜鐢ㄥ瓧绗︿覆琛ㄧず鐨勬暟瀛楃殑鍜?
public class AddStrings_415 {
	//鎬濊矾锛氫粠鏈?鍚庝竴浣嶅紑濮嬭绠楁瘡涓?浣嶇殑鍜岋紝璁板綍杩涗綅鎯呭喌
	public String addStrings(String num1, String num2) {
		int len1=num1.length();
        int len2=num2.length();
        int minlen=len1>len2?len2:len1;
        int temp=0,carry=0;
        StringBuilder sum=new StringBuilder();
        for(int i=0;i<minlen;i++){
        	if(carry>0)
        		temp=num1.charAt(len1-i-1)-'0'+num2.charAt(len2-i-1)-'0'+1;
        	else 
        		temp=num1.charAt(len1-i-1)-'0'+num2.charAt(len2-i-1)-'0';
        	carry=(temp>9)?1:0;
        	sum.append(temp%10);
        }
        if(len1>len2){
        	for(int i=len1-minlen-1;i>=0;i--){
        		if(carry>0)
            		temp=num1.charAt(i)-'0'+1;
            	else 
            		temp=num1.charAt(i)-'0';
            	carry=(temp>9)?1:0;
            	sum.append(temp%10);
        	}
        }else{
        	for(int i=len2-minlen-1;i>=0;i--){
        		if(carry>0)
            		temp=num2.charAt(i)-'0'+1;
            	else 
            		temp=num2.charAt(i)-'0';
            	carry=(temp>9)?1:0;
            	sum.append(temp%10);
        	}
        }
        if(carry>0) sum.append(1); //娉ㄦ剰鏈?楂樹綅鍦ㄩ渶瑕佺殑鏃跺?欒ˉ1
        return sum.reverse().toString();
    }
	
}
