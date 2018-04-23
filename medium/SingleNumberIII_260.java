package medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SingleNumberIII_260 {
	public int[] singleNumber(int[] nums) {		
        if(nums==null||nums.length<2) return new int[]{};
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
        	if(!set.add(n)) set.remove(n);
        }
        Iterator iter = set.iterator();
        return new int[]{(int) iter.next(),(int) iter.next()};
    }
	
	//������-����1��ʹ�����
	//��������������򣬵õ�ҪѰ�ҵ������������ֵ����������ԭ�����ֶ�����1��λ��˵�����������ڸ�λ���ǲ�ͬ��
	//����ж��1λ��������ȡһ��1λ���ɣ����ݸ�λ��ԭ�������ݷ�Ϊ���飬��ô���������ض����ڲ�ͬ������
	//�ο���http://stackoverflow.com/questions/7405438/why-if-n-n-n-then-n-is-a-power-of-2
	public int[] singleNumber1(int[] nums) {
		int diff = 0;
		for(int n : nums){
			diff ^= n;
		}
		
		//ȡdiff�����һ��������1λ�ã����ݸ�λ������Ԫ�ؽ��з���
		//diff &= ~(diff-1)
		//diff ^= diff&(diff-1)
		//diff = Integer.highestOneBit(diff);
		diff &= -diff;
		int[] ret = {0,0};
		for(int n : nums){
			if((n & diff) == 0){
				ret[0] ^= n;
			}else{
				ret[1] ^= n;
			}
		}
		return ret;
	}
	
	//������-����2���뷽��1��ͬ��ֻ��Щ΢�仯
	public int[] singleNumber2(int[] nums) {
		int xXor = nums[0];
	    for (int i = 1; i<nums.length; i++) {
	        xXor = xXor ^ nums[i];
	    }
	    
	    int marker = 1; 
	    while ((marker & xXor) != marker) {
	        marker = marker << 1;
	    }
	    
	    int resultX = 0;
	    for (int i = 0; i<nums.length; i++) {
	        if ((nums[i] & marker)!=0) {
	            resultX = resultX^nums[i];
	        }
	    }
	    //�����Ѿ����������һ����ֻ��Ҫ��ԭ������ϼ�����򼴿ɵó�����һ��
	    int resultY = resultX^xXor;
	    
	    return new int[]{resultX, resultY};
	}
	
	
	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE+"--"+-Integer.MIN_VALUE);
	}
}
