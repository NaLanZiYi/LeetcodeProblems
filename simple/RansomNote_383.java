package simple;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * 閳ャ�╥ven閳ワ拷 an 閳ャ倹rbitrary閳ワ拷 ransom閳ワ拷 note閳ワ拷 string 閳ャ倹nd 閳ャ倹nother 閳ワ箷tring 閳ャ兘ontaining 閳ワ拷
 * letters from閳ワ拷 all 閳ワ箹he 閳ワ箮agazines,閳ワ拷 write 閳ャ倹 閳ャ倽unction 閳ワ箹hat 閳ワ箽ill 閳ワ箶eturn 閳ワ箹rue 閳ワ拷
 * if 閳ワ箹he 閳ワ箶ansom 閳ワ拷 note 閳ャ兘an 閳ャ倻e 閳ャ兘onstructed 閳ャ倽rom 閳ワ箹he 閳ワ箮agazines ; 閳ワ箰therwise, 閳ワ拷
 * it 閳ワ箽ill 閳ワ箶eturn 閳ャ倽alse. 
 * Each 閳ワ箥etter閳ワ拷 in閳ワ拷 the閳ワ拷 magazine 閳ワ箷tring 閳ャ兘an閳ワ拷 only 閳ャ倻e閳ワ拷 used 閳ワ箰nce閳ワ拷 in閳ワ拷 your 閳ワ箶ansom閳ワ拷 note.
 * @author Dian
 *
 */
public class RansomNote_383 {
	public boolean canConstruct(String ransomNote, String magazine) {
	    Map<Character, Integer> ransomMap=new HashMap<Character,Integer>();
	    Map<Character, Integer> magazineMap=new HashMap<Character,Integer>();
	    char[] rc=ransomNote.toCharArray();
	    char[] mc=magazine.toCharArray();
	    char ch;
	    int i;
	    for(i=0;i<rc.length;i++){
	    	ch=rc[i];
//	    	if(ransomMap.containsKey(ch)){
//	    		ransomMap.put(ch, (int)ransomMap.get(ch)+1);
//	    	}else{
//	    		ransomMap.put(ch, 1);
//	    	}
	    	ransomMap.put(ch, ransomMap.getOrDefault(ch, 0)+1);
	    }
	    
	    for(i=0;i<mc.length;i++){
	    	ch=mc[i];
//	    	if(magazineMap.containsKey(ch)){
//	    		magazineMap.put(ch, (int)magazineMap.get(ch)+1);
//	    	}else{
//	    		magazineMap.put(ch, 1);
//	    	}
	    	magazineMap.put(ch, magazineMap.getOrDefault(ch, 0)+1);
	    }
	    
	    for(Map.Entry<Character, Integer> entry:ransomMap.entrySet()){
	    	ch=entry.getKey();
	    	if(!magazineMap.containsKey(ch)){
	    		return false;
	    	}else if(entry.getValue()>magazineMap.get(ch)){
	    		return false;
	    	}
	    }
	    return true;
	}
	
	//閺傝纭�2閿涙艾褰ф担璺ㄦ暏娑擄拷娑撶尠ap
	public boolean canConstruct1(String ransomNote, String magazine) {
		Map map = new HashMap<Character,Integer>();
		for(char ch:magazine.toCharArray()){
			map.put(ch, (int)map.getOrDefault(ch, 0)+1);
		}
		for(char ch:ransomNote.toCharArray()){
			int num=(int) map.getOrDefault(ch, 0)-1;
			if(num<0) return false;
			map.put(ch, num);
			//娑撳﹪娼版稉澶庮攽缁涘鐜禍锟�
			//if((int)map.put(ch, (int)map.getOrDefault(ch, 0)-1)<0) return false;
		}
		return true;
	}
}
