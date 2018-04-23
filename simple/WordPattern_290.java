package simple;
import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {
	public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length()!=strs.length) return false;
        Map<Character,String> map1 = new HashMap<>();
        for(int i=0;i<strs.length;i++){
        	char c = pattern.charAt(i);
        	String str1 = strs[i];
        	if(map1.containsKey(c)){
        		if(!map1.get(c).equals(str1)) return false;
        	}else{
        		if(map1.containsValue(str1)) return false;
        	}
        	map1.put(c, str1);
        }
        return true;
    }
	
	public boolean wordPattern1(String pattern, String str) {
		String[] strs = str.split(" ");
        if(pattern.length()!=strs.length) return false;
        Map<Character,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for(Integer i=0;i<strs.length;i++){
        	if(map1.put(pattern.charAt(i), i)!=map2.put(strs[i], i))
        		return false;
        }
        return true;
	}
}
