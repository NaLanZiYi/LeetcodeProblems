package simple;
//涓嶈兘鎶㈠姭杩炵画鐨勬埧闂达紝姹傝兘鎶㈠埌鐨勬渶澶氱殑閽憋紝鍔ㄦ?佽鍒掔殑鎬濇兂
public class HouseRobber_198 {
	public int rob(int[] nums) {
        int ifRobPre = 0;  //鎶㈠姭褰撳墠鐨勬埧闂寸殑鎬绘敹鍏?
        int ifNotRobPre = 0;  //涓嶆姠鍔綋鍓嶆埧闂寸殑鎬绘敹鍏?
        int toRob = 0,notToRob = 0;
        for(int n : nums){
        	toRob = ifNotRobPre + n;  //鎶㈠姭褰撳墠鎴块棿锛屽垯涓嶅簲璇ユ姠鍔墠涓?涓埧闂达紝鍚屾椂鍔犱笂璇ユ埧闂?
        	notToRob = Math.max(ifRobPre, ifNotRobPre);  //涓嶆姠鍔綋鍓嶆埧闂达紝鏈?澶у?煎氨鏄墠闈㈢粨鏋滅殑鏈?澶у??
        	ifRobPre = toRob;
        	ifNotRobPre = notToRob;
        	
        	/******浠ヤ笅浠ｇ爜鍙互鍑忓皯涓?涓彉閲忕殑寮?閿?******/
//        	int temp = ifNotRobPre;
//        	ifNotRobPre = Math.max(ifNotRobPre, ifRobPre);
//        	ifRobPre = temp +n;
        }
        return Math.max(ifRobPre, ifNotRobPre); 
    }
	
	//璁ㄨ鍖?-鏂规硶2锛氫娇鐢ㄦ暟缁凮(n)鐨勭┖闂村鏉傚害
	/**
	 * 璇P formula鏂规硶鐨勬?濇兂锛氭瘡涓埧闂存湁鍋蜂笌涓嶅伔涓や釜閫夋嫨锛屽鏋滃伔褰撳墠鎴块棿k锛屾敹鍏ヤ究鏄綋鍓嶅?煎姞涓婂伔k-2鎴块棿鐨勬敹鍏?,濡傛灉涓嶅伔锛屾敹鍏ヤ究鏄痥-1鎴块棿鐨勬敹鍏?
	 * f(0)=nums[0]
	 * f(1)=Math.max(nums[0],nums[1])
	 * f(k)=Math.max(f(k-1),f(k-2)+nums[k]);
	 * @param nums
	 * @return
	 */
	public int rob1(int[] nums) {  
	    if(nums.length==0) return 0;
	    if(nums.length==1) return nums[0];
		int[] mark = new int[nums.length];
		mark[0] = nums[0];
		mark[1] = Math.max(nums[0], nums[1]);
		for(int i=2;i<nums.length;i++){
			mark[i] = Math.max(nums[i]+mark[i-2], mark[i-1]);
		}
		return mark[nums.length-1];
	}
	
	//璁ㄨ鍖猴細鏂规硶3锛氳繖閲岀殑a琛ㄧず鎴鍒板綋鍓嶅伓鏁版埧闂寸殑鏈?澶у?硷紝b琛ㄧず鎴鍒板綋鍓嶆妧鏈埧闂寸殑鏈?澶у??
	public int rob2(int nums[]) {
	    int a = 0;
	    int b = 0;	    
	    for (int i=0; i<nums.length; i++)
	    {
	        if (i%2==0)
	        {
	            a = Math.max(a+nums[i], b);  //涓婁竴涓伓鏁版埧闂寸殑鏀跺叆鍔犱笂褰撳墠鎴块棿涓庡墠涓?涓埧闂存?绘敹鍏ョ殑鏈?澶у??
	        }
	        else
	        {
	            b = Math.max(a, b+nums[i]);  //涓婁竴涓妧鏈埧闂村姞涓婂綋鍓嶅熀鏁版埧闂翠笌涓婁竴涓伓鏁版埧闂存敹鍏ョ殑鏈?澶у??
	        }
	    }	    
	    return Math.max(a, b);
	}
	
	//璁ㄨ鍖猴細鏂规硶4锛氫笉鑰冭檻鍩烘暟鍋舵暟
	public int rob3(int[] nums) { 
        int n = nums.length, pre = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            int temp = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
