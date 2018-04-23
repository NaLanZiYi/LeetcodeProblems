package simple;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_36 {
	//璁ㄨ鍖?-1锛氶噰鐢ㄤ竴瀹氱殑缂栫爜鍘嬬缉鏁扮嫭
	//渚嬪锛氱1琛岀殑4璁颁负0(4),绗?1鍒楃殑4璁颁负(4)0,宸︿笂瑙掔殑9瀹牸鐨?4璁颁负0(4)0
	 public boolean isValidSudoku(char[][] board) {
	      Set<String> set = new HashSet();
	      for(int i=0;i<9;i++){
	    	  for(int j=0;j<9;j++){
	    		  if(board[i][j]!='.'){
	    			 String str = "("+board[i][j] +")";
	    			 if(!set.add(i+str)||!set.add(str+j)||!set.add(i/3+str+j/3)){
	    				 return false;
	    			 }
	    		  }	    		  
	    	  }
	      }
	      return true;
	 }
	 
	 //璁ㄨ鍖?-2锛氬師鐞嗗悓涓?
	 public boolean isValidSudoku1(char[][] board) {
	    for(int i = 0; i<9; i++){
	        HashSet<Character> rows = new HashSet<Character>();
	        HashSet<Character> columns = new HashSet<Character>();
	        HashSet<Character> cube = new HashSet<Character>();
	        for (int j = 0; j < 9;j++){
	            if(board[i][j]!='.' && !rows.add(board[i][j]))
	                return false;
	            if(board[j][i]!='.' && !columns.add(board[j][i]))
	                return false;
	            //浠ヤ笅鍑犲彞鑷冲叧閲嶈锛岄?氳繃i鍜宩鏄犲皠鍒颁節瀹牸(鍘夊浜嗘垜鐨勫摜)锛屽唴灞傚惊鐜竴娆￠亶鍘嗗畬涓?涓節瀹牸锛屽灞傚惊鐜竴娆￠亶鍘嗕笅涓?涓節瀹牸
	            //椤哄簭涓?00,01,02,10,11,12,20,21,22
	            int RowIndex = 3*(i/3);
	            int ColIndex = 3*(i%3);
	            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
	                return false;
	        }
	    }
	    return true;
	}
	 
	 //璁ㄨ鍖?-3锛氬師鐞嗗悓1	 
	 public boolean isValidSudoku2(char[][] board) {
		 int[][] used1 = new int[9][9];  //妫?鏌ユ瘡涓?琛?
		 int[][] used2 = new int[9][9];  //妫?鏌ユ瘡涓?鍒?
		 int[][] used3 = new int[9][9];  //妫?鏌ユ瘡涓?涓節瀹牸锛屾牳蹇冨湪浜庯細灏嗗睘浜庡悓涓?涓節瀹牸鐨勪笢瑗挎槧灏勫埌鍚屼竴琛?
		 for(int i = 0; i < 9; ++ i)
            for(int j = 0; j < 9; ++ j)
                if(board[i][j] != '.')
                {
                	//k鐨勪綔鐢ㄥ氨鏄皢灞炰簬鍚屼竴涓節瀹牸鐨勬暟鎹槧灏勫埌used3鐨勫悓涓?琛?
                    int num = board[i][j] - '0' - 1, k = i / 3 * 3 + j / 3;
                    if(used1[i][num]!=0 || used2[j][num]!=0 || used3[k][num]!=0)
                        return false;
                    used1[i][num] = used2[j][num] = used3[k][num] = 1;
                }
        
        return true;
	 }
	 
	 //璁ㄨ鍖?-4锛?
	 public boolean isValidSudoku3(char[][] board) {
		    int [] vset = new int [9];
		    int [] hset = new int [9];
		    int [] bckt = new int [9];
		    int idx = 0;
		    //鍘熺悊锛氶噰鐢ㄤ綅涓庤繍绠楀垽鏂煇涓暟瀛楁槸鍚﹀凡缁忓嚭鐜帮紝濡傛灏嗘暟瀛楃殑鏄惁鍑虹幇杞寲涓哄畾涔変綅缃笂鏄惁鏄?1锛屽彧闇?3涓竴缁存暟缁勫嵆鍙?
		    for (int i = 0; i < 9; i++) {
		        for (int j = 0; j < 9; j++) {
		            if (board[i][j] != '.') {
		                idx = 1 << (board[i][j] - '0') ;
		                if ((hset[i] & idx) > 0 ||
		                    (vset[j] & idx) > 0 ||
		                    (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
		                //閲囩敤鎴栬繍绠楋紝鍙互灏嗕箣鍓嶅凡缁忓嚭鐜拌繃鐨勬暟瀛椾竴璧疯褰曚笅鏉?
		                hset[i] |= idx;
		                vset[j] |= idx;
		                bckt[(i / 3) * 3 + j / 3] |= idx;
		            }
		        }
		    }
		    return true;
		}
}
