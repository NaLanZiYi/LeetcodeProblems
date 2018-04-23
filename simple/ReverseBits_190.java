package simple;

public class ReverseBits_190 {
	// you need treat n as an unsigned value
	//讨论区-方法1：位运算归并排序
	//过程：abcdefgh -- efghabcd -- ghefcdab -- hgfedcba
    public int reverseBits(int n) {
        n = (n>>>16)|(n<<16); //高16位和低16位互换
        n = ((n & 0xff00ff00) >>> 8)|((n & 0x00ff00ff) << 8);  //16位中的高8位和低8位互换
        n = ((n & 0xf0f0f0f0) >>> 4)|((n & 0x0f0f0f0f) << 4);  //8位中的高4位和低4位互换
        n = ((n & 0xcccccccc) >>> 2)|((n & 0x33333333) << 2);  //4位中的高2位和低2位互换
        n = ((n & 0xaaaaaaaa) >>> 1)|((n & 0x55555555) << 1);  //2位互换
        return n;
    }
    
    //讨论区-方法2：位运算
    //循环右移n，通过result左移实现倒序
    public int reverseBits1(int n) {
    	int result = 0;
    	for(int i=0;i<32;i++){
    		result <<= 1;
    		result += n&1;    		
    		n >>>= 1;
    		//等同于下面一句话
    		//result = (result<<1)+(n>>>i & 1);
    		//result = (result<<1) | (n>>>i & 1);
    	}
    	return result;
    }
    
    //讨论区-方法3
    public int reverseBits2(int n) {
    	char[] tb= {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
    	 int curr = 0;
         int ret = 0;
         int msk = 0xF;
         for(int i = 0; i< 8; i++) {
             ret = ret << 4;
             curr = msk&n;
             ret |= tb[curr];
             n = n >> 4;
         }
         return ret;
    }
    
    //讨论区-方法3：思想与上述方法相同，不过每次将n的最后一位左移count位
    public int reverseBits3(int n) {
    	int res = 0;
        int count = 31;
        while (n != 0) {
            if ((n & 1) == 1) {
                res = res + (1 << count);
            } 
            n >>>= 1;
            count--;
        }
        
        return res;
    }
}
