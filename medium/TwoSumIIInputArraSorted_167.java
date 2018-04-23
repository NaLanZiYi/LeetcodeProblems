package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TwoSumIIInputArraSorted_167 {
	public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
        	if(i<numbers.length-1&&numbers[i]+numbers[i+1]==target){
        		return new int[]{i+1,i+2};
        	}
        	map.put(numbers[i],i+1);
        }
        int first = 0, second = 0;
        for(Entry<Integer,Integer> entry : map.entrySet()){
        	int key = entry.getKey();
        	if(map.containsKey(target-key)){
        		first = map.get(key);
        		second = map.get(target-key);
        		break;
        	}
        }
        return first>second?new int[]{second,first}:new int[]{first,second};
    }
	
	//讨论区-方法1：采用首尾指针，注意数组已经排序
	public int[] twoSum1(int[] numbers, int target) {
		int[] indice = new int[2];
	    if (numbers == null || numbers.length < 2) return indice;
	    int first = 0, second = numbers.length-1;
	    long sum = 0;
	    while(first<second){
	    	sum = numbers[first] + numbers[second];
	    	if(sum==target){
	    		indice[0] = first+1;
	    		indice[1] = second+1;
	    		break;
	    	}else if(sum<target){
	    		first++;
	    	}else{
	    		second--;
	    	}
	    }
	    return indice;
	}
	
	//讨论区-方法2：二分查找，时间复杂度O(nlgn)
	public int[] twoSum2(int[] numbers, int target) {
	  if(numbers==null||numbers.length<2) return new int[]{};
	    for(int i=0; i<numbers.length-1; i++) {
	        int start=i+1, end=numbers.length-1, gap=target-numbers[i];
	        while(start <= end) {
	            int m = start+(end-start)/2;
	            if(numbers[m] == gap) return new int[]{i+1,m+1};
	            else if(numbers[m] > gap) end=m-1;
	            else start=m+1;
	        }
	    }
	    return new int[]{};
	}
}
