package medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber_268 {
	//����ķ���-��������
	public int missingNumber(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        Arrays.sort(nums);
        if(nums.length==1){
        	if(nums[0]==0) return 1;
        	else return 0;
        }
        int i = 0;
        for(;i<nums.length;i++){
        	if(nums[i]!=i){
        		return i;
        	}     	
        }
        return nums.length;
    }
	
	//������-����1�����
	public int missingNumber1(int[] nums) {
		//����м����ȱʧ����ô���һ�����ֱ�Ȼ�����鳤�ȣ���ʱ��֮ȡ���͵õ���ȷֵ�����û��ȱʧֵ����ֱ�ӷ������鳤��
		int xor = 0, index = 0;
		for(int n : nums){
			xor ^= n ^ (index++);
		}
		return xor^index;
	}
	
	//������-����2����͡�
	//1.�м�ȱʧ����ôsum=i-len�����������鳤��len���ɵó�i
	//2.��ȱʧֵ����sum=0,�������鳤��len����
	public int missingNumber2(int[] nums) {
		int sum = nums.length;
		for(int i=0;i<nums.length;i++){
			sum += i-nums[i];
		}
		return sum;
		
		//����
//		int n = nums.length, sum = 0;
//		for(int i=0;i<nums.length;i++){
//			sum+=i;
//		}
//		return n*(n+1)/2-sum;
	}
	
	//������-����3�����ֲ���
	public int missingNumber3(int[] nums) {
		int left = 0, right = nums.length, mid = left+(right-left)/2;
		Arrays.sort(nums);
		while(left<right){
			if(nums[mid]>mid){
				right = mid;
			}else{
				left = mid +1;
			}
			mid = left+(right-left)/2;
		}
		return left;
	}
	
	//������-����4��IntStream
	public int missingNumber4(int[] nums) {
		int n = nums.length;
		return (n*(n+1)/2-IntStream.of(nums).sum());
	}
}
