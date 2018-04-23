package simple;

//鍒ゆ柇鏄惁鏄?3鐨勫箓
public class PowerofThree_326 {
	public boolean isPowerOfThree(int n) {
        //鎵惧嚭鏁存暟鑼冨洿鍐?3鐨勬渶澶у箓--1162261467锛屼富瑕佹?濇兂鏄?3鏄川鏁?
		//int max3power=(int)Math.pow(3, (int)Math.log(Integer.MAX_VALUE)/Math.log(3.0));
		if(n<=0) return false;
		if(1162261467%n==0) return true;
		return false;
		//浠ヤ笂绛変簬
		//return (n>0&&1162261467%n==0);
    }
	
	//璁ㄨ鍖烘柟娉曗憼锛氶噰鐢╨og鍑芥暟
	public boolean isPowerOfThree1(int n){
		if(n<=0) return false;
		double a=Math.log10(n)/Math.log10(3.0);
		//姝ゆ椂鍙渶瑕佸垽鏂璦鏄惁鏈変綑鏁板嵆鍙?,鍗砳f(a%1==0) return true;
		//鎴栬?卍ouble a=Math.log(n)/Math.log(3.0);//杩欓噷涔熷彲鑳芥湁绮惧害闂锛屾瘮濡俷=243
		//return Math.floor(a)==a;  //姝ゅ鐢变簬绮惧害闂鍙兘寰椾笉鍒版纭粨鏋?
		return Math.abs(Math.floor(a)-a)<=1e10;
	}
	
	public static void main(String[] args){
		double a=Math.log10(243)/Math.log10(3.0);
		System.out.println(-2%2);
		System.out.println(Math.abs(Math.floor(a)-a));
		new PowerofThree_326().isPowerOfThree(3);
	}
}
