package medium;

public class CountingBits_338 {
	/**
	 * Ѱ��0-num֮���������ֵĶ����Ƹ����м���1
	 * @param num
	 * @return
	 */
	
	//��������-����1������
	//ԭ��f[i]=f[i/2]+i%2
	//��i��Ϊ�����֣����һλ��ǰ31λ�����һλ�Ƿ���1�ȼ���%2,ǰ�沿������i/2��ͬ
	public int[] countBits(int num) {
        int[] ret = new int[num+1];
        for(int i=0;i<ret.length;i++){
        	ret[i] = ret[i>>1]+i%2;   //����  ret[i] = ret[i>>1]+i&1;
        }
        return ret;
    }
	
	//������-����2
	public int[] countBits1(int num) {
		int[] ret = new int[num+1];
        for(int i=1;i<ret.length;i++){
        	ret[i] = ret[i&(i-1)]+1;  //i&(i-1)��ȥ��i�����һ��1λ������Ҫ�ں����1
        }
        return ret;
	}
	
	//������-����3����2���ݷֿ�����
	//0-7��8-15���Ӧ��Ψһ����������8-15��λ����һ��1
	public int[] countBits2(int num) {
		int[] ret = new int[num+1];	
		int pow = 1, t = 0;
        for(int i=1;i<ret.length;i++,t++){
        	if(pow==i) {
        		pow *= 2;
        		t = 0;
        	}
        	ret[i] = ret[t]+1;
        }
        return ret;
	}
	
	//������-����4����3ԭ����ͬ   
	//result[index] = result[index - offset] + 1;
//	dp[1] = dp[1-1] + 1;
//	dp[2] = dp[2-2] + 1;
//	dp[3] = dp[3-2] +1;
//	dp[4] = dp[4-4] + 1;
//	dp[5] = dp[5-4] + 1;
//	dp[6] = dp[6-4] + 1;
//	dp[7] = dp[7-4] + 1;
//	dp[8] = dp[8-8] + 1;
	public int[] countBits3(int num) {
		int result[] = new int[num + 1];
	    int offset = 1;
	    for (int index = 1; index < num + 1; ++index){
	        if (offset * 2 == index){
	            offset *= 2;
	        }
	        result[index] = result[index - offset] + 1;
	    }
	    return result;
	}
}
