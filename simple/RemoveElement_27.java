package simple;
//Given an array and a value, remove all instances of that value in place and return the new length.
public class RemoveElement_27 {
	
	public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0) return 0;
        int len = nums.length;
        int count = 0;
        //娉ㄦ剰i==j鐨勬儏鍐碉紝鎵?鏈夊皢璇ュ垽鏂Щ鍒板墠闈?
        for(int i=0,j=len-1;i<=j;){
        	while(i<=j&&nums[i]!=val) i++;
        	while(i<=j&&nums[j]==val){
        		j--;
        		count++;
        	}
        	if(i<=j){
        		int temp = nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        	}
        }
        return len-count;
    }
	
	//涓婅堪鐨勬敼杩涚増鏈?
	public int removeElement1(int[] nums, int val) {
        if(nums==null||nums.length==0) return 0;
        int len = nums.length;
        int count = 0;
        //娉ㄦ剰i==j鐨勬儏鍐碉紝鎵?鏈夊皢璇ュ垽鏂Щ鍒板墠闈?
        for(int i=0,j=len-1;i<=j;){
        	while(i<=j&&nums[i]!=val) i++;
        	while(i<=j&&nums[j]==val){
        		j--;
        		count++;
        	}
        	if(i<=j){
        		//int temp = nums[i];
        		nums[i] = nums[j];
        		//nums[j] = temp;
        		//褰撲袱涓?煎彂鐢熷懠鍞わ紝鍒欒瘉鏄庡張鎵惧埌浜嗚鍒犻櫎鐨勮妭鐐癸紝姝ゆ椂鐩存帴杩涜i++鍜宩--,閬垮厤鍦ㄤ笅涓?杞惊鐜腑鍐嶆閬嶅巻涓?閬?
        		count++;
        		i++;
        		j--;
        	}
        }
        return len-count;
    }
	
	//鐩存帴浠庡墠寰?鍚庨亶鍘?
	public int removeElement2(int[] nums, int val) {
		int m=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=val){
				nums[m++]=nums[i];
			}
		}
		return m;
	}
	
	//璁ㄨ鍖?-鏂规硶3:
	public int removeElement3(int[] nums, int val) {
		int len = nums.length;
		for(int i=0;i<len;i++){
			while(nums[i]==val&&i<len){
				nums[i] = nums[--len];
			}
		}
		return len;
	}
	
	//璁ㄨ鍖?-鏂规硶4
	public int removeElement4(int[] nums, int val) {
		int count = 0;
		int len = nums.length;
		for(int i=0;i<len;i++){
			//鍔犱笂while璇彞鍙互蹇?熸壘鍒扮涓?涓獀al鍏冪礌
//			while(count==0&&i<len&&nums[i]!=val) i++;
//			if(i==len) break;
			if(nums[i]==val) count++;
			else nums[i-count] = nums[i];
		}
		return len-count;
	}
		
	//璁ㄨ鍖?-鏂规硶5锛氭柟娉?3鐨勫彉褰?
	public int removeElemen5(int[] A, int elem) {
	    int l = A.length;
	    for (int i=0; i<l; i++) {
	        if (A[i] == elem) {
	            A[i--] = A[l-- -1];
	        }
	    }
	    return l;
	}
	
	//璁ㄨ鍖?-鏂规硶6锛氭柟:5鐨勫師鐗?
	public int removeElement6(int A[], int elem) {
	    int i = 0;
	    int n = A.length;
	    while (i < n) {
	        if (A[i] == elem) {
	            A[i] = A[n - 1];
	            n--;
	        }
	        else
	            i++;
	    }
	    return n;
	}
}
