package simple;
import java.util.HashSet;
import java.util.Set;


//鎵惧嚭鏈?闀跨殑鍥炴枃鐨勯暱搴?
public class LongestPalindrome_409 {
	public int longestPalindrome(String s) {
        if(s==null||s.length()==0) return 0;
        if(s.length()==1) return 1;
        int[] charNums=new int[52];
        for(char i:s.toCharArray()){
        	if(i>='a'){
        		charNums[i-'a']++;  //0-25 is lowercase
        	}else{
        		charNums[26+i-'A']++; //26-51 for uppercase
        	}
        }
        int onlyone=0;
        int sum=0;
        for(int i : charNums){
        	if(onlyone==0&&i%2==1) onlyone=1;
        	sum+=i/2;
        }
        return (onlyone==1)?sum*2+1:sum*2;
    }
	
	//璁ㄨ鍖?-鏂规硶鈶犱娇鐢╯et鎴栬?卪ap锛屽厛娣诲姞鍚庡垹闄わ紝缁熻鏈?鍚庡嚭鐜板熀鏁版鐨勫瓧绗︿釜鏁?
	public int longestPalindrome1(String s) {
		Set<Character> set=new HashSet<Character>();
		for(char c:s.toCharArray()){
			if(set.contains(c))set.remove(c);
			else set.add(c);
		}
		int odds=set.size();   //number of odd char
		return s.length()-(odds==0?0:odds-1);
	}
}
