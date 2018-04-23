package medium;

public class IntegerBreak_343 {
	//��������֤���ֽ�������Ϊ����3��2
	//����f>4����ô2*(f-2)=2*f-4>4��˵����f>4ʱ������Ӧ�ý���ֽ�ɸ�С����
	//�ٸ���6=3+3=2+2+2����3*3>2*2*2���������ȿ���3
	public int integerBreak(int n) {
		//����������ʵ��4=2+2��2*2=4�������4��ʱ��û�б�Ҫ�����ֽ⣬
		//5=2+3��2*3=6��6=3+3=2+2+2,����3*3>2*2*2��
		//���Դ�5��ʼ�����е����������𽥷ֳɽ�С�������������ȷֳ�3�����ֵ�������2��3��4ʱ��ֹͣ
        if(n<4) return n-1;
        int product = 1;
        while(n>2){
        	if(n==4||n==3||n==2) break;
        	if(n>3){
        		product *= 3;
        		n -= 3;
        	}
        }
        
        //��������������4��
//        while(n>4){
//        	product *= 3;
//        	n -= 3;
//        }
        product *= n;
        return product;
    }
	
	//������-����1:˼���࣬����Էֽ�Ľ��������������������ۣ���2��1��2��2��2
	public int integerBreak1(int n) {
		if(n<4) return n-1;
		if(n%3==0) return (int)Math.pow(3, n/3);
		if(n%3==1) return 4*(int)Math.pow(3, (n-4)/3);
		return 2*(int)Math.pow(3, (n-2)/3);
	}
	
	//������-����2��DP��̬�滮
//	(1) i is the sum of two numbers, i.e. S=i-j is one number, and so maxArr[i]=j*(i-j)
//  (2) i is the sum of at least three numbers, i.e. S=i-j is a sum of at least 2 numbers,
	public int integerBreak2(int n) {
		int[] dp = new int[n+1];
		dp[1] = dp [2] = 1;
		for(int i=3;i<n;i++){
			for(int j=1;j<i;j++){
			//for(int j=1;2*j<i;j++)   // ������˼���
				//dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
				dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*(dp[i-j])));
			}
		}
		return dp[n];
	}
	
	//������-����3��DP�ı���
	int integerBreak3(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        for (int i = 5; i <= n; ++i) {
            dp[i] = 3 * Math.max(i - 3, dp[i - 3]);
        }
        return dp[n];
    }
}
