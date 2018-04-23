package simple;
import java.util.HashMap;
import java.util.Map;

//判断字符串s和t是否同构
public class IsomorphicStrings_205 {
	//主要思想是判断字符之间的映射关系是否唯一
	public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap();
        for(int i=0;i<s.length();i++){
        	char cs = s.charAt(i);
        	char ts = t.charAt(i);
        	if(!map.containsKey(cs)){
        		//如果不包含key，说明该映射还不存在
        		//然而如果value已经存在，说明存在其他字符到该value的映射，返回false
        		if(map.containsValue(ts)) return false;
        		map.put(cs, ts);
        	}else if(map.get(cs)!=ts){
        		//包含key的时候，只需要判断value是否一致即可
        		return false;
        	}
        }
        return true;
    }
	
	//讨论区-2：
	public boolean isIsomorphic1(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
    
        for(Integer i = 0; i < s1.length(); i++) {
        	//如果key已存在,put会返回之前的value值，下面这一行比较的是Integer引用
        	//也可以比较数值，但是要注意排除返回null的情况
            if(m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }
	
	//讨论区-3:思想与我的做法一样，不同之处在于使用数组替换了map，使用数组下标与值的关系代替了map的k->value
	public boolean isIsomorphic2(String sString, String tString) {
		char[] s = sString.toCharArray();
	    char[] t = tString.toCharArray();

	    int length = s.length;
	    if(length != t.length) return false;

	    char[] sm = new char[256];
	    char[] tm = new char[256];

	    for(int i=0; i<length; i++){
	        char sc = s[i];
	        char tc = t[i];
	        if(sm[sc] == 0 && tm[tc] == 0){
	            sm[sc] = tc;
	            tm[tc] = sc;
	        }else{
	            if(sm[sc] != tc || tm[tc] != sc){
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	//讨论区-方法4：方法2的思想，但是使用数组
	public boolean isIsomorphic3(String s, String t) {
		int[] sarr = new int[256];
		int[] tarr = new int[256];
		for(int i=0;i<s.length();i++){
			if(sarr[i]!=tarr[i]) return false;
			sarr[s.charAt(i)]=i+1;
			tarr[t.charAt(i)]=i+1;
		}
		return true;
	}
	
	
	public static void main(String[] args){
		Map<Character,Character> map = new HashMap();
		map.put('a', 'b');
		System.out.println(map.put('a', 'b'));
	}
}
