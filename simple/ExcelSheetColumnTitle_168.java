package simple;

public class ExcelSheetColumnTitle_168 {
	//可以 采用26进制的方式，但是问题在于题目中的整数从0开始，这就意味着这个26进制缺少0，把整数减去1即可
	public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while(n>0){
        	--n;
        	builder.append((char)('A'+n%26));
        	n/=26;
        }
        //注意要颠倒顺序
        return builder.reverse().toString();
    }
	
	//讨论区-方法2-递归
	public String convertToTitle1(int n) {
		return n==0 ? "" : convertToTitle1((--n)/26)+(char)('A'+n%26);
	}
}
