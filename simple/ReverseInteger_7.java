package simple;

public class ReverseInteger_7 {
	//除以10取余的方式实现翻转，可以同时避免首位出现多余的0
	public int reverse(int x) {
		long ret = 0;
		int tag = x<0?-1:1;
		long i = tag*x;
//        if(x<0){
//        	tag = -1;
//        	//x = -x;  //这里也可能越界，例如-2^31
//        	i = -x;
//        	
//        }
        while(i/10>0){
        	ret = ret*10+i%10;
        	i/=10;
        }
        ret = (ret*10+i)*tag;
        if(ret>Integer.MAX_VALUE||ret<Integer.MIN_VALUE) return 0;
//        if(ret>(int)Math.pow(2,31)-1||ret<-1*Math.pow(2, 31)){
//        	return 0;
//        }
        return (int) ret;
    }
	
	//通过StringBuilder翻转
	public int reverse1(int x) {
		long i = x;
		int tag = 1;
		if(x<0){
			tag *= -1;
			i *= -1;
		}
		String str = new StringBuilder(i+"").reverse().toString();
		long ret = Long.parseLong(str)*tag;
		if(ret>Integer.MAX_VALUE||ret<Integer.MIN_VALUE) return 0;
//		if(ret>(int)Math.pow(2,31)-1||ret<-1*Math.pow(2, 31)){
//	       return 0;
//	    }
	    return (int) ret;
	}
	
	//更优雅的写法
	public int reverse2(int x) {
		long result = 0;
		while(x!=0){
			result = result*10+x%10;
			x/=10;
		}
		if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE) return 0;
		return (int)result;
	}
	
	//讨论区-方法3：不使用long	
	public int reverse3(int x) {
		int result = 0;
		while(x!=0){
			int tail = x%10;
			result = result*10+tail;
			//如果发生溢出，则result的值就会发生变化
			if((result-tail)/10!=result) return 0;
			x/=10;
		}
		return result;
	}
	
	//讨论区-方法4：同3
	public int reverse4(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int res = 0;
        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE - x % 10) < res * 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        
        return sign * res;
    }
}
