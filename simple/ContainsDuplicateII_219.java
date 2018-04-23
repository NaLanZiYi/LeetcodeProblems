package simple;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII_219 {
	//此方法容易超时
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums==null||k<=0) return false;
        for(int i=0;i<nums.length-1;i++){
        	for(int j=i+1;j<=i+k&&j<nums.length;j++){
        		if(nums[i]==nums[j]&&j-i<=k) return true;
        	}
        }
        return false;
    }
	
	//讨论区-方法1：使用map
	//以数组元素作为key，下标作为value，当出现相同的key时，比较下标是否在k以内即可
	public boolean containsNearbyDuplicate1(int[] nums, int k) {
		if(nums==null||k<=0) return false;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				if(i-map.get(nums[i])<=k) return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}
	
	//讨论区-方法2：使用Set
	//核心思想：维持一个长度为k+1的set，如果i>k，则删除最开头的元素，因为后面的元素与它的距离一定是大于k的
	//如果新的值在set中存在，距离一定在k以内，说明找到
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<nums.length;i++){
			//以下两句不能调换顺序，也不能换成if...else
			if(i>k) set.remove(i-k-1);
			if(!set.add(nums[i])) return true;
			
			//或者换成下面的表达
			//if(!set.add(nums[i])) return true;
			//if(set.size()>k) set.remove(i-k-1);
		}
		return false;
	}
}
