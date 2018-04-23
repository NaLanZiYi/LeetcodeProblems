package simple;
import java.util.ArrayList;
import java.util.List;


public class BinaryWatch_401 {
	//鍩烘湰鎬濇兂锛氳涓?10浣嶄簩杩涘埗鏁帮紝姣忎釜浣?1琛ㄧず璇ョ伅浜紝鍓嶅洓浣嶈〃绀烘椂閽堬紝鍚?6浣嶈〃绀虹閽?
	//閭ｄ箞璇ラ鍙互瑙嗕负鎵惧嚭鍏朵腑1鐨勪釜鏁扮瓑浜庣粰瀹歯um鐨勯棶棰?
	public List<String> readBinaryWatch(int num) {
		
        List<String> list=new ArrayList<String>();
        if(num>8) return null;
        for(int h=0;h<12;h++){
        	for(int m=0;m<60;m++){
        		//bitCount缁熻浜岃繘鍒舵暟涓殑1鐨勪釜鏁帮紝杩欓噷鍋囪鏃堕拡鏀惧湪楂樹綅鍒嗛拡浣庝綅锛宧*64+m鍗充负璇ヤ簩杩涘埗鏁拌〃绀虹殑10杩涜处澶у皬
        		//涔熷彲浠ユ敼鎴恏+m*16=h+m*2^4
        		if(Integer.bitCount(h*64+m)==num){
        			list.add(h+":"+((m<10)?("0"+m):m));
        		}
        	}
        }
        return list;
    }
}
