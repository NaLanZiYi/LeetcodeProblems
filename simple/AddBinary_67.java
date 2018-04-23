package simple;
public class AddBinary_67 {
	//˼·�������һλ��ʼ��λ��ӣ���¼��λ�������Ҫע���������㷨����֮����Ȼ�н�λ���������λҪ����1
	public String addBinary(String a, String b) {
        char[] arra = a.toCharArray();
        char[] arrb = b.toCharArray();
        int count = 0;  //��¼��λ
        StringBuilder result = new StringBuilder();  //�����¼�͵�ÿλ����
        int i=arra.length-1,j=arrb.length-1;
        int sum = 0;
        for(;i>=0&j>=0;i--,j--){
        	sum = count+arra[i]-'0'+arrb[j]-'0';//����ÿһλ�ĺͣ�ע������Ԫ��Ϊchar����
        	count = sum>1?1:0;       //��λ
        	sum = sum>1?sum-2:sum;   //���λ
        	result.append(sum);
        }
        //�����Ȳ�һ�µ����
        while(i>=0){
        	sum = count+arra[i--]-'0';
        	count = sum>1?1:0;
        	sum = sum>1?sum-2:sum;
        	result.append(sum);
        }
        while(j>=0){
        	sum = count+arrb[j--]-'0';
        	count = sum>1?1:0;
        	sum = sum>1?sum-2:sum;
        	result.append(sum);
        }
        if(count>0) result.append(count);
        return result.reverse().toString();
    }
	
	//������-����1�����������ļ���
	public String addBinary1(String a, String b) {
		char[] arra = a.toCharArray();
        char[] arrb = b.toCharArray();
		StringBuilder result = new StringBuilder();
		int count = 0, i = arra.length-1, j = arrb.length-1;
		while(i>=0||j>=0||count==1){  //count==1������ж���Ľ�λʱ�Ż�ִ�У���ʱ�൱�����һ�����λ1
			count += i>=0?arra[i--]:0;  //�ڼ���ʱͬʱ����i>=0���򻯺������ж�
			count += j>=0?arrb[j--]:0;
			result.append(count%2+'0');  //count%2��Ϊ���λ
			count /= 2;  //�����λ
		}
		return result.reverse().toString();
	}
}
