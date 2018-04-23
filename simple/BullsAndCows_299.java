package simple;

public class BullsAndCows_299 {
	
	//璁ㄨ鍖?-1锛氱浉鍚屼綅缃笂鐩稿悓鏁板瓧鍒檅ulls++锛岀敤涓?涓暟缁勮褰昪ows鐨勬儏鍐?
	//鏁板瓧鍑虹幇鍦╯ecret涓垯澧炲姞涓嬫爣瀵瑰簲鐨勬暟缁勫?硷紝鍑虹幇鍦╣uess涓垯鍑忓皯璇ュ??
	public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] count = new int[10];
        for(int i=0;i<secret.length();i++){
        	char sc = secret.charAt(i);
        	char gc = guess.charAt(i);
        	if(sc==gc) bulls++;
        	else{
        		//濡傛灉count[sc-'0']璇存槑guess鍑忓皯浜嗚鍊硷紝璇存槑guess涓嚭鐜拌繃
        		if(count[sc-'0']++<0) cows++;
        		if(count[gc-'0']-->0) cows++;
        	}
        }
        return bulls+"A"+cows+"B";
    }
	
	//璁ㄨ鍖?-2锛歴ame digit same position鍒檅ulls++
	//鍚﹀垯锛氬垎鍒敤涓や釜鏁扮粍璁板綍涓嶅悓浣嶇疆鐨勬暟瀛楀嚭鐜扮殑娆℃暟
	public String getHint1(String secret, String guess) {
		int bulls = 0 , cows = 0;
		int[] s = new int[10];
		int[] g = new int[10];
		for(int i = 0;i<secret.length();i++){
			char sc = secret.charAt(i);
			char gc = guess.charAt(i);
			if(sc==gc) bulls++;
			else{
				s[sc-'0']++;
				g[gc-'0']++;
			}
		}
		//杩斿洖鏁扮粍鍏冪礌杈冨皬鐨勫拰
		for(int j=0;j<s.length;j++){
			cows+=Math.min(s[j], g[j]);
		}
		return bulls+"A"+cows+"B";
	}
}
