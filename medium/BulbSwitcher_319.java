package medium;

public class BulbSwitcher_319 {
	 //���ÿ�����Ĺ���������-----�������ʳ�ʱ
	 public int bulbSwitch(int n) {
	     if(n<=0) return 0;
	     int[] count = new int[n];
	     for(int i=1;i<=n;i++){
	    	 for(int j=1;j<=i/2;j++){
	    		 if(i%j==0)count[i-1]++;
	    	 }
	     }
	     int num = 0;
	     for(int count1 : count){
	    	 if(count1%2==0) num++;
	     }
	     return num;
	 }
	 
	 //������-����1
	 //���ݻ��������α仯�� ���ڿ���״̬����ÿ�����ݱ仯�Ĵ������������й�Լ���ĸ���
	 //һ������Ĺ�Լ�����ǳɶԴ��ڵģ��������ż���α仯�Դ��ڹص�״̬������ƽ����
	 //��������ͱ�������n�����е�ƽ�����ĸ�����squt(n)�Ǽ�����ʾ �����˼���ƽ����
	 public int bulbSwitch1(int n) {
		 return (int)Math.sqrt(n);
	 }
}
