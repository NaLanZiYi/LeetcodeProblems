package medium;

public class ReconstructOriginalDigitsFromEnglish_423 {
	//讨论区-方法1：根据每个数字的英文中的唯一字符判断个数
	//zero-z,two-w,four-u,six-x,eight-g,剩下的根据其他的字符减去唯一的数字个数即可
	public String originalDigits(String s) {
		int[] count = new int[10];
		//分别对应0,0+1+2+4,2,0+3+4,4,4+5,6,6+7,8,5+6+8+9
        char[] cs = {'z','o','w','r','u','f','x','s','g','i'};
        for(char c : s.toCharArray()){
        	for(int i=0;i<cs.length;i++){
        		if(c==cs[i]){
        			count[i]++;
        			break;
        		}
        	}
        }
        count[5] -= count[4];  //5
        count[7] -= count[6];  //7
        count[3] = count[3]-count[0]-count[4];  //3
        count[1] = count[1]-count[0]-count[2]-count[4];  //1
        count[9] = count[9]-count[5]-count[6]-count[8];  //9
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<count.length;i++){
        	for(int j=0;j<count[i];j++){
        		builder.append(i);
        	}
        }
        return builder.toString();
    }
}
