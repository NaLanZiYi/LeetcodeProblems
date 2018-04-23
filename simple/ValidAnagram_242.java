package simple;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ValidAnagram_242 {
	
	public boolean isAnagram(String s, String t) {
       // if(s==null||t==null) return false;
        //if(s.length()==0||t.length()==0) return s.equals(t);
        if(s.length()!=t.length()) return false;
        
    	char ch;
    	Map<Character, Integer> smap=new HashMap<Character, Integer>();
    	Map<Character, Integer> tmap=new HashMap<Character, Integer>();
    	//鍒濆鍖杕ap
    	for(int i=0;i<s.length();i++){
    		ch=s.charAt(i);
    		if(smap.containsKey(ch)) {smap.put(ch, smap.get(ch)+1);}
    		else smap.put(ch, 1);
    		//smap.put(ch, (int)smap.getOrDefault(ch, 0)+1);
    		ch=t.charAt(i);
    		if(tmap.containsKey(ch)) {tmap.put(ch, tmap.get(ch)+1);}
    		else tmap.put(ch, 1);
    		//tmap.put(ch, (int)tmap.getOrDefault(ch, 0)+1);
    	}
    	
    	for(Map.Entry entry:smap.entrySet()){
    		ch=(char)entry.getKey();
    		if(!tmap.containsKey(ch)) return false;
    		//娉ㄦ剰get鏂规硶杩斿洖鐨勬槸Integer瀵硅薄锛屼笉鑳戒娇鐢?==鏉ユ瘮杈?
    		if(!tmap.get(ch).equals(smap.get(ch))) return false;
    	}
    	return true;
    }
	
	//璁ㄨ鍖?-浣跨敤鏁扮粍瀛樻斁瀛楁瘝椤哄簭
	public boolean isAnagram1(String s, String t){
		//璇ユ柟娉曠畝鍗曟湁鏁堬紝浣嗙己鐐瑰湪浜庯細1.涓嶈兘澶勭悊unicode瀛楃 2.缂哄皯null鍒ゆ柇锛屼細鎶ュ紓甯? 
		//3.鍦ㄩ亶鍘唗鏃讹紝鍙互鍦?--涔嬪悗浣滃皬浜?0鐨勫垽鏂紝鍑忓皯鍚庣画鐨勬楠?
		//鏀硅繘锛氬彲鑰冭檻浣跨敤hashmap鏇挎崲鏁扮粍锛屽鐞唘nicode瀛楃
		int[] chars=new int[26];
		for(int i=0;i<s.length();i++) chars[s.charAt(i)-'a']++;
		for(int i=0;i<t.length();i++) chars[t.charAt(i)-'a']--;
		//鍙互鏇挎崲涓?
//		for(int i=0;i<t.length();i++){
//			if(--chars[t.charAt(i)-'a']<0) return false;
//		}
		for(int i:chars){
			if(i!=0) return false;
		}
		return true;
	}
	
	//瀵规暟缁勬帓搴?
	public boolean isAnagram2(String s, String t){
		if(s==null||t==null) return s==t;
		char[] schars=s.toCharArray();
		char[] tchars=t.toCharArray();
		Arrays.sort(schars);
		Arrays.sort(tchars);
		return Arrays.equals(schars, tchars);
	}
}
