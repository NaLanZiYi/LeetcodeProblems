package simple;
import java.util.HashMap;
import java.util.Map;


public class Roman2Int_13 {
	//缃楅┈鏁板瓧杞崲鎴愭暣鏁?
	//璁ㄨ鍖猴細閫嗗簭閬嶅巻瀛楃涓诧紝娉ㄦ剰纰板埌I銆乆銆丆(鍗矷V,IX,XL,XC,CD,CM)闇?瑕佸垽瀹氭槸鍚﹁鍋氬噺娉?
	public int romanToInt(String s) {
		char ch;
		char[] str=s.toCharArray();
		int sum=0;
        for(int i=str.length-1;i>=0;i--){
        	ch=str[i];
        	switch(ch){
        	case 'I': 
        		sum+=(sum>=5?-1:1);
        		break;
        	case 'V': 
        		sum+=5;
        		break;
        	case 'X': 
        		sum+=10*(sum>=50?-1:1);
        		break;
        	case 'L': 
        		sum+=50;
        		break;
        	case 'C': 
        		sum+=100*(sum>=500?-1:1);
        		break;
        	case 'D': 
        		sum+=500;
        		break;
        	case 'M': 
        		sum+=1000;
        		break;
        	}
        }
        return sum;
    }
	
	//璁ㄨ鍖猴細濡傛灉宸﹁竟鐨勬暟姣斿彸杈圭殑鏁板皬锛屽噺锛屽惁鍒欏姞锛屽洜涓哄彧鏈夊噺娉曠殑鏃跺?欏皬鏁版墠浼氬嚭鐜板湪澶ф暟鐨勫乏杈?
	public int romanToInt1(String s) {
		
		
		
		//鈶?
		int[] mapping=new int[s.length()];
		int i=0;
		for(char ch:s.toCharArray()){
			switch(ch){
        	case 'I': 
        		mapping[i++]=1;
        		break;
        	case 'V': 
        		mapping[i++]=5;;
        		break;
        	case 'X': 
        		mapping[i++]=10;
        		break;
        	case 'L': 
        		mapping[i++]=50;
        		break;
        	case 'C': 
        		mapping[i++]=100;
        		break;
        	case 'D': 
        		mapping[i++]=500;
        		break;
        	case 'M': 
        		mapping[i++]=1000;
        		break;
        	}
		}
		int sum=mapping[mapping.length-1];
		for(int j=mapping.length-2;j>=0;j--){
			if(mapping[j]<mapping[j+1]){
				sum-=mapping[j];
			}else{
				sum+=mapping[j];
			}
		}
		return sum;
	}
	
	public int romanToInt2(String s){
		//鈶?
		Map<Character,Integer> mapping=new HashMap<Character, Integer>();
		mapping.put('I', 1);
		mapping.put('V', 5);
		mapping.put('X', 10);
		mapping.put('L', 50);
		mapping.put('C', 100);
		mapping.put('D', 500);
		mapping.put('M', 1000);
		char[] chars=s.toCharArray();
		int sum=mapping.get(chars[chars.length-1]);
		int temp1,temp2;
		for(int i=chars.length-2;i>=0;i--){
			temp1=mapping.get(chars[i]);
			temp2=mapping.get(chars[i+1]);
			if(temp1<temp2) {
				sum-=temp1;
			}else{
				sum+=temp1;
			}
		}
		//濡傛灉浠庝笅鏍囦负0寮?濮嬮亶鍘嗭細鍒╃敤浜嗗彧鏈変竴涓皬鏁板瓧鑳藉鍑虹幇鍦ㄥぇ鏁板瓧涔嬪墠锛屾墍浠ラ渶瑕佸噺2鍊嶅皬鏁板瓧
//		int sum1=mapping.get(chars[0]);
//		//temp1=sum1;
//		for(int i=1;i<chars.length-1;i++){
//			temp1=mapping.get(chars[i-1]);
//			temp2=mapping.get(chars[i]);
//			if(temp1>=temp2) {
//				sum+=temp2;
//			}else{
//				sum+=temp2-2*temp1;   //***娉ㄦ剰杩欓噷***
//			}
//			//temp1=temp2;
//		}
		return sum;
	}	
	
}
