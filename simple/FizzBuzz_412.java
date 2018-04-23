package simple;
import java.util.ArrayList;
import java.util.List;

//鐢ㄥ瓧绗︿覆鐨勫舰寮忚〃绀?1-n鐨勬暟瀛楋紝瀵逛簬3鐨勫?嶆暟杈撳嚭鈥淔izz鈥?,5鐨勫?嶆暟杈撳嚭鈥淏uzz鈥濓紝3鍜?5鍏卞悓鐨勫?嶆暟杈撳嚭鈥淔izzBuzz鈥?
public class FizzBuzz_412 {
	public List<String> fizzBuzz(int n) {
        if(n<=0) return null;
        List<String> numlist = new ArrayList();
        for(int i=1;i<=n;i++){
        	if(i%15==0) {
        		numlist.add("FizzBuzz");
        	}else if(i%3==0){
        		numlist.add("Fizz");
        	}else if(i%5==0){
        		numlist.add("Buzz");
        	}else{
        		numlist.add(i+"");
        	}
        }
        return numlist;
    }
}
