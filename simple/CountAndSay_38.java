package simple;

public class CountAndSay_38 {
	public String countAndSay(int n) {
		if(n<=0) return "";
		//String str1="1",str2="1";
		String str = "1";
        for(int i=1;i<n;i++){
        	//str2 = getNextStr(str1);
        	//str1=str2;
        	str = getNextStr(str);
        }
        return str;
    }
	
	public String getNextStr(String str){
		if(str.length()==1) return "11";
        StringBuilder ret = new StringBuilder();
        char[] ch = str.toCharArray();
        int len = ch.length;
        //下面的代码无法处理str长度为1的情况，需要在开头作判断
        for(int i=0;i<len-1;){
        	int count = 1;
        	//下面的while循环只能处理最后两个元素相等的情况
        	while(i<len-1&&ch[i]==ch[i+1]){
        		count++;
        		i++;
        	}
        	ret.append(count+""+ch[i]);
        	i++;  //可以放在for里面
        	//处理最后两个元素不相等的情况
        	if(i==len-1&&ch[i]!=ch[i-1]){
        		ret.append("1"+ch[i]);
        	}
        }
        
        //-----改写上面的for循环-----
//        for(int i=0;i<len;i++){
//        	int count = 1;
//        	//下面的while循环只能处理最后两个元素相等的情况
//        	while(i<len-1&&ch[i]==ch[i+1]){
//        		count++;
//        		i++;
//        	}
//        	ret.append(count+""+ch[i]);
//        }
        
        return ret.toString();
	}
	
	//讨论区-2：方法同上，但是更简洁
	public String getNextStr1(String str){
		StringBuilder builder = new StringBuilder();
		int count = 1;
		char[] cs = str.toCharArray();
		char c = cs[0];
		for(int i = 1;i<str.length();i++){
			if(cs[i]==c) {
				count++;
			}else{
				builder.append(count+""+c);
				count=1;
				c=cs[i];
			}
		}
		builder.append(count+""+c);
		return builder.toString();
	}
	
	//讨论区-方法3：不使用额外的函数
	public String countAndSay2(int n) {
		if(n<=0) return "";
		String str = "1";
		while(--n>0){
			StringBuilder cur = new StringBuilder();
			for(int i=0;i<str.length();i++){
				int count = 1;
				//第一个判断防止下标越界
				while(i+1<str.length()&&str.charAt(i)==str.charAt(i+1)){
					++count;
					++i;
				}
				cur.append(count+""+str.charAt(i));				
			}
			str = cur.toString();
		}
		return str;
	}
	
	public static void main(String[] args){
		CountAndSay_38 test = new CountAndSay_38();
		System.out.println(test.countAndSay(4));
	}
}
