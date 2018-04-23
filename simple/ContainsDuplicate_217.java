package simple;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ContainsDuplicate_217 {
	//瀛樺叆set鑷姩鍘绘帀閲嶅鍊硷紝妫?鏌et鐨勯暱搴﹀拰nums闀垮害鏄惁鐩哥瓑
	public boolean containsDuplicate(int[] nums) {
        if(nums==null) return false;
        Set<Integer> set=new HashSet<Integer>();
//        for(int i:nums) {
//        	//鈶?
////        	if(set.contains(i)) return true;
////        	set.add(i);
        //绛変环浜庯細if(!set.add(i)) return true;
//        	
//        	//鈶?
//        	set.add(i);
//        	if(set.size()<i+1) return true;
//        }
        for(int i:nums) set.add(i);
        if(set.size()==nums.length) return false;
        return false;
    }
	
	//鍒╃敤鏁扮粍鎺掑簭锛屾鏌ョ浉閭诲厓绱犳槸鍚︾浉绛?
	public boolean containsDuplicate1(int[] nums) {
		if(nums==null) return false;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i++){
			if(nums[i]==nums[i+1]) return true;
		}
		return false;
	}
	
	//璁ㄨ鍖猴細涓婅瘔鏂规硶鐨勫彉褰紝浣跨敤鍙屾寚閽堝垎鍒寚鍚戦灏?
	public boolean containsDuplicate2(int[] nums) {
		if(nums==null) return false;
		Arrays.sort(nums);
		int i=0,j=nums.length-1;
		while(i<j){
			if(nums[i]==nums[i+1]||nums[j-1]==nums[j]) return true;
			i++;
			j--;
		}
		return false;
	}
}
