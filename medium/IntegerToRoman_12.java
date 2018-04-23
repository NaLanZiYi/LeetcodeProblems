package medium;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman_12 {
	//讨论区-方法1
	public String intToRoman(int num) {
        String[] M = {"","M","MM","MMM"};
        String[] C = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] X = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] I = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        return M[num/1000]+C[(num%1000)/100]+X[(num%100)/10]+I[num%10];
    }
	
	//讨论区-方法2
	public String intToRoman1(int num) {
		if(num<1||num>3999) return "";
		int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		StringBuilder builder = new StringBuilder();
		for(int i=0;num>0&&i<nums.length;i++){
			while(num>=nums[i]){
				num -= nums[i];
				builder.append(romans[i]);
			}
		}
		return builder.toString();
	}
	
	//讨论区-方法3：递归
	private Map<Integer,String> map = new HashMap<>();
	{
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
	}
	public String intToRoman2(int num) {
		for(Integer i : map.keySet()){
			if(num>=i) return map.get(i)+intToRoman2(num-i);
		}
		return "";
	}
	
	//讨论区-方法4：
	public String intToRoma3(int num) {
        if (num>=1000) {
            return ("M"+intToRoman(num-1000));
        } else if (num>=900) {
            return ("CM"+intToRoman(num-900));
        } else if (num>=500) {
            return ("D"+intToRoman(num-500));
        } else if (num>=400) {
            return ("CD"+intToRoman(num-400));
        } else if (num>=100) {
            return ("C"+intToRoman(num-100));
        } else if (num>=90) {
            return ("XC"+intToRoman(num-90));
        } else if (num>=50) {
            return ("L"+intToRoman(num-50));
        } else if (num>=40) {
            return ("XL"+intToRoman(num-40));
        } else if (num>=10) {
            return ("X"+intToRoman(num-10));
        } else if (num>=9) {
            return ("IX"+intToRoman(num-9));
        } else if (num>=5) {
            return ("V"+intToRoman(num-5));
        } else if (num>=4) {
            return ("IV"+intToRoman(num-4));
        } else if (num>=1) {
            return ("I"+intToRoman(num-1));
        }
        return ("");
    }
}
