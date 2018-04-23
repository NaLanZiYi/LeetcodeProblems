package simple;
import java.util.ArrayList;
import java.util.List;

/**
 * 瀵绘壘4鐨勫箓
 * 4鐨勫箓鏈夊涓嬬壒寰侊細
 * 鈶犲ぇ浜?0
 * 鈶″叾浜岃繘鍒跺舰寮忓彧鏈変竴浣嶆槸1骞朵笖璇ヤ綅鍦ㄥ鏁颁綅
 * @author Dian
 *
 */
public class PowerOfFour_342 {
	//鏂规硶1锛氫緷娆″皢鏁存暟鑼冨洿鍐呮墍鏈?4鐨勫箓娣诲姞杩涙潵锛岀劧鍚庡垽鏂槸鍚﹀瓨鍦ㄥ嵆鍙?
	public boolean isPowerOfFour(int num) {
        List<Integer> numlist=new ArrayList<>();
        int maxint=(int) (Math.pow(2, 32))-1; //2147483646
        for(int i=1;i<num;i*=4){
        	numlist.add(i);
        }
        return numlist.contains(num);
        
        //绠?鍖栫増
//        int i=1;
//        for(;i<=num;i*=4){
//        	if(i==num) break;
//        }
//        return i==num;
    }
	
	//鏂规硶2锛?4鐨勫箓鏄簩杩涘埗绗?2,4,6.銆傘?傘?傘??30浣嶄笂鏄?1鐨勬暟锛屼笖鍙湁涓?涓?1浣?
	public boolean isPowerOfFour1(int num) {
		if(num<1) return false;
		if(Integer.bitCount(num)>1) return false;
		int tag=0;
		while((num&1)!=1){
			tag++;
			num=num>>>1;
		}
		return tag%2==0?true:false;
	}
	
	//璁ㄨ鍖?-鏂规硶3锛氳浆鍖栨垚4杩涘埗锛岄偅涔堝彲浠ヨ4鏁撮櫎鐨勬暟灏辩被浼?10,100,1000....
	public boolean isPowerOfFour2(int num){
		return Integer.toString(num, 4).matches("10*");
	}
	
	//璁ㄨ鍖?-鏂规硶4锛氬埄鐢?4鐨勫箓浜岃繘鍒跺彧鏈夊鏁颁綅鏈?1
	public boolean isPowerOfFour3(int num){
		//num&(num-1)淇濊瘉浜嗕簩杩涘埗鍙湁1浣嶆槸1
		return num>0&&(num&(num-1))==0&&(num&0x55555555)!=0;
		
		//姝ゆ柟娉曠殑鍙樺舰锛屽埄鐢?4^-1鍙互琚?3鏁撮櫎
		//璇佹槑:4^0+4^1+...+4^(n-1)=(4^n-1)/3=鏁存暟
		//num>0&&(num&(num-1))==0&&(num-1)%3==0;
	}
	
	//璁ㄨ鍖?-鏂规硶5锛氬埄鐢╨og鍑芥暟锛屾垨鑰呭紑鏂?
	public boolean isPowerOfFour4(int num){
		//寮?鏂规硶锛氭?濊矾锛屽厛鎵惧嚭浜岃繘鍒跺彧鏈変竴浣?1锛堝嵆2鐨勫箓锛夛紝鍐嶆壘鍑洪噷闈㈣兘澶熷紑鏂圭殑鏁?
		if(num<1) return false;
        int root = (int)Math.sqrt(num);
        return (root&(root-1))==0 && root*root==num;
        
        //log鍑芥暟娉曟?濊矾锛?4鐨勫箓闄や互log4鎵嶈兘寰楀埌鏁存暟
//        if (num <= 0) {
//    		return false;
//    	}
//    	if (num == 1) {
//    		return true;
//    	}
//    	double result = Math.log((double)num)/Math.log(4);
//    	return result == Math.floor(result);
	}
	
	public static void main(String[] args){
		int x=0x55555555;
		System.out.println(x+" : "+Integer.toBinaryString(x));
		System.out.println((int)(Math.pow(2, 32))-1);
	}
}
