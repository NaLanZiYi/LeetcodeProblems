package simple;
//鐖ゼ姊?
//You are climbing a stair case. It takes n steps to reach to the top.
//Each time you can either climb 1 or 2 steps. 
//In how many distinct ways can you climb to the top?
public class ClaimStairs_70 {
	 //閫掑綊-鏍稿績鎬濇兂锛氭瘡涓?灞傞兘鍙互閫夋嫨鐖竴灞傛垨涓ゅ眰锛岀埇涓?灞備箣鍚庡氨鍙樻垚n-1灞傛ゼ姊殑闂锛岀埇涓ゅ眰鍙樻垚n-2
	 public int climbStairs(int n) {
	        if(n<=2) return n;
	        return climbStairs(n-1)+climbStairs(n-2);
	 }
	 
	 //鏂愭尝閭ｅ鏁板垪锛氶棶棰樼殑姹傝В绛夊悓浜庢眰瑙ｆ枑娉㈤偅濂戞暟鍒?
	 public int climbStairs1(int n) {
		 if(n<=2) return n;
		 int first=1,second=2,third=0;
		 for(int i=3;i<=n;i++){
			 third=first+second;
			 first=second;
			 second=third;
		 }
		 return third;
	 }
	 
	 //璁ㄨ鍖?-浣跨敤鏁扮粍
	 public int climbStairs2(int n) {
		 if(n<=1) return n;
		 int[] nums=new int[n+1];
		 nums[0]=1;
		 nums[1]=1;
		 for(int i=2;i<=n;i++){
			 nums[i]=nums[i-1]+nums[i-2];
		 }
		 return nums[n];
	 }
	 
	 //璁ㄨ鍖猴細鍙娇鐢ㄩ暱搴︿负2鐨勬暟缁?
	 public int climbStairs3(int n) {
		 if(n<=1) return n;
		 int[] nums={1,1};
		 for(int i=2;i<=n;i++){
			 nums[i%2]=nums[0]+nums[1];
		 }
		 return nums[n%2];
	 }
	 
	 public static void main(String[] args){
		 ClaimStairs_70 claim=new ClaimStairs_70();
		 long pretime=System.currentTimeMillis();
		 System.out.println(claim.climbStairs(44));
		 long aftertime=System.currentTimeMillis();
		 System.out.println("Total time:"+(aftertime-pretime));
	 }
}
