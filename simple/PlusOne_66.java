package simple;
import java.util.Arrays;

public class PlusOne_66 {
	
	public int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0) return new int[]{1};
        int len = digits.length;
        int flag = 1;  //杩涗綅鏍囪锛屽洜涓鸿鍔犱笂1锛屾墍浠ュ垵濮嬩负1
        if(digits[len-1]<9){  //濡傛灉涓綅灏忎簬9锛岀洿鎺ヤ釜浣嶅姞1杩斿洖
        	digits[len-1]++;
        	return digits;
        }else{        	
        	for(int i=len-1;i>=0;i--){
        		if(digits[i]+flag>9){
        			digits[i] = 0;
        			flag = 1;
        		}else{
        			//浠ヤ笅涓ゅ彞鐨勯『搴忎笉鍙崲
        			digits[i] +=flag;
        			flag = 0;
        		}
        	}
        }
        if(flag==1){  //璇存槑鎵?鏈変綅閮戒负9
        	int[] ret = new int[len+1];
        	ret[0] = 1;
        	return ret;
        }
        return digits;
    }
	
	public static void main(String[] args){
		int[] i = {9,9,8,9,9,1};
		PlusOne_66 test = new PlusOne_66();
		int[] j = test.plusOne(i);
		System.out.println(Arrays.toString(j));
	}
	
	//璁ㄨ鍖?-鏂规硶2锛氭敼杩?
	public int[] plusOne1(int[] digits) {
		int len = digits.length;
		//寰幆鑳藉涓嶆柇缁х画锛岃鏄庨亣鍒颁簡9浜х敓杩涗綅锛屾墍浠ョ洿鎺ュ湪瀵瑰簲浣嶄笂鍔?1
		//鍙鏈変竴浣嶄笉涓?9锛屽湪寰幆涓細鐩存帴杩斿洖
		for(int i=len-1;i>=0;i--){
			if(digits[i]<9){
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		//澶勭悊鎵?鏈変綅閮芥槸9鐨勬儏鍐?
		int[] ret = new int[len+1];
		ret[0] = 1;
		return ret;
	}
}
