package simple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ArrayIntersection2_350 {
	public int[] intersect(int[] nums1, int[] nums2) { 
		
        if(nums1==null||nums2==null) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result=new ArrayList<Integer>();
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
        	if(nums1[i]<nums2[j]){
        		i++;
        	}else if(nums1[i]>nums2[j]){
        		j++;
        	}else{
        		result.add(nums1[i]);
        		i++;
        		j++;
        	}
        }
        int[] arr=new int[result.size()];
        i=0;
        
        for(int k:result){
        	arr[i++]=k;
        }
        return arr;
        
        //java8鐨勫仛娉?
        //return result.stream().mapToInt(Integer :: intValue).toArray();
    }
	
	//浣跨敤map淇濆瓨娆℃暟锛屾壘鍒颁氦鍙夊厓绱犲氨灏嗘鏁板噺1
	public int[] intersect1(int[] nums1, int[] nums2) {
		if(nums1==null||nums2==null) return new int[0];
		Map<Integer,Integer> store=new HashMap<Integer, Integer>();
		List<Integer> list=new ArrayList<Integer>();
		for(int i:nums1){
			store.put(i, store.getOrDefault(i, 0)+1);
		}
		for(int j:nums2){
			if(store.containsKey(j)&&store.get(j)>0){
				list.add(j);
				store.put(j,store.get(j)-1);
			}
		}
		//java8灏唋ist杞崲鎴愭暟缁勭殑绠?鍗曞仛娉?
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
