package simple;
import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber_414 {
	public int thirdMax(int[] nums) {
		//最大值，中间值，第三大的值，使用count来判断是否有第三大的值，还可以声明三个变量位long类型的最小值，最后判断m3是否还是最小值
        int m1, m2, m3, count =0;
        m1 = m2 = m3 = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        //去除重复的数据
        for(int n : nums){
        	set.add(n);
        }
        for(int n : set){
        	if(n>m1){
        		m3 = m2;
        		m2 = m1;
        		m1 = n;
        		++count;
        	}else if(n>m2){
        		m3 = m2;
        		m2 = n;
        		++count;
        	}else if(n>=m3){
        		m3 = n;
        		++count;
        	}
        }
        //如果发现第三大的值就返回m3，否则返回最大的值
        if(count>=3) return m3;
        else return m1;
    }
}
