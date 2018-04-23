package simple;

public class NthDigit_400 {
	//讨论区-方法1
	//思想：1.计算第n位对应几位数；2.计算对应的数；3.找出数上对应的位
	public int findNthDigit(int n) {
        int base = 1;  //记录第n位是几位数
        long count = 9;  //避免count溢出int范围
        while(n > base*count){
        	n -= base*count;
        	base++;
        	count *= 10;
        }
        //计算第n位对应的数字
        String num = (int)Math.pow(10, base-1)+((n-1)/base)+"";
        //找出n对应上面数字的第几位
        return Integer.parseInt(num.substring((n-1)%base,(n-1)%base+1));
        //或者
        //return Character.getNumericValue(num.charAt((n - 1) % base));
    }
	
	public static void main(String[] args){
		NthDigit_400 test = new NthDigit_400();
		test.findNthDigit(2147483647);
	}
}
