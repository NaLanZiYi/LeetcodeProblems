package simple;

public class IntegerAdd_371 {
	//寰幆瀹炵幇
	 public int getSum(int a, int b) {
		int carry=0;
		System.out.print(a+" + "+b+" = ");
		//鍔犳硶杩愮畻鍙互鎷嗗垎鎴愨?滃拰鈥濊繍绠楀拰鈥滀笌鈥濊繍绠楋紝鍏堟眰鍜岋紝鍐嶅姞涓婅繘浣?
		//浣嗙敱浜庡姞涓婅繘浣嶇殑杩囩▼涓篃浼氫骇鐢熻繘浣嶏紝鎵?浠ュ簲璇ュ惊鐜殑姹傚嚭姣忔鈥滃拰鈥濆姞涓婅繘浣嶇殑鏂扮殑杩涗綅
	    while(b!=0){
	    	carry=a&b;  //涓庤繍绠楁眰鍑鸿繘浣?
	    	a=a^b;      //浜︽垨杩愮畻姹傚嚭鍜?
	    	b=carry<<1; //杩涗綅瑕佸姞鍦ㄤ笂涓?浣嶄篃灏辨槸楂樹綅涓婏紝鎵?浠ラ渶瑕佸乏绉讳竴浣?
	    }	    
	    return a;
	 }
	 
	 //杩唬瀹炵幇
	 public int getSum1(int a,int b){
		 return (b==0)?a:getSum1(a^b, (a&b)<<1);
	 }
	 
	 public static void main(String[] args){
		 IntegerAdd_371 test=new IntegerAdd_371();
		 System.out.println(test.getSum(3, 6));
		 System.out.println("3:"+(~3+1));
	 }
}
