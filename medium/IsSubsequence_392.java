package medium;

import java.util.List;

public class IsSubsequence_392 {
	public boolean isSubsequence(String s, String t) {
        if(s==null||t==null||t.length()<s.length()) return false;
        if(s.length()==0&&t.length()==0) return true;
        int lens = s.length(), lent = t.length();
        int i = 0, j = 0;
        //֮������ѭ��������j++����Ϊ����ÿ�γɹ�ƥ��֮����j�ƶ�����һ���ַ�λ��
        for(;i<lens&&j<lent;i++,j++){
        	char c = s.charAt(i);
        	while(j<lent&&t.charAt(j)!=c) ++j;
        	//�����t�����һλ��lent-1�ɹ�ƥ�䣬��ôj=lent-1������޷��ɹ�ƥ�䣬��j=lent���������������Ҫ����ѭ��
        	if(j>=lent-1) break;
        }
        if(j==lent||i<lens-1) return false;
        return true;
        
        //�������ĸĽ�
//        for(;j<lent&&j<lent;j++){
//        	if(s.charAt(i)==t.charAt(j)) i++;
//        }
//        return i==lens;
        
    }
	
	//������-����1��
	public boolean isSubsequence1(String s, String t) {
		if(t.length()<s.length()) return false;
		int prev = 0;
		//˼�룺����s��Ȼ����t��Ѱ��ÿһ���ַ�c����¼��λ���Ա��´δӸ�λ�ÿ�ʼ����
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			prev = t.indexOf(c,prev);
			if(prev==-1) return false;
			++prev;
		}
		return true;
	}
	
	//������-����2���ݹ�
	public boolean isSubsequence2(String s, String t) {
		if (s == null || s.length() == 0) return true;
        for (int i = 0; i < t.length(); i += 1) {
            if (t.charAt(i) == s.charAt(0)) return isSubsequence(s.substring(1), t.substring(i + 1));
        }
        return false;
	}
	
	//���Follow-up�����	
	public boolean[] isSubsequence(List<String> list, String t) {
		int[] indexs = new int[list.size()];  //��¼ÿһ���ַ������±�λ��
		int tIndex = 0;
		for(int i=0;i<t.length();i++){
			for(int j=0;j<indexs.length;j++){
				char c = list.get(j).charAt(indexs[j]);
				if(c==t.charAt(tIndex++)) indexs[j]++;
			}			
		}
		boolean[] b = new boolean[indexs.length];
		for(int i=0;i<indexs.length;i++) {
			b[i] = false;
			if(indexs[i]==list.get(i).length()) b[i] = true;
		}
		return b;
	}
	

}
 