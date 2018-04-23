package medium;

public class ProductOfArrayExceptSelf_238 {
	//������-����1�����α�������һ�μ���ǰi-1��Ļ����ڶ��μ����length-i-1��
	public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        //��һ��ѭ��������ÿһ���ǰi-1��ĳ˻�
        for(int i=1;i<n;i++){
        	result[i] = result[i-1]*nums[i-1];
        }
        //�ڶ���ѭ�������Ժ�n-i-1��ĳ˻�
        int right = 1;
        for(int i=n-1;i>=0;i--){
        	result[i] *= right;
        	right *= nums[i];
        }
        return result;
    }
	
	//������-����2������1�ı���
	//����������һ��ѭ������ɶ�����ĸ�ֵ
	public int[] productExceptSelf1(int[] nums) {
		int[] result = new int[nums.length];
		for(int i=0;i<result.length;i++) result[i] = 1;
		int ltor = 1, rtol = 1;
		for(int i=0, j=nums.length-1;i<nums.length-1;i++,j--){
			ltor *= nums[i];
			rtol *= nums[j];
			result[i+1] *= ltor;
			result[j-1] *= rtol;
		}
		return result;
	}
}
