package simple;
public class AddBinary_67 {
	//思路：从最后一位开始逐位相加，记录进位结果。需要注意的是如果算法结束之后仍然有进位，则在最高位要补上1
	public String addBinary(String a, String b) {
        char[] arra = a.toCharArray();
        char[] arrb = b.toCharArray();
        int count = 0;  //记录进位
        StringBuilder result = new StringBuilder();  //逆序记录和的每位数字
        int i=arra.length-1,j=arrb.length-1;
        int sum = 0;
        for(;i>=0&j>=0;i--,j--){
        	sum = count+arra[i]-'0'+arrb[j]-'0';//计算每一位的和，注意数组元素为char类型
        	count = sum>1?1:0;       //进位
        	sum = sum>1?sum-2:sum;   //结果位
        	result.append(sum);
        }
        //处理长度不一致的情况
        while(i>=0){
        	sum = count+arra[i--]-'0';
        	count = sum>1?1:0;
        	sum = sum>1?sum-2:sum;
        	result.append(sum);
        }
        while(j>=0){
        	sum = count+arrb[j--]-'0';
        	count = sum>1?1:0;
        	sum = sum>1?sum-2:sum;
        	result.append(sum);
        }
        if(count>0) result.append(count);
        return result.reverse().toString();
    }
	
	//讨论区-方法1：上述方法的简洁版
	public String addBinary1(String a, String b) {
		char[] arra = a.toCharArray();
        char[] arrb = b.toCharArray();
		StringBuilder result = new StringBuilder();
		int count = 0, i = arra.length-1, j = arrb.length-1;
		while(i>=0||j>=0||count==1){  //count==1在最后有额外的进位时才会执行，此时相当于添加一个最高位1
			count += i>=0?arra[i--]:0;  //在计算时同时考虑i>=0，简化后续的判断
			count += j>=0?arrb[j--]:0;
			result.append(count%2+'0');  //count%2即为结果位
			count /= 2;  //计算进位
		}
		return result.reverse().toString();
	}
}
