package simple;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given an array of integers, every element appears 
 * twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
 * @author Dian
 *
 */
public class SingleNumber_136 {
	//杞寲鎴恗ap锛屼互鏁板瓧涓簁ey锛屽嚭鐜版鏁颁负value锛岀劧鍚庨亶鍘唌ap鍗冲彲
	public int singleNumber(int[] nums) {
		int ret=0;
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int key:nums){
			if(map.containsKey(key)){
				map.put(key, (int)map.get(key)+1);
			}else{
				map.put(key, 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry:map.entrySet()){
			if(entry.getValue()==1){
				ret=entry.getKey();
			}
		} 
		
		return ret;
	}
	
	//缃戝弸浣跨敤浜︽垨鐨勫仛娉?
	/**
	 * 鎬濊矾锛屼害鎴栬浆鎹㈡垚2杩涘埗锛岀浉鍚屼负0锛屼笉鍚屼负1锛屼害鎴栨搷浣滃彲浜ゆ崲
	 * @param nums
	 * @return
	 */
	public int singleNumber1(int[] nums){
		int result = 0;
		//娆″惊鐜浉褰撲簬0^nums[0]^nums[1]^....^nums[n-1]锛岀粨鏋滃氨绛変簬鍑虹幇涓?娆＄殑閭ｄ釜鏁?
		for(int i=0;i<nums.length;i++){
			result^=nums[i];
		}
		return result;
	}
}
