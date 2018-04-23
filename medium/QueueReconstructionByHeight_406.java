package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight_406 {
	//讨论区-方法1：按身高从高到低排序，身高相同按k值排序，这样在改变数组元素顺序时，由于前面的都比后面的高，不会影响到k的值
	public int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0) return new int[][]{};
        //按身高从高到低排序，身高相同的按k值排序
        Arrays.sort(people, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				if(a[0]==b[0]) return a[1]-b[1];
				return b[0]-a[0];
			}        	
        });
        //按照k值将元素插入到对应的位置
        List<int[]> list = new ArrayList<>();
        for(int[] temp : people){
        	list.add(temp[1],temp);
        }
        
        //return list.toArray(new int[people.length][2]);  //可以只有这一句话
        int[][] ret = new int[people.length][2];
        for(int i=0;i<list.size();i++){
        	ret[i][0] = list.get(i)[0];
        	ret[i][1] = list.get(i)[1];
        }
        return ret;
    }
}
