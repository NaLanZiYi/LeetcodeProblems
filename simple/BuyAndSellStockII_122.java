package simple;

public class BuyAndSellStockII_122 {
	
	public int maxProfit(int[] prices) {
        int min = 0, i = 0, profit = 0;
        while(i<prices.length){
        	while(i < prices.length-1 && prices[i+1] <= prices[i]) i++;
        	//只有一个元素时，i一直不变化会造成死循环，用i++解决，但是会造成数组元素越界问题
        	//当然，这里数组越界则说明，当前到数组尾部都是递减，没有利润
        	min = prices[i++]; 
        	while(i<prices.length-1 && prices[i+1] >= prices[i]) i++;
        	profit += i<prices.length ? prices[i] - min : 0;
        }
        return profit;
    }
}
