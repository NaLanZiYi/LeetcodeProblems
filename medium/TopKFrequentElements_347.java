package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKFrequentElements_347 {
	//������-����1��ʹ��bucket����Ƶ����������Ԫ��
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //ͳ��ÿ�����ֵ�Ƶ��
        for(int n : nums){
        	map.put(n, map.getOrDefault(n, 0)+1);
        }
        //������Ƶ��Ϊ�±��¼��ͬ���֣������±�Խ�������Ƶ��Խ��
        List<Integer>[] list = new ArrayList[nums.length+1];
        for(int key : map.keySet()){
        	int freq = map.get(key);
        	if(list[freq]==null){
        		list[freq] = new ArrayList<>();
        	}
        	list[freq].add(key);
        }
        //��Ƶ���ɸߵ��ͻ�ȡ����
        List<Integer> ret = new ArrayList<>();
        for(int i=list.length-1;i>=0&&ret.size()<k;i--){
        	if(list[i]!=null){
        		ret.addAll(list[i]);
        	}
        }
        //����k�����ȵ����б�
        return ret.subList(0, k);
    }
	
	//������-����2��ʹ�����ȼ�����
	public List<Integer> topKFrequent1(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<>();
        //ͳ��ÿ�����ֵ�Ƶ��
        for(int n : nums){
        	map.put(n, map.getOrDefault(n, 0)+1);
        }
        //�������ȼ����У�ʹ��lamda���ʽ��������
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        	maxHeap.add(entry);
        }
        //���λ�ȡ���жѶ���ֵ
        List<Integer> ret = new ArrayList<>();
        while(ret.size()<k){
        	ret.add(maxHeap.poll().getKey());
        }
        return ret;
	}
	
	//������-����3��ʹ��TreeMap
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
