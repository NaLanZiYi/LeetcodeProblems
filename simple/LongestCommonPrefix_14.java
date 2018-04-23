package simple;
import java.util.Arrays;

//最长公共前缀
public class LongestCommonPrefix_14 {
	public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0) return "";
        String str = strs[0];
        String temp = "";
        for(int i=1;i<strs.length;i++){
        	for(int j=0;j<str.length();j++){
        		if(strs[i].length()>j&&str.substring(j,j+1).equals(strs[i].substring(j, j+1))){
//        			temp+=str.substring(j,j+1);
        			continue;
        		}else{
        			str = str.substring(0, j);
        			break;        			
        		}
        	}        	
        }
        return str;
    }
	
	//讨论区-方法1：对字符串数组进行排序
	public String longestCommonPrefix1(String[] strs) {
		if(strs==null||strs.length==0) return "";
		Arrays.sort(strs);
		StringBuilder result = new StringBuilder();
		char[] c1 = strs[0].toCharArray();
		char[] c2 = strs[strs.length-1].toCharArray();
		for(int i=0;i<c1.length;i++){
			if(c2.length>i&&c1[i]==c2[i]){
				result.append(c1[i]);
			}else{
				break;
			}
		}
		return result.toString();
	}
	
	//讨论区-方法2：横向比较
	//思路：比较所有元素的第i位是否与第一个元素的第i位相同
	public String longestCommonPrefix2(String[] strs) {
		if(strs==null||strs.length==0) return "";
		StringBuilder result = new StringBuilder();
		for(int i=0;i<strs[0].length();i++){
			for(int j=1;j<strs.length;j++){
				if(strs[j].length()<=i||!strs[j].substring(i, i+1).equals(strs[0].substring(i, i+1))){
					return result.toString();
					//另一种思路是记录下最长前缀的位置，此时不需要result不停的添加前缀元素
					//return strs[0].substring(0,i);
				}
			}
			//如果遍历一圈，说明所有数组元素的第i位都相同，添加进前缀
			result.append(strs[0].substring(i, i+1));
		}
		return result.toString();
	}
}
