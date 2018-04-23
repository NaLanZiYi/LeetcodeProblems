package simple;

public class FirstBadVersion_278 {
	//二分法，但是会超时
	public int firstBadVersion(int n) {
        int i = 1, j = n, m = 0;
        while(i<j){
//            if(isBadVersion(m)&&!isBadVersion(m-1)) return m;
//            if(i+1==j) return j; 
        	//m = (i+j)/2;      //注意：这种方法会溢出
        	m = i+(j-i)/2;
            if(isBadVersion(m)){
                j = m;
            }else{
                i = m+1;
            }           
        }
        return i;
    }
	
	//与上面方法相同，只是略有改动，这次返回j
	public int firstBadVersion1(int n) {
        int i = 1, j = n, m = 0;
        while(i<j){
        	m = i+(j-i)/2;
            if(isBadVersion(m)){
                j = m;
            }else{
                i = m;   //这里i永远指向好数，因此不能返回i
            }           
        }
        return j;
    }
	
	//方法2：二分法的递归实现
	public int firstBadVersion2(int n) {
		return helper(1,n);
	}

	private int helper(int start, int end) {
		if(start>=end) return start;
		int mid = start+(end-start)/2;
		if(isBadVersion(mid)) return helper(start,mid);
		else return helper(mid+1,end);
	}

	private boolean isBadVersion(int m) {
		return false;
	}
}
