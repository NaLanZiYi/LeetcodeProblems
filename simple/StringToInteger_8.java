package simple;

public class StringToInteger_8 {
	public int myAtoi(String str) {
		str = str.trim();  //去掉首尾空白符
		if(str.equals("")) return 0;
		
		int tag = str.substring(0,1).equals("-")?-1:1;  //判断正负
		str = tag==-1?str.substring(1):str;  //若是负数去除负号
		if(tag==1&&str.substring(0,1).equals("+")) str = str.substring(1);  //正数去掉正号
		StringBuilder builder = new StringBuilder();
		int validIndex = 0;  //记录第一个有效数字
		
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c=='0'&&validIndex==0) continue;  //忽略前面的0
			if(c-'0'>=0&&c-'0'<=9) {
				if(validIndex!=1) validIndex=1;
				builder.append(c);
				if(builder.toString().length()>10) break;  //长度大于10就已经越界
			}
			else break;  //如果出现非数字则退出循环
		}
		String res = builder.toString();
		if(res.equals("")) return 0;
		
		long lnum = tag*Long.parseLong(res);
		//判断是否越界
		if(lnum>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		if(lnum<Integer.MIN_VALUE) return Integer.MIN_VALUE;
		return (int)lnum;
    }
	
	//讨论区-方法1：
	public int myAtoi1(String str) {
		int sign = 1, base = 0, i = 0;
		char[] cs = str.toCharArray();
		while(cs[i]==' ') i++;
		if(cs[i]=='-'||cs[i]=='+') sign = cs[i++]=='-'?-1:1;
		while(cs[i]>='0'||cs[i]<='9'){
			//这里只需要考虑已经有9位数的情况，下面的if条件会放过Integer.MAX_VALUE，但是在下一次循环或者最后返回时会处理。
			if(base>Integer.MAX_VALUE/10||(base==Integer.MAX_VALUE/10&&cs[i]-'0'>Integer.MAX_VALUE%10)){
				if(sign==1) return Integer.MAX_VALUE;
				else return Integer.MIN_VALUE;
			}
			base = base*10+cs[i++]-'0';
		}
		return sign*base;
	}
	
	public static void main(String[] args) {
		StringToInteger_8 test = new StringToInteger_8();
		System.out.println(test.myAtoi("+"));
	}
}
