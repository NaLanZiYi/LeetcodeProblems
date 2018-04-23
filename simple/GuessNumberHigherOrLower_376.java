package simple;

public class GuessNumberHigherOrLower_376 {
	private int realnum;
	
	//浜屽垎鏌ユ壘
	public int guessNumber(int n) {
		//涓嶈浣跨敤(min+max)/2閬垮厤鏁存暟婧㈠嚭鑰屼骇鐢熸棤闄愬惊鐜?
		int min = 1, max = n, m=(max-min)/2+min;
		int temp = 0;
        while((temp=guess(m))!=0){
        	if(temp>0){
        		min = m+1;
        	}
        	else{
        		max = m-1;        		
        	}
        	m=(max-min)/2+min;
        }
        return m;
    }
	
	public void setRealnum(int num){
		this.realnum = num;
	}
	
	int guess(int num){
		if(num>realnum){
			return -1;
		}else if(num<realnum){
			return 1;
		}else return 0;
	}
	
	public static void main(String[] args){
		GuessNumberHigherOrLower_376 test = new GuessNumberHigherOrLower_376();
		test.setRealnum(10);
		System.out.println(test.guessNumber(19));
	}
}
