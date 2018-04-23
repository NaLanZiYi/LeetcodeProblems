package simple;

import java.util.HashSet;
import java.util.Set;


public class HappyNumber_202 {
	 public boolean isHappy(int n) {
	    if(n<0) return false;
	    Set set=new HashSet<Integer>();
	    set.add(n);
	    int sum=0;
	    int count=0;
	    while(true){
	    	sum=0;
	    	while(n!=0){
		    	sum+=(n%10)*(n%10);
		    	n=n/10;
		    }
		    if(sum==1) {
		    	return true;
		    }
		    else{
		    	if(set.contains(sum)) return false;
		    	set.add(sum);
		    	n=sum;
		    }
		    System.out.println(++count+":"+n);
	    }
	    
	 }
	 
	 //鎵?鏈夌殑闈瀐appy鏁板瓧鏈?缁堥兘浼氶櫡鍏?4-16-37鐨勫惊鐜?
	 public boolean isHappy1(int n) {
		 if(n<0) return false;
		 int sum=0;
		 while(n!=1&&n!=4){
			 sum=0;
			 while(n!=0){
				 sum+=(n%10)*(n%10);
				 n=n/10;
			 }
			 n=sum;
		 }
		 return n==1;
	 }
	 
	 //璁ㄨ鍖猴細Floyd Cycle detection algorithm
	 //鍘熺悊锛氬鏋滄暟鎹摼璺腑鏈夌幆锛岄偅涔堝揩鎸囬拡涓?瀹氫細杩戒笂鎱㈡寚閽堬紝涓斾袱鑰呯浉宸殑璺濈鏄幆闀跨殑鏁存暟鍊?
		 int digitSquareSum(int n) {
			    int sum = 0, tmp;
			    while (n!=0) {
			        tmp = n % 10;
			        sum += tmp * tmp;
			        n /= 10;
			    }
			    return sum;
			}

			boolean isHappy2(int n) {
			    int slow, fast;
			    slow = fast = n;
			    do {
			        slow = digitSquareSum(slow);
			        fast = digitSquareSum(fast);
			        fast = digitSquareSum(fast);
			    } while(slow != fast);
			    if (slow == 1) return true;
			    else return false;
			}
	 
	 public static void main(String[] args){
		 new HappyNumber_202().isHappy(2);
	 }
}
