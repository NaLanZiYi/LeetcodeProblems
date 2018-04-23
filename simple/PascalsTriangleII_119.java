package simple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//杩斿洖甯曟柉鍗′笁瑙掔k琛岀殑鏁?
public class PascalsTriangleII_119 {
	//璁ㄨ鍖?-1锛氭瘡娆″湪寮?澶存坊鍔犱竴涓?1锛屽啀璁＄畻姣忎釜浣嶇疆鐨勫??
	public List<Integer> getRow(int rowIndex){
        List<Integer> ret = new ArrayList();
        for(int i=0;i<=rowIndex;i++){
        	ret.add(0,1);
        	for(int j=1;j<ret.size()-1;j++){
        		ret.set(j, ret.get(j)+ret.get(j+1));
        	}
        }
        return ret;
    }
	
	//璁ㄨ鍖?-鏂规硶2锛氬熀浜庝互涓嬩簨瀹?
	//row k of Pascal's Triangle:	[C(k,0), C(k,1), ..., C(k, k-1), C(k, k)]
	//and	C[k,i] = C[k,i-1]*(k-i+1)/i
	public List<Integer> getRow1(int rowIndex) {
		Integer[] ret = new Integer[rowIndex+1];
		ret[0] = 1;
		for(int i=1;i<ret.length;i++){
			ret[i] = ret[i-1]*(rowIndex-i+1)/i;
		}
		return Arrays.asList(ret);
	}
	
	//璁ㄨ鍖?-鏂规硶3锛氭瘡娆″湪鍚庨潰娣诲姞1
	public List<Integer> getRow2(int rowIndex) {
		List<Integer> ret = new ArrayList();
		ret.add(1);
		for(int i=1;i<=rowIndex;i++){
			for(int j=i-1;j>=1;j--){
				ret.set(j, ret.get(j)+ret.get(j-1));
			}
			ret.add(1);
		}
		return ret;
	}
	
	//璁ㄨ鍖?-4:3鐨勬敼杩?
	public List<Integer> getRow3(int rowIndex) {
		Integer[] ret = new Integer[rowIndex+1];		
		ret[0]=1;
		for(int i =1;i<=rowIndex;i++){
			for(int j=i;j>=1;j--){
				ret[j]+=ret[j-1];
			}
		}
		return Arrays.asList(ret);
	}
	
	//璁ㄨ鍖?-鏂规硶5:4鐨勬?濊矾锛屼絾鏄～鍏?1
	public List<Integer> getRow4(int rowIndex) {
        Integer[] integers = new Integer[rowIndex + 1];
        Arrays.fill(integers, 1);
        for (int row = 0; row < rowIndex; row++) {
            for (int col = row; col > 0; col--) {
                integers[col] += integers[col - 1];
            }
        }
        //涓ょ寰幆褰㈠紡閮藉彲浠?
//        for (int row = 0; row <= rowIndex; row++) {
//            for (int col = row-1; col > 0; col--) {
//                integers[col] += integers[col - 1];
//            }
//        }
        return Arrays.asList(integers);
    }
	
	//璁ㄨ鍖?-鏂规硶3锛?
}
