package medium;

public class BestTimeToBuyAndSellStockII_122 {
	//��Ŀ��û����ȷ�ܷ���ͬһ���������Ʊ���ֹ����Ʊ
	
	//������-����1���������ͬʱ��������ôֱ���ڹɼ۱��ʱ�������ɣ�����Ʊ���ۻ�
	public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=0;i<prices.length-1;i++){
        	if(prices[i+1]>prices[i]) profit += prices[i+1]-prices[i];
        }
        return profit;
    }
	
	//������-����2���������ͬʱ����
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
