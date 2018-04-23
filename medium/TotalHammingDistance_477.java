package medium;

public class TotalHammingDistance_477 {
	public int totalHammingDistance(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int totalBits = 0;
        for(int i=0;i<nums.length;i++){
        	for(int j=i;j<nums.length;j++){
        		totalBits += Integer.bitCount(nums[i]^nums[j]);
        	}
        }
        return totalBits;
    }
	
	//讨论区-方法1
	//计算n阁数字1-32位上的1的个数k，该位的hamming distance的贡献值为k*(n-k)
	public int totalHammingDistance1(int[] nums) {
		int totalBits = 0, n = nums.length;
		for(int i=0;i<32;i++){
			int bit = 0;
			for(int j=0;j<n;j++){
				bit += ((nums[j]>>j)&1);
			}
			totalBits += bit*(n-bit);
		}
		return totalBits;
	}
}
