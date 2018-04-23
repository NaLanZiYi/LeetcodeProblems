package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfWordLengths_318 {
	//������-����1��λ���㣺ʹ��32λ�еĵ�1-26λ�Ƿ�Ϊ1��ʾa-z��ĸ�Ƿ����
	public int maxProduct(String[] words) {
        if(words==null||words.length==0) return 0;
        int maxproduct = 0;
        int len = words.length;
        int[] values = new int[len];
        for(int i=0;i<len;i++){
        	values[i] = 0;
        	for(int j=0;j<words[i].length();j++){
        		//���ҿ�ʼ����һλ��ʾ��ĸa���ڶ�λb����������
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
	
	//������-����2������1�ı���:������Ԫ�ذ����ȴӴ�С����
	//�����������˻���ʱ��ֻҪһ�������һ���˻����Ͳ�������������ˣ���Ϊ�����ĳ��ȱ��
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
        		//���ҿ�ʼ����һλ��ʾ��ĸa���ڶ�λb����������
        		values[i] |= 1<<(words[i].charAt(j)-'a');
        	}
        }
        
        for(int i=0;i<len;i++){
        	//����ʹ����i.len*i.len���������������ı���
        	if(words[i].length()*words[i].length()<=maxproduct) break;
        	for(int j=i+1;j<len;j++){
        		if((values[i]&values[j])==0&&(words[i].length()*words[j].length()>maxproduct)){
        			maxproduct = words[i].length()*words[j].length();
        		}
        	}
        }
        return maxproduct;
	}
	
	//������-����3��
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
