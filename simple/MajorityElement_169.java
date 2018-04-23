package simple;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//鎵惧嚭鏁扮粍涓嚭鐜版鏁拌秴杩噉/2鐨勬暟瀛?
public class MajorityElement_169 {
	public int majorityElement(int[] nums) {
		int len=nums.length;
		if(len==1) return nums[0];
		int temp=0,result=0;
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i:nums){
        	if(map.containsKey(i)){
        		temp=(int)map.get(i);
        		if(temp>=len/2) {
        			result = i;
        			break;
        		}else{
        			map.put(i, temp+1);
        		}
        	}else{
        		map.put(i, 1);
        	}
        	//map.put(i, (int)map.getOrDefault(i, 0)+1);
        }
//        for(Map.Entry entry:map.entrySet()){
//        	if((int)entry.getValue()>len/2) {
//        		result = (int)entry.getKey();
//        	}
//        }
        return result;
    }
	
	//鏂规硶2锛氬鏁扮粍鎺掑簭锛屾壘鍑簄/2浣嶇疆鐨勫厓绱犲嵆鍙?
	public int majorityElement1(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	
	//璁ㄨ鍖?-鏂规硶3锛欱oyer-Moore implementation 
	//https://en.wikipedia.org/wiki/Boyer鈥揗oore_majority_vote_algorithm
	public int majorityElement2(int[] nums) {
		int candidate=0,count=0;
		for(int i=0;i<nums.length;i++){
			if(count==0){
				count=1;
				candidate=nums[i];
			}else if(nums[i]==candidate){
				count++;
			}else{
				count--;
			}
		}
		return candidate;
	}
	
	//璁ㄨ鍖?-鏂规硶4锛堟病鐪嬫噦锛?
	// Bit manipulation 
	public int majorityElement3(int[] nums) {
	    int[] bit = new int[32];
	    for (int num: nums)
	        for (int i=0; i<32; i++) 
	            if ((num>>(31-i) & 1) == 1)
	                bit[i]++;
	    int ret=0;
	    for (int i=0; i<32; i++) {
	        bit[i]=bit[i]>nums.length/2?1:0;
	        ret += bit[i]*(1<<(31-i));
	    }
	    return ret;
	}
}
