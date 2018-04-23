package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses_241 {
	//讨论区-方法1：递归
	//这种方法的问题在于会重复计算某些表达式的值
	public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<>();
        for(int i=0;i<input.length();i++){
        	int result = 0;
        	char c = input.charAt(i);
        	if(c=='+'||c=='-'||c=='*'){
        		String part1 = input.substring(0,i);
        		String part2 = input.substring(i+1);
        		List<Integer> get1 = diffWaysToCompute(part1);
        		List<Integer> get2 = diffWaysToCompute(part2);
        		for(int n1 : get1){
        			for(int n2 : get2){
        				switch(c){
	        				case '+' : result = n1 + n2; break;
	        				case '-' : result = n1 - n2; break;
	        				case '*' : result = n1 * n2; break;
        				}
        			}
        			ret.add(result);
        		}
        	}
        }
        if(ret.size()==0){
        	ret.add(Integer.parseInt(input));
        }
        return ret;
    }
	
	//讨论区-方法2：方法1的改进
	//使用HashMap存储中间结果
	Map<String,List<Integer>> map = new HashMap<>();
	public List<Integer> diffWaysToCompute1(String input) {
		List<Integer> ret = new ArrayList<>();
        for(int i=0;i<input.length();i++){
        	int result = 0;
        	char c = input.charAt(i);
        	if(c=='+'||c=='-'||c=='*'){
        		String part1 = input.substring(0,i);
        		String part2 = input.substring(i+1);
        		List<Integer> get1 = map.getOrDefault(part1,diffWaysToCompute(part1));
        		List<Integer> get2 = map.getOrDefault(part2,diffWaysToCompute(part2));
        		for(int n1 : get1){
        			for(int n2 : get2){
        				switch(c){
	        				case '+' : result = n1 + n2; break;
	        				case '-' : result = n1 - n2; break;
	        				case '*' : result = n1 * n2; break;
        				}
        				ret.add(result);
        			}        			
        		}
        	}
        }
        if(ret.size()==0){
        	ret.add(Integer.parseInt(input));
        }
        //map.put(input,ret);
        return ret;
	}
}
