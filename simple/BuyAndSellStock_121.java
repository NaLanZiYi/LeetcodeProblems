package simple;
//Best Time to Buy and Sell Stock
public class BuyAndSellStock_121 {
	
	public int maxProfit(int[] prices) {
		if(prices==null||prices.length<2) return 0;
		int profits=0;
		int minPri=prices[0];
		for(int i=1;i<prices.length;i++){
			minPri=Math.min(minPri, prices[i]);
			profits=Math.max(profits, prices[i]-minPri);
		}
		return profits;
	}
	
	//讨论区-2：对上述方法的改进，不必每次都同时及时收益和最小单价
	public int maxProfit1(int[] prices) {
      if(prices==null||prices.length<2) return 0;
      int bought=prices[0];
      int profits=0;
      for(int i=1;i<prices.length;i++){
      	if(prices[i]>bought){
      		if(profits<prices[i]-bought){
      			profits=prices[i]-bought;
      		}
      	}else{
      		bought=prices[i];
      	}
      }
      return profits;
  }
	
	//讨论区-3：Kadane's Algorithm
	public int maxProfit2(int[] prices) {
      int maxCur = 0, maxSoFar = 0;
      for(int i = 1; i < prices.length; i++) {
          maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
          maxSoFar = Math.max(maxCur, maxSoFar);
      }
      return maxSoFar;
  }
}
