package simple;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {
	public List<List<Integer>> generate(int numRows) {
        if(numRows<=0) return new ArrayList();
        List<Integer> list1=new ArrayList();
        List<List<Integer>> list2 = new ArrayList();
        list1.add(1);
        list2.add(list1);
        for(int i=1;i<numRows;i++){
        	list1=new ArrayList();
        	//list1.clear();  //Java鍊间紶閫掞紝濡傛灉浠呬粎鏀瑰彉list1锛屽垯鎵?鏈夌殑閮戒細鏀瑰彉
        	List<Integer> prelist = list2.get(i-1);
        	list1.add(1);
        	for(int j=0;j<prelist.size()-1;j++){
        		list1.add(prelist.get(j)+prelist.get(j+1));
        	}
        	list1.add(1);        	
        	list2.add(list1);
        }
        return list2;
    }
	
	//璁ㄨ鍖?-鏂规硶1锛氬彧浣跨敤涓?涓狝rrayList
	public List<List<Integer>> generate1(int numRows) {
		List<Integer> list1 = new ArrayList();
		List<List<Integer>> list2 = new ArrayList();
		for(int i=0;i<numRows;i++){
			list1.add(0, 1);   //姣忔閮藉厛鍦ㄥ紑澶存彃鍏?1锛屽悗闈㈢殑鍏冪礌灏辨槸涓婁竴灞傜殑鍏冪礌
			for(int j=1;j<list1.size()-1;j++){
				list1.set(j, list1.get(j)+list1.get(j+1));
			}
			list2.add(new ArrayList<Integer>(list1));//涓嶈兘浣跨敤list2.add(list1)锛屽紩鐢ㄧ被鍨嬪弬鏁颁細淇敼鍘熸潵鐨勫??
		}
		return list2;
	}
	
	public static void main(String[] args){
		PascalsTriangle_118 angle = new PascalsTriangle_118();
		List<List<Integer>> test = angle.generate(3);
		for(List<Integer> list : test){
			for(Integer i: list){
				System.out.print(i+",");
			}
			System.out.println();
		}
	}
}
