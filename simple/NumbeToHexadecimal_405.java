package simple;
/*
 * 杩涘埗杞崲
 */
public class NumbeToHexadecimal_405 {
	//10->16:闄?16鍙嶅悜鍙栦綑
	public String toHex(int num) {
		StringBuilder str=new StringBuilder();
		char[] chars=new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		if(num>=0){
			 while(num/16>0){
		        	str.append(chars[num%16]);
		        	num=num/16;
		        }
		        str.append(chars[num]);
		}else{
			//璐熸暟鍏堣浆鎹㈡垚浜岃繘鍒惰ˉ鐮侊紝鍐嶇洿鎺ヨ浆鎴?16杩涘埗
			String bitStr = Integer.toBinaryString(num);
			int len=bitStr.length();
			int sum=0;
			for(int i=len-1;i>=0;){
				sum=0;
				for(int j=0;j<4;j++){
					sum+=(bitStr.charAt(i--)-48)*(int)Math.pow(2, j);
				}
				str.append(chars[sum]);
			}
		}
       
        return str.reverse().toString();
    }
	
	//璁ㄨ鍖虹瓟妗堚憼锛氫綅杩愮畻鐒跺悗鍙崇Щ鍥涗綅锛岀浉褰撲簬姣忔璁＄畻鏈?鍚庡洓浣嶏紝鐩存帴杞垚16杩涘埗
	public String toHex1(int num) {
		StringBuilder str=new StringBuilder();
		char[] chars=new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		while(num!=0){
			str.append(chars[num & 0xf]);//or num & 15
			num=(num>>>4);
		}
		return str.reverse().toString();
	}
	
	//鏂规硶2锛氭?濇兂鍚屼笂锛屽彧鏄疄鐜颁笂绋嶆湁鍖哄埆
	public String toHex2(int num) {
		String str="";
		int n=0;
		while(num!=0){
			n=num & 15;
			n+=n>9?'a'-10:'0';
			str=(char)n+str;
			num=num>>>4;
		}
		return str;
	}
	
	public static void main(String[] args){
		System.out.println(Integer.toBinaryString(26));
		System.out.println(new NumbeToHexadecimal_405().toHex2(26));
	}
}
