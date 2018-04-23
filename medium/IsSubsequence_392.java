package medium;

import java.util.List;

public class IsSubsequence_392 {
	public boolean isSubsequence(String s, String t) {
        if(s==null||t==null||t.length()<s.length()) return false;
        if(s.length()==0&&t.length()==0) return true;
        int lens = s.length(), lent = t.length();
        int i = 0, j = 0;
        //之所以在循环里面让j++，是为了在每次成功匹配之后，让j移动到下一个字符位置
        for(;i<lens&&j<lent;i++,j++){
        	char c = s.charAt(i);
        	while(j<lent&&t.charAt(j)!=c) ++j;
        	//如果在t的最后一位即lent-1成功匹配，那么j=lent-1，如果无法成功匹配，则j=lent，这两种情况都需要结束循环
        	if(j>=lent-1) break;
        }
        if(j==lent||i<lens-1) return false;
        return true;
        
        //对上述的改进
//        for(;j<lent&&j<lent;j++){
//        	if(s.charAt(i)==t.charAt(j)) i++;
//        }
//        return i==lens;
        
    }
	
	//讨论区-方法1：
	public boolean isSubsequence1(String s, String t) {
		if(t.length()<s.length()) return false;
		int prev = 0;
		//思想：遍历s，然后在t中寻找每一个字符c，记录下位置以便下次从该位置开始查找
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			prev = t.indexOf(c,prev);
			if(prev==-1) return false;
			++prev;
		}
		return true;
	}
	
	//讨论区-方法2：递归
	public boolean isSubsequence2(String s, String t) {
		if (s == null || s.length() == 0) return true;
        for (int i = 0; i < t.length(); i += 1) {
            if (t.charAt(i) == s.charAt(0)) return isSubsequence(s.substring(1), t.substring(i + 1));
        }
        return false;
	}
	
	//解决Follow-up的情况	
	public boolean[] isSubsequence(List<String> list, String t) {
		int[] indexs = new int[list.size()];  //记录每一个字符串的下标位置
		int tIndex = 0;
		for(int i=0;i<t.length();i++){
			for(int j=0;j<indexs.length;j++){
				char c = list.get(j).charAt(indexs[j]);
				if(c==t.charAt(tIndex++)) indexs[j]++;
			}			
		}
		boolean[] b = new boolean[indexs.length];
		for(int i=0;i<indexs.length;i++) {
			b[i] = false;
			if(indexs[i]==list.get(i).length()) b[i] = true;
		}
		return b;
	}
	

}
 