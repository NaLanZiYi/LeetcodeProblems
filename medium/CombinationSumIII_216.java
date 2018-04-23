package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumIII_216 {
	//讨论区-方法1
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
		helper(list,new ArrayList<Integer>(),k,1,n);
		return list;
    }

	private void helper(List<List<Integer>> list, ArrayList<Integer> com, int k, int start, int n) {
		if(com.size()>k) return;
		if(com.size()==k&&n==0){
			list.add(new ArrayList<>(com));
			return;
		}
		for(int i=start;i<=9&&i<=n;i++){
			com.add(i);
			helper(list,com,k,i+1,n-i);
			com.remove(com.size()-1);
		}
	}	
}
