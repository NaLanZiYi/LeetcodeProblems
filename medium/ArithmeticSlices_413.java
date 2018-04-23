package medium;

public class ArithmeticSlices_413 {
	//������ѵ���Ҫ���ڼ���sum
	//������-����1��
	//ԭ����3�����п�ʼ�����г���ÿ����1����Ӧ������i-3+1=i-2����cur��¼������ӵ�ֵ���ӵ�sum�ϼ�Ϊ�ܺ�
	public int numberOfArithmeticSlices(int[] A) {
		if(A.length<3) return 0;
		int sum = 0, cur = 0;
        for(int i=2;i<A.length;i++){
        	//ע�⣬�������������������MAX_VALUE-MIN_VALUE�����ܿ���ת��long����
        	if(A[i]-A[i-1]==A[i-1]-A[i-2]){
        		++cur;
        		sum+=cur;
        		//sum+=++cur;
        	}else{
        		cur=0;
        	}
        }
        return sum;
    }
	
	//������-����2
	//����Ҫÿ�ζ�����sum��ֻ�������г���len��Ȼ��ʹ�ù�ʽ����len��Ӧ���ٸ�������
	public int numberOfArithmeticSlices1(int[] A) {
	    if(A == null || A.length < 3)
            return 0;
        int sum = 0;
        int len = 2;

        for(int i=2;i<A.length;i++) {
            // keep increasing the splice
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) {
                len++;
            }
            else {
                if(len > 2) {
                    sum += calculateSlices(len);
                }
                // reset the length of new slice
                len = 2;
            }
        }
        // add up the slice in the rear
        if(len>2)
            sum += calculateSlices(len);
        return sum;
	}
	//���㳤��Ϊn�����а�������������
	 private int calculateSlices(int n){
	        return (n-1)*(n-2)/2;
	    }
}
