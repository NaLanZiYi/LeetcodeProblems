package simple;
//返回字符串中最后一个单词的长度
public class LengthOfLastWord_58 {
	//这种方法仅仅适合娱乐，面试的时候这样做是很不好的
	public int lengthOfLastWord(String s) {
        if(s==null) return 0;
        String[] strs = s.split(" ");
        return strs.length>0?strs[strs.length-1].length():0;
        
        //其实最好将首尾的空白字符去掉
      //return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
	
	//讨论区-方法1：lower-lever method
	//基本思想：1-从末尾开始，找到第一个不为' '的字符
	//======2-从这个字符开始向前，记录下不为' '的字符个数，返回即可
	public int lengthOfLastWord1(String s) {
		if(s==null) return 0;
		int n = s.length()-1;
		int len = 0;
		while(n>=0&&s.charAt(n)==' ') n--;
		while(n>=0&&s.charAt(n)!=' '){
			n--;
			len++;
		}
		return len;
	}
	
}
