package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight_406 {
	//������-����1������ߴӸߵ������������ͬ��kֵ���������ڸı�����Ԫ��˳��ʱ������ǰ��Ķ��Ⱥ���ĸߣ�����Ӱ�쵽k��ֵ
	public int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0) return new int[][]{};
        //����ߴӸߵ������������ͬ�İ�kֵ����
        Arrays.sort(people, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				if(a[0]==b[0]) return a[1]-b[1];
				return b[0]-a[0];
			}        	
        });
        //����kֵ��Ԫ�ز��뵽��Ӧ��λ��
        List<int[]> list = new ArrayList<>();
        for(int[] temp : people){
        	list.add(temp[1],temp);
        }
        
        //return list.toArray(new int[people.length][2]);  //����ֻ����һ�仰
        int[][] ret = new int[people.length][2];
        for(int i=0;i<list.size();i++){
        	ret[i][0] = list.get(i)[0];
        	ret[i][1] = list.get(i)[1];
        }
        return ret;
    }
}
