package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKFrequentElements_347 {
	//讨论区-方法1：使用bucket按照频率排列数组元素
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //统计每个数字的频率
        for(int n : nums){
        	map.put(n, map.getOrDefault(n, 0)+1);
        }
        //以数字频率为下标记录不同数字，这样下标越大的数字频率越高
        List<Integer>[] list = new ArrayList[nums.length+1];
        for(int key : map.keySet()){
        	int freq = map.get(key);
        	if(list[freq]==null){
        		list[freq] = new ArrayList<>();
        	}
        	list[freq].add(key);
        }
        //按频率由高到低获取数字
        List<Integer> ret = new ArrayList<>();
        for(int i=list.length-1;i>=0&&ret.size()<k;i--){
        	if(list[i]!=null){
        		ret.addAll(list[i]);
        	}
        }
        //返回k个长度的子列表
        return ret.subList(0, k);
    }
	
	//讨论区-方法2：使用优先级队列
	public List<Integer> topKFrequent1(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<>();
        //统计每个数字的频率
        for(int n : nums){
        	map.put(n, map.getOrDefault(n, 0)+1);
        }
        //利用优先级队列，使用lamda表达式构建最大堆
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        	maxHeap.add(entry);
        }
        //依次获取队列堆顶的值
        List<Integer> ret = new ArrayList<>();
        while(ret.size()<k){
        	ret.add(maxHeap.poll().getKey());
        }
        return ret;
	}
	
	//讨论区-方法3：使用TreeMap
	public List<Integer> topKFrequent2(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
           int freq = map.get(num);
           if(!freqMap.containsKey(freq)){
               freqMap.put(freq, new LinkedList<>());
           }
           freqMap.get(freq).add(num);
        }
        
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res.subList(0, k);
	}
}
