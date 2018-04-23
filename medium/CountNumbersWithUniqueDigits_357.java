package medium;

public class CountNumbersWithUniqueDigits_357 {
	//讨论去-方法1：动态规划
	//f(0)=1,f(1)=10,f(2)=9*9,f(3)=9*9*8,f(4)=9*9*8*7,....,f(10)=9*9*8*...*1,f(n>11)=0
	public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int result = 10;
        int availableNum = 9, uniqueNum = 9;
        while(n-->1&&availableNum>0){
        	uniqueNum *= availableNum;
        	result += uniqueNum;
        	availableNum--;
        }
        return result;
    }
	
	//讨论区-方法2
	public int countNumbersWithUniqueDigits1(int n) {
		if(n==0) return 1;
        int result = 10, unique = 9;
        for(int i=2;i<=10&&i<=n;i++){
        	unique *= 9-i+2;
        	result += unique;
        }
        return result;
	}
}
