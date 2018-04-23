package simple;

//将zigzag字符串转换为正常的字符串
public class ZigZagConversion_4 {
	//讨论区-方法1：
	public String convert(String s, int numRows) {
        if(s==null||numRows<=1) return s;
        char[] cs = s.toCharArray();
        int len = cs.length;
        StringBuilder[] builder = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++) builder[i] = new StringBuilder();
        //思路，先竖直遍历，然后倾斜遍历，依次循环，注意中间单元素列行数位numRows-2
        for(int i=0;i<len;){
        	for(int j=0;j<numRows&&i<len;j++){
        		builder[j].append(cs[i++]);
        	}
        	for(int j=numRows-2;j>=1&&i<len;j--){
        		builder[j].append(cs[i++]);
        	}
        }
        for(int i=1;i<numRows;i++){
        	builder[0].append(builder[i]);
        }
        return builder[0].toString();
    }
	
	//讨论区-方法2：按行遍历，每一行字符坐标为pos+step1[+step2]
	/*n=numRows
	 *       -pos-|-------------step1---|-step2-|----------step1-----|-step2--|
	Δ=2n-2    1                           2n-1                         4n-3
	Δ=        2                     2n-2  2n                    4n-4   4n-2
	Δ=        3               2n-3        2n+1              4n-5       .
	Δ=        .           .               .               .            .
	Δ=        .       n+2                 .           3n               .
	Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
	Δ=2n-2    n                           3n-2                         5n-48*/
	//实际上，由于下标从0开始，上述所有的下标都需要减去1
	public String convert1(String s, int numRows) {
		if(s==null||numRows<=1) return s;
		int len = s.length();
		char[] cs = s.toCharArray();
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<numRows;i++){
			int step1 = (numRows-i-1)*2;
			int step2 = i*2;
			int pos = i;
			if(pos<len) builder.append(cs[pos]);
			//循环遍历每一行后面的元素
			while(pos<len){
				pos += step1;
				if(pos<len&&step1!=0) builder.append(cs[pos]);
				if(step2!=0){
					pos += step2;
					if(pos<len) builder.append(cs[pos]);
				}				
			}
		}
		return builder.toString();
	}
	
	//讨论区-方法3：与方法1类似，step使用的很妙
	public String convert2(String s, int numRows) {
		if(numRows<=1) return s;
		int len = s.length();
		char[] cs = s.toCharArray();
		int row = 0, step = 0;
		StringBuilder[] builder = new StringBuilder[len];
		for(int i=0;i<numRows;i++) builder[i] = new StringBuilder();
		for(int i=0;i<len;i++){
			builder[row].append(cs[i]);
			//使用step来确定方向
			if(row==0) step = 1;
			else if(row==numRows-1) step = -1;
			row += step;
		}
		for(int i=1;i<numRows;i++){
        	builder[0].append(builder[i]);
        }
        return builder[0].toString();
	}
	
	//讨论区-方法4：与方法2类似，同样是横向遍历
	//将字符竖直分割为若干组，每组的长度为cycle=2*numRows-2，第i行的第一个字符位置j=i+cycle*k，第二个字符位secondJ=j-i+cycle-i
	public String convert3(String s, int numRows) {
        if(numRows <= 1) return s;
        String result = "";
        //the size of a cycle(period)
        int cycle = 2 * numRows - 2;
        char[] cs = s.toCharArray();
        for(int i = 0; i < numRows; ++i)
        {
            for(int j = i; j < s.length(); j = j + cycle){
               result = result + cs[j];
               int secondJ = (j - i) + cycle - i;
               //排除第一行和最后一行
               if(i != 0 && i != numRows-1 && secondJ < s.length())
                   result = result + cs[secondJ];
            }
        }
        return result;
    }
}
