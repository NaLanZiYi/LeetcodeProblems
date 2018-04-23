package medium;

public class BestTimeToBuyAndSellStockII_122 {
	//题目并没有明确能否在同一天既卖掉股票，又购买股票
	
	//讨论区-方法1：如果可以同时买卖，那么直接在股价变高时卖掉即可，将股票差累积
	public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=0;i<prices.length-1;i++){
        	if(prices[i+1]>prices[i]) profit += prices[i+1]-prices[i];
        }
        return profit;
    }
	
	//讨论区-方法2：如果不能同时买卖
	public int maxProfit1(int[] prices) {
		int profit = 0, i = 0;
		while(i<prices.length){
			while(i < prices.length-1 &&prices[i+1]<=prices[i]) i++;
			int minprice = prices[i++];
			while(i < prices.length-1 &&prices[i+1]>=prices[i]) i++;
			profit += i < prices.length ? prices[i++] - minprice : 0;
		}
		return profit;
	}
}
