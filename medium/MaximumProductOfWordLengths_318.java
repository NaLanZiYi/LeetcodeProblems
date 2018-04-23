package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfWordLengths_318 {
	//讨论区-方法1：位运算：使用32位中的低1-26位是否为1表示a-z字母是否出现
	public int maxProduct(String[] words) {
        if(words==null||words.length==0) return 0;
        int maxproduct = 0;
        int len = words.length;
        int[] values = new int[len];
        for(int i=0;i<len;i++){
        	values[i] = 0;
        	for(int j=0;j<words[i].length();j++){
        		//从右开始，第一位表示字母a，第二位b，。。。。
        		values[i] |= 1<<(words[i].charAt(j)-'a');
        	}
        }
        
        for(int i=0;i<len;i++){
        	for(int j=i+1;j<len;j++){
        		if((values[i]&values[j])==0&&(words[i].length()*words[j].length()>maxproduct)){
        			maxproduct = words[i].length()*words[j].length();
        		}
        	}
        }
        return maxproduct;
    }
	
	//讨论区-方法2：方法1的变形:将数组元素按长度从大到小排序，
	//这样在求最大乘积的时候，只要一旦求出了一个乘积，就不用再求后续的了，因为后续的长度变短
	public int maxProduct1(String[] words) {
		if(words==null||words.length==0) return 0;
        int maxproduct = 0;
        int len = words.length;
        int[] values = new int[len];
        
        Arrays.sort(words,new Comparator<String>(){
			public int compare(String a, String b) {
				return b.length()-a.length();
			}        	
        });
        
        for(int i=0;i<len;i++){
        	values[i] = 0;
        	for(int j=0;j<words[i].length();j++){
        		//从右开始，第一位表示字母a，第二位b，。。。。
        		values[i] |= 1<<(words[i].charAt(j)-'a');
        	}
        }
        
        for(int i=0;i<len;i++){
        	//这里使用了i.len*i.len，避免后续作额外的遍历
        	if(words[i].length()*words[i].length()<=maxproduct) break;
        	for(int j=i+1;j<len;j++){
        		if((values[i]&values[j])==0&&(words[i].length()*words[j].length()>maxproduct)){
        			maxproduct = words[i].length()*words[j].length();
        		}
        	}
        }
        return maxproduct;
	}
	
	//讨论区-方法3：
	public int maxProduct2(String[] words) {
		Map<Integer,Integer> map = new HashMap<>();
		int result = 0;
		for(String word : words){
			int values = 0;
			for(char c : word.toCharArray()){
				values |= 1<<(c-'a');
			}
			map.put(values, Math.max(map.getOrDefault(values, 0), word.length()));
			for(int c : map.keySet()){
				if((values&c)==0){
					result = Math.max(result, word.length()*map.get(c));
				}
			}
		}
		return result;
	}
}
