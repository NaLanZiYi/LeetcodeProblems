package simple;

public class CompareVersionNumbers_165 {
	//讨论区-方法1：字符串分割
	public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."); 
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length);
        for(int i=0;i<len;i++){
        	Integer num1 = i<v1.length?Integer.parseInt(v1[i]):0;
        	Integer num2 = i<v2.length?Integer.parseInt(v2[i]):0;
        	int compare = num1.compareTo(num2);
        	if(compare!=0) 	return compare; 
        }
        return 0;
    }
	
	//讨论-方法2：不用分割字符串
	public int compareVersion1(String version1, String version2) {
		int len1 = version1.length(), len2 = version2.length();
		int i = 0, j = 0;
		int temp1 = 0, temp2 = 0;
		while(i<len1||j<len2){
			while(i<len1&&version1.charAt(i)!='.'){
				temp1 = temp1*10+version1.charAt(i)-'0';
			}
			while(j<len1&&version2.charAt(j)!='.'){
				temp2 = temp2*10+version2.charAt(j)-'0';
			}
			if(temp1<temp2) return -1;
			else if(temp1>temp2) return 1;
			++i;
			++j;
			temp1 = temp2 =0;
		}
		return 0;
	}
}
